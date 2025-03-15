package com.pouffydev.bundledelight.init.bundles.brewinandchewin.data.recipe;

import com.pouffydev.bundledelight.datagen.builder.recipe.KegPouringRecipeBuilder;
import com.pouffydev.bundledelight.datagen.builder.recipe.KegRecipeBuilder;
import com.pouffydev.bundledelight.foundation.data.BundleRecipeGen;
import com.pouffydev.bundledelight.foundation.data.FinishedData;
import com.pouffydev.bundledelight.init.bundles.brewinandchewin.BrewinFluids;
import com.pouffydev.bundledelight.init.bundles.brewinandchewin.BrewinItems;
import com.pouffydev.bundledelight.init.bundles.farmersrespite.RespiteItems;
import com.pouffydev.bundledelight.init.bundles.miners_brew.MinersBrewItems;
import com.sammy.minersdelight.setup.MDItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import umpaz.brewinandchewin.common.registry.BnCFluids;
import umpaz.brewinandchewin.common.registry.BnCItems;
import umpaz.farmersrespite.common.registry.FRItems;
import vectorwing.farmersdelight.common.registry.ModItems;

import java.util.function.Consumer;

import static com.pouffydev.bundledelight.foundation.util.CommonUtil.fromFR;

public class BrewinFermenting extends BundleRecipeGen {
    private static final String BUNDLE_NAME = "brewinandchewin";
    
    public static void register(Consumer<FinishedData> consumer) {
        fermentBrews(consumer);
        fermentFoods(consumer);
        pourBrews(consumer);
    }
    
    private static final Item glassTankard = BrewinItems.glassTankard.get();
    
    private static void fermentBrews(Consumer<FinishedData> consumer) {
        KegRecipeBuilder.kegRecipe(BrewinFluids.rootBeer.get(), 1000, FERMENTING_TIME, MEDIUM_FERMENT_EXP, 3, BUNDLE_NAME).addFluidIngredient(Fluids.WATER, 1000).addIngredient(Items.HANGING_ROOTS).addIngredient(Items.SUGAR).addIngredient(ModItems.TREE_BARK.get()).addIngredient(Items.HONEY_BOTTLE).build(consumer);
    }
    
    private static void fermentFoods(Consumer<FinishedData> consumer) {
    
    }

    private static void pourBrews(Consumer<FinishedData> consumer) {
        KegPouringRecipeBuilder.kegPouringRecipe(BrewinFluids.rootBeer.get(), 250, BrewinItems.rootBeer.get(), BUNDLE_NAME).withContainer(BnCItems.TANKARD.get()).build(consumer);
        KegPouringRecipeBuilder.kegPouringRecipe(BrewinFluids.rootBeer.get(), 250, BrewinItems.rootBeerGlass.get(), BUNDLE_NAME).withContainer(BrewinItems.glassTankard).build(consumer);
        KegPouringRecipeBuilder.kegPouringRecipe(BnCFluids.BEER.get(), 250, BrewinItems.beerGlass.get(), BUNDLE_NAME).withContainer(BrewinItems.glassTankard).build(consumer);
        KegPouringRecipeBuilder.kegPouringRecipe(BnCFluids.VODKA.get(), 250, BrewinItems.vodkaGlass.get(), BUNDLE_NAME).withContainer(BrewinItems.glassTankard).build(consumer);
        KegPouringRecipeBuilder.kegPouringRecipe(BnCFluids.MEAD.get(), 250, BrewinItems.meadGlass.get(), BUNDLE_NAME).withContainer(BrewinItems.glassTankard).build(consumer);
        KegPouringRecipeBuilder.kegPouringRecipe(BnCFluids.RICE_WINE.get(), 250, BrewinItems.riceWineGlass.get(), BUNDLE_NAME).withContainer(BrewinItems.glassTankard).build(consumer);
        KegPouringRecipeBuilder.kegPouringRecipe(BnCFluids.EGG_GROG.get(), 250, BrewinItems.eggGrogGlass.get(), BUNDLE_NAME).withContainer(BrewinItems.glassTankard).build(consumer);
        KegPouringRecipeBuilder.kegPouringRecipe(BnCFluids.STRONGROOT_ALE.get(), 250, BrewinItems.strongrootAleGlass.get(), BUNDLE_NAME).withContainer(BrewinItems.glassTankard).build(consumer);
        KegPouringRecipeBuilder.kegPouringRecipe(BnCFluids.SACCHARINE_RUM.get(), 250, BrewinItems.saccharineRumGlass.get(), BUNDLE_NAME).withContainer(BrewinItems.glassTankard).build(consumer);
        KegPouringRecipeBuilder.kegPouringRecipe(BnCFluids.PALE_JANE.get(), 250, BrewinItems.paleJaneGlass.get(), BUNDLE_NAME).withContainer(BrewinItems.glassTankard).build(consumer);
        KegPouringRecipeBuilder.kegPouringRecipe(BnCFluids.SALTY_FOLLY.get(), 250, BrewinItems.saltyFollyGlass.get(), BUNDLE_NAME).withContainer(BrewinItems.glassTankard).build(consumer);
        KegPouringRecipeBuilder.kegPouringRecipe(BnCFluids.STEEL_TOE_STOUT.get(), 250, BrewinItems.steelToeStoutGlass.get(), BUNDLE_NAME).withContainer(BrewinItems.glassTankard).build(consumer);
        KegPouringRecipeBuilder.kegPouringRecipe(BnCFluids.GLITTERING_GRENADINE.get(), 250, BrewinItems.glitteringGrenadineGlass.get(), BUNDLE_NAME).withContainer(BrewinItems.glassTankard).build(consumer);
        KegPouringRecipeBuilder.kegPouringRecipe(BnCFluids.BLOODY_MARY.get(), 250, BrewinItems.bloodyMaryGlass.get(), BUNDLE_NAME).withContainer(BrewinItems.glassTankard).build(consumer);
        KegPouringRecipeBuilder.kegPouringRecipe(BnCFluids.RED_RUM.get(), 250, BrewinItems.redRumGlass.get(), BUNDLE_NAME).withContainer(BrewinItems.glassTankard).build(consumer);
        KegPouringRecipeBuilder.kegPouringRecipe(BnCFluids.WITHERING_DROSS.get(), 250, BrewinItems.witheringDrossGlass.get(), BUNDLE_NAME).withContainer(BrewinItems.glassTankard).build(consumer);
        KegPouringRecipeBuilder.kegPouringRecipe(BnCFluids.DREAD_NOG.get(), 250, BrewinItems.dreadNogGlass.get(), BUNDLE_NAME).withContainer(BrewinItems.glassTankard).build(consumer);
        KegPouringRecipeBuilder.kegPouringRecipe(BnCFluids.KOMBUCHA.get(), 250, BrewinItems.kombuchaGlass.get(), BUNDLE_NAME).withContainer(BrewinItems.glassTankard).build(consumer);
    }

    @Override
    public String getBundleName() {
        return BUNDLE_NAME;
    }
}
