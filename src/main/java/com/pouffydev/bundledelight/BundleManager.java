package com.pouffydev.bundledelight;

import com.pouffydev.bundledelight.foundation.Bundle;
import com.pouffydev.bundledelight.init.DefaultBundle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BundleManager {
    public static final List<Bundle> BUNDLES;
    
    static {
        List<Bundle> bundles = new ArrayList<>();
        
        bundles.add(new DefaultBundle());
        
        for (Bundle bundle : bundles) {
            bundle.tryLoad();
        }
        
        BUNDLES = Collections.unmodifiableList(bundles);
    }
    
    public static void visit() {
        int loaded = BUNDLES.size() + 1;
        BundledDelights.LOGGER.info("Loaded {} bundles", loaded);
    }
}
