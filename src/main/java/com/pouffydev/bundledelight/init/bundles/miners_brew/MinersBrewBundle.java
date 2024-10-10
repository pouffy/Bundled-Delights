package com.pouffydev.bundledelight.init.bundles.miners_brew;

import com.pouffydev.bundledelight.BundledDelight;
import com.pouffydev.bundledelight.foundation.bundle.Bundle;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.List;

public class MinersBrewBundle extends Bundle {
    @Override
    public List<String> getRequiredClasses() {
        return List.of("umpaz.brewinandchewin.BrewinAndChewin", "com.sammy.minersdelight.MinersDelightMod");
    }

    public MinersBrewBundle() {
        super();
    }

    @Override
    public String getName() {
        return "miners_brew";
    }

    @Override
    public void tryLoad() {
        super.tryLoad();
        MinersBrewItems.register();
    }

    @Override
    protected void onLoad() {

    }

    @Override
    public void runDatagen(DataGenerator generator, ExistingFileHelper existingFileHelper, boolean client, boolean server) {
        BundledDelight.LOGGER.info("Running Miner's Brew datagen");
        MinersBrewDatagen.gatherData(generator, existingFileHelper, client, server);
    }
}
