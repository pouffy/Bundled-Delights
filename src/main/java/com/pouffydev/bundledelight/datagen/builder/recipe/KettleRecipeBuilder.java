package com.pouffydev.bundledelight.datagen.builder.recipe;

import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.pouffydev.bundledelight.foundation.data.FinishedData;
import lombok.Getter;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class KettleRecipeBuilder {
    private final List<Ingredient> ingredients = Lists.newArrayList();
    private final int brewingTime;
    private final float experience;
    private final FluidStack fluidIn;
    private final FluidStack fluidOut;
    private final String requiredBundle;
    
    private KettleRecipeBuilder(FluidStack fluidIn, FluidStack fluidOut, int brewingTime, float experience, String requiredBundle) {
        this.fluidIn = fluidIn;
        this.fluidOut = fluidOut;
        this.brewingTime = brewingTime;
        this.experience = experience;
        this.requiredBundle = requiredBundle;
    }
    
    public static KettleRecipeBuilder kettleRecipe(FluidStack fluidIn, FluidStack fluidOut, int cookingTime, float experience, String requiredBundle) {
        return new KettleRecipeBuilder(fluidIn, fluidOut, cookingTime, experience, requiredBundle);
    }
    
    public KettleRecipeBuilder addIngredient(TagKey<Item> tagIn) {
        return this.addIngredient(Ingredient.of(tagIn));
    }
    
    public KettleRecipeBuilder addIngredient(ItemLike itemIn) {
        return this.addIngredient(itemIn, 1);
    }

    public KettleRecipeBuilder addIngredient(ItemLike itemIn, int quantity) {
        for(int i = 0; i < quantity; ++i) {
            this.addIngredient(Ingredient.of(itemIn));
        }

        return this;
    }
    
    public KettleRecipeBuilder addIngredient(Ingredient ingredientIn) {
        return this.addIngredient((Ingredient)ingredientIn, 1);
    }
    
    public KettleRecipeBuilder addIngredient(Ingredient ingredientIn, int quantity) {
        for(int i = 0; i < quantity; ++i) {
            this.ingredients.add(ingredientIn);
        }
        
        return this;
    }

    protected String getDefaultRecipeName(ResourceLocation resultItemKey) {
        return "bundledelight:compat/farmersrespite/brewing/" + resultItemKey.getPath();
    }
    
    public void build(Consumer<FinishedData> consumerIn) {
        ResourceLocation baseFluidLocation = ForgeRegistries.FLUIDS.getKey(this.fluidIn.getFluid());
        ResourceLocation resultFluidLocation = ForgeRegistries.FLUIDS.getKey(this.fluidOut.getFluid());
        String var10002 = resultFluidLocation.getPath();
        this.build(consumerIn, "bundledelight:compat/farmersrespite/brewing/" + var10002 + "_from_" + baseFluidLocation.getPath());
    }

    public void build(Consumer<FinishedData> consumerIn, String save) {
        this.build(consumerIn, new ResourceLocation(save));
    }

    public void build(Consumer<FinishedData> consumerIn, ResourceLocation id) {
        consumerIn.accept(new KettleRecipeBuilder.Result(id, this.fluidIn, this.fluidOut, this.ingredients, this.brewingTime, this.experience, this.requiredBundle));
    }
    
    public static class Result implements FinishedData {
        @Getter
        private final ResourceLocation id;
        private final List<Ingredient> ingredients;
        private final int cookingTime;
        private final float experience;
        private final FluidStack fluidIn;
        private final FluidStack fluidOut;
        private final String requiredBundle;
        
        public Result(ResourceLocation idIn, FluidStack fluidIn, FluidStack fluidOut, List<Ingredient> ingredientsIn, int cookingTimeIn, float experienceIn, String requiredBundle) {
            this.id = idIn;
            this.fluidIn = fluidIn;
            this.fluidOut = fluidOut;
            this.ingredients = ingredientsIn;
            this.cookingTime = cookingTimeIn;
            this.experience = experienceIn;
            this.requiredBundle = requiredBundle;
        }
        
        public void serializeData(JsonObject json) {
            JsonArray arrayIngredients = new JsonArray();

            for(Ingredient ingredient : this.ingredients) {
                arrayIngredients.add(ingredient.toJson());
            }
            json.add("ingredients", arrayIngredients);
            JsonObject basefluid = new JsonObject();
            basefluid.addProperty("fluid", ForgeRegistries.FLUIDS.getKey(this.fluidIn.getFluid()).toString());
            basefluid.addProperty("count", this.fluidIn.getAmount());
            json.add("base", basefluid);
            JsonArray arrayConditions = new JsonArray();
            JsonObject objectCondition = new JsonObject();
            objectCondition.addProperty("type", "bundledelight:bundle_loaded");
            objectCondition.addProperty("bundle", this.requiredBundle);
            arrayConditions.add(objectCondition);
            JsonObject resultFluid = new JsonObject();
            resultFluid.addProperty("fluid", ForgeRegistries.FLUIDS.getKey(this.fluidOut.getFluid()).toString());
            resultFluid.addProperty("count", this.fluidOut.getAmount());
            json.add("result", resultFluid);
            if (this.experience > 0.0F) {
                json.addProperty("experience", this.experience);
            }

            json.addProperty("cookingtime", this.cookingTime);
            json.add("conditions", arrayConditions);
        }

        public ResourceLocation getType() {
            return new ResourceLocation("farmersrespite", "brewing");
        }
        
        @Nullable
        public JsonObject serializeAdvancement() {
            return null;
        }
        
        @Nullable
        public ResourceLocation getAdvancementId() {
            return null;
        }
    }
}
