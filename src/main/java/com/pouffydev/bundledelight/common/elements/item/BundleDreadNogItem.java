package com.pouffydev.bundledelight.common.elements.item;

import com.pouffydev.bundledelight.foundation.util.CommonUtil;
import com.pouffydev.bundledelight.foundation.util.ConsumptionEffect;
import com.pouffydev.bundledelight.foundation.util.client.BDTextUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.StringUtil;
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
import umpaz.brewinandchewin.common.utility.BnCTextUtils;
import vectorwing.farmersdelight.common.utility.TextUtils;

import javax.annotation.Nullable;
import java.util.List;

public class BundleDreadNogItem extends BundleBoozeItem {
    public BundleDreadNogItem(int potency, int duration, Item.Properties properties, BundleConsumableItem.RemainderItem remainder) {
        super(potency, duration, properties, Effect.None, 0, 0, 4200, remainder);
    }

    public void affectConsumer(ItemStack stack, Level level, LivingEntity consumer) {
        MobEffectInstance badOmenEffect = consumer.getEffect(MobEffects.BAD_OMEN);
        if (!consumer.hasEffect(MobEffects.BAD_OMEN)) {
            consumer.addEffect(new MobEffectInstance(MobEffects.BAD_OMEN, 12000, 0), consumer);
        } else {
            assert badOmenEffect != null;
            if (badOmenEffect.getAmplifier() < 2) {
                consumer.addEffect(new MobEffectInstance(MobEffects.BAD_OMEN, 12000, badOmenEffect.getAmplifier() + 1), consumer);
            }
        }
        CommonUtil.addTipsyEffect(consumer, this.duration, this.potency);
    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {


        String potencyNumeral = this.potency > 0 ? BDTextUtils.toRomanNumeral(this.potency + 1) + " " : "";
        MutableComponent tipsyTooltip = BDTextUtils.getTranslation("bundledelight", "tooltip.tipsy", potencyNumeral, StringUtil.formatTickDuration(this.duration));
        MutableComponent textBadOmen = BnCTextUtils.getTranslation("tooltip.dread_nog");

        tooltip.add(tipsyTooltip.withStyle(ChatFormatting.RED));
        TextUtils.addFoodEffectTooltip(stack, tooltip, 1.0F);
        tooltip.add(textBadOmen.withStyle(ChatFormatting.RED));
    }
}
