package com.pouffydev.bundledelight.foundation.util;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

public class TextUtils {

    public TextUtils() {
    }

    public static MutableComponent getTranslation(String key, Object... args) {
        return Component.translatable("bundledelight." + key, args);
    }
}
