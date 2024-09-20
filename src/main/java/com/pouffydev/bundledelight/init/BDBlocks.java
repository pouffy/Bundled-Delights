package com.pouffydev.bundledelight.init;

import com.pouffydev.bundledelight.compat.neapolitan.CompatFlavoredCakeBlock;
import com.pouffydev.bundledelight.compat.neapolitan.CompatFlavoredCandleCakeBlock;
import com.pouffydev.bundledelight.content.food.FoodValues;
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

public class BDBlocks {
    public static final DeferredRegister<Block> BLOCKS;
    public static final RegistryObject<Block> GREEN_TEA_POWDER_BASKET;
    public static final RegistryObject<Block> YELLOW_TEA_POWDER_BASKET;
    public static final RegistryObject<Block> BLACK_TEA_POWDER_BASKET;
    public static final RegistryObject<Block> COFFEE_POWDER_BASKET;
    public static final RegistryObject<Block> GREEN_TEA_CRATE;
    public static final RegistryObject<Block> YELLOW_TEA_CRATE;
    public static final RegistryObject<Block> BLACK_TEA_CRATE;
    public static final RegistryObject<Block> COFFEE_CRATE;
    public static final RegistryObject<Block> ADZUKI_CRATE;
    public static final RegistryObject<Block> VANILLA_CRATE;
    public static final RegistryObject<Block> MINT_CRATE;
    public static final RegistryObject<Block> ADZUKI_POWDER_BASKET;
    public static final RegistryObject<Block> VANILLA_POWDER_BASKET;
    public static final RegistryObject<Block> MINT_POWDER_BASKET;
    public static final RegistryObject<Block> WHITE_STRAWBERRY_ICE_CREAM_BLOCK;

    public static final RegistryObject<Block> CARROT_CAKE;
    public static final RegistryObject<Block> CARROT_CANDLE_CAKE;
    public static final RegistryObject<Block> WHITE_CARROT_CANDLE_CAKE;
    public static final RegistryObject<Block> ORANGE_CARROT_CANDLE_CAKE;
    public static final RegistryObject<Block> MAGENTA_CARROT_CANDLE_CAKE;
    public static final RegistryObject<Block> LIGHT_BLUE_CARROT_CANDLE_CAKE;
    public static final RegistryObject<Block> YELLOW_CARROT_CANDLE_CAKE;
    public static final RegistryObject<Block> LIME_CARROT_CANDLE_CAKE;
    public static final RegistryObject<Block> PINK_CARROT_CANDLE_CAKE;
    public static final RegistryObject<Block> GRAY_CARROT_CANDLE_CAKE;
    public static final RegistryObject<Block> LIGHT_GRAY_CARROT_CANDLE_CAKE;
    public static final RegistryObject<Block> CYAN_CARROT_CANDLE_CAKE;
    public static final RegistryObject<Block> PURPLE_CARROT_CANDLE_CAKE;
    public static final RegistryObject<Block> BLUE_CARROT_CANDLE_CAKE;
    public static final RegistryObject<Block> BROWN_CARROT_CANDLE_CAKE;
    public static final RegistryObject<Block> GREEN_CARROT_CANDLE_CAKE;
    public static final RegistryObject<Block> RED_CARROT_CANDLE_CAKE;
    public static final RegistryObject<Block> BLACK_CARROT_CANDLE_CAKE;

    public BDBlocks() {
    }

    private static ToIntFunction<BlockState> litBlockEmission(int lightValue) {
        return (state) -> {
            return (Boolean) state.getValue(BlockStateProperties.LIT) ? lightValue : 0;
        };
    }

