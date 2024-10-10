package com.pouffydev.bundledelight.init.bundles.miners_brew.data;

import com.pouffydev.bundledelight.datagen.CustomRecipeProvider;
import com.pouffydev.bundledelight.foundation.data.FinishedData;
import com.pouffydev.bundledelight.init.bundles.miners_brew.data.recipe.MinersBrewCrafting;
import com.pouffydev.bundledelight.init.bundles.miners_brew.data.recipe.MinersBrewFermenting;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

public class MinersBrewRecipes extends CustomRecipeProvider {
    public MinersBrewRecipes(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        MinersBrewCrafting.register(consumer);
    }

    @Override
    protected void buildCustomRecipes(Consumer<FinishedData> consumer) {
        MinersBrewFermenting.register(consumer);
    }
}
