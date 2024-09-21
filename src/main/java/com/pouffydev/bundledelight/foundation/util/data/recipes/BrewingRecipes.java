package com.pouffydev.bundledelight.foundation.util.data.recipes;

import com.pouffydev.bundledelight.compat.farmersrespite.RespiteCompatItems;
import com.pouffydev.bundledelight.compat.farmersrespite.RespiteMDCompatItems;
import com.pouffydev.bundledelight.compat.neapolitan.NeapolitanCompatItems;
import com.pouffydev.bundledelight.compat.respiteful.RespitefulMDCompatItems;
import com.pouffydev.bundledelight.content.tag.BDTags;
import com.pouffydev.bundledelight.foundation.util.data.FinishedData;
import com.pouffydev.bundledelight.foundation.util.data.builder.farmersrespite.KettleRecipeBuilder;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import vectorwing.farmersdelight.common.tag.ForgeTags;

import java.util.function.Consumer;

import static com.pouffydev.bundledelight.compat.farmersrespite.RespiteMDCompatItems.CUP;
import static com.pouffydev.bundledelight.foundation.util.CommonUtil.getItem;

public class BrewingRecipes {
    public BrewingRecipes() {
    }

    public static void register(Consumer<FinishedData> consumer) {
        cookMiscellaneous(consumer);
    }

