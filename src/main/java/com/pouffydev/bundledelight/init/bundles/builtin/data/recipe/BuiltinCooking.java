package com.pouffydev.bundledelight.init.bundles.builtin.data.recipe;

import com.pouffydev.bundledelight.BundledDelight;
import com.pouffydev.bundledelight.foundation.data.BundleRecipeGen;
import com.pouffydev.bundledelight.init.bundles.builtin.BuiltinItems;
import com.pouffydev.krystal_core.foundation.data.condition.BundleLoadedCondition;
import com.pouffydev.krystal_core.foundation.dynamicpack.data.advancement.RecipeAdvancement;
import com.pouffydev.krystal_core.foundation.dynamicpack.data.recipe.custom.farmersdelight.CookingPotRecipe;
import com.pouffydev.krystal_core.foundation.dynamicpack.data.recipe.output.CustomRecipeOutput;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.ICondition;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.CommonTags;

public class BuiltinCooking extends BundleRecipeGen {
    private static final String BUNDLE_NAME = "builtin";
    public BuiltinCooking() {
    }

    static ICondition condition = new BundleLoadedCondition(BundledDelight.location("builtin"));

    public static void register(CustomRecipeOutput output) {
        cookMiscellaneous(output);
        cookMeals(output);
    }

    private static void cookMiscellaneous(CustomRecipeOutput output) {
    
    }

    private static void cookMeals(CustomRecipeOutput output) {
        CookingPotRecipe.cookingPotRecipe(BuiltinItems.borscht.get(), 1, NORMAL_COOKING, MEDIUM_EXP)
                .addIngredient(CommonTags.Items.FOODS_RAW_BEEF)
                .addIngredient(Items.BEETROOT)
                .addIngredient(CommonTags.Items.CROPS_CABBAGE)
                .addIngredient(ModItems.TOMATO_SAUCE.get())
                .setRecipeBookTab(CookingPotRecipe.CookingPotRecipeBookTab.MEALS)
                .withCondition(condition)
                .save(output, BundledDelight.location("cooking/borscht"), (loc) -> new RecipeAdvancement(output, loc).unlockedByAnyIngredient(Items.BEEF, Items.BEETROOT, ModItems.CABBAGE.get(), ModItems.TOMATO_SAUCE.get()));
        CookingPotRecipe.cookingPotRecipe(BuiltinItems.nettleSoup.get(), 1, NORMAL_COOKING, MEDIUM_EXP)
                .addIngredient(Items.WATER_BUCKET)
                .addIngredient(Items.FERN)
                .addIngredient(Tags.Items.FOODS_VEGETABLE)
                .addIngredient(Tags.Items.SEEDS)
                .withCondition(condition)
                .save(output, BundledDelight.location("cooking/nettle_soup"), (loc) -> new RecipeAdvancement(output, loc).unlockedByAnyIngredient(Items.FERN));
        }
    
    @Override
    public String getBundleName() {
        return BUNDLE_NAME;
    }
}
