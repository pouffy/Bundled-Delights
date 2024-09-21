package com.pouffydev.bundledelight.foundation.util.data.recipes;

import com.pouffydev.bundledelight.compat.farmersrespite.RespiteCompatItems;
import com.pouffydev.bundledelight.init.BDItems;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import vectorwing.farmersdelight.client.recipebook.CookingPotRecipeBookTab;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.ForgeTags;
import vectorwing.farmersdelight.data.builder.CookingPotRecipeBuilder;

import java.util.function.Consumer;

import static com.pouffydev.bundledelight.foundation.util.CommonUtil.getItem;

public class CookingRecipes {
    public static final int FAST_COOKING = 100;
    public static final int NORMAL_COOKING = 200;
    public static final int SLOW_COOKING = 400;
    public static final float SMALL_EXP = 0.35F;
    public static final float MEDIUM_EXP = 1.0F;
    public static final float LARGE_EXP = 2.0F;

    public CookingRecipes() {
    }
    public static void register(Consumer<FinishedRecipe> consumer) {
        cookMiscellaneous(consumer);
        cookMeals(consumer);
    }
    private static void cookMiscellaneous(Consumer<FinishedRecipe> consumer) {

    }
    private static void cookMeals(Consumer<FinishedRecipe> consumer) {
        CookingPotRecipeBuilder.cookingPotRecipe((ItemLike) BDItems.BORSCHT.get(), 1, 200, 1.0F).addIngredient(ForgeTags.RAW_BEEF).addIngredient(Items.BEETROOT).addIngredient(ForgeTags.CROPS_CABBAGE).addIngredient(ModItems.TOMATO_SAUCE.get()).unlockedByAnyIngredient(Items.BEEF, Items.BEETROOT, ModItems.CABBAGE.get(), ModItems.TOMATO_SAUCE.get()).setRecipeBookTab(CookingPotRecipeBookTab.MEALS).build(consumer);
        CookingPotRecipeBuilder.cookingPotRecipe((ItemLike) BDItems.NETTLE_SOUP.get(), 1, 200, 1.0F).addIngredient(Items.WATER_BUCKET).addIngredient(Items.FERN).addIngredient(ForgeTags.VEGETABLES).addIngredient(ForgeTags.SEEDS).unlockedByAnyIngredient(Items.FERN).setRecipeBookTab(CookingPotRecipeBookTab.MEALS).build(consumer);
        CookingPotRecipeBuilder.cookingPotRecipe((ItemLike) getItem(new ResourceLocation("farmersrespite", "tea_curry")), 1, 200, 0.35F).addIngredient((ItemLike) RespiteCompatItems.POWDERED_YELLOW_TEA_LEAVES.get()).addIngredient((ItemLike)RespiteCompatItems.POWDERED_YELLOW_TEA_LEAVES.get()).addIngredient(ForgeTags.RAW_CHICKEN).addIngredient(ForgeTags.CROPS_CABBAGE).addIngredient(ForgeTags.CROPS_ONION).addIngredient(ForgeTags.CROPS_RICE).build(consumer);
    }




    }
