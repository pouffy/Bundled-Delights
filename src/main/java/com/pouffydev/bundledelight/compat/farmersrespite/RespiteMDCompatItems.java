package com.pouffydev.bundledelight.compat.farmersrespite;

import com.pouffydev.bundledelight.compat.item.CompatEffectDrink;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import umpaz.farmersrespite.common.FRFoodValues;

import static com.pouffydev.bundledelight.foundation.util.ItemRegistryUtils.*;

public class RespiteMDCompatItems {
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
    
    public RespiteMDCompatItems() {}
    static String respite = "farmersrespite";
    static String miners = "miners_delight";

    static{
        ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "bundledelight");

        CUP = ITEMS.register("cup", () -> {
            return new Item(basicItem());
        });
        GREEN_TEA_CUP = ITEMS.register("green_tea_cup", () -> {
            return new CompatEffectDrink(compatEffectDrink(), FRFoodValues.GREEN_TEA, respite);
        });
        LONG_GREEN_TEA_CUP = ITEMS.register("long_green_tea_cup", () -> {
            return new CompatEffectDrink(compatEffectDrink(), FRFoodValues.LONG_GREEN_TEA, respite, true);
        });
        STRONG_GREEN_TEA_CUP = ITEMS.register("strong_green_tea_cup", () -> {
            return new CompatEffectDrink(compatEffectDrink(), FRFoodValues.STRONG_GREEN_TEA, respite, true);
        });
        YELLOW_TEA_CUP = ITEMS.register("yellow_tea_cup", () -> {
            return new CompatEffectDrink(compatEffectDrink(), FRFoodValues.YELLOW_TEA, respite);
        });
        LONG_YELLOW_TEA_CUP = ITEMS.register("long_yellow_tea_cup", () -> {
            return new CompatEffectDrink(compatEffectDrink(), FRFoodValues.LONG_YELLOW_TEA, respite, true);
        });
        STRONG_YELLOW_TEA_CUP = ITEMS.register("strong_yellow_tea_cup", () -> {
            return new CompatEffectDrink(compatEffectDrink(), FRFoodValues.STRONG_YELLOW_TEA, respite, true);
        });
        BLACK_TEA_CUP = ITEMS.register("black_tea_cup", () -> {
            return new CompatEffectDrink(compatEffectDrink(), FRFoodValues.BLACK_TEA, respite);
        });
        LONG_BLACK_TEA_CUP = ITEMS.register("long_black_tea_cup", () -> {
            return new CompatEffectDrink(compatEffectDrink(), FRFoodValues.LONG_BLACK_TEA, respite, true);
        });
        STRONG_BLACK_TEA_CUP = ITEMS.register("strong_black_tea_cup", () -> {
            return new CompatEffectDrink(compatEffectDrink(), FRFoodValues.STRONG_BLACK_TEA, respite, true);
        });
        ROSE_HIP_TEA_CUP = ITEMS.register("rose_hip_tea_cup", () -> {
            return new CompatEffectDrink(compatEffectDrink(), FRFoodValues.ROSE_HIP_TEA, respite);
        });
        STRONG_ROSE_HIP_TEA_CUP = ITEMS.register("strong_rose_hip_tea_cup", () -> {
            return new CompatEffectDrink(compatEffectDrink(), FRFoodValues.STRONG_ROSE_HIP_TEA, respite, true);
        });
        DANDELION_TEA_CUP = ITEMS.register("dandelion_tea_cup", () -> {
            return new CompatEffectDrink(compatEffectDrink(), FRFoodValues.DANDELION_TEA, respite);
        });
        LONG_DANDELION_TEA_CUP = ITEMS.register("long_dandelion_tea_cup", () -> {
            return new CompatEffectDrink(compatEffectDrink(), FRFoodValues.LONG_DANDELION_TEA, respite, true);
        });
        PURULENT_TEA_CUP = ITEMS.register("purulent_tea_cup", () -> {
            return new CompatEffectDrink(compatEffectDrink(), FRFoodValues.PURULENT_TEA, respite);
        });
        STRONG_PURULENT_TEA_CUP = ITEMS.register("long_purulent_tea_cup", () -> {
            return new CompatEffectDrink(compatEffectDrink(), FRFoodValues.LONG_PURULENT_TEA, respite, true);
        });
        COFFEE_CUP = ITEMS.register("coffee_cup", () -> {
            return new CompatEffectDrink(compatEffectDrink(), FRFoodValues.COFFEE, respite);
        });
        STRONG_COFFEE_CUP = ITEMS.register("strong_coffee_cup", () -> {
            return new CompatEffectDrink(compatEffectDrink(), FRFoodValues.STRONG_COFFEE, respite, true);
        });
        LONG_COFFEE_CUP = ITEMS.register("long_coffee_cup", () -> {
            return new CompatEffectDrink(compatEffectDrink(), FRFoodValues.LONG_COFFEE, respite, true);
        });
    }
}
