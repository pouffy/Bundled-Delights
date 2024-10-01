package com.pouffydev.bundledelight.init.bundles.miners_respite.data.recipe;

import com.pouffydev.bundledelight.datagen.BundleTags;
import com.pouffydev.bundledelight.datagen.builder.recipe.KettleRecipeBuilder;
import com.pouffydev.bundledelight.foundation.data.BundleRecipeGen;
import com.pouffydev.bundledelight.foundation.data.FinishedData;
import com.pouffydev.bundledelight.init.bundles.farmersrespite.RespiteItems;
import com.pouffydev.bundledelight.init.bundles.miners_respite.MinersRespiteItems;
import com.sammy.minersdelight.setup.MDItems;
import net.minecraft.world.item.Items;
import umpaz.farmersrespite.common.registry.FRItems;
import vectorwing.farmersdelight.common.tag.ForgeTags;

import java.util.function.Consumer;

public class MinersRespiteBrewing extends BundleRecipeGen {
    private static final String BUNDLE_NAME = "miners_respite";

    public MinersRespiteBrewing() {
    }

    public static void register(Consumer<FinishedData> consumer) {
        brewTeaCups(consumer);
        brewLongTeaCups(consumer);
        brewStrongTeaCups(consumer);
    }

    private static void brewTeaCups(Consumer<FinishedData> consumer) {
        KettleRecipeBuilder.kettleRecipe(MinersRespiteItems.greenTeaCup.get(), BUNDLE_NAME).addIngredient(RespiteItems.powderedGreenTeaLeaves.get()).addIngredient(RespiteItems.powderedGreenTeaLeaves.get()).build(consumer);
        KettleRecipeBuilder.kettleRecipe(MinersRespiteItems.yellowTeaCup.get(), BUNDLE_NAME).addIngredient(RespiteItems.powderedYellowTeaLeaves.get()).addIngredient(RespiteItems.powderedYellowTeaLeaves.get()).build(consumer);
        KettleRecipeBuilder.kettleRecipe(MinersRespiteItems.blackTeaCup.get(), BUNDLE_NAME).addIngredient(RespiteItems.powderedBlackTeaLeaves.get()).addIngredient(RespiteItems.powderedBlackTeaLeaves.get()).build(consumer);
        KettleRecipeBuilder.kettleRecipe(MinersRespiteItems.coffeeCup.get(), BUNDLE_NAME).addIngredient(RespiteItems.powderedCoffeeBeans.get()).addIngredient(RespiteItems.powderedCoffeeBeans.get()).build(consumer);

        KettleRecipeBuilder.kettleRecipe(MinersRespiteItems.roseHipTeaCup.get(), BUNDLE_NAME).addIngredient(FRItems.ROSE_HIPS.get()).build(consumer);
        KettleRecipeBuilder.kettleRecipe(MinersRespiteItems.dandelionTeaCup.get(), BUNDLE_NAME).addIngredient(Items.DANDELION).addIngredient(BundleTags.TEA_POWDER).build(consumer);
        KettleRecipeBuilder.kettleRecipe(MinersRespiteItems.purulentTeaCup.get(), BUNDLE_NAME).addIngredient(Items.SPIDER_EYE).addIngredient(Items.NETHER_WART).build(consumer);
    }

