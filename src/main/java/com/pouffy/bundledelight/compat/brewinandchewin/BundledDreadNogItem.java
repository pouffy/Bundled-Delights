package com.pouffy.bundledelight.compat.brewinandchewin;

import com.brewinandchewin.core.registry.BCEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class BundledDreadNogItem extends BundledBoozeItem {
    public BundledDreadNogItem(int potency, int duration, Item.Properties properties) {
        super(potency, duration, properties);
    }

    public void affectConsumer(ItemStack stack, Level level, LivingEntity consumer) {
        MobEffectInstance badOmenEffect = consumer.getEffect(MobEffects.BAD_OMEN);
        if (!consumer.hasEffect(MobEffects.BAD_OMEN)) {
            consumer.addEffect(new MobEffectInstance(MobEffects.BAD_OMEN, 12000, 0), consumer);
        } else if (badOmenEffect.getAmplifier() < 2) {
            consumer.addEffect(new MobEffectInstance(MobEffects.BAD_OMEN, 12000, badOmenEffect.getAmplifier() + 1), consumer);
        }

        if (consumer.hasEffect((MobEffect) BCEffects.TIPSY.get())) {
            MobEffectInstance tipsyEffect = consumer.getEffect((MobEffect)BCEffects.TIPSY.get());
            consumer.addEffect(new MobEffectInstance((MobEffect)BCEffects.TIPSY.get(), tipsyEffect.getDuration() + this.duration * 600, tipsyEffect.getAmplifier() + this.potency), consumer);
        } else if (!consumer.hasEffect((MobEffect)BCEffects.TIPSY.get())) {
            consumer.addEffect(new MobEffectInstance((MobEffect)BCEffects.TIPSY.get(), this.duration * 1200, this.potency - 1), consumer);
        }

    }
}
