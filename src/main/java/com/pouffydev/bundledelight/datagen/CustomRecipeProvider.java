package com.pouffydev.bundledelight.datagen;

import com.google.common.collect.Sets;
import com.pouffydev.bundledelight.BundledDelight;
import com.pouffydev.krystal_core.foundation.dynamicpack.data.recipe.custom.CustomRecipe;
import com.pouffydev.krystal_core.foundation.dynamicpack.data.recipe.output.CustomRecipeOutput;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;
import net.neoforged.neoforge.common.conditions.ICondition;
import net.neoforged.neoforge.common.conditions.WithConditions;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.concurrent.CompletableFuture;

@SuppressWarnings({"DuplicatedCode", "removal"})
public abstract class CustomRecipeProvider implements DataProvider {
    private static final Logger LOGGER = BundledDelight.LOGGER;
    
    protected final PackOutput.PathProvider recipePathProvider;
    protected final PackOutput.PathProvider advancementPathProvider;
    
    public CustomRecipeProvider(PackOutput packOutput) {
        this.recipePathProvider = packOutput.createPathProvider(PackOutput.Target.DATA_PACK, "recipes");
        this.advancementPathProvider = packOutput.createPathProvider(PackOutput.Target.DATA_PACK, "advancements");
    }

    public CompletableFuture<?> run(CachedOutput output, final HolderLookup.Provider registries) {
        Set<ResourceLocation> set = Sets.newHashSet();
        List<CompletableFuture<?>> list = new ArrayList();
        this.buildCraftingRecipes(new RecipeOutput() {
            @Override
            public void accept(ResourceLocation location, Recipe<?> recipe, AdvancementHolder advancementHolder, @Nullable ICondition... conditions) {
                if (!set.add(location)) {
                    throw new IllegalStateException("Duplicate recipe " + location);
                } else {
                    list.add(DataProvider.saveStable(output, registries, Recipe.CONDITIONAL_CODEC, Optional.of(new WithConditions<>(recipe, conditions)), recipePathProvider.json(location)));
                    if (advancementHolder != null) {
                        list.add(DataProvider.saveStable(output, registries, Advancement.CONDITIONAL_CODEC, Optional.of(new WithConditions<>(advancementHolder.value(), conditions)), advancementPathProvider.json(advancementHolder.id())));
                    }
                }
            }

            public Advancement.Builder advancement() {
                return Advancement.Builder.recipeAdvancement().parent(RecipeBuilder.ROOT_RECIPE_ADVANCEMENT);
            }
        });
        this.buildCustomRecipes(new CustomRecipeOutput() {
            @Override
            public Advancement.Builder advancement() {
                return Advancement.Builder.recipeAdvancement().parent(RecipeBuilder.ROOT_RECIPE_ADVANCEMENT);
            }

            @Override
            public void accept(ResourceLocation location, CustomRecipe<?> customRecipe, @Nullable AdvancementHolder advancementHolder, ICondition... conditions) {
                if (!set.add(location)) {
                    throw new IllegalStateException("Duplicate recipe " + location);
                } else {
                    list.add(DataProvider.saveStable(output, registries, Recipe.CONDITIONAL_CODEC, Optional.of(new WithConditions<>(customRecipe, conditions)), recipePathProvider.json(location)));
                    if (advancementHolder != null) {
                        list.add(DataProvider.saveStable(output, registries, Advancement.CONDITIONAL_CODEC, Optional.of(new WithConditions<>(advancementHolder.value(), conditions)), advancementPathProvider.json(advancementHolder.id())));
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

    protected CompletableFuture<?> buildAdvancement(CachedOutput output, HolderLookup.Provider registries, AdvancementHolder advancement) {
        return this.buildAdvancement(output, registries, advancement);
    }

    protected CompletableFuture<?> buildAdvancement(CachedOutput output, HolderLookup.Provider registries, AdvancementHolder advancement, ICondition... conditions) {
        return DataProvider.saveStable(output, registries, Advancement.CONDITIONAL_CODEC, Optional.of(new WithConditions(advancement.value(), conditions)), this.advancementPathProvider.json(advancement.id()));
    }
    
    protected abstract void buildCraftingRecipes(RecipeOutput recipeConsumer);
    
    protected abstract void buildCustomRecipes(CustomRecipeOutput customConsumer);
}
