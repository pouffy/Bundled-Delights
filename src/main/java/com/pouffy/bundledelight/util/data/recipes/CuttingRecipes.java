package com.pouffy.bundledelight.util.data.recipes;

import com.farmersrespite.core.registry.FRItems;
import com.pouffy.bundledelight.compats.farmersrespite.RespiteItems;
import com.pouffy.bundledelight.compats.neapolitan.NeapolitanCompatItems;
import com.teamabnormals.neapolitan.core.registry.NeapolitanItems;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import vectorwing.farmersdelight.common.tag.ModTags;
import vectorwing.farmersdelight.data.builder.CuttingBoardRecipeBuilder;

import java.util.function.Consumer;

public class CuttingRecipes {
    public CuttingRecipes(){}
    public static void register(Consumer<FinishedRecipe> consumer) {
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of((ItemLike) FRItems.COFFEE_BEANS.get()), Ingredient.of(ModTags.KNIVES), (ItemLike) RespiteItems.POWDERED_COFFEE_BEANS.get(), 2).addResultWithChance(RespiteItems.POWDERED_COFFEE_BEANS.get(), 0.5F).build(consumer);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of((ItemLike) FRItems.GREEN_TEA_LEAVES.get()), Ingredient.of(ModTags.KNIVES), (ItemLike) RespiteItems.POWDERED_GREEN_TEA_LEAVES.get(), 2).addResultWithChance(RespiteItems.POWDERED_GREEN_TEA_LEAVES.get(), 0.5F).build(consumer);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of((ItemLike) FRItems.YELLOW_TEA_LEAVES.get()), Ingredient.of(ModTags.KNIVES), (ItemLike) RespiteItems.POWDERED_YELLOW_TEA_LEAVES.get(), 2).addResultWithChance(RespiteItems.POWDERED_YELLOW_TEA_LEAVES.get(), 0.5F).build(consumer);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of((ItemLike) FRItems.BLACK_TEA_LEAVES.get()), Ingredient.of(ModTags.KNIVES), (ItemLike) RespiteItems.POWDERED_BLACK_TEA_LEAVES.get(), 2).addResultWithChance(RespiteItems.POWDERED_BLACK_TEA_LEAVES.get(), 0.5F).build(consumer);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of((ItemLike) NeapolitanItems.DRIED_VANILLA_PODS.get()), Ingredient.of(ModTags.KNIVES), (ItemLike) NeapolitanCompatItems.POWDERED_VANILLA_PODS.get(), 2).addResultWithChance(NeapolitanCompatItems.POWDERED_VANILLA_PODS.get(), 0.5F).build(consumer);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of((ItemLike) NeapolitanItems.ROASTED_ADZUKI_BEANS.get()), Ingredient.of(ModTags.KNIVES), (ItemLike) NeapolitanCompatItems.POWDERED_ADZUKI_BEANS.get(), 2).addResultWithChance(NeapolitanCompatItems.POWDERED_ADZUKI_BEANS.get(), 0.5F).build(consumer);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of((ItemLike) NeapolitanItems.MINT_LEAVES.get()), Ingredient.of(ModTags.KNIVES), (ItemLike) NeapolitanCompatItems.POWDERED_MINT_LEAVES.get(), 2).addResultWithChance(NeapolitanCompatItems.POWDERED_MINT_LEAVES.get(), 0.5F).build(consumer);
    }
}
