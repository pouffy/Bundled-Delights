package com.pouffydev.bundledelight.datagen;

import com.pouffydev.bundledelight.datagen.builder.recipe.BundleShapedRecipeBuilder;
import com.pouffydev.bundledelight.datagen.builder.recipe.BundleShapelessRecipeBuilder;
import com.pouffydev.bundledelight.datagen.builder.recipe.KegRecipeBuilder;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import vectorwing.farmersdelight.common.tag.ForgeTags;

public class RecipeShortcuts {
    public static BundleShapedRecipeBuilder compact9x9(ItemLike result, ItemLike ingredient, String bundleName) {
        return BundleShapedRecipeBuilder.shaped(result, bundleName)
                .pattern("iii")
                .pattern("iii")
                .pattern("iii")
                .define('i', ingredient)
                .unlockedBy("has_ingredient", InventoryChangeTrigger.TriggerInstance.hasItems(ingredient));
    }

    public static BundleShapedRecipeBuilder cake(ItemLike result, ItemLike ingredient, String bundleName) {
        return BundleShapedRecipeBuilder.shaped(result, bundleName)
                .pattern("mcm")
                .pattern("ses")
                .pattern("wcw")
                .define('m', ForgeTags.MILK)
                .define('s', Items.SUGAR)
                .define('c', ingredient)
                .define('e', Items.EGG)
                .define('w', Items.WHEAT)
                .unlockedBy("has_ingredient", InventoryChangeTrigger.TriggerInstance.hasItems(ingredient));
    }

    public static BundleShapelessRecipeBuilder compactCakeFromSlices(ItemLike result, ItemLike ingredient, String bundleName) {
        return BundleShapelessRecipeBuilder.shapeless(result, bundleName)
                .requires(ingredient)
                .requires(ingredient)
                .requires(ingredient)
                .requires(ingredient)
                .requires(ingredient)
                .requires(ingredient)
                .requires(ingredient)
                .unlockedBy("has_cake_slice", InventoryChangeTrigger.TriggerInstance.hasItems(ingredient));
    }

    public static BundleShapelessRecipeBuilder juice(ItemLike result, ItemLike ingredient, String bundleName) {
        return BundleShapelessRecipeBuilder.shapeless(result, bundleName)
                .requires(ingredient)
                .requires(ingredient)
                .requires(ingredient)
                .requires(ingredient)
                .requires(Items.SUGAR)
                .requires(Items.GLASS_BOTTLE)
                .unlockedBy("has_ingredient", InventoryChangeTrigger.TriggerInstance.hasItems(ingredient));
    }
}
