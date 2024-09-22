package com.pouffydev.bundledelight.init.bundles.builtin.data.recipe;

import com.pouffydev.bundledelight.datagen.builder.recipe.CookingPotRecipeBuilder;
import com.pouffydev.bundledelight.foundation.data.BundleRecipeGen;
import com.pouffydev.bundledelight.init.bundles.builtin.BuiltinItems;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import vectorwing.farmersdelight.client.recipebook.CookingPotRecipeBookTab;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.ForgeTags;

import java.util.function.Consumer;

public class BuiltinCooking extends BundleRecipeGen {
    private static final String BUNDLE_NAME = "builtin";
    public BuiltinCooking() {
    }
    public static void register(Consumer<FinishedRecipe> consumer) {
        cookMiscellaneous(consumer);
        cookMeals(consumer);
    }
    private static void cookMiscellaneous(Consumer<FinishedRecipe> consumer) {
    
    }
    private static void cookMeals(Consumer<FinishedRecipe> consumer) {
        CookingPotRecipeBuilder.cookingPotRecipe(BuiltinItems.borscht.get(), 1, NORMAL_COOKING, MEDIUM_EXP, BUNDLE_NAME).addIngredient(ForgeTags.RAW_BEEF).addIngredient(Items.BEETROOT).addIngredient(ForgeTags.CROPS_CABBAGE).addIngredient(ModItems.TOMATO_SAUCE.get()).unlockedByAnyIngredient(Items.BEEF, Items.BEETROOT, ModItems.CABBAGE.get(), ModItems.TOMATO_SAUCE.get()).setRecipeBookTab(CookingPotRecipeBookTab.MEALS).build(consumer);
        CookingPotRecipeBuilder.cookingPotRecipe(BuiltinItems.nettleSoup.get(), 1, NORMAL_COOKING, MEDIUM_EXP, BUNDLE_NAME).addIngredient(Items.WATER_BUCKET).addIngredient(Items.FERN).addIngredient(ForgeTags.VEGETABLES).addIngredient(ForgeTags.SEEDS).unlockedByAnyIngredient(Items.FERN).setRecipeBookTab(CookingPotRecipeBookTab.MEALS).build(consumer);
    }
    
    @Override
    public String getBundleName() {
        return BUNDLE_NAME;
    }
}
