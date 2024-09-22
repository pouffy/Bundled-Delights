package com.pouffydev.bundledelight.init;

import com.pouffydev.bundledelight.foundation.data.BundleLoadedCondition;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class CommonSetup {
    public static void init(final FMLCommonSetupEvent event) {
        CraftingHelper.register(new BundleLoadedCondition.Serializer());
    }
}
