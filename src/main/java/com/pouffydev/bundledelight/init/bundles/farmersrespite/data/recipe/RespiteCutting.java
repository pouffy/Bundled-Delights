package com.pouffydev.bundledelight.init.bundles.farmersrespite.data.recipe;

import com.pouffydev.bundledelight.datagen.RecipeShortcuts;
import com.pouffydev.bundledelight.foundation.data.BundleRecipeGen;
import com.pouffydev.bundledelight.init.bundles.farmersrespite.RespiteItems;
import net.minecraft.data.recipes.FinishedRecipe;
import umpaz.farmersrespite.common.registry.FRItems;

import java.util.function.Consumer;

public class RespiteCutting extends BundleRecipeGen {
    private static final String BUNDLE_NAME = "farmersrespite";

    public RespiteCutting() {
    }

    public static void register(Consumer<FinishedRecipe> consumer) {
        cutMiscellaneous(consumer);
    }

    private static void cutMiscellaneous(Consumer<FinishedRecipe> consumer) {
        RecipeShortcuts.powder(RespiteItems.powderedGreenTeaLeaves.get(), FRItems.GREEN_TEA_LEAVES.get(), BUNDLE_NAME).build(consumer);
        RecipeShortcuts.powder(RespiteItems.powderedYellowTeaLeaves.get(), FRItems.YELLOW_TEA_LEAVES.get(), BUNDLE_NAME).build(consumer);
        RecipeShortcuts.powder(RespiteItems.powderedBlackTeaLeaves.get(), FRItems.BLACK_TEA_LEAVES.get(), BUNDLE_NAME).build(consumer);
        RecipeShortcuts.powder(RespiteItems.powderedCoffeeBeans.get(), FRItems.COFFEE_BEANS.get(), BUNDLE_NAME).build(consumer);
    }

    @Override
    public String getBundleName() {
        return BUNDLE_NAME;
    }
}
