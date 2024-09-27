package com.pouffydev.bundledelight.init.bundles.farmersrespite;

import com.pouffydev.bundledelight.foundation.bundle.Bundle;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.List;

public class RespiteBundle extends Bundle {
    public RespiteBundle() {
        super("farmersrespite");
    }

    @Override
    public List<String> getRequiredClasses() {
        return List.of("umpaz.farmersrespite.FarmersRespite");
    }

    @Override
    public String getName() {
        return "farmersrespite";
    }

    @Override
    protected void onLoad() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        RespiteItems.register();
    }

    @Override
    public void runDatagen(DataGenerator generator, ExistingFileHelper existingFileHelper, boolean client, boolean server) {
        RespiteDatagen.gatherData(generator, existingFileHelper, client, server);
    }
}
