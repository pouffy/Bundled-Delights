package com.pouffydev.bundledelight.init.bundles.neapolitan.data.recipe;

import com.pouffydev.bundledelight.datagen.builder.recipe.KegRecipeBuilder;
import com.pouffydev.bundledelight.foundation.data.BundleRecipeGen;
import com.pouffydev.bundledelight.foundation.data.FinishedData;
import com.teamabnormals.neapolitan.core.registry.NeapolitanItems;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.ForgeMod;
import umpaz.brewinandchewin.data.recipe.KegFermentingRecipes;

import java.util.function.Consumer;

public class NeapolitanFermenting extends BundleRecipeGen {
    private static final String BUNDLE_NAME = "neapolitan";

    public static void register(Consumer<FinishedData> consumer) {
        fermentFoods(consumer);
    }

    private static void fermentFoods(Consumer<FinishedData> consumer) {
        KegRecipeBuilder.kegRecipe(NeapolitanItems.VANILLA_FUDGE.get(), 2, FERMENTING_TIME, MEDIUM_FERMENT_EXP, 5, BUNDLE_NAME).addFluidIngredient(ForgeMod.MILK.get(), 500).addIngredient(Items.SUGAR).addIngredient(NeapolitanItems.DRIED_VANILLA_PODS.get()).addIngredient(NeapolitanItems.DRIED_VANILLA_PODS.get()).build(consumer);
    }

    @Override
    public String getBundleName() {
        return BUNDLE_NAME;
    }
}
