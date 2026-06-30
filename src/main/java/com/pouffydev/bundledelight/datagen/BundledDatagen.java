package com.pouffydev.bundledelight.datagen;

import com.pouffydev.bundledelight.BundledDelight;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.data.event.GatherDataEvent;

public class BundledDatagen {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        BundleDelightTagsProvider.addGenerators(event);
        BundledDelight.INSTANCE.bundleManager.bundleDatagen(event);
    }
}
