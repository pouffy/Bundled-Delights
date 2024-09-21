package com.pouffydev.bundledelight.content.item;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;

public class BundleMilkshakeItem extends BundleDrinkItem {
    public BundleMilkshakeItem(Properties builder) {
        super(builder);
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
}
