package com.pouffydev.bundledelight;

import com.pouffydev.bundledelight.foundation.bundle.Bundle;
import com.pouffydev.bundledelight.init.bundles.brewinandchewin.BrewinBundle;
import com.pouffydev.bundledelight.init.bundles.builtin.BuiltinBundle;
import com.pouffydev.bundledelight.init.bundles.farmersrespite.RespiteBundle;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BundleManager {
    public static final List<Bundle> BUNDLES;
    
    static {
        List<Bundle> bundles = new ArrayList<>();
        
        bundles.add(new BuiltinBundle());
        bundles.add(new BrewinBundle());
        bundles.add(new RespiteBundle());
        
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
    
    public static void bundleDatagen(DataGenerator generator, ExistingFileHelper existingFileHelper, boolean client, boolean server) {
        for (Bundle bundle : BUNDLES) {
            if (bundle.isLoaded()) {
                bundle.runDatagen(generator, existingFileHelper, client, server);
            }
        }
    }
    
    public static Bundle getBundle(String name) {
        for (Bundle bundle : BUNDLES) {
            if (bundle.getName().toLowerCase().equals(name)) {
                return bundle;
            }
        }
        return null;
    }
}
