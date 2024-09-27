package com.pouffydev.bundledelight.datagen;

import com.pouffydev.bundledelight.datagen.builder.recipe.BundleShapedRecipeBuilder;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.world.level.ItemLike;

public class RecipeShortcuts {
    public static BundleShapedRecipeBuilder compact9x9(ItemLike result, ItemLike ingredient, String bundleName) {
        return BundleShapedRecipeBuilder.shaped(result, bundleName)
                .pattern("iii")
                .pattern("iii")
                .pattern("iii")
                .define('i', ingredient)
                .unlockedBy("has_ingredient", InventoryChangeTrigger.TriggerInstance.hasItems(ingredient));
    }
}
