package com.pouffydev.bundledelight.common.elements.item;

import com.pouffydev.bundledelight.foundation.util.CommonUtil;
import com.pouffydev.bundledelight.foundation.util.client.BDTextUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import vectorwing.farmersdelight.common.item.DrinkableItem;
import vectorwing.farmersdelight.common.utility.TextUtils;

import javax.annotation.Nullable;
import java.util.List;

public class BundleTeaItem extends BundleDrinkableItem {
    protected final Effect effect;
    protected final int effectDuration;
    protected final int effectAmplifier;
    
    
    public BundleTeaItem(Properties properties, Effect effect, int effectDuration, int effectAmplifier, boolean copper) {
        super(properties);
        this.effect = effect;
        this.effectDuration = effectDuration;
        this.effectAmplifier = effectAmplifier;
        this.remainderItem = RemainderItem.copperCup;
    }

    public BundleTeaItem(Properties properties, boolean copper) {
        this(properties, Effect.None, 0, 0, copper);
    }

    public BundleTeaItem withRemainderItem(RemainderItem remainderItem) {
        this.remainderItem = remainderItem;
        return this;
    }

    public void affectConsumer(ItemStack stack, Level level, LivingEntity consumer) {
        if (this.effect != Effect.None) {
            CommonUtil.addEffect(consumer, this.effectDuration, this.effectAmplifier, effect.getEffect());
        }
    }


    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        if (this.effect != Effect.None) {
            ResourceLocation effectName = this.effect.getEffect();
            MutableComponent textEffect = BDTextUtils.getFoodEffectTooltip(effectName, this.effectDuration, this.effectAmplifier);
            tooltip.add(textEffect.withStyle(ChatFormatting.BLUE));
        } else {
            TextUtils.addFoodEffectTooltip(stack, tooltip, 1.0F);
        }
    }


    public enum Effect {
        None,
        Caffeinated
        ;

        ResourceLocation getEffect() {
            return this == None ? null : new ResourceLocation("farmersrespite", "caffeinated");
        }
    }
}
