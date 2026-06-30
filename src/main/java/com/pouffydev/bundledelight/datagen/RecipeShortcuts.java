package com.pouffydev.bundledelight.datagen;

import com.pouffydev.bundledelight.datagen.builder.recipe.BundleShapedRecipeBuilder;
import com.pouffydev.bundledelight.datagen.builder.recipe.BundleShapelessRecipeBuilder;
import com.pouffydev.krystal_core.foundation.dynamicpack.data.recipe.custom.RecipeTemplates;
import com.pouffydev.krystal_core.foundation.dynamicpack.data.recipe.custom.create.CreateRecipe;
import com.pouffydev.krystal_core.foundation.dynamicpack.data.recipe.custom.farmersdelight.CuttingBoardRecipe;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.Tags;
import vectorwing.farmersdelight.common.crafting.ingredient.ChanceResult;
import vectorwing.farmersdelight.common.tag.ModTags;

import java.util.List;

public class RecipeShortcuts {
    public static BundleShapedRecipeBuilder compact3x3(ItemLike result, ItemLike ingredient, RecipeCategory category) {
        return BundleShapedRecipeBuilder.shaped(category, result)
                .pattern("iii")
                .pattern("iii")
                .pattern("iii")
                .define('i', ingredient)
                .unlockedBy("has_ingredient", InventoryChangeTrigger.TriggerInstance.hasItems(ingredient));
    }

    public static BundleShapedRecipeBuilder compact2x2(ItemLike result, ItemLike ingredient, RecipeCategory category) {
        return BundleShapedRecipeBuilder.shaped(category, result)
                .pattern("ii")
                .pattern("ii")
                .define('i', ingredient)
                .unlockedBy("has_ingredient", InventoryChangeTrigger.TriggerInstance.hasItems(ingredient));
    }

    public static BundleShapelessRecipeBuilder decompact3x3(ItemLike result, ItemLike ingredient, RecipeCategory category) {
        return BundleShapelessRecipeBuilder.shapeless(category, result, 9).requires(ingredient).unlockedBy("has_ingredient", InventoryChangeTrigger.TriggerInstance.hasItems(ingredient));
    }

    public static BundleShapelessRecipeBuilder decompact2x2(ItemLike result, ItemLike ingredient, RecipeCategory category) {
        return BundleShapelessRecipeBuilder.shapeless(category, result, 4).requires(ingredient).unlockedBy("has_ingredient", InventoryChangeTrigger.TriggerInstance.hasItems(ingredient));
    }


    public static BundleShapedRecipeBuilder doughnutCraft(ItemLike result, ItemLike center, ItemLike ring, RecipeCategory category) {
        return BundleShapedRecipeBuilder.shaped(category, result)
                .pattern("iii")
                .pattern("i#i")
                .pattern("iii")
                .define('#', center)
                .define('i', ring)
                .unlockedBy("has_ingredient", InventoryChangeTrigger.TriggerInstance.hasItems(center));
    }

    public static BundleShapedRecipeBuilder cake(ItemLike result, ItemLike ingredient) {
        return BundleShapedRecipeBuilder.shaped(RecipeCategory.FOOD, result)
                .pattern("mcm")
                .pattern("ses")
                .pattern("wcw")
                .define('m', Tags.Items.BUCKETS_MILK)
                .define('s', Items.SUGAR)
                .define('c', ingredient)
                .define('e', Items.EGG)
                .define('w', Items.WHEAT)
                .unlockedBy("has_ingredient", InventoryChangeTrigger.TriggerInstance.hasItems(ingredient));
    }

