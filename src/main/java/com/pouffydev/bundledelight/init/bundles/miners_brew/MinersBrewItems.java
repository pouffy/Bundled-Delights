package com.pouffydev.bundledelight.init.bundles.miners_brew;

import com.pouffydev.bundledelight.BundledDelight;
import com.pouffydev.bundledelight.foundation.bundle.BundleRegistryClass;

public class MinersBrewItems extends BundleRegistryClass {
    public MinersBrewItems() {
        super("miners_brew");
    }


    public static void register() {
        BundledDelight.LOGGER.info("Registering Miner's Brew items");
    }
}
