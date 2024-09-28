package com.pouffydev.bundledelight.datagen.builder.recipe;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

public class BundleShapedRecipeBuilder implements RecipeBuilder {
    private final Item result;
    private final int count;
    private final List<String> rows = Lists.newArrayList();
    private final Map<Character, Ingredient> key = Maps.newLinkedHashMap();
    private final Advancement.Builder advancement = Advancement.Builder.advancement();
    @Nullable
    private String group;
    private final String requiredBundle;
    
    public BundleShapedRecipeBuilder(ItemLike pResult, int pCount, String requiredBundle) {
        this.result = pResult.asItem();
        this.count = pCount;
        this.requiredBundle = requiredBundle;
    }
    
    public static BundleShapedRecipeBuilder shaped(ItemLike pResult, String requiredBundle) {
        return shaped(pResult, 1, requiredBundle);
    }
    
    public static BundleShapedRecipeBuilder shaped(ItemLike pResult, int pCount, String requiredBundle) {
        return new BundleShapedRecipeBuilder(pResult, pCount, requiredBundle);
    }
    
    public BundleShapedRecipeBuilder define(Character pSymbol, TagKey<Item> pTag) {
        return this.define(pSymbol, Ingredient.of(pTag));
    }
    
    public BundleShapedRecipeBuilder define(Character pSymbol, ItemLike pItem) {
        return this.define(pSymbol, Ingredient.of(new ItemLike[]{pItem}));
    }
    
    public BundleShapedRecipeBuilder define(Character pSymbol, Ingredient pIngredient) {
        if (this.key.containsKey(pSymbol)) {
            throw new IllegalArgumentException("Symbol '" + pSymbol + "' is already defined!");
        } else if (pSymbol == ' ') {
            throw new IllegalArgumentException("Symbol ' ' (whitespace) is reserved and cannot be defined");
        } else {
            this.key.put(pSymbol, pIngredient);
            return this;
        }
    }
    
    public BundleShapedRecipeBuilder pattern(String pPattern) {
        if (!this.rows.isEmpty() && pPattern.length() != ((String)this.rows.get(0)).length()) {
            throw new IllegalArgumentException("Pattern must be the same width on every line!");
        } else {
            this.rows.add(pPattern);
            return this;
        }
    }
    
    public BundleShapedRecipeBuilder unlockedBy(String pCriterionName, CriterionTriggerInstance pCriterionTrigger) {
        this.advancement.addCriterion(pCriterionName, pCriterionTrigger);
        return this;
    }
    
    public BundleShapedRecipeBuilder group(@Nullable String pGroupName) {
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
        pFinishedRecipeConsumer.accept(new BundleShapedRecipeBuilder.Result(finalRecipeID, this.result, this.count, group, this.rows, this.key, this.advancement, new ResourceLocation(pRecipeId.getNamespace(), "recipes/" + this.result.getItemCategory().getRecipeFolderName() + "/" + pRecipeId.getPath()), this.requiredBundle));
    }
    
    private void ensureValid(ResourceLocation pId) {
        if (this.rows.isEmpty()) {
            throw new IllegalStateException("No pattern is defined for shaped recipe " + pId + "!");
        } else {
            Set<Character> $$1 = Sets.newHashSet(this.key.keySet());
            $$1.remove(' ');
            Iterator var3 = this.rows.iterator();
            
            while(var3.hasNext()) {
                String $$2 = (String)var3.next();
                
                for(int $$3 = 0; $$3 < $$2.length(); ++$$3) {
                    char $$4 = $$2.charAt($$3);
                    if (!this.key.containsKey($$4) && $$4 != ' ') {
                        throw new IllegalStateException("Pattern in recipe " + pId + " uses undefined symbol '" + $$4 + "'");
                    }
                    
                    $$1.remove($$4);
                }
            }
            
            if (!$$1.isEmpty()) {
                throw new IllegalStateException("Ingredients are defined but not used in pattern for recipe " + pId);
            } else if (this.rows.size() == 1 && ((String)this.rows.get(0)).length() == 1) {
                throw new IllegalStateException("Shaped recipe " + pId + " only takes in a single item - should it be a shapeless recipe instead?");
            } else if (this.advancement.getCriteria().isEmpty()) {
                throw new IllegalStateException("No way of obtaining recipe " + pId);
            }
        }
    }
    
    public static class Result implements FinishedRecipe {
        private final ResourceLocation id;
        private final Item result;
        private final int count;
        private final String group;
        private final List<String> pattern;
        private final Map<Character, Ingredient> key;
        private final Advancement.Builder advancement;
        private final ResourceLocation advancementId;
        private final String requiredBundle;
        
        public Result(ResourceLocation pId, Item pResult, int pCount, String pGroup, List<String> pPattern, Map<Character, Ingredient> pKey, Advancement.Builder pAdvancement, ResourceLocation pAdvancementId, String requiredBundle) {
            this.id = pId;
            this.result = pResult;
            this.count = pCount;
            this.group = pGroup;
            this.pattern = pPattern;
            this.key = pKey;
            this.advancement = pAdvancement;
            this.advancementId = pAdvancementId;
            this.requiredBundle = requiredBundle;
        }
        
        public void serializeRecipeData(JsonObject pJson) {
            if (!this.group.isEmpty()) {
                pJson.addProperty("group", this.group);
            }
            
            JsonArray pattern = new JsonArray();
            
            for (String patternValue : this.pattern) {
                pattern.add(patternValue);
            }
            
            JsonArray arrayConditions = new JsonArray();
            JsonObject objectCondition = new JsonObject();
            objectCondition.addProperty("type", "bundledelight:bundle_loaded");
            objectCondition.addProperty("bundle", this.requiredBundle);
            arrayConditions.add(objectCondition);
            pJson.add("conditions", arrayConditions);
            
            pJson.add("pattern", pattern);
            JsonObject key = new JsonObject();
            
            for (Map.Entry<Character, Ingredient> characterIngredientEntry : this.key.entrySet()) {
                key.add(String.valueOf(characterIngredientEntry.getKey()), characterIngredientEntry.getValue().toJson());
            }
            
            pJson.add("key", key);
            JsonObject result = new JsonObject();
            result.addProperty("item", Registry.ITEM.getKey(this.result).toString());
            if (this.count > 1) {
                result.addProperty("count", this.count);
            }
            
            pJson.add("result", result);
        }
        
        public RecipeSerializer<?> getType() {
            return RecipeSerializer.SHAPED_RECIPE;
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
