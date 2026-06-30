package com.pouffydev.bundledelight.init.bundles.builtin.data.recipe;

import com.pouffydev.bundledelight.BundledDelight;
import com.pouffydev.bundledelight.datagen.RecipeShortcuts;
import com.pouffydev.bundledelight.foundation.data.BundleRecipeGen;
import com.pouffydev.bundledelight.init.bundles.builtin.BuiltinBlocks;
import com.pouffydev.bundledelight.init.bundles.builtin.BuiltinItems;
import com.pouffydev.krystal_core.foundation.data.condition.BundleLoadedCondition;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.conditions.ICondition;

import java.util.List;

public class BuiltinCrafting extends BundleRecipeGen {
    private static final String BUNDLE_NAME = "builtin";
    public BuiltinCrafting() {
    }

    static ICondition condition = new BundleLoadedCondition(BundledDelight.location("builtin"));
    
    public static void register(RecipeOutput output) {
        recipesFoodstuffs(output);
        recipesFoodBlocks(output);
    }
    
    private static void recipesFoodstuffs(RecipeOutput output) {
        RecipeShortcuts.juice(BuiltinItems.sweetBerryJuice.get(), Items.SWEET_BERRIES).save(output, BundledDelight.location("food/sweet_berry_juice"), condition);
        RecipeShortcuts.shapelessWithin4x4(BuiltinItems.carrotCookie.get(), 8, Items.CARROT, List.of(Items.WHEAT, Items.WHEAT), RecipeCategory.FOOD).save(output, BundledDelight.location("food/carrot_cookie"), condition);
    }
    
    private static void recipesFoodBlocks(RecipeOutput output) {
        RecipeShortcuts.cake(BuiltinBlocks.carrotCake.get(), Items.CARROT).save(output, BundledDelight.location("food/carrot_cake"), condition);
        RecipeShortcuts.compactCakeFromSlices(BuiltinBlocks.carrotCake.get(), BuiltinItems.carrotCakeSlice.get()).save(output, BundledDelight.location("food/carrot_cake_from_slices"), condition);
    }
    
    @Override
    public String getBundleName() {
        return BUNDLE_NAME;
    }
}
