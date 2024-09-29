package com.pouffydev.bundledelight.datagen;

import com.pouffydev.bundledelight.BundledDelight;
import com.pouffydev.bundledelight.foundation.util.Brews;
import com.pouffydev.bundledelight.foundation.util.Teas;
import com.pouffydev.bundledelight.init.bundles.brewinandchewin.BrewinItems;
import com.pouffydev.bundledelight.init.bundles.builtin.BuiltinBlocks;
import com.pouffydev.bundledelight.init.bundles.builtin.BuiltinItems;
import com.pouffydev.bundledelight.init.bundles.farmersrespite.RespiteItems;
import com.pouffydev.bundledelight.init.bundles.neapolitan.NeapolitanItems;
import com.tterrag.registrate.providers.ProviderType;
import com.tterrag.registrate.providers.RegistrateTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import vectorwing.farmersdelight.common.tag.ModTags;

public class BundleRegistrateTags {
    public static void addGenerators() {
        BundledDelight.registrate.addDataGenerator(ProviderType.BLOCK_TAGS, BundleRegistrateTags::genBlockTags);
        BundledDelight.registrate.addDataGenerator(ProviderType.ITEM_TAGS, BundleRegistrateTags::genItemTags);
    }
    
    private static void genBlockTags(RegistrateTagsProvider<Block> prov) {
        prov.tag(BlockTags.MINEABLE_WITH_AXE)
                .addOptional(new ResourceLocation("bundledelight", "mint_leaf_sack"))
                .addOptional(new ResourceLocation("bundledelight", "adzuki_bean_sack"))
                .addOptional(new ResourceLocation("bundledelight", "roasted_adzuki_bean_sack"))
                .addOptional(new ResourceLocation("bundledelight", "powdered_adzuki_beans_sack"))
                .addOptional(new ResourceLocation("bundledelight", "powdered_mint_leaves_sack"))
                .addOptional(new ResourceLocation("bundledelight", "powdered_vanilla_sack"))
                .addOptional(new ResourceLocation("bundledelight", "powdered_green_tea_leaves_sack"))
                .addOptional(new ResourceLocation("bundledelight", "powdered_yellow_tea_leaves_sack"))
                .addOptional(new ResourceLocation("bundledelight", "powdered_black_tea_leaves_sack"))
                .addOptional(new ResourceLocation("bundledelight", "powdered_coffee_beans_sack"));
        prov.tag(ModTags.MINEABLE_WITH_KNIFE)
                .add(BuiltinBlocks.carrotCake.get())
                .addOptional(new ResourceLocation("bundledelight", "white_strawberry_cake"));
        prov.tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .addOptional(new ResourceLocation("bundledelight", "white_strawberry_ice_cream_block"))
                .addOptional(new ResourceLocation("bundledelight", "sweet_berry_ice_cream_block"));
        prov.tag(BlockTags.CANDLE_CAKES)
                .add(BuiltinBlocks.carrotCandleCake.get())
                .add(BuiltinBlocks.whiteCarrotCandleCake.get())
                .add(BuiltinBlocks.orangeCarrotCandleCake.get())
                .add(BuiltinBlocks.magentaCarrotCandleCake.get())
                .add(BuiltinBlocks.lightBlueCarrotCandleCake.get())
                .add(BuiltinBlocks.yellowCarrotCandleCake.get())
                .add(BuiltinBlocks.limeCarrotCandleCake.get())
                .add(BuiltinBlocks.pinkCarrotCandleCake.get())
                .add(BuiltinBlocks.grayCarrotCandleCake.get())
                .add(BuiltinBlocks.lightGrayCarrotCandleCake.get())
                .add(BuiltinBlocks.cyanCarrotCandleCake.get())
                .add(BuiltinBlocks.purpleCarrotCandleCake.get())
                .add(BuiltinBlocks.blueCarrotCandleCake.get())
                .add(BuiltinBlocks.brownCarrotCandleCake.get())
                .add(BuiltinBlocks.greenCarrotCandleCake.get())
                .add(BuiltinBlocks.redCarrotCandleCake.get())
                .add(BuiltinBlocks.blackCarrotCandleCake.get())
                .addOptional(new ResourceLocation("bundledelight", "white_strawberry_candle_cake"))
                .addOptional(new ResourceLocation("bundledelight", "white_white_strawberry_candle_cake"))
                .addOptional(new ResourceLocation("bundledelight", "orange_white_strawberry_candle_cake"))
                .addOptional(new ResourceLocation("bundledelight", "magenta_white_strawberry_candle_cake"))
                .addOptional(new ResourceLocation("bundledelight", "light_blue_white_strawberry_candle_cake"))
                .addOptional(new ResourceLocation("bundledelight", "yellow_white_strawberry_candle_cake"))
                .addOptional(new ResourceLocation("bundledelight", "lime_white_strawberry_candle_cake"))
                .addOptional(new ResourceLocation("bundledelight", "pink_white_strawberry_candle_cake"))
                .addOptional(new ResourceLocation("bundledelight", "gray_white_strawberry_candle_cake"))
                .addOptional(new ResourceLocation("bundledelight", "light_gray_white_strawberry_candle_cake"))
                .addOptional(new ResourceLocation("bundledelight", "cyan_white_strawberry_candle_cake"))
                .addOptional(new ResourceLocation("bundledelight", "purple_white_strawberry_candle_cake"))
                .addOptional(new ResourceLocation("bundledelight", "blue_white_strawberry_candle_cake"))
                .addOptional(new ResourceLocation("bundledelight", "brown_white_strawberry_candle_cake"))
                .addOptional(new ResourceLocation("bundledelight", "green_white_strawberry_candle_cake"))
                .addOptional(new ResourceLocation("bundledelight", "red_white_strawberry_candle_cake"))
                .addOptional(new ResourceLocation("bundledelight", "black_white_strawberry_candle_cake"));
        prov.tag(BundleTags.DROPS_CAKE_SLICE)
                .add(BuiltinBlocks.carrotCake.get())
                .addOptional(new ResourceLocation("bundledelight", "white_strawberry_cake"));
        prov.tag(BundleTags.DROPS_CARROT_CAKE_SLICE).add(
                BuiltinBlocks.carrotCake.get()
        );
        prov.tag(BundleTags.DROPS_WHITE_STRAWBERRY_CAKE_SLICE).addOptional(
                new ResourceLocation("bundledelight", "white_strawberry_cake")
        );
    }
    
