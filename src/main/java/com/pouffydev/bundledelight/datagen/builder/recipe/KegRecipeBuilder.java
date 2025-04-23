package com.pouffydev.bundledelight.datagen.builder.recipe;

import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.pouffydev.bundledelight.common.elements.item.BundleTeaItem;
import com.pouffydev.bundledelight.foundation.data.FinishedData;
import lombok.Getter;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.registries.ForgeRegistries;
import umpaz.brewinandchewin.client.recipebook.FermentingRecipeBookTab;
import umpaz.brewinandchewin.data.builder.KegFermentingRecipeBuilder;

import javax.annotation.Nullable;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;

public class KegRecipeBuilder {
    private final String requiredBundle;
    private final List<Ingredient> ingredients = Lists.newArrayList();
    private Optional<FluidStack> fluidIngredient = Optional.empty();
    private Optional<Fluid> resultFluid = Optional.empty();
    private Optional<Item> resultItem = Optional.empty();
    private Optional<FermentingRecipeBookTab> tab = Optional.empty();
    private final int fermentingTime;
    private final float experience;
    private final int temperature;
    private final int amount;
    private final Advancement.Builder advancement = Advancement.Builder.advancement();

    private KegRecipeBuilder(int amount, int fermentingTime, float experience, int temperature, String requiredBundle) {
        this.fermentingTime = fermentingTime;
        this.experience = experience;
        this.temperature = temperature;
        this.amount = amount;
        this.requiredBundle = requiredBundle;
    }
    
    public static KegRecipeBuilder kegRecipe(Item item, int amount, int fermentingTime, float experience, int temperature, String requiredBundle) {
        KegRecipeBuilder i = new KegRecipeBuilder(amount, fermentingTime, experience, temperature, requiredBundle);
        i.setResult(item);
        return i;
    }
    
    public static KegRecipeBuilder kegRecipe(Fluid fluid, int amount, int fermentingTime, float experience, int temperature, String requiredBundle) {
        KegRecipeBuilder i = new KegRecipeBuilder(amount, fermentingTime, experience, temperature, requiredBundle);
        i.setResult(fluid);
        return i;
    }
    
    public static KegRecipeBuilder kegRecipe(Item item, int amount, int fermentingTime, float experience, String requiredBundle) {
        KegRecipeBuilder i = new KegRecipeBuilder(amount, fermentingTime, experience, 3, requiredBundle);
        i.setResult(item);
        return i;
    }

    public static KegRecipeBuilder kegRecipe(Fluid fluid, int amount, int fermentingTime, float experience, String requiredBundle) {
        KegRecipeBuilder i = new KegRecipeBuilder(amount, fermentingTime, experience, 3, requiredBundle);
        i.setResult(fluid);
        return i;
    }

    private void setResult(Fluid fluid) {
        this.resultFluid = Optional.of(fluid);
    }

    private void setResult(Item item) {
        this.resultItem = Optional.of(item);
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

    public KegRecipeBuilder setRecipeBookTab(FermentingRecipeBookTab tab) {
        this.tab = Optional.of(tab);
        return this;
    }

    public KegRecipeBuilder unlockedBy(String criterionName, CriterionTriggerInstance criterionTrigger) {
        this.advancement.addCriterion(criterionName, criterionTrigger);
        return this;
    }

    public KegRecipeBuilder unlockedByItems(String criterionName, ItemLike... items) {
        return this.unlockedBy(criterionName, InventoryChangeTrigger.TriggerInstance.hasItems(items));
    }

    public KegRecipeBuilder unlockedByAnyIngredient(ItemLike... items) {
        this.advancement.addCriterion("has_any_ingredient", InventoryChangeTrigger.TriggerInstance.hasItems(new ItemPredicate[]{net.minecraft.advancements.critereon.ItemPredicate.Builder.item().of(items).build()}));
        return this;
    }

    public void build(Consumer<FinishedData> consumerIn) {
        if (!this.resultFluid.isPresent() && !this.resultItem.isPresent()) {
            throw new IllegalStateException("No result fluid or item");
        } else {
            if (this.resultItem.isPresent()) {
                ResourceLocation resultItemLocation = ForgeRegistries.ITEMS.getKey((Item)this.resultItem.get());
                this.build(consumerIn, "bundledelight:compat/brewinandchewin/fermenting/" + resultItemLocation.getPath());
            } else if (!this.fluidIngredient.isPresent()) {
                ResourceLocation resultFluidLocation = ForgeRegistries.FLUIDS.getKey((Fluid)this.resultFluid.get());
                this.build(consumerIn, "bundledelight:compat/brewinandchewin/fermenting/" + resultFluidLocation.getPath());
            } else {
                ResourceLocation baseFluidLocation = ForgeRegistries.FLUIDS.getKey(((FluidStack)this.fluidIngredient.get()).getFluid());
                ResourceLocation resultFluidLocation = ForgeRegistries.FLUIDS.getKey((Fluid)this.resultFluid.get());
                String var10002 = resultFluidLocation.getPath();
                this.build(consumerIn, "bundledelight:compat/brewinandchewin/fermenting/" + var10002 + "_from_" + baseFluidLocation.getPath());
            }

        }
    }

    public void build(Consumer<FinishedData> consumerIn, String save) {
        if (!this.resultFluid.isPresent() && !this.resultItem.isPresent()) {
            throw new IllegalStateException("No result fluid or item");
        } else {
            ResourceLocation resourcelocation = this.resultItem.isPresent() ? ForgeRegistries.ITEMS.getKey((Item)this.resultItem.get()) : ForgeRegistries.FLUIDS.getKey((Fluid)this.resultFluid.get());
            if ((new ResourceLocation(save)).equals(resourcelocation)) {
                throw new IllegalStateException("Fermenting Recipe " + save + " should remove its 'save' argument");
            } else {
                this.build(consumerIn, new ResourceLocation(save));
            }
        }
    }

    public KegRecipeBuilder addFluidIngredient(Fluid flowingFluid, int i) {
        this.fluidIngredient = Optional.of(new FluidStack(flowingFluid, i));
        return this;
    }

    public void build(Consumer<FinishedData> consumerIn, ResourceLocation id) {
        ResourceLocation advancementId = null;
        if (!this.advancement.getCriteria().isEmpty()) {
            this.advancement.parent(new ResourceLocation("recipes/root")).addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(id)).rewards(net.minecraft.advancements.AdvancementRewards.Builder.recipe(id)).requirements(RequirementsStrategy.OR);
            advancementId = id.withPath((path) -> "recipes/" + path);
        }

        consumerIn.accept(new KegRecipeBuilder.Result(id, this.fluidIngredient, this.tab, this.resultItem, this.resultFluid, this.amount, this.ingredients, this.fermentingTime, this.experience, this.temperature, this.advancement, advancementId, this.requiredBundle));
    }
    
