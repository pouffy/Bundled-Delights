package com.pouffydev.bundledelight.datagen.builder.recipe;

import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.core.Registry;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Consumer;

public class BundleShapelessRecipeBuilder implements RecipeBuilder {
    private final Item result;
    private final int count;
    private final List<Ingredient> ingredients = Lists.newArrayList();
    private final Advancement.Builder advancement = Advancement.Builder.advancement();
    @Nullable
    private String group;
    private final String requiredBundle;
    
    public BundleShapelessRecipeBuilder(ItemLike pResult, int pCount, String requiredBundle) {
        this.result = pResult.asItem();
        this.count = pCount;
        this.requiredBundle = requiredBundle;
    }
    
    public static BundleShapelessRecipeBuilder shapeless(ItemLike pResult, String requiredBundle) {
        return new BundleShapelessRecipeBuilder(pResult, 1, requiredBundle);
    }
    
    public static BundleShapelessRecipeBuilder shapeless(ItemLike pResult, int pCount, String requiredBundle) {
        return new BundleShapelessRecipeBuilder(pResult, pCount, requiredBundle);
    }
    
    public BundleShapelessRecipeBuilder requires(TagKey<Item> pTag) {
        return this.requires(Ingredient.of(pTag));
    }
    
    public BundleShapelessRecipeBuilder requires(ItemLike pItem) {
        return this.requires((ItemLike)pItem, 1);
    }
    
    public BundleShapelessRecipeBuilder requires(ItemLike pItem, int pQuantity) {
        for(int $$2 = 0; $$2 < pQuantity; ++$$2) {
            this.requires(Ingredient.of(new ItemLike[]{pItem}));
        }
        
        return this;
    }
    
    public BundleShapelessRecipeBuilder requires(Ingredient pIngredient) {
        return this.requires((Ingredient)pIngredient, 1);
    }
    
    public BundleShapelessRecipeBuilder requires(Ingredient pIngredient, int pQuantity) {
        for(int $$2 = 0; $$2 < pQuantity; ++$$2) {
            this.ingredients.add(pIngredient);
        }
        
        return this;
    }
    
    public BundleShapelessRecipeBuilder unlockedBy(String pCriterionName, CriterionTriggerInstance pCriterionTrigger) {
        this.advancement.addCriterion(pCriterionName, pCriterionTrigger);
        return this;
    }
    
    public BundleShapelessRecipeBuilder group(@Nullable String pGroupName) {
        this.group = pGroupName;
        return this;
    }
    
    public Item getResult() {
        return this.result;
    }
    
    public void save(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ResourceLocation pRecipeId) {
        this.ensureValid(pRecipeId);
        this.advancement.parent(ROOT_RECIPE_ADVANCEMENT).addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(pRecipeId)).rewards(net.minecraft.advancements.AdvancementRewards.Builder.recipe(pRecipeId)).requirements(RequirementsStrategy.OR);
        String group = this.group == null ? "" : this.group;
        ResourceLocation finalRecipeID = new ResourceLocation(pRecipeId.getNamespace(), "crafting/" + pRecipeId.getPath());
        pFinishedRecipeConsumer.accept(new BundleShapelessRecipeBuilder.Result(finalRecipeID, this.result, this.count, group, this.ingredients, this.advancement, new ResourceLocation(pRecipeId.getNamespace(), "recipes/" + this.result.getItemCategory().getRecipeFolderName() + "/" + pRecipeId.getPath()), this.requiredBundle));
    }
    
    private void ensureValid(ResourceLocation pId) {
        if (this.advancement.getCriteria().isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + pId);
        }
    }
    
    public static class Result implements FinishedRecipe {
        private final ResourceLocation id;
        private final Item result;
        private final int count;
        private final String group;
        private final List<Ingredient> ingredients;
        private final Advancement.Builder advancement;
        private final ResourceLocation advancementId;
        private final String requiredBundle;
        
        public Result(ResourceLocation pId, Item pResult, int pCount, String pGroup, List<Ingredient> pIngredients, Advancement.Builder pAdvancement, ResourceLocation pAdvancementId, String requiredBundle) {
            this.id = pId;
            this.result = pResult;
            this.count = pCount;
            this.group = pGroup;
            this.ingredients = pIngredients;
            this.advancement = pAdvancement;
            this.advancementId = pAdvancementId;
            this.requiredBundle = requiredBundle;
        }
        
        public void serializeRecipeData(JsonObject pJson) {
            if (!this.group.isEmpty()) {
                pJson.addProperty("group", this.group);
            }
            
            JsonArray ingredients = new JsonArray();
            
            for (Ingredient ingredient : this.ingredients) {
                ingredients.add(ingredient.toJson());
            }
            
            JsonArray arrayConditions = new JsonArray();
            JsonObject objectCondition = new JsonObject();
            objectCondition.addProperty("type", "bundledelight:bundle_loaded");
            objectCondition.addProperty("bundle", this.requiredBundle);
            arrayConditions.add(objectCondition);
            pJson.add("conditions", arrayConditions);
            
            pJson.add("ingredients", ingredients);
            JsonObject result = new JsonObject();
            result.addProperty("item", Registry.ITEM.getKey(this.result).toString());
            if (this.count > 1) {
                result.addProperty("count", this.count);
            }
            
            pJson.add("result", result);
        }
        
        public RecipeSerializer<?> getType() {
            return RecipeSerializer.SHAPELESS_RECIPE;
        }
        
        public ResourceLocation getId() {
            return this.id;
        }
        
        @Nullable
        public JsonObject serializeAdvancement() {
            return this.advancement.serializeToJson();
        }
        
        @Nullable
        public ResourceLocation getAdvancementId() {
            return this.advancementId;
        }
    }
}
