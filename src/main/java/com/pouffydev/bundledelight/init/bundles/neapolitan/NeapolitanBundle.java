package com.pouffydev.bundledelight.init.bundles.neapolitan;

import com.pouffydev.bundledelight.foundation.bundle.Bundle;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.List;

public class NeapolitanBundle extends Bundle {
    public NeapolitanBundle() {
        super();
    }

    @Override
    public List<String> getRequiredClasses() {
        return List.of("com.teamabnormals.neapolitan.core.Neapolitan");
    }

    @Override
    public String getName() {
        return "neapolitan";
    }

    @Override
    protected void onLoad() {
        IEventBus bus = this.bus;
        NeapolitanBlocks.register();
        NeapolitanItems.register();
    }

    @Override
    public void runDatagen(DataGenerator generator, ExistingFileHelper existingFileHelper, boolean client, boolean server) {
        NeapolitanDatagen.gatherData(generator, existingFileHelper, client, server);
    }
}
