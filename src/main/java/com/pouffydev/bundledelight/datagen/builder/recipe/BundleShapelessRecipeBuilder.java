package com.pouffydev.bundledelight.datagen.builder.recipe;

import lombok.Getter;
import net.minecraft.advancements.*;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.core.NonNullList;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.ShapelessRecipe;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.ICondition;

import javax.annotation.Nullable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class BundleShapelessRecipeBuilder implements RecipeBuilder {
    @Getter
    private final Item result;
    private final int count;
    private final ItemStack resultStack;
    private final NonNullList<Ingredient> ingredients;
    @Nullable
    private String group;
    private final RecipeCategory category;
    private final Map<String, Criterion<?>> criteria;

    public BundleShapelessRecipeBuilder(RecipeCategory category, ItemStack resultStack) {
        this.result = resultStack.getItem();
        this.count = resultStack.getCount();
        this.resultStack = resultStack;
        this.criteria = new LinkedHashMap<>();
        this.ingredients = NonNullList.create();
        this.category = category;
    }

    public  BundleShapelessRecipeBuilder(RecipeCategory category, ItemLike result, int count) {
        this(category, new ItemStack(result, count));
    }
    
    public static BundleShapelessRecipeBuilder shapeless(RecipeCategory category, ItemLike pResult) {
        return new BundleShapelessRecipeBuilder(category, pResult, 1);
    }
    
    public static BundleShapelessRecipeBuilder shapeless(RecipeCategory category, ItemLike pResult, int pCount) {
        return new BundleShapelessRecipeBuilder(category, pResult, pCount);
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
        for (int $$2 = 0; $$2 < pQuantity; ++$$2) {
            this.ingredients.add(pIngredient);
        }

        return this;
    }

    @Override
    public BundleShapelessRecipeBuilder unlockedBy(String pCriterionName, Criterion<?> criterion) {
        this.criteria.put(pCriterionName, criterion);
        return this;
    }

    public BundleShapelessRecipeBuilder group(@Nullable String pGroupName) {
        this.group = pGroupName;
        return this;
    }

    @Override
    public void save(RecipeOutput recipeOutput, ResourceLocation id) {
        this.ensureValid(id);
        Advancement.Builder advancement = recipeOutput.advancement().addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(id)).rewards(AdvancementRewards.Builder.recipe(id)).requirements(AdvancementRequirements.Strategy.OR);
        Map<String, Criterion<?>> criteria = this.criteria;
        Objects.requireNonNull(advancement);
        criteria.forEach(advancement::addCriterion);
        ShapelessRecipe shapelessrecipe = new ShapelessRecipe(Objects.requireNonNullElse(this.group, ""), RecipeBuilder.determineBookCategory(this.category), this.resultStack, this.ingredients);
        recipeOutput.accept(id, shapelessrecipe, advancement.build(id.withPrefix("recipes/" + this.category.getFolderName() + "/")));
    }

    public void save(RecipeOutput recipeOutput, ResourceLocation id, ICondition... conditions) {
        this.ensureValid(id);
        Advancement.Builder advancement = recipeOutput.advancement().addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(id)).rewards(AdvancementRewards.Builder.recipe(id)).requirements(AdvancementRequirements.Strategy.OR);
        Map<String, Criterion<?>> criteria = this.criteria;
        Objects.requireNonNull(advancement);
        criteria.forEach(advancement::addCriterion);
        ShapelessRecipe shapelessrecipe = new ShapelessRecipe(Objects.requireNonNullElse(this.group, ""), RecipeBuilder.determineBookCategory(this.category), this.resultStack, this.ingredients);
        recipeOutput.accept(id, shapelessrecipe, advancement.build(id.withPrefix("recipes/" + this.category.getFolderName() + "/")), conditions);
    }
    
    private void ensureValid(ResourceLocation id) {
        if (this.criteria.isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + id);
        }
    }
}
