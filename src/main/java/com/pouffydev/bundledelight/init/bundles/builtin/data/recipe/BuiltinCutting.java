package com.pouffydev.bundledelight.init.bundles.builtin.data.recipe;

import com.pouffydev.bundledelight.BundledDelight;
import com.pouffydev.bundledelight.datagen.RecipeShortcuts;
import com.pouffydev.bundledelight.foundation.data.BundleRecipeGen;
import com.pouffydev.bundledelight.init.bundles.builtin.BuiltinBlocks;
import com.pouffydev.bundledelight.init.bundles.builtin.BuiltinItems;
import com.pouffydev.krystal_core.foundation.data.condition.BundleLoadedCondition;
import com.pouffydev.krystal_core.foundation.dynamicpack.data.recipe.output.CustomRecipeOutput;
import net.neoforged.neoforge.common.conditions.ICondition;

public class BuiltinCutting extends BundleRecipeGen {
    private static final String BUNDLE_NAME = "builtin";
    public BuiltinCutting() {
    }

    static ICondition condition = new BundleLoadedCondition(BundledDelight.location("builtin"));
    
    public static void register(CustomRecipeOutput output) {
        cutMiscellaneous(output);
    }
    
    private static void cutMiscellaneous(CustomRecipeOutput output) {
        RecipeShortcuts.cutWithKnife(BuiltinItems.carrotCakeSlice.get(), 7, BuiltinBlocks.carrotCake.get()).withCondition(condition).save(output, BundledDelight.location("cutting/carrot_cake"));
    }
    
    @Override
    public String getBundleName() {
        return BUNDLE_NAME;
    }
}