    public static BundleShapelessRecipeBuilder compactCakeFromSlices(ItemLike result, ItemLike ingredient) {
        return BundleShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, result)
                .requires(ingredient)
                .requires(ingredient)
                .requires(ingredient)
                .requires(ingredient)
                .requires(ingredient)
                .requires(ingredient)
                .requires(ingredient)
                .unlockedBy("has_cake_slice", InventoryChangeTrigger.TriggerInstance.hasItems(ingredient));
    }

    public static BundleShapelessRecipeBuilder juice(ItemLike result, ItemLike ingredient) {
        return BundleShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, result)
                .requires(ingredient)
                .requires(ingredient)
                .requires(ingredient)
                .requires(ingredient)
                .requires(Items.SUGAR)
                .requires(Items.GLASS_BOTTLE)
                .unlockedBy("has_ingredient", InventoryChangeTrigger.TriggerInstance.hasItems(ingredient));
    }

    public static BundleShapelessRecipeBuilder juice(ItemLike result, ItemLike ingredient, ItemLike bottle) {
        return BundleShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, result)
                .requires(ingredient)
                .requires(ingredient)
                .requires(ingredient)
                .requires(ingredient)
                .requires(Items.SUGAR)
                .requires(bottle)
                .unlockedBy("has_ingredient", InventoryChangeTrigger.TriggerInstance.hasItems(ingredient));
    }

    public static BundleShapelessRecipeBuilder shapelessWithin4x4(ItemLike result, int resultAmount, ItemLike mainIngredient, List<ItemLike> ingredients, RecipeCategory category) {
        BundleShapelessRecipeBuilder builder = BundleShapelessRecipeBuilder.shapeless(category, result, resultAmount);
        if (ingredients.size() > 3) {
            throw new IllegalArgumentException("Too many ingredients for a 4x4 recipe");
        }
        for (ItemLike ingredient : ingredients) {
            builder.requires(ingredient);
        }
        builder.requires(mainIngredient);
        return builder.unlockedBy("has_ingredient", InventoryChangeTrigger.TriggerInstance.hasItems(mainIngredient));
    }

    public static BundleShapelessRecipeBuilder shapelessWithin9x9(ItemLike result, int resultAmount, ItemLike mainIngredient, List<ItemLike> ingredients, RecipeCategory category) {
        BundleShapelessRecipeBuilder builder = BundleShapelessRecipeBuilder.shapeless(category, result, resultAmount);
        if (ingredients.size() > 8) {
            throw new IllegalArgumentException("Too many ingredients for a 9x9 recipe");
        }
        for (ItemLike ingredient : ingredients) {
            builder.requires(ingredient);
        }
        builder.requires(mainIngredient);
        return builder.unlockedBy("has_ingredient", InventoryChangeTrigger.TriggerInstance.hasItems(mainIngredient));
    }

    public static CuttingBoardRecipe powder(ItemLike result, ItemLike ingredient) {
        return cutWithKnife(result, 2, List.of(createCuttingResult(result, 1, 0.5F)), ingredient);
    }

    public static CreateRecipe millPowder(ItemLike result, ItemLike ingredient) {
        CreateRecipe milling = RecipeTemplates.Create.MILLING;
        return milling.input(ingredient).result(result, 2).result(0.5F, result, 1).duration(50);
    }

    public static CuttingBoardRecipe cutWithKnife(ItemLike result, int resultAmount, ItemLike ingredient) {
        return cut(result, resultAmount, List.of(), ingredient, Ingredient.of(ModTags.Items.KNIVES));
    }
    public static CuttingBoardRecipe cutWithKnife(ItemLike result, int resultAmount, List<ChanceResult> chanceResults, ItemLike ingredient) {
        return cut(result, resultAmount, chanceResults, ingredient, Ingredient.of(ModTags.Items.KNIVES));
    }

    public static CuttingBoardRecipe cut(ItemLike mainResult, int mainResultAmount, List<ChanceResult> chanceResults, ItemLike ingredient, Ingredient tool) {
        CuttingBoardRecipe builder = CuttingBoardRecipe.cuttingRecipe(Ingredient.of(ingredient), tool, mainResult, mainResultAmount);
        for (ChanceResult chanceResult : chanceResults) {
            ItemStack result = chanceResult.stack();
            float chance = chanceResult.chance();
            builder.addResultWithChance(result.getItem(), chance, result.getCount());
        }
        return builder;
    }

    public static ChanceResult createCuttingResult(ItemLike result, int count, float chance) {
        return new ChanceResult(new ItemStack(result.asItem(), count), chance);
    }
    public static ChanceResult createCuttingResult(ItemLike result, int count) {
        return new ChanceResult(new ItemStack(result.asItem(), count), 1.0F);
    }
}
