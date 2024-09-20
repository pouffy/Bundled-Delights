package com.pouffy.bundledelight.util.data.recipes;

import com.pouffy.bundledelight.util.data.builder.thermal.BottlingRecipeBuilder;
import com.pouffy.bundledelight.util.data.builder.thermal.SeparatorRecipeBuilder;
import com.sammy.minersdelight.MinersDelightMod;
import com.sammy.minersdelight.setup.MDItems;
import com.teamabnormals.neapolitan.core.registry.NeapolitanItems;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.Items;
import umpaz.farmersrespite.common.registry.FRItems;

import java.util.function.Consumer;

public class ThermalRecipes {
    /** In case of Mod ID changes, this is for bulk ID strings. */
    static String centralKitchen = "create_central_kitchen:";
    static String centralKitchenID = "create_central_kitchen";
    public ThermalRecipes() {
    }

    public static void register(Consumer<FinishedRecipe> consumer) {
        bottling(consumer);
        centrifuge(consumer);
    }

    private static void bottling(Consumer<FinishedRecipe> consumer) {
        //Miners Delight
        BottlingRecipeBuilder.thermalBottling(MDItems.WATER_CUP.get(), 1, MDItems.COPPER_CUP.get(), "minecraft:water", 1000, MinersDelightMod.MODID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(MDItems.MILK_CUP.get(), 1, MDItems.COPPER_CUP.get(), "forge:milk", 250, MinersDelightMod.MODID, true).build(consumer);

        //Create Central Kitchen
        //Neapolitan Ice Cream
        BottlingRecipeBuilder.thermalBottling(NeapolitanItems.ADZUKI_ICE_CREAM.get(), 1, Items.BOWL, centralKitchen + "adzuki_ice_cream", 500, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(NeapolitanItems.BANANA_ICE_CREAM.get(), 1, Items.BOWL, centralKitchen + "banana_ice_cream", 500, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(NeapolitanItems.CHOCOLATE_ICE_CREAM.get(), 1, Items.BOWL, centralKitchen + "chocolate_ice_cream", 500, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(NeapolitanItems.MINT_ICE_CREAM.get(), 1, Items.BOWL, centralKitchen + "mint_ice_cream", 500, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(NeapolitanItems.STRAWBERRY_ICE_CREAM.get(), 1, Items.BOWL, centralKitchen + "strawberry_ice_cream", 500, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(NeapolitanItems.VANILLA_ICE_CREAM.get(), 1, Items.BOWL, centralKitchen + "vanilla_ice_cream", 500, centralKitchenID, false).build(consumer);
        //Neapolitan Milkshakes
        BottlingRecipeBuilder.thermalBottling(NeapolitanItems.ADZUKI_MILKSHAKE.get(), 1, Items.GLASS_BOTTLE, centralKitchen + "adzuki_milkshake", 250, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(NeapolitanItems.BANANA_MILKSHAKE.get(), 1, Items.GLASS_BOTTLE, centralKitchen + "banana_milkshake", 250, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(NeapolitanItems.CHOCOLATE_MILKSHAKE.get(), 1, Items.GLASS_BOTTLE, centralKitchen + "chocolate_milkshake", 250, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(NeapolitanItems.MINT_MILKSHAKE.get(), 1, Items.GLASS_BOTTLE, centralKitchen + "mint_milkshake", 250, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(NeapolitanItems.STRAWBERRY_MILKSHAKE.get(), 1, Items.GLASS_BOTTLE, centralKitchen + "strawberry_milkshake", 250, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(NeapolitanItems.VANILLA_MILKSHAKE.get(), 1, Items.GLASS_BOTTLE, centralKitchen + "vanilla_milkshake", 250, centralKitchenID, false).build(consumer);
        //Farmer's Respite Drinks
        BottlingRecipeBuilder.thermalBottling(FRItems.BLACK_TEA.get(), 1, Items.GLASS_BOTTLE, centralKitchen + "black_tea", 250, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(FRItems.COFFEE.get(), 1, Items.GLASS_BOTTLE, centralKitchen + "coffee", 250, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(FRItems.DANDELION_TEA.get(), 1, Items.GLASS_BOTTLE, centralKitchen + "dandelion_tea", 250, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(FRItems.GREEN_TEA.get(), 1, Items.GLASS_BOTTLE, centralKitchen + "green_tea", 250, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(FRItems.LONG_APPLE_CIDER.get(), 1, Items.GLASS_BOTTLE, centralKitchen + "long_apple_cider", 250, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(FRItems.LONG_BLACK_TEA.get(), 1, Items.GLASS_BOTTLE, centralKitchen + "long_black_tea", 250, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(FRItems.LONG_COFFEE.get(), 1, Items.GLASS_BOTTLE, centralKitchen + "long_coffee", 250, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(FRItems.LONG_DANDELION_TEA.get(), 1, Items.GLASS_BOTTLE, centralKitchen + "long_dandelion_tea", 250, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(FRItems.LONG_GREEN_TEA.get(), 1, Items.GLASS_BOTTLE, centralKitchen + "long_green_tea", 250, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(FRItems.LONG_YELLOW_TEA.get(), 1, Items.GLASS_BOTTLE, centralKitchen + "long_yellow_tea", 250, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(FRItems.PURULENT_TEA.get(), 1, Items.GLASS_BOTTLE, centralKitchen + "purulent_tea", 250, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(FRItems.ROSE_HIP_TEA.get(), 1, Items.GLASS_BOTTLE, centralKitchen + "rose_hip_tea", 250, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(FRItems.STRONG_APPLE_CIDER.get(), 1, Items.GLASS_BOTTLE, centralKitchen + "strong_apple_cider", 250, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(FRItems.STRONG_BLACK_TEA.get(), 1, Items.GLASS_BOTTLE, centralKitchen + "strong_black_tea", 250, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(FRItems.STRONG_COFFEE.get(), 1, Items.GLASS_BOTTLE, centralKitchen + "strong_coffee", 250, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(FRItems.STRONG_GREEN_TEA.get(), 1, Items.GLASS_BOTTLE, centralKitchen + "strong_green_tea", 250, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(FRItems.STRONG_PURULENT_TEA.get(), 1, Items.GLASS_BOTTLE, centralKitchen + "strong_purulent_tea", 250, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(FRItems.STRONG_ROSE_HIP_TEA.get(), 1, Items.GLASS_BOTTLE, centralKitchen + "strong_rose_hip_tea", 250, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(FRItems.STRONG_YELLOW_TEA.get(), 1, Items.GLASS_BOTTLE, centralKitchen + "strong_yellow_tea", 250, centralKitchenID, false).build(consumer);
        BottlingRecipeBuilder.thermalBottling(FRItems.YELLOW_TEA.get(), 1, Items.GLASS_BOTTLE, centralKitchen + "yellow_tea", 250, centralKitchenID, false).build(consumer);
    }

    private static void centrifuge(Consumer<FinishedRecipe> consumer) {
        SeparatorRecipeBuilder.thermalSeparator(MDItems.WATER_CUP.get(), MDItems.COPPER_CUP.get(), 1, "minecraft:water", 1000, MinersDelightMod.MODID).build(consumer);
        //Create Central Kitchen
        //Neapolitan Ice Cream
        SeparatorRecipeBuilder.thermalSeparator(NeapolitanItems.ADZUKI_ICE_CREAM.get(), Items.BOWL, 1, centralKitchen + "adzuki_ice_cream", 500, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(NeapolitanItems.BANANA_ICE_CREAM.get(), Items.BOWL, 1, centralKitchen + "banana_ice_cream", 500, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(NeapolitanItems.CHOCOLATE_ICE_CREAM.get(), Items.BOWL, 1, centralKitchen + "chocolate_ice_cream", 500, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(NeapolitanItems.MINT_ICE_CREAM.get(), Items.BOWL, 1, centralKitchen + "mint_ice_cream", 500, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(NeapolitanItems.STRAWBERRY_ICE_CREAM.get(), Items.BOWL, 1, centralKitchen + "strawberry_ice_cream", 500, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(NeapolitanItems.VANILLA_ICE_CREAM.get(), Items.BOWL, 1, centralKitchen + "vanilla_ice_cream", 500, centralKitchenID).build(consumer);
        //Neapolitan Milkshakes
        SeparatorRecipeBuilder.thermalSeparator(NeapolitanItems.ADZUKI_MILKSHAKE.get(), Items.GLASS_BOTTLE, 1, centralKitchen + "adzuki_milkshake", 250, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(NeapolitanItems.BANANA_MILKSHAKE.get(), Items.GLASS_BOTTLE, 1, centralKitchen + "banana_milkshake", 250, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(NeapolitanItems.CHOCOLATE_MILKSHAKE.get(), Items.GLASS_BOTTLE, 1, centralKitchen + "chocolate_milkshake", 250, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(NeapolitanItems.MINT_MILKSHAKE.get(), Items.GLASS_BOTTLE, 1, centralKitchen + "mint_milkshake", 250, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(NeapolitanItems.STRAWBERRY_MILKSHAKE.get(), Items.GLASS_BOTTLE, 1, centralKitchen + "strawberry_milkshake", 250, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(NeapolitanItems.VANILLA_MILKSHAKE.get(), Items.GLASS_BOTTLE, 1, centralKitchen + "vanilla_milkshake", 250, centralKitchenID).build(consumer);
        //Farmer's Respite Drinks
        SeparatorRecipeBuilder.thermalSeparator(FRItems.BLACK_TEA.get(), Items.GLASS_BOTTLE, 1, centralKitchen + "black_tea", 250, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(FRItems.COFFEE.get(), Items.GLASS_BOTTLE, 1, centralKitchen + "coffee", 250, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(FRItems.DANDELION_TEA.get(), Items.GLASS_BOTTLE, 1, centralKitchen + "dandelion_tea", 250, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(FRItems.GREEN_TEA.get(), Items.GLASS_BOTTLE, 1, centralKitchen + "green_tea", 250, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(FRItems.LONG_APPLE_CIDER.get(), Items.GLASS_BOTTLE, 1, centralKitchen + "long_apple_cider", 250, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(FRItems.LONG_BLACK_TEA.get(), Items.GLASS_BOTTLE, 1, centralKitchen + "long_black_tea", 250, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(FRItems.LONG_COFFEE.get(), Items.GLASS_BOTTLE, 1, centralKitchen + "long_coffee", 250, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(FRItems.LONG_DANDELION_TEA.get(), Items.GLASS_BOTTLE, 1, centralKitchen + "long_dandelion_tea", 250, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(FRItems.LONG_GREEN_TEA.get(), Items.GLASS_BOTTLE, 1, centralKitchen + "long_green_tea", 250, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(FRItems.LONG_YELLOW_TEA.get(), Items.GLASS_BOTTLE, 1, centralKitchen + "long_yellow_tea", 250, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(FRItems.PURULENT_TEA.get(), Items.GLASS_BOTTLE, 1, centralKitchen + "purulent_tea", 250, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(FRItems.ROSE_HIP_TEA.get(), Items.GLASS_BOTTLE, 1, centralKitchen + "rose_hip_tea", 250, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(FRItems.STRONG_APPLE_CIDER.get(), Items.GLASS_BOTTLE, 1, centralKitchen + "strong_apple_cider", 250, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(FRItems.STRONG_BLACK_TEA.get(), Items.GLASS_BOTTLE, 1, centralKitchen + "strong_black_tea", 250, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(FRItems.STRONG_COFFEE.get(), Items.GLASS_BOTTLE, 1, centralKitchen + "strong_coffee", 250, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(FRItems.STRONG_GREEN_TEA.get(), Items.GLASS_BOTTLE, 1, centralKitchen + "strong_green_tea", 250, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(FRItems.STRONG_PURULENT_TEA.get(), Items.GLASS_BOTTLE, 1, centralKitchen + "strong_purulent_tea", 250, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(FRItems.STRONG_ROSE_HIP_TEA.get(), Items.GLASS_BOTTLE, 1, centralKitchen + "strong_rose_hip_tea", 250, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(FRItems.STRONG_YELLOW_TEA.get(), Items.GLASS_BOTTLE, 1, centralKitchen + "strong_yellow_tea", 250, centralKitchenID).build(consumer);
        SeparatorRecipeBuilder.thermalSeparator(FRItems.YELLOW_TEA.get(), Items.GLASS_BOTTLE, 1, centralKitchen + "yellow_tea", 250, centralKitchenID).build(consumer);
    }
}
