package com.pouffydev.bundledelight.init.bundles.minersdelight.data.recipe;

import com.pouffydev.bundledelight.BundledDelight;
import com.pouffydev.bundledelight.datagen.RecipeShortcuts;
import com.pouffydev.bundledelight.foundation.data.BundleRecipeGen;
import com.pouffydev.bundledelight.init.bundles.minersdelight.MinersItems;
import com.sammy.minersdelight.setup.MDItems;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;

import java.util.function.Consumer;

public class MinersCrafting extends BundleRecipeGen {
    private static final String BUNDLE_NAME = "miners_delight";

    public MinersCrafting() {
    }

    public static void register(Consumer<FinishedRecipe> consumer) {
        recipesFoods(consumer);
    }

    private static void recipesFoods(Consumer<FinishedRecipe> consumer) {
        RecipeShortcuts.juice(MinersItems.melonJuiceCup.get(), Items.MELON_SLICE, MDItems.COPPER_CUP.get(), BUNDLE_NAME).save(consumer, new ResourceLocation(BundledDelight.MODID, "food/melon_juice_cup"));
        RecipeShortcuts.juice(MinersItems.sweetBerryJuiceCup.get(), Items.SWEET_BERRIES, MDItems.COPPER_CUP.get(), BUNDLE_NAME).save(consumer, new ResourceLocation(BundledDelight.MODID, "food/sweet_berry_juice_cup"));
    }

    @Override
    public String getBundleName() {
        return BUNDLE_NAME;
    }
}
