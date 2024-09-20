package com.pouffydev.bundledelight.compat.item;

import com.pouffydev.bundledelight.foundation.util.TextUtils;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

import javax.annotation.Nullable;

public class MissingEffect extends MobEffect {
    public MissingEffect() {
        super(MobEffectCategory.NEUTRAL, 0xffffff);
    }
    
    public void applyInstantenousEffect(@Nullable Entity entity, @Nullable Entity entity1, LivingEntity livingEntity, int p_19465_, double p_19466_) {
        livingEntity.sendSystemMessage(TextUtils.getTranslation("missing_effect", this.getDisplayName().getString()));
    }
}
