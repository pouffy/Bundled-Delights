package com.pouffy.bundledelight.compats.abnormals_delight;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Random;

public class CompatCakeSliceItem extends Item {
    private final ResourceLocation effectName;
    private final int duration;

    public CompatCakeSliceItem(ResourceLocation effectName, int duration, Item.Properties properties) {
        super(properties);
        this.effectName = effectName;
        this.duration = duration;
    }

    public CompatCakeSliceItem(Item.Properties properties) {
        this((ResourceLocation)null, 0, properties);
    }

    public ItemStack finishUsingItem(ItemStack stack, Level worldIn, LivingEntity entityLiving) {
        if (!worldIn.isClientSide && this.effectName != null && ForgeRegistries.MOB_EFFECTS.getValue(this.effectName) != null) {
            entityLiving.addEffect(new MobEffectInstance((MobEffect)ForgeRegistries.MOB_EFFECTS.getValue(this.effectName), this.duration));
        } else if (this == AbnormalsNeapolitanCompatItems.WHITE_STRAWBERRY_CAKE_SLICE.get()) {
            applyHealing(1.0F, worldIn, entityLiving);
        }

        return super.finishUsingItem(stack, worldIn, entityLiving);
    }

    public static void applyHealing(float healAmount, LevelAccessor world, LivingEntity entity) {
        entity.heal(healAmount);
        Random rand = entity.getRandom();
        if (world.isClientSide()) {
            int times = 2 * Math.round(healAmount);

            for(int i = 0; i < times; ++i) {
                double d0 = rand.nextGaussian() * 0.02;
                double d1 = rand.nextGaussian() * 0.02;
                double d2 = rand.nextGaussian() * 0.02;
                world.addParticle(ParticleTypes.HEART, entity.getRandomX(1.0), entity.getRandomY() + 0.5, entity.getRandomZ(1.0), d0, d1, d2);
            }
        }

    }
}
