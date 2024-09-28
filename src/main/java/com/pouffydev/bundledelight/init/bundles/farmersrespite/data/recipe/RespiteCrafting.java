package com.pouffydev.bundledelight.init.bundles.farmersrespite.data.recipe;

import com.pouffydev.bundledelight.BundledDelight;
import com.pouffydev.bundledelight.datagen.RecipeShortcuts;
import com.pouffydev.bundledelight.foundation.data.BundleRecipeGen;
import com.pouffydev.bundledelight.init.bundles.farmersrespite.RespiteBlocks;
import com.pouffydev.bundledelight.init.bundles.farmersrespite.RespiteItems;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Consumer;

public class RespiteCrafting extends BundleRecipeGen {
    private static final String BUNDLE_NAME = "farmersrespite";

    public RespiteCrafting() {
    }

    public static void register(Consumer<FinishedRecipe> consumer) {
        recipesFoodBlocks(consumer);
    }

    private static void recipesFoodBlocks(Consumer<FinishedRecipe> consumer) {
        RecipeShortcuts.compact3x3(RespiteBlocks.powderedGreenTeaLeavesSack.get(), RespiteItems.powderedGreenTeaLeaves.get(), BUNDLE_NAME).save(consumer, new ResourceLocation(BundledDelight.MODID, "storage/powdered_green_tea_leaves_sack"));
        RecipeShortcuts.compact3x3(RespiteBlocks.powderedYellowTeaLeavesSack.get(), RespiteItems.powderedYellowTeaLeaves.get(), BUNDLE_NAME).save(consumer, new ResourceLocation(BundledDelight.MODID, "storage/powdered_yellow_tea_leaves_sack"));
        RecipeShortcuts.compact3x3(RespiteBlocks.powderedBlackTeaLeavesSack.get(), RespiteItems.powderedBlackTeaLeaves.get(), BUNDLE_NAME).save(consumer, new ResourceLocation(BundledDelight.MODID, "storage/powdered_black_tea_leaves_sack"));
        RecipeShortcuts.compact3x3(RespiteBlocks.powderedCoffeeBeansSack.get(), RespiteItems.powderedCoffeeBeans.get(), BUNDLE_NAME).save(consumer, new ResourceLocation(BundledDelight.MODID, "storage/powdered_coffee_beans_sack"));

        RecipeShortcuts.decompact3x3(RespiteItems.powderedGreenTeaLeaves.get(), RespiteBlocks.powderedGreenTeaLeavesSack.get(), BUNDLE_NAME).save(consumer, new ResourceLocation(BundledDelight.MODID, "storage/powdered_green_tea_leaves_from_sack"));
        RecipeShortcuts.decompact3x3(RespiteItems.powderedYellowTeaLeaves.get(), RespiteBlocks.powderedYellowTeaLeavesSack.get(), BUNDLE_NAME).save(consumer, new ResourceLocation(BundledDelight.MODID, "storage/powdered_yellow_tea_leaves_from_sack"));
        RecipeShortcuts.decompact3x3(RespiteItems.powderedBlackTeaLeaves.get(), RespiteBlocks.powderedBlackTeaLeavesSack.get(), BUNDLE_NAME).save(consumer, new ResourceLocation(BundledDelight.MODID, "storage/powdered_black_tea_leaves_from_sack"));
        RecipeShortcuts.decompact3x3(RespiteItems.powderedCoffeeBeans.get(), RespiteBlocks.powderedCoffeeBeansSack.get(), BUNDLE_NAME).save(consumer, new ResourceLocation(BundledDelight.MODID, "storage/powdered_coffee_beans_from_sack"));
    }


    @Override
    public String getBundleName() {
        return BUNDLE_NAME;
    }


}
