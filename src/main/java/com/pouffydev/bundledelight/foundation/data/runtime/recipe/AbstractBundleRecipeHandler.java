package com.pouffydev.bundledelight.foundation.data.runtime.recipe;

import com.pouffydev.bundledelight.foundation.data.FinishedData;
import net.minecraft.data.recipes.FinishedRecipe;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public abstract class AbstractBundleRecipeHandler {
    public abstract void run(@NotNull Consumer<FinishedRecipe> provider);

    public abstract void runCustom(@NotNull Consumer<FinishedData> provider);
}
