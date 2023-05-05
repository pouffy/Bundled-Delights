package com.pouffy.bundledelight.util.data.recipes;

import com.brewinandchewin.data.builder.BCKegRecipeBuilder;
import com.pouffy.bundledelight.compats.brewinandchewin.BrewinMDItems;
import com.pouffy.bundledelight.compats.farmersrespite.RespiteItems;
import com.pouffy.bundledelight.compats.farmersrespite.RespiteMDItems;
import com.sammy.minersdelight.setup.MDItems;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import vectorwing.farmersdelight.common.registry.ModItems;

import java.util.function.Consumer;

public class FermentingRecipes {
    public static final int FERMENTING_TIME = 12000;

    public FermentingRecipes() {
    }

    public static void register(Consumer<FinishedRecipe> consumer) {
        fermentBrews(consumer);
        fermentFoods(consumer);
    }
    private static void fermentBrews(Consumer<FinishedRecipe> consumer) {
        BCKegRecipeBuilder.kegRecipe((ItemLike) BrewinMDItems.BEER_SWIG.get(), 1, 12000, 0.6F, (ItemLike) BrewinMDItems.COPPER_TANKARD.get(), MDItems.WATER_CUP.get(), 3).addIngredient(Items.WHEAT).addIngredient(Items.WHEAT).addIngredient(Items.WHEAT).build(consumer);
        BCKegRecipeBuilder.kegRecipe((ItemLike) BrewinMDItems.VODKA_SWIG.get(), 1, 12000, 0.6F, (ItemLike) BrewinMDItems.COPPER_TANKARD.get(), MDItems.WATER_CUP.get(), 3).addIngredient(Items.POTATO).addIngredient(Items.POTATO).addIngredient(Items.POTATO).addIngredient(Items.WHEAT).build(consumer);
        BCKegRecipeBuilder.kegRecipe((ItemLike) BrewinMDItems.MEAD_SWIG.get(), 1, 12000, 0.6F, (ItemLike) BrewinMDItems.COPPER_TANKARD.get(), Items.HONEY_BOTTLE, 3).addIngredient(Items.WHEAT).addIngredient(Items.WHEAT).addIngredient(Items.GLOW_BERRIES).build(consumer);
        BCKegRecipeBuilder.kegRecipe((ItemLike) BrewinMDItems.RICE_WINE_SWIG.get(), 1, 12000, 0.6F, (ItemLike) BrewinMDItems.COPPER_TANKARD.get(), MDItems.WATER_CUP.get(), 3).addIngredient((ItemLike) ModItems.RICE.get()).addIngredient((ItemLike)ModItems.RICE.get()).addIngredient((ItemLike)ModItems.RICE.get()).addIngredient((ItemLike)ModItems.RICE.get()).build(consumer);
        BCKegRecipeBuilder.kegRecipe((ItemLike) BrewinMDItems.EGG_GROG_SWIG.get(), 1, 12000, 0.6F, (ItemLike) BrewinMDItems.COPPER_TANKARD.get(), MDItems.MILK_CUP.get(), 3).addIngredient(Items.EGG).addIngredient(Items.EGG).addIngredient((ItemLike)ModItems.CABBAGE_LEAF.get()).addIngredient(Items.SUGAR).build(consumer);
        BCKegRecipeBuilder.kegRecipe((ItemLike) BrewinMDItems.STRONGROOT_ALE_SWIG.get(), 1, 12000, 0.6F, (ItemLike) BrewinMDItems.COPPER_TANKARD.get(), (ItemLike)BrewinMDItems.BEER_SWIG.get(), 3).addIngredient(Items.BEETROOT).addIngredient(Items.POTATO).addIngredient(Items.BROWN_MUSHROOM).addIngredient(Items.CARROT).build(consumer);
        BCKegRecipeBuilder.kegRecipe((ItemLike) BrewinMDItems.SACCHARINE_RUM_SWIG.get(), 1, 12000, 0.6F, (ItemLike) BrewinMDItems.COPPER_TANKARD.get(), (ItemLike)BrewinMDItems.MEAD_SWIG.get(), 4).addIngredient(Items.SWEET_BERRIES).addIngredient(Items.SUGAR_CANE).addIngredient(Items.SUGAR_CANE).addIngredient(Items.MELON_SLICE).build(consumer);
        BCKegRecipeBuilder.kegRecipe((ItemLike) BrewinMDItems.PALE_JANE_SWIG.get(), 1, 12000, 0.6F, (ItemLike) BrewinMDItems.COPPER_TANKARD.get(), (ItemLike)BrewinMDItems.RICE_WINE_SWIG.get(), 4).addIngredient(Items.HONEY_BOTTLE).addIngredient((ItemLike)ModItems.TREE_BARK.get()).addIngredient(Items.LILY_OF_THE_VALLEY).addIngredient(Items.SUGAR).build(consumer);
        BCKegRecipeBuilder.kegRecipe((ItemLike) BrewinMDItems.DREAD_NOG_SWIG.get(), 1, 12000, 0.6F, (ItemLike) BrewinMDItems.COPPER_TANKARD.get(), (ItemLike)BrewinMDItems.EGG_GROG_SWIG.get(), 1).addIngredient(Items.EGG).addIngredient(Items.EGG).addIngredient(Items.TURTLE_EGG).addIngredient(Items.FERMENTED_SPIDER_EYE).build(consumer);
        BCKegRecipeBuilder.kegRecipe((ItemLike) BrewinMDItems.SALTY_FOLLY_SWIG.get(), 1, 12000, 0.6F, (ItemLike) BrewinMDItems.COPPER_TANKARD.get(), (ItemLike)BrewinMDItems.VODKA_SWIG.get(), 2).addIngredient(Items.SEA_PICKLE).addIngredient(Items.DRIED_KELP).addIngredient(Items.DRIED_KELP).addIngredient(Items.SEAGRASS).build(consumer);
        BCKegRecipeBuilder.kegRecipe((ItemLike) BrewinMDItems.STEEL_TOE_STOUT_SWIG.get(), 1, 12000, 0.6F, (ItemLike) BrewinMDItems.COPPER_TANKARD.get(), (ItemLike)BrewinMDItems.STRONGROOT_ALE_SWIG.get(), 1).addIngredient(Items.CRIMSON_FUNGUS).addIngredient(Items.IRON_INGOT).addIngredient(Items.NETHER_WART).addIngredient(Items.WHEAT).build(consumer);
        BCKegRecipeBuilder.kegRecipe((ItemLike) BrewinMDItems.GLITTERING_GRENADINE_SWIG.get(), 1, 12000, 0.6F, (ItemLike) BrewinMDItems.COPPER_TANKARD.get(), MDItems.WATER_CUP.get(), 2).addIngredient(Items.GLOW_BERRIES).addIngredient(Items.GLOW_INK_SAC).addIngredient(Items.GLOWSTONE_DUST).addIngredient(Items.GLOW_BERRIES).build(consumer);
        BCKegRecipeBuilder.kegRecipe((ItemLike) BrewinMDItems.BLOODY_MARY_SWIG.get(), 1, 12000, 0.6F, (ItemLike) BrewinMDItems.COPPER_TANKARD.get(), (ItemLike)BrewinMDItems.VODKA_SWIG.get(), 4).addIngredient((ItemLike)ModItems.TOMATO.get()).addIngredient((ItemLike)ModItems.TOMATO.get()).addIngredient((ItemLike)ModItems.CABBAGE_LEAF.get()).addIngredient(Items.SWEET_BERRIES).build(consumer);
        BCKegRecipeBuilder.kegRecipe((ItemLike) BrewinMDItems.RED_RUM_SWIG.get(), 1, 12000, 0.6F, (ItemLike) BrewinMDItems.COPPER_TANKARD.get(), (ItemLike)BrewinMDItems.BLOODY_MARY_SWIG.get(), 5).addIngredient(Items.CRIMSON_FUNGUS).addIngredient(Items.NETHER_WART).addIngredient(Items.FERMENTED_SPIDER_EYE).addIngredient(Items.SHROOMLIGHT).build(consumer);
        BCKegRecipeBuilder.kegRecipe((ItemLike) BrewinMDItems.WITHERING_DROSS_SWIG.get(), 1, 12000, 0.6F, (ItemLike) BrewinMDItems.COPPER_TANKARD.get(), (ItemLike)BrewinMDItems.SALTY_FOLLY_SWIG.get(), 5).addIngredient(Items.WITHER_ROSE).addIngredient(Items.INK_SAC).addIngredient(Items.NETHER_WART).addIngredient(Items.BONE).build(consumer);
        BCKegRecipeBuilder.kegRecipe((ItemLike) BrewinMDItems.KOMBUCHA_SWIG.get(), 1, 12000, 0.6F, (ItemLike) BrewinMDItems.COPPER_TANKARD.get(), (ItemLike) RespiteMDItems.GREEN_TEA_CUP.get(), 3).addIngredient(Items.BEETROOT).addIngredient(Items.CARROT).addIngredient(RespiteItems.POWDERED_BLACK_TEA_LEAVES.get()).addIngredient(Items.GLOW_BERRIES).build(consumer);
    }
    private static void fermentFoods(Consumer<FinishedRecipe> consumer) {

    }

    }
