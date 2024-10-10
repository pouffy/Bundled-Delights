package com.pouffydev.bundledelight.init.bundles.brewinandchewin.data.recipe;

import com.pouffydev.bundledelight.datagen.builder.recipe.KegRecipeBuilder;
import com.pouffydev.bundledelight.foundation.data.BundleRecipeGen;
import com.pouffydev.bundledelight.foundation.data.FinishedData;
import com.pouffydev.bundledelight.init.bundles.brewinandchewin.BrewinItems;
import com.pouffydev.bundledelight.init.bundles.farmersrespite.RespiteItems;
import com.pouffydev.bundledelight.init.bundles.miners_brew.MinersBrewItems;
import com.sammy.minersdelight.setup.MDItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import umpaz.farmersrespite.common.registry.FRItems;
import vectorwing.farmersdelight.common.registry.ModItems;

import java.util.function.Consumer;

import static com.pouffydev.bundledelight.foundation.util.CommonUtil.fromFR;

public class BrewinFermenting extends BundleRecipeGen {
    private static final String BUNDLE_NAME = "brewinandchewin";
    
    public static void register(Consumer<FinishedData> consumer) {
        fermentBrews(consumer);
        fermentFoods(consumer);
    }
    
    private static final Item glassTankard = BrewinItems.glassTankard.get();
    
