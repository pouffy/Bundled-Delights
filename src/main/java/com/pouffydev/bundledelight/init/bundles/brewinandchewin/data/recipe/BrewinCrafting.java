package com.pouffydev.bundledelight.init.bundles.brewinandchewin.data.recipe;

import com.pouffydev.bundledelight.BundledDelight;
import com.pouffydev.bundledelight.datagen.builder.recipe.BundleShapedRecipeBuilder;
import com.pouffydev.bundledelight.foundation.data.BundleRecipeGen;
import com.pouffydev.bundledelight.init.bundles.brewinandchewin.BrewinItems;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

public class BrewinCrafting extends BundleRecipeGen {
    private static final String BUNDLE_NAME = "brewinandchewin";
    
    public BrewinCrafting() {
    }
    
    public static void register(Consumer<FinishedRecipe> consumer) {
        recipesMaterials(consumer);
    }
    
    private static void recipesMaterials(Consumer<FinishedRecipe> consumer) {
        BundleShapedRecipeBuilder.shaped(BrewinItems.glassTankard.get(), BUNDLE_NAME)
                .pattern("# #")
                .pattern("# #")
                .pattern(" # ")
                .define('#', Tags.Items.GLASS)
                .unlockedBy("has_glass", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GLASS))
                .save(consumer, new ResourceLocation(BundledDelight.MODID, "crafting/glass_tankard"));
    }
    
    @Override
    public String getBundleName() {
        return BUNDLE_NAME;
    }
}
