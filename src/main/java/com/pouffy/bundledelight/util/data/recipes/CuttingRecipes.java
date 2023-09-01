package com.pouffy.bundledelight.util.data.recipes;

import com.farmersrespite.core.registry.FRItems;
import com.pouffy.bundledelight.compat.abnormals_delight.AbnormalsNeapolitanCompatItems;
import com.pouffy.bundledelight.compat.farmersrespite.RespiteCompatItems;
import com.pouffy.bundledelight.compat.neapolitan.NeapolitanCompatItems;
import com.pouffy.bundledelight.init.BDItems;
import com.pouffy.bundledelight.util.data.builder.farmersdelight.CuttingBoardRecipeBuilder;
import com.teamabnormals.neapolitan.core.registry.NeapolitanItems;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import vectorwing.farmersdelight.common.tag.ModTags;

import java.util.function.Consumer;

public class CuttingRecipes {
    public CuttingRecipes(){}
    public static void register(Consumer<FinishedRecipe> consumer) {
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of((ItemLike) FRItems.COFFEE_BEANS.get()), Ingredient.of(ModTags.KNIVES), (ItemLike) RespiteCompatItems.POWDERED_COFFEE_BEANS.get(), 2).addResultWithChance(RespiteCompatItems.POWDERED_COFFEE_BEANS.get(), 0.5F).build(consumer);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of((ItemLike) FRItems.GREEN_TEA_LEAVES.get()), Ingredient.of(ModTags.KNIVES), (ItemLike) RespiteCompatItems.POWDERED_GREEN_TEA_LEAVES.get(), 2).addResultWithChance(RespiteCompatItems.POWDERED_GREEN_TEA_LEAVES.get(), 0.5F).build(consumer);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of((ItemLike) FRItems.YELLOW_TEA_LEAVES.get()), Ingredient.of(ModTags.KNIVES), (ItemLike) RespiteCompatItems.POWDERED_YELLOW_TEA_LEAVES.get(), 2).addResultWithChance(RespiteCompatItems.POWDERED_YELLOW_TEA_LEAVES.get(), 0.5F).build(consumer);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of((ItemLike) FRItems.BLACK_TEA_LEAVES.get()), Ingredient.of(ModTags.KNIVES), (ItemLike) RespiteCompatItems.POWDERED_BLACK_TEA_LEAVES.get(), 2).addResultWithChance(RespiteCompatItems.POWDERED_BLACK_TEA_LEAVES.get(), 0.5F).build(consumer);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of((ItemLike) NeapolitanItems.DRIED_VANILLA_PODS.get()), Ingredient.of(ModTags.KNIVES), (ItemLike) NeapolitanCompatItems.POWDERED_VANILLA_PODS.get(), 2).addResultWithChance(NeapolitanCompatItems.POWDERED_VANILLA_PODS.get(), 0.5F).build(consumer);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of((ItemLike) NeapolitanItems.ROASTED_ADZUKI_BEANS.get()), Ingredient.of(ModTags.KNIVES), (ItemLike) NeapolitanCompatItems.POWDERED_ADZUKI_BEANS.get(), 2).addResultWithChance(NeapolitanCompatItems.POWDERED_ADZUKI_BEANS.get(), 0.5F).build(consumer);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of((ItemLike) NeapolitanItems.MINT_LEAVES.get()), Ingredient.of(ModTags.KNIVES), (ItemLike) NeapolitanCompatItems.POWDERED_MINT_LEAVES.get(), 2).addResultWithChance(NeapolitanCompatItems.POWDERED_MINT_LEAVES.get(), 0.5F).build(consumer);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of((ItemLike) NeapolitanCompatItems.STRAWBERRY_CAKE.get()), Ingredient.of(ModTags.KNIVES), (ItemLike) AbnormalsNeapolitanCompatItems.WHITE_STRAWBERRY_CAKE_SLICE.get(), 7).build(consumer);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of((ItemLike) BDItems.CARROT_CAKE.get()), Ingredient.of(ModTags.KNIVES), (ItemLike) BDItems.CARROT_CAKE_SLICE.get(), 7).build(consumer);
    }
}
