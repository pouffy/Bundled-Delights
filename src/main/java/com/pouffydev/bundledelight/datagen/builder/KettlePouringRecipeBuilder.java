package com.pouffydev.bundledelight.datagen.builder;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.pouffydev.bundledelight.foundation.data.FinishedData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.function.Consumer;

public class KettlePouringRecipeBuilder {
    private final ItemStack container;
    private final Fluid fluid;
    private final int amount;
    private final ItemStack output;
    private final String requiredBundle;

    private KettlePouringRecipeBuilder(ItemStack container, Fluid fluid, int amount, ItemStack output, String requiredBundle) {
        this.container = container;
        this.fluid = fluid;
        this.amount = amount;
        this.output = output;
        this.requiredBundle = requiredBundle;
    }

    public static void kettlePouringRecipe(ItemLike container, Fluid fluid, int amount, ItemLike output, Consumer<FinishedData> consumer, String requiredBundle) {
        (new KettlePouringRecipeBuilder(container.asItem().getDefaultInstance(), fluid, amount, output.asItem().getDefaultInstance(), requiredBundle)).build(consumer);
    }

    public void build(Consumer<FinishedData> consumerIn) {
        ResourceLocation outputLocation = ForgeRegistries.ITEMS.getKey(this.output.getItem());
        this.build(consumerIn, "bundledelight:compat/farmersrespite/pouring/" + outputLocation.getPath());
    }

    public void build(Consumer<FinishedData> consumerIn, String save) {
        ResourceLocation resourcelocation = ForgeRegistries.ITEMS.getKey(this.output.getItem());
        if ((new ResourceLocation(save)).equals(resourcelocation)) {
            throw new IllegalStateException("Pouring Recipe " + save + " should remove its 'save' argument");
        } else {
            this.build(consumerIn, new ResourceLocation(save));
        }
    }

    public void build(Consumer<FinishedData> consumerIn, ResourceLocation id) {
        consumerIn.accept(new KettlePouringRecipeBuilder.Result(id, this.container, this.fluid, this.amount, this.output, this.requiredBundle));
    }

    public static class Result implements FinishedData {
        private final ResourceLocation id;
        private final ItemStack container;
        private final Fluid fluid;
        private final int amount;
        private final ItemStack output;
        private final String requiredBundle;

        public Result(ResourceLocation idIn, ItemStack containerIn, Fluid fluidIn, int amountIn, ItemStack outputIn, String requiredBundle) {
            this.id = idIn;
            this.container = containerIn;
            this.fluid = fluidIn;
            this.amount = amountIn;
            this.output = outputIn;
            this.requiredBundle = requiredBundle;
        }

        @Override
        public void serializeData(JsonObject json) {
            JsonObject objectContainer = new JsonObject();
            objectContainer.addProperty("item", ForgeRegistries.ITEMS.getKey(this.container.getItem()).toString());
            json.add("container", objectContainer);
            if (this.container.hasTag()) {
                objectContainer.addProperty("nbt", this.output.getTag().toString());
            }

            JsonObject objectContainer1 = new JsonObject();
            objectContainer1.addProperty("item", ForgeRegistries.ITEMS.getKey(this.output.getItem()).toString());
            if (this.output.hasTag()) {
                objectContainer1.addProperty("nbt", this.output.getTag().toString());
            }

            json.add("output", objectContainer1);
            json.addProperty("fluid", ForgeRegistries.FLUIDS.getKey(this.fluid).toString());
            json.addProperty("amount", this.amount);
            JsonArray arrayConditions = new JsonArray();
            JsonObject objectCondition = new JsonObject();
            objectCondition.addProperty("type", "bundledelight:bundle_loaded");
            objectCondition.addProperty("bundle", this.requiredBundle);
            arrayConditions.add(objectCondition);
            json.add("conditions", arrayConditions);
        }

        public ResourceLocation getId() {
            return this.id;
        }

        public ResourceLocation getType() {
            return new ResourceLocation("farmersrespite", "kettle_pouring");
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
