package com.pouffydev.bundledelight.common.elements.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class BundleCakeSliceItem extends Item {
    private float healAmount = 0.0F;

    public BundleCakeSliceItem(Properties pProperties) {
        super(pProperties);
    }

    public BundleCakeSliceItem withHealAmount(float pHealAmount) {
        healAmount = pHealAmount;
        return this;
    }

    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        if (healAmount > 0.0F)
            BundleHealingItem.applyHealing(this.healAmount, level, entity);
        return super.finishUsingItem(stack, level, entity);
    }
}
