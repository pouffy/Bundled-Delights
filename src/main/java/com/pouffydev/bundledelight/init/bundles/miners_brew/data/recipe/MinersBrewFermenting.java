package com.pouffydev.bundledelight.init.bundles.miners_brew.data.recipe;

import com.pouffydev.bundledelight.datagen.builder.recipe.KegPouringRecipeBuilder;
import com.pouffydev.bundledelight.datagen.builder.recipe.KegRecipeBuilder;
import com.pouffydev.bundledelight.foundation.data.BundleRecipeGen;
import com.pouffydev.bundledelight.foundation.data.FinishedData;
import com.pouffydev.bundledelight.init.bundles.brewinandchewin.BrewinFluids;
import com.pouffydev.bundledelight.init.bundles.brewinandchewin.BrewinItems;
import com.pouffydev.bundledelight.init.bundles.farmersrespite.RespiteItems;
import com.pouffydev.bundledelight.init.bundles.miners_brew.MinersBrewItems;
import com.pouffydev.bundledelight.init.bundles.miners_respite.MinersRespiteItems;
import com.sammy.minersdelight.setup.MDItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import umpaz.brewinandchewin.common.registry.BnCFluids;
import umpaz.brewinandchewin.common.registry.BnCItems;
import vectorwing.farmersdelight.common.registry.ModItems;

import java.util.function.Consumer;

public class MinersBrewFermenting extends BundleRecipeGen {
    private static final String BUNDLE_NAME = "miners_brew";

    public static void register(Consumer<FinishedData> consumer) {
        fermentBrews(consumer);
        fermentFoods(consumer);
        pourBrews(consumer);
    }

    private static final Item copperSwig = MinersBrewItems.copperSwig.get();

    private static void fermentBrews(Consumer<FinishedData> consumer) {

    }

    private static void fermentFoods(Consumer<FinishedData> consumer) {

    }

    private static void pourBrews(Consumer<FinishedData> consumer) {
        KegPouringRecipeBuilder.kegPouringRecipe(BrewinFluids.rootBeer.get(), 250, MinersBrewItems.rootBeerSwig.get(), BUNDLE_NAME).withContainer(MinersBrewItems.copperSwig).build(consumer);
        KegPouringRecipeBuilder.kegPouringRecipe(BnCFluids.BEER.get(), 250, MinersBrewItems.beerSwig.get(), BUNDLE_NAME).withContainer(MinersBrewItems.copperSwig).build(consumer);
        KegPouringRecipeBuilder.kegPouringRecipe(BnCFluids.VODKA.get(), 250, MinersBrewItems.vodkaSwig.get(), BUNDLE_NAME).withContainer(MinersBrewItems.copperSwig).build(consumer);
        KegPouringRecipeBuilder.kegPouringRecipe(BnCFluids.MEAD.get(), 250, MinersBrewItems.meadSwig.get(), BUNDLE_NAME).withContainer(MinersBrewItems.copperSwig).build(consumer);
        KegPouringRecipeBuilder.kegPouringRecipe(BnCFluids.RICE_WINE.get(), 250, MinersBrewItems.riceWineSwig.get(), BUNDLE_NAME).withContainer(MinersBrewItems.copperSwig).build(consumer);
        KegPouringRecipeBuilder.kegPouringRecipe(BnCFluids.EGG_GROG.get(), 250, MinersBrewItems.eggGrogSwig.get(), BUNDLE_NAME).withContainer(MinersBrewItems.copperSwig).build(consumer);
        KegPouringRecipeBuilder.kegPouringRecipe(BnCFluids.STRONGROOT_ALE.get(), 250, MinersBrewItems.strongrootAleSwig.get(), BUNDLE_NAME).withContainer(MinersBrewItems.copperSwig).build(consumer);
        KegPouringRecipeBuilder.kegPouringRecipe(BnCFluids.SACCHARINE_RUM.get(), 250, MinersBrewItems.saccharineRumSwig.get(), BUNDLE_NAME).withContainer(MinersBrewItems.copperSwig).build(consumer);
        KegPouringRecipeBuilder.kegPouringRecipe(BnCFluids.PALE_JANE.get(), 250, MinersBrewItems.paleJaneSwig.get(), BUNDLE_NAME).withContainer(MinersBrewItems.copperSwig).build(consumer);
        KegPouringRecipeBuilder.kegPouringRecipe(BnCFluids.SALTY_FOLLY.get(), 250, MinersBrewItems.saltyFollySwig.get(), BUNDLE_NAME).withContainer(MinersBrewItems.copperSwig).build(consumer);
        KegPouringRecipeBuilder.kegPouringRecipe(BnCFluids.STEEL_TOE_STOUT.get(), 250, MinersBrewItems.steelToeStoutSwig.get(), BUNDLE_NAME).withContainer(MinersBrewItems.copperSwig).build(consumer);
        KegPouringRecipeBuilder.kegPouringRecipe(BnCFluids.GLITTERING_GRENADINE.get(), 250, MinersBrewItems.glitteringGrenadineSwig.get(), BUNDLE_NAME).withContainer(MinersBrewItems.copperSwig).build(consumer);
        KegPouringRecipeBuilder.kegPouringRecipe(BnCFluids.BLOODY_MARY.get(), 250, MinersBrewItems.bloodyMarySwig.get(), BUNDLE_NAME).withContainer(MinersBrewItems.copperSwig).build(consumer);
        KegPouringRecipeBuilder.kegPouringRecipe(BnCFluids.RED_RUM.get(), 250, MinersBrewItems.redRumSwig.get(), BUNDLE_NAME).withContainer(MinersBrewItems.copperSwig).build(consumer);
        KegPouringRecipeBuilder.kegPouringRecipe(BnCFluids.WITHERING_DROSS.get(), 250, MinersBrewItems.witheringDrossSwig.get(), BUNDLE_NAME).withContainer(MinersBrewItems.copperSwig).build(consumer);
        KegPouringRecipeBuilder.kegPouringRecipe(BnCFluids.DREAD_NOG.get(), 250, MinersBrewItems.dreadNogSwig.get(), BUNDLE_NAME).withContainer(MinersBrewItems.copperSwig).build(consumer);
        KegPouringRecipeBuilder.kegPouringRecipe(BnCFluids.KOMBUCHA.get(), 250, MinersBrewItems.kombuchaSwig.get(), BUNDLE_NAME).withContainer(MinersBrewItems.copperSwig).build(consumer);
    }

    @Override
    public String getBundleName() {
        return BUNDLE_NAME;
    }
}
