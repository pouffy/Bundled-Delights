package com.pouffydev.bundledelight.init.bundles.miners_respite;

import com.pouffydev.bundledelight.foundation.bundle.Bundle;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.List;

public class MinersRespiteBundle extends Bundle {
    @Override
    public List<String> getRequiredClasses() {
        return List.of("umpaz.farmersrespite.FarmersRespite", "com.sammy.minersdelight.MinersDelightMod");
    }

    public MinersRespiteBundle() {
    }

    @Override
    public String getName() {
        return "miners_respite";
    }

    @Override
    public void tryLoad() {
        MinersRespiteItems.register();
    }

    @Override
    protected void onLoad() {

    }

    @Override
    public void runDatagen(DataGenerator generator, ExistingFileHelper existingFileHelper, boolean client, boolean server) {

    }
}
