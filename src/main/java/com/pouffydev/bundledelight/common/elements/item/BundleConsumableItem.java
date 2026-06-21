package com.pouffydev.bundledelight.common.elements.item;

import com.pouffydev.krystal_core.KrystalCore;
import com.pouffydev.krystal_core.foundation.CompatHelpers;
import lombok.Getter;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import vectorwing.farmersdelight.common.Configuration;
import vectorwing.farmersdelight.common.utility.TextUtils;

import java.util.List;
import java.util.Objects;

public class BundleConsumableItem extends Item {
    private final boolean hasFoodEffectTooltip;
    private final boolean hasCustomTooltip;
    static RemainderItem remainderItem = RemainderItem.bowl;

    public BundleConsumableItem(Item.Properties properties) {
        super(properties);
        this.hasFoodEffectTooltip = false;
        this.hasCustomTooltip = false;
    }

    public BundleConsumableItem(Item.Properties properties, boolean hasFoodEffectTooltip) {
        super(properties);
        this.hasFoodEffectTooltip = hasFoodEffectTooltip;
        this.hasCustomTooltip = false;
    }

    public BundleConsumableItem(Item.Properties properties, boolean hasFoodEffectTooltip, boolean hasCustomTooltip) {
        super(properties);
        this.hasFoodEffectTooltip = hasFoodEffectTooltip;
        this.hasCustomTooltip = hasCustomTooltip;
    }

    public BundleConsumableItem withRemainderItem(RemainderItem pRemainderItem) {
        remainderItem = pRemainderItem;
        return this;
    }

    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity consumer) {
        if (!level.isClientSide) {
            this.affectConsumer(stack, level, consumer);
        }

        ItemStack containerStack = remainderItem != null ? remainderItem.getRemainderItem() : stack.getCraftingRemainingItem();
        if (stack.getFoodProperties(consumer) != null) {
            super.finishUsingItem(stack, level, consumer);
        } else {
            Player player = consumer instanceof Player ? (Player)consumer : null;
            if (player instanceof ServerPlayer) {
                CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayer)player, stack);
            }

            if (player != null) {
                player.awardStat(Stats.ITEM_USED.get(this));
                if (!player.getAbilities().instabuild) {
                    stack.shrink(1);
                }
            }
        }

        if (stack.isEmpty()) {
            return containerStack;
        } else {
            if (consumer instanceof Player) {
                Player player = (Player)consumer;
                if (!((Player)consumer).getAbilities().instabuild && !player.getInventory().add(containerStack)) {
                    player.drop(containerStack, false);
                }
            }

            return stack;
        }
    }

    public void affectConsumer(ItemStack stack, Level level, LivingEntity consumer) {
    }

    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag isAdvanced) {
        if (Configuration.ENABLE_FOOD_EFFECT_TOOLTIP.get()) {
            if (this.hasCustomTooltip) {
                tooltip.add(TextUtils.tooltip(BuiltInRegistries.ITEM.getKey(this).getPath()).withStyle(ChatFormatting.BLUE));
            }

            if (this.hasFoodEffectTooltip) {
                Objects.requireNonNull(tooltip);
                TextUtils.addFoodEffectTooltip(stack, tooltip::add, 1.0F, context.tickRate());
            }
        }

    }

    public enum RemainderItem {
        bowl("minecraft", "minecraft:bowl"),
        glassBottle("minecraft", "minecraft:glass_bottle"),
        glassTankard("bundledelight", "bundledelight:glass_tankard"),
        copperSwig("bundledelight", "bundledelight:copper_swig"),
        copperCup("miners_delight", "miners_delight:copper_cup"),
        tankard("brewinandchewin", "brewinandchewin:tankard"),
        ;

        @Getter
        private final String namespace;
        private final String remainderItem;

        RemainderItem(String namespace, String remainderItem) {
            this.namespace = namespace;
            this.remainderItem = remainderItem;
        }

        public String getRemainderItemName() {
            return this.remainderItem;
        }

        public ItemStack getRemainderItem() {
            boolean shouldUse = CompatHelpers.isLoaded(this.namespace);
            ItemStack remainderItem = new ItemStack(Items.BOWL);
            if (shouldUse) {
                remainderItem = new ItemStack(BuiltInRegistries.ITEM.get(KrystalCore.location(this.remainderItem)));
            }
            return remainderItem;
        }
    }


}
