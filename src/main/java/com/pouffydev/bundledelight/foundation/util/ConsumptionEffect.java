package com.pouffydev.bundledelight.foundation.util;

import com.google.common.collect.Lists;
import com.mojang.datafixers.util.Pair;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectUtil;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ConsumptionEffect {
    private int duration;
    private int amplifier;
    private ResourceLocation effect;
    private boolean hasEffect;
    
    public ConsumptionEffect() {
    }
    
    public ConsumptionEffect withEffect(ResourceLocation effect, int duration, int amplifier) {
        this.effect = effect;
        this.duration = duration;
        this.amplifier = amplifier;
        this.hasEffect = true;
        return this;
    }
    
    public ConsumptionEffect noEffect() {
        this.hasEffect = false;
        return this;
    }
    
    public int getDuration() {
        return this.duration;
    }
    
    public int getAmplifier() {
        return this.amplifier;
    }
    
    public ResourceLocation getEffect() {
        return this.effect;
    }
    
    public boolean hasEffect() {
        return this.hasEffect;
    }
    
    public void affectConsumer(LivingEntity consumer) {
        if (this.hasEffect) {
            CommonUtil.addEffect(consumer, this.duration, this.amplifier, this.effect);
        }
    }
    
    public void createTooltip(List<Component> lores) {
        if (!this.hasEffect) {
            return;
        }
        List<Pair<Attribute, AttributeModifier>> attributeList = Lists.newArrayList();
        MobEffectInstance instance = new MobEffectInstance(CommonUtil.getMobEffect(this.effect), this.duration, this.amplifier);
        MutableComponent iformattabletextcomponent = Component.translatable(instance.getDescriptionId());
        MobEffect effect = instance.getEffect();
        Map<Attribute, AttributeModifier> attributeMap = effect.getAttributeModifiers();
        if (!attributeMap.isEmpty()) {
            for (Map.Entry<Attribute, AttributeModifier> attributeAttributeModifierEntry : attributeMap.entrySet()) {
                AttributeModifier rawModifier = attributeAttributeModifierEntry.getValue();
                AttributeModifier modifier = new AttributeModifier(rawModifier.getName(), effect.getAttributeModifierValue(instance.getAmplifier(), rawModifier), rawModifier.getOperation());
                attributeList.add(new Pair<>(attributeAttributeModifierEntry.getKey(), modifier));
            }
            
        }
        if (instance.getAmplifier() > 0) {
            iformattabletextcomponent = Component.translatable("potion.withAmplifier", new Object[]{iformattabletextcomponent, Component.translatable("potion.potency." + instance.getAmplifier())});
        }
        
        if (instance.getDuration() > 20) {
            iformattabletextcomponent = Component.translatable("potion.withDuration", new Object[]{iformattabletextcomponent, MobEffectUtil.formatDuration(instance, 1.0F)});
        }
        
        if (!attributeList.isEmpty()) {
            lores.add(CommonComponents.EMPTY);
            lores.add(Component.translatable("potion.whenDrank").withStyle(ChatFormatting.DARK_PURPLE));
            
            for (Pair<Attribute, AttributeModifier> attributeAttributeModifierPair : attributeList) {
                AttributeModifier modifier = attributeAttributeModifierPair.getSecond();
                double amount = modifier.getAmount();
                double formattedAmount;
                if (modifier.getOperation() != AttributeModifier.Operation.MULTIPLY_BASE && modifier.getOperation() != AttributeModifier.Operation.MULTIPLY_TOTAL) {
                    formattedAmount = modifier.getAmount();
                } else {
                    formattedAmount = modifier.getAmount() * 100.0;
                }
                
                if (amount > 0.0) {
                    lores.add(Component.translatable("attribute.modifier.plus." + modifier.getOperation().toValue(), new Object[]{ItemStack.ATTRIBUTE_MODIFIER_FORMAT.format(formattedAmount), Component.translatable(attributeAttributeModifierPair.getFirst().getDescriptionId())}).withStyle(ChatFormatting.BLUE));
                } else if (amount < 0.0) {
                    formattedAmount *= -1.0;
                    lores.add(Component.translatable("attribute.modifier.take." + modifier.getOperation().toValue(), new Object[]{ItemStack.ATTRIBUTE_MODIFIER_FORMAT.format(formattedAmount), Component.translatable(attributeAttributeModifierPair.getFirst().getDescriptionId())}).withStyle(ChatFormatting.RED));
                }
            }
        }
    }
}
