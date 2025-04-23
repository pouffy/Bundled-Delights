package com.pouffydev.bundledelight.common.elements.item;

import com.pouffydev.bundledelight.foundation.util.CommonUtil;
import com.pouffydev.bundledelight.foundation.util.client.BDTextUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.StringUtil;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import vectorwing.farmersdelight.common.utility.TextUtils;

import javax.annotation.Nullable;
import java.util.List;

public class BundleBoozeItem extends BundleDrinkableItem {
    protected final int potency;
    protected final int duration;
    protected final Effect effect;
    protected final int effectDuration;
    protected final int effectAmplifier;
    protected final int intoxicationDuration;

    public BundleBoozeItem(int potency, int duration, Item.Properties properties, Effect effect, int effectDuration, int effectAmplifier, int intoxicationDuration, BundleConsumableItem.RemainderItem remainder) {
        super(properties);
        this.potency = potency;
        this.duration = duration;
        this.effect = effect;
        this.effectDuration = effectDuration;
        this.effectAmplifier = effectAmplifier;
        this.intoxicationDuration = intoxicationDuration;
        remainderItem = remainder;
    }
    
    public void affectConsumer(ItemStack stack, Level level, LivingEntity consumer) {
        CommonUtil.addTipsyEffect(consumer, this.duration, this.potency);
        if (this.intoxicationDuration > 0) {
            CommonUtil.addIntoxicationEffect(consumer, this.intoxicationDuration, 0);
        }
        if (this.effect != Effect.None) {
            CommonUtil.addEffect(consumer, this.effectDuration, this.effectAmplifier, effect.getEffect());
        }
    }
    
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        String potencyNumeral = this.potency > 0 ? BDTextUtils.toRomanNumeral(this.potency + 1) + " " : "";
        MutableComponent tipsyTooltip = BDTextUtils.getTranslation("bundledelight", "tooltip.tipsy", potencyNumeral, StringUtil.formatTickDuration(this.duration));
        tooltip.add(tipsyTooltip.withStyle(ChatFormatting.RED));
        if (this.intoxicationDuration > 0) {
            MutableComponent intoxTooltip = BDTextUtils.getTranslation("bundledelight", "tooltip.intoxication", StringUtil.formatTickDuration(this.intoxicationDuration));
            tooltip.add(intoxTooltip.withStyle(ChatFormatting.RED));
        }
        if (this.effect != Effect.None) {
            ResourceLocation effectName = this.effect.getEffect();
            assert effectName != null;
            MutableComponent textEffect = BDTextUtils.getFoodEffectTooltip(effectName, this.effectDuration, this.effectAmplifier);
            tooltip.add(textEffect.withStyle(ChatFormatting.BLUE));
        }
        TextUtils.addFoodEffectTooltip(stack, tooltip, 1.0F);
    }

    public enum Effect {
        None,
        Sweet_Heart,
        Raging
        ;

        @Nullable
        ResourceLocation getEffect() {
            return switch (this) {
                case Sweet_Heart -> new ResourceLocation("brewinandchewin", "sweet_heart");
                case Raging -> new ResourceLocation("brewinandchewin", "raging");
                default -> null;
            };
        }
    }
}
