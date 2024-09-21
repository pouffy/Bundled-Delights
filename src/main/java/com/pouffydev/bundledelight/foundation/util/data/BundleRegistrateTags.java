package com.pouffydev.bundledelight.foundation.util.data;

import com.pouffydev.bundledelight.BundledDelights;
import com.tterrag.registrate.providers.ProviderType;
import com.tterrag.registrate.providers.RegistrateTagsProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class BundleRegistrateTags {
    public static void addGenerators() {
        BundledDelights.registrate.addDataGenerator(ProviderType.BLOCK_TAGS, BundleRegistrateTags::genBlockTags);
        BundledDelights.registrate.addDataGenerator(ProviderType.ITEM_TAGS, BundleRegistrateTags::genItemTags);
    }
    
    private static void genBlockTags(RegistrateTagsProvider<Block> prov) {
    
    }
    
    private static void genItemTags(RegistrateTagsProvider<Item> prov) {
    
    }
}
