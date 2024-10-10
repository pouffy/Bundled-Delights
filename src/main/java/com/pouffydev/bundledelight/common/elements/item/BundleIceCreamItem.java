package com.pouffydev.bundledelight.common.elements.item;

import com.pouffydev.bundledelight.foundation.lang.Components;
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
import vectorwing.farmersdelight.common.item.ConsumableItem;

import javax.annotation.Nullable;
import java.util.List;

public class BundleIceCreamItem extends BundleConsumableItem {
    private float healAmount = 0.0F;
    private Effect effect = Effect.None;
    private int duration = 0;
    private int amplifier = 0;

    public BundleIceCreamItem(Item.Properties builder, RemainderItem remainder) {
        super(builder);
        remainderItem = remainder;
    }

    public BundleIceCreamItem withHealAmount(float pHealAmount) {
        healAmount = pHealAmount;
        return this;
    }

    public BundleIceCreamItem withEffect(Effect pEffect, int duration, int amplifier) {
        this.effect = pEffect;
        this.duration = duration;
        this.amplifier = amplifier;
        return this;
    }

    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        if (healAmount > 0.0F)
            BundleHealingItem.applyHealing(this.healAmount, level, entity);
        if (this.effect != Effect.None)
            CommonUtil.addEffect(entity, this.duration, this.amplifier, effect.getEffect());
        entity.setTicksFrozen(entity.getTicksFrozen() + 200);
        return super.finishUsingItem(stack, level, entity);
    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        if (this.effect != Effect.None) {
            tooltip.add(this.effect.getTooltip(this.duration, this.amplifier));
        }
        if (this.healAmount > 0.0F) {
            tooltip.add(BDTextUtils.InstantHealth.getFromFloat(this.healAmount).getTooltip());
        }
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }

    public static final ResourceLocation sugarRush = new ResourceLocation("neapolitan", "sugar_rush");
    public static final ResourceLocation vanillaScent = new ResourceLocation("neapolitan", "vanilla_scent");
    public static final ResourceLocation agility = new ResourceLocation("neapolitan", "agility");
    public static final ResourceLocation berserking = new ResourceLocation("neapolitan", "berserking");
    public static final ResourceLocation harmony = new ResourceLocation("neapolitan", "harmony");

    public enum Effect {
        None,
        Sugar_Rush,
        Vanilla_Scent,
        Agility,
        Berserking,
        Harmony
        ;

        @Nullable
        ResourceLocation getEffect() {
            return switch (this) {
                case Sugar_Rush -> sugarRush;
                case Vanilla_Scent -> vanillaScent;
                case Agility -> agility;
                case Berserking -> berserking;
                case Harmony -> harmony;
                default -> null;
            };
        }

        public MutableComponent getTooltip(int duration, int amplifier) {
            if (getEffect() == null) {
                return Components.empty();
            }
            String romanNumeral = amplifier > 0 ? BDTextUtils.toRomanNumeral(amplifier + 1) + " " : "";
            MutableComponent result = BDTextUtils.getTranslation("bundledelight", "tooltip." + getEffect().getPath(), romanNumeral, StringUtil.formatTickDuration(duration));
            result = result.withStyle(ChatFormatting.BLUE);
            return result;
        }
    }
}
