package com.pouffydev.bundledelight.init.bundles.builtin.data.recipe;

import com.pouffydev.bundledelight.BundledDelight;
import com.pouffydev.bundledelight.datagen.RecipeShortcuts;
import com.pouffydev.bundledelight.datagen.builder.recipe.BundleShapelessRecipeBuilder;
import com.pouffydev.bundledelight.foundation.data.BundleRecipeGen;
import com.pouffydev.bundledelight.init.bundles.builtin.BuiltinBlocks;
import com.pouffydev.bundledelight.init.bundles.builtin.BuiltinItems;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;

import java.util.List;
import java.util.function.Consumer;

public class BuiltinCrafting extends BundleRecipeGen {
    private static final String BUNDLE_NAME = "builtin";
    public BuiltinCrafting() {
    }
    
    public static void register(Consumer<FinishedRecipe> consumer) {
        recipesFoodstuffs(consumer);
        recipesFoodBlocks(consumer);
    }
    
    private static void recipesFoodstuffs(Consumer<FinishedRecipe> consumer) {
        RecipeShortcuts.juice(BuiltinItems.sweetBerryJuice.get(), Items.SWEET_BERRIES, BUNDLE_NAME).save(consumer, new ResourceLocation(BundledDelight.MODID, "food/sweet_berry_juice"));
        RecipeShortcuts.shapelessWithin4x4(BuiltinItems.carrotCookie.get(), 8, Items.CARROT, List.of(Items.WHEAT, Items.WHEAT), BUNDLE_NAME).save(consumer, new ResourceLocation(BundledDelight.MODID, "food/carrot_cookie"));
    }
    
    private static void recipesFoodBlocks(Consumer<FinishedRecipe> consumer) {
        RecipeShortcuts.cake(BuiltinBlocks.carrotCake.get(), Items.CARROT, BUNDLE_NAME).save(consumer, new ResourceLocation(BundledDelight.MODID, "food/carrot_cake"));
        RecipeShortcuts.compactCakeFromSlices(BuiltinBlocks.carrotCake.get(), BuiltinItems.carrotCakeSlice.get(), BUNDLE_NAME).save(consumer, new ResourceLocation(BundledDelight.MODID, "food/carrot_cake_from_slices"));
    }
    
    @Override
    public String getBundleName() {
        return BUNDLE_NAME;
    }
}
