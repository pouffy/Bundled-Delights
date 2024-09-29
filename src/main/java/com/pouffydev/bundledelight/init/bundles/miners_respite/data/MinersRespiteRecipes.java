package com.pouffydev.bundledelight.init.bundles.miners_respite.data;

import com.pouffydev.bundledelight.datagen.CustomRecipeProvider;
import com.pouffydev.bundledelight.foundation.data.FinishedData;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

public class MinersRespiteRecipes extends CustomRecipeProvider {
    public MinersRespiteRecipes(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {

    }

    @Override
    protected void buildCustomRecipes(Consumer<FinishedData> consumer) {
    }
}
