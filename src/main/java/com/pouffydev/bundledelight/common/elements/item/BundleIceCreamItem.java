package com.pouffydev.bundledelight.common.elements.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.BowlFoodItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class BundleIceCreamItem extends BowlFoodItem {
    private float healAmount = 0.0F;

    public BundleIceCreamItem(Item.Properties builder) {
        super(builder);
    }

    public BundleIceCreamItem withHealAmount(float pHealAmount) {
        healAmount = pHealAmount;
        return this;
    }

    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        if (healAmount > 0.0F)
            BundleHealingItem.applyHealing(this.healAmount, level, entity);
        entity.setTicksFrozen(entity.getTicksFrozen() + 200);
        return super.finishUsingItem(stack, level, entity);
    }
}
