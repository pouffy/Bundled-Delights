package com.pouffydev.bundledelight.common.elements.item;

import com.pouffydev.bundledelight.foundation.util.client.BDTextUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.BowlFoodItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

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

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        if (this.healAmount > 0.0F) {
            tooltip.add(BDTextUtils.InstantHealth.getFromFloat(this.healAmount).getTooltip());
        }
    }
}
