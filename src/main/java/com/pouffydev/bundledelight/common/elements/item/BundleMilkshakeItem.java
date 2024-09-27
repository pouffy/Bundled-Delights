package com.pouffydev.bundledelight.common.elements.item;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import vectorwing.farmersdelight.common.item.DrinkableItem;

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
}