    public static class Result implements FinishedData {
        @Getter
        private final ResourceLocation id;
        private final List<Ingredient> ingredients;
        private final Optional<FermentingRecipeBookTab> tab;
        private final Optional<FluidStack> fluidIngredient;
        private final Optional<Item> resultItem;
        private final Optional<Fluid> resultFluid;
        private final int fermentingTime;
        private final float experience;
        private final int temperature;
        private final int count;
        private final Advancement.Builder advancement;
        private final ResourceLocation advancementId;
        private final String requiredBundle;
        
        public Result(ResourceLocation idIn, Optional<FluidStack> fluidIngredient, Optional<FermentingRecipeBookTab> tab, Optional<Item> resultItemIn, Optional<Fluid> resultFluidIn, int count, List<Ingredient> ingredientsIn, int fermentingTimeIn, float experienceIn, int temperatureIn, @Nullable Advancement.Builder advancement, @Nullable ResourceLocation advancementId, String requiredBundle) {
            this.id = idIn;
            this.fluidIngredient = fluidIngredient;
            this.tab = tab;
            this.resultItem = resultItemIn;
            this.resultFluid = resultFluidIn;
            this.count = count;
            this.ingredients = ingredientsIn;
            this.fermentingTime = fermentingTimeIn;
            this.experience = experienceIn;
            this.temperature = temperatureIn;
            this.advancement = advancement;
            this.advancementId = advancementId;
            this.requiredBundle = requiredBundle;
        }
        
        public void serializeData(JsonObject json) {
            JsonArray arrayIngredients = new JsonArray();

            for(Ingredient ingredient : this.ingredients) {
                arrayIngredients.add(ingredient.toJson());
            }

            json.add("ingredients", arrayIngredients);
            JsonArray arrayConditions = new JsonArray();
            JsonObject objectCondition = new JsonObject();
            objectCondition.addProperty("type", "bundledelight:bundle_loaded");
            objectCondition.addProperty("bundle", this.requiredBundle);
            arrayConditions.add(objectCondition);
            //json.add("conditions", arrayConditions);
            json.add("ingredients", arrayIngredients);
            JsonObject result = new JsonObject();
            if (this.resultItem.isPresent()) {
                result.addProperty("item", ForgeRegistries.ITEMS.getKey((Item)this.resultItem.get()).toString());
            } else {
                result.addProperty("fluid", ForgeRegistries.FLUIDS.getKey((Fluid)this.resultFluid.get()).toString());
            }

            result.addProperty("count", this.count);
            json.add("result", result);
            if (this.fluidIngredient.isPresent()) {
                JsonObject basefluid = new JsonObject();
                basefluid.addProperty("fluid", ForgeRegistries.FLUIDS.getKey(((FluidStack)this.fluidIngredient.get()).getFluid()).toString());
                basefluid.addProperty("count", ((FluidStack)this.fluidIngredient.get()).getAmount());
                json.add("basefluid", basefluid);
            }

            this.tab.ifPresent((t) -> json.addProperty("recipe_book_tab", t.name));
            if (this.experience > 0.0F) {
                json.addProperty("experience", this.experience);
            }

            json.addProperty("fermentingtime", this.fermentingTime);
            json.addProperty("temperature", this.temperature);
        }

        public ResourceLocation getType() {
            return new ResourceLocation("brewinandchewin", "fermenting");
        }

        @Nullable
        public JsonObject serializeAdvancement() {
            return this.advancement != null ? this.advancement.serializeToJson() : null;
        }

        @Nullable
        public ResourceLocation getAdvancementId() {
            return this.advancementId;
        }
    }
}
