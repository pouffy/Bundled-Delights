package com.pouffy.bundledelight.compats.neapolitan;

import com.teamabnormals.blueprint.core.util.registry.BlockSubRegistryHelper;
import com.teamabnormals.neapolitan.core.Neapolitan;
import com.teamabnormals.neapolitan.core.registry.NeapolitanItems;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.ToIntFunction;

public class NeapolitanCompatBlocks {
    public static final DeferredRegister<Block> BLOCKS;
    public static final RegistryObject<Block> STRAWBERRY_CAKE;
    public static final RegistryObject<Block> STRAWBERRY_CANDLE_CAKE;
    public static final RegistryObject<Block> WHITE_STRAWBERRY_CANDLE_CAKE;
    public static final RegistryObject<Block> ORANGE_STRAWBERRY_CANDLE_CAKE;
    public static final RegistryObject<Block> MAGENTA_STRAWBERRY_CANDLE_CAKE;
    public static final RegistryObject<Block> LIGHT_BLUE_STRAWBERRY_CANDLE_CAKE;
    public static final RegistryObject<Block> YELLOW_STRAWBERRY_CANDLE_CAKE;
    public static final RegistryObject<Block> LIME_STRAWBERRY_CANDLE_CAKE;
    public static final RegistryObject<Block> PINK_STRAWBERRY_CANDLE_CAKE;
    public static final RegistryObject<Block> GRAY_STRAWBERRY_CANDLE_CAKE;
    public static final RegistryObject<Block> LIGHT_GRAY_STRAWBERRY_CANDLE_CAKE;
    public static final RegistryObject<Block> CYAN_STRAWBERRY_CANDLE_CAKE;
    public static final RegistryObject<Block> PURPLE_STRAWBERRY_CANDLE_CAKE;
    public static final RegistryObject<Block> BLUE_STRAWBERRY_CANDLE_CAKE;
    public static final RegistryObject<Block> BROWN_STRAWBERRY_CANDLE_CAKE;
    public static final RegistryObject<Block> GREEN_STRAWBERRY_CANDLE_CAKE;
    public static final RegistryObject<Block> RED_STRAWBERRY_CANDLE_CAKE;
    public static final RegistryObject<Block> BLACK_STRAWBERRY_CANDLE_CAKE;

    static{
        BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, "bundledelight");
        
