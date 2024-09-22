package com.pouffydev.bundledelight.datagen.builder.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.pouffydev.bundledelight.foundation.data.FinishedData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.function.Consumer;

public class BottlingRecipeBuilder {
    private final Item result;
    private final int resultCount;
    private final Item container;
    private final String fluid;
    private final int fluidAmount;
    private final String requiredBundle;
    private static boolean shouldUseTag;
    private BottlingRecipeBuilder(ItemLike resultIn, int count, Item container, String fluid, int fluidAmount, String requiredBundle, boolean shouldUseTag) {
        this.result = resultIn.asItem();
        this.resultCount = count;
        this.container = container;
        this.fluid = fluid;
        this.fluidAmount = fluidAmount;
        this.requiredBundle = requiredBundle;
        BottlingRecipeBuilder.shouldUseTag = shouldUseTag;
    }
    public static BottlingRecipeBuilder thermalBottling(ItemLike resultIn, int count, Item container, String fluid, int fluidAmount, String requiredBundle, boolean shouldUseTag) {
        return new BottlingRecipeBuilder(resultIn, count, container, fluid, fluidAmount, requiredBundle, shouldUseTag);
    }
    public void build(Consumer<FinishedData> consumerIn) {
        ResourceLocation location = ForgeRegistries.ITEMS.getKey(this.result);
        this.build(consumerIn, "bundledelight:compat/thermal/bottling/" + location.getPath());
    }
    public void build(Consumer<FinishedData> consumerIn, String save) {
        ResourceLocation resourcelocation = ForgeRegistries.ITEMS.getKey(this.result);
        if ((new ResourceLocation(save)).equals(resourcelocation)) {
            throw new IllegalStateException("Bottling Recipe " + save + " should remove its 'save' argument");
        } else {
            this.build(consumerIn, new ResourceLocation(save));
        }
    }
    public void build(Consumer<FinishedData> consumerIn, ResourceLocation id) {
        consumerIn.accept(new BottlingRecipeBuilder.Result(id, this.result, this.resultCount, this.container, this.fluid, this.fluidAmount, this.requiredBundle));
    }
    
    public static class Result implements FinishedData {
        private final ResourceLocation id;
        private final Item result;
        private final Item container;
        private final int count;
        private final String fluid;
        private final int fluidAmount;
        private final String requiredBundle;
        
        public Result(ResourceLocation idIn, Item resultIn, int countIn, Item container, String fluid, int fluidAmount, String requiredBundle) {
            this.id = idIn;
            this.container = container;
            this.result = resultIn;
            this.count = countIn;
            this.fluid = fluid;
            this.fluidAmount = fluidAmount;
            this.requiredBundle = requiredBundle;
        }
        public void serializeData(JsonObject json) {
            JsonArray arrayConditions = new JsonArray();
            JsonObject objectCondition = new JsonObject();
            objectCondition.addProperty("type", "bundledelight:bundle_loaded");
            objectCondition.addProperty("bundle", this.requiredBundle);
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
        
        public @NotNull ResourceLocation getType() {
            return new ResourceLocation("thermal", "bottler");
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
