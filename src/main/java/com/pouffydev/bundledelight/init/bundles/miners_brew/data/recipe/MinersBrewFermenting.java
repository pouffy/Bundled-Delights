package com.pouffydev.bundledelight.init.bundles.miners_brew.data.recipe;

import com.pouffydev.bundledelight.datagen.builder.recipe.KegRecipeBuilder;
import com.pouffydev.bundledelight.foundation.data.BundleRecipeGen;
import com.pouffydev.bundledelight.foundation.data.FinishedData;
import com.pouffydev.bundledelight.init.bundles.farmersrespite.RespiteItems;
import com.pouffydev.bundledelight.init.bundles.miners_brew.MinersBrewItems;
import com.pouffydev.bundledelight.init.bundles.miners_respite.MinersRespiteItems;
import com.sammy.minersdelight.setup.MDItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import vectorwing.farmersdelight.common.registry.ModItems;

import java.util.function.Consumer;

public class MinersBrewFermenting extends BundleRecipeGen {
    private static final String BUNDLE_NAME = "miners_brew";

    public static void register(Consumer<FinishedData> consumer) {
        fermentBrews(consumer);
        fermentFoods(consumer);
    }

    private static final Item copperSwig = MinersBrewItems.copperSwig.get();

    private static void fermentBrews(Consumer<FinishedData> consumer) {
        KegRecipeBuilder.kegRecipe(MinersBrewItems.beerSwig.get(), 1, FERMENTING_TIME, MEDIUM_FERMENT_EXP, copperSwig, MDItems.WATER_CUP.get(), 3, BUNDLE_NAME).addIngredient(Items.WHEAT).addIngredient(Items.WHEAT).addIngredient(Items.WHEAT).build(consumer);
        KegRecipeBuilder.kegRecipe(MinersBrewItems.vodkaSwig.get(), 1, FERMENTING_TIME, MEDIUM_FERMENT_EXP, copperSwig, MDItems.WATER_CUP.get(), 3, BUNDLE_NAME).addIngredient(Items.POTATO).addIngredient(Items.POTATO).addIngredient(Items.POTATO).addIngredient(Items.WHEAT).build(consumer);
        KegRecipeBuilder.kegRecipe(MinersBrewItems.meadSwig.get(), 1, FERMENTING_TIME, MEDIUM_FERMENT_EXP, copperSwig, Items.HONEY_BOTTLE, 3, BUNDLE_NAME).addIngredient(Items.WHEAT).addIngredient(Items.WHEAT).addIngredient(Items.GLOW_BERRIES).build(consumer);
        KegRecipeBuilder.kegRecipe(MinersBrewItems.riceWineSwig.get(), 1, FERMENTING_TIME, MEDIUM_FERMENT_EXP, copperSwig, MDItems.WATER_CUP.get(), 3, BUNDLE_NAME).addIngredient(ModItems.RICE.get()).addIngredient(ModItems.RICE.get()).addIngredient(ModItems.RICE.get()).addIngredient(ModItems.RICE.get()).build(consumer);
        KegRecipeBuilder.kegRecipe(MinersBrewItems.eggGrogSwig.get(), 1, FERMENTING_TIME, MEDIUM_FERMENT_EXP, copperSwig, MDItems.MILK_CUP.get(), 3, BUNDLE_NAME).addIngredient(Items.EGG).addIngredient(Items.EGG).addIngredient(ModItems.CABBAGE_LEAF.get()).addIngredient(Items.SUGAR).build(consumer);
        KegRecipeBuilder.kegRecipe(MinersBrewItems.strongrootAleSwig.get(), 1, FERMENTING_TIME, MEDIUM_FERMENT_EXP, copperSwig, MinersBrewItems.copperSwig.get(), 3, BUNDLE_NAME).addIngredient(Items.BEETROOT).addIngredient(Items.POTATO).addIngredient(Items.BROWN_MUSHROOM).addIngredient(Items.CARROT).build(consumer);
        KegRecipeBuilder.kegRecipe(MinersBrewItems.saccharineRumSwig.get(), 1, FERMENTING_TIME, MEDIUM_FERMENT_EXP, copperSwig, MinersBrewItems.meadSwig.get(), 4, BUNDLE_NAME).addIngredient(Items.SWEET_BERRIES).addIngredient(Items.SUGAR_CANE).addIngredient(Items.SUGAR_CANE).addIngredient(Items.MELON_SLICE).build(consumer);
        KegRecipeBuilder.kegRecipe(MinersBrewItems.paleJaneSwig.get(), 1, FERMENTING_TIME, MEDIUM_FERMENT_EXP, copperSwig, MinersBrewItems.riceWineSwig.get(), 4, BUNDLE_NAME).addIngredient(Items.HONEY_BOTTLE).addIngredient(ModItems.TREE_BARK.get()).addIngredient(Items.LILY_OF_THE_VALLEY).addIngredient(Items.SUGAR).build(consumer);
        KegRecipeBuilder.kegRecipe(MinersBrewItems.dreadNogSwig.get(), 1, FERMENTING_TIME, MEDIUM_FERMENT_EXP, copperSwig, MinersBrewItems.eggGrogSwig.get(), 1, BUNDLE_NAME).addIngredient(Items.EGG).addIngredient(Items.EGG).addIngredient(Items.TURTLE_EGG).addIngredient(Items.FERMENTED_SPIDER_EYE).build(consumer);
        KegRecipeBuilder.kegRecipe(MinersBrewItems.saltyFollySwig.get(), 1, FERMENTING_TIME, MEDIUM_FERMENT_EXP, copperSwig, MinersBrewItems.vodkaSwig.get(), 2, BUNDLE_NAME).addIngredient(Items.SEA_PICKLE).addIngredient(Items.DRIED_KELP).addIngredient(Items.DRIED_KELP).addIngredient(Items.SEAGRASS).build(consumer);
        KegRecipeBuilder.kegRecipe(MinersBrewItems.steelToeStoutSwig.get(), 1, FERMENTING_TIME, MEDIUM_FERMENT_EXP, copperSwig, MinersBrewItems.strongrootAleSwig.get(), 1, BUNDLE_NAME).addIngredient(Items.CRIMSON_FUNGUS).addIngredient(Items.IRON_INGOT).addIngredient(Items.NETHER_WART).addIngredient(Items.WHEAT).build(consumer);
        KegRecipeBuilder.kegRecipe(MinersBrewItems.glitteringGrenadineSwig.get(), 1, FERMENTING_TIME, MEDIUM_FERMENT_EXP, copperSwig, MDItems.WATER_CUP.get(), 2, BUNDLE_NAME).addIngredient(Items.HONEY_BOTTLE).addIngredient(Items.GLOW_INK_SAC).addIngredient(Items.GLOWSTONE_DUST).addIngredient(Items.GLOW_BERRIES).build(consumer);
        KegRecipeBuilder.kegRecipe(MinersBrewItems.bloodyMarySwig.get(), 1, FERMENTING_TIME, MEDIUM_FERMENT_EXP, copperSwig, MinersBrewItems.vodkaSwig.get(), 4, BUNDLE_NAME).addIngredient(ModItems.TOMATO.get()).addIngredient(ModItems.TOMATO.get()).addIngredient(ModItems.CABBAGE_LEAF.get()).addIngredient(Items.SWEET_BERRIES).build(consumer);
        KegRecipeBuilder.kegRecipe(MinersBrewItems.redRumSwig.get(), 1, FERMENTING_TIME, MEDIUM_FERMENT_EXP, copperSwig, MinersBrewItems.bloodyMarySwig.get(), 5, BUNDLE_NAME).addIngredient(Items.CRIMSON_FUNGUS).addIngredient(Items.NETHER_WART).addIngredient(Items.FERMENTED_SPIDER_EYE).addIngredient(Items.SHROOMLIGHT).build(consumer);
        KegRecipeBuilder.kegRecipe(MinersBrewItems.witheringDrossSwig.get(), 1, FERMENTING_TIME, MEDIUM_FERMENT_EXP, copperSwig, MinersBrewItems.saltyFollySwig.get(), 5, BUNDLE_NAME).addIngredient(Items.WITHER_ROSE).addIngredient(Items.INK_SAC).addIngredient(Items.NETHER_WART).addIngredient(Items.BONE).build(consumer);
        KegRecipeBuilder.kegRecipe(MinersBrewItems.kombuchaSwig.get(), 1, FERMENTING_TIME, MEDIUM_FERMENT_EXP, copperSwig, MinersRespiteItems.greenTeaCup.get(), 3, BUNDLE_NAME).addIngredient(Items.BEETROOT).addIngredient(Items.CARROT).addIngredient(RespiteItems.powderedBlackTeaLeaves.get()).addIngredient(Items.SWEET_BERRIES).build(consumer);
        KegRecipeBuilder.kegRecipe(MinersBrewItems.rootBeerSwig.get(), 1, FERMENTING_TIME, MEDIUM_FERMENT_EXP, copperSwig, MDItems.WATER_CUP.get(), 3, BUNDLE_NAME).addIngredient(Items.HANGING_ROOTS).addIngredient(Items.SUGAR).addIngredient(ModItems.TREE_BARK.get()).addIngredient(Items.GLOW_BERRIES).build(consumer);
    }

    private static void fermentFoods(Consumer<FinishedData> consumer) {

    }

    @Override
    public String getBundleName() {
        return BUNDLE_NAME;
    }
}
