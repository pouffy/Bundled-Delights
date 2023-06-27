package com.pouffy.bundledelight.util.data.builder.thermal;

import cofh.thermal.core.ThermalCore;
import cofh.thermal.core.init.TCoreRecipeTypes;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class BottlingRecipeBuilder {
    private final Item result;
    private final int resultCount;
    private final Item container;
    private final String fluid;
    private final int fluidAmount;
    private final String requiredMod;
    private static boolean shouldUseTag;
    private BottlingRecipeBuilder(ItemLike resultIn, int count, Item container, String fluid, int fluidAmount, String requiredMod, boolean shouldUseTag) {
        this.result = resultIn.asItem();
        this.resultCount = count;
        this.container = container;
        this.fluid = fluid;
        this.fluidAmount = fluidAmount;
        this.requiredMod = requiredMod;
        BottlingRecipeBuilder.shouldUseTag = shouldUseTag;
    }
    public static BottlingRecipeBuilder thermalBottling(ItemLike resultIn, int count, Item container, String fluid, int fluidAmount, String requiredMod, boolean shouldUseTag) {
        return new BottlingRecipeBuilder(resultIn, count, container, fluid, fluidAmount, requiredMod, shouldUseTag);
    }
    public void build(Consumer<FinishedRecipe> consumerIn) {
        ResourceLocation location = ForgeRegistries.ITEMS.getKey(this.result);
        this.build(consumerIn, "bundledelight:compat/thermal/bottling/" + location.getPath());
    }
    public void build(Consumer<FinishedRecipe> consumerIn, String save) {
        ResourceLocation resourcelocation = ForgeRegistries.ITEMS.getKey(this.result);
        if ((new ResourceLocation(save)).equals(resourcelocation)) {
            throw new IllegalStateException("Bottling Recipe " + save + " should remove its 'save' argument");
        } else {
            this.build(consumerIn, new ResourceLocation(save));
        }
    }
    public void build(Consumer<FinishedRecipe> consumerIn, ResourceLocation id) {
        consumerIn.accept(new BottlingRecipeBuilder.Result(id, this.result, this.resultCount, this.container, this.fluid, this.fluidAmount, this.requiredMod));
    }

    public static class Result implements FinishedRecipe {
        private final ResourceLocation id;
        private final Item result;
        private final Item container;
        private final int count;
        private final String fluid;
        private final int fluidAmount;
        private final String requiredMod;

        public Result(ResourceLocation idIn, Item resultIn, int countIn, Item container, String fluid, int fluidAmount, String requiredMod) {
            this.id = idIn;
            this.container = container;
            this.result = resultIn;
            this.count = countIn;
            this.fluid = fluid;
            this.fluidAmount = fluidAmount;
            this.requiredMod = requiredMod;
        }
        public void serializeRecipeData(JsonObject json) {
            JsonArray arrayConditions = new JsonArray();
            JsonObject objectCondition = new JsonObject();
            objectCondition.addProperty("type", "forge:mod_loaded");
            objectCondition.addProperty("modid", this.requiredMod);
            JsonObject objectCondition2 = new JsonObject();
            objectCondition2.addProperty("type", "forge:item_exists");
            objectCondition2.addProperty("item", ForgeRegistries.ITEMS.getKey(this.result).toString());
            arrayConditions.add(objectCondition);
            arrayConditions.add(objectCondition2);
            json.add("conditions", arrayConditions);
            JsonObject objectFluid = new JsonObject();
            if (!shouldUseTag) {
                objectFluid.addProperty("fluid", this.fluid.toString());
            } else {
                objectFluid.addProperty("fluid_tag", this.fluid.toString());
            }
            objectFluid.addProperty("amount", this.fluidAmount);
            JsonObject objectContainer = new JsonObject();
            objectContainer.addProperty("item", ForgeRegistries.ITEMS.getKey(this.container).toString());
            JsonArray arrayIngredients = new JsonArray();
            arrayIngredients.add(objectContainer);
            arrayIngredients.add(objectFluid);
            json.add("ingredients", arrayIngredients);
            JsonObject objectResult = new JsonObject();
            objectResult.addProperty("item", ForgeRegistries.ITEMS.getKey(this.result).toString());
            if (this.count > 1) {
                objectResult.addProperty("count", this.count);
            }
            JsonArray arrayResults = new JsonArray();
            arrayResults.add(objectResult);
            json.add("result", arrayResults);
        }

        public @NotNull ResourceLocation getId() {
            return this.id;
        }

        public @NotNull RecipeSerializer<?> getType() {
            return (RecipeSerializer) ThermalCore.RECIPE_SERIALIZERS.get(TCoreRecipeTypes.ID_RECIPE_BOTTLER);
        }

        @Nullable
        @Override
        public JsonObject serializeAdvancement() {
            return null;
        }

        @Nullable
        @Override
        public ResourceLocation getAdvancementId() {
            return null;
        }
    }
}
