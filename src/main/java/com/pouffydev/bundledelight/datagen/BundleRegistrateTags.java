package com.pouffydev.bundledelight.datagen;

import com.pouffydev.bundledelight.BundledDelight;
import com.tterrag.registrate.providers.ProviderType;
import com.tterrag.registrate.providers.RegistrateTagsProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class BundleRegistrateTags {
    public static void addGenerators() {
        BundledDelight.registrate.addDataGenerator(ProviderType.BLOCK_TAGS, BundleRegistrateTags::genBlockTags);
        BundledDelight.registrate.addDataGenerator(ProviderType.ITEM_TAGS, BundleRegistrateTags::genItemTags);
    }
    
    private static void genBlockTags(RegistrateTagsProvider<Block> prov) {
    
    }
    
    private static void genItemTags(RegistrateTagsProvider<Item> prov) {
    
    }
}
