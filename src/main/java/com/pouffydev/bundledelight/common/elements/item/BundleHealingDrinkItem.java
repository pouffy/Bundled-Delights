package com.pouffydev.bundledelight.common.elements.item;

import com.pouffydev.bundledelight.foundation.util.client.BDTextUtils;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import vectorwing.farmersdelight.common.item.DrinkableItem;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

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

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        if (this.healAmount > 0.0F) {
            tooltip.add(BDTextUtils.InstantHealth.getFromFloat(this.healAmount).getTooltip());
        }
    }
}
