package com.pouffy.bundledelight.util;

import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.TranslatableComponent;

public class TextUtils {

    public TextUtils() {
    }

    public static MutableComponent getTranslation(String key, Object... args) {
        return new TranslatableComponent("bundledelight." + key, args);
    }
}
