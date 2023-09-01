package com.pouffy.bundledelight.content.food;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.registry.ModEffects;

public class FoodValues {

    public static final FoodProperties RADIANT_BREW = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.1F).effect(() -> {
        return new MobEffectInstance((MobEffect) MobEffects.LEVITATION, 200, 0);
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
    public static final FoodProperties NETTLE_SOUP_CUP = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.9F).effect(() -> {
        return new MobEffectInstance((MobEffect) ModEffects.COMFORT.get(), 3600, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance((MobEffect) MobEffects.DIG_SPEED, 1800, 0);
    }, 1.0F).build();
    public static final FoodProperties BORSCHT_CUP = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.6F).effect(() -> {
        return new MobEffectInstance((MobEffect) ModEffects.COMFORT.get(), 3600, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance((MobEffect) MobEffects.DIG_SPEED, 1800, 0);
    }, 1.0F).build();

    public static final FoodProperties CARROT_CAKE = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.2F).build();

    public static final FoodProperties SWEET_BERRY_JUICE = (new FoodProperties.Builder()).effect(() -> {
        return new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1200, 1);
    }, 1.0F).build();
    public static final FoodProperties SYRUP_GLAZED_APPLE = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.8F).build();
    public static final FoodProperties SYRUP_GLAZED_BERRIES = (new FoodProperties.Builder()).nutrition(7).saturationMod(0.8F).build();

    public static final FoodProperties CONCRETE = (new FoodProperties.Builder()).effect(() -> {
        return new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 1200, 3);
    }, 1.0F).build();
}
