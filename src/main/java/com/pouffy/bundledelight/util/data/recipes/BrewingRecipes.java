package com.pouffy.bundledelight.util.data.recipes;

import com.farmersrespite.core.registry.FRItems;
import com.farmersrespite.data.builder.KettleRecipeBuilder;
import com.pouffy.bundledelight.compats.farmersrespite.RespiteItems;
import com.pouffy.bundledelight.compats.farmersrespite.RespiteMDItems;
import com.pouffy.bundledelight.content.tag.ModTags;
import com.pouffy.bundledelight.init.BDItems;
import com.sammy.minersdelight.setup.MDItems;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import vectorwing.farmersdelight.common.tag.ForgeTags;

import java.util.function.Consumer;

public class BrewingRecipes {
    public BrewingRecipes() {
    }

    public static void register(Consumer<FinishedRecipe> consumer) {
        cookMiscellaneous(consumer);
    }

    private static void cookMiscellaneous(Consumer<FinishedRecipe> consumer) {
        KettleRecipeBuilder.kettleRecipe((ItemLike) RespiteMDItems.GREEN_TEA_CUP.get()).addIngredient((ItemLike) RespiteItems.POWDERED_GREEN_TEA_LEAVES.get()).addIngredient((ItemLike) RespiteItems.POWDERED_GREEN_TEA_LEAVES.get()).build(consumer);
        KettleRecipeBuilder.kettleRecipe((ItemLike) RespiteMDItems.LONG_GREEN_TEA_CUP.get(), 1, 2400, 0.35F, false, MDItems.COPPER_CUP.get()).addIngredient((ItemLike) RespiteMDItems.GREEN_TEA_CUP.get()).addIngredient(ForgeTags.MILK).build(consumer);
        KettleRecipeBuilder.kettleRecipe((ItemLike) RespiteMDItems.STRONG_GREEN_TEA_CUP.get(), 1, 2400, 0.35F, false, MDItems.COPPER_CUP.get()).addIngredient((ItemLike) RespiteMDItems.GREEN_TEA_CUP.get()).addIngredient(Items.HONEY_BOTTLE).build(consumer);

        KettleRecipeBuilder.kettleRecipe((ItemLike) RespiteMDItems.YELLOW_TEA_CUP.get()).addIngredient((ItemLike) RespiteItems.POWDERED_YELLOW_TEA_LEAVES.get()).addIngredient((ItemLike) RespiteItems.POWDERED_YELLOW_TEA_LEAVES.get()).build(consumer);
        KettleRecipeBuilder.kettleRecipe((ItemLike) RespiteMDItems.LONG_YELLOW_TEA_CUP.get(), 1, 2400, 0.35F, false, MDItems.COPPER_CUP.get()).addIngredient((ItemLike) RespiteMDItems.YELLOW_TEA_CUP.get()).addIngredient(ForgeTags.MILK).build(consumer);
        KettleRecipeBuilder.kettleRecipe((ItemLike) RespiteMDItems.STRONG_YELLOW_TEA_CUP.get(), 1, 2400, 0.35F, false, MDItems.COPPER_CUP.get()).addIngredient((ItemLike) RespiteMDItems.YELLOW_TEA_CUP.get()).addIngredient(Items.HONEY_BOTTLE).build(consumer);

        KettleRecipeBuilder.kettleRecipe((ItemLike) RespiteMDItems.BLACK_TEA_CUP.get()).addIngredient((ItemLike) RespiteItems.POWDERED_BLACK_TEA_LEAVES.get()).addIngredient((ItemLike) RespiteItems.POWDERED_BLACK_TEA_LEAVES.get()).build(consumer);
        KettleRecipeBuilder.kettleRecipe((ItemLike) RespiteMDItems.LONG_BLACK_TEA_CUP.get(), 1, 2400, 0.35F, false, MDItems.COPPER_CUP.get()).addIngredient((ItemLike) RespiteMDItems.BLACK_TEA_CUP.get()).addIngredient(ForgeTags.MILK).build(consumer);
        KettleRecipeBuilder.kettleRecipe((ItemLike) RespiteMDItems.STRONG_BLACK_TEA_CUP.get(), 1, 2400, 0.35F, false, MDItems.COPPER_CUP.get()).addIngredient((ItemLike) RespiteMDItems.BLACK_TEA_CUP.get()).addIngredient(Items.HONEY_BOTTLE).build(consumer);

        KettleRecipeBuilder.kettleRecipe((ItemLike) RespiteMDItems.COFFEE_CUP.get()).addIngredient((ItemLike) RespiteItems.POWDERED_COFFEE_BEANS.get()).addIngredient((ItemLike) RespiteItems.POWDERED_COFFEE_BEANS.get()).build(consumer);
        KettleRecipeBuilder.kettleRecipe((ItemLike) RespiteMDItems.LONG_COFFEE_CUP.get(), 1, 2400, 0.35F, false, MDItems.COPPER_CUP.get()).addIngredient((ItemLike) RespiteMDItems.COFFEE_CUP.get()).addIngredient(ForgeTags.MILK).build(consumer);
        KettleRecipeBuilder.kettleRecipe((ItemLike) RespiteMDItems.STRONG_COFFEE_CUP.get(), 1, 2400, 0.35F, false, MDItems.COPPER_CUP.get()).addIngredient((ItemLike) RespiteMDItems.COFFEE_CUP.get()).addIngredient(Items.HONEY_BOTTLE).build(consumer);

        KettleRecipeBuilder.kettleRecipe((ItemLike) RespiteMDItems.ROSE_HIP_TEA_CUP.get()).addIngredient((ItemLike)FRItems.ROSE_HIPS.get()).build(consumer);
        KettleRecipeBuilder.kettleRecipe((ItemLike) RespiteMDItems.STRONG_ROSE_HIP_TEA_CUP.get(), 1, 2400, 0.35F, false, MDItems.COPPER_CUP.get()).addIngredient((ItemLike) RespiteMDItems.ROSE_HIP_TEA_CUP.get()).addIngredient(Items.HONEY_BOTTLE).build(consumer);

        KettleRecipeBuilder.kettleRecipe((ItemLike) RespiteMDItems.DANDELION_TEA_CUP.get()).addIngredient((ItemLike)Items.DANDELION).addIngredient(ModTags.TEA_POWDER).build(consumer);
        KettleRecipeBuilder.kettleRecipe((ItemLike) RespiteMDItems.LONG_DANDELION_TEA_CUP.get(), 1, 2400, 0.35F, false, MDItems.COPPER_CUP.get()).addIngredient((ItemLike) RespiteMDItems.DANDELION_TEA_CUP.get()).addIngredient(ForgeTags.MILK).build(consumer);

        KettleRecipeBuilder.kettleRecipe((ItemLike) RespiteMDItems.PURULENT_TEA_CUP.get()).addIngredient((ItemLike)Items.SPIDER_EYE).addIngredient((ItemLike)Items.NETHER_WART).build(consumer);
        KettleRecipeBuilder.kettleRecipe((ItemLike) RespiteMDItems.STRONG_PURULENT_TEA_CUP.get(), 1, 2400, 0.35F, false, MDItems.COPPER_CUP.get()).addIngredient((ItemLike) RespiteMDItems.PURULENT_TEA_CUP.get()).addIngredient(Items.HONEY_BOTTLE).build(consumer);

    }
}
