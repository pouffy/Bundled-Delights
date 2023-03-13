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
    }
}