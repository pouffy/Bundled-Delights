package com.pouffydev.bundledelight.init.bundles.builtin;

import com.pouffydev.bundledelight.init.bundles.builtin.data.BuiltinRecipes;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BuiltinDatagen {
    public static void gatherData(DataGenerator generator, ExistingFileHelper existingFileHelper, boolean client, boolean server) {
        generator.addProvider(server, new BuiltinRecipes(generator));
    }
}
