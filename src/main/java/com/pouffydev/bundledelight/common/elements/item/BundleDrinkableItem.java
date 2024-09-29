package com.pouffydev.bundledelight.common.elements.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class BundleDrinkableItem extends BundleConsumableItem {
    public BundleDrinkableItem(Item.Properties properties) {
        super(properties);
    }

    public BundleDrinkableItem(Item.Properties properties, boolean hasFoodEffectTooltip) {
        super(properties, hasFoodEffectTooltip);
    }

    public BundleDrinkableItem(Item.Properties properties, boolean hasPotionEffectTooltip, boolean hasCustomTooltip) {
        super(properties, hasPotionEffectTooltip, hasCustomTooltip);
    }

    public BundleDrinkableItem withRemainderItem(RemainderItem remainderItem) {
        this.remainderItem = remainderItem;
        return this;
    }

    public int getUseDuration(ItemStack stack) {
        return 32;
    }

    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack heldStack = player.getItemInHand(hand);
        if (heldStack.isEdible()) {
            if (player.canEat(heldStack.getFoodProperties(player).canAlwaysEat())) {
                player.startUsingItem(hand);
                return InteractionResultHolder.consume(heldStack);
            } else {
                return InteractionResultHolder.fail(heldStack);
            }
        } else {
            return ItemUtils.startUsingInstantly(level, player, hand);
        }
    }
}
