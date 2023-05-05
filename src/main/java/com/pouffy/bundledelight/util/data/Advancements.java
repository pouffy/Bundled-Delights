package com.pouffy.bundledelight.util.data;

import com.google.common.collect.Sets;
import com.google.gson.GsonBuilder;
import com.pouffy.bundledelight.compats.brewinandchewin.BrewinMDItems;
import com.pouffy.bundledelight.compats.farmersrespite.RespiteMDItems;
import com.pouffy.bundledelight.content.tag.ModTags;
import com.pouffy.bundledelight.init.BDItems;
import com.pouffy.bundledelight.util.TextUtils;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.HashCache;
import net.minecraft.data.advancements.AdvancementProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.ParametersAreNonnullByDefault;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Set;
import java.util.function.Consumer;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class Advancements extends AdvancementProvider {
    private final Path PATH;
    public static final Logger LOGGER = LogManager.getLogger();

    public Advancements(DataGenerator generatorIn) {
        super(generatorIn);
        this.PATH = generatorIn.getOutputFolder();
    }

    public void run(HashCache cache) {
        Set<ResourceLocation> set = Sets.newHashSet();
        Consumer<Advancement> consumer = (advancement) -> {
            if (!set.add(advancement.getId())) {
                throw new IllegalStateException("Duplicate advancement " + advancement.getId());
            } else {
                Path path1 = getPath(this.PATH, advancement);

                try {
                    DataProvider.save((new GsonBuilder()).setPrettyPrinting().create(), cache, advancement.deconstruct().serializeToJson(), path1);
                } catch (IOException var6) {
                    LOGGER.error("Couldn't save advancement {}", path1, var6);
                }

            }
        };
        (new BundleDelightAdvancements()).accept(consumer);
    }

    private static Path getPath(Path pathIn, Advancement advancementIn) {
        String var10001 = advancementIn.getId().getNamespace();
        return pathIn.resolve("data/" + var10001 + "/advancements/" + advancementIn.getId().getPath() + ".json");
    }

    public static class BundleDelightAdvancements implements Consumer<Consumer<Advancement>> {
        public BundleDelightAdvancements() {
        }
        public void accept(Consumer<Advancement> consumer) {
            Advancement bundleDelight = Advancement.Builder.advancement().display((ItemLike) BDItems.BORSCHT.get(), TextUtils.getTranslation("advancement.root", new Object[0]), TextUtils.getTranslation("advancement.root.desc", new Object[0]), new ResourceLocation("minecraft:textures/block/spruce_log.png"), FrameType.TASK, false, false, false).addCriterion("seeds", InventoryChangeTrigger.TriggerInstance.hasItems(new ItemLike[0])).save(consumer, this.getNameId("main/root"));
            Advancement copperStein = getAdvancement(bundleDelight, (ItemLike) BrewinMDItems.COPPER_TANKARD.get(), "copper_stein", FrameType.TASK, true, true, false).addCriterion("copper_stein", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike)BrewinMDItems.COPPER_TANKARD.get())).requirements(RequirementsStrategy.OR).save(consumer, this.getNameId("main/copper_stein"));
            Advancement copperMug = getAdvancement(bundleDelight, (ItemLike) RespiteMDItems.CUP.get(), "copper_mug", FrameType.TASK, true, true, false).addCriterion("copper_mug", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike) RespiteMDItems.CUP.get())).requirements(RequirementsStrategy.OR).save(consumer, this.getNameId("main/copper_mug"));
            Advancement copperTea = getAdvancement(copperMug, (ItemLike) RespiteMDItems.GREEN_TEA_CUP.get(), "copper_tea", FrameType.TASK, true, true, false).addCriterion("green_tea", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike) RespiteMDItems.GREEN_TEA_CUP.get())).addCriterion("yellow_tea", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike) RespiteMDItems.YELLOW_TEA_CUP.get())).addCriterion("black_tea", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike) RespiteMDItems.BLACK_TEA_CUP.get())).requirements(RequirementsStrategy.OR).save(consumer, this.getNameId("main/copper_tea"));
        }

        protected static Advancement.Builder getAdvancement(Advancement parent, ItemLike display, String name, FrameType frame, boolean showToast, boolean announceToChat, boolean hidden) {
            return Advancement.Builder.advancement().parent(parent).display(display, TextUtils.getTranslation("advancement." + name, new Object[0]), TextUtils.getTranslation("advancement." + name + ".desc", new Object[0]), (ResourceLocation)null, frame, showToast, announceToChat, hidden);
        }

        private String getNameId(String id) {
            return "bundledelight:" + id;
        }
    }
}
