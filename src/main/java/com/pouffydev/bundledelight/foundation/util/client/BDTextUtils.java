package com.pouffydev.bundledelight.foundation.util.client;

import com.pouffydev.bundledelight.foundation.lang.Components;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.StringUtil;
import net.minecraftforge.registries.ForgeRegistries;

public class BDTextUtils {
    public BDTextUtils() {
    }
    
    public static MutableComponent getTranslation(String key, Object... args) {
        return Component.translatable("bundledelight." + key, args);
    }
    
    public static MutableComponent getTranslation(String modid, String key, Object... args) {
        return Component.translatable(modid + "." + key, args);
    }

    public static MutableComponent getTypeTranslation(String resourceType, String modid, String key, Object... args) {
        return Component.translatable(resourceType + "." + modid + "." + key, args);
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

    public static MutableComponent getFoodEffectTooltip(ResourceLocation effectName, int duration, int amplifier) {
        String romanNumeral = amplifier > 0 ? BDTextUtils.toRomanNumeral(amplifier + 1) + " " : "";
        MutableComponent formattedName = getTypeTranslation("effect", effectName.getNamespace(), effectName.getPath());
        MutableComponent formattedAmpAndDuration = Components.literal(romanNumeral + "(" + StringUtil.formatTickDuration(duration) + ")");
        return BDTextUtils.getTranslation("bundledelight", "tooltip.mobeffect", formattedName.getString(), romanNumeral, StringUtil.formatTickDuration(duration));
    }
}
