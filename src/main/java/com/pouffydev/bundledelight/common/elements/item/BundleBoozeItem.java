package com.pouffydev.bundledelight.common.elements.item;

import com.pouffydev.bundledelight.foundation.util.CommonUtil;
import com.pouffydev.bundledelight.foundation.util.client.BDTextUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
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

    public BundleBoozeItem(int potency, int duration, Item.Properties properties, Effect effect, int effectDuration, int effectAmplifier, boolean glass) {
        super(properties);
        this.potency = potency;
        this.duration = duration;
        this.effect = effect;
        this.effectDuration = effectDuration;
        this.effectAmplifier = effectAmplifier;
        this.remainderItem = glass ? RemainderItem.glassTankard : RemainderItem.copperSwig;
    }
    
    public void affectConsumer(ItemStack stack, Level level, LivingEntity consumer) {
        CommonUtil.addTipsyEffect(consumer, this.duration, this.potency);
        if (this.effect != Effect.None) {
            CommonUtil.addEffect(consumer, this.effectDuration, this.effectAmplifier, effect.getEffect());
        }
    }
    
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        MutableComponent textTipsy = BDTextUtils.getTranslation("brewinandchewin", "tooltip.tipsy1", this.duration);
        if (this.potency == 2) {
            textTipsy = BDTextUtils.getTranslation("brewinandchewin", "tooltip.tipsy2", this.duration);
        } else if (this.potency == 3) {
            textTipsy = BDTextUtils.getTranslation("brewinandchewin", "tooltip.tipsy3", this.duration);
        }
        tooltip.add(textTipsy.withStyle(ChatFormatting.RED));
        if (this.effect != Effect.None) {
            ResourceLocation effectName = this.effect.getEffect();
            assert effectName != null;
            MutableComponent textEffect = BDTextUtils.getFoodEffectTooltip(effectName, this.effectDuration, this.effectAmplifier);
            tooltip.add(textEffect.withStyle(ChatFormatting.BLUE));
        } else {
            TextUtils.addFoodEffectTooltip(stack, tooltip, 1.0F);
        }
    }

    public enum Effect {
        None,
        Sweet_Heart,
        Satisfaction

        ;

        ResourceLocation getEffect() {
            return switch (this) {
                case Sweet_Heart -> new ResourceLocation("brewinandchewin", "sweet_heart");
                case Satisfaction -> new ResourceLocation("brewinandchewin", "satisfaction");
                default -> null;
            };
        }
    }
}
