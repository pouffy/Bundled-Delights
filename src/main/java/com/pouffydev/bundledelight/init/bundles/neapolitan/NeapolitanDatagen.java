package com.pouffydev.bundledelight.init.bundles.neapolitan;

import com.pouffydev.bundledelight.BundledDelight;
import com.pouffydev.bundledelight.init.bundles.neapolitan.data.NeapolitanRecipes;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

public class NeapolitanDatagen {
    public static void gatherData(DataGenerator generator, ExistingFileHelper existingFileHelper, boolean client, boolean server) {
        BundledDelight.LOGGER.info("Running Neapolitan datagen");
        generator.addProvider(server, new NeapolitanRecipes(generator));
    }
}
