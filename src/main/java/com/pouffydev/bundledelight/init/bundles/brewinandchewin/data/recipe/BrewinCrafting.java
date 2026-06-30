package com.pouffydev.bundledelight.init.bundles.brewinandchewin.data.recipe;

import com.pouffydev.bundledelight.BundledDelight;
import com.pouffydev.bundledelight.datagen.builder.recipe.BundleShapedRecipeBuilder;
import com.pouffydev.bundledelight.datagen.builder.recipe.BundleShapelessRecipeBuilder;
import com.pouffydev.bundledelight.foundation.data.BundleRecipeGen;
import com.pouffydev.bundledelight.init.bundles.brewinandchewin.BrewinItems;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.Tags;
import umpaz.brewinandchewin.common.registry.BnCItems;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.CommonTags;

public class BrewinCrafting extends BundleRecipeGen {
    private static final String BUNDLE_NAME = "brewinandchewin";
    
    public BrewinCrafting() {
    }
    
    public static void register(RecipeOutput output) {
        recipesMaterials(output);
        recipesFoods(output);
    }
    
    private static void recipesMaterials(RecipeOutput output) {
        BundleShapedRecipeBuilder.shaped(RecipeCategory.BREWING, BrewinItems.glassTankard.get())
                .pattern("# #")
                .pattern("# #")
                .pattern(" # ")
                .define('#', Tags.Items.GLASS_BLOCKS)
                .unlockedBy("has_glass", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GLASS))
                .save(output, BundledDelight.location("glass_tankard"));
    }

    private static void recipesFoods(RecipeOutput output) {
        BundleShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BrewinItems.cheeseburger.get())
                .requires(Tags.Items.FOODS_BREAD)
                .requires(ModItems.BEEF_PATTY.get())
                .requires(CommonTags.Items.FOODS_LEAFY_GREEN)
                .requires(CommonTags.Items.CROPS_TOMATO)
                .requires(CommonTags.Items.CROPS_ONION)
                .requires(BnCItems.FLAXEN_CHEESE_WEDGE)
                .unlockedBy("has_cheeseburger_ingredients", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.BEEF_PATTY.get(), BnCItems.FLAXEN_CHEESE_WEDGE))
                .save(output, BundledDelight.location("food/cheeseburger"));
        BundleShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BrewinItems.scarletCheeseburger.get())
                .requires(Tags.Items.FOODS_BREAD)
                .requires(ModItems.BEEF_PATTY.get())
                .requires(CommonTags.Items.FOODS_LEAFY_GREEN)
                .requires(CommonTags.Items.CROPS_TOMATO)
                .requires(CommonTags.Items.CROPS_ONION)
                .requires(BnCItems.SCARLET_CHEESE_WEDGE)
                .unlockedBy("has_scarlet_cheeseburger_ingredients", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.BEEF_PATTY.get(), BnCItems.SCARLET_CHEESE_WEDGE))
                .save(output, BundledDelight.location("food/scarlet_cheeseburger"));
    }

    
    @Override
    public String getBundleName() {
        return BUNDLE_NAME;
    }
}
