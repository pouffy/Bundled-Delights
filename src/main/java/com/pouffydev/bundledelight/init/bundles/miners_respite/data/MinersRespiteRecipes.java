package com.pouffydev.bundledelight.init.bundles.miners_respite.data;

import com.pouffydev.bundledelight.datagen.CustomRecipeProvider;
import com.pouffydev.bundledelight.foundation.data.FinishedData;
import com.pouffydev.bundledelight.init.bundles.brewinandchewin.BrewinBundle;
import com.pouffydev.bundledelight.init.bundles.miners_respite.MinersRespiteBundle;
import com.pouffydev.bundledelight.init.bundles.miners_respite.data.recipe.MinersRespiteBrewing;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

public class MinersRespiteRecipes extends CustomRecipeProvider {
    public MinersRespiteRecipes(DataGenerator generator) {
        super(generator.getPackOutput());
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {

    }

    @Override
    protected void buildCustomRecipes(Consumer<FinishedData> consumer) {
        MinersRespiteBrewing.register(consumer);
    }

    @Override
    public String getName() {
        return "Bundled Delights' Custom Recipes [Miner's Respite]";
    }
}