    private static void brewLongTeaCups(Consumer<FinishedData> consumer) {
        KettleRecipeBuilder.kettleRecipe(MinersRespiteItems.longGreenTeaCup.get(), 1, 2400, 0.35F, false, MDItems.COPPER_CUP.get(), BUNDLE_NAME).addIngredient(MinersRespiteItems.greenTeaCup.get()).addIngredient(ForgeTags.MILK).build(consumer);
        KettleRecipeBuilder.kettleRecipe(MinersRespiteItems.longYellowTeaCup.get(), 1, 2400, 0.35F, false, MDItems.COPPER_CUP.get(), BUNDLE_NAME).addIngredient(MinersRespiteItems.yellowTeaCup.get()).addIngredient(ForgeTags.MILK).build(consumer);
        KettleRecipeBuilder.kettleRecipe(MinersRespiteItems.longBlackTeaCup.get(), 1, 2400, 0.35F, false, MDItems.COPPER_CUP.get(), BUNDLE_NAME).addIngredient(MinersRespiteItems.blackTeaCup.get()).addIngredient(ForgeTags.MILK).build(consumer);
        KettleRecipeBuilder.kettleRecipe(MinersRespiteItems.longCoffeeCup.get(), 1, 2400, 0.35F, false, MDItems.COPPER_CUP.get(), BUNDLE_NAME).addIngredient(MinersRespiteItems.coffeeCup.get()).addIngredient(ForgeTags.MILK).build(consumer);

        KettleRecipeBuilder.kettleRecipe(MinersRespiteItems.longDandelionTeaCup.get(), 1, 2400, 0.35F, false, MDItems.COPPER_CUP.get(), BUNDLE_NAME).addIngredient(MinersRespiteItems.dandelionTeaCup.get()).addIngredient(ForgeTags.MILK).build(consumer);
        KettleRecipeBuilder.kettleRecipe(MinersRespiteItems.longPurulentTeaCup.get(), 1, 2400, 0.35F, false, MDItems.COPPER_CUP.get(), BUNDLE_NAME).addIngredient(MinersRespiteItems.purulentTeaCup.get()).addIngredient(ForgeTags.MILK).build(consumer);
    }

    private static void brewStrongTeaCups(Consumer<FinishedData> consumer) {
        KettleRecipeBuilder.kettleRecipe(MinersRespiteItems.strongGreenTeaCup.get(), 1, 2400, 0.35F, false, MDItems.COPPER_CUP.get(), BUNDLE_NAME).addIngredient(MinersRespiteItems.greenTeaCup.get()).addIngredient(Items.HONEY_BOTTLE).build(consumer);
        KettleRecipeBuilder.kettleRecipe(MinersRespiteItems.strongYellowTeaCup.get(), 1, 2400, 0.35F, false, MDItems.COPPER_CUP.get(), BUNDLE_NAME).addIngredient(MinersRespiteItems.yellowTeaCup.get()).addIngredient(Items.HONEY_BOTTLE).build(consumer);
        KettleRecipeBuilder.kettleRecipe(MinersRespiteItems.strongBlackTeaCup.get(), 1, 2400, 0.35F, false, MDItems.COPPER_CUP.get(), BUNDLE_NAME).addIngredient(MinersRespiteItems.blackTeaCup.get()).addIngredient(Items.HONEY_BOTTLE).build(consumer);
        KettleRecipeBuilder.kettleRecipe(MinersRespiteItems.strongCoffeeCup.get(), 1, 2400, 0.35F, false, MDItems.COPPER_CUP.get(), BUNDLE_NAME).addIngredient(MinersRespiteItems.coffeeCup.get()).addIngredient(Items.HONEY_BOTTLE).build(consumer);

        KettleRecipeBuilder.kettleRecipe(MinersRespiteItems.strongRoseHipTeaCup.get(), 1, 2400, 0.35F, false, MDItems.COPPER_CUP.get(), BUNDLE_NAME).addIngredient(MinersRespiteItems.roseHipTeaCup.get()).addIngredient(Items.HONEY_BOTTLE).build(consumer);
        KettleRecipeBuilder.kettleRecipe(MinersRespiteItems.strongPurulentTeaCup.get(), 1, 2400, 0.35F, false, MDItems.COPPER_CUP.get(), BUNDLE_NAME).addIngredient(MinersRespiteItems.purulentTeaCup.get()).addIngredient(Items.HONEY_BOTTLE).build(consumer);
    }


    @Override
    public String getBundleName() {
        return BUNDLE_NAME;
    }
}
