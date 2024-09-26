package com.pouffydev.bundledelight.init.bundles.farmersrespite.data.recipe;

import com.pouffydev.bundledelight.foundation.data.BundleRecipeGen;
import com.pouffydev.bundledelight.foundation.data.FinishedData;

import java.util.function.Consumer;

public class RespiteMilling extends BundleRecipeGen {
    private static final String BUNDLE_NAME = "farmersrespite";

    public RespiteMilling() {
    }

    public static void register(Consumer<FinishedData> consumer) {
        millMiscellaneous(consumer);
    }

    private static void millMiscellaneous(Consumer<FinishedData> consumer) {

    }

    @Override
    public String getBundleName() {
        return BUNDLE_NAME;
    }
}
