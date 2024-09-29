package com.pouffydev.bundledelight.init.bundles.minersdelight;

import com.pouffydev.bundledelight.foundation.bundle.Bundle;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.List;

public class MinersBundle extends Bundle {
    @Override
    public List<String> getRequiredClasses() {
        return List.of("com.sammy.minersdelight.MinersDelightMod");
    }

    @Override
    public String getName() {
        return "miners_delight";
    }

    @Override
    protected void onLoad() {
        MinersItems.register();
    }

    @Override
    public void runDatagen(DataGenerator generator, ExistingFileHelper existingFileHelper, boolean client, boolean server) {
        MinersDatagen.gatherData(generator, existingFileHelper, client, server);
    }
}
