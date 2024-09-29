package com.pouffydev.bundledelight;

import com.pouffydev.bundledelight.foundation.bundle.Bundle;
import com.pouffydev.bundledelight.init.bundles.brewinandchewin.BrewinBundle;
import com.pouffydev.bundledelight.init.bundles.builtin.BuiltinBundle;
import com.pouffydev.bundledelight.init.bundles.farmersrespite.RespiteBundle;
import com.pouffydev.bundledelight.init.bundles.miners_respite.MinersRespiteBundle;
import com.pouffydev.bundledelight.init.bundles.minersdelight.MinersBundle;
import com.pouffydev.bundledelight.init.bundles.neapolitan.NeapolitanBundle;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BundleManager {
    public static final List<Bundle> BUNDLES;
    
    static {
        List<Bundle> bundles = new ArrayList<>();

        // Single mod bundles

        bundles.add(new BuiltinBundle());
        bundles.add(new BrewinBundle());
        bundles.add(new RespiteBundle());
        bundles.add(new NeapolitanBundle());
        bundles.add(new MinersBundle());
        //TODO bundles.add(new AbnormalDelightBundle());
        //TODO bundles.add(new CreateBundle());


        // Multi mod bundles

        //TODO bundles.add(new MinersBrewBundle());
        bundles.add(new MinersRespiteBundle());
        //TODO bundles.add(new ThermalKitchenBundle());
        
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

    public static List<String> getBundleNames() {
        List<String> names = new ArrayList<>();
        for (Bundle bundle : BUNDLES) {
            names.add(bundle.getName());
        }
        return names;
    }

    public static boolean isBundleLoaded(String name) {
        if (name.startsWith("{}") || name.endsWith("{}")) {
            String resultingName = name.replace("{}", "");
            for (String bundleName : getBundleNames()) {
                if (bundleName.endsWith(resultingName) || bundleName.startsWith(resultingName)) {
                    return getBundle(bundleName) != null && getBundle(bundleName).isLoaded();
                }
            }
        }
        return getBundle(name) != null && getBundle(name).isLoaded();
    }
}
