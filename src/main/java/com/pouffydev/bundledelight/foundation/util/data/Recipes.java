package com.pouffydev.bundledelight.foundation.util.data;

import com.pouffydev.bundledelight.foundation.util.data.recipes.*;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.function.Consumer;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class Recipes extends RecipeProvider {
    public Recipes(DataGenerator generator) {
        super(generator);
    }

    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        CraftingRecipes.register(consumer);
        BrewingRecipes.register(consumer);
        FermentingRecipes.register(consumer);
        CuttingRecipes.register(consumer);
        CookingRecipes.register(consumer);
        ThermalRecipes.register(consumer);
    }
}
