package com.pouffydev.bundledelight.init.bundles.neapolitans_brew;

import com.pouffydev.bundledelight.foundation.bundle.Bundle;
import com.pouffydev.bundledelight.init.bundles.neapolitan.NeapolitanBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.IEventBus;

import java.util.List;

public class NeapolitansBrewBundle extends Bundle {
    public NeapolitansBrewBundle() {
        super();
    }

    @Override
    public List<String> getRequiredClasses() {
        return List.of("com.teamabnormals.neapolitan.core.Neapolitan", "umpaz.brewinandchewin.BrewinAndChewin");
    }

    @Override
    public String getName() {
        return "neapolitans_brew";
    }

    @Override
    protected void onLoad() {
        IEventBus bus = this.bus;
        NeapolitansBrewItems.register();
    }

    @Override
    public void runDatagen(DataGenerator generator, ExistingFileHelper existingFileHelper, boolean client, boolean server) {
        NeapolitansBrewDatagen.gatherData(generator, existingFileHelper, client, server);
    }
}
