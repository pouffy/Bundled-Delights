package com.pouffydev.bundledelight.init.bundles.brewinandchewin;

import com.pouffydev.bundledelight.init.bundles.brewinandchewin.data.BrewinRecipes;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BrewinDatagen {
    public static void gatherData(DataGenerator generator, ExistingFileHelper existingFileHelper, boolean client, boolean server) {
        generator.addProvider(server, new BrewinRecipes(generator));
    }
}
