package com.pouffydev.bundledelight.init.bundles.minersparlour;

import com.pouffydev.bundledelight.foundation.bundle.Bundle;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.List;

public class MinersParlourBundle extends Bundle {
    @Override
    public List<String> getRequiredClasses() {
        return List.of("com.teamabnormals.neapolitan.core.Neapolitan", "com.sammy.minersdelight.MinersDelightMod");
    }

    @Override
    public String getName() {
        return "miners_parlour";
    }

    @Override
    protected void onLoad() {

    }

    @Override
    public void runDatagen(DataGenerator generator, ExistingFileHelper existingFileHelper, boolean client, boolean server) {

    }
}
