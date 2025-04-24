package com.pouffydev.bundledelight.common.elements.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class BundleDreadNogItem extends BundleBoozeItem {
    public BundleDreadNogItem(int potency, int duration, Item.Properties properties, BundleConsumableItem.RemainderItem remainder) {
        super(potency, duration, properties, remainder);
    }

    public void affectConsumer(ItemStack stack, Level level, LivingEntity consumer) {
        if (consumer.hasEffect(MobEffects.BAD_OMEN)) {
            MobEffectInstance effect = consumer.getEffect(MobEffects.BAD_OMEN);
            consumer.addEffect(new MobEffectInstance(MobEffects.BAD_OMEN, effect.getDuration() == -1 ? -1 : Math.max(effect.getDuration(), duration), Math.min(effect.getAmplifier() + potency + 1, 4), effect.isAmbient(), effect.isVisible(), effect.showIcon()));
        }
    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);

        for(int i = 0; i < tooltip.size(); ++i) {
            Component tt = (Component)tooltip.get(i);
            if (tt.contains(MobEffects.BAD_OMEN.getDisplayName())) {
                tooltip.set(i, Component.translatable(("brewinandchewin.tooltip.dread_nog")).withStyle(ChatFormatting.RED));
            }
        }
    }
}
