package com.pouffydev.bundledelight.datagen;

import com.pouffydev.bundledelight.BundledDelight;
import com.pouffydev.bundledelight.foundation.util.Brews;
import com.pouffydev.bundledelight.foundation.util.Teas;
import com.pouffydev.bundledelight.init.bundles.brewinandchewin.BrewinItems;
import com.pouffydev.bundledelight.init.bundles.builtin.BuiltinBlocks;
import com.pouffydev.bundledelight.init.bundles.farmersrespite.RespiteItems;
import com.pouffydev.bundledelight.init.bundles.neapolitan.NeapolitanItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.common.tag.ModTags;

import java.util.concurrent.CompletableFuture;

public class BundleDelightTagsProvider {

    public static void addGenerators(GatherDataEvent event) {
        DataGenerator dataGenerator = event.getGenerator();
        var blockTagsProvider = new Block(dataGenerator.getPackOutput(), event.getLookupProvider(), BundledDelight.MODID, event.getExistingFileHelper());
        var itemTagsProvider = new Item(dataGenerator.getPackOutput(), event.getLookupProvider(), blockTagsProvider.contentsGetter());
        dataGenerator.addProvider(event.includeServer(), blockTagsProvider);
        dataGenerator.addProvider(event.includeServer(), itemTagsProvider);
    }
    
    private static class Block extends BlockTagsProvider {

        public Block(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, String modId, @Nullable ExistingFileHelper existingFileHelper) {
            super(output, lookupProvider, modId, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.Provider provider) {
            tag(BlockTags.MINEABLE_WITH_AXE)
                    .addOptional(BundledDelight.location("mint_leaf_sack"))
                    .addOptional(BundledDelight.location("adzuki_bean_sack"))
                    .addOptional(BundledDelight.location("roasted_adzuki_bean_sack"))
                    .addOptional(BundledDelight.location("powdered_adzuki_beans_sack"))
                    .addOptional(BundledDelight.location("powdered_mint_leaves_sack"))
                    .addOptional(BundledDelight.location("powdered_vanilla_sack"))
                    .addOptional(BundledDelight.location("powdered_green_tea_leaves_sack"))
                    .addOptional(BundledDelight.location("powdered_yellow_tea_leaves_sack"))
                    .addOptional(BundledDelight.location("powdered_black_tea_leaves_sack"))
                    .addOptional(BundledDelight.location("powdered_coffee_beans_sack"));
            tag(ModTags.Blocks.MINEABLE_WITH_KNIFE)
                    .add(BuiltinBlocks.carrotCake.get())
                    .addOptional(BundledDelight.location("white_strawberry_cake"));
            tag(BlockTags.MINEABLE_WITH_SHOVEL)
                    .addOptional(BundledDelight.location("white_strawberry_ice_cream_block"))
                    .addOptional(BundledDelight.location("sweet_berry_ice_cream_block"));
            tag(BlockTags.CANDLE_CAKES)
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
                    .addOptional(BundledDelight.location("white_strawberry_candle_cake"))
                    .addOptional(BundledDelight.location("white_white_strawberry_candle_cake"))
                    .addOptional(BundledDelight.location("orange_white_strawberry_candle_cake"))
                    .addOptional(BundledDelight.location("magenta_white_strawberry_candle_cake"))
                    .addOptional(BundledDelight.location("light_blue_white_strawberry_candle_cake"))
                    .addOptional(BundledDelight.location("yellow_white_strawberry_candle_cake"))
                    .addOptional(BundledDelight.location("lime_white_strawberry_candle_cake"))
                    .addOptional(BundledDelight.location("pink_white_strawberry_candle_cake"))
                    .addOptional(BundledDelight.location("gray_white_strawberry_candle_cake"))
                    .addOptional(BundledDelight.location("light_gray_white_strawberry_candle_cake"))
                    .addOptional(BundledDelight.location("cyan_white_strawberry_candle_cake"))
                    .addOptional(BundledDelight.location("purple_white_strawberry_candle_cake"))
                    .addOptional(BundledDelight.location("blue_white_strawberry_candle_cake"))
                    .addOptional(BundledDelight.location("brown_white_strawberry_candle_cake"))
                    .addOptional(BundledDelight.location("green_white_strawberry_candle_cake"))
                    .addOptional(BundledDelight.location("red_white_strawberry_candle_cake"))
                    .addOptional(BundledDelight.location("black_white_strawberry_candle_cake"));
            tag(BundleTags.DROPS_CAKE_SLICE)
                    .add(BuiltinBlocks.carrotCake.get())
                    .addOptional(BundledDelight.location("white_strawberry_cake"));
            tag(BundleTags.DROPS_CARROT_CAKE_SLICE).add(
                    BuiltinBlocks.carrotCake.get()
            );
            tag(BundleTags.DROPS_WHITE_STRAWBERRY_CAKE_SLICE).addOptional(
                    BundledDelight.location("white_strawberry_cake")
            );
        }
    }

    private static class Item extends ItemTagsProvider {

        public Item(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<net.minecraft.world.level.block.Block>> blockTags) {
            super(output, lookupProvider, blockTags);
        }

        @Override
        protected void addTags(HolderLookup.Provider provider) {
            tag(BundleTags.SEEDS).addOptional(BundledDelight.location("farmersrespite:tea_seeds")).addOptional(BundledDelight.location("farmersrespite:coffee_beans"));
            tag(BundleTags.SEEDS_TEA).addOptional(BundledDelight.location("farmersrespite:tea_seeds"));
            tag(BundleTags.SEEDS_COFFEE).addOptional(BundledDelight.location("farmersrespite:coffee_beans"));
            for (Brews brew : Brews.values()) {
                tag(brew.getTag()).addOptional(brew.tankardId()).addOptional(brew.swigId()).addOptional(brew.glassId());
                tag(BundleTags.BELT_UPRIGHT).addOptionalTag(brew.getTagLoc()).addOptional(BundledDelight.location("copper_swig")).addOptional(BundledDelight.location("glass_tankard"));
            }
            for (Teas tea : Teas.values()) {
                tag(tea.getTag()).addOptional(tea.getTeaLoc()).addOptional(tea.getTeaCupLoc());
                tag(BundleTags.BELT_UPRIGHT).addOptionalTag(tea.getTagLoc());
            }
            tag(BundleTags.BEESECHURGER).add(BrewinItems.cheeseburger.get(), BrewinItems.scarletCheeseburger.get());
            tag(BundleTags.GREEN_TEA_POWDER).add(RespiteItems.powderedGreenTeaLeaves.get());
            tag(BundleTags.YELLOW_TEA_POWDER).add(RespiteItems.powderedYellowTeaLeaves.get());
            tag(BundleTags.BLACK_TEA_POWDER).add(RespiteItems.powderedBlackTeaLeaves.get());
            tag(BundleTags.COFFEE_POWDER).add(RespiteItems.powderedCoffeeBeans.get());
            tag(BundleTags.ADZUKI_POWDER).add(NeapolitanItems.powderedAdzukiBeans.get());
            tag(BundleTags.VANILLA_POWDER).add(NeapolitanItems.powderedVanilla.get());
            tag(BundleTags.MINT_POWDER).add(NeapolitanItems.powderedMintLeaves.get());
            tag(BundleTags.TEA_POWDER).add(RespiteItems.powderedGreenTeaLeaves.get(), RespiteItems.powderedYellowTeaLeaves.get(), RespiteItems.powderedBlackTeaLeaves.get());
        }
    }
}
