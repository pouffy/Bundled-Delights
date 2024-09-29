package com.pouffydev.bundledelight.common.elements.item;

import com.pouffydev.bundledelight.foundation.util.client.BDTextUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class BundleMelonJuiceItem extends BundleDrinkableItem {
    private final float healAmount;

    public BundleMelonJuiceItem(Item.Properties properties, float healAmount) {
        super(properties, false, true);
        this.remainderItem = RemainderItem.copperCup;
        this.healAmount = healAmount;
    }

    public void affectConsumer(ItemStack stack, Level level, LivingEntity consumer) {
        consumer.heal(healAmount);
    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(BDTextUtils.InstantHealth.getFromFloat(healAmount).getTooltip());
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }
}
