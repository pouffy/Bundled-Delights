package com.pouffy.bundledelight.compats.farmersrespite;

import com.farmersrespite.core.utility.FRFoods;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.item.DrinkableItem;

import static com.pouffy.bundledelight.compats.miners_delight.MinersCompat.cupFoodItem;
import static com.pouffy.bundledelight.compats.miners_delight.MinersCompat.cupFoodItemHidden;
import static com.pouffy.bundledelight.init.BDItems.basicItem;

public class RespiteMDItems {
    public static final DeferredRegister<Item> ITEMS;
    public static final RegistryObject<Item> CUP;

    public static final RegistryObject<Item> GREEN_TEA_CUP;
    public static final RegistryObject<Item> LONG_GREEN_TEA_CUP;
    public static final RegistryObject<Item> STRONG_GREEN_TEA_CUP;
    public static final RegistryObject<Item> YELLOW_TEA_CUP;
    public static final RegistryObject<Item> LONG_YELLOW_TEA_CUP;
    public static final RegistryObject<Item> STRONG_YELLOW_TEA_CUP;
    public static final RegistryObject<Item> BLACK_TEA_CUP;
    public static final RegistryObject<Item> LONG_BLACK_TEA_CUP;
    public static final RegistryObject<Item> STRONG_BLACK_TEA_CUP;
    public static final RegistryObject<Item> ROSE_HIP_TEA_CUP;
    public static final RegistryObject<Item> STRONG_ROSE_HIP_TEA_CUP;
    public static final RegistryObject<Item> DANDELION_TEA_CUP;
    public static final RegistryObject<Item> LONG_DANDELION_TEA_CUP;
    public static final RegistryObject<Item> PURULENT_TEA_CUP;
    public static final RegistryObject<Item> STRONG_PURULENT_TEA_CUP;
    public static final RegistryObject<Item> COFFEE_CUP;
    public static final RegistryObject<Item> LONG_COFFEE_CUP;
    public static final RegistryObject<Item> STRONG_COFFEE_CUP;
    public RespiteMDItems() {}

    static{
        ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "bundledelight");

        CUP = ITEMS.register("cup", () -> {
            return new Item(basicItem());
        });
        GREEN_TEA_CUP = ITEMS.register("green_tea_cup", () -> {
            return new DrinkableItem(cupFoodItem(FRFoods.GREEN_TEA), true, false);
        });
        LONG_GREEN_TEA_CUP = ITEMS.register("long_green_tea_cup", () -> {
            return new DrinkableItem(cupFoodItemHidden(FRFoods.LONG_GREEN_TEA), true, false);
        });
        STRONG_GREEN_TEA_CUP = ITEMS.register("strong_green_tea_cup", () -> {
            return new DrinkableItem(cupFoodItemHidden(FRFoods.STRONG_GREEN_TEA), true, false);
        });
        YELLOW_TEA_CUP = ITEMS.register("yellow_tea_cup", () -> {
            return new DrinkableItem(cupFoodItem(FRFoods.YELLOW_TEA), true, false);
        });
        LONG_YELLOW_TEA_CUP = ITEMS.register("long_yellow_tea_cup", () -> {
            return new DrinkableItem(cupFoodItemHidden(FRFoods.LONG_YELLOW_TEA), true, false);
        });
        STRONG_YELLOW_TEA_CUP = ITEMS.register("strong_yellow_tea_cup", () -> {
            return new DrinkableItem(cupFoodItemHidden(FRFoods.STRONG_YELLOW_TEA), true, false);
        });
        BLACK_TEA_CUP = ITEMS.register("black_tea_cup", () -> {
            return new DrinkableItem(cupFoodItem(FRFoods.BLACK_TEA), true, false);
        });
        LONG_BLACK_TEA_CUP = ITEMS.register("long_black_tea_cup", () -> {
            return new DrinkableItem(cupFoodItemHidden(FRFoods.LONG_BLACK_TEA), true, false);
        });
        STRONG_BLACK_TEA_CUP = ITEMS.register("strong_black_tea_cup", () -> {
            return new DrinkableItem(cupFoodItemHidden(FRFoods.STRONG_BLACK_TEA), true, false);
        });
        ROSE_HIP_TEA_CUP = ITEMS.register("rose_hip_tea_cup", () -> {
            return new DrinkableItem(cupFoodItem(FRFoods.ROSE_HIP_TEA), true, false);
        });
        STRONG_ROSE_HIP_TEA_CUP = ITEMS.register("strong_rose_hip_tea_cup", () -> {
            return new DrinkableItem(cupFoodItemHidden(FRFoods.STRONG_ROSE_HIP_TEA), true, false);
        });
        DANDELION_TEA_CUP = ITEMS.register("dandelion_tea_cup", () -> {
            return new DrinkableItem(cupFoodItem(FRFoods.DANDELION_TEA), true, false);
        });
        LONG_DANDELION_TEA_CUP = ITEMS.register("long_dandelion_tea_cup", () -> {
            return new DrinkableItem(cupFoodItemHidden(FRFoods.LONG_DANDELION_TEA), true, false);
        });
        PURULENT_TEA_CUP = ITEMS.register("purulent_tea_cup", () -> {
            return new DrinkableItem(cupFoodItem(FRFoods.PURULENT_TEA), true, false);
        });
        STRONG_PURULENT_TEA_CUP = ITEMS.register("strong_purulent_tea_cup", () -> {
            return new DrinkableItem(cupFoodItemHidden(FRFoods.STRONG_PURULENT_TEA), true, false);
        });
        COFFEE_CUP = ITEMS.register("coffee_cup", () -> {
            return new DrinkableItem(cupFoodItem(FRFoods.COFFEE), true, false);
        });
        STRONG_COFFEE_CUP = ITEMS.register("strong_coffee_cup", () -> {
            return new DrinkableItem(cupFoodItemHidden(FRFoods.STRONG_COFFEE), true, false);
        });
        LONG_COFFEE_CUP = ITEMS.register("long_coffee_cup", () -> {
            return new DrinkableItem(cupFoodItemHidden(FRFoods.LONG_COFFEE), true, false);
        });
    }
}
