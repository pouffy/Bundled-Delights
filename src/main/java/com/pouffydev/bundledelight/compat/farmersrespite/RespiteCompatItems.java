package com.pouffydev.bundledelight.compat.farmersrespite;

import com.pouffydev.bundledelight.init.BDBlocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.pouffydev.bundledelight.foundation.util.ItemRegistryUtils.*;
public class RespiteCompatItems {
    public static final DeferredRegister<Item> ITEMS;
    public static final RegistryObject<Item> GREEN_TEA_POWDER_BASKET;
    public static final RegistryObject<Item> YELLOW_TEA_POWDER_BASKET;
    public static final RegistryObject<Item> BLACK_TEA_POWDER_BASKET;
    public static final RegistryObject<Item> COFFEE_POWDER_BASKET;
    public static final RegistryObject<Item> GREEN_TEA_CRATE;
    public static final RegistryObject<Item> YELLOW_TEA_CRATE;
    public static final RegistryObject<Item> BLACK_TEA_CRATE;
    public static final RegistryObject<Item> COFFEE_CRATE;
    public static final RegistryObject<Item> POWDERED_GREEN_TEA_LEAVES;
    public static final RegistryObject<Item> POWDERED_YELLOW_TEA_LEAVES;
    public static final RegistryObject<Item> POWDERED_BLACK_TEA_LEAVES;
    public static final RegistryObject<Item> POWDERED_COFFEE_BEANS;
    public RespiteCompatItems(){
    }
    static {
        ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "bundledelight");

        GREEN_TEA_POWDER_BASKET = ITEMS.register("green_tea_powder_basket", () -> {
            return new BlockItem((Block) BDBlocks.GREEN_TEA_POWDER_BASKET.get(), basicItem());
        });
        YELLOW_TEA_POWDER_BASKET = ITEMS.register("yellow_tea_powder_basket", () -> {
            return new BlockItem((Block) BDBlocks.YELLOW_TEA_POWDER_BASKET.get(), basicItem());
        });
        BLACK_TEA_POWDER_BASKET = ITEMS.register("black_tea_powder_basket", () -> {
            return new BlockItem((Block) BDBlocks.BLACK_TEA_POWDER_BASKET.get(), basicItem());
        });
        COFFEE_POWDER_BASKET = ITEMS.register("coffee_powder_basket", () -> {
            return new BlockItem((Block) BDBlocks.COFFEE_POWDER_BASKET.get(), basicItem());
        });

        GREEN_TEA_CRATE = ITEMS.register("green_tea_leaf_crate", () -> {
            return new BlockItem((Block) BDBlocks.GREEN_TEA_CRATE.get(), basicItem());
        });
        YELLOW_TEA_CRATE = ITEMS.register("yellow_tea_leaf_crate", () -> {
            return new BlockItem((Block) BDBlocks.YELLOW_TEA_CRATE.get(), basicItem());
        });
        BLACK_TEA_CRATE = ITEMS.register("black_tea_leaf_crate", () -> {
            return new BlockItem((Block) BDBlocks.BLACK_TEA_CRATE.get(), basicItem());
        });
        COFFEE_CRATE = ITEMS.register("coffee_bean_crate", () -> {
            return new BlockItem((Block) BDBlocks.COFFEE_CRATE.get(), basicItem());
        });

        POWDERED_GREEN_TEA_LEAVES = ITEMS.register("powdered_green_tea_leaves", () -> {
            return new Item(basicItem());
        });
        POWDERED_YELLOW_TEA_LEAVES = ITEMS.register("powdered_yellow_tea_leaves", () -> {
            return new Item(basicItem());
        });
        POWDERED_BLACK_TEA_LEAVES = ITEMS.register("powdered_black_tea_leaves", () -> {
            return new Item(basicItem());
        });
        POWDERED_COFFEE_BEANS = ITEMS.register("powdered_coffee_beans", () -> {
            return new Item(basicItem());
        });


    }
}
