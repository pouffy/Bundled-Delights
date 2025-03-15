package com.pouffydev.bundledelight;

import com.pouffydev.bundledelight.foundation.BundledRegistrate;
import com.pouffydev.bundledelight.init.bundles.builtin.BuiltinItems;
import com.tterrag.registrate.util.entry.RegistryEntry;
import it.unimi.dsi.fastutil.objects.ReferenceArrayList;
import it.unimi.dsi.fastutil.objects.ReferenceLinkedOpenHashSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class BundleDelightCreativeTab {
    private static final DeferredRegister<CreativeModeTab> TAB_REGISTER =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BundledDelight.MODID);

    public static final RegistryObject<CreativeModeTab> MAIN_TAB = TAB_REGISTER.register("main",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.bundledelight.base"))
                    .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                    .icon(BuiltinItems.borscht::asStack)
                    .displayItems(new RegistrateDisplayItemsGenerator(BundleDelightCreativeTab.MAIN_TAB))
                    .build());

    public static void register(IEventBus modEventBus) {
        TAB_REGISTER.register(modEventBus);
    }

    public static class RegistrateDisplayItemsGenerator implements CreativeModeTab.DisplayItemsGenerator {



        private final RegistryObject<CreativeModeTab> tabFilter;
        public RegistrateDisplayItemsGenerator(RegistryObject<CreativeModeTab> tabFilter) {

            this.tabFilter = tabFilter;
        }

        private List<Item> collectBlocks() {
            List<Item> items = new ReferenceArrayList<>();
            for (RegistryEntry<Block> entry : BundledDelight.registrate().getAll(Registries.BLOCK)) {
                if (!BundledRegistrate.isInCreativeTab(entry, tabFilter))
                    continue;
                Item item = entry.get()
                        .asItem();
                if (item == Items.AIR)
                    continue;


                items.add(item);
            }
            items = new ReferenceArrayList<>(new ReferenceLinkedOpenHashSet<>(items));
            return items;
        }

        private List<Item> collectItems(RegistryObject<CreativeModeTab> tab, Predicate<Item> exclusionPredicate) {
            List<Item> items = new ReferenceArrayList<>();


            for (RegistryEntry<Item> entry : BundledDelight.registrate().getAll(Registries.ITEM)) {
                if (!BundledDelight.registrate().isInCreativeTab(entry, tab))
                    continue;
                Item item = entry.get();
                if (item instanceof BlockItem)
                    continue;
                if (!exclusionPredicate.test(item))
                    items.add(item);
            }
            return items;
        }
        List<Item> exclude = List.of(

        );
        private static void outputAll(CreativeModeTab.Output output, List<Item> items) {
            for (Item item : items) {
                output.accept(item);
            }
        }




        @Override
        public void accept(CreativeModeTab.ItemDisplayParameters params, CreativeModeTab.Output output) {
            List<Item> items = new LinkedList<>();
            items.addAll(collectBlocks());

            items.addAll(collectItems(tabFilter, (item) -> exclude.contains(item)));

            outputAll(output, items);
        }
    }
}
