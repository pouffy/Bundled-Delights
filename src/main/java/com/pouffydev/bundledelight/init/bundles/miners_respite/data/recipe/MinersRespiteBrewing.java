package com.pouffydev.bundledelight.init.bundles.miners_respite.data.recipe;

import com.pouffydev.bundledelight.datagen.BundleTags;
import com.pouffydev.bundledelight.datagen.builder.recipe.KettleRecipeBuilder;
import com.pouffydev.bundledelight.foundation.data.BundleRecipeGen;
import com.pouffydev.bundledelight.foundation.data.FinishedData;
import com.pouffydev.bundledelight.init.bundles.farmersrespite.RespiteItems;
import com.pouffydev.bundledelight.init.bundles.miners_respite.MinersRespiteItems;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import umpaz.farmersrespite.common.registry.FRItems;

import java.util.function.Consumer;

public class MinersRespiteBrewing extends BundleRecipeGen {
    private static final String BUNDLE_NAME = "miners_respite";

    public MinersRespiteBrewing() {
    }

    public static void register(Consumer<FinishedData> consumer) {
        brewTeaCups(consumer);
    }

    private static void brewTeaCups(Consumer<FinishedData> consumer) {
        KettleRecipeBuilder.kettleRecipe(MinersRespiteItems.greenTeaCup.get(), BUNDLE_NAME).addIngredient(RespiteItems.powderedGreenTeaLeaves.get()).addIngredient(RespiteItems.powderedGreenTeaLeaves.get()).build(consumer);
        KettleRecipeBuilder.kettleRecipe(MinersRespiteItems.yellowTeaCup.get(), BUNDLE_NAME).addIngredient(RespiteItems.powderedYellowTeaLeaves.get()).addIngredient(RespiteItems.powderedYellowTeaLeaves.get()).build(consumer);
        KettleRecipeBuilder.kettleRecipe(MinersRespiteItems.blackTeaCup.get(), BUNDLE_NAME).addIngredient(RespiteItems.powderedBlackTeaLeaves.get()).addIngredient(RespiteItems.powderedBlackTeaLeaves.get()).build(consumer);
        KettleRecipeBuilder.kettleRecipe(MinersRespiteItems.coffeeCup.get(), BUNDLE_NAME).addIngredient(RespiteItems.powderedCoffeeBeans.get()).addIngredient(RespiteItems.powderedCoffeeBeans.get()).build(consumer);

        KettleRecipeBuilder.kettleRecipe(MinersRespiteItems.roseHipTeaCup.get(), BUNDLE_NAME).addIngredient(FRItems.ROSE_HIPS.get()).build(consumer);
        KettleRecipeBuilder.kettleRecipe(MinersRespiteItems.dandelionTeaCup.get(), BUNDLE_NAME).addIngredient(Items.DANDELION).addIngredient(BundleTags.TEA_POWDER).build(consumer);
    }

    private static void brewLongTeaCups(Consumer<FinishedData> consumer) {

    }

    private static void brewStrongTeaCups(Consumer<FinishedData> consumer) {

    }


    @Override
    public String getBundleName() {
        return BUNDLE_NAME;
    }
}