    private static void genItemTags(RegistrateTagsProvider<Item> prov) {
        ResourceLocation teaSeeds = new ResourceLocation("farmersrespite", "tea_seeds");
        ResourceLocation coffeeSeeds = new ResourceLocation("farmersrespite", "coffee_beans");
        prov.tag(BundleTags.SEEDS).addOptional(teaSeeds).addOptional(coffeeSeeds);
        prov.tag(BundleTags.SEEDS_TEA).addOptional(teaSeeds);
        prov.tag(BundleTags.SEEDS_COFFEE).addOptional(coffeeSeeds);

        for (Brews brew : Brews.values()) {
            prov.tag(brew.getTag()).addOptional(brew.tankardId()).addOptional(brew.swigId()).addOptional(brew.glassId());
            prov.tag(BundleTags.BELT_UPRIGHT).addOptionalTag(brew.getTagLoc());
        }
        for (Teas tea : Teas.values()) {
            prov.tag(tea.getTag()).addOptional(tea.getTeaLoc()).addOptional(tea.getTeaCupLoc());
            prov.tag(BundleTags.BELT_UPRIGHT).addOptionalTag(tea.getTagLoc());
        }

        prov.tag(BundleTags.BEESECHURGER).add(BrewinItems.cheeseburger.get(), BrewinItems.scarletCheeseburger.get());
        prov.tag(BundleTags.GREEN_TEA_POWDER).add(RespiteItems.powderedGreenTeaLeaves.get());
        prov.tag(BundleTags.YELLOW_TEA_POWDER).add(RespiteItems.powderedYellowTeaLeaves.get());
        prov.tag(BundleTags.BLACK_TEA_POWDER).add(RespiteItems.powderedBlackTeaLeaves.get());
        prov.tag(BundleTags.COFFEE_POWDER).add(RespiteItems.powderedCoffeeBeans.get());
        prov.tag(BundleTags.ADZUKI_POWDER).add(NeapolitanItems.powderedAdzukiBeans.get());
        prov.tag(BundleTags.VANILLA_POWDER).add(NeapolitanItems.powderedVanilla.get());
        prov.tag(BundleTags.MINT_POWDER).add(NeapolitanItems.powderedMintLeaves.get());
        prov.tag(BundleTags.TEA_POWDER).add(RespiteItems.powderedGreenTeaLeaves.get(), RespiteItems.powderedYellowTeaLeaves.get(), RespiteItems.powderedBlackTeaLeaves.get());
    }
}
