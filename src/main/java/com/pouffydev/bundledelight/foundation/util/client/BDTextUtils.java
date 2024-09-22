package com.pouffydev.bundledelight.foundation.util.client;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

public class BDTextUtils {
    public BDTextUtils() {
    }
    
    public static MutableComponent getTranslation(String key, Object... args) {
        return Component.translatable("bundledelight." + key, args);
    }
    
    public static MutableComponent getTranslation(String modid, String key, Object... args) {
        return Component.translatable(modid + "." + key, args);
    }
}
