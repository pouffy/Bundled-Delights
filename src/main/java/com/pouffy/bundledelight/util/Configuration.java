package com.pouffy.bundledelight.util;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class Configuration {
    public static ForgeConfigSpec COMMON_CONFIG;

    public static final String CATEGORY_EXTRAS = "extras";
    public static ForgeConfigSpec.BooleanValue NEAPOLITAN_TOOLTIPS;

    static {
        ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();

        COMMON_BUILDER.comment("Modded bonus features").push(CATEGORY_EXTRAS);
        NEAPOLITAN_TOOLTIPS = COMMON_BUILDER.comment("Should foods from Neapolitan have potion effect tooltips? Default TRUE")
                .define("neapolitanEffectsTooltips", true);
        COMMON_BUILDER.pop();

        COMMON_CONFIG = COMMON_BUILDER.build();
    }
}
