package com.pouffydev.bundledelight.common.elements.item;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import vectorwing.farmersdelight.common.item.DrinkableItem;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class BundleHealingDrinkItem extends DrinkableItem {
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