    static {
        BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, "bundledelight");
        GREEN_TEA_POWDER_BASKET = BLOCKS.register("green_tea_powder_basket", () -> {
            return new Block(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD));
        });
        YELLOW_TEA_POWDER_BASKET = BLOCKS.register("yellow_tea_powder_basket", () -> {
            return new Block(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD));
        });
        BLACK_TEA_POWDER_BASKET = BLOCKS.register("black_tea_powder_basket", () -> {
            return new Block(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD));
        });
        COFFEE_POWDER_BASKET = BLOCKS.register("coffee_powder_basket", () -> {
            return new Block(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD));
        });
        GREEN_TEA_CRATE = BLOCKS.register("green_tea_leaf_crate", () -> {
            return new Block(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD));
        });
        YELLOW_TEA_CRATE = BLOCKS.register("yellow_tea_leaf_crate", () -> {
            return new Block(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD));
        });
        BLACK_TEA_CRATE = BLOCKS.register("black_tea_leaf_crate", () -> {
            return new Block(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD));
        });
        COFFEE_CRATE = BLOCKS.register("coffee_bean_crate", () -> {
            return new Block(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD));
        });

        ADZUKI_CRATE = BLOCKS.register("adzuki_bean_crate", () -> {
            return new Block(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD));
        });
        VANILLA_CRATE = BLOCKS.register("dried_vanilla_pod_crate", () -> {
            return new Block(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD));
        });
        MINT_CRATE = BLOCKS.register("mint_leaf_crate", () -> {
            return new Block(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD));
        });
        ADZUKI_POWDER_BASKET = BLOCKS.register("adzuki_powder_basket", () -> {
            return new Block(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD));
        });
        VANILLA_POWDER_BASKET = BLOCKS.register("vanilla_powder_basket", () -> {
            return new Block(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD));
        });
        MINT_POWDER_BASKET = BLOCKS.register("mint_powder_basket", () -> {
            return new Block(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD));
        });
        WHITE_STRAWBERRY_ICE_CREAM_BLOCK = BLOCKS.register("white_strawberry_ice_cream_block", () -> {
            return new Block(BlockBehaviour.Properties.of(Material.SNOW).strength(0.2F, 0.2F).sound(SoundType.SNOW));
        });
        CARROT_CAKE = BLOCKS.register("carrot_cake", () -> {
            return new CompatFlavoredCakeBlock(FoodValues.CARROT_CAKE, Properties.CARROT_CAKE);
        });
        CARROT_CANDLE_CAKE = BLOCKS.register("carrot_candle_cake", () -> {
            return new CompatFlavoredCandleCakeBlock(CARROT_CAKE, Blocks.CANDLE, Properties.CARROT_CANDLE_CAKE);
        });
        WHITE_CARROT_CANDLE_CAKE = BLOCKS.register("white_carrot_candle_cake", () -> {
            return new CompatFlavoredCandleCakeBlock(CARROT_CAKE, Blocks.WHITE_CANDLE, Properties.CARROT_CANDLE_CAKE);
        });
        ORANGE_CARROT_CANDLE_CAKE = BLOCKS.register("orange_carrot_candle_cake", () -> {
            return new CompatFlavoredCandleCakeBlock(CARROT_CAKE, Blocks.ORANGE_CANDLE, Properties.CARROT_CANDLE_CAKE);
        });
        MAGENTA_CARROT_CANDLE_CAKE = BLOCKS.register("magenta_carrot_candle_cake", () -> {
            return new CompatFlavoredCandleCakeBlock(CARROT_CAKE, Blocks.MAGENTA_CANDLE, Properties.CARROT_CANDLE_CAKE);
        });
        LIGHT_BLUE_CARROT_CANDLE_CAKE = BLOCKS.register("light_blue_carrot_candle_cake", () -> {
            return new CompatFlavoredCandleCakeBlock(CARROT_CAKE, Blocks.LIGHT_BLUE_CANDLE, Properties.CARROT_CANDLE_CAKE);
        });
        YELLOW_CARROT_CANDLE_CAKE = BLOCKS.register("yellow_carrot_candle_cake", () -> {
            return new CompatFlavoredCandleCakeBlock(CARROT_CAKE, Blocks.YELLOW_CANDLE, Properties.CARROT_CANDLE_CAKE);
        });
        LIME_CARROT_CANDLE_CAKE = BLOCKS.register("lime_carrot_candle_cake", () -> {
            return new CompatFlavoredCandleCakeBlock(CARROT_CAKE, Blocks.LIME_CANDLE, Properties.CARROT_CANDLE_CAKE);
        });
        PINK_CARROT_CANDLE_CAKE = BLOCKS.register("pink_carrot_candle_cake", () -> {
            return new CompatFlavoredCandleCakeBlock(CARROT_CAKE, Blocks.PINK_CANDLE, Properties.CARROT_CANDLE_CAKE);
        });
        GRAY_CARROT_CANDLE_CAKE = BLOCKS.register("gray_carrot_candle_cake", () -> {
            return new CompatFlavoredCandleCakeBlock(CARROT_CAKE, Blocks.GRAY_CANDLE, Properties.CARROT_CANDLE_CAKE);
        });
        LIGHT_GRAY_CARROT_CANDLE_CAKE = BLOCKS.register("light_gray_carrot_candle_cake", () -> {
            return new CompatFlavoredCandleCakeBlock(CARROT_CAKE, Blocks.LIGHT_GRAY_CANDLE, Properties.CARROT_CANDLE_CAKE);
        });
        CYAN_CARROT_CANDLE_CAKE = BLOCKS.register("cyan_carrot_candle_cake", () -> {
            return new CompatFlavoredCandleCakeBlock(CARROT_CAKE, Blocks.CYAN_CANDLE, Properties.CARROT_CANDLE_CAKE);
        });
        PURPLE_CARROT_CANDLE_CAKE = BLOCKS.register("purple_carrot_candle_cake", () -> {
            return new CompatFlavoredCandleCakeBlock(CARROT_CAKE, Blocks.PURPLE_CANDLE, Properties.CARROT_CANDLE_CAKE);
        });
        BLUE_CARROT_CANDLE_CAKE = BLOCKS.register("blue_carrot_candle_cake", () -> {
            return new CompatFlavoredCandleCakeBlock(CARROT_CAKE, Blocks.BLUE_CANDLE, Properties.CARROT_CANDLE_CAKE);
        });
        BROWN_CARROT_CANDLE_CAKE = BLOCKS.register("brown_carrot_candle_cake", () -> {
            return new CompatFlavoredCandleCakeBlock(CARROT_CAKE, Blocks.BROWN_CANDLE, Properties.CARROT_CANDLE_CAKE);
        });
        GREEN_CARROT_CANDLE_CAKE = BLOCKS.register("green_carrot_candle_cake", () -> {
            return new CompatFlavoredCandleCakeBlock(CARROT_CAKE, Blocks.GREEN_CANDLE, Properties.CARROT_CANDLE_CAKE);
        });
        RED_CARROT_CANDLE_CAKE = BLOCKS.register("red_carrot_candle_cake", () -> {
            return new CompatFlavoredCandleCakeBlock(CARROT_CAKE, Blocks.RED_CANDLE, Properties.CARROT_CANDLE_CAKE);
        });
        BLACK_CARROT_CANDLE_CAKE = BLOCKS.register("black_carrot_candle_cake", () -> {
            return new CompatFlavoredCandleCakeBlock(CARROT_CAKE, Blocks.BLACK_CANDLE, Properties.CARROT_CANDLE_CAKE);
        });

    }

    static class Properties {
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
}