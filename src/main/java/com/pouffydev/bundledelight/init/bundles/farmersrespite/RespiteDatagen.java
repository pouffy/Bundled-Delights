package com.pouffydev.bundledelight.init.bundles.farmersrespite;

import com.pouffydev.bundledelight.init.bundles.brewinandchewin.data.BrewinRecipes;
import com.pouffydev.bundledelight.init.bundles.farmersrespite.data.RespiteRecipes;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

public class RespiteDatagen {
    public static void gatherData(DataGenerator generator, ExistingFileHelper existingFileHelper, boolean client, boolean server) {
        generator.addProvider(server, new RespiteRecipes(generator));
    }
}
