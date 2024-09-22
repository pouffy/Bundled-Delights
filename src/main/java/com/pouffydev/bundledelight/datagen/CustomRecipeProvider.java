package com.pouffydev.bundledelight.datagen;

import com.google.common.collect.Sets;
import com.google.gson.JsonObject;
import com.pouffydev.bundledelight.BundledDelight;
import com.pouffydev.bundledelight.foundation.data.FinishedData;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.critereon.ImpossibleTrigger;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Set;
import java.util.function.Consumer;

public class CustomRecipeProvider implements DataProvider {
    private static final Logger LOGGER = BundledDelight.LOGGER;
    
    protected final DataGenerator.PathProvider recipePathProvider;
    protected final DataGenerator.PathProvider advancementPathProvider;
    
    public CustomRecipeProvider(DataGenerator generator) {
        this.recipePathProvider = generator.createPathProvider(DataGenerator.Target.DATA_PACK, "recipes");
        this.advancementPathProvider = generator.createPathProvider(DataGenerator.Target.DATA_PACK, "advancements");
    }
    
    public void run(CachedOutput pOutput) {
        Set<ResourceLocation> set = Sets.newHashSet();
        this.buildCraftingRecipes((consumer) -> {
            if (!set.add(consumer.getId())) {
                throw new IllegalStateException("Duplicate recipe " + consumer.getId());
            } else {
                saveRecipe(pOutput, consumer.serializeRecipe(), this.recipePathProvider.json(consumer.getId()));
                JsonObject jsonobject = consumer.serializeAdvancement();
                if (jsonobject != null) {
                    this.saveAdvancement(pOutput, jsonobject, this.advancementPathProvider.json(consumer.getAdvancementId()));
                }
                
            }
        });
        this.buildCustomRecipes((consumer) -> {
            if (!set.add(consumer.getId())) {
                throw new IllegalStateException("Duplicate recipe " + consumer.getId());
            } else {
                saveRecipe(pOutput, consumer.serialize(), this.recipePathProvider.json(consumer.getId()));
                JsonObject jsonobject = consumer.serializeAdvancement();
                if (jsonobject != null) {
                    this.saveAdvancement(pOutput, jsonobject, this.advancementPathProvider.json(consumer.getAdvancementId()));
                }
                
            }
        });
        if (this.getClass() == CustomRecipeProvider.class) {
            this.saveAdvancement(pOutput, Advancement.Builder.advancement().addCriterion("impossible", new ImpossibleTrigger.TriggerInstance()).serializeToJson(), this.advancementPathProvider.json(RecipeBuilder.ROOT_RECIPE_ADVANCEMENT));
        }
    }
    
    @Override
    public String getName() {
        return "Bundled Delights' Custom Recipes";
    }
    
    private static void saveRecipe(CachedOutput pOutput, JsonObject jObject, Path path) {
        try {
            DataProvider.saveStable(pOutput, jObject, path);
        } catch (IOException ioexception) {
            LOGGER.error("Couldn't save recipe {}", path, ioexception);
        }
        
    }
    
    protected void saveAdvancement(CachedOutput pOutput, JsonObject jObject, Path path) {
        try {
            DataProvider.saveStable(pOutput, jObject, path);
        } catch (IOException ioexception) {
            LOGGER.error("Couldn't save recipe advancement {}", path, ioexception);
        }
        
    }
    
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> recipeConsumer) {
    
    }
    
    protected void buildCustomRecipes(Consumer<FinishedData> customConsumer) {
    
    }
}
