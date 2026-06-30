package com.pouffydev.bundledelight.init.bundles.brewinandchewin.data.recipe;

import com.pouffydev.bundledelight.BundledDelight;
import com.pouffydev.bundledelight.foundation.data.BundleRecipeGen;
import com.pouffydev.bundledelight.init.bundles.brewinandchewin.BrewinFluids;
import com.pouffydev.bundledelight.init.bundles.brewinandchewin.BrewinItems;
import com.pouffydev.krystal_core.foundation.data.condition.BundleLoadedCondition;
import com.pouffydev.krystal_core.foundation.dynamicpack.data.recipe.custom.farmersdelight.KegFermentingRecipe;
import com.pouffydev.krystal_core.foundation.dynamicpack.data.recipe.custom.farmersdelight.KegPouringRecipe;
import com.pouffydev.krystal_core.foundation.dynamicpack.data.recipe.output.CustomRecipeOutput;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.common.conditions.ICondition;
import umpaz.brewinandchewin.common.registry.BnCFluids;
import umpaz.brewinandchewin.common.registry.BnCItems;
import vectorwing.farmersdelight.common.registry.ModItems;

public class BrewinFermenting extends BundleRecipeGen {
    private static final String BUNDLE_NAME = "brewinandchewin";

    static ICondition condition = new BundleLoadedCondition(BundledDelight.location("brewinandchewin"));
    
    public static void register(CustomRecipeOutput output) {
        fermentBrews(output);
        fermentFoods(output);
        pourBrews(output);
    }

    private static void fermentBrews(CustomRecipeOutput output) {
        KegFermentingRecipe.kegFermentingRecipe(KegFermentingRecipe.FermentingBookCategory.DRINKS, BrewinFluids.ROOT_BEER.get(), 1000, FERMENTING_TIME, MEDIUM_FERMENT_EXP, 3)
                .addFluidIngredient(Fluids.WATER, 1000)
                .addIngredient(Items.HANGING_ROOTS).addIngredient(Items.SUGAR).addIngredient(ModItems.TREE_BARK.get()).addIngredient(Items.HONEY_BOTTLE)
                .withCondition(condition)
                .save(output, BundledDelight.location("fermenting/root_beer"));
    }
    
    private static void fermentFoods(CustomRecipeOutput output) {
    
    }

