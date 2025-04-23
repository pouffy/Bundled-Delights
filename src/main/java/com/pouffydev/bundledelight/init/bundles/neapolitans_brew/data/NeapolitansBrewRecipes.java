package com.pouffydev.bundledelight.init.bundles.neapolitans_brew.data;

import com.pouffydev.bundledelight.datagen.CustomRecipeProvider;
import com.pouffydev.bundledelight.foundation.data.FinishedData;
import com.pouffydev.bundledelight.init.bundles.neapolitans_brew.data.recipe.NeapolitansBrewCooking;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

public class NeapolitansBrewRecipes extends CustomRecipeProvider {
    public NeapolitansBrewRecipes(DataGenerator generator) {
        super(generator.getPackOutput());
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        NeapolitansBrewCooking.register(consumer);
    }

    @Override
    protected void buildCustomRecipes(Consumer<FinishedData> consumer) {
    }

    @Override
    public String getName() {
        return "Bundled Delights' Custom Recipes [Neapolitan's Brew]";
    }
}
