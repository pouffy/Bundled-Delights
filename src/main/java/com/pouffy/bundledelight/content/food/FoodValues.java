package com.pouffy.bundledelight.content.food;

import com.brewinandchewin.core.registry.BCEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.registry.ModEffects;

public class FoodValues {

    public static final FoodProperties RADIANT_BREW = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.1F).effect(() -> {
        return new MobEffectInstance((MobEffect) MobEffects.LEVITATION, 1600, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance((MobEffect) MobEffects.GLOWING, 6000, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 12000, 1);
    }, 1.0F).build();
    public static final FoodProperties CHEESEBURGER = (new FoodProperties.Builder()).nutrition(13).saturationMod(0.9F).build();
    public static final FoodProperties BORSCHT = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.6F).effect(() -> {
        return new MobEffectInstance((MobEffect) ModEffects.COMFORT.get(), 3600, 0);
    }, 1.0F).build();
    public static final FoodProperties NETTLE_SOUP = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.9F).effect(() -> {
        return new MobEffectInstance((MobEffect) ModEffects.COMFORT.get(), 3600, 0);
    }, 1.0F).build();

}