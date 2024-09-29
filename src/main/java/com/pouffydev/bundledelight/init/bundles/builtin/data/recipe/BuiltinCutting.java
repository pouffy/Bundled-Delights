package com.pouffydev.bundledelight.init.bundles.builtin.data.recipe;

import com.pouffydev.bundledelight.datagen.RecipeShortcuts;
import com.pouffydev.bundledelight.datagen.builder.recipe.CuttingBoardRecipeBuilder;
import com.pouffydev.bundledelight.foundation.data.BundleRecipeGen;
import com.pouffydev.bundledelight.init.bundles.builtin.BuiltinBlocks;
import com.pouffydev.bundledelight.init.bundles.builtin.BuiltinItems;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import vectorwing.farmersdelight.common.tag.ModTags;

import java.util.function.Consumer;

public class BuiltinCutting extends BundleRecipeGen {
    private static final String BUNDLE_NAME = "builtin";
    public BuiltinCutting() {
    }
    
    public static void register(Consumer<FinishedRecipe> consumer) {
        cutMiscellaneous(consumer);
    }
    
    private static void cutMiscellaneous(Consumer<FinishedRecipe> consumer) {
        RecipeShortcuts.cutWithKnife(BuiltinItems.carrotCakeSlice.get(), 7, BuiltinBlocks.carrotCake.get(), BUNDLE_NAME).build(consumer);
    }
    
    @Override
    public String getBundleName() {
        return BUNDLE_NAME;
    }
}
