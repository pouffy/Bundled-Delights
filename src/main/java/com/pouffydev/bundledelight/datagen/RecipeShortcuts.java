package com.pouffydev.bundledelight.datagen;

import com.pouffydev.bundledelight.datagen.builder.recipe.BundleShapedRecipeBuilder;
import com.pouffydev.bundledelight.datagen.builder.recipe.BundleShapelessRecipeBuilder;
import com.pouffydev.bundledelight.datagen.builder.recipe.CreateProcessingRecipeBuilder;
import com.pouffydev.bundledelight.datagen.builder.recipe.CuttingBoardRecipeBuilder;
import com.pouffydev.bundledelight.foundation.data.BundleRecipeGen;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import vectorwing.farmersdelight.common.tag.ForgeTags;
import vectorwing.farmersdelight.common.tag.ModTags;

import java.util.List;

public class RecipeShortcuts {
    public static BundleShapedRecipeBuilder compact3x3(ItemLike result, ItemLike ingredient, String bundleName) {
        return BundleShapedRecipeBuilder.shaped(result, bundleName)
                .pattern("iii")
                .pattern("iii")
                .pattern("iii")
                .define('i', ingredient)
                .unlockedBy("has_ingredient", InventoryChangeTrigger.TriggerInstance.hasItems(ingredient));
    }

    public static BundleShapedRecipeBuilder compact2x2(ItemLike result, ItemLike ingredient, String bundleName) {
        return BundleShapedRecipeBuilder.shaped(result, bundleName)
                .pattern("ii")
                .pattern("ii")
                .define('i', ingredient)
                .unlockedBy("has_ingredient", InventoryChangeTrigger.TriggerInstance.hasItems(ingredient));
    }

    public static BundleShapelessRecipeBuilder decompact3x3(ItemLike result, ItemLike ingredient, String bundleName) {
        return BundleShapelessRecipeBuilder.shapeless(result, 9, bundleName).requires(ingredient).unlockedBy("has_ingredient", InventoryChangeTrigger.TriggerInstance.hasItems(ingredient));
    }

    public static BundleShapelessRecipeBuilder decompact2x2(ItemLike result, ItemLike ingredient, String bundleName) {
        return BundleShapelessRecipeBuilder.shapeless(result, 4, bundleName).requires(ingredient).unlockedBy("has_ingredient", InventoryChangeTrigger.TriggerInstance.hasItems(ingredient));
    }


    public static BundleShapedRecipeBuilder doughnutCraft(ItemLike result, ItemLike center, ItemLike ring, String bundleName) {
        return BundleShapedRecipeBuilder.shaped(result, bundleName)
                .pattern("iii")
                .pattern("i#i")
                .pattern("iii")
                .define('#', center)
                .define('i', ring)
                .unlockedBy("has_ingredient", InventoryChangeTrigger.TriggerInstance.hasItems(center));
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

    public static BundleShapelessRecipeBuilder shapelessWithin4x4(ItemLike result, int resultAmount, ItemLike mainIngredient, List<ItemLike> ingredients, String bundleName) {
        BundleShapelessRecipeBuilder builder = BundleShapelessRecipeBuilder.shapeless(result, resultAmount, bundleName);
        if (ingredients.size() > 3) {
            throw new IllegalArgumentException("Too many ingredients for a 4x4 recipe");
        }
        for (ItemLike ingredient : ingredients) {
            builder.requires(ingredient);
        }
        builder.requires(mainIngredient);
        return builder.unlockedBy("has_ingredient", InventoryChangeTrigger.TriggerInstance.hasItems(mainIngredient));
    }

    public static BundleShapelessRecipeBuilder shapelessWithin9x9(ItemLike result, int resultAmount, ItemLike mainIngredient, List<ItemLike> ingredients, String bundleName) {
        BundleShapelessRecipeBuilder builder = BundleShapelessRecipeBuilder.shapeless(result, resultAmount, bundleName);
        if (ingredients.size() > 8) {
            throw new IllegalArgumentException("Too many ingredients for a 9x9 recipe");
        }
        for (ItemLike ingredient : ingredients) {
            builder.requires(ingredient);
        }
        builder.requires(mainIngredient);
        return builder.unlockedBy("has_ingredient", InventoryChangeTrigger.TriggerInstance.hasItems(mainIngredient));
    }

    public static CuttingBoardRecipeBuilder powder(ItemLike result, ItemLike ingredient, String bundleName) {
        return CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(ingredient), Ingredient.of(ModTags.KNIVES), result, 2, bundleName).addResultWithChance(result, 0.5F);
    }
    public static CreateProcessingRecipeBuilder millPowder(ItemLike result, ItemLike ingredient, String bundleName) {
        return CreateProcessingRecipeBuilder.create(BundleRecipeGen.MILLSTONE, bundleName).require(ingredient).output(result, 2).output(0.5F, result).duration(50);
    }
}