        STRAWBERRY_CAKE = BLOCKS.register("white_strawberry_cake", () -> {
            return new CompatFlavoredCakeBlock(NeapolitanItems.NeapolitanFoods.STRAWBERRY_CAKE, NeapolitanCompatBlocks.Properties.STRAWBERRY_CAKE);
        });
        STRAWBERRY_CANDLE_CAKE = BLOCKS.register("white_strawberry_candle_cake", () -> {
            return new CompatFlavoredCandleCakeBlock(STRAWBERRY_CAKE, Blocks.CANDLE, NeapolitanCompatBlocks.Properties.STRAWBERRY_CANDLE_CAKE);
        });
        WHITE_STRAWBERRY_CANDLE_CAKE = BLOCKS.register("white_white_strawberry_candle_cake", () -> {
            return new CompatFlavoredCandleCakeBlock(STRAWBERRY_CAKE, Blocks.WHITE_CANDLE, NeapolitanCompatBlocks.Properties.STRAWBERRY_CANDLE_CAKE);
        });
        ORANGE_STRAWBERRY_CANDLE_CAKE = BLOCKS.register("orange_white_strawberry_candle_cake", () -> {
            return new CompatFlavoredCandleCakeBlock(STRAWBERRY_CAKE, Blocks.ORANGE_CANDLE, NeapolitanCompatBlocks.Properties.STRAWBERRY_CANDLE_CAKE);
        });
        MAGENTA_STRAWBERRY_CANDLE_CAKE = BLOCKS.register("magenta_white_strawberry_candle_cake", () -> {
            return new CompatFlavoredCandleCakeBlock(STRAWBERRY_CAKE, Blocks.MAGENTA_CANDLE, NeapolitanCompatBlocks.Properties.STRAWBERRY_CANDLE_CAKE);
        });
        LIGHT_BLUE_STRAWBERRY_CANDLE_CAKE = BLOCKS.register("light_blue_white_strawberry_candle_cake", () -> {
            return new CompatFlavoredCandleCakeBlock(STRAWBERRY_CAKE, Blocks.LIGHT_BLUE_CANDLE, NeapolitanCompatBlocks.Properties.STRAWBERRY_CANDLE_CAKE);
        });
        YELLOW_STRAWBERRY_CANDLE_CAKE = BLOCKS.register("yellow_white_strawberry_candle_cake", () -> {
            return new CompatFlavoredCandleCakeBlock(STRAWBERRY_CAKE, Blocks.YELLOW_CANDLE, NeapolitanCompatBlocks.Properties.STRAWBERRY_CANDLE_CAKE);
        });
        LIME_STRAWBERRY_CANDLE_CAKE = BLOCKS.register("lime_white_strawberry_candle_cake", () -> {
            return new CompatFlavoredCandleCakeBlock(STRAWBERRY_CAKE, Blocks.LIME_CANDLE, NeapolitanCompatBlocks.Properties.STRAWBERRY_CANDLE_CAKE);
        });
        PINK_STRAWBERRY_CANDLE_CAKE = BLOCKS.register("pink_white_strawberry_candle_cake", () -> {
            return new CompatFlavoredCandleCakeBlock(STRAWBERRY_CAKE, Blocks.PINK_CANDLE, NeapolitanCompatBlocks.Properties.STRAWBERRY_CANDLE_CAKE);
        });
        GRAY_STRAWBERRY_CANDLE_CAKE = BLOCKS.register("gray_white_strawberry_candle_cake", () -> {
            return new CompatFlavoredCandleCakeBlock(STRAWBERRY_CAKE, Blocks.GRAY_CANDLE, NeapolitanCompatBlocks.Properties.STRAWBERRY_CANDLE_CAKE);
        });
        LIGHT_GRAY_STRAWBERRY_CANDLE_CAKE = BLOCKS.register("light_gray_white_strawberry_candle_cake", () -> {
            return new CompatFlavoredCandleCakeBlock(STRAWBERRY_CAKE, Blocks.LIGHT_GRAY_CANDLE, NeapolitanCompatBlocks.Properties.STRAWBERRY_CANDLE_CAKE);
        });
        CYAN_STRAWBERRY_CANDLE_CAKE = BLOCKS.register("cyan_white_strawberry_candle_cake", () -> {
            return new CompatFlavoredCandleCakeBlock(STRAWBERRY_CAKE, Blocks.CYAN_CANDLE, NeapolitanCompatBlocks.Properties.STRAWBERRY_CANDLE_CAKE);
        });
        PURPLE_STRAWBERRY_CANDLE_CAKE = BLOCKS.register("purple_white_strawberry_candle_cake", () -> {
            return new CompatFlavoredCandleCakeBlock(STRAWBERRY_CAKE, Blocks.PURPLE_CANDLE, NeapolitanCompatBlocks.Properties.STRAWBERRY_CANDLE_CAKE);
        });
        BLUE_STRAWBERRY_CANDLE_CAKE = BLOCKS.register("blue_white_strawberry_candle_cake", () -> {
            return new CompatFlavoredCandleCakeBlock(STRAWBERRY_CAKE, Blocks.BLUE_CANDLE, NeapolitanCompatBlocks.Properties.STRAWBERRY_CANDLE_CAKE);
        });
        BROWN_STRAWBERRY_CANDLE_CAKE = BLOCKS.register("brown_white_strawberry_candle_cake", () -> {
            return new CompatFlavoredCandleCakeBlock(STRAWBERRY_CAKE, Blocks.BROWN_CANDLE, NeapolitanCompatBlocks.Properties.STRAWBERRY_CANDLE_CAKE);
        });
        GREEN_STRAWBERRY_CANDLE_CAKE = BLOCKS.register("green_white_strawberry_candle_cake", () -> {
            return new CompatFlavoredCandleCakeBlock(STRAWBERRY_CAKE, Blocks.GREEN_CANDLE, NeapolitanCompatBlocks.Properties.STRAWBERRY_CANDLE_CAKE);
        });
        RED_STRAWBERRY_CANDLE_CAKE = BLOCKS.register("red_white_strawberry_candle_cake", () -> {
            return new CompatFlavoredCandleCakeBlock(STRAWBERRY_CAKE, Blocks.RED_CANDLE, NeapolitanCompatBlocks.Properties.STRAWBERRY_CANDLE_CAKE);
        });
        BLACK_STRAWBERRY_CANDLE_CAKE = BLOCKS.register("black_white_strawberry_candle_cake", () -> {
            return new CompatFlavoredCandleCakeBlock(STRAWBERRY_CAKE, Blocks.BLACK_CANDLE, NeapolitanCompatBlocks.Properties.STRAWBERRY_CANDLE_CAKE);
        });
    }
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
}
