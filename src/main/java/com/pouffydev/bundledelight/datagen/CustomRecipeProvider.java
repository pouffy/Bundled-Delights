package com.pouffydev.bundledelight.datagen;

import com.google.common.collect.Sets;
import com.google.gson.JsonObject;
import com.pouffydev.bundledelight.BundledDelight;
import com.pouffydev.bundledelight.foundation.bundle.Bundle;
import com.pouffydev.bundledelight.foundation.data.FinishedData;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.critereon.ImpossibleTrigger;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public abstract class CustomRecipeProvider implements DataProvider {
    private static final Logger LOGGER = BundledDelight.LOGGER;
    
    protected final PackOutput.PathProvider recipePathProvider;
    protected final PackOutput.PathProvider advancementPathProvider;
    
    public CustomRecipeProvider(PackOutput packOutput) {
        this.recipePathProvider = packOutput.createPathProvider(PackOutput.Target.DATA_PACK, "recipes");
        this.advancementPathProvider = packOutput.createPathProvider(PackOutput.Target.DATA_PACK, "advancements");
    }

    public CompletableFuture<?> run(CachedOutput output) {
        Set<ResourceLocation> set = Sets.newHashSet();
        List<CompletableFuture<?>> list = new ArrayList();
        this.buildCraftingRecipes((finishedRecipe) -> {
            if (!set.add(finishedRecipe.getId())) {
                throw new IllegalStateException("Duplicate recipe " + finishedRecipe.getId());
            } else {
                list.add(DataProvider.saveStable(output, finishedRecipe.serializeRecipe(), this.recipePathProvider.json(finishedRecipe.getId())));
                if (finishedRecipe.getAdvancementId() != null) {
                    JsonObject jsonobject = finishedRecipe.serializeAdvancement();
                    if (jsonobject != null) {
                        CompletableFuture<?> saveAdvancementFuture = this.saveAdvancement(output, finishedRecipe, jsonobject);
                        if (saveAdvancementFuture != null) {
                            list.add(saveAdvancementFuture);
                        }
                    }
                }
            }
        });
        this.buildCustomRecipes((finishedData) -> {
            if (!set.add(finishedData.getId())) {
                throw new IllegalStateException("Duplicate recipe " + finishedData.getId());
            } else {
                list.add(DataProvider.saveStable(output, finishedData.serialize(), this.recipePathProvider.json(finishedData.getId())));
                if (finishedData.getAdvancementId() != null) {
                    JsonObject jsonobject = finishedData.serializeAdvancement();
                    if (jsonobject != null) {
                        CompletableFuture<?> saveAdvancementFuture = this.saveAdvancement(output, finishedData, jsonobject);
                        if (saveAdvancementFuture != null) {
                            list.add(saveAdvancementFuture);
                        }
                    }
                }
            }
        });
        return CompletableFuture.allOf(list.toArray(CompletableFuture[]::new));
    }
    
    @Override
    public String getName() {
        return "Bundled Delights' Custom Recipes";
    }

    protected @Nullable CompletableFuture<?> saveAdvancement(CachedOutput output, FinishedRecipe finishedRecipe, JsonObject advancementJson) {
        return DataProvider.saveStable(output, advancementJson, this.advancementPathProvider.json(finishedRecipe.getAdvancementId()));
    }
    protected @Nullable CompletableFuture<?> saveAdvancement(CachedOutput output, FinishedData finishedData, JsonObject advancementJson) {
        return DataProvider.saveStable(output, advancementJson, this.advancementPathProvider.json(finishedData.getAdvancementId()));
    }
    
    protected abstract void buildCraftingRecipes(Consumer<FinishedRecipe> recipeConsumer);
    
    protected abstract void buildCustomRecipes(Consumer<FinishedData> customConsumer);
}
