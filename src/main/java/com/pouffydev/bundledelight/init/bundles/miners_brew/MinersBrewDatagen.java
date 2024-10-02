package com.pouffydev.bundledelight.init.bundles.miners_brew;

import com.pouffydev.bundledelight.init.bundles.miners_respite.data.MinersRespiteRecipes;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

public class MinersBrewDatagen {
    public static void gatherData(DataGenerator generator, ExistingFileHelper existingFileHelper, boolean client, boolean server) {
        generator.addProvider(server, new MinersRespiteRecipes(generator));
    }
}
