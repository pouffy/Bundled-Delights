package com.pouffydev.bundledelight.common.elements.item;

import com.pouffydev.bundledelight.foundation.util.client.BDTextUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import vectorwing.farmersdelight.common.item.DrinkableItem;

import javax.annotation.Nullable;
import java.util.List;

public class BundleMilkshakeItem extends DrinkableItem {
    private float healAmount = 0.0F;


    public BundleMilkshakeItem(Properties builder) {
        super(builder);
    }

    public BundleMilkshakeItem withHealAmount(float pHealAmount) {
        healAmount = pHealAmount;
        return this;
    }

    public int getUseDuration(ItemStack stack) {
        return 40;
    }

    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }

    public SoundEvent getDrinkingSound() {
        return SoundEvents.HONEY_DRINK;
    }

    public SoundEvent getEatingSound() {
        return SoundEvents.HONEY_DRINK;
    }

    public ItemStack finishUsingItem(ItemStack stack, Level worldIn, LivingEntity entity) {
        if (healAmount > 0.0F)
            BundleHealingItem.applyHealing(this.healAmount, worldIn, entity);
        return super.finishUsingItem(stack, worldIn, entity);
    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        if (this.healAmount > 0.0F) {
            tooltip.add(BDTextUtils.InstantHealth.getFromFloat(this.healAmount).getTooltip());
        }
    }
}
