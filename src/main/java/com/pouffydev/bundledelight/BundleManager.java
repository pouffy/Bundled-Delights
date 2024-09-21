package com.pouffydev.bundledelight;

import com.pouffydev.bundledelight.foundation.bundle.Bundle;
import com.pouffydev.bundledelight.init.bundles.builtin.BuiltinBundle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BundleManager {
    public static final List<Bundle> BUNDLES;
    
    static {
        List<Bundle> bundles = new ArrayList<>();
        
        bundles.add(new BuiltinBundle());
        
        for (Bundle bundle : bundles) {
            bundle.tryLoad();
        }
        
        BUNDLES = Collections.unmodifiableList(bundles);
    }
    
    public static void visit() {
        for (Bundle bundle : BUNDLES) {
            if (bundle.getName() == null) {
                BundledDelight.LOGGER.error("Bundle {} has no name set", bundle.getClass().getName());
            }
            if (bundle.isLoaded()) {
                BundledDelight.LOGGER.info("Load Complete for {}", bundle.getName());
            } else {
                BundledDelight.LOGGER.error("Failed to load {}. This is likely due to its required mod(s) not being present.", bundle.getName());
            }
        }
    }
    
    public static void bundleDatagen() {
        for (Bundle bundle : BUNDLES) {
            if (bundle.isLoaded()) {
                bundle.runDatagen();
            }
        }
    }
}
