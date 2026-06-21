package com.pouffydev.bundledelight.init.bundles.builtin.data.recipe;

import com.pouffydev.bundledelight.foundation.data.BundleRecipeGen;
import com.pouffydev.bundledelight.init.bundles.builtin.BuiltinItems;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.Tags;
import vectorwing.farmersdelight.client.recipebook.CookingPotRecipeBookTab;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.CommonTags;
import vectorwing.farmersdelight.data.builder.CookingPotRecipeBuilder;

public class BuiltinCooking extends BundleRecipeGen {
    private static final String BUNDLE_NAME = "builtin";
    public BuiltinCooking() {
    }
    public static void register(RecipeOutput output) {
        cookMiscellaneous(output);
        cookMeals(output);
    }
    private static void cookMiscellaneous(RecipeOutput output) {
    
    }
    private static void cookMeals(RecipeOutput output) {
        CookingPotRecipeBuilder.cookingPotRecipe(BuiltinItems.borscht.get(), 1, NORMAL_COOKING, MEDIUM_EXP).addIngredient(CommonTags.Items.FOODS_RAW_BEEF).addIngredient(Items.BEETROOT).addIngredient(CommonTags.Items.CROPS_CABBAGE).addIngredient(ModItems.TOMATO_SAUCE.get()).unlockedByAnyIngredient(Items.BEEF, Items.BEETROOT, ModItems.CABBAGE.get(), ModItems.TOMATO_SAUCE.get()).setRecipeBookTab(CookingPotRecipeBookTab.MEALS).save(output);
        CookingPotRecipeBuilder.cookingPotRecipe(BuiltinItems.nettleSoup.get(), 1, NORMAL_COOKING, MEDIUM_EXP).addIngredient(Items.WATER_BUCKET).addIngredient(Items.FERN).addIngredient(Tags.Items.FOODS_VEGETABLE).addIngredient(Tags.Items.SEEDS).unlockedByAnyIngredient(Items.FERN).setRecipeBookTab(CookingPotRecipeBookTab.MEALS).save(output);
    }
    
    @Override
    public String getBundleName() {
        return BUNDLE_NAME;
    }
}
