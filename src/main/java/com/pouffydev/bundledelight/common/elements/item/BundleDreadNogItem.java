package com.pouffydev.bundledelight.common.elements.item;

import com.pouffydev.bundledelight.foundation.util.CommonUtil;
import com.pouffydev.bundledelight.foundation.util.ConsumptionEffect;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class BundleDreadNogItem extends BundleBoozeItem {
    public BundleDreadNogItem(int potency, int duration, Item.Properties properties) {
        super(potency, duration, new ConsumptionEffect().noEffect(), properties);
    }
    
    public void affectConsumer(ItemStack stack, Level level, LivingEntity consumer) {
        MobEffectInstance badOmenEffect = consumer.getEffect(MobEffects.BAD_OMEN);
        if (!consumer.hasEffect(MobEffects.BAD_OMEN)) {
            consumer.addEffect(new MobEffectInstance(MobEffects.BAD_OMEN, 12000, 0), consumer);
        } else if (badOmenEffect.getAmplifier() < 2) {
            consumer.addEffect(new MobEffectInstance(MobEffects.BAD_OMEN, 12000, badOmenEffect.getAmplifier() + 1), consumer);
        }
        MobEffect tipsy = CommonUtil.getMobEffect(new ResourceLocation("brewinandchewin", "tipsy"));
        if (consumer.hasEffect((MobEffect) tipsy)) {
            MobEffectInstance tipsyEffect = consumer.getEffect((MobEffect)tipsy);
            consumer.addEffect(new MobEffectInstance((MobEffect)tipsy, tipsyEffect.getDuration() + this.duration * 600, tipsyEffect.getAmplifier() + this.potency), consumer);
        } else if (!consumer.hasEffect((MobEffect)tipsy)) {
            consumer.addEffect(new MobEffectInstance((MobEffect)tipsy, this.duration * 1200, this.potency - 1), consumer);
        }
        
    }
}
