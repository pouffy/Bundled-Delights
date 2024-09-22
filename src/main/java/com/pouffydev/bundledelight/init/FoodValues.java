package com.pouffydev.bundledelight.init;

import com.pouffydev.bundledelight.foundation.util.CommonUtil;
import net.minecraft.resources.ResourceLocation;
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
    
    //Brewin n Chewin
    public static MobEffect satisfaction = CommonUtil.getMobEffect(new ResourceLocation("brewinandchewin", "satisfaction"));
    public static MobEffect sweetHeart = CommonUtil.getMobEffect(new ResourceLocation("brewinandchewin", "sweet_heart"));
    public static final FoodProperties MEAD = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.1F).alwaysEat().build();
    public static final FoodProperties RICE_WINE = (new FoodProperties.Builder()).alwaysEat().build();
    public static final FoodProperties EGG_GROG = (new FoodProperties.Builder()).effect(() -> {
        return new MobEffectInstance(MobEffects.ABSORPTION, 3600, 0);
    }, 1.0F).alwaysEat().build();
    public static final FoodProperties STRONGROOT_ALE = (new FoodProperties.Builder()).effect(() -> {
        return new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6000, 0);
    }, 1.0F).alwaysEat().build();
    public static final FoodProperties SACCHARINE_RUM = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.1F).alwaysEat().build();
    public static final FoodProperties PALE_JANE = (new FoodProperties.Builder()).alwaysEat().build();
    public static final FoodProperties SALTY_FOLLY = (new FoodProperties.Builder()).effect(() -> {
        return new MobEffectInstance(MobEffects.WATER_BREATHING, 9600, 0);
    }, 1.0F).alwaysEat().build();
    public static final FoodProperties STEEL_TOE_STOUT = (new FoodProperties.Builder()).effect(() -> {
        return new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 12000, 1);
    }, 1.0F).alwaysEat().build();
    public static final FoodProperties GLITTERING_GRENADINE = (new FoodProperties.Builder()).effect(() -> {
        return new MobEffectInstance(MobEffects.GLOWING, 12000, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(MobEffects.NIGHT_VISION, 12000, 0);
    }, 1.0F).alwaysEat().build();
    public static final FoodProperties BLOODY_MARY = (new FoodProperties.Builder()).effect(() -> {
        return new MobEffectInstance((MobEffect)ModEffects.COMFORT.get(), 6000, 0);
    }, 1.0F).alwaysEat().build();
    public static final FoodProperties RED_RUM = (new FoodProperties.Builder()).effect(() -> {
        return new MobEffectInstance((MobEffect)ModEffects.COMFORT.get(), 9600, 1);
    }, 1.0F).alwaysEat().build();
    public static final FoodProperties WITHERING_DROSS = (new FoodProperties.Builder()).effect(() -> {
        return new MobEffectInstance(MobEffects.BLINDNESS, 12000, 0);
    }, 0.75F).effect(() -> {
        return new MobEffectInstance(MobEffects.WEAKNESS, 12000, 0);
    }, 0.75F).effect(() -> {
        return new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 12000, 0);
    }, 0.75F).effect(() -> {
        return new MobEffectInstance(MobEffects.WITHER, 12000, 0);
    }, 1.0F).alwaysEat().build();
    public static final FoodProperties KOMBUCHA = (new FoodProperties.Builder()).effect(() -> {
        return new MobEffectInstance(satisfaction, 3600, 0);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(MobEffects.DIG_SPEED, 6000, 0);
    }, 1.0F).alwaysEat().build();
    public static final FoodProperties KIMCHI = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.6F).effect(() -> {
        return new MobEffectInstance(satisfaction, 2400, 0);
    }, 1.0F).build();
    
    //Farmers Respite
    public static MobEffect caffeinated = CommonUtil.getMobEffect(new ResourceLocation("farmersrespite", "caffeinated"));
    
    public static final FoodProperties GREEN_TEA = (new FoodProperties.Builder()).alwaysEat().effect(() -> {
        return new MobEffectInstance(MobEffects.DIG_SPEED, 3600, 0);
    }, 1.0F).build();
    public static final FoodProperties YELLOW_TEA = (new FoodProperties.Builder()).alwaysEat().effect(() -> {
        return new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 3600, 0);
    }, 1.0F).build();
    public static final FoodProperties BLACK_TEA = (new FoodProperties.Builder()).alwaysEat().effect(() -> {
        return new MobEffectInstance(caffeinated, 600, 0);
    }, 1.0F).build();
    public static final FoodProperties ROSE_HIP_TEA = (new FoodProperties.Builder()).alwaysEat().effect(() -> {
        return new MobEffectInstance(MobEffects.REGENERATION, 200, 0);
    }, 1.0F).build();
    public static final FoodProperties DANDELION_TEA = (new FoodProperties.Builder()).alwaysEat().effect(() -> {
        return new MobEffectInstance((MobEffect)ModEffects.COMFORT.get(), 3600, 0);
    }, 1.0F).build();
    public static final FoodProperties PURULENT_TEA = (new FoodProperties.Builder()).alwaysEat().effect(() -> {
        return new MobEffectInstance(MobEffects.WEAKNESS, 600, 0);
    }, 1.0F).build();
    public static final FoodProperties COFFEE = (new FoodProperties.Builder()).alwaysEat().effect(() -> {
        return new MobEffectInstance(caffeinated, 6000, 1);
    }, 1.0F).build();
    public static final FoodProperties LONG_GREEN_TEA = (new FoodProperties.Builder()).alwaysEat().effect(() -> {
        return new MobEffectInstance(MobEffects.DIG_SPEED, 5400, 0);
    }, 1.0F).build();
    public static final FoodProperties LONG_YELLOW_TEA = (new FoodProperties.Builder()).alwaysEat().effect(() -> {
        return new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 5400, 0);
    }, 1.0F).build();
    public static final FoodProperties LONG_BLACK_TEA = (new FoodProperties.Builder()).alwaysEat().effect(() -> {
        return new MobEffectInstance(caffeinated, 900, 0);
    }, 1.0F).build();
    public static final FoodProperties LONG_ROSE_HIP_TEA = (new FoodProperties.Builder()).alwaysEat().effect(() -> {
        return new MobEffectInstance(MobEffects.REGENERATION, 300, 0);
    }, 1.0F).build();
    public static final FoodProperties LONG_DANDELION_TEA = (new FoodProperties.Builder()).alwaysEat().effect(() -> {
        return new MobEffectInstance((MobEffect) ModEffects.COMFORT.get(), 5400, 0);
    }, 1.0F).build();
    public static final FoodProperties LONG_PURULENT_TEA = (new FoodProperties.Builder()).alwaysEat().effect(() -> {
        return new MobEffectInstance(MobEffects.WEAKNESS, 300, 0);
    }, 1.0F).build();
    public static final FoodProperties LONG_COFFEE = (new FoodProperties.Builder()).alwaysEat().effect(() -> {
        return new MobEffectInstance(caffeinated, 12000, 0);
    }, 1.0F).build();
    public static final FoodProperties LONG_APPLE_CIDER = (new FoodProperties.Builder()).alwaysEat().effect(() -> {
        return new MobEffectInstance(MobEffects.ABSORPTION, 1800, 0);
    }, 1.0F).build();
    public static final FoodProperties STRONG_GREEN_TEA = (new FoodProperties.Builder()).alwaysEat().effect(() -> {
        return new MobEffectInstance(MobEffects.DIG_SPEED, 1800, 1);
    }, 1.0F).build();
    public static final FoodProperties STRONG_YELLOW_TEA = (new FoodProperties.Builder()).alwaysEat().effect(() -> {
        return new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1800, 1);
    }, 1.0F).build();
    public static final FoodProperties STRONG_BLACK_TEA = (new FoodProperties.Builder()).alwaysEat().effect(() -> {
        return new MobEffectInstance(caffeinated, 300, 1);
    }, 1.0F).build();
    public static final FoodProperties STRONG_ROSE_HIP_TEA = (new FoodProperties.Builder()).alwaysEat().effect(() -> {
        return new MobEffectInstance(MobEffects.REGENERATION, 200, 1);
    }, 1.0F).build();
    public static final FoodProperties STRONG_COFFEE = (new FoodProperties.Builder()).alwaysEat().effect(() -> {
        return new MobEffectInstance(caffeinated, 3000, 2);
    }, 1.0F).build();
    
    //Respiteful
    public static MobEffect vitality = CommonUtil.getMobEffect(new ResourceLocation("respiteful", "vitality"));
    public static MobEffect tenacity = CommonUtil.getMobEffect(new ResourceLocation("respiteful", "tenacity"));
    public static MobEffect maturity = CommonUtil.getMobEffect(new ResourceLocation("respiteful", "maturity"));
    
    public static MobEffect berserking = CommonUtil.getMobEffect(new ResourceLocation("neapolitan", "berserking"));
    public static MobEffect harmony = CommonUtil.getMobEffect(new ResourceLocation("neapolitan", "harmony"));
    public static MobEffect sugarRush = CommonUtil.getMobEffect(new ResourceLocation("neapolitan", "sugar_rush"));
    public static MobEffect vanillaScent = CommonUtil.getMobEffect(new ResourceLocation("neapolitan", "vanilla_scent"));
    
    public static final FoodProperties MINT_GREEN_TEA = (new FoodProperties.Builder()).alwaysEat().effect(() -> {
        return new MobEffectInstance(vitality, 1200);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(berserking, 1200);
    }, 1.0F).build();
    public static final FoodProperties VANILLA_MILK_TEA = (new FoodProperties.Builder()).alwaysEat().effect(() -> {
        return new MobEffectInstance(tenacity, 1200);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(vanillaScent, 1200);
    }, 1.0F).build();
    public static final FoodProperties ADZUKI_MILK_TEA = (new FoodProperties.Builder()).alwaysEat().effect(() -> {
        return new MobEffectInstance(maturity, 1200);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(harmony, 1200);
    }, 1.0F).build();
    public static final FoodProperties MOCHA_COFFEE = (new FoodProperties.Builder()).alwaysEat().effect(() -> {
        return new MobEffectInstance(sugarRush, 3600);
    }, 1.0F).effect(() -> {
        return new MobEffectInstance(caffeinated, 6000);
    }, 1.0F).build();
    
    //Neapolitan
    public static final FoodProperties STRAWBERRY_MILKSHAKE = (new FoodProperties.Builder()).alwaysEat().nutrition(2).saturationMod(1.5F).build();
    public static final FoodProperties STRAWBERRY_ICE_CREAM = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.4F).build();
    public static final FoodProperties STRAWBERRY_CAKE = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).build();
    public static final FoodProperties CAKE_SLICE = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).fast().effect(() -> {
        return new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0);
    }, 1.0F).build();
}
