package com.pouffydev.bundledelight.compat;

import com.google.common.collect.ImmutableMap;
import com.pouffydev.bundledelight.compat.neapolitan.NeapolitanCompatItems;
import com.pouffydev.bundledelight.foundation.util.CommonUtil;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

import java.util.Map;

import static com.pouffydev.bundledelight.foundation.util.CommonUtil.getItem;

public class CompatFoodValues {
    public static MobEffect berserking = CommonUtil.getMobEffect(new ResourceLocation("neapolitan", "berserking"));
    public static MobEffect harmony = CommonUtil.getMobEffect(new ResourceLocation("neapolitan", "harmony"));
    public static MobEffect sugarRush = CommonUtil.getMobEffect(new ResourceLocation("neapolitan", "sugar_rush"));
    public static MobEffect vanillaScent = CommonUtil.getMobEffect(new ResourceLocation("neapolitan", "vanilla_scent"));
    public static MobEffect agility = CommonUtil.getMobEffect(new ResourceLocation("neapolitan", "agility"));

    public static final FoodProperties ADZUKI_CURRY_CUP = (new FoodProperties.Builder()).nutrition(6).saturationMod(1.2F).effect(() -> {
        return new MobEffectInstance((MobEffect)harmony, 300);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance((MobEffect)agility, 300);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance((MobEffect) MobEffects.DIG_SPEED, 1800, 1);
    }, 1.0F).build();
    public static final Map<Item, FoodProperties> NEAPOLITAN_EFFECTS = (new ImmutableMap.Builder<Item, FoodProperties>())
            .put(NeapolitanCompatItems.WHITE_STRAWBERRY_ICE_CREAM.get(), (new FoodProperties.Builder())
                    .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 2), 1.0F).build())
            .put(getItem(new ResourceLocation("neapolitan", "chocolate_bar")), (new FoodProperties.Builder())
                    .effect(() -> new MobEffectInstance(sugarRush, 400, 1), 1.0F).build())
            .put(getItem(new ResourceLocation("neapolitan", "chocolate_spider_eye")), (new FoodProperties.Builder())
                    .effect(() -> new MobEffectInstance(sugarRush, 800, 1), 1.0F).build())
            .put(getItem(new ResourceLocation("neapolitan", "chocolate_ice_cream")), (new FoodProperties.Builder())
                    .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 2), 1.0F).effect(() -> new MobEffectInstance(sugarRush, 600, 2), 1.0F).build())
            .put(getItem(new ResourceLocation("neapolitan", "strawberry_ice_cream")), (new FoodProperties.Builder())
                    .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 2), 1.0F).build())
            .put(getItem(new ResourceLocation("neapolitan", "dried_vanilla_pods")), (new FoodProperties.Builder())
                    .effect(() -> new MobEffectInstance(vanillaScent, 200), 1.0F).build())
            .put(getItem(new ResourceLocation("neapolitan", "vanilla_fudge")), (new FoodProperties.Builder())
                    .effect(() -> new MobEffectInstance(vanillaScent, 100), 1.0F).build())
            .put(getItem(new ResourceLocation("neapolitan", "vanilla_pudding")), (new FoodProperties.Builder())
                    .effect(() -> new MobEffectInstance(vanillaScent, 300), 1.0F).build())
            .put(getItem(new ResourceLocation("neapolitan", "vanilla_ice_cream")), (new FoodProperties.Builder())
                    .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 2), 1.0F).effect(() -> new MobEffectInstance(vanillaScent, 400), 1.0F).build())
            .put(getItem(new ResourceLocation("neapolitan", "banana")), (new FoodProperties.Builder())
                    .effect(() -> new MobEffectInstance(agility, 300), 1.0F).build())
            .put(getItem(new ResourceLocation("neapolitan", "banana_bread")), (new FoodProperties.Builder())
                    .effect(() -> new MobEffectInstance(agility, 600), 1.0F).build())
            .put(getItem(new ResourceLocation("neapolitan", "dried_banana")), (new FoodProperties.Builder())
                    .effect(() -> new MobEffectInstance(agility, 200), 1.0F).build())
            .put(getItem(new ResourceLocation("neapolitan", "banana_ice_cream")), (new FoodProperties.Builder())
                    .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 2), 1.0F).effect(() -> new MobEffectInstance(agility, 1200), 1.0F).build())
            .put(getItem(new ResourceLocation("neapolitan", "mint_leaves")), (new FoodProperties.Builder())
                    .effect(() -> new MobEffectInstance(berserking, 600), 1.0F).build())
            .put(getItem(new ResourceLocation("neapolitan", "mint_chops")), (new FoodProperties.Builder())
                    .effect(() -> new MobEffectInstance(berserking, 900), 1.0F).build())
            .put(getItem(new ResourceLocation("neapolitan", "cooked_mint_chops")), (new FoodProperties.Builder())
                    .effect(() -> new MobEffectInstance(berserking, 1200), 1.0F).build())
            .put(getItem(new ResourceLocation("neapolitan", "mint_candies")), (new FoodProperties.Builder())
                    .effect(() -> new MobEffectInstance(berserking, 2400), 1.0F).build())
            .put(getItem(new ResourceLocation("neapolitan", "mint_ice_cream")), (new FoodProperties.Builder())
                    .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 2), 1.0F).effect(() -> new MobEffectInstance(berserking, 1600), 1.0F).build())
            .put(getItem(new ResourceLocation("neapolitan", "roasted_adzuki_beans")), (new FoodProperties.Builder())
                    .effect(() -> new MobEffectInstance(harmony, 100), 1.0F).build())
            .put(getItem(new ResourceLocation("neapolitan", "adzuki_bun")), (new FoodProperties.Builder())
                    .effect(() -> new MobEffectInstance(harmony, 300), 1.0F).build())
            .put(getItem(new ResourceLocation("neapolitan", "adzuki_stew")), (new FoodProperties.Builder())
                    .effect(() -> new MobEffectInstance(harmony, 400), 1.0F).build())
            .put(getItem(new ResourceLocation("neapolitan", "adzuki_ice_cream")), (new FoodProperties.Builder())
                    .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 2), 1.0F).effect(() -> new MobEffectInstance(harmony, 600), 1.0F).build())
            .put(getItem(new ResourceLocation("neapolitan", "chocolate_strawberries")), (new FoodProperties.Builder())
                    .effect(() -> new MobEffectInstance(sugarRush, 200), 1.0F).build())
            .put(getItem(new ResourceLocation("neapolitan", "vanilla_chocolate_fingers")), (new FoodProperties.Builder())
                    .effect(() -> new MobEffectInstance(sugarRush, 200), 1.0F).effect(() -> new MobEffectInstance(vanillaScent, 100), 1.0F).build())
            .put(getItem(new ResourceLocation("neapolitan", "strawberry_banana_smoothie")), (new FoodProperties.Builder())
                    .effect(() -> new MobEffectInstance(agility, 600), 1.0F).build())
            .put(getItem(new ResourceLocation("neapolitan", "mint_chocolate")), (new FoodProperties.Builder())
                    .effect(() -> new MobEffectInstance(sugarRush, 200), 1.0F).effect(() -> new MobEffectInstance(berserking, 1200), 1.0F).build())
            .put(getItem(new ResourceLocation("neapolitan", "strawberry_bean_bonbons")), (new FoodProperties.Builder())
                    .effect(() -> new MobEffectInstance(harmony, 100), 1.0F).build())
            .put(getItem(new ResourceLocation("neapolitan", "adzuki_curry")), (new FoodProperties.Builder())
                    .effect(() -> new MobEffectInstance(harmony, 300), 1.0F).effect(() -> new MobEffectInstance(agility, 300), 1.0F).build())
            .put(getItem(new ResourceLocation("neapolitan", "neapolitan_ice_cream")), (new FoodProperties.Builder())
                    .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 2), 1.0F).effect(() -> new MobEffectInstance(sugarRush, 400, 1), 1.0F).effect(() -> new MobEffectInstance(vanillaScent, 200), 1.0F).build())
    .build();
}
