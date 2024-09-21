package com.pouffydev.bundledelight.content.item;

import com.pouffydev.bundledelight.foundation.util.BDTextUtils;
import com.pouffydev.bundledelight.foundation.util.CommonUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import vectorwing.farmersdelight.common.item.DrinkableItem;
import vectorwing.farmersdelight.common.utility.TextUtils;

import javax.annotation.Nullable;
import java.util.List;

public class BundleBoozeItem extends DrinkableItem {
    protected final int potency;
    protected final int duration;
    
    public BundleBoozeItem(int potency, int duration, Item.Properties properties) {
        super(properties);
        this.potency = potency;
        this.duration = duration;
    }
    
    public void affectConsumer(ItemStack stack, Level level, LivingEntity consumer) {
        CommonUtil.addTipsyEffect(consumer, this.duration, this.potency);
    }
    
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        MutableComponent textTipsy = BDTextUtils.getTranslation("brewinandchewin", "tooltip.tipsy1", this.duration);
        if (this.potency == 2) {
            textTipsy = BDTextUtils.getTranslation("brewinandchewin", "tooltip.tipsy2", this.duration);
        } else if (this.potency == 3) {
            textTipsy = BDTextUtils.getTranslation("brewinandchewin", "tooltip.tipsy3", this.duration);
        }
        
        tooltip.add(textTipsy.withStyle(ChatFormatting.RED));
        TextUtils.addFoodEffectTooltip(stack, tooltip, 1.0F);
    }
}
