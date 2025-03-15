package com.pouffydev.bundledelight.init.bundles.minersdelight.data;

import com.pouffydev.bundledelight.datagen.CustomRecipeProvider;
import com.pouffydev.bundledelight.foundation.data.FinishedData;
import com.pouffydev.bundledelight.init.bundles.brewinandchewin.BrewinBundle;
import com.pouffydev.bundledelight.init.bundles.minersdelight.MinersBundle;
import com.pouffydev.bundledelight.init.bundles.minersdelight.data.recipe.MinersCrafting;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

public class MinersRecipes extends CustomRecipeProvider {
    public MinersRecipes(DataGenerator generator) {
        super(generator.getPackOutput());
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        MinersCrafting.register(consumer);
    }

    @Override
    protected void buildCustomRecipes(Consumer<FinishedData> consumer) {
    }

    @Override
    public String getName() {
        return "Bundled Delights' Custom Recipes [Miner's Delight]";
    }
}
