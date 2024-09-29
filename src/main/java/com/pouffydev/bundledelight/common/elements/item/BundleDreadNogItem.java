package com.pouffydev.bundledelight.common.elements.item;

import com.pouffydev.bundledelight.foundation.util.CommonUtil;
import com.pouffydev.bundledelight.foundation.util.ConsumptionEffect;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import umpaz.brewinandchewin.common.item.DreadNogItem;
import umpaz.brewinandchewin.common.utility.BCTextUtils;

import javax.annotation.Nullable;
import java.util.List;

public class BundleDreadNogItem extends BundleBoozeItem {
    public BundleDreadNogItem(int potency, int duration, Item.Properties properties, boolean glass) {
        super(potency, duration, properties, Effect.None, 0, 0, glass);
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

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        MutableComponent textTipsy = BCTextUtils.getTranslation("tooltip.tipsy1", this.duration);
        MutableComponent textBadOmen = BCTextUtils.getTranslation("tooltip.dread_nog");
        if (this.potency == 2) {
            textTipsy = BCTextUtils.getTranslation("tooltip.tipsy2", this.duration);
        } else if (this.potency == 3) {
            textTipsy = BCTextUtils.getTranslation("tooltip.tipsy3", this.duration);
        }

        tooltip.add(textTipsy.withStyle(ChatFormatting.RED));
        tooltip.add(textBadOmen.withStyle(ChatFormatting.RED));
    }
}
