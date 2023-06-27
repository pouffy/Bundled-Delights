package com.pouffy.bundledelight.util.data.recipes;

import com.farmersrespite.core.registry.FRItems;
import com.pouffy.bundledelight.compats.brewinandchewin.BrewinCompatItems;
import com.pouffy.bundledelight.compats.brewinandchewin.BrewinMDCompatItems;
import com.pouffy.bundledelight.compats.farmersrespite.RespiteCompatItems;
import com.pouffy.bundledelight.compats.farmersrespite.RespiteMDCompatItems;
import com.pouffy.bundledelight.util.data.builder.brewinandchewin.KegRecipeBuilder;
import com.sammy.minersdelight.setup.MDItems;
import com.teamabnormals.neapolitan.core.registry.NeapolitanItems;
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
        KegRecipeBuilder.kegRecipe((ItemLike) BrewinMDCompatItems.BEER_SWIG.get(), 1, 12000, 0.6F, (ItemLike) BrewinMDCompatItems.COPPER_TANKARD.get(), MDItems.WATER_CUP.get(), 3).addIngredient(Items.WHEAT).addIngredient(Items.WHEAT).addIngredient(Items.WHEAT).build(consumer);
        KegRecipeBuilder.kegRecipe((ItemLike) BrewinMDCompatItems.VODKA_SWIG.get(), 1, 12000, 0.6F, (ItemLike) BrewinMDCompatItems.COPPER_TANKARD.get(), MDItems.WATER_CUP.get(), 3).addIngredient(Items.POTATO).addIngredient(Items.POTATO).addIngredient(Items.POTATO).addIngredient(Items.WHEAT).build(consumer);
        KegRecipeBuilder.kegRecipe((ItemLike) BrewinMDCompatItems.MEAD_SWIG.get(), 1, 12000, 0.6F, (ItemLike) BrewinMDCompatItems.COPPER_TANKARD.get(), Items.HONEY_BOTTLE, 3).addIngredient(Items.WHEAT).addIngredient(Items.WHEAT).addIngredient(Items.GLOW_BERRIES).build(consumer);
        KegRecipeBuilder.kegRecipe((ItemLike) BrewinMDCompatItems.RICE_WINE_SWIG.get(), 1, 12000, 0.6F, (ItemLike) BrewinMDCompatItems.COPPER_TANKARD.get(), MDItems.WATER_CUP.get(), 3).addIngredient((ItemLike) ModItems.RICE.get()).addIngredient((ItemLike)ModItems.RICE.get()).addIngredient((ItemLike)ModItems.RICE.get()).addIngredient((ItemLike)ModItems.RICE.get()).build(consumer);
        KegRecipeBuilder.kegRecipe((ItemLike) BrewinMDCompatItems.EGG_GROG_SWIG.get(), 1, 12000, 0.6F, (ItemLike) BrewinMDCompatItems.COPPER_TANKARD.get(), MDItems.MILK_CUP.get(), 3).addIngredient(Items.EGG).addIngredient(Items.EGG).addIngredient((ItemLike)ModItems.CABBAGE_LEAF.get()).addIngredient(Items.SUGAR).build(consumer);
        KegRecipeBuilder.kegRecipe((ItemLike) BrewinMDCompatItems.STRONGROOT_ALE_SWIG.get(), 1, 12000, 0.6F, (ItemLike) BrewinMDCompatItems.COPPER_TANKARD.get(), (ItemLike) BrewinMDCompatItems.BEER_SWIG.get(), 3).addIngredient(Items.BEETROOT).addIngredient(Items.POTATO).addIngredient(Items.BROWN_MUSHROOM).addIngredient(Items.CARROT).build(consumer);
        KegRecipeBuilder.kegRecipe((ItemLike) BrewinMDCompatItems.SACCHARINE_RUM_SWIG.get(), 1, 12000, 0.6F, (ItemLike) BrewinMDCompatItems.COPPER_TANKARD.get(), (ItemLike) BrewinMDCompatItems.MEAD_SWIG.get(), 4).addIngredient(Items.SWEET_BERRIES).addIngredient(Items.SUGAR_CANE).addIngredient(Items.SUGAR_CANE).addIngredient(Items.MELON_SLICE).build(consumer);
        KegRecipeBuilder.kegRecipe((ItemLike) BrewinMDCompatItems.PALE_JANE_SWIG.get(), 1, 12000, 0.6F, (ItemLike) BrewinMDCompatItems.COPPER_TANKARD.get(), (ItemLike) BrewinMDCompatItems.RICE_WINE_SWIG.get(), 4).addIngredient(Items.HONEY_BOTTLE).addIngredient((ItemLike)ModItems.TREE_BARK.get()).addIngredient(Items.LILY_OF_THE_VALLEY).addIngredient(Items.SUGAR).build(consumer);
        KegRecipeBuilder.kegRecipe((ItemLike) BrewinMDCompatItems.DREAD_NOG_SWIG.get(), 1, 12000, 0.6F, (ItemLike) BrewinMDCompatItems.COPPER_TANKARD.get(), (ItemLike) BrewinMDCompatItems.EGG_GROG_SWIG.get(), 1).addIngredient(Items.EGG).addIngredient(Items.EGG).addIngredient(Items.TURTLE_EGG).addIngredient(Items.FERMENTED_SPIDER_EYE).build(consumer);
        KegRecipeBuilder.kegRecipe((ItemLike) BrewinMDCompatItems.SALTY_FOLLY_SWIG.get(), 1, 12000, 0.6F, (ItemLike) BrewinMDCompatItems.COPPER_TANKARD.get(), (ItemLike) BrewinMDCompatItems.VODKA_SWIG.get(), 2).addIngredient(Items.SEA_PICKLE).addIngredient(Items.DRIED_KELP).addIngredient(Items.DRIED_KELP).addIngredient(Items.SEAGRASS).build(consumer);
        KegRecipeBuilder.kegRecipe((ItemLike) BrewinMDCompatItems.STEEL_TOE_STOUT_SWIG.get(), 1, 12000, 0.6F, (ItemLike) BrewinMDCompatItems.COPPER_TANKARD.get(), (ItemLike) BrewinMDCompatItems.STRONGROOT_ALE_SWIG.get(), 1).addIngredient(Items.CRIMSON_FUNGUS).addIngredient(Items.IRON_INGOT).addIngredient(Items.NETHER_WART).addIngredient(Items.WHEAT).build(consumer);
        KegRecipeBuilder.kegRecipe((ItemLike) BrewinMDCompatItems.GLITTERING_GRENADINE_SWIG.get(), 1, 12000, 0.6F, (ItemLike) BrewinMDCompatItems.COPPER_TANKARD.get(), MDItems.WATER_CUP.get(), 2).addIngredient(Items.GLOW_BERRIES).addIngredient(Items.GLOW_INK_SAC).addIngredient(Items.GLOWSTONE_DUST).addIngredient(Items.GLOW_BERRIES).build(consumer);
        KegRecipeBuilder.kegRecipe((ItemLike) BrewinMDCompatItems.BLOODY_MARY_SWIG.get(), 1, 12000, 0.6F, (ItemLike) BrewinMDCompatItems.COPPER_TANKARD.get(), (ItemLike) BrewinMDCompatItems.VODKA_SWIG.get(), 4).addIngredient((ItemLike)ModItems.TOMATO.get()).addIngredient((ItemLike)ModItems.TOMATO.get()).addIngredient((ItemLike)ModItems.CABBAGE_LEAF.get()).addIngredient(Items.SWEET_BERRIES).build(consumer);
        KegRecipeBuilder.kegRecipe((ItemLike) BrewinMDCompatItems.RED_RUM_SWIG.get(), 1, 12000, 0.6F, (ItemLike) BrewinMDCompatItems.COPPER_TANKARD.get(), (ItemLike) BrewinMDCompatItems.BLOODY_MARY_SWIG.get(), 5).addIngredient(Items.CRIMSON_FUNGUS).addIngredient(Items.NETHER_WART).addIngredient(Items.FERMENTED_SPIDER_EYE).addIngredient(Items.SHROOMLIGHT).build(consumer);
        KegRecipeBuilder.kegRecipe((ItemLike) BrewinMDCompatItems.WITHERING_DROSS_SWIG.get(), 1, 12000, 0.6F, (ItemLike) BrewinMDCompatItems.COPPER_TANKARD.get(), (ItemLike) BrewinMDCompatItems.SALTY_FOLLY_SWIG.get(), 5).addIngredient(Items.WITHER_ROSE).addIngredient(Items.INK_SAC).addIngredient(Items.NETHER_WART).addIngredient(Items.BONE).build(consumer);
        KegRecipeBuilder.kegRecipe((ItemLike) BrewinMDCompatItems.KOMBUCHA_SWIG.get(), 1, 12000, 0.6F, (ItemLike) BrewinMDCompatItems.COPPER_TANKARD.get(), (ItemLike) RespiteMDCompatItems.GREEN_TEA_CUP.get(), 3).addIngredient(Items.BEETROOT).addIngredient(Items.CARROT).addIngredient(RespiteCompatItems.POWDERED_BLACK_TEA_LEAVES.get()).addIngredient(Items.GLOW_BERRIES).build(consumer);
        KegRecipeBuilder.kegRecipe((ItemLike) BrewinMDCompatItems.ROOT_BEER_SWIG.get(), 1, 12000, 0.6F, (ItemLike) BrewinMDCompatItems.COPPER_TANKARD.get(), MDItems.WATER_CUP.get(), 3).addIngredient(Items.HANGING_ROOTS).addIngredient(Items.SUGAR).addIngredient(ModItems.TREE_BARK.get()).addIngredient(Items.GLOW_BERRIES).build(consumer);
        KegRecipeBuilder.kegRecipe((ItemLike) BrewinCompatItems.BEER_GLASS.get(), 1, 12000, 0.6F, (ItemLike) BrewinCompatItems.GLASS_TANKARD.get(), Items.WATER_BUCKET, 3).addIngredient(Items.BROWN_MUSHROOM).addIngredient(Items.WHEAT).addIngredient(Items.WHEAT).build(consumer);
        KegRecipeBuilder.kegRecipe((ItemLike) BrewinCompatItems.VODKA_GLASS.get(), 1, 12000, 0.6F, (ItemLike) BrewinCompatItems.GLASS_TANKARD.get(), Items.WATER_BUCKET, 3).addIngredient(Items.POTATO).addIngredient(Items.POTATO).addIngredient(Items.WHEAT).addIngredient(Items.WHEAT).build(consumer);
        KegRecipeBuilder.kegRecipe((ItemLike) BrewinCompatItems.MEAD_GLASS.get(), 1, 12000, 0.6F, (ItemLike) BrewinCompatItems.GLASS_TANKARD.get(), Items.HONEY_BOTTLE, 3).addIngredient(Items.WHEAT).addIngredient(Items.WHEAT).addIngredient(Items.HONEY_BOTTLE).build(consumer);
        KegRecipeBuilder.kegRecipe((ItemLike) BrewinCompatItems.RICE_WINE_GLASS.get(), 1, 12000, 0.6F, (ItemLike) BrewinCompatItems.GLASS_TANKARD.get(), Items.WATER_BUCKET, 3).addIngredient((ItemLike) ModItems.RICE.get()).addIngredient((ItemLike)ModItems.RICE.get()).addIngredient((ItemLike)Items.SUGAR).addIngredient((ItemLike)Items.SUGAR).build(consumer);
        KegRecipeBuilder.kegRecipe((ItemLike) BrewinCompatItems.EGG_GROG_GLASS.get(), 1, 12000, 0.6F, (ItemLike) BrewinCompatItems.GLASS_TANKARD.get(), Items.MILK_BUCKET, 3).addIngredient(Items.EGG).addIngredient(Items.EGG).addIngredient((ItemLike)Items.KELP).addIngredient(Items.SUGAR).build(consumer);
        KegRecipeBuilder.kegRecipe((ItemLike) BrewinCompatItems.STRONGROOT_ALE_GLASS.get(), 1, 12000, 0.6F, (ItemLike) BrewinCompatItems.GLASS_TANKARD.get(), (ItemLike) BrewinCompatItems.BEER_GLASS.get(), 3).addIngredient(Items.BEETROOT).addIngredient(Items.POTATO).addIngredient(Items.BROWN_MUSHROOM).addIngredient(Items.CARROT).build(consumer);
        KegRecipeBuilder.kegRecipe((ItemLike) BrewinCompatItems.SACCHARINE_RUM_GLASS.get(), 1, 12000, 0.6F, (ItemLike) BrewinCompatItems.GLASS_TANKARD.get(), (ItemLike) BrewinCompatItems.MEAD_GLASS.get(), 4).addIngredient(Items.SWEET_BERRIES).addIngredient(Items.SUGAR_CANE).addIngredient(Items.SUGAR_CANE).addIngredient(Items.MELON_SLICE).build(consumer);
        KegRecipeBuilder.kegRecipe((ItemLike) BrewinCompatItems.PALE_JANE_GLASS.get(), 1, 12000, 0.6F, (ItemLike) BrewinCompatItems.GLASS_TANKARD.get(), (ItemLike) BrewinCompatItems.RICE_WINE_GLASS.get(), 4).addIngredient(Items.HONEY_BOTTLE).addIngredient((ItemLike)ModItems.TREE_BARK.get()).addIngredient(Items.LILY_OF_THE_VALLEY).addIngredient(Items.SUGAR).build(consumer);
        KegRecipeBuilder.kegRecipe((ItemLike) BrewinCompatItems.DREAD_NOG_GLASS.get(), 1, 12000, 0.6F, (ItemLike) BrewinCompatItems.GLASS_TANKARD.get(), (ItemLike) BrewinCompatItems.EGG_GROG_GLASS.get(), 1).addIngredient(Items.EGG).addIngredient(Items.EGG).addIngredient(Items.TURTLE_EGG).addIngredient(Items.FERMENTED_SPIDER_EYE).build(consumer);
        KegRecipeBuilder.kegRecipe((ItemLike) BrewinCompatItems.SALTY_FOLLY_GLASS.get(), 1, 12000, 0.6F, (ItemLike) BrewinCompatItems.GLASS_TANKARD.get(), (ItemLike) BrewinCompatItems.VODKA_GLASS.get(), 2).addIngredient(Items.SEA_PICKLE).addIngredient(Items.DRIED_KELP).addIngredient(Items.DRIED_KELP).addIngredient(Items.SEAGRASS).build(consumer);
        KegRecipeBuilder.kegRecipe((ItemLike) BrewinCompatItems.STEEL_TOE_STOUT_GLASS.get(), 1, 12000, 0.6F, (ItemLike) BrewinCompatItems.GLASS_TANKARD.get(), (ItemLike) BrewinCompatItems.STRONGROOT_ALE_GLASS.get(), 1).addIngredient(Items.CRIMSON_FUNGUS).addIngredient(Items.IRON_INGOT).addIngredient(Items.NETHER_WART).addIngredient(Items.WHEAT).build(consumer);
        KegRecipeBuilder.kegRecipe((ItemLike) BrewinCompatItems.GLITTERING_GRENADINE_GLASS.get(), 1, 12000, 0.6F, (ItemLike) BrewinCompatItems.GLASS_TANKARD.get(), Items.WATER_BUCKET, 2).addIngredient(Items.HONEY_BOTTLE).addIngredient(Items.GLOW_INK_SAC).addIngredient(Items.GLOWSTONE_DUST).addIngredient(Items.GLOW_BERRIES).build(consumer);
        KegRecipeBuilder.kegRecipe((ItemLike) BrewinCompatItems.BLOODY_MARY_GLASS.get(), 1, 12000, 0.6F, (ItemLike) BrewinCompatItems.GLASS_TANKARD.get(), (ItemLike) BrewinCompatItems.VODKA_GLASS.get(), 4).addIngredient((ItemLike)ModItems.TOMATO.get()).addIngredient((ItemLike)ModItems.TOMATO.get()).addIngredient((ItemLike)ModItems.CABBAGE_LEAF.get()).addIngredient(Items.SWEET_BERRIES).build(consumer);
        KegRecipeBuilder.kegRecipe((ItemLike) BrewinCompatItems.RED_RUM_GLASS.get(), 1, 12000, 0.6F, (ItemLike) BrewinCompatItems.GLASS_TANKARD.get(), (ItemLike) BrewinCompatItems.BLOODY_MARY_GLASS.get(), 5).addIngredient(Items.CRIMSON_FUNGUS).addIngredient(Items.NETHER_WART).addIngredient(Items.FERMENTED_SPIDER_EYE).addIngredient(Items.SHROOMLIGHT).build(consumer);
        KegRecipeBuilder.kegRecipe((ItemLike) BrewinCompatItems.WITHERING_DROSS_GLASS.get(), 1, 12000, 0.6F, (ItemLike) BrewinCompatItems.GLASS_TANKARD.get(), (ItemLike) BrewinCompatItems.SALTY_FOLLY_GLASS.get(), 5).addIngredient(Items.WITHER_ROSE).addIngredient(Items.INK_SAC).addIngredient(Items.NETHER_WART).addIngredient(Items.BONE).build(consumer);
        KegRecipeBuilder.kegRecipe((ItemLike) BrewinCompatItems.KOMBUCHA_GLASS.get(), 1, 12000, 0.6F, (ItemLike) BrewinCompatItems.GLASS_TANKARD.get(), (ItemLike) FRItems.GREEN_TEA.get(), 3).addIngredient(Items.BEETROOT).addIngredient(Items.CARROT).addIngredient(RespiteCompatItems.POWDERED_BLACK_TEA_LEAVES.get()).addIngredient(Items.SWEET_BERRIES).build(consumer);
        KegRecipeBuilder.kegRecipe((ItemLike) BrewinCompatItems.ROOT_BEER_GLASS.get(), 1, 12000, 0.6F, (ItemLike) BrewinCompatItems.GLASS_TANKARD.get(), Items.WATER_BUCKET, 3).addIngredient(Items.HANGING_ROOTS).addIngredient(Items.SUGAR).addIngredient(ModItems.TREE_BARK.get()).addIngredient(Items.HONEY_BOTTLE).build(consumer);


        //BCKegRecipeBuilder.kegRecipe((ItemLike) BrewinCompatItems.ROOT_BEER.get(), 1, 12000, 0.6F, (ItemLike) BCItems.TANKARD.get(), Items.WATER_BUCKET, 3).addIngredient(Items.HANGING_ROOTS).addIngredient(Items.SUGAR).addIngredient(ModItems.TREE_BARK.get()).addIngredient(Items.SWEET_BERRIES).build(consumer);

        KegRecipeBuilder.kegRecipe((ItemLike) NeapolitanItems.VANILLA_FUDGE.get(), 4, 12000, 0.6F, Items.MILK_BUCKET, 5).addIngredient(Items.SUGAR).addIngredient(NeapolitanItems.DRIED_VANILLA_PODS.get()).addIngredient(NeapolitanItems.DRIED_VANILLA_PODS.get()).build(consumer);

    }
    private static void fermentFoods(Consumer<FinishedRecipe> consumer) {

    }

    }
