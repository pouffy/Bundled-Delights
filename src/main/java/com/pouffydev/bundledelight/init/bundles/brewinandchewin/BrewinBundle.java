package com.pouffydev.bundledelight.init.bundles.brewinandchewin;

import com.pouffydev.bundledelight.BundledDelight;
import com.pouffydev.bundledelight.init.bundles.brewinandchewin.data.recipe.BrewinCrafting;
import com.pouffydev.bundledelight.init.bundles.brewinandchewin.data.recipe.BrewinFermenting;
import com.pouffydev.krystal_core.foundation.bundle.Bundle;
import com.pouffydev.krystal_core.foundation.bundle.BundleManager;
import com.pouffydev.krystal_core.foundation.bundle.runtime.AbstractBundleRecipeHandler;
import com.pouffydev.krystal_core.foundation.dynamicpack.data.recipe.output.CustomRecipeOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import org.jetbrains.annotations.NotNull;


import java.util.List;

public class BrewinBundle extends Bundle {

    public BrewinBundle(BundleManager manager) {
        super(manager);
    }
    
    @Override
    public List<String> getRequiredClasses() {
        return List.of("umpaz.brewinandchewin.BrewinAndChewin");
    }
    
    @Override
    public String getName() {
        return "brewinandchewin";
    }
    
    @Override
    protected void onLoad() {
        BrewinItems.register();
        BrewinFluids.register();
    }

    @Override
    public void runDatagen(GatherDataEvent gatherDataEvent) {
        BundledDelight.LOGGER.info("Running Brewin datagen");
        BrewinDatagen.gatherData(gatherDataEvent.getGenerator(), gatherDataEvent.getExistingFileHelper(), gatherDataEvent.includeClient(), gatherDataEvent.includeServer());
    }

    @Override
    public void addCreative(BuildCreativeModeTabContentsEvent buildCreativeModeTabContentsEvent) {

    }

    @Override
    public AbstractBundleRecipeHandler getRecipeHandler() {
        return new AbstractBundleRecipeHandler() {

            @Override
            public void run(@NotNull RecipeOutput recipeOutput) {
                BrewinCrafting.register(recipeOutput);
            }

            @Override
            public void runCustom(@NotNull CustomRecipeOutput customRecipeOutput) {
                BrewinFermenting.register(customRecipeOutput);
            }
        };
    }
}
