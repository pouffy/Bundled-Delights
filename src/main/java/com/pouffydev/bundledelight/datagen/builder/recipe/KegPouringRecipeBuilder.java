package com.pouffydev.bundledelight.datagen.builder.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.pouffydev.bundledelight.foundation.data.FinishedData;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.common.crafting.StrictNBTIngredient;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.ModLoadedCondition;
import net.minecraftforge.registries.ForgeRegistries;
import umpaz.brewinandchewin.common.registry.BnCRecipeSerializers;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class KegPouringRecipeBuilder {
    private ItemStack container;
    private final Fluid fluid;
    private final int amount;
    private final ItemStack output;
    private final boolean strict;
    private final boolean filling;
    private final List<ICondition> conditions = new ArrayList();
    private final String requiredBundle;

    private KegPouringRecipeBuilder(Fluid fluid, int amount, ItemStack output, boolean strict, boolean filling, String requiredBundle) {
        this.fluid = fluid;
        this.amount = amount;
        this.output = output;
        this.strict = strict;
        this.filling = filling;
        this.requiredBundle = requiredBundle;
    }

    public static KegPouringRecipeBuilder kegPouringRecipe(Fluid fluid, int amount, ItemStack output, boolean strict, String requiredBundle) {
        return new KegPouringRecipeBuilder(fluid, amount, output, strict, true, requiredBundle);
    }

    public static KegPouringRecipeBuilder kegPouringRecipe(Fluid fluid, int amount, ItemStack output, boolean strict, boolean filling, String requiredBundle) {
        return new KegPouringRecipeBuilder(fluid, amount, output, strict, filling, requiredBundle);
    }

    public static KegPouringRecipeBuilder kegPouringRecipe(Fluid fluid, int amount, ItemLike output, String requiredBundle) {
        return new KegPouringRecipeBuilder(fluid, amount, output.asItem().getDefaultInstance(), false, true, requiredBundle);
    }

    public static KegPouringRecipeBuilder kegPouringRecipe(Fluid fluid, int amount, ItemLike output, boolean filling, String requiredBundle) {
        return new KegPouringRecipeBuilder(fluid, amount, output.asItem().getDefaultInstance(), false, filling, requiredBundle);
    }

    public KegPouringRecipeBuilder withContainer(ItemLike container) {
        this.container = container.asItem().getDefaultInstance();
        return this;
    }

    public KegPouringRecipeBuilder withCondition(ICondition condition) {
        this.conditions.add(condition);
        return this;
    }

    public void build(Consumer<FinishedData> consumerIn) {
        ResourceLocation outputLocation = ForgeRegistries.ITEMS.getKey(this.output.getItem());
        this.build(consumerIn, "bundledelight:compat/brewinandchewin/pouring/" + outputLocation.getPath());
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
        if (!this.output.hasCraftingRemainingItem() && this.container == null) {
            throw new IllegalStateException("Pouring Recipe " + String.valueOf(id) + " must specify a container as the output does not have a remainder.");
        } else {
            consumerIn.accept(new KegPouringRecipeBuilder.Result(id, this.container, this.fluid, this.amount, this.output, this.strict, this.filling, this.conditions, this.requiredBundle));
        }
    }

    public static class Result implements FinishedData {
        private final ResourceLocation id;
        @Nullable
        private final ItemStack container;
        private final Fluid fluid;
        private final int amount;
        private final ItemStack output;
        private final boolean strict;
        private final boolean filling;
        private final List<ICondition> conditions;
        private final String requiredBundle;

        public Result(ResourceLocation idIn, ItemStack containerIn, Fluid fluidIn, int amountIn, ItemStack outputIn, boolean strict, boolean filling, List<ICondition> conditions, String requiredBundle) {
            this.id = idIn;
            this.container = containerIn;
            this.fluid = fluidIn;
            this.amount = amountIn;
            this.output = outputIn;
            this.strict = strict;
            this.filling = filling;
            this.conditions = conditions;
            this.requiredBundle = requiredBundle;
        }

        public void serializeData(JsonObject json) {
            JsonArray arrayConditions = new JsonArray();
            JsonObject objectCondition = new JsonObject();
            objectCondition.addProperty("type", "bundledelight:bundle_loaded");
            objectCondition.addProperty("bundle", this.requiredBundle);
            arrayConditions.add(objectCondition);
            json.add("conditions", arrayConditions);
            if (this.container != null) {
                JsonObject objectContainer = new JsonObject();
                objectContainer.addProperty("item", ForgeRegistries.ITEMS.getKey(this.container.getItem()).toString());
                if (this.container.hasTag()) {
                    objectContainer.addProperty("nbt", this.container.getTag().toString());
                }

                json.add("container", objectContainer);
            }

            JsonObject objectContainer1 = new JsonObject();
            objectContainer1.addProperty("item", ForgeRegistries.ITEMS.getKey(this.output.getItem()).toString());
            if (this.output.hasTag()) {
                objectContainer1.addProperty("nbt", this.output.getTag().toString());
            }

            json.add("output", objectContainer1);
            json.addProperty("fluid", ForgeRegistries.FLUIDS.getKey(this.fluid).toString());
            json.addProperty("amount", this.amount);
            json.addProperty("strict", this.strict);
            json.addProperty("filling", this.filling);
            if (!this.conditions.isEmpty()) {
                JsonArray conditions = new JsonArray();
                this.conditions.forEach((iCondition) -> conditions.add(CraftingHelper.serialize(iCondition)));
                json.add("conditions", conditions);
            }

        }

        public ResourceLocation getId() {
            return this.id;
        }

        public ResourceLocation getType() {
            return new ResourceLocation("brewinandchewin", "keg_pouring");
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
