package com.pouffydev.bundledelight.init.bundles.builtin.data;

import com.pouffydev.bundledelight.datagen.CustomRecipeProvider;
import com.pouffydev.bundledelight.foundation.data.FinishedData;
import com.pouffydev.bundledelight.init.bundles.builtin.data.recipe.BuiltinCooking;
import com.pouffydev.bundledelight.init.bundles.builtin.data.recipe.BuiltinCrafting;
import com.pouffydev.bundledelight.init.bundles.builtin.data.recipe.BuiltinCutting;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

public class BuiltinRecipes extends CustomRecipeProvider {
    public BuiltinRecipes(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        BuiltinCooking.register(consumer);
        BuiltinCrafting.register(consumer);
        BuiltinCutting.register(consumer);
    }

    @Override
    protected void buildCustomRecipes(Consumer<FinishedData> customConsumer) {

    }
}
