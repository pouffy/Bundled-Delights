package com.pouffy.bundledelight.util.data;

import com.pouffy.bundledelight.content.tag.BDTags;
import com.pouffy.bundledelight.init.BDBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import vectorwing.farmersdelight.common.tag.ModTags;

import javax.annotation.Nullable;

public class BlockTags extends BlockTagsProvider {
    public BlockTags(DataGenerator generatorIn, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(generatorIn, modId, existingFileHelper);
    }

    protected void addTags() {
        this.registerModTags();
        this.registerMinecraftTags();
        this.registerForgeTags();
        this.registerBlockMineables();
    }

    protected void registerBlockMineables() {
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_AXE).add(
        BDBlocks.VANILLA_POWDER_BASKET.get(),
        BDBlocks.MINT_POWDER_BASKET.get(),
        BDBlocks.ADZUKI_POWDER_BASKET.get(),
        BDBlocks.MINT_CRATE.get(),
        BDBlocks.ADZUKI_CRATE.get(),
        BDBlocks.VANILLA_CRATE.get(),
        BDBlocks.BLACK_TEA_CRATE.get(),
        BDBlocks.GREEN_TEA_CRATE.get(),
        BDBlocks.YELLOW_TEA_CRATE.get(),
        BDBlocks.BLACK_TEA_POWDER_BASKET.get(),
        BDBlocks.GREEN_TEA_POWDER_BASKET.get(),
        BDBlocks.YELLOW_TEA_POWDER_BASKET.get(),
        BDBlocks.COFFEE_CRATE.get(),
        BDBlocks.COFFEE_POWDER_BASKET.get()
        );
        tag(ModTags.MINEABLE_WITH_KNIFE).add(
                BDBlocks.CARROT_CAKE.get()
        );
    }
    protected void registerMinecraftTags() {

    }

    protected void registerForgeTags() {

    }
    protected void registerModTags() {
        tag(BDTags.DROPS_CAKE_SLICE).add(
                BDBlocks.CARROT_CAKE.get()
        );
        tag(BDTags.DROPS_CARROT_CAKE_SLICE).add(
                BDBlocks.CARROT_CAKE.get()
        );
    }



    }
