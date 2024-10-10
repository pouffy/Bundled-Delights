package com.pouffydev.bundledelight.init.bundles.miners_brew.data.recipe;

import com.pouffydev.bundledelight.BundledDelight;
import com.pouffydev.bundledelight.datagen.builder.recipe.BundleShapedRecipeBuilder;
import com.pouffydev.bundledelight.foundation.data.BundleRecipeGen;
import com.pouffydev.bundledelight.init.bundles.miners_brew.MinersBrewItems;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

public class MinersBrewCrafting extends BundleRecipeGen {
    private static final String BUNDLE_NAME = "miners_brew";

    public MinersBrewCrafting() {
    }

    public static void register(Consumer<FinishedRecipe> consumer) {
        recipesMaterials(consumer);
    }

    private static void recipesMaterials(Consumer<FinishedRecipe> consumer) {
        BundleShapedRecipeBuilder.shaped(MinersBrewItems.copperSwig.get(), BUNDLE_NAME)
                .pattern("# #")
                .pattern("- -")
                .pattern("###")
                .define('-', Tags.Items.NUGGETS_IRON)
                .define('#', Tags.Items.INGOTS_COPPER)
                .unlockedBy("has_copper", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(Tags.Items.INGOTS_COPPER).build()))
                .save(consumer, new ResourceLocation(BundledDelight.MODID, "copper_swig"));
    }

    @Override
    public String getBundleName() {
        return BUNDLE_NAME;
    }
}
