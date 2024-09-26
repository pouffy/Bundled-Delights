package com.pouffydev.bundledelight.datagen.builder.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.pouffydev.bundledelight.foundation.data.FinishedData;
import com.pouffydev.bundledelight.foundation.helper.FluidHelper;
import com.pouffydev.bundledelight.foundation.helper.FluidIngredient;
import com.pouffydev.bundledelight.foundation.helper.RegisteredObjects;
import com.pouffydev.bundledelight.foundation.lang.Lang;
import com.pouffydev.bundledelight.foundation.util.Pair;
import com.tterrag.registrate.util.DataIngredient;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

public class CreateProcessingRecipeBuilder {
    private final ResourceLocation recipeType;
    private List<Ingredient> ingredients;
    private List<FluidIngredient> fluidIngredients;
    private List<FluidStack> fluidOutputs;
    private List<ProcessingOutput> outputs;

    private int processingDuration;
    private HeatCondition requiredHeat = HeatCondition.NONE;

    private String requiredBundle;

    public CreateProcessingRecipeBuilder(ResourceLocation recipeType, String requiredBundle) {
        this.recipeType = recipeType;
        this.requiredBundle = requiredBundle;
    }


    public CreateProcessingRecipeBuilder withItemIngredients(Ingredient... ingredients) {
        return withItemIngredients(NonNullList.of(Ingredient.EMPTY, ingredients));
    }

    public CreateProcessingRecipeBuilder withItemIngredients(NonNullList<Ingredient> ingredients) {
        this.ingredients = ingredients;
        return this;
    }

    public CreateProcessingRecipeBuilder withSingleItemOutput(ItemStack output) {
        return withItemOutputs(new ProcessingOutput(output, 1));
    }

    public CreateProcessingRecipeBuilder withItemOutputs(ProcessingOutput... outputs) {
        return withItemOutputs(NonNullList.of(ProcessingOutput.EMPTY, outputs));
    }

    public CreateProcessingRecipeBuilder withItemOutputs(NonNullList<ProcessingOutput> pOutputs) {
        this.outputs = pOutputs;
        return this;
    }

    public CreateProcessingRecipeBuilder withFluidIngredients(FluidIngredient... ingredients) {
        return withFluidIngredients(NonNullList.of(FluidIngredient.EMPTY, ingredients));
    }

    public CreateProcessingRecipeBuilder withFluidIngredients(NonNullList<FluidIngredient> ingredients) {
        this.fluidIngredients = ingredients;
        return this;
    }

    public CreateProcessingRecipeBuilder withFluidOutputs(FluidStack... outputs) {
        return withFluidOutputs(NonNullList.of(FluidStack.EMPTY, outputs));
    }

    public CreateProcessingRecipeBuilder withFluidOutputs(NonNullList<FluidStack> outputs) {
        this.fluidOutputs = outputs;
        return this;
    }

    public CreateProcessingRecipeBuilder duration(int ticks) {
        this.processingDuration = ticks;
        return this;
    }

    public CreateProcessingRecipeBuilder averageProcessingDuration() {
        return duration(100);
    }

    public CreateProcessingRecipeBuilder requiresHeat(HeatCondition condition) {
        this.requiredHeat = condition;
        return this;
    }

    public CreateProcessingRecipeBuilder require(TagKey<Item> tag) {
        return require(Ingredient.of(tag));
    }

    public CreateProcessingRecipeBuilder require(ItemLike item) {
        return require(Ingredient.of(item));
    }

    public CreateProcessingRecipeBuilder require(Ingredient ingredient) {
        this.ingredients.add(ingredient);
        return this;
    }

    public CreateProcessingRecipeBuilder require(ResourceLocation ingredient) {
        this.ingredients.add(DataIngredient.ingredient(null, ingredient));
        return this;
    }

    public CreateProcessingRecipeBuilder require(Fluid fluid, int amount) {
        return require(FluidIngredient.fromFluid(fluid, amount));
    }

    public CreateProcessingRecipeBuilder require(TagKey<Fluid> fluidTag, int amount) {
        return require(FluidIngredient.fromTag(fluidTag, amount));
    }

    public CreateProcessingRecipeBuilder require(FluidIngredient ingredient) {
        this.fluidIngredients.add(ingredient);
        return this;
    }

    public CreateProcessingRecipeBuilder output(ItemLike item) {
        return output(item, 1);
    }

    public CreateProcessingRecipeBuilder output(float chance, ItemLike item) {
        return output(chance, item, 1);
    }

    public CreateProcessingRecipeBuilder output(ItemLike item, int amount) {
        return output(1, item, amount);
    }

    public CreateProcessingRecipeBuilder output(float chance, ItemLike item, int amount) {
        return output(chance, new ItemStack(item, amount));
    }

    public CreateProcessingRecipeBuilder output(ItemStack output) {
        return output(1, output);
    }

    public CreateProcessingRecipeBuilder output(float chance, ItemStack output) {
        return output(new ProcessingOutput(output, chance));
    }

    public CreateProcessingRecipeBuilder output(float chance, ResourceLocation registryName, int amount) {
        return output(new ProcessingOutput(Pair.of(registryName, amount), chance));
    }

    public CreateProcessingRecipeBuilder output(ProcessingOutput output) {
        this.outputs.add(output);
        return this;
    }

