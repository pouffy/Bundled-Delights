package com.pouffydev.bundledelight.init.bundles.farmersrespite.data.recipe;

import com.pouffydev.bundledelight.datagen.builder.recipe.CreateProcessingRecipeBuilder;
import com.pouffydev.bundledelight.foundation.data.BundleRecipeGen;
import com.pouffydev.bundledelight.foundation.data.FinishedData;
import com.pouffydev.bundledelight.init.bundles.farmersrespite.RespiteItems;
import net.minecraft.resources.ResourceLocation;
import umpaz.farmersrespite.common.registry.FRItems;

import java.util.function.Consumer;

public class RespiteMilling extends BundleRecipeGen {
    private static final String BUNDLE_NAME = "farmersrespite";
    private static final ResourceLocation MILLSTONE = new ResourceLocation("create", "milling");

    public RespiteMilling() {
    }

    public static void register(Consumer<FinishedData> consumer) {
        millMiscellaneous(consumer);
    }

    private static void millMiscellaneous(Consumer<FinishedData> consumer) {
        CreateProcessingRecipeBuilder.create(MILLSTONE, BUNDLE_NAME).require(FRItems.GREEN_TEA_LEAVES.get()).output(RespiteItems.powderedGreenTeaLeaves.get(), 2).output(0.5f, RespiteItems.powderedGreenTeaLeaves.get()).duration(50).build(consumer);
        CreateProcessingRecipeBuilder.create(MILLSTONE, BUNDLE_NAME).require(FRItems.YELLOW_TEA_LEAVES.get()).output(RespiteItems.powderedYellowTeaLeaves.get(), 2).output(0.5f, RespiteItems.powderedYellowTeaLeaves.get()).duration(50).build(consumer);
        CreateProcessingRecipeBuilder.create(MILLSTONE, BUNDLE_NAME).require(FRItems.BLACK_TEA_LEAVES.get()).output(RespiteItems.powderedBlackTeaLeaves.get(), 2).output(0.5f, RespiteItems.powderedBlackTeaLeaves.get()).duration(50).build(consumer);
        CreateProcessingRecipeBuilder.create(MILLSTONE, BUNDLE_NAME).require(FRItems.COFFEE_BEANS.get()).output(RespiteItems.powderedCoffeeBeans.get(), 2).output(0.5f, RespiteItems.powderedCoffeeBeans.get()).duration(50).build(consumer);
    }

    @Override
    public String getBundleName() {
        return BUNDLE_NAME;
    }
}
