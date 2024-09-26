package com.pouffydev.bundledelight.init.bundles.farmersrespite.data.recipe;

import com.pouffydev.bundledelight.datagen.builder.recipe.CuttingBoardRecipeBuilder;
import com.pouffydev.bundledelight.foundation.data.BundleRecipeGen;
import com.pouffydev.bundledelight.init.bundles.farmersrespite.RespiteItems;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import umpaz.farmersrespite.common.registry.FRItems;
import vectorwing.farmersdelight.common.tag.ModTags;

import java.util.function.Consumer;

public class RespiteCutting extends BundleRecipeGen {
    private static final String BUNDLE_NAME = "farmersrespite";

    public RespiteCutting() {
    }

    public static void register(Consumer<FinishedRecipe> consumer) {
        cutMiscellaneous(consumer);
    }

    private static void cutMiscellaneous(Consumer<FinishedRecipe> consumer) {
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(FRItems.GREEN_TEA_LEAVES.get()), Ingredient.of(ModTags.KNIVES), RespiteItems.powderedGreenTeaLeaves.get(), 2, BUNDLE_NAME).addResultWithChance(RespiteItems.powderedGreenTeaLeaves.get(), 0.5F).build(consumer);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(FRItems.YELLOW_TEA_LEAVES.get()), Ingredient.of(ModTags.KNIVES), RespiteItems.powderedYellowTeaLeaves.get(), 2, BUNDLE_NAME).addResultWithChance(RespiteItems.powderedYellowTeaLeaves.get(), 0.5F).build(consumer);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(FRItems.BLACK_TEA_LEAVES.get()), Ingredient.of(ModTags.KNIVES), RespiteItems.powderedBlackTeaLeaves.get(), 2, BUNDLE_NAME).addResultWithChance(RespiteItems.powderedBlackTeaLeaves.get(), 0.5F).build(consumer);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(FRItems.COFFEE_BEANS.get()), Ingredient.of(ModTags.KNIVES), RespiteItems.powderedCoffeeBeans.get(), 2, BUNDLE_NAME).addResultWithChance(RespiteItems.powderedCoffeeBeans.get(), 0.5F).build(consumer);
    }

    @Override
    public String getBundleName() {
        return BUNDLE_NAME;
    }
}
