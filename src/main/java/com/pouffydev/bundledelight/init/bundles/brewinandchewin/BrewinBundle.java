package com.pouffydev.bundledelight.init.bundles.brewinandchewin;

import com.pouffydev.bundledelight.BundledDelight;
import com.pouffydev.bundledelight.foundation.bundle.Bundle;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.List;

public class BrewinBundle extends Bundle {
    public BrewinBundle() {
        super();
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
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        BrewinItems.register();
    }
    
    @Override
    public void runDatagen(DataGenerator generator, ExistingFileHelper existingFileHelper, boolean client, boolean server) {
        BundledDelight.LOGGER.info("Running BrewinAndChewin datagen");
        BrewinDatagen.gatherData(generator, existingFileHelper, client, server);
    }
}
