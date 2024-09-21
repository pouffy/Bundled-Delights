package com.pouffydev.bundledelight.foundation.util.data.recipes;

import com.pouffydev.bundledelight.compat.farmersrespite.RespiteMDCompatItems;
import com.pouffydev.bundledelight.foundation.util.data.FinishedData;
import com.pouffydev.bundledelight.foundation.util.data.builder.thermal.BottlingRecipeBuilder;
import com.pouffydev.bundledelight.foundation.util.data.builder.thermal.SeparatorRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.function.Consumer;

import static com.pouffydev.bundledelight.foundation.util.CommonUtil.*;

public class ThermalRecipes {
    /** In case of Mod ID changes, this is for bulk ID strings. */
    static String centralKitchen = "create_central_kitchen:";
    static String centralKitchenID = "create_central_kitchen";
    
    static Item copperCup = fromMD("copper_cup");
    static Item waterCup = fromMD("water_cup");
    static Item milkCup = fromMD("milk_cup");
    static Item glassBottle = Items.GLASS_BOTTLE;
    static Item bowl = Items.BOWL;
    public ThermalRecipes() {
    }

    public static void register(Consumer<FinishedData> consumer) {
        bottling(consumer);
        centrifuge(consumer);
    }

    private static void bottling(Consumer<FinishedData> consumer) {
        //Miners Delight
        BottlingRecipeBuilder.thermalBottling(waterCup, 1, copperCup, "minecraft:water", 1000, "miners_delight", false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(milkCup, 1, copperCup, "forge:milk", 250, "miners_delight", true).build(consumer);

        //Create Central Kitchen
        //Neapolitan Ice Cream
        BottlingRecipeBuilder.thermalBottling(fromN("ADZUKI_ICE_CREAM"), 1, bowl, centralKitchen + "adzuki_ice_cream", 500, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(fromN("BANANA_ICE_CREAM"), 1, bowl, centralKitchen + "banana_ice_cream", 500, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(fromN("CHOCOLATE_ICE_CREAM"), 1, bowl, centralKitchen + "chocolate_ice_cream", 500, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(fromN("MINT_ICE_CREAM"), 1, bowl, centralKitchen + "mint_ice_cream", 500, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(fromN("STRAWBERRY_ICE_CREAM"), 1, bowl, centralKitchen + "strawberry_ice_cream", 500, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(fromN("VANILLA_ICE_CREAM"), 1, bowl, centralKitchen + "vanilla_ice_cream", 500, centralKitchenID, false).build(consumer);
        //Neapolitan Milkshakes
        BottlingRecipeBuilder.thermalBottling(fromN("ADZUKI_MILKSHAKE"), 1, glassBottle, centralKitchen + "adzuki_milkshake", 250, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(fromN("BANANA_MILKSHAKE"), 1, glassBottle, centralKitchen + "banana_milkshake", 250, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(fromN("CHOCOLATE_MILKSHAKE"), 1, glassBottle, centralKitchen + "chocolate_milkshake", 250, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(fromN("MINT_MILKSHAKE"), 1, glassBottle, centralKitchen + "mint_milkshake", 250, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(fromN("STRAWBERRY_MILKSHAKE"), 1, glassBottle, centralKitchen + "strawberry_milkshake", 250, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(fromN("VANILLA_MILKSHAKE"), 1, glassBottle, centralKitchen + "vanilla_milkshake", 250, centralKitchenID, false).build(consumer);
        //Farmer's Respite Drinks
        BottlingRecipeBuilder.thermalBottling(fromFR("BLACK_TEA"), 1, glassBottle, centralKitchen + "black_tea", 250, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(fromFR("COFFEE"), 1, glassBottle, centralKitchen + "coffee", 250, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(fromFR("DANDELION_TEA"), 1, glassBottle, centralKitchen + "dandelion_tea", 250, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(fromFR("GREEN_TEA"), 1, glassBottle, centralKitchen + "green_tea", 250, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(fromFR("LONG_APPLE_CIDER"), 1, glassBottle, centralKitchen + "long_apple_cider", 250, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(fromFR("LONG_BLACK_TEA"), 1, glassBottle, centralKitchen + "long_black_tea", 250, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(fromFR("LONG_COFFEE"), 1, glassBottle, centralKitchen + "long_coffee", 250, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(fromFR("LONG_DANDELION_TEA"), 1, glassBottle, centralKitchen + "long_dandelion_tea", 250, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(fromFR("LONG_GREEN_TEA"), 1, glassBottle, centralKitchen + "long_green_tea", 250, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(fromFR("LONG_YELLOW_TEA"), 1, glassBottle, centralKitchen + "long_yellow_tea", 250, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(fromFR("PURULENT_TEA"), 1, glassBottle, centralKitchen + "purulent_tea", 250, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(fromFR("ROSE_HIP_TEA"), 1, glassBottle, centralKitchen + "rose_hip_tea", 250, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(fromFR("STRONG_APPLE_CIDER"), 1, glassBottle, centralKitchen + "strong_apple_cider", 250, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(fromFR("STRONG_BLACK_TEA"), 1, glassBottle, centralKitchen + "strong_black_tea", 250, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(fromFR("STRONG_COFFEE"), 1, glassBottle, centralKitchen + "strong_coffee", 250, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(fromFR("STRONG_GREEN_TEA"), 1, glassBottle, centralKitchen + "strong_green_tea", 250, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(fromFR("STRONG_PURULENT_TEA"), 1, glassBottle, centralKitchen + "strong_purulent_tea", 250, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(fromFR("STRONG_ROSE_HIP_TEA"), 1, glassBottle, centralKitchen + "strong_rose_hip_tea", 250, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(fromFR("STRONG_YELLOW_TEA"), 1, glassBottle, centralKitchen + "strong_yellow_tea", 250, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(fromFR("YELLOW_TEA"), 1, glassBottle, centralKitchen + "yellow_tea", 250, centralKitchenID, false).build(consumer);
        //Farmer's Respite Drinks (Cups)
        BottlingRecipeBuilder.thermalBottling(RespiteMDCompatItems.BLACK_TEA_CUP.get(), 1, copperCup, centralKitchen + "black_tea", 250, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(RespiteMDCompatItems.COFFEE_CUP.get(), 1, copperCup, centralKitchen + "coffee", 250, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(RespiteMDCompatItems.DANDELION_TEA_CUP.get(), 1, copperCup, centralKitchen + "dandelion_tea", 250, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(RespiteMDCompatItems.GREEN_TEA_CUP.get(), 1, copperCup, centralKitchen + "green_tea", 250, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(RespiteMDCompatItems.LONG_BLACK_TEA_CUP.get(), 1, copperCup, centralKitchen + "long_black_tea", 250, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(RespiteMDCompatItems.LONG_DANDELION_TEA_CUP.get(), 1, copperCup, centralKitchen + "long_dandelion_tea", 250, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(RespiteMDCompatItems.LONG_GREEN_TEA_CUP.get(), 1, copperCup, centralKitchen + "long_green_tea", 250, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(RespiteMDCompatItems.LONG_YELLOW_TEA_CUP.get(), 1, copperCup, centralKitchen + "long_yellow_tea", 250, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(RespiteMDCompatItems.PURULENT_TEA_CUP.get(), 1, copperCup, centralKitchen + "purulent_tea", 250, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(RespiteMDCompatItems.ROSE_HIP_TEA_CUP.get(), 1, copperCup, centralKitchen + "rose_hip_tea", 250, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(RespiteMDCompatItems.STRONG_BLACK_TEA_CUP.get(), 1, copperCup, centralKitchen + "strong_black_tea", 250, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(RespiteMDCompatItems.STRONG_COFFEE_CUP.get(), 1, copperCup, centralKitchen + "strong_coffee", 250, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(RespiteMDCompatItems.STRONG_GREEN_TEA_CUP.get(), 1, copperCup, centralKitchen + "strong_green_tea", 250, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(RespiteMDCompatItems.STRONG_PURULENT_TEA_CUP.get(), 1, copperCup, centralKitchen + "strong_purulent_tea", 250, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(RespiteMDCompatItems.STRONG_ROSE_HIP_TEA_CUP.get(), 1, copperCup, centralKitchen + "strong_rose_hip_tea", 250, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(RespiteMDCompatItems.STRONG_YELLOW_TEA_CUP.get(), 1, copperCup, centralKitchen + "strong_yellow_tea", 250, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(RespiteMDCompatItems.YELLOW_TEA_CUP.get(), 1, copperCup, centralKitchen + "yellow_tea", 250, centralKitchenID, false).build(consumer);
    }

    private static void centrifuge(Consumer<FinishedData> consumer) {
        SeparatorRecipeBuilder.thermalSeparator(waterCup, copperCup, 1, "minecraft:water", 1000, "miners_delight").build(consumer);
        //Create Central Kitchen
        //Neapolitan Ice Cream
        SeparatorRecipeBuilder.thermalSeparator(fromN("ADZUKI_ICE_CREAM"), bowl, 1, centralKitchen + "adzuki_ice_cream", 500, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(fromN("BANANA_ICE_CREAM"), bowl, 1, centralKitchen + "banana_ice_cream", 500, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(fromN("CHOCOLATE_ICE_CREAM"), bowl, 1, centralKitchen + "chocolate_ice_cream", 500, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(fromN("MINT_ICE_CREAM"), bowl, 1, centralKitchen + "mint_ice_cream", 500, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(fromN("STRAWBERRY_ICE_CREAM"), bowl, 1, centralKitchen + "strawberry_ice_cream", 500, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(fromN("VANILLA_ICE_CREAM"), bowl, 1, centralKitchen + "vanilla_ice_cream", 500, centralKitchenID).build(consumer);
        //Neapolitan Milkshakes
        SeparatorRecipeBuilder.thermalSeparator(fromN("ADZUKI_MILKSHAKE"), glassBottle, 1, centralKitchen + "adzuki_milkshake", 250, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(fromN("BANANA_MILKSHAKE"), glassBottle, 1, centralKitchen + "banana_milkshake", 250, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(fromN("CHOCOLATE_MILKSHAKE"), glassBottle, 1, centralKitchen + "chocolate_milkshake", 250, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(fromN("MINT_MILKSHAKE"), glassBottle, 1, centralKitchen + "mint_milkshake", 250, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(fromN("STRAWBERRY_MILKSHAKE"), glassBottle, 1, centralKitchen + "strawberry_milkshake", 250, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(fromN("VANILLA_MILKSHAKE"), glassBottle, 1, centralKitchen + "vanilla_milkshake", 250, centralKitchenID).build(consumer);
        //Farmer's Respite Drinks
        SeparatorRecipeBuilder.thermalSeparator(fromFR("BLACK_TEA"), glassBottle, 1, centralKitchen + "black_tea", 250, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(fromFR("COFFEE"), glassBottle, 1, centralKitchen + "coffee", 250, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(fromFR("DANDELION_TEA"), glassBottle, 1, centralKitchen + "dandelion_tea", 250, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(fromFR("GREEN_TEA"), glassBottle, 1, centralKitchen + "green_tea", 250, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(fromFR("LONG_APPLE_CIDER"), glassBottle, 1, centralKitchen + "long_apple_cider", 250, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(fromFR("LONG_BLACK_TEA"), glassBottle, 1, centralKitchen + "long_black_tea", 250, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(fromFR("LONG_COFFEE"), glassBottle, 1, centralKitchen + "long_coffee", 250, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(fromFR("LONG_DANDELION_TEA"), glassBottle, 1, centralKitchen + "long_dandelion_tea", 250, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(fromFR("LONG_GREEN_TEA"), glassBottle, 1, centralKitchen + "long_green_tea", 250, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(fromFR("LONG_YELLOW_TEA"), glassBottle, 1, centralKitchen + "long_yellow_tea", 250, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(fromFR("PURULENT_TEA"), glassBottle, 1, centralKitchen + "purulent_tea", 250, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(fromFR("ROSE_HIP_TEA"), glassBottle, 1, centralKitchen + "rose_hip_tea", 250, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(fromFR("STRONG_APPLE_CIDER"), glassBottle, 1, centralKitchen + "strong_apple_cider", 250, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(fromFR("STRONG_BLACK_TEA"), glassBottle, 1, centralKitchen + "strong_black_tea", 250, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(fromFR("STRONG_COFFEE"), glassBottle, 1, centralKitchen + "strong_coffee", 250, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(fromFR("STRONG_GREEN_TEA"), glassBottle, 1, centralKitchen + "strong_green_tea", 250, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(fromFR("STRONG_PURULENT_TEA"), glassBottle, 1, centralKitchen + "strong_purulent_tea", 250, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(fromFR("STRONG_ROSE_HIP_TEA"), glassBottle, 1, centralKitchen + "strong_rose_hip_tea", 250, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(fromFR("STRONG_YELLOW_TEA"), glassBottle, 1, centralKitchen + "strong_yellow_tea", 250, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(fromFR("YELLOW_TEA"), glassBottle, 1, centralKitchen + "yellow_tea", 250, centralKitchenID).build(consumer);
        //Farmer's Respite Drinks (Cups)
        SeparatorRecipeBuilder.thermalSeparator(RespiteMDCompatItems.BLACK_TEA_CUP.get(), copperCup, 1, centralKitchen + "black_tea", 250, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(RespiteMDCompatItems.COFFEE_CUP.get(), copperCup, 1, centralKitchen + "coffee", 250, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(RespiteMDCompatItems.DANDELION_TEA_CUP.get(), copperCup, 1, centralKitchen + "dandelion_tea", 250, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(RespiteMDCompatItems.GREEN_TEA_CUP.get(), copperCup, 1, centralKitchen + "green_tea", 250, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(RespiteMDCompatItems.LONG_BLACK_TEA_CUP.get(), copperCup, 1, centralKitchen + "long_black_tea", 250, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(RespiteMDCompatItems.LONG_COFFEE_CUP.get(), copperCup, 1, centralKitchen + "long_coffee", 250, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(RespiteMDCompatItems.LONG_DANDELION_TEA_CUP.get(), copperCup, 1, centralKitchen + "long_dandelion_tea", 250, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(RespiteMDCompatItems.LONG_GREEN_TEA_CUP.get(), copperCup, 1, centralKitchen + "long_green_tea", 250, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(RespiteMDCompatItems.LONG_YELLOW_TEA_CUP.get(), copperCup, 1, centralKitchen + "long_yellow_tea", 250, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(RespiteMDCompatItems.PURULENT_TEA_CUP.get(), copperCup, 1, centralKitchen + "purulent_tea", 250, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(RespiteMDCompatItems.ROSE_HIP_TEA_CUP.get(), copperCup, 1, centralKitchen + "rose_hip_tea", 250, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(RespiteMDCompatItems.STRONG_BLACK_TEA_CUP.get(), copperCup, 1, centralKitchen + "strong_black_tea", 250, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(RespiteMDCompatItems.STRONG_COFFEE_CUP.get(), copperCup, 1, centralKitchen + "strong_coffee", 250, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(RespiteMDCompatItems.STRONG_GREEN_TEA_CUP.get(), copperCup, 1, centralKitchen + "strong_green_tea", 250, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(RespiteMDCompatItems.STRONG_PURULENT_TEA_CUP.get(), copperCup, 1, centralKitchen + "strong_purulent_tea", 250, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(RespiteMDCompatItems.STRONG_ROSE_HIP_TEA_CUP.get(), copperCup, 1, centralKitchen + "strong_rose_hip_tea", 250, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(RespiteMDCompatItems.STRONG_YELLOW_TEA_CUP.get(), copperCup, 1, centralKitchen + "strong_yellow_tea", 250, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(RespiteMDCompatItems.YELLOW_TEA_CUP.get(), copperCup, 1, centralKitchen + "yellow_tea", 250, centralKitchenID).build(consumer);
    }
}
