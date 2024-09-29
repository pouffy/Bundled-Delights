package com.pouffydev.bundledelight.init.bundles.neapolitan.data.recipe;

import com.pouffydev.bundledelight.datagen.RecipeShortcuts;
import com.pouffydev.bundledelight.foundation.data.BundleRecipeGen;
import com.pouffydev.bundledelight.init.bundles.neapolitan.NeapolitanBlocks;
import com.pouffydev.bundledelight.init.bundles.neapolitan.NeapolitanItems;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

public class NeapolitanCutting extends BundleRecipeGen {
    private static final String BUNDLE_NAME = "neapolitan";

    public NeapolitanCutting() {
    }

    public static void register(Consumer<FinishedRecipe> consumer) {
        cutMiscellaneous(consumer);
    }

    private static void cutMiscellaneous(Consumer<FinishedRecipe> consumer) {
        RecipeShortcuts.powder(NeapolitanItems.powderedAdzukiBeans.get(), com.teamabnormals.neapolitan.core.registry.NeapolitanItems.ROASTED_ADZUKI_BEANS.get(), BUNDLE_NAME).build(consumer);
        RecipeShortcuts.powder(NeapolitanItems.powderedMintLeaves.get(), com.teamabnormals.neapolitan.core.registry.NeapolitanItems.MINT_LEAVES.get(), BUNDLE_NAME).build(consumer);
        RecipeShortcuts.powder(NeapolitanItems.powderedVanilla.get(), com.teamabnormals.neapolitan.core.registry.NeapolitanItems.DRIED_VANILLA_PODS.get(), BUNDLE_NAME).build(consumer);

        RecipeShortcuts.cutWithKnife(NeapolitanItems.whiteStrawberryCakeSlice.get(), 7, NeapolitanBlocks.whiteStrawberryCake.get(), BUNDLE_NAME).build(consumer);
    }

    @Override
    public String getBundleName() {
        return BUNDLE_NAME;
    }
}
