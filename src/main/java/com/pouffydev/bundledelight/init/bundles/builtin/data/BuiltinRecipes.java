package com.pouffydev.bundledelight.init.bundles.builtin.data;

import com.pouffydev.bundledelight.datagen.CustomRecipeProvider;
import com.pouffydev.bundledelight.foundation.data.FinishedData;
import com.pouffydev.bundledelight.init.bundles.builtin.data.recipe.BuiltinCooking;
import com.pouffydev.bundledelight.init.bundles.builtin.data.recipe.BuiltinCrafting;
import com.pouffydev.bundledelight.init.bundles.builtin.data.recipe.BuiltinCutting;
import net.minecraft.data.PackOutput;

import java.util.function.Consumer;

public class BuiltinRecipes extends CustomRecipeProvider {
    public BuiltinRecipes(PackOutput packOutput) {
        super(packOutput);
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

    @Override
    public String getName() {
        return "Bundled Delights' Custom Recipes [Builtin]";
    }
}
