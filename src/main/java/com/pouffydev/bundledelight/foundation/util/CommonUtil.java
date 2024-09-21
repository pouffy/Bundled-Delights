package com.pouffydev.bundledelight.foundation.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;

public class CommonUtil {
    
    public static MobEffect getMobEffect(ResourceLocation id) {
        return ForgeRegistries.MOB_EFFECTS.getValue(id);
    }
    
    public static Item getItem(ResourceLocation id) {
        return ForgeRegistries.ITEMS.getValue(id);
    }
    
    public static Block getBlock(ResourceLocation id) {
        return ForgeRegistries.BLOCKS.getValue(id);
    }
    
    public static Item fromFR(String id) {
        ResourceLocation rl = new ResourceLocation("farmersrespite", id.toLowerCase());
        return ForgeRegistries.ITEMS.getValue(rl);
    }
    
    public static Item fromN(String id) {
        ResourceLocation rl = new ResourceLocation("neapolitan", id.toLowerCase());
        return ForgeRegistries.ITEMS.getValue(rl);
    }
    
    public static Item fromR(String id) {
        ResourceLocation rl = new ResourceLocation("respiteful", id.toLowerCase());
        return ForgeRegistries.ITEMS.getValue(rl);
    }
    
    public static Item fromBNC(String id) {
        ResourceLocation rl = new ResourceLocation("brewinandchewin", id.toLowerCase());
        return ForgeRegistries.ITEMS.getValue(rl);
    }
    
    public static Item fromMD(String id) {
        ResourceLocation rl = new ResourceLocation("miners_delight", id.toLowerCase());
        return ForgeRegistries.ITEMS.getValue(rl);
    }
    
    public static Item fromBD(String id) {
        ResourceLocation rl = new ResourceLocation("bundledelight", id.toLowerCase());
        return ForgeRegistries.ITEMS.getValue(rl);
    }
    
    public static void addTipsyEffect(LivingEntity entity, int duration, int amplifier) {
        MobEffect tipsy = getMobEffect(new ResourceLocation("brewinandchewin", "tipsy"));
        if (!entity.hasEffect(tipsy)) {
            entity.forceAddEffect(new MobEffectInstance(tipsy, duration * 1200, amplifier - 1, false, false, true), entity);
        } else if (entity.hasEffect(tipsy)) {
            MobEffectInstance effect = entity.getEffect(tipsy);
            entity.forceAddEffect(new MobEffectInstance(tipsy, effect.getDuration() + duration * 600, Math.min(effect.getAmplifier() + amplifier, 9), false, false, true), entity);
        }
        
    }
}