    public CreateProcessingRecipeBuilder output(Fluid fluid, int amount) {
        fluid = FluidHelper.convertToStill(fluid);
        return output(new FluidStack(fluid, amount));
    }

    public CreateProcessingRecipeBuilder output(FluidStack fluidStack) {
        this.fluidOutputs.add(fluidStack);
        return this;
    }

    public void build(Consumer<FinishedData> consumerIn) {
        StringBuilder recipeId = new StringBuilder();
        for (Ingredient ingredient : ingredients) {
            recipeId.append(ingredient.getItems()
        }
        this.build(consumerIn, "bundledelight:compat/create/" + recipeType.getPath() + "/" + location.getPath());
    }
    public void build(Consumer<FinishedData> consumerIn, String save) {
        ResourceLocation resourcelocation = ForgeRegistries.ITEMS.getKey(this.result);
        if ((new ResourceLocation(save)).equals(resourcelocation)) {
            throw new IllegalStateException("Processing Recipe " + save + " should remove its 'save' argument");
        } else {
            this.build(consumerIn, new ResourceLocation(save));
        }
    }
    public void build(Consumer<FinishedData> consumerIn, ResourceLocation id) {
        consumerIn.accept(new Result(id, recipeType, ingredients, fluidIngredients, outputs, fluidOutputs, processingDuration, requiredHeat, requiredBundle));
    }

    public static class Result implements FinishedData {
        private final ResourceLocation id;
        private ResourceLocation recipeType;
        private final List<Ingredient> ingredients;
        private final List<FluidIngredient> fluidIngredients;
        private final List<FluidStack> fluidOutputs;
        private final List<ProcessingOutput> outputs;

        private int processingDuration;
        private HeatCondition requiredHeat = HeatCondition.NONE;


        private final String requiredBundle;


        public Result(ResourceLocation id, ResourceLocation recipeType, List<Ingredient> ingredients, List<FluidIngredient> fluidIngredients, List<ProcessingOutput> outputs, List<FluidStack> fluidOutputs, int processingDuration, HeatCondition requiredHeat, String requiredBundle) {
            this.id = id;
            this.recipeType = recipeType;
            this.ingredients = ingredients;
            this.fluidIngredients = fluidIngredients;
            this.outputs = outputs;
            this.fluidOutputs = fluidOutputs;
            this.processingDuration = processingDuration;
            this.requiredHeat = requiredHeat;

            this.requiredBundle = requiredBundle;
        }

        @Override
        public void serializeData(JsonObject json) {
            JsonArray arrayConditions = new JsonArray();
            JsonObject objectCondition = new JsonObject();
            objectCondition.addProperty("type", "bundledelight:bundle_loaded");
            objectCondition.addProperty("bundle", this.requiredBundle);
            arrayConditions.add(objectCondition);
            JsonArray jsonIngredients = new JsonArray();
            JsonArray jsonOutputs = new JsonArray();
            ingredients.forEach(i -> jsonIngredients.add(i.toJson()));
            fluidIngredients.forEach(i -> jsonIngredients.add(i.serialize()));

            outputs.forEach(o -> jsonOutputs.add(o.serialize()));
            fluidOutputs.forEach(o -> jsonOutputs.add(FluidHelper.serializeFluidStack(o)));

            if (processingDuration > 0)
                json.addProperty("processingTime", processingDuration);

            if (requiredHeat != HeatCondition.NONE)
                json.addProperty("heatRequirement", requiredHeat.serialize());
        }

        @Override
        public ResourceLocation getId() {
            return id;
        }

        @Override
        public ResourceLocation getType() {
            return recipeType;
        }

        @Override
        public JsonObject serializeAdvancement() {
            return null;
        }

        @Override
        public ResourceLocation getAdvancementId() {
            return null;
        }

    }

    static class ProcessingOutput {
        public static final ProcessingOutput EMPTY = new ProcessingOutput(ItemStack.EMPTY, 1);

        private static final Random r = new Random();
        private final ItemStack stack;
        private final float chance;

        private Pair<ResourceLocation, Integer> compatDatagenOutput;

        public ProcessingOutput(ItemStack stack, float chance) {
            this.stack = stack;
            this.chance = chance;
        }

        public ProcessingOutput(Pair<ResourceLocation, Integer> item, float chance) {
            this.stack = ItemStack.EMPTY;
            this.compatDatagenOutput = item;
            this.chance = chance;
        }

        public ItemStack getStack() {
            return stack;
        }

        public float getChance() {
            return chance;
        }

        public JsonElement serialize() {
            JsonObject json = new JsonObject();
            ResourceLocation resourceLocation = compatDatagenOutput == null ? RegisteredObjects.getKeyOrThrow(stack
                    .getItem()) : compatDatagenOutput.getFirst();
            json.addProperty("item", resourceLocation.toString());
            int count = compatDatagenOutput == null ? stack.getCount() : compatDatagenOutput.getSecond();
            if (count != 1)
                json.addProperty("count", count);
            if (stack.hasTag())
                json.add("nbt", JsonParser.parseString(stack.getTag()
                        .toString()));
            if (chance != 1)
                json.addProperty("chance", chance);
            return json;
        }
    }

    enum HeatCondition {
        NONE(0xffffff), HEATED(0xE88300), SUPERHEATED(0x5C93E8),

        ;

        private int color;

        private HeatCondition(int color) {
            this.color = color;
        }

        public String serialize() {
            return Lang.asId(name());
        }
    }
}
