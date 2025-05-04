package com.pouffydev.bundledelight.foundation.data.runtime.recipe;

import com.pouffydev.bundledelight.BundleManager;
import com.pouffydev.bundledelight.foundation.bundle.Bundle;
import com.pouffydev.bundledelight.foundation.data.FinishedData;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

public class BundledRecipes {

    public static void recipeAddition(Consumer<FinishedRecipe> originalConsumer) {
        for (Bundle bundle : BundleManager.BUNDLES) {
            if (!bundle.isLoaded()) {
                continue;
            }
            var recipeHandler = bundle.getRecipeHandler();
            if (recipeHandler == null) {
                continue;
            }
            recipeHandler.run(originalConsumer);
        }
    }

    public static void customDataAddition(Consumer<FinishedData> originalConsumer) {
        for (Bundle bundle : BundleManager.BUNDLES) {
            if (!bundle.isLoaded()) {
                continue;
            }
            var recipeHandler = bundle.getRecipeHandler();
            if (recipeHandler == null) {
                continue;
            }
            recipeHandler.runCustom(originalConsumer);
        }
    }
}
