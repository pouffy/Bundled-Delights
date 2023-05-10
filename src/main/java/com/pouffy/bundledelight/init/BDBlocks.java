package com.pouffy.bundledelight.init;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Material;
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
    }
}