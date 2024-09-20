package com.pouffy.bundledelight.util.data.builder.farmersrespite;

import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.ForgeRegistries;
import umpaz.farmersrespite.common.registry.FRRecipeSerializers;

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

    private KettleRecipeBuilder(ItemLike resultIn, @Nullable int count, @Nullable int brewingTime, @Nullable float experience, @Nullable boolean needWater, @Nullable ItemLike container) {
        this.result = resultIn.asItem();
        this.count = count;
        this.brewingTime = brewingTime;
        this.experience = experience;
        this.container = container != null ? container.asItem() : null;
        this.needWater = needWater;
    }

    public static KettleRecipeBuilder kettleRecipe(ItemLike mainResult) {
        return new KettleRecipeBuilder(mainResult, 1, 2400, 0.35F, true, (ItemLike)null);
    }

    public static KettleRecipeBuilder kettleRecipe(ItemLike mainResult, int count, int brewingTime, float experience, boolean needWater, ItemLike container) {
        return new KettleRecipeBuilder(mainResult, count, brewingTime, experience, needWater, container);
    }

    public KettleRecipeBuilder addIngredient(TagKey<Item> tagIn) {
        return this.addIngredient(Ingredient.of(tagIn));
    }

    public KettleRecipeBuilder addIngredient(ItemLike itemIn) {
        return this.addIngredient((ItemLike)itemIn, 1);
    }

    public KettleRecipeBuilder addIngredient(ItemLike itemIn, int quantity) {
        for(int i = 0; i < quantity; ++i) {
            this.addIngredient(Ingredient.of(new ItemLike[]{itemIn}));
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

    public void build(Consumer<FinishedRecipe> consumerIn) {
        ResourceLocation location = ForgeRegistries.ITEMS.getKey(this.result);
        this.build(consumerIn, "bundledelight:compat/farmersrespite/brewing/" + location.getPath());
    }

    public void build(Consumer<FinishedRecipe> consumerIn, String save) {
        ResourceLocation resourcelocation = ForgeRegistries.ITEMS.getKey(this.result);
        if ((new ResourceLocation(save)).equals(resourcelocation)) {
            throw new IllegalStateException("Brewing Recipe " + save + " should remove its 'save' argument");
        } else {
            this.build(consumerIn, new ResourceLocation(save));
        }
    }

    public void build(Consumer<FinishedRecipe> consumerIn, ResourceLocation id) {
        consumerIn.accept(new KettleRecipeBuilder.Result(id, this.result, this.count, this.ingredients, this.brewingTime, this.experience, this.needWater, this.container));
    }

    public static class Result implements FinishedRecipe {
        private final ResourceLocation id;
        private final List<Ingredient> ingredients;
        private final Item result;
        private final int count;
        private final int brewingTime;
        private final float experience;
        private final boolean needWater;
        private final Item container;

        public Result(ResourceLocation idIn, Item resultIn, int countIn, List<Ingredient> ingredientsIn, int brewingTimeIn, float experienceIn, @Nullable boolean needWaterIn, @Nullable Item containerIn) {
            this.id = idIn;
            this.ingredients = ingredientsIn;
            this.result = resultIn;
            this.count = countIn;
            this.brewingTime = brewingTimeIn;
            this.experience = experienceIn;
            this.needWater = needWaterIn;
            this.container = containerIn;
        }

        public void serializeRecipeData(JsonObject json) {
            JsonArray arrayIngredients = new JsonArray();
            Iterator var3 = this.ingredients.iterator();

            while(var3.hasNext()) {
                Ingredient ingredient = (Ingredient)var3.next();
                arrayIngredients.add(ingredient.toJson());
            }
            JsonArray arrayConditions = new JsonArray();
            JsonObject objectCondition = new JsonObject();
            objectCondition.addProperty("type", "forge:mod_loaded");
            objectCondition.addProperty("modid", "farmersrespite");
            JsonObject objectCondition2 = new JsonObject();
            objectCondition2.addProperty("type", "forge:item_exists");
            objectCondition2.addProperty("item", ForgeRegistries.ITEMS.getKey(this.result).toString());
            arrayConditions.add(objectCondition);
            arrayConditions.add(objectCondition2);
            json.add("conditions", arrayConditions);

            json.add("ingredients", arrayIngredients);
            JsonObject objectResult = new JsonObject();
            objectResult.addProperty("item", ForgeRegistries.ITEMS.getKey(this.result).toString());
            if (this.count > 1) {
                objectResult.addProperty("count", this.count);
            }

            json.add("result", objectResult);
            if (this.container != null) {
                JsonObject objectContainer = new JsonObject();
                objectContainer.addProperty("item", ForgeRegistries.ITEMS.getKey(this.container).toString());
                json.add("container", objectContainer);
            }

            if (this.experience > 0.0F) {
                json.addProperty("experience", this.experience);
            }

            json.addProperty("brewingtime", this.brewingTime);
            json.addProperty("needwater", this.needWater);
        }

        public ResourceLocation getId() {
            return this.id;
        }

        public RecipeSerializer<?> getType() {
            return FRRecipeSerializers.BREWING.get();
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
