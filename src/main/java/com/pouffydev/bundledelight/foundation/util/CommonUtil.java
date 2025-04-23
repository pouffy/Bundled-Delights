package com.pouffydev.bundledelight.foundation.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.ForgeRegistries;

public class CommonUtil {
    public static MobEffect getMobEffect(ResourceLocation id) {
        MobEffect effect = ForgeRegistries.MOB_EFFECTS.getValue(id);
        if (effect == null) {
            return MobEffects.LUCK;
        }
        return effect;
    }
    
    public static Item getItem(ResourceLocation id) {
        Item item = ForgeRegistries.ITEMS.getValue(id);
        if (item == null) {
            return Items.AIR;
        }
        return item;
    }
    
    public static Block getBlock(ResourceLocation id) {
        Block block = ForgeRegistries.BLOCKS.getValue(id);
        if (block == null) {
            return Blocks.AIR;
        }
        return block;
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
            entity.forceAddEffect(new MobEffectInstance(tipsy, duration, amplifier, false, false, true), entity);
        } else if (entity.hasEffect(tipsy)) {
            MobEffectInstance effect = entity.getEffect(tipsy);
            entity.forceAddEffect(new MobEffectInstance(tipsy, effect.getDuration() == -1 ? -1 : effect.getDuration() + duration, Math.min(effect.getAmplifier() + amplifier, 9), effect.isAmbient(), effect.isVisible(), effect.showIcon()), entity);
        }
    }

    public static void addIntoxicationEffect(LivingEntity entity, int duration, int amplifier) {
        MobEffect intoxication = getMobEffect(new ResourceLocation("brewinandchewin", "intoxication"));
        entity.forceAddEffect(new MobEffectInstance(intoxication, duration, amplifier, false, false, true), entity);
        //if (!entity.hasEffect(intoxication)) {
        //    entity.forceAddEffect(new MobEffectInstance(intoxication, duration, amplifier, false, false, true), entity);
        //} else if (entity.hasEffect(intoxication)) {
        //    MobEffectInstance effect = entity.getEffect(intoxication);
        //    entity.forceAddEffect(new MobEffectInstance(intoxication, effect.getDuration() + duration / 2 , Math.min(effect.getAmplifier() + amplifier, 9), false, false, true), entity);
        //}
    }
    
    public static void addEffect(LivingEntity entity, int duration, int amplifier, ResourceLocation effect) {
        MobEffect mobEffect = getMobEffect(effect);
        entity.forceAddEffect(new MobEffectInstance(mobEffect, duration, amplifier), entity);
    }
}