    private static void cookMiscellaneous(Consumer<FinishedData> consumer) {
        KettleRecipeBuilder.kettleRecipe((ItemLike) RespiteMDCompatItems.GREEN_TEA_CUP.get()).addIngredient((ItemLike) RespiteCompatItems.POWDERED_GREEN_TEA_LEAVES.get()).addIngredient((ItemLike) RespiteCompatItems.POWDERED_GREEN_TEA_LEAVES.get()).build(consumer);
        KettleRecipeBuilder.kettleRecipe((ItemLike) RespiteMDCompatItems.LONG_GREEN_TEA_CUP.get(), 1, 2400, 0.35F, false, CUP.get()).addIngredient((ItemLike) RespiteMDCompatItems.GREEN_TEA_CUP.get()).addIngredient(ForgeTags.MILK).build(consumer);
        KettleRecipeBuilder.kettleRecipe((ItemLike) RespiteMDCompatItems.STRONG_GREEN_TEA_CUP.get(), 1, 2400, 0.35F, false, CUP.get()).addIngredient((ItemLike) RespiteMDCompatItems.GREEN_TEA_CUP.get()).addIngredient(Items.HONEY_BOTTLE).build(consumer);

        KettleRecipeBuilder.kettleRecipe((ItemLike) RespiteMDCompatItems.YELLOW_TEA_CUP.get()).addIngredient((ItemLike) RespiteCompatItems.POWDERED_YELLOW_TEA_LEAVES.get()).addIngredient((ItemLike) RespiteCompatItems.POWDERED_YELLOW_TEA_LEAVES.get()).build(consumer);
        KettleRecipeBuilder.kettleRecipe((ItemLike) RespiteMDCompatItems.LONG_YELLOW_TEA_CUP.get(), 1, 2400, 0.35F, false, CUP.get()).addIngredient((ItemLike) RespiteMDCompatItems.YELLOW_TEA_CUP.get()).addIngredient(ForgeTags.MILK).build(consumer);
        KettleRecipeBuilder.kettleRecipe((ItemLike) RespiteMDCompatItems.STRONG_YELLOW_TEA_CUP.get(), 1, 2400, 0.35F, false, CUP.get()).addIngredient((ItemLike) RespiteMDCompatItems.YELLOW_TEA_CUP.get()).addIngredient(Items.HONEY_BOTTLE).build(consumer);

        KettleRecipeBuilder.kettleRecipe((ItemLike) RespiteMDCompatItems.BLACK_TEA_CUP.get()).addIngredient((ItemLike) RespiteCompatItems.POWDERED_BLACK_TEA_LEAVES.get()).addIngredient((ItemLike) RespiteCompatItems.POWDERED_BLACK_TEA_LEAVES.get()).build(consumer);
        KettleRecipeBuilder.kettleRecipe((ItemLike) RespiteMDCompatItems.LONG_BLACK_TEA_CUP.get(), 1, 2400, 0.35F, false, CUP.get()).addIngredient((ItemLike) RespiteMDCompatItems.BLACK_TEA_CUP.get()).addIngredient(ForgeTags.MILK).build(consumer);
        KettleRecipeBuilder.kettleRecipe((ItemLike) RespiteMDCompatItems.STRONG_BLACK_TEA_CUP.get(), 1, 2400, 0.35F, false, CUP.get()).addIngredient((ItemLike) RespiteMDCompatItems.BLACK_TEA_CUP.get()).addIngredient(Items.HONEY_BOTTLE).build(consumer);

        KettleRecipeBuilder.kettleRecipe((ItemLike) RespiteMDCompatItems.COFFEE_CUP.get()).addIngredient((ItemLike) RespiteCompatItems.POWDERED_COFFEE_BEANS.get()).addIngredient((ItemLike) RespiteCompatItems.POWDERED_COFFEE_BEANS.get()).build(consumer);
        KettleRecipeBuilder.kettleRecipe((ItemLike) RespiteMDCompatItems.LONG_COFFEE_CUP.get(), 1, 2400, 0.35F, false, CUP.get()).addIngredient((ItemLike) RespiteMDCompatItems.COFFEE_CUP.get()).addIngredient(ForgeTags.MILK).build(consumer);
        KettleRecipeBuilder.kettleRecipe((ItemLike) RespiteMDCompatItems.STRONG_COFFEE_CUP.get(), 1, 2400, 0.35F, false, CUP.get()).addIngredient((ItemLike) RespiteMDCompatItems.COFFEE_CUP.get()).addIngredient(Items.HONEY_BOTTLE).build(consumer);

        KettleRecipeBuilder.kettleRecipe((ItemLike) RespiteMDCompatItems.ROSE_HIP_TEA_CUP.get()).addIngredient((ItemLike) getItem(new ResourceLocation("farmersrespite", "rose_hips"))).build(consumer);
        KettleRecipeBuilder.kettleRecipe((ItemLike) RespiteMDCompatItems.STRONG_ROSE_HIP_TEA_CUP.get(), 1, 2400, 0.35F, false, CUP.get()).addIngredient((ItemLike) RespiteMDCompatItems.ROSE_HIP_TEA_CUP.get()).addIngredient(Items.HONEY_BOTTLE).build(consumer);

        KettleRecipeBuilder.kettleRecipe((ItemLike) RespiteMDCompatItems.DANDELION_TEA_CUP.get()).addIngredient((ItemLike)Items.DANDELION).addIngredient(BDTags.TEA_POWDER).build(consumer);
        KettleRecipeBuilder.kettleRecipe((ItemLike) RespiteMDCompatItems.LONG_DANDELION_TEA_CUP.get(), 1, 2400, 0.35F, false, CUP.get()).addIngredient((ItemLike) RespiteMDCompatItems.DANDELION_TEA_CUP.get()).addIngredient(ForgeTags.MILK).build(consumer);

        KettleRecipeBuilder.kettleRecipe((ItemLike) RespiteMDCompatItems.PURULENT_TEA_CUP.get()).addIngredient((ItemLike)Items.SPIDER_EYE).addIngredient((ItemLike)Items.NETHER_WART).build(consumer);
        KettleRecipeBuilder.kettleRecipe((ItemLike) RespiteMDCompatItems.STRONG_PURULENT_TEA_CUP.get(), 1, 2400, 0.35F, false, CUP.get()).addIngredient((ItemLike) RespiteMDCompatItems.PURULENT_TEA_CUP.get()).addIngredient(Items.HONEY_BOTTLE).build(consumer);
        KettleRecipeBuilder.kettleRecipe((ItemLike) RespitefulMDCompatItems.MINT_GREEN_TEA_CUP.get()).addIngredient((ItemLike) RespiteCompatItems.POWDERED_GREEN_TEA_LEAVES.get()).addIngredient((ItemLike) NeapolitanCompatItems.POWDERED_MINT_LEAVES.get()).build(consumer);
    }
}
