package com.pouffydev.bundledelight.init.bundles.neapolitan;

import com.pouffydev.bundledelight.BundledDelight;
import com.pouffydev.bundledelight.common.elements.block.CompatFlavoredCakeBlock;
import com.pouffydev.bundledelight.common.elements.block.CompatFlavoredCandleCakeBlock;
import com.pouffydev.bundledelight.foundation.BundledRegistrate;
import com.pouffydev.bundledelight.foundation.bundle.BundleRegistryClass;
import com.pouffydev.bundledelight.init.FoodValues;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

import java.util.function.ToIntFunction;

public class NeapolitanBlocks extends BundleRegistryClass {
    public static final BundledRegistrate registrate = BundledDelight.registrate().creativeModeTab(() -> BundledDelight.itemGroup);

    public NeapolitanBlocks() {
        super("neapolitan");
    }

    public static final BlockEntry<CompatFlavoredCakeBlock> whiteStrawberryCake = registrate.cake(getBundleContentName("white_strawberry_cake"), FoodValues.STRAWBERRY_CAKE, (p) -> Properties.STRAWBERRY_CAKE);
    
    public static final BlockEntry<CompatFlavoredCandleCakeBlock> 
            whiteStrawberryCandleCake = registrate.candleCake(getBundleContentName("white_strawberry_candle_cake"), whiteStrawberryCake::get, Blocks.CANDLE, (p) -> Properties.STRAWBERRY_CANDLE_CAKE),
            whiteWhiteStrawberryCandleCake = registrate.candleCake(getBundleContentName("white_white_strawberry_candle_cake"), whiteStrawberryCake::get, Blocks.WHITE_CANDLE, (p) -> Properties.STRAWBERRY_CANDLE_CAKE, "white"),
            orangeWhiteStrawberryCandleCake = registrate.candleCake(getBundleContentName("orange_white_strawberry_candle_cake"), whiteStrawberryCake::get, Blocks.ORANGE_CANDLE, (p) -> Properties.STRAWBERRY_CANDLE_CAKE, "orange"),
            magentaWhiteStrawberryCandleCake = registrate.candleCake(getBundleContentName("magenta_white_strawberry_candle_cake"), whiteStrawberryCake::get, Blocks.MAGENTA_CANDLE, (p) -> Properties.STRAWBERRY_CANDLE_CAKE, "magenta"),
            lightBlueWhiteStrawberryCandleCake = registrate.candleCake(getBundleContentName("light_blue_white_strawberry_candle_cake"), whiteStrawberryCake::get, Blocks.LIGHT_BLUE_CANDLE, (p) -> Properties.STRAWBERRY_CANDLE_CAKE, "light_blue"),
            yellowWhiteStrawberryCandleCake = registrate.candleCake(getBundleContentName("yellow_white_strawberry_candle_cake"), whiteStrawberryCake::get, Blocks.YELLOW_CANDLE, (p) -> Properties.STRAWBERRY_CANDLE_CAKE, "yellow"),
            limeWhiteStrawberryCandleCake = registrate.candleCake(getBundleContentName("lime_white_strawberry_candle_cake"), whiteStrawberryCake::get, Blocks.LIME_CANDLE, (p) -> Properties.STRAWBERRY_CANDLE_CAKE, "lime"),
            pinkWhiteStrawberryCandleCake = registrate.candleCake(getBundleContentName("pink_white_strawberry_candle_cake"), whiteStrawberryCake::get, Blocks.PINK_CANDLE, (p) -> Properties.STRAWBERRY_CANDLE_CAKE, "pink"),
            grayWhiteStrawberryCandleCake = registrate.candleCake(getBundleContentName("gray_white_strawberry_candle_cake"), whiteStrawberryCake::get, Blocks.GRAY_CANDLE, (p) -> Properties.STRAWBERRY_CANDLE_CAKE, "gray"),
            lightGrayWhiteStrawberryCandleCake = registrate.candleCake(getBundleContentName("light_gray_white_strawberry_candle_cake"), whiteStrawberryCake::get, Blocks.LIGHT_GRAY_CANDLE, (p) -> Properties.STRAWBERRY_CANDLE_CAKE, "light_gray"),
            cyanWhiteStrawberryCandleCake = registrate.candleCake(getBundleContentName("cyan_white_strawberry_candle_cake"), whiteStrawberryCake::get, Blocks.CYAN_CANDLE, (p) -> Properties.STRAWBERRY_CANDLE_CAKE, "cyan"),
            purpleWhiteStrawberryCandleCake = registrate.candleCake(getBundleContentName("purple_white_strawberry_candle_cake"), whiteStrawberryCake::get, Blocks.PURPLE_CANDLE, (p) -> Properties.STRAWBERRY_CANDLE_CAKE, "purple"),
            blueWhiteStrawberryCandleCake = registrate.candleCake(getBundleContentName("blue_white_strawberry_candle_cake"), whiteStrawberryCake::get, Blocks.BLUE_CANDLE, (p) -> Properties.STRAWBERRY_CANDLE_CAKE, "blue"),
            brownWhiteStrawberryCandleCake = registrate.candleCake(getBundleContentName("brown_white_strawberry_candle_cake"), whiteStrawberryCake::get, Blocks.BROWN_CANDLE, (p) -> Properties.STRAWBERRY_CANDLE_CAKE, "brown"),
            greenWhiteStrawberryCandleCake = registrate.candleCake(getBundleContentName("green_white_strawberry_candle_cake"), whiteStrawberryCake::get, Blocks.GREEN_CANDLE, (p) -> Properties.STRAWBERRY_CANDLE_CAKE, "green"),
            redWhiteStrawberryCandleCake = registrate.candleCake(getBundleContentName("red_white_strawberry_candle_cake"), whiteStrawberryCake::get, Blocks.RED_CANDLE, (p) -> Properties.STRAWBERRY_CANDLE_CAKE, "red"),
            blackWhiteStrawberryCandleCake = registrate.candleCake(getBundleContentName("black_white_strawberry_candle_cake"), whiteStrawberryCake::get, Blocks.BLACK_CANDLE, (p) -> Properties.STRAWBERRY_CANDLE_CAKE, "black");

