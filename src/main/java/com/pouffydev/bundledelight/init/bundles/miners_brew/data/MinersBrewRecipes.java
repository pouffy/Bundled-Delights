package com.pouffydev.bundledelight.init.bundles.miners_brew.data;

import com.pouffydev.bundledelight.datagen.CustomRecipeProvider;
import com.pouffydev.bundledelight.foundation.data.FinishedData;
import com.pouffydev.bundledelight.init.bundles.brewinandchewin.BrewinBundle;
import com.pouffydev.bundledelight.init.bundles.miners_brew.MinersBrewBundle;
import com.pouffydev.bundledelight.init.bundles.miners_brew.data.recipe.MinersBrewCrafting;
import com.pouffydev.bundledelight.init.bundles.miners_brew.data.recipe.MinersBrewFermenting;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

public class MinersBrewRecipes extends CustomRecipeProvider {
    public MinersBrewRecipes(DataGenerator generator) {
        super(generator.getPackOutput());
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        MinersBrewCrafting.register(consumer);
    }

    @Override
    protected void buildCustomRecipes(Consumer<FinishedData> consumer) {
        MinersBrewFermenting.register(consumer);
    }

    @Override
    public String getName() {
        return "Bundled Delights' Custom Recipes [Miner's Brew]";
    }

}
