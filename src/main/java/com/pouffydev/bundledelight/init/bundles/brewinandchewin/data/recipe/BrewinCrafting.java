package com.pouffydev.bundledelight.init.bundles.brewinandchewin.data.recipe;

import com.pouffydev.bundledelight.BundledDelight;
import com.pouffydev.bundledelight.datagen.builder.recipe.BundleShapedRecipeBuilder;
import com.pouffydev.bundledelight.datagen.builder.recipe.BundleShapelessRecipeBuilder;
import com.pouffydev.bundledelight.foundation.data.BundleRecipeGen;
import com.pouffydev.bundledelight.init.bundles.brewinandchewin.BrewinItems;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.Tags;
import umpaz.brewinandchewin.common.registry.BCItems;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.ForgeTags;

import java.util.function.Consumer;

public class BrewinCrafting extends BundleRecipeGen {
    private static final String BUNDLE_NAME = "brewinandchewin";
    
    public BrewinCrafting() {
    }
    
    public static void register(Consumer<FinishedRecipe> consumer) {
        recipesMaterials(consumer);
        recipesFoods(consumer);
    }
    
    private static void recipesMaterials(Consumer<FinishedRecipe> consumer) {
        BundleShapedRecipeBuilder.shaped(BrewinItems.glassTankard.get(), BUNDLE_NAME)
                .pattern("# #")
                .pattern("# #")
                .pattern(" # ")
                .define('#', Tags.Items.GLASS)
                .unlockedBy("has_glass", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GLASS))
                .save(consumer, new ResourceLocation(BundledDelight.MODID, "glass_tankard"));
    }

    private static void recipesFoods(Consumer<FinishedRecipe> consumer) {
        BundleShapelessRecipeBuilder.shapeless(BrewinItems.cheeseburger.get(), BUNDLE_NAME)
                .requires(ForgeTags.BREAD)
                .requires(ModItems.BEEF_PATTY.get())
                .requires(ForgeTags.SALAD_INGREDIENTS)
                .requires(ForgeTags.CROPS_TOMATO)
                .requires(ForgeTags.CROPS_ONION)
                .requires(BCItems.FLAXEN_CHEESE_WEDGE.get())
                .unlockedBy("has_cheeseburger_ingredients", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.BEEF_PATTY.get(), BCItems.FLAXEN_CHEESE_WEDGE.get()))
                .save(consumer, new ResourceLocation(BundledDelight.MODID, "food/cheeseburger"));
        BundleShapelessRecipeBuilder.shapeless(BrewinItems.scarletCheeseburger.get(), BUNDLE_NAME)
                .requires(ForgeTags.BREAD)
                .requires(ModItems.BEEF_PATTY.get())
                .requires(ForgeTags.SALAD_INGREDIENTS)
                .requires(ForgeTags.CROPS_TOMATO)
                .requires(ForgeTags.CROPS_ONION)
                .requires(BCItems.SCARLET_CHEESE_WEDGE.get())
                .unlockedBy("has_scarlet_cheeseburger_ingredients", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.BEEF_PATTY.get(), BCItems.SCARLET_CHEESE_WEDGE.get()))
                .save(consumer, new ResourceLocation(BundledDelight.MODID, "food/scarlet_cheeseburger"));
    }

    
    @Override
    public String getBundleName() {
        return BUNDLE_NAME;
    }
}
