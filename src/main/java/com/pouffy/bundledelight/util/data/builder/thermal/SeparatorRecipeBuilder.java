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

public class SeparatorRecipeBuilder {
    private final Item result;
    private final int resultCount;
    private final Item container;
    private final String fluid;
    private final int fluidAmount;
    private final String requiredMod;
    private SeparatorRecipeBuilder(Item container, ItemLike resultIn, int count, String fluid, int fluidAmount, String requiredMod) {
        this.result = resultIn.asItem();
        this.resultCount = count;
        this.container = container;
        this.fluid = fluid;
        this.fluidAmount = fluidAmount;
        this.requiredMod = requiredMod;
    }
    public static SeparatorRecipeBuilder thermalSeparator(Item container, ItemLike resultIn, int count, String fluid, int fluidAmount, String requiredMod) {
        return new SeparatorRecipeBuilder(container, resultIn, count, fluid, fluidAmount, requiredMod);
    }
    public void build(Consumer<FinishedRecipe> consumerIn) {
        ResourceLocation location = ForgeRegistries.ITEMS.getKey(this.container);
        this.build(consumerIn, "bundledelight:compat/thermal/centrifuge/" + location.getPath());
    }
    public void build(Consumer<FinishedRecipe> consumerIn, String save) {
        ResourceLocation resourcelocation = ForgeRegistries.ITEMS.getKey(this.result);
        if ((new ResourceLocation(save)).equals(resourcelocation)) {
            throw new IllegalStateException("Separator Recipe " + save + " should remove its 'save' argument");
        } else {
            this.build(consumerIn, new ResourceLocation(save));
        }
    }
    public void build(Consumer<FinishedRecipe> consumerIn, ResourceLocation id) {
        consumerIn.accept(new SeparatorRecipeBuilder.Result(id, this.result, this.resultCount, this.container, this.fluid, this.fluidAmount, this.requiredMod));
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
            objectCondition2.addProperty("item", ForgeRegistries.ITEMS.getKey(this.container).toString());
            arrayConditions.add(objectCondition);
            arrayConditions.add(objectCondition2);
            json.add("conditions", arrayConditions);
            JsonObject objectIngredient = new JsonObject();
            objectIngredient.addProperty("item", ForgeRegistries.ITEMS.getKey(this.container).toString());
            json.add("ingredient", objectIngredient);
            JsonObject objectFluid = new JsonObject();
            objectFluid.addProperty("fluid", this.fluid.toString());
            objectFluid.addProperty("amount", this.fluidAmount);
            JsonObject objectContainer = new JsonObject();
            objectContainer.addProperty("item", ForgeRegistries.ITEMS.getKey(this.result).toString());
            if (this.count > 1) {objectContainer.addProperty("count", this.count);}
            JsonArray arrayResults = new JsonArray();
            arrayResults.add(objectContainer);
            arrayResults.add(objectFluid);
            json.add("result", arrayResults);


        }

        public @NotNull ResourceLocation getId() {
            return this.id;
        }

        public @NotNull RecipeSerializer<?> getType() {
            return (RecipeSerializer) ThermalCore.RECIPE_SERIALIZERS.get(TCoreRecipeTypes.ID_CENTRIFUGE_RECIPE);
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
