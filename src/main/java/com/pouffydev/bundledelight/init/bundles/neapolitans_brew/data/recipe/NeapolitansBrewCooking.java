package com.pouffydev.bundledelight.init.bundles.neapolitans_brew.data.recipe;

import com.pouffydev.bundledelight.datagen.builder.recipe.CookingPotRecipeBuilder;
import com.pouffydev.bundledelight.foundation.data.BundleRecipeGen;
import com.pouffydev.bundledelight.init.bundles.builtin.BuiltinItems;
import com.pouffydev.bundledelight.init.bundles.neapolitans_brew.NeapolitansBrewItems;
import com.teamabnormals.neapolitan.core.registry.NeapolitanItems;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.Items;
import vectorwing.farmersdelight.client.recipebook.CookingPotRecipeBookTab;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.ForgeTags;

import java.util.function.Consumer;

public class NeapolitansBrewCooking extends BundleRecipeGen {
    private static final String BUNDLE_NAME = "neapolitans_brew";
    public NeapolitansBrewCooking() {
    }
    public static void register(Consumer<FinishedRecipe> consumer) {
        cookMiscellaneous(consumer);
        cookMeals(consumer);
    }
    private static void cookMiscellaneous(Consumer<FinishedRecipe> consumer) {
        CookingPotRecipeBuilder.cookingPotRecipe(NeapolitansBrewItems.strawberryJam.get(), 1, NORMAL_COOKING, MEDIUM_EXP, BUNDLE_NAME)
                .addIngredient(Items.SUGAR)
                .addIngredient(NeapolitanItems.STRAWBERRIES.get()).addIngredient(NeapolitanItems.STRAWBERRIES.get()).addIngredient(NeapolitanItems.STRAWBERRIES.get())
                .unlockedByAnyIngredient(NeapolitanItems.STRAWBERRIES.get()).setRecipeBookTab(CookingPotRecipeBookTab.MISC).build(consumer);
        CookingPotRecipeBuilder.cookingPotRecipe(NeapolitansBrewItems.whiteStrawberryJam.get(), 1, NORMAL_COOKING, MEDIUM_EXP, BUNDLE_NAME)
                .addIngredient(Items.SUGAR)
                .addIngredient(NeapolitanItems.WHITE_STRAWBERRIES.get()).addIngredient(NeapolitanItems.WHITE_STRAWBERRIES.get()).addIngredient(NeapolitanItems.WHITE_STRAWBERRIES.get())
                .unlockedByAnyIngredient(NeapolitanItems.WHITE_STRAWBERRIES.get()).setRecipeBookTab(CookingPotRecipeBookTab.MISC).build(consumer);
    }
    private static void cookMeals(Consumer<FinishedRecipe> consumer) {
    }
    
    @Override
    public String getBundleName() {
        return BUNDLE_NAME;
    }
}