    private static void fermentBrews(Consumer<FinishedData> consumer) {
        KegRecipeBuilder.kegRecipe(BrewinItems.beerGlass.get(), 1, FERMENTING_TIME, MEDIUM_FERMENT_EXP, glassTankard, Items.WATER_BUCKET, 3, BUNDLE_NAME).addIngredient(Items.BROWN_MUSHROOM).addIngredient(Items.WHEAT).addIngredient(Items.WHEAT).build(consumer);
        KegRecipeBuilder.kegRecipe(BrewinItems.vodkaGlass.get(), 1, FERMENTING_TIME, MEDIUM_FERMENT_EXP, glassTankard, Items.WATER_BUCKET, 3, BUNDLE_NAME).addIngredient(Items.POTATO).addIngredient(Items.POTATO).addIngredient(Items.WHEAT).addIngredient(Items.WHEAT).build(consumer);
        KegRecipeBuilder.kegRecipe(BrewinItems.meadGlass.get(), 1, FERMENTING_TIME, MEDIUM_FERMENT_EXP, glassTankard, Items.HONEY_BOTTLE, 3, BUNDLE_NAME).addIngredient(Items.WHEAT).addIngredient(Items.WHEAT).addIngredient(Items.HONEY_BOTTLE).build(consumer);
        KegRecipeBuilder.kegRecipe(BrewinItems.riceWineGlass.get(), 1, FERMENTING_TIME, MEDIUM_FERMENT_EXP, glassTankard, Items.WATER_BUCKET, 3, BUNDLE_NAME).addIngredient(ModItems.RICE.get()).addIngredient(ModItems.RICE.get()).addIngredient(Items.SUGAR).addIngredient(Items.SUGAR).build(consumer);
        KegRecipeBuilder.kegRecipe(BrewinItems.eggGrogGlass.get(), 1, FERMENTING_TIME, MEDIUM_FERMENT_EXP, glassTankard, Items.MILK_BUCKET, 3, BUNDLE_NAME).addIngredient(Items.EGG).addIngredient(Items.EGG).addIngredient(Items.KELP).addIngredient(Items.SUGAR).build(consumer);
        KegRecipeBuilder.kegRecipe(BrewinItems.strongrootAleGlass.get(), 1, FERMENTING_TIME, MEDIUM_FERMENT_EXP, glassTankard, BrewinItems.beerGlass.get(), 3, BUNDLE_NAME).addIngredient(Items.BEETROOT).addIngredient(Items.POTATO).addIngredient(Items.BROWN_MUSHROOM).addIngredient(Items.CARROT).build(consumer);
        KegRecipeBuilder.kegRecipe(BrewinItems.saccharineRumGlass.get(), 1, FERMENTING_TIME, MEDIUM_FERMENT_EXP, glassTankard, BrewinItems.meadGlass.get(), 4, BUNDLE_NAME).addIngredient(Items.SWEET_BERRIES).addIngredient(Items.SUGAR_CANE).addIngredient(Items.SUGAR_CANE).addIngredient(Items.MELON_SLICE).build(consumer);
        KegRecipeBuilder.kegRecipe(BrewinItems.paleJaneGlass.get(), 1, FERMENTING_TIME, MEDIUM_FERMENT_EXP, glassTankard, BrewinItems.riceWineGlass.get(), 4, BUNDLE_NAME).addIngredient(Items.HONEY_BOTTLE).addIngredient(ModItems.TREE_BARK.get()).addIngredient(Items.LILY_OF_THE_VALLEY).addIngredient(Items.SUGAR).build(consumer);
        KegRecipeBuilder.kegRecipe(BrewinItems.dreadNogGlass.get(), 1, FERMENTING_TIME, MEDIUM_FERMENT_EXP, glassTankard, BrewinItems.eggGrogGlass.get(), 1, BUNDLE_NAME).addIngredient(Items.EGG).addIngredient(Items.EGG).addIngredient(Items.TURTLE_EGG).addIngredient(Items.FERMENTED_SPIDER_EYE).build(consumer);
        KegRecipeBuilder.kegRecipe(BrewinItems.saltyFollyGlass.get(), 1, FERMENTING_TIME, MEDIUM_FERMENT_EXP, glassTankard, BrewinItems.vodkaGlass.get(), 2, BUNDLE_NAME).addIngredient(Items.SEA_PICKLE).addIngredient(Items.DRIED_KELP).addIngredient(Items.DRIED_KELP).addIngredient(Items.SEAGRASS).build(consumer);
        KegRecipeBuilder.kegRecipe(BrewinItems.steelToeStoutGlass.get(), 1, FERMENTING_TIME, MEDIUM_FERMENT_EXP, glassTankard, BrewinItems.strongrootAleGlass.get(), 1, BUNDLE_NAME).addIngredient(Items.CRIMSON_FUNGUS).addIngredient(Items.IRON_INGOT).addIngredient(Items.NETHER_WART).addIngredient(Items.WHEAT).build(consumer);
        KegRecipeBuilder.kegRecipe(BrewinItems.glitteringGrenadineGlass.get(), 1, FERMENTING_TIME, MEDIUM_FERMENT_EXP, glassTankard, Items.WATER_BUCKET, 2, BUNDLE_NAME).addIngredient(Items.HONEY_BOTTLE).addIngredient(Items.GLOW_INK_SAC).addIngredient(Items.GLOWSTONE_DUST).addIngredient(Items.GLOW_BERRIES).build(consumer);
        KegRecipeBuilder.kegRecipe(BrewinItems.bloodyMaryGlass.get(), 1, FERMENTING_TIME, MEDIUM_FERMENT_EXP, glassTankard, BrewinItems.vodkaGlass.get(), 4, BUNDLE_NAME).addIngredient(ModItems.TOMATO.get()).addIngredient(ModItems.TOMATO.get()).addIngredient(ModItems.CABBAGE_LEAF.get()).addIngredient(Items.SWEET_BERRIES).build(consumer);
        KegRecipeBuilder.kegRecipe(BrewinItems.redRumGlass.get(), 1, FERMENTING_TIME, MEDIUM_FERMENT_EXP, glassTankard, BrewinItems.bloodyMaryGlass.get(), 5, BUNDLE_NAME).addIngredient(Items.CRIMSON_FUNGUS).addIngredient(Items.NETHER_WART).addIngredient(Items.FERMENTED_SPIDER_EYE).addIngredient(Items.SHROOMLIGHT).build(consumer);
        KegRecipeBuilder.kegRecipe(BrewinItems.witheringDrossGlass.get(), 1, FERMENTING_TIME, MEDIUM_FERMENT_EXP, glassTankard, BrewinItems.saltyFollyGlass.get(), 5, BUNDLE_NAME).addIngredient(Items.WITHER_ROSE).addIngredient(Items.INK_SAC).addIngredient(Items.NETHER_WART).addIngredient(Items.BONE).build(consumer);
        KegRecipeBuilder.kegRecipe(BrewinItems.kombuchaGlass.get(), 1, FERMENTING_TIME, MEDIUM_FERMENT_EXP, glassTankard, FRItems.GREEN_TEA.get(), 3, BUNDLE_NAME).addIngredient(Items.BEETROOT).addIngredient(Items.CARROT).addIngredient(RespiteItems.powderedBlackTeaLeaves.get()).addIngredient(Items.SWEET_BERRIES).build(consumer);
        KegRecipeBuilder.kegRecipe(BrewinItems.rootBeerGlass.get(), 1, FERMENTING_TIME, MEDIUM_FERMENT_EXP, glassTankard, Items.WATER_BUCKET, 3, BUNDLE_NAME).addIngredient(Items.HANGING_ROOTS).addIngredient(Items.SUGAR).addIngredient(ModItems.TREE_BARK.get()).addIngredient(Items.HONEY_BOTTLE).build(consumer);
    }
    
    private static void fermentFoods(Consumer<FinishedData> consumer) {
    
    }
    
    @Override
    public String getBundleName() {
        return BUNDLE_NAME;
    }
}
