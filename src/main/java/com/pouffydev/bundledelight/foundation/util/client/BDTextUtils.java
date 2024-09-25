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

    public static String toRomanNumeral(int number) {
        return "I".repeat(number)
                .replace("IIIII", "V")
                .replace("IIII", "IV")
                .replace("VV", "X")
                .replace("VIV", "IX")
                .replace("XXXXX", "L")
                .replace("XXXX", "XL")
                .replace("LL", "C")
                .replace("LXL", "XC")
                .replace("CCCCC", "D")
                .replace("CCCC", "CD")
                .replace("DD", "M")
                .replace("DCD", "CM");
    }
}
