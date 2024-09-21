package com.pouffydev.bundledelight.foundation.util.data.recipes;

import com.pouffydev.bundledelight.compat.abnormals_delight.AbnormalsNeapolitanCompatItems;
import com.pouffydev.bundledelight.compat.farmersrespite.RespiteCompatItems;
import com.pouffydev.bundledelight.compat.neapolitan.NeapolitanCompatItems;
import com.pouffydev.bundledelight.foundation.util.data.builder.farmersdelight.CuttingBoardRecipeBuilder;
import com.pouffydev.bundledelight.init.BDItems;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import vectorwing.farmersdelight.common.tag.ModTags;

import java.util.function.Consumer;

import static com.pouffydev.bundledelight.foundation.util.CommonUtil.*;

public class CuttingRecipes {
    public CuttingRecipes(){}
    public static void register(Consumer<FinishedRecipe> consumer) {
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of((ItemLike) fromFR("COFFEE_BEANS")), Ingredient.of(ModTags.KNIVES), (ItemLike) RespiteCompatItems.POWDERED_COFFEE_BEANS.get(), 2).addResultWithChance(RespiteCompatItems.POWDERED_COFFEE_BEANS.get(), 0.5F).build(consumer);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of((ItemLike) fromFR("GREEN_TEA_LEAVES")), Ingredient.of(ModTags.KNIVES), (ItemLike) RespiteCompatItems.POWDERED_GREEN_TEA_LEAVES.get(), 2).addResultWithChance(RespiteCompatItems.POWDERED_GREEN_TEA_LEAVES.get(), 0.5F).build(consumer);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of((ItemLike) fromFR("YELLOW_TEA_LEAVES")), Ingredient.of(ModTags.KNIVES), (ItemLike) RespiteCompatItems.POWDERED_YELLOW_TEA_LEAVES.get(), 2).addResultWithChance(RespiteCompatItems.POWDERED_YELLOW_TEA_LEAVES.get(), 0.5F).build(consumer);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of((ItemLike) fromFR("BLACK_TEA_LEAVES")), Ingredient.of(ModTags.KNIVES), (ItemLike) RespiteCompatItems.POWDERED_BLACK_TEA_LEAVES.get(), 2).addResultWithChance(RespiteCompatItems.POWDERED_BLACK_TEA_LEAVES.get(), 0.5F).build(consumer);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of((ItemLike) fromN("DRIED_VANILLA_PODS")), Ingredient.of(ModTags.KNIVES), (ItemLike) NeapolitanCompatItems.POWDERED_VANILLA_PODS.get(), 2).addResultWithChance(NeapolitanCompatItems.POWDERED_VANILLA_PODS.get(), 0.5F).build(consumer);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of((ItemLike) fromN("ROASTED_ADZUKI_BEANS")), Ingredient.of(ModTags.KNIVES), (ItemLike) NeapolitanCompatItems.POWDERED_ADZUKI_BEANS.get(), 2).addResultWithChance(NeapolitanCompatItems.POWDERED_ADZUKI_BEANS.get(), 0.5F).build(consumer);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of((ItemLike) fromN("MINT_LEAVES")), Ingredient.of(ModTags.KNIVES), (ItemLike) NeapolitanCompatItems.POWDERED_MINT_LEAVES.get(), 2).addResultWithChance(NeapolitanCompatItems.POWDERED_MINT_LEAVES.get(), 0.5F).build(consumer);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of((ItemLike) NeapolitanCompatItems.STRAWBERRY_CAKE.get()), Ingredient.of(ModTags.KNIVES), (ItemLike) AbnormalsNeapolitanCompatItems.WHITE_STRAWBERRY_CAKE_SLICE.get(), 7).build(consumer);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of((ItemLike) BDItems.CARROT_CAKE.get()), Ingredient.of(ModTags.KNIVES), (ItemLike) BDItems.CARROT_CAKE_SLICE.get(), 7).build(consumer);
    }
}
