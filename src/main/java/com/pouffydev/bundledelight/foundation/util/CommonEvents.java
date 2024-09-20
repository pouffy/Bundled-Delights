package com.pouffydev.bundledelight.foundation.util;

import com.pouffydev.bundledelight.BundledDelights;
import com.pouffydev.bundledelight.compat.abnormals_delight.AbnormalsNeapolitanCompatItems;
import com.pouffydev.bundledelight.compat.farmersrespite.RespiteCompatItems;
import com.pouffydev.bundledelight.compat.neapolitan.NeapolitanCompatItems;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.forgespi.language.IModFileInfo;
import net.minecraftforge.forgespi.locating.IModFile;

@Mod.EventBusSubscriber
public class CommonEvents {
    public static void init(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            registerCompostables();
            //registerDispenserBehaviors();
            //registerAnimalFeeds();
            //registerLootItemFunctions();
            //WildCropGeneration.registerWildCropGeneration();
        });

        //ModAdvancements.register();
        //CraftingHelper.register(new VanillaCrateEnabledCondition.Serializer());
    }
    public static void registerCompostables() {
        // 10% chance
        ComposterBlock.COMPOSTABLES.put(RespiteCompatItems.POWDERED_BLACK_TEA_LEAVES.get(), 0.1F);

        // 20% chance
        ComposterBlock.COMPOSTABLES.put(RespiteCompatItems.POWDERED_YELLOW_TEA_LEAVES.get(), 0.2F);
        ComposterBlock.COMPOSTABLES.put(NeapolitanCompatItems.POWDERED_VANILLA_PODS.get(), 0.3F);

        // 30% chance
        ComposterBlock.COMPOSTABLES.put(RespiteCompatItems.POWDERED_GREEN_TEA_LEAVES.get(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(NeapolitanCompatItems.POWDERED_ADZUKI_BEANS.get(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(NeapolitanCompatItems.POWDERED_MINT_LEAVES.get(), 0.3F);

        // 85% chance
        ComposterBlock.COMPOSTABLES.put(AbnormalsNeapolitanCompatItems.WHITE_STRAWBERRY_CAKE_SLICE.get(), 0.85F);

        // 100% chance
        ComposterBlock.COMPOSTABLES.put(NeapolitanCompatItems.STRAWBERRY_CAKE.get(), 1.0F);
    }
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModBusEvents {

        @SubscribeEvent
        public static void addPackFinders(AddPackFindersEvent event) {
            if (event.getPackType() == PackType.CLIENT_RESOURCES) {
                IModFileInfo modFileInfo = ModList.get().getModFileById(BundledDelights.MODID);
                if (modFileInfo == null) {
                    BundledDelights.LOGGER.error("Could not find Bundled Delight mod file info; built-in resource packs will be missing!");
                    return;
                }
                IModFile modFile = modFileInfo.getFile();
                event.addRepositorySource((consumer, constructor) -> {
                    consumer.accept(Pack.create(BundledDelights.asResource("bundledelight_resprites").toString(), false, () -> new ModFilePackResources("Bundled Delight Resprites", modFile, "resourcepacks/bundledelight_resprites"), constructor, Pack.Position.TOP, PackSource.DEFAULT));
                });
            }
        }

    }
}
