package com.pouffy.bundledelight.compats;

import com.google.common.collect.ImmutableMap;
import com.pouffy.bundledelight.compats.neapolitan.NeapolitanCompatItems;
import com.teamabnormals.neapolitan.core.registry.NeapolitanItems;
import com.teamabnormals.neapolitan.core.registry.NeapolitanMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

import java.util.Map;

public class CompatFoodValues {

    public static final FoodProperties ADZUKI_CURRY_CUP = (new FoodProperties.Builder()).nutrition(6).saturationMod(1.2F).effect(() -> {
        return new MobEffectInstance((MobEffect)NeapolitanMobEffects.HARMONY.get(), 300);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance((MobEffect)NeapolitanMobEffects.AGILITY.get(), 300);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance((MobEffect) MobEffects.DIG_SPEED, 1800, 1);
    }, 1.0F).build();
    public static final Map<Item, FoodProperties> NEAPOLITAN_EFFECTS = (new ImmutableMap.Builder<Item, FoodProperties>())
            .put(NeapolitanCompatItems.WHITE_STRAWBERRY_ICE_CREAM.get(), (new FoodProperties.Builder())
                    .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 2), 1.0F).build())
            .put(NeapolitanItems.CHOCOLATE_BAR.get(), (new FoodProperties.Builder())
                    .effect(() -> new MobEffectInstance(NeapolitanMobEffects.SUGAR_RUSH.get(), 400, 1), 1.0F).build())
            .put(NeapolitanItems.CHOCOLATE_SPIDER_EYE.get(), (new FoodProperties.Builder())
                    .effect(() -> new MobEffectInstance(NeapolitanMobEffects.SUGAR_RUSH.get(), 800, 1), 1.0F).build())
            .put(NeapolitanItems.CHOCOLATE_ICE_CREAM.get(), (new FoodProperties.Builder())
                    .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 2), 1.0F).effect(() -> new MobEffectInstance(NeapolitanMobEffects.SUGAR_RUSH.get(), 600, 2), 1.0F).build())
            .put(NeapolitanItems.STRAWBERRY_ICE_CREAM.get(), (new FoodProperties.Builder())
                    .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 2), 1.0F).build())
            .put(NeapolitanItems.DRIED_VANILLA_PODS.get(), (new FoodProperties.Builder())
                    .effect(() -> new MobEffectInstance(NeapolitanMobEffects.VANILLA_SCENT.get(), 200), 1.0F).build())
            .put(NeapolitanItems.VANILLA_FUDGE.get(), (new FoodProperties.Builder())
                    .effect(() -> new MobEffectInstance(NeapolitanMobEffects.VANILLA_SCENT.get(), 100), 1.0F).build())
            .put(NeapolitanItems.VANILLA_PUDDING.get(), (new FoodProperties.Builder())
                    .effect(() -> new MobEffectInstance(NeapolitanMobEffects.VANILLA_SCENT.get(), 300), 1.0F).build())
            .put(NeapolitanItems.VANILLA_ICE_CREAM.get(), (new FoodProperties.Builder())
                    .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 2), 1.0F).effect(() -> new MobEffectInstance(NeapolitanMobEffects.VANILLA_SCENT.get(), 400), 1.0F).build())
            .put(NeapolitanItems.BANANA.get(), (new FoodProperties.Builder())
                    .effect(() -> new MobEffectInstance(NeapolitanMobEffects.AGILITY.get(), 300), 1.0F).build())
            .put(NeapolitanItems.BANANA_BREAD.get(), (new FoodProperties.Builder())
                    .effect(() -> new MobEffectInstance(NeapolitanMobEffects.AGILITY.get(), 600), 1.0F).build())
            .put(NeapolitanItems.DRIED_BANANA.get(), (new FoodProperties.Builder())
                    .effect(() -> new MobEffectInstance(NeapolitanMobEffects.AGILITY.get(), 200), 1.0F).build())
            .put(NeapolitanItems.BANANA_ICE_CREAM.get(), (new FoodProperties.Builder())
                    .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 2), 1.0F).effect(() -> new MobEffectInstance(NeapolitanMobEffects.AGILITY.get(), 1200), 1.0F).build())
            .put(NeapolitanItems.MINT_LEAVES.get(), (new FoodProperties.Builder())
                    .effect(() -> new MobEffectInstance(NeapolitanMobEffects.BERSERKING.get(), 600), 1.0F).build())
            .put(NeapolitanItems.MINT_CHOPS.get(), (new FoodProperties.Builder())
                    .effect(() -> new MobEffectInstance(NeapolitanMobEffects.BERSERKING.get(), 900), 1.0F).build())
            .put(NeapolitanItems.COOKED_MINT_CHOPS.get(), (new FoodProperties.Builder())
                    .effect(() -> new MobEffectInstance(NeapolitanMobEffects.BERSERKING.get(), 1200), 1.0F).build())
            .put(NeapolitanItems.MINT_CANDIES.get(), (new FoodProperties.Builder())
                    .effect(() -> new MobEffectInstance(NeapolitanMobEffects.BERSERKING.get(), 2400), 1.0F).build())
            .put(NeapolitanItems.MINT_ICE_CREAM.get(), (new FoodProperties.Builder())
                    .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 2), 1.0F).effect(() -> new MobEffectInstance(NeapolitanMobEffects.BERSERKING.get(), 1600), 1.0F).build())
            .put(NeapolitanItems.ROASTED_ADZUKI_BEANS.get(), (new FoodProperties.Builder())
                    .effect(() -> new MobEffectInstance(NeapolitanMobEffects.HARMONY.get(), 100), 1.0F).build())
            .put(NeapolitanItems.ADZUKI_BUN.get(), (new FoodProperties.Builder())
                    .effect(() -> new MobEffectInstance(NeapolitanMobEffects.HARMONY.get(), 300), 1.0F).build())
            .put(NeapolitanItems.ADZUKI_STEW.get(), (new FoodProperties.Builder())
                    .effect(() -> new MobEffectInstance(NeapolitanMobEffects.HARMONY.get(), 400), 1.0F).build())
            .put(NeapolitanItems.ADZUKI_ICE_CREAM.get(), (new FoodProperties.Builder())
                    .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 2), 1.0F).effect(() -> new MobEffectInstance(NeapolitanMobEffects.HARMONY.get(), 600), 1.0F).build())
            .put(NeapolitanItems.CHOCOLATE_STRAWBERRIES.get(), (new FoodProperties.Builder())
                    .effect(() -> new MobEffectInstance(NeapolitanMobEffects.SUGAR_RUSH.get(), 200), 1.0F).build())
            .put(NeapolitanItems.VANILLA_CHOCOLATE_FINGERS.get(), (new FoodProperties.Builder())
                    .effect(() -> new MobEffectInstance(NeapolitanMobEffects.SUGAR_RUSH.get(), 200), 1.0F).effect(() -> new MobEffectInstance(NeapolitanMobEffects.VANILLA_SCENT.get(), 100), 1.0F).build())
            .put(NeapolitanItems.STRAWBERRY_BANANA_SMOOTHIE.get(), (new FoodProperties.Builder())
                    .effect(() -> new MobEffectInstance(NeapolitanMobEffects.AGILITY.get(), 600), 1.0F).build())
            .put(NeapolitanItems.MINT_CHOCOLATE.get(), (new FoodProperties.Builder())
                    .effect(() -> new MobEffectInstance(NeapolitanMobEffects.SUGAR_RUSH.get(), 200), 1.0F).effect(() -> new MobEffectInstance(NeapolitanMobEffects.BERSERKING.get(), 1200), 1.0F).build())
            .put(NeapolitanItems.STRAWBERRY_BEAN_BONBONS.get(), (new FoodProperties.Builder())
                    .effect(() -> new MobEffectInstance(NeapolitanMobEffects.HARMONY.get(), 100), 1.0F).build())
            .put(NeapolitanItems.ADZUKI_CURRY.get(), (new FoodProperties.Builder())
                    .effect(() -> new MobEffectInstance(NeapolitanMobEffects.HARMONY.get(), 300), 1.0F).effect(() -> new MobEffectInstance(NeapolitanMobEffects.AGILITY.get(), 300), 1.0F).build())
            .put(NeapolitanItems.NEAPOLITAN_ICE_CREAM.get(), (new FoodProperties.Builder())
                    .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 2), 1.0F).effect(() -> new MobEffectInstance(NeapolitanMobEffects.SUGAR_RUSH.get(), 400, 1), 1.0F).effect(() -> new MobEffectInstance(NeapolitanMobEffects.VANILLA_SCENT.get(), 200), 1.0F).build())
    .build();
}
