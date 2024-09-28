package com.pouffydev.bundledelight.init.bundles.neapolitan.data;

import com.pouffydev.bundledelight.datagen.CustomRecipeProvider;
import com.pouffydev.bundledelight.foundation.data.FinishedData;
import com.pouffydev.bundledelight.init.bundles.neapolitan.data.recipe.NeapolitanCrafting;
import com.pouffydev.bundledelight.init.bundles.neapolitan.data.recipe.NeapolitanCutting;
import com.pouffydev.bundledelight.init.bundles.neapolitan.data.recipe.NeapolitanFermenting;
import com.pouffydev.bundledelight.init.bundles.neapolitan.data.recipe.NeapolitanMilling;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

public class NeapolitanRecipes extends CustomRecipeProvider {
    public NeapolitanRecipes(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        NeapolitanCrafting.register(consumer);
        NeapolitanCutting.register(consumer);
    }

    @Override
    protected void buildCustomRecipes(Consumer<FinishedData> consumer) {
        NeapolitanFermenting.register(consumer);
        NeapolitanMilling.register(consumer);
    }
}
