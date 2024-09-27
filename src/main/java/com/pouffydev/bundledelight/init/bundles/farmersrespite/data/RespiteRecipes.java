package com.pouffydev.bundledelight.init.bundles.farmersrespite.data;

import com.pouffydev.bundledelight.datagen.CustomRecipeProvider;
import com.pouffydev.bundledelight.foundation.data.FinishedData;
import com.pouffydev.bundledelight.init.bundles.farmersrespite.data.recipe.RespiteCutting;
import com.pouffydev.bundledelight.init.bundles.farmersrespite.data.recipe.RespiteMilling;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

public class RespiteRecipes extends CustomRecipeProvider {
    public RespiteRecipes(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        RespiteCutting.register(consumer);
    }

    @Override
    protected void buildCustomRecipes(Consumer<FinishedData> consumer) {
        RespiteMilling.register(consumer);
    }
}
