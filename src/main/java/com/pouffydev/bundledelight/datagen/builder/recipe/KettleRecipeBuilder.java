package com.pouffydev.bundledelight.datagen.builder.recipe;

import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.pouffydev.bundledelight.foundation.data.FinishedData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class KettleRecipeBuilder {
    private final List<Ingredient> ingredients = Lists.newArrayList();
    private final Item result;
    private final int count;
    private final int brewingTime;
    private final float experience;
    private final Item container;
    private final boolean needWater;
    private final String requiredBundle;
    
    private KettleRecipeBuilder(ItemLike resultIn, @Nullable int count, @Nullable int brewingTime, @Nullable float experience, @Nullable boolean needWater, @Nullable ItemLike container, String requiredBundle) {
        this.result = resultIn.asItem();
        this.count = count;
        this.brewingTime = brewingTime;
        this.experience = experience;
        this.container = container != null ? container.asItem() : null;
        this.needWater = needWater;
        this.requiredBundle = requiredBundle;
    }
    
    public static KettleRecipeBuilder kettleRecipe(ItemLike mainResult, String requiredBundle) {
        return new KettleRecipeBuilder(mainResult, 1, 2400, 0.35F, true, (ItemLike)null, requiredBundle);
    }
    
    public static KettleRecipeBuilder kettleRecipe(ItemLike mainResult, int count, int brewingTime, float experience, boolean needWater, ItemLike container, String requiredBundle) {
        return new KettleRecipeBuilder(mainResult, count, brewingTime, experience, needWater, container, requiredBundle);
    }
    
    public KettleRecipeBuilder addIngredient(TagKey<Item> tagIn) {
        return this.addIngredient(Ingredient.of(tagIn));
    }
    
    public KettleRecipeBuilder addIngredient(ItemLike itemIn) {
        return this.addIngredient((ItemLike)itemIn, 1);
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
    
    public void build(Consumer<FinishedData> consumerIn) {
        ResourceLocation location = ForgeRegistries.ITEMS.getKey(this.result);
        this.build(consumerIn, "bundledelight:compat/farmersrespite/brewing/" + location.getPath());
    }
    
    public void build(Consumer<FinishedData> consumerIn, String save) {
        ResourceLocation resourcelocation = ForgeRegistries.ITEMS.getKey(this.result);
        if ((new ResourceLocation(save)).equals(resourcelocation)) {
            throw new IllegalStateException("Brewing Recipe " + save + " should remove its 'save' argument");
        } else {
            this.build(consumerIn, new ResourceLocation(save));
        }
    }
    
    public void build(Consumer<FinishedData> consumerIn, ResourceLocation id) {
        consumerIn.accept(new KettleRecipeBuilder.Result(id, this.result, this.count, this.ingredients, this.brewingTime, this.experience, this.needWater, this.container, this.requiredBundle));
    }
    
    public static class Result implements FinishedData {
        private final ResourceLocation id;
        private final List<Ingredient> ingredients;
        private final Item result;
        private final int count;
        private final int brewingTime;
        private final float experience;
        private final boolean needWater;
        private final Item container;
        private final String requiredBundle;
        
        public Result(ResourceLocation idIn, Item resultIn, int countIn, List<Ingredient> ingredientsIn, int brewingTimeIn, float experienceIn, @Nullable boolean needWaterIn, @Nullable Item containerIn, String requiredBundle) {
            this.id = idIn;
            this.ingredients = ingredientsIn;
            this.result = resultIn;
            this.count = countIn;
            this.brewingTime = brewingTimeIn;
            this.experience = experienceIn;
            this.needWater = needWaterIn;
            this.container = containerIn;
            this.requiredBundle = requiredBundle;
        }
        
        public void serializeData(JsonObject json) {
            JsonArray arrayIngredients = new JsonArray();
            String item = ForgeRegistries.ITEMS.getKey(this.result).getPath();
            String clearedName = item.replace("strong_", "").replace("long_", "");
            for (Ingredient ingredient : this.ingredients) {
                arrayIngredients.add(ingredient.toJson());
            }
            JsonArray arrayConditions = new JsonArray();
            //JsonObject objectCondition = new JsonObject();
            //objectCondition.addProperty("type", "bundledelight:bundle_loaded");
            //objectCondition.addProperty("bundle", this.requiredBundle);
            JsonObject objectCondition2 = new JsonObject();
            objectCondition2.addProperty("type", "forge:item_exists");
            objectCondition2.addProperty("item", ForgeRegistries.ITEMS.getKey(this.result).toString());
            //arrayConditions.add(objectCondition);
            arrayConditions.add(objectCondition2);

            JsonObject objectResult = new JsonObject();
            objectResult.addProperty("item", ForgeRegistries.ITEMS.getKey(this.result).toString());
            if (this.count > 1) {
                objectResult.addProperty("count", this.count);
            }
            if (this.container != null) {
                JsonObject objectContainer = new JsonObject();
                objectContainer.addProperty("item", ForgeRegistries.ITEMS.getKey(this.container).toString());
                json.add("container", objectContainer);
            }
            json.addProperty("cookingtime", this.brewingTime);
            if (this.experience > 0.0F) {
                json.addProperty("experience", this.experience);
            }
            json.addProperty("group", clearedName);
            json.add("ingredients", arrayIngredients);
            json.addProperty("needwater", this.needWater);
            json.addProperty("recipe_book_tab", "drinks");
            json.add("result", objectResult);
            json.add("conditions", arrayConditions);
        }
        
        public ResourceLocation getId() {
            return this.id;
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
