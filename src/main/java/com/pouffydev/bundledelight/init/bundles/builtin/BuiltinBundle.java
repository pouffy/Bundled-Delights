package com.pouffydev.bundledelight.init.bundles.builtin;

import com.pouffydev.bundledelight.BundledDelight;
import com.pouffydev.bundledelight.foundation.bundle.Bundle;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.List;

public class BuiltinBundle extends Bundle {
    public BuiltinBundle() {
        super();
    }
    
    @Override
    public List<String> getRequiredClasses() {
        return List.of("com.pouffydev.bundledelight.BundledDelight");
    }
    
    @Override
    public String getName() {
        return "builtin";
    }
    
    @Override
    protected void onLoad() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        BuiltinItems.register();
        BuiltinBlocks.register();
    }
    
    @Override
    public void runDatagen(DataGenerator generator, ExistingFileHelper existingFileHelper, boolean client, boolean server) {
        BundledDelight.LOGGER.info("Running Builtin datagen");
        BuiltinDatagen.gatherData(generator, existingFileHelper, client, server);
    }
}
