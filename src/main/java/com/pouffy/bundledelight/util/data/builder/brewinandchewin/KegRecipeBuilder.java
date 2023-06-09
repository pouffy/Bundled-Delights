package com.pouffy.bundledelight.util.data.builder.brewinandchewin;

import com.brewinandchewin.common.crafting.KegRecipe;
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

import javax.annotation.Nullable;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class KegRecipeBuilder {
    private final List<Ingredient> ingredients = Lists.newArrayList();
    private final Item result;
    private final int count;
    private final int cookingTime;
    private final float experience;
    private final Item container;
    private final Item liquid;
    private final int temperature;

    private KegRecipeBuilder(ItemLike resultIn, int count, int cookingTime, float experience, @Nullable ItemLike container, @Nullable ItemLike liquid, int temperature) {
        this.result = resultIn.asItem();
        this.count = count;
        this.liquid = liquid != null ? liquid.asItem() : null;
        this.cookingTime = cookingTime;
        this.experience = experience;
        this.container = container != null ? container.asItem() : null;
        this.temperature = temperature;
    }

    public static KegRecipeBuilder kegRecipe(ItemLike mainResult, int count, int cookingTime, float experience, ItemLike liquid, int temperature) {
        return new KegRecipeBuilder(mainResult, count, cookingTime, experience, (ItemLike)null, liquid, temperature);
    }

    public static KegRecipeBuilder kegRecipe(ItemLike mainResult, int count, int cookingTime, float experience, int temperature) {
        return new KegRecipeBuilder(mainResult, count, cookingTime, experience, (ItemLike)null, (ItemLike)null, temperature);
    }

    public static KegRecipeBuilder kegRecipe(ItemLike mainResult, int count, int cookingTime, float experience, ItemLike container, ItemLike liquid, int temperature) {
        return new KegRecipeBuilder(mainResult, count, cookingTime, experience, container, liquid, temperature);
    }

    public KegRecipeBuilder addIngredient(TagKey<Item> tagIn) {
        return this.addIngredient(Ingredient.of(tagIn));
    }

    public KegRecipeBuilder addIngredient(ItemLike itemIn) {
        return this.addIngredient((ItemLike)itemIn, 1);
    }

    public KegRecipeBuilder addIngredient(ItemLike itemIn, int quantity) {
        for(int i = 0; i < quantity; ++i) {
            this.addIngredient(Ingredient.of(new ItemLike[]{itemIn}));
        }

        return this;
    }

    public KegRecipeBuilder addIngredient(Ingredient ingredientIn) {
        return this.addIngredient((Ingredient)ingredientIn, 1);
    }

    public KegRecipeBuilder addIngredient(Ingredient ingredientIn, int quantity) {
        for(int i = 0; i < quantity; ++i) {
            this.ingredients.add(ingredientIn);
        }

        return this;
    }

    public void build(Consumer<FinishedRecipe> consumerIn) {
        ResourceLocation location = ForgeRegistries.ITEMS.getKey(this.result);
        this.build(consumerIn, "bundledelight:compat/brewinandchewin/fermenting/" + location.getPath());
    }

    public void build(Consumer<FinishedRecipe> consumerIn, String save) {
        ResourceLocation resourcelocation = ForgeRegistries.ITEMS.getKey(this.result);
        if ((new ResourceLocation(save)).equals(resourcelocation)) {
            throw new IllegalStateException("Fermenting Recipe " + save + " should remove its 'save' argument");
        } else {
            this.build(consumerIn, new ResourceLocation(save));
        }
    }

    public void build(Consumer<FinishedRecipe> consumerIn, ResourceLocation id) {
        consumerIn.accept(new KegRecipeBuilder.Result(id, this.result, this.count, this.ingredients, this.cookingTime, this.experience, this.container, this.liquid, this.temperature));
    }

    public static class Result implements FinishedRecipe {
        private final ResourceLocation id;
        private final List<Ingredient> ingredients;
        private final Item result;
        private final int count;
        private final int cookingTime;
        private final float experience;
        private final Item container;
        private final Item liquid;
        private final int temperature;

        public Result(ResourceLocation idIn, Item resultIn, int countIn, List<Ingredient> ingredientsIn, int cookingTimeIn, float experienceIn, @Nullable Item containerIn, @Nullable Item liquidIn, int temperatureIn) {
            this.id = idIn;
            this.ingredients = ingredientsIn;
            this.result = resultIn;
            this.count = countIn;
            this.cookingTime = cookingTimeIn;
            this.experience = experienceIn;
            this.container = containerIn;
            this.liquid = liquidIn;
            this.temperature = temperatureIn;
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
            objectCondition.addProperty("modid", "brewinandchewin");
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
            JsonObject objectLiquid;
            if (this.container != null) {
                objectLiquid = new JsonObject();
                objectLiquid.addProperty("item", ForgeRegistries.ITEMS.getKey(this.container).toString());
                json.add("container", objectLiquid);
            }

            if (this.liquid != null) {
                objectLiquid = new JsonObject();
                objectLiquid.addProperty("item", ForgeRegistries.ITEMS.getKey(this.liquid).toString());
                json.add("liquid", objectLiquid);
            }

            if (this.experience > 0.0F) {
                json.addProperty("experience", this.experience);
            }

            json.addProperty("cookingtime", this.cookingTime);
            json.addProperty("temperature", this.temperature);
        }

        public ResourceLocation getId() {
            return this.id;
        }

        public RecipeSerializer<?> getType() {
            return KegRecipe.SERIALIZER;
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
