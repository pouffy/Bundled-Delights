package com.pouffydev.bundledelight;

import com.pouffydev.bundledelight.init.bundles.builtin.BuiltinItems;
import com.pouffydev.krystal_core.foundation.registry.CreativeTabRegistryHelper;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.registries.DeferredHolder;

public class BundleDelightCreativeTab {
    private static final CreativeTabRegistryHelper HELPER = BundledDelight.getRegistryHelper().getCreativeTabHelper();

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MAIN_TAB = HELPER.registerTabSearchBar("main", BuiltinItems.borscht, (params, out) -> {},
            builder -> builder.withTabsBefore(CreativeModeTabs.COMBAT));

    public static void staticInit() {

    }
}
