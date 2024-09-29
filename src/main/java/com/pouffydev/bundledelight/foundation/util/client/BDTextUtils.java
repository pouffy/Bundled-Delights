package com.pouffydev.bundledelight.foundation.util.client;

import com.pouffydev.bundledelight.BundledDelight;
import com.pouffydev.bundledelight.foundation.lang.Components;
import net.minecraft.ChatFormatting;
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

    public static MutableComponent getFoodEffectTooltipOld(ResourceLocation effectName, int duration, int amplifier) {
        String romanNumeral = amplifier > 0 ? BDTextUtils.toRomanNumeral(amplifier + 1) + " " : "";
        MutableComponent formattedName = getTranslation("effect." + effectName.getNamespace() + "." + effectName.getPath());
        MutableComponent formattedAmpAndDuration = Components.literal(romanNumeral + "(" + StringUtil.formatTickDuration(duration) + ")");
        BundledDelight.LOGGER.info("Fetching translation for key: {}, effectName: {}, duration: {}, amplifier: {}", "bundledelight.tooltip.mobeffect", formattedName.getString(), duration, amplifier);
        return BDTextUtils.getTranslation("bundledelight", "tooltip.mobeffect", formattedName.getString(), romanNumeral, StringUtil.formatTickDuration(duration));
    }

    public static MutableComponent getFoodEffectTooltip(String effectName, int duration, int amplifier) {
        String romanNumeral = amplifier > 0 ? BDTextUtils.toRomanNumeral(amplifier + 1) + " " : "";
        String translationKey = "bundledelight.tooltip.mobeffect";
        return Component.translatable(translationKey, effectName, romanNumeral, StringUtil.formatTickDuration(duration));
    }

    public static MutableComponent getFoodEffectTooltip(ResourceLocation effectName, int duration, int amplifier) {
        String romanNumeral = amplifier > 0 ? BDTextUtils.toRomanNumeral(amplifier + 1) + " " : "";
        String translationKey = "effect." + effectName.getNamespace() + "." + effectName.getPath();
        MutableComponent formattedName = Component.translatable(translationKey);
        MutableComponent formattedAmpAndDuration = Components.literal(romanNumeral + "(" + StringUtil.formatTickDuration(duration) + ")");
        BundledDelight.LOGGER.info("Fetching translation for key: {}, effectName: {}, duration: {}, amplifier: {}", "bundledelight.tooltip.mobeffect", formattedName.getString(), duration, amplifier);
        return BDTextUtils.getTranslation("bundledelight", "tooltip.mobeffect", formattedName.getString(), romanNumeral, StringUtil.formatTickDuration(duration));
    }

    public enum InstantHealth {
        Tiny,
        Minor,
        Medium,
        Large,
        Major
        ;

        public static InstantHealth getFromFloat(float healAmount) {
            if (healAmount <= 1.0F) {
                return Tiny;
            } else if (healAmount <= 2.0F) {
                return Minor;
            } else if (healAmount <= 4.0F) {
                return Medium;
            } else if (healAmount <= 8.0F) {
                return Large;
            } else {
                return Major;
            }
        }

        public MutableComponent getTooltip() {
            return BDTextUtils.getTranslation("bundledelight", "tooltip.instant_health." + this.name().toLowerCase()).withStyle(ChatFormatting.BLUE);
        }
    }
}
