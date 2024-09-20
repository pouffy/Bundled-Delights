package com.pouffydev.bundledelight.compat.neapolitan;

import com.pouffydev.bundledelight.init.BDBlocks;
import com.teamabnormals.neapolitan.common.item.HealingDrinkItem;
import com.teamabnormals.neapolitan.common.item.MilkshakeItem;
import com.teamabnormals.neapolitan.core.registry.NeapolitanItems;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.pouffydev.bundledelight.foundation.util.ItemRegistryUtils.*;
public class NeapolitanCompatItems {
    public static final DeferredRegister<Item> ITEMS;
    public static final RegistryObject<Item> POWDERED_VANILLA_PODS;
    public static final RegistryObject<Item> POWDERED_MINT_LEAVES;
    public static final RegistryObject<Item> POWDERED_ADZUKI_BEANS;
    public static final RegistryObject<Item> ADZUKI_CRATE;
    public static final RegistryObject<Item> MINT_CRATE;
    public static final RegistryObject<Item> VANILLA_CRATE;
    public static final RegistryObject<Item> ADZUKI_POWDER_CRATE;
    public static final RegistryObject<Item> MINT_POWDER_CRATE;
    public static final RegistryObject<Item> VANILLA_POWDER_CRATE;
    public static final RegistryObject<Item> STRAWBERRY_CAKE;
    public static final RegistryObject<Item> WHITE_STRAWBERRY_ICE_CREAM;
    public static final RegistryObject<Item> WHITE_STRAWBERRY_MILKSHAKE;
    public static final RegistryObject<Item> WHITE_STRAWBERRY_ICE_CREAM_BLOCK;
    public NeapolitanCompatItems(){
    }
    static {
        ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "bundledelight");
        POWDERED_VANILLA_PODS = ITEMS.register("powdered_vanilla_pods", () -> {
            return new Item(basicItem());
        });
        POWDERED_MINT_LEAVES = ITEMS.register("powdered_mint_leaves", () -> {
            return new Item(basicItem());
        });
        POWDERED_ADZUKI_BEANS = ITEMS.register("powdered_adzuki_beans", () -> {
            return new Item(basicItem());
        });
        ADZUKI_CRATE = ITEMS.register("adzuki_bean_crate", () -> {
            return new BlockItem((Block) BDBlocks.ADZUKI_CRATE.get(), basicItem());
        });
        MINT_CRATE = ITEMS.register("mint_leaf_crate", () -> {
            return new BlockItem((Block) BDBlocks.MINT_CRATE.get(), basicItem());
        });
        VANILLA_CRATE = ITEMS.register("dried_vanilla_pod_crate", () -> {
            return new BlockItem((Block) BDBlocks.VANILLA_CRATE.get(), basicItem());
        });
        ADZUKI_POWDER_CRATE = ITEMS.register("adzuki_powder_basket", () -> {
            return new BlockItem((Block) BDBlocks.ADZUKI_POWDER_BASKET.get(), basicItem());
        });
        MINT_POWDER_CRATE = ITEMS.register("mint_powder_basket", () -> {
            return new BlockItem((Block) BDBlocks.MINT_POWDER_BASKET.get(), basicItem());
        });
        VANILLA_POWDER_CRATE = ITEMS.register("vanilla_powder_basket", () -> {
            return new BlockItem((Block) BDBlocks.VANILLA_POWDER_BASKET.get(), basicItem());
        });
        STRAWBERRY_CAKE = ITEMS.register("white_strawberry_cake", () -> {
            return new BlockItem((Block) NeapolitanCompatBlocks.STRAWBERRY_CAKE.get(), singleItem());
        });
        WHITE_STRAWBERRY_ICE_CREAM = ITEMS.register("white_strawberry_ice_cream", () -> {
            return new HealingDrinkItem(3.0F, bowlFoodItem(NeapolitanItems.NeapolitanFoods.STRAWBERRY_ICE_CREAM));
        });
        WHITE_STRAWBERRY_MILKSHAKE = ITEMS.register("white_strawberry_milkshake", () -> {
            return new MilkshakeItem(bowlFoodItem(NeapolitanItems.NeapolitanFoods.STRAWBERRY_MILKSHAKE));
        });
        WHITE_STRAWBERRY_ICE_CREAM_BLOCK = ITEMS.register("white_strawberry_ice_cream_block", () -> {
            return new BlockItem((Block) BDBlocks.WHITE_STRAWBERRY_ICE_CREAM_BLOCK.get(), basicItem());
        });
    }
}
