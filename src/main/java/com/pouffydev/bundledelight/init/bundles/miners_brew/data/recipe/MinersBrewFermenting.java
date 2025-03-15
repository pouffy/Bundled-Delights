package com.pouffydev.bundledelight.init.bundles.miners_brew.data.recipe;

import com.pouffydev.bundledelight.datagen.builder.recipe.KegRecipeBuilder;
import com.pouffydev.bundledelight.foundation.data.BundleRecipeGen;
import com.pouffydev.bundledelight.foundation.data.FinishedData;
import com.pouffydev.bundledelight.init.bundles.farmersrespite.RespiteItems;
import com.pouffydev.bundledelight.init.bundles.miners_brew.MinersBrewItems;
import com.pouffydev.bundledelight.init.bundles.miners_respite.MinersRespiteItems;
import com.sammy.minersdelight.setup.MDItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import vectorwing.farmersdelight.common.registry.ModItems;

import java.util.function.Consumer;

public class MinersBrewFermenting extends BundleRecipeGen {
    private static final String BUNDLE_NAME = "miners_brew";

    public static void register(Consumer<FinishedData> consumer) {
        fermentBrews(consumer);
        fermentFoods(consumer);
    }

    private static final Item copperSwig = MinersBrewItems.copperSwig.get();

    private static void fermentBrews(Consumer<FinishedData> consumer) {

    }

    private static void fermentFoods(Consumer<FinishedData> consumer) {

    }

    @Override
    public String getBundleName() {
        return BUNDLE_NAME;
    }
}