    private static void pourBrews(CustomRecipeOutput output) {
        KegPouringRecipe.kegPouringRecipe(BrewinFluids.ROOT_BEER.get(), 250, BrewinItems.rootBeer.get()).withContainer(BnCItems.TANKARD).withCondition(condition).save(output, BundledDelight.location("pouring/tankard/root_beer"));
        KegPouringRecipe.kegPouringRecipe(BrewinFluids.ROOT_BEER.get(), 250, BrewinItems.rootBeerGlass.get()).withContainer(BrewinItems.glassTankard).withCondition(condition).save(output, BundledDelight.location("pouring/glass_tankard/root_beer"));
        KegPouringRecipe.kegPouringRecipe(BnCFluids.BEER, 250, BrewinItems.beerGlass.get()).withContainer(BrewinItems.glassTankard).withCondition(condition).save(output, BundledDelight.location("pouring/glass_tankard/beer"));
        KegPouringRecipe.kegPouringRecipe(BnCFluids.VODKA, 250, BrewinItems.vodkaGlass.get()).withContainer(BrewinItems.glassTankard).withCondition(condition).save(output, BundledDelight.location("pouring/glass_tankard/vodka"));
        KegPouringRecipe.kegPouringRecipe(BnCFluids.MEAD, 250, BrewinItems.meadGlass.get()).withContainer(BrewinItems.glassTankard).withCondition(condition).save(output, BundledDelight.location("pouring/glass_tankard/mead"));
        KegPouringRecipe.kegPouringRecipe(BnCFluids.RICE_WINE, 250, BrewinItems.riceWineGlass.get()).withContainer(BrewinItems.glassTankard).withCondition(condition).save(output, BundledDelight.location("pouring/glass_tankard/rice_wine"));
        KegPouringRecipe.kegPouringRecipe(BnCFluids.EGG_GROG, 250, BrewinItems.eggGrogGlass.get()).withContainer(BrewinItems.glassTankard).withCondition(condition).save(output, BundledDelight.location("pouring/glass_tankard/egg_grog"));
        KegPouringRecipe.kegPouringRecipe(BnCFluids.STRONGROOT_ALE, 250, BrewinItems.strongrootAleGlass.get()).withContainer(BrewinItems.glassTankard).withCondition(condition).save(output, BundledDelight.location("pouring/glass_tankard/strongroot_ale"));
        KegPouringRecipe.kegPouringRecipe(BnCFluids.SACCHARINE_RUM, 250, BrewinItems.saccharineRumGlass.get()).withContainer(BrewinItems.glassTankard).withCondition(condition).save(output, BundledDelight.location("pouring/glass_tankard/saccharine_rum"));
        KegPouringRecipe.kegPouringRecipe(BnCFluids.PALE_JANE, 250, BrewinItems.paleJaneGlass.get()).withContainer(BrewinItems.glassTankard).withCondition(condition).save(output, BundledDelight.location("pouring/glass_tankard/pale_jane"));
        KegPouringRecipe.kegPouringRecipe(BnCFluids.SALTY_FOLLY, 250, BrewinItems.saltyFollyGlass.get()).withContainer(BrewinItems.glassTankard).withCondition(condition).save(output, BundledDelight.location("pouring/glass_tankard/salty_folly"));
        KegPouringRecipe.kegPouringRecipe(BnCFluids.STEEL_TOE_STOUT, 250, BrewinItems.steelToeStoutGlass.get()).withContainer(BrewinItems.glassTankard).withCondition(condition).save(output, BundledDelight.location("pouring/glass_tankard/steel_toe_stout"));
        KegPouringRecipe.kegPouringRecipe(BnCFluids.GLITTERING_GRENADINE, 250, BrewinItems.glitteringGrenadineGlass.get()).withContainer(BrewinItems.glassTankard).withCondition(condition).save(output, BundledDelight.location("pouring/glass_tankard/glittering_grenadine"));
        KegPouringRecipe.kegPouringRecipe(BnCFluids.BLOODY_MARY, 250, BrewinItems.bloodyMaryGlass.get()).withContainer(BrewinItems.glassTankard).withCondition(condition).save(output, BundledDelight.location("pouring/glass_tankard/bloody_mary"));
        KegPouringRecipe.kegPouringRecipe(BnCFluids.RED_RUM, 250, BrewinItems.redRumGlass.get()).withContainer(BrewinItems.glassTankard).withCondition(condition).save(output, BundledDelight.location("pouring/glass_tankard/red_rum"));
        KegPouringRecipe.kegPouringRecipe(BnCFluids.WITHERING_DROSS, 250, BrewinItems.witheringDrossGlass.get()).withContainer(BrewinItems.glassTankard).withCondition(condition).save(output, BundledDelight.location("pouring/glass_tankard/withering_dross"));
        KegPouringRecipe.kegPouringRecipe(BnCFluids.DREAD_NOG, 250, BrewinItems.dreadNogGlass.get()).withContainer(BrewinItems.glassTankard).withCondition(condition).save(output, BundledDelight.location("pouring/glass_tankard/dread_nog"));
        KegPouringRecipe.kegPouringRecipe(BnCFluids.KOMBUCHA, 250, BrewinItems.kombuchaGlass.get()).withContainer(BrewinItems.glassTankard).withCondition(condition).save(output, BundledDelight.location("pouring/glass_tankard/kombucha"));
    }

    @Override
    public String getBundleName() {
        return BUNDLE_NAME;
    }
}
