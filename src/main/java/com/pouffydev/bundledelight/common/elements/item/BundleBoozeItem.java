package com.pouffydev.bundledelight.common.elements.item;

import com.pouffydev.bundledelight.foundation.util.CommonUtil;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import vectorwing.farmersdelight.common.utility.TextUtils;

import javax.annotation.Nullable;
import java.util.List;

public class BundleBoozeItem extends BundleDrinkableItem {
    protected final int potency;
    protected final int duration;

    public BundleBoozeItem(int potency, int duration, Item.Properties properties, BundleConsumableItem.RemainderItem remainder) {
        super(properties, true, false);
        this.potency = potency;
        this.duration = duration;
        remainderItem = remainder;
    }
    
    public void affectConsumer(ItemStack stack, Level level, LivingEntity consumer) {
        CommonUtil.addTipsyEffect(consumer, this.duration, this.potency);
    }
    
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }
}
