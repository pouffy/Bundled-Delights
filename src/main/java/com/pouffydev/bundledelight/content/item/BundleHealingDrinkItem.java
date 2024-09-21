package com.pouffydev.bundledelight.content.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class BundleHealingDrinkItem extends BundleDrinkItem {
    private final float healAmount;
    
    public BundleHealingDrinkItem(float healAmount, Item.Properties builder) {
        super(builder);
        this.healAmount = healAmount;
    }
    
    public ItemStack finishUsingItem(ItemStack stack, Level worldIn, LivingEntity entity) {
        BundleHealingItem.applyHealing(this.healAmount, worldIn, entity);
        return super.finishUsingItem(stack, worldIn, entity);
    }
}