    public static final BlockEntry<Block>
            mintLeafSack = registrate.sack(getBundleContentName("mint_leaf_sack"), (p) -> p),
            adzukiBeanSack = registrate.sack(getBundleContentName("adzuki_bean_sack"), (p) -> p);

    public static final BlockEntry<Block>
            whiteStrawberryIceCreamBlock = registrate.iceCreamBlock(getBundleContentName("white_strawberry_ice_cream_block"), MaterialColor.TERRACOTTA_WHITE, (p) -> p),
            sweetBerryIceCreamBlock = registrate.iceCreamBlock(getBundleContentName("sweet_berry_ice_cream_block"), MaterialColor.TERRACOTTA_PINK, (p) -> p);


    static class Properties {
        public static final BlockBehaviour.Properties STRAWBERRY_CAKE;
        public static final BlockBehaviour.Properties STRAWBERRY_CANDLE_CAKE;
        Properties() {
        }

        private static ToIntFunction<BlockState> litBlockEmission(int level) {
            return (state) -> {
                return (Boolean)state.getValue(BlockStateProperties.LIT) ? level : 0;
            };
        }

        static {
            STRAWBERRY_CAKE = BlockBehaviour.Properties.of(Material.CAKE, MaterialColor.COLOR_PINK).strength(0.5F).sound(SoundType.WOOL);
            STRAWBERRY_CANDLE_CAKE = BlockBehaviour.Properties.of(Material.CAKE, MaterialColor.COLOR_PINK).strength(0.5F).sound(SoundType.WOOL).lightLevel(litBlockEmission(3));

        }
    }

    public static void register() {
        BundledDelight.LOGGER.info("Registering Neapolitan Blocks");
    }
}
