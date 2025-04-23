package com.pouffydev.bundledelight.init.bundles.miners_respite.data.recipe;

import com.pouffydev.bundledelight.datagen.BundleTags;
import com.pouffydev.bundledelight.datagen.builder.KettlePouringRecipeBuilder;
import com.pouffydev.bundledelight.datagen.builder.recipe.KettleRecipeBuilder;
import com.pouffydev.bundledelight.foundation.data.BundleRecipeGen;
import com.pouffydev.bundledelight.foundation.data.FinishedData;
import com.pouffydev.bundledelight.init.bundles.farmersrespite.RespiteItems;
import com.pouffydev.bundledelight.init.bundles.miners_respite.MinersRespiteItems;
import com.pouffydev.bundledelight.init.bundles.minersdelight.MinersItems;
import com.sammy.minersdelight.setup.MDItems;
import net.minecraft.world.item.Items;
import umpaz.farmersrespite.common.registry.FRFluids;
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
        pourBrews(consumer);
    }

    private static void brewTeaCups(Consumer<FinishedData> consumer) {
        //KettleRecipeBuilder.kettleRecipe(MinersRespiteItems.greenTeaCup.get(), 1, 2400, 0.35F, true, MDItems.COPPER_CUP.get(), BUNDLE_NAME).addIngredient(RespiteItems.powderedGreenTeaLeaves.get()).addIngredient(RespiteItems.powderedGreenTeaLeaves.get()).build(consumer);
        //KettleRecipeBuilder.kettleRecipe(MinersRespiteItems.yellowTeaCup.get(), 1, 2400, 0.35F, true, MDItems.COPPER_CUP.get(), BUNDLE_NAME).addIngredient(RespiteItems.powderedYellowTeaLeaves.get()).addIngredient(RespiteItems.powderedYellowTeaLeaves.get()).build(consumer);
        //KettleRecipeBuilder.kettleRecipe(MinersRespiteItems.blackTeaCup.get(), 1, 2400, 0.35F, true, MDItems.COPPER_CUP.get(), BUNDLE_NAME).addIngredient(RespiteItems.powderedBlackTeaLeaves.get()).addIngredient(RespiteItems.powderedBlackTeaLeaves.get()).build(consumer);
        //KettleRecipeBuilder.kettleRecipe(MinersRespiteItems.coffeeCup.get(), 1, 2400, 0.35F, true, MDItems.COPPER_CUP.get(), BUNDLE_NAME).addIngredient(RespiteItems.powderedCoffeeBeans.get()).addIngredient(RespiteItems.powderedCoffeeBeans.get()).build(consumer);
//
        //KettleRecipeBuilder.kettleRecipe(MinersRespiteItems.roseHipTeaCup.get(), 1, 2400, 0.35F, true, MDItems.COPPER_CUP.get(), BUNDLE_NAME).addIngredient(FRItems.ROSE_HIPS.get()).build(consumer);
        //KettleRecipeBuilder.kettleRecipe(MinersRespiteItems.dandelionTeaCup.get(), 1, 2400, 0.35F, true, MDItems.COPPER_CUP.get(), BUNDLE_NAME).addIngredient(Items.DANDELION).addIngredient(BundleTags.TEA_POWDER).build(consumer);
        //KettleRecipeBuilder.kettleRecipe(MinersRespiteItems.purulentTeaCup.get(), 1, 2400, 0.35F, true, MDItems.COPPER_CUP.get(), BUNDLE_NAME).addIngredient(Items.SPIDER_EYE).addIngredient(Items.NETHER_WART).build(consumer);
    }

    private static void brewLongTeaCups(Consumer<FinishedData> consumer) {
        //KettleRecipeBuilder.kettleRecipe(MinersRespiteItems.longGreenTeaCup.get(), 1, 2400, 0.35F, false, MDItems.COPPER_CUP.get(), BUNDLE_NAME).addIngredient(MinersRespiteItems.greenTeaCup.get()).addIngredient(ForgeTags.MILK).build(consumer);
        //KettleRecipeBuilder.kettleRecipe(MinersRespiteItems.longYellowTeaCup.get(), 1, 2400, 0.35F, false, MDItems.COPPER_CUP.get(), BUNDLE_NAME).addIngredient(MinersRespiteItems.yellowTeaCup.get()).addIngredient(ForgeTags.MILK).build(consumer);
        //KettleRecipeBuilder.kettleRecipe(MinersRespiteItems.longBlackTeaCup.get(), 1, 2400, 0.35F, false, MDItems.COPPER_CUP.get(), BUNDLE_NAME).addIngredient(MinersRespiteItems.blackTeaCup.get()).addIngredient(ForgeTags.MILK).build(consumer);
        //KettleRecipeBuilder.kettleRecipe(MinersRespiteItems.longCoffeeCup.get(), 1, 2400, 0.35F, false, MDItems.COPPER_CUP.get(), BUNDLE_NAME).addIngredient(MinersRespiteItems.coffeeCup.get()).addIngredient(ForgeTags.MILK).build(consumer);
//
        //KettleRecipeBuilder.kettleRecipe(MinersRespiteItems.longDandelionTeaCup.get(), 1, 2400, 0.35F, false, MDItems.COPPER_CUP.get(), BUNDLE_NAME).addIngredient(MinersRespiteItems.dandelionTeaCup.get()).addIngredient(ForgeTags.MILK).build(consumer);
        //KettleRecipeBuilder.kettleRecipe(MinersRespiteItems.longPurulentTeaCup.get(), 1, 2400, 0.35F, false, MDItems.COPPER_CUP.get(), BUNDLE_NAME).addIngredient(MinersRespiteItems.purulentTeaCup.get()).addIngredient(ForgeTags.MILK).build(consumer);
//
        //KettleRecipeBuilder.kettleRecipe(MinersRespiteItems.longAppleCiderCup.get(), 1, 2400, 0.35F, false, MDItems.COPPER_CUP.get(), BUNDLE_NAME).addIngredient(MinersItems.appleCiderCup.get()).addIngredient(ForgeTags.MILK).build(consumer);
    }

    private static void brewStrongTeaCups(Consumer<FinishedData> consumer) {
        //KettleRecipeBuilder.kettleRecipe(MinersRespiteItems.strongGreenTeaCup.get(), 1, 2400, 0.35F, false, MDItems.COPPER_CUP.get(), BUNDLE_NAME).addIngredient(MinersRespiteItems.greenTeaCup.get()).addIngredient(Items.HONEY_BOTTLE).build(consumer);
        //KettleRecipeBuilder.kettleRecipe(MinersRespiteItems.strongYellowTeaCup.get(), 1, 2400, 0.35F, false, MDItems.COPPER_CUP.get(), BUNDLE_NAME).addIngredient(MinersRespiteItems.yellowTeaCup.get()).addIngredient(Items.HONEY_BOTTLE).build(consumer);
        //KettleRecipeBuilder.kettleRecipe(MinersRespiteItems.strongBlackTeaCup.get(), 1, 2400, 0.35F, false, MDItems.COPPER_CUP.get(), BUNDLE_NAME).addIngredient(MinersRespiteItems.blackTeaCup.get()).addIngredient(Items.HONEY_BOTTLE).build(consumer);
        //KettleRecipeBuilder.kettleRecipe(MinersRespiteItems.strongCoffeeCup.get(), 1, 2400, 0.35F, false, MDItems.COPPER_CUP.get(), BUNDLE_NAME).addIngredient(MinersRespiteItems.coffeeCup.get()).addIngredient(Items.HONEY_BOTTLE).build(consumer);
//
        //KettleRecipeBuilder.kettleRecipe(MinersRespiteItems.strongRoseHipTeaCup.get(), 1, 2400, 0.35F, false, MDItems.COPPER_CUP.get(), BUNDLE_NAME).addIngredient(MinersRespiteItems.roseHipTeaCup.get()).addIngredient(Items.HONEY_BOTTLE).build(consumer);
        //KettleRecipeBuilder.kettleRecipe(MinersRespiteItems.strongPurulentTeaCup.get(), 1, 2400, 0.35F, false, MDItems.COPPER_CUP.get(), BUNDLE_NAME).addIngredient(MinersRespiteItems.purulentTeaCup.get()).addIngredient(Items.HONEY_BOTTLE).build(consumer);
//
        //KettleRecipeBuilder.kettleRecipe(MinersRespiteItems.strongAppleCiderCup.get(), 1, 2400, 0.35F, false, MDItems.COPPER_CUP.get(), BUNDLE_NAME).addIngredient(MinersItems.appleCiderCup.get()).addIngredient(Items.HONEY_BOTTLE).build(consumer);
        //KettleRecipeBuilder.kettleRecipe(MinersRespiteItems.strongMelonJuiceCup.get(), 1, 2400, 0.35F, false, MDItems.COPPER_CUP.get(), BUNDLE_NAME).addIngredient(MinersItems.melonJuiceCup.get()).addIngredient(Items.HONEY_BOTTLE).build(consumer);
        //KettleRecipeBuilder.kettleRecipe(MinersRespiteItems.strongHotCocoaCup.get(), 1, 2400, 0.35F, false, MDItems.COPPER_CUP.get(), BUNDLE_NAME).addIngredient(Items.HONEY_BOTTLE).build(consumer);
    }

    private static void pourBrews(Consumer<FinishedData> consumer) {
        KettlePouringRecipeBuilder.kettlePouringRecipe(MDItems.COPPER_CUP, FRFluids.GREEN_TEA.get(), 250, MinersRespiteItems.greenTeaCup.get(), consumer, BUNDLE_NAME);
        KettlePouringRecipeBuilder.kettlePouringRecipe(MDItems.COPPER_CUP, FRFluids.YELLOW_TEA.get(), 250, MinersRespiteItems.yellowTeaCup.get(), consumer, BUNDLE_NAME);
        KettlePouringRecipeBuilder.kettlePouringRecipe(MDItems.COPPER_CUP, FRFluids.BLACK_TEA.get(), 250, MinersRespiteItems.blackTeaCup.get(), consumer, BUNDLE_NAME);
        KettlePouringRecipeBuilder.kettlePouringRecipe(MDItems.COPPER_CUP, FRFluids.COFFEE.get(), 250, MinersRespiteItems.coffeeCup.get(), consumer, BUNDLE_NAME);

        KettlePouringRecipeBuilder.kettlePouringRecipe(MDItems.COPPER_CUP, FRFluids.ROSE_HIP_TEA.get(), 250, MinersRespiteItems.roseHipTeaCup.get(), consumer, BUNDLE_NAME);
        KettlePouringRecipeBuilder.kettlePouringRecipe(MDItems.COPPER_CUP, FRFluids.DANDELION_TEA.get(), 250, MinersRespiteItems.dandelionTeaCup.get(), consumer, BUNDLE_NAME);
        KettlePouringRecipeBuilder.kettlePouringRecipe(MDItems.COPPER_CUP, FRFluids.PURULENT_TEA.get(), 250, MinersRespiteItems.purulentTeaCup.get(), consumer, BUNDLE_NAME);
        KettlePouringRecipeBuilder.kettlePouringRecipe(MDItems.COPPER_CUP, FRFluids.APPLE_CIDER.get(), 250, MinersItems.appleCiderCup.get(), consumer, BUNDLE_NAME);
        KettlePouringRecipeBuilder.kettlePouringRecipe(MDItems.COPPER_CUP, FRFluids.MELON_JUICE.get(), 250, MinersItems.melonJuiceCup.get(), consumer, BUNDLE_NAME);
        KettlePouringRecipeBuilder.kettlePouringRecipe(MDItems.COPPER_CUP, FRFluids.HOT_COCOA.get(), 250, MinersRespiteItems.strongHotCocoaCup.get(), consumer, BUNDLE_NAME);

        KettlePouringRecipeBuilder.kettlePouringRecipe(MDItems.COPPER_CUP, FRFluids.STRONG_GREEN_TEA.get(), 250, MinersRespiteItems.strongGreenTeaCup.get(), consumer, BUNDLE_NAME);
        KettlePouringRecipeBuilder.kettlePouringRecipe(MDItems.COPPER_CUP, FRFluids.STRONG_YELLOW_TEA.get(), 250, MinersRespiteItems.strongYellowTeaCup.get(), consumer, BUNDLE_NAME);
        KettlePouringRecipeBuilder.kettlePouringRecipe(MDItems.COPPER_CUP, FRFluids.STRONG_BLACK_TEA.get(), 250, MinersRespiteItems.strongBlackTeaCup.get(), consumer, BUNDLE_NAME);
        KettlePouringRecipeBuilder.kettlePouringRecipe(MDItems.COPPER_CUP, FRFluids.STRONG_COFFEE.get(), 250, MinersRespiteItems.strongCoffeeCup.get(), consumer, BUNDLE_NAME);
        KettlePouringRecipeBuilder.kettlePouringRecipe(MDItems.COPPER_CUP, FRFluids.STRONG_ROSE_HIP_TEA.get(), 250, MinersRespiteItems.strongRoseHipTeaCup.get(), consumer, BUNDLE_NAME);
        KettlePouringRecipeBuilder.kettlePouringRecipe(MDItems.COPPER_CUP, FRFluids.STRONG_PURULENT_TEA.get(), 250, MinersRespiteItems.strongPurulentTeaCup.get(), consumer, BUNDLE_NAME);
        KettlePouringRecipeBuilder.kettlePouringRecipe(MDItems.COPPER_CUP, FRFluids.STRONG_APPLE_CIDER.get(), 250, MinersRespiteItems.strongAppleCiderCup.get(), consumer, BUNDLE_NAME);
        KettlePouringRecipeBuilder.kettlePouringRecipe(MDItems.COPPER_CUP, FRFluids.LONG_GREEN_TEA.get(), 250, MinersRespiteItems.longGreenTeaCup.get(), consumer, BUNDLE_NAME);
        KettlePouringRecipeBuilder.kettlePouringRecipe(MDItems.COPPER_CUP, FRFluids.LONG_YELLOW_TEA.get(), 250, MinersRespiteItems.longYellowTeaCup.get(), consumer, BUNDLE_NAME);
        KettlePouringRecipeBuilder.kettlePouringRecipe(MDItems.COPPER_CUP, FRFluids.LONG_BLACK_TEA.get(), 250, MinersRespiteItems.longBlackTeaCup.get(), consumer, BUNDLE_NAME);
        KettlePouringRecipeBuilder.kettlePouringRecipe(MDItems.COPPER_CUP, FRFluids.LONG_COFFEE.get(), 250, MinersRespiteItems.longCoffeeCup.get(), consumer, BUNDLE_NAME);
        KettlePouringRecipeBuilder.kettlePouringRecipe(MDItems.COPPER_CUP, FRFluids.LONG_DANDELION_TEA.get(), 250, MinersRespiteItems.longDandelionTeaCup.get(), consumer, BUNDLE_NAME);
        KettlePouringRecipeBuilder.kettlePouringRecipe(MDItems.COPPER_CUP, FRFluids.LONG_PURULENT_TEA.get(), 250, MinersRespiteItems.longPurulentTeaCup.get(), consumer, BUNDLE_NAME);
        KettlePouringRecipeBuilder.kettlePouringRecipe(MDItems.COPPER_CUP, FRFluids.LONG_APPLE_CIDER.get(), 250, MinersRespiteItems.longAppleCiderCup.get(), consumer, BUNDLE_NAME);
    }


    @Override
    public String getBundleName() {
        return BUNDLE_NAME;
    }
}
