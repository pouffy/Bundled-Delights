package com.pouffydev.bundledelight.init.bundles.builtin;

import com.pouffydev.bundledelight.BundledDelight;
import com.pouffydev.bundledelight.common.elements.block.CompatFlavoredCakeBlock;
import com.pouffydev.bundledelight.common.elements.block.CompatFlavoredCandleCakeBlock;
import com.pouffydev.bundledelight.foundation.BDBlockHelper;
import com.pouffydev.bundledelight.init.FoodValues;
import com.pouffydev.krystal_core.KrystalCore;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.function.ToIntFunction;

public class BuiltinBlocks {
    private static final BDBlockHelper HELPER = new BDBlockHelper(BundledDelight.getRegistryHelper().getBlockHelper());
    
    public static final DeferredBlock<CompatFlavoredCakeBlock> carrotCake = HELPER.cake(formatName("carrot_cake"), FoodValues.CARROT_CAKE, (p) -> Properties.CARROT_CAKE);

    public static final DeferredBlock<CompatFlavoredCandleCakeBlock>
            carrotCandleCake = HELPER.candleCake(formatName("carrot_candle_cake"), carrotCake, Blocks.CANDLE, (p) -> Properties.CARROT_CANDLE_CAKE),
            whiteCarrotCandleCake = HELPER.candleCake(formatName("white_carrot_candle_cake"), carrotCake, Blocks.WHITE_CANDLE, (p) -> Properties.CARROT_CANDLE_CAKE),
            orangeCarrotCandleCake = HELPER.candleCake(formatName("orange_carrot_candle_cake"), carrotCake, Blocks.ORANGE_CANDLE, (p) -> Properties.CARROT_CANDLE_CAKE),
            magentaCarrotCandleCake = HELPER.candleCake(formatName("magenta_carrot_candle_cake"), carrotCake, Blocks.MAGENTA_CANDLE, (p) -> Properties.CARROT_CANDLE_CAKE),
            lightBlueCarrotCandleCake = HELPER.candleCake(formatName("light_blue_carrot_candle_cake"), carrotCake, Blocks.LIGHT_BLUE_CANDLE, (p) -> Properties.CARROT_CANDLE_CAKE),
            yellowCarrotCandleCake = HELPER.candleCake(formatName("yellow_carrot_candle_cake"), carrotCake, Blocks.YELLOW_CANDLE, (p) -> Properties.CARROT_CANDLE_CAKE),
            limeCarrotCandleCake = HELPER.candleCake(formatName("lime_carrot_candle_cake"), carrotCake, Blocks.LIME_CANDLE, (p) -> Properties.CARROT_CANDLE_CAKE),
            pinkCarrotCandleCake = HELPER.candleCake(formatName("pink_carrot_candle_cake"), carrotCake, Blocks.PINK_CANDLE, (p) -> Properties.CARROT_CANDLE_CAKE),
            grayCarrotCandleCake = HELPER.candleCake(formatName("gray_carrot_candle_cake"), carrotCake, Blocks.GRAY_CANDLE, (p) -> Properties.CARROT_CANDLE_CAKE),
            lightGrayCarrotCandleCake = HELPER.candleCake(formatName("light_gray_carrot_candle_cake"), carrotCake, Blocks.LIGHT_GRAY_CANDLE, (p) -> Properties.CARROT_CANDLE_CAKE),
            cyanCarrotCandleCake = HELPER.candleCake(formatName("cyan_carrot_candle_cake"), carrotCake, Blocks.CYAN_CANDLE, (p) -> Properties.CARROT_CANDLE_CAKE),
            purpleCarrotCandleCake = HELPER.candleCake(formatName("purple_carrot_candle_cake"), carrotCake, Blocks.PURPLE_CANDLE, (p) -> Properties.CARROT_CANDLE_CAKE),
            blueCarrotCandleCake = HELPER.candleCake(formatName("blue_carrot_candle_cake"), carrotCake, Blocks.BLUE_CANDLE, (p) -> Properties.CARROT_CANDLE_CAKE),
            brownCarrotCandleCake = HELPER.candleCake(formatName("brown_carrot_candle_cake"), carrotCake, Blocks.BROWN_CANDLE, (p) -> Properties.CARROT_CANDLE_CAKE),
            greenCarrotCandleCake = HELPER.candleCake(formatName("green_carrot_candle_cake"), carrotCake, Blocks.GREEN_CANDLE, (p) -> Properties.CARROT_CANDLE_CAKE),
            redCarrotCandleCake = HELPER.candleCake(formatName("red_carrot_candle_cake"), carrotCake, Blocks.RED_CANDLE, (p) -> Properties.CARROT_CANDLE_CAKE),
            blackCarrotCandleCake = HELPER.candleCake(formatName("black_carrot_candle_cake"), carrotCake, Blocks.BLACK_CANDLE, (p) -> Properties.CARROT_CANDLE_CAKE);
    
    public static class Properties {
        public static final BlockBehaviour.Properties CARROT_CAKE;
        public static final BlockBehaviour.Properties CARROT_CANDLE_CAKE;
        Properties() {
        }
        
        private static ToIntFunction<BlockState> litBlockEmission(int level) {
            return (state) -> (Boolean)state.getValue(BlockStateProperties.LIT) ? level : 0;
        }
        
        static {
            CARROT_CAKE = BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).strength(0.5F).sound(SoundType.WOOL);
            CARROT_CANDLE_CAKE = BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).strength(0.5F).sound(SoundType.WOOL).lightLevel(litBlockEmission(3));
            
        }
    }
    
    public static void register() {
        BundledDelight.LOGGER.info("Registering Builtin Blocks");
    }

    private static String formatName(String name) {
        var bundle = KrystalCore.getBundle(BundledDelight.location("builtin"));
        return bundle == null ? name : bundle.getBundleContentName(name);
    }
}
