package com.pouffydev.bundledelight.common.elements.item;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class BundleHealingItem extends Item {
    private final float healAmount;
    
    public BundleHealingItem(float healAmount, Properties builder) {
        super(builder);
        this.healAmount = healAmount;
    }
    
    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level worldIn, LivingEntity entityLiving) {
        applyHealing(this.healAmount, worldIn, entityLiving);
        return super.finishUsingItem(stack, worldIn, entityLiving);
    }
    
    public static void applyHealing(float healAmount, LevelAccessor world, LivingEntity entity) {
        entity.heal(healAmount);
        RandomSource rand = entity.getRandom();
        if (world.isClientSide()) {
            int times = 2 * Math.round(healAmount);
            for (int i = 0; i < times; ++i) {
                double d0 = rand.nextGaussian() * 0.02D;
                double d1 = rand.nextGaussian() * 0.02D;
                double d2 = rand.nextGaussian() * 0.02D;
                world.addParticle(ParticleTypes.HEART, entity.getRandomX(1.0D), entity.getRandomY() + 0.5D, entity.getRandomZ(1.0D), d0, d1, d2);
            }
        }
    }
}
