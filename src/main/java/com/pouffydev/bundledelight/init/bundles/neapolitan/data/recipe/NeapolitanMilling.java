package com.pouffydev.bundledelight.init.bundles.neapolitan.data.recipe;

import com.pouffydev.bundledelight.datagen.RecipeShortcuts;
import com.pouffydev.bundledelight.foundation.data.BundleRecipeGen;
import com.pouffydev.bundledelight.foundation.data.FinishedData;
import com.pouffydev.bundledelight.init.bundles.neapolitan.NeapolitanItems;

import java.util.function.Consumer;

public class NeapolitanMilling extends BundleRecipeGen {
    private static final String BUNDLE_NAME = "neapolitan";

    public NeapolitanMilling() {
    }

    public static void register(Consumer<FinishedData> consumer) {
        millMiscellaneous(consumer);
    }

    private static void millMiscellaneous(Consumer<FinishedData> consumer) {
        RecipeShortcuts.millPowder(NeapolitanItems.powderedMintLeaves.get(), com.teamabnormals.neapolitan.core.registry.NeapolitanItems.MINT_LEAVES.get(), BUNDLE_NAME).build(consumer);
        RecipeShortcuts.millPowder(NeapolitanItems.powderedVanilla.get(), com.teamabnormals.neapolitan.core.registry.NeapolitanItems.DRIED_VANILLA_PODS.get(), BUNDLE_NAME).build(consumer);
        RecipeShortcuts.millPowder(NeapolitanItems.powderedAdzukiBeans.get(), com.teamabnormals.neapolitan.core.registry.NeapolitanItems.ROASTED_ADZUKI_BEANS.get(), BUNDLE_NAME).build(consumer);
    }

    @Override
    public String getBundleName() {
        return BUNDLE_NAME;
    }
}
