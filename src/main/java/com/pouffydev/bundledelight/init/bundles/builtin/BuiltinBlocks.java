package com.pouffydev.bundledelight.init.bundles.builtin;

import com.pouffydev.bundledelight.BundledDelights;
import com.pouffydev.bundledelight.compat.neapolitan.CompatFlavoredCakeBlock;
import com.pouffydev.bundledelight.compat.neapolitan.CompatFlavoredCandleCakeBlock;
import com.pouffydev.bundledelight.content.food.FoodValues;
import com.pouffydev.bundledelight.foundation.BundleRegistryClass;
import com.pouffydev.bundledelight.foundation.BundledRegistrate;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

import java.util.function.ToIntFunction;

public class BuiltinBlocks extends BundleRegistryClass {
    public static final BundledRegistrate registrate = BundledDelights.registrate().creativeModeTab(() -> BundledDelights.itemGroup);
    
    public static final BlockEntry<CompatFlavoredCakeBlock> carrotCake = registrate.cake(getBundleContentName("carrot_cake"), FoodValues.CARROT_CAKE, (p) -> Properties.CARROT_CAKE);
    
    public static final BlockEntry<CompatFlavoredCandleCakeBlock>
            carrotCandleCake = registrate.candleCake(getBundleContentName("carrot_candle_cake"), carrotCake::get, Blocks.CANDLE, (p) -> Properties.CARROT_CANDLE_CAKE),
            whiteCarrotCandleCake = registrate.candleCake(getBundleContentName("white_carrot_candle_cake"), carrotCake::get, Blocks.WHITE_CANDLE, (p) -> Properties.CARROT_CANDLE_CAKE, "white"),
            orangeCarrotCandleCake = registrate.candleCake(getBundleContentName("orange_carrot_candle_cake"), carrotCake::get, Blocks.ORANGE_CANDLE, (p) -> Properties.CARROT_CANDLE_CAKE, "orange"),
            magentaCarrotCandleCake = registrate.candleCake(getBundleContentName("magenta_carrot_candle_cake"), carrotCake::get, Blocks.MAGENTA_CANDLE, (p) -> Properties.CARROT_CANDLE_CAKE, "magenta"),
            lightBlueCarrotCandleCake = registrate.candleCake(getBundleContentName("light_blue_carrot_candle_cake"), carrotCake::get, Blocks.LIGHT_BLUE_CANDLE, (p) -> Properties.CARROT_CANDLE_CAKE, "light_blue"),
            yellowCarrotCandleCake = registrate.candleCake(getBundleContentName("yellow_carrot_candle_cake"), carrotCake::get, Blocks.YELLOW_CANDLE, (p) -> Properties.CARROT_CANDLE_CAKE, "yellow"),
            limeCarrotCandleCake = registrate.candleCake(getBundleContentName("lime_carrot_candle_cake"), carrotCake::get, Blocks.LIME_CANDLE, (p) -> Properties.CARROT_CANDLE_CAKE, "lime"),
            pinkCarrotCandleCake = registrate.candleCake(getBundleContentName("pink_carrot_candle_cake"), carrotCake::get, Blocks.PINK_CANDLE, (p) -> Properties.CARROT_CANDLE_CAKE, "pink"),
            grayCarrotCandleCake = registrate.candleCake(getBundleContentName("gray_carrot_candle_cake"), carrotCake::get, Blocks.GRAY_CANDLE, (p) -> Properties.CARROT_CANDLE_CAKE, "gray"),
            lightGrayCarrotCandleCake = registrate.candleCake(getBundleContentName("light_gray_carrot_candle_cake"), carrotCake::get, Blocks.LIGHT_GRAY_CANDLE, (p) -> Properties.CARROT_CANDLE_CAKE, "light_gray"),
            cyanCarrotCandleCake = registrate.candleCake(getBundleContentName("cyan_carrot_candle_cake"), carrotCake::get, Blocks.CYAN_CANDLE, (p) -> Properties.CARROT_CANDLE_CAKE, "cyan"),
            purpleCarrotCandleCake = registrate.candleCake(getBundleContentName("purple_carrot_candle_cake"), carrotCake::get, Blocks.PURPLE_CANDLE, (p) -> Properties.CARROT_CANDLE_CAKE, "purple"),
            blueCarrotCandleCake = registrate.candleCake(getBundleContentName("blue_carrot_candle_cake"), carrotCake::get, Blocks.BLUE_CANDLE, (p) -> Properties.CARROT_CANDLE_CAKE, "blue"),
            brownCarrotCandleCake = registrate.candleCake(getBundleContentName("brown_carrot_candle_cake"), carrotCake::get, Blocks.BROWN_CANDLE, (p) -> Properties.CARROT_CANDLE_CAKE, "brown"),
            greenCarrotCandleCake = registrate.candleCake(getBundleContentName("green_carrot_candle_cake"), carrotCake::get, Blocks.GREEN_CANDLE, (p) -> Properties.CARROT_CANDLE_CAKE, "green"),
            redCarrotCandleCake = registrate.candleCake(getBundleContentName("red_carrot_candle_cake"), carrotCake::get, Blocks.RED_CANDLE, (p) -> Properties.CARROT_CANDLE_CAKE, "red"),
            blackCarrotCandleCake = registrate.candleCake(getBundleContentName("black_carrot_candle_cake"), carrotCake::get, Blocks.BLACK_CANDLE, (p) -> Properties.CARROT_CANDLE_CAKE, "black");
    
    
    public static class Properties {
        public static final BlockBehaviour.Properties CARROT_CAKE;
        public static final BlockBehaviour.Properties CARROT_CANDLE_CAKE;
        Properties() {
        }
        
        private static ToIntFunction<BlockState> litBlockEmission(int level) {
            return (state) -> {
                return (Boolean)state.getValue(BlockStateProperties.LIT) ? level : 0;
            };
        }
        
        static {
            CARROT_CAKE = BlockBehaviour.Properties.of(Material.CAKE, MaterialColor.COLOR_ORANGE).strength(0.5F).sound(SoundType.WOOL);
            CARROT_CANDLE_CAKE = BlockBehaviour.Properties.of(Material.CAKE, MaterialColor.COLOR_ORANGE).strength(0.5F).sound(SoundType.WOOL).lightLevel(litBlockEmission(3));
            
        }
    }
    
    public static void register() {
    }
}
