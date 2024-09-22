package com.pouffydev.bundledelight.init.bundles.brewinandchewin.data;

import com.pouffydev.bundledelight.datagen.CustomRecipeProvider;
import com.pouffydev.bundledelight.foundation.data.FinishedData;
import com.pouffydev.bundledelight.init.bundles.brewinandchewin.data.recipe.BrewinCrafting;
import com.pouffydev.bundledelight.init.bundles.brewinandchewin.data.recipe.BrewinFermenting;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

public class BrewinRecipes extends CustomRecipeProvider {
    public BrewinRecipes(DataGenerator generator) {
        super(generator);
    }
    
    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        BrewinCrafting.register(consumer);
    }
    
    @Override
    protected void buildCustomRecipes(Consumer<FinishedData> consumer) {
        BrewinFermenting.register(consumer);
    }
}
