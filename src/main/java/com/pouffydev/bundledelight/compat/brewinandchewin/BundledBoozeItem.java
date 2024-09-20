package com.pouffydev.bundledelight.compat.brewinandchewin;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import umpaz.brewinandchewin.common.registry.BCEffects;
import umpaz.brewinandchewin.common.utility.BCTextUtils;
import vectorwing.farmersdelight.common.item.DrinkableItem;

import javax.annotation.Nullable;
import java.util.List;

public class BundledBoozeItem extends DrinkableItem {
    protected final int potency;
    protected final int duration;

    public BundledBoozeItem(int potency, int duration, Item.Properties properties) {
        super(properties);
        this.potency = potency;
        this.duration = duration;
    }

    public void affectConsumer(ItemStack stack, Level level, LivingEntity consumer) {
        if (consumer.hasEffect((MobEffect) BCEffects.TIPSY.get())) {
            MobEffectInstance effect = consumer.getEffect((MobEffect)BCEffects.TIPSY.get());
            if (effect.getAmplifier() == 8) {
                consumer.addEffect(new MobEffectInstance((MobEffect)BCEffects.TIPSY.get(), effect.getDuration() + this.duration * 600, effect.getAmplifier() + 1), consumer);
            }

            if (effect.getAmplifier() == 7 && this.potency > 2) {
                consumer.addEffect(new MobEffectInstance((MobEffect)BCEffects.TIPSY.get(), effect.getDuration() + this.duration * 600, effect.getAmplifier() + 2), consumer);
            }

            if (effect.getAmplifier() < 9) {
                consumer.addEffect(new MobEffectInstance((MobEffect)BCEffects.TIPSY.get(), effect.getDuration() + this.duration * 600, effect.getAmplifier() + this.potency), consumer);
            }

            if (effect.getAmplifier() == 9) {
                consumer.addEffect(new MobEffectInstance((MobEffect)BCEffects.TIPSY.get(), effect.getDuration() + this.duration * 600, effect.getAmplifier()), consumer);
            }
        } else if (!consumer.hasEffect((MobEffect)BCEffects.TIPSY.get())) {
            consumer.addEffect(new MobEffectInstance((MobEffect)BCEffects.TIPSY.get(), this.duration * 1200, this.potency - 1), consumer);
        }

    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        MutableComponent textEmpty;
        if (this.potency == 1) {
            textEmpty = BCTextUtils.getTranslation("tooltip.tipsy1", new Object[]{this.duration});
            tooltip.add(textEmpty.withStyle(ChatFormatting.RED));
        }

        if (this.potency == 2) {
            textEmpty = BCTextUtils.getTranslation("tooltip.tipsy2", new Object[]{this.duration});
            tooltip.add(textEmpty.withStyle(ChatFormatting.RED));
        }

        if (this.potency == 3) {
            textEmpty = BCTextUtils.getTranslation("tooltip.tipsy3", new Object[]{this.duration});
            tooltip.add(textEmpty.withStyle(ChatFormatting.RED));
        }

        BCTextUtils.addFoodEffectTooltip(stack, tooltip, 1.0F);
        if (stack.sameItem(new ItemStack((ItemLike) BrewinMDCompatItems.DREAD_NOG_SWIG.get()))) {
            textEmpty = BCTextUtils.getTranslation("tooltip." + this, new Object[0]);
            tooltip.add(textEmpty.withStyle(ChatFormatting.RED));
        }
        if (stack.sameItem(new ItemStack((ItemLike) BrewinCompatItems.DREAD_NOG_GLASS.get()))) {
            textEmpty = BCTextUtils.getTranslation("tooltip." + this, new Object[0]);
            tooltip.add(textEmpty.withStyle(ChatFormatting.RED));
        }

    }
}
