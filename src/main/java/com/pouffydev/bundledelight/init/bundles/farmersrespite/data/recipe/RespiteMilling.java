package com.pouffydev.bundledelight.init.bundles.farmersrespite.data.recipe;

import com.pouffydev.bundledelight.datagen.RecipeShortcuts;
import com.pouffydev.bundledelight.foundation.data.BundleRecipeGen;
import com.pouffydev.bundledelight.foundation.data.FinishedData;
import com.pouffydev.bundledelight.init.bundles.farmersrespite.RespiteItems;
import umpaz.farmersrespite.common.registry.FRItems;

import java.util.function.Consumer;

public class RespiteMilling extends BundleRecipeGen {
    private static final String BUNDLE_NAME = "farmersrespite";

    public RespiteMilling() {
    }

    public static void register(Consumer<FinishedData> consumer) {
        millMiscellaneous(consumer);
    }

    private static void millMiscellaneous(Consumer<FinishedData> consumer) {
        RecipeShortcuts.millPowder(RespiteItems.powderedGreenTeaLeaves.get(), FRItems.GREEN_TEA_LEAVES.get(), BUNDLE_NAME).build(consumer);
        RecipeShortcuts.millPowder(RespiteItems.powderedYellowTeaLeaves.get(), FRItems.YELLOW_TEA_LEAVES.get(), BUNDLE_NAME).build(consumer);
        RecipeShortcuts.millPowder(RespiteItems.powderedBlackTeaLeaves.get(), FRItems.BLACK_TEA_LEAVES.get(), BUNDLE_NAME).build(consumer);
        RecipeShortcuts.millPowder(RespiteItems.powderedCoffeeBeans.get(), FRItems.COFFEE_BEANS.get(), BUNDLE_NAME).build(consumer);
    }

    @Override
    public String getBundleName() {
        return BUNDLE_NAME;
    }
}
