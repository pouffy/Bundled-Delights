package com.pouffydev.bundledelight.common.elements.item;

import com.pouffydev.bundledelight.BundleManager;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;
import vectorwing.farmersdelight.common.Configuration;
import vectorwing.farmersdelight.common.utility.TextUtils;

import javax.annotation.Nullable;
import java.util.List;

public class BundleConsumableItem extends Item {
    private final boolean hasFoodEffectTooltip;
    private final boolean hasCustomTooltip;
    RemainderItem remainderItem;

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

    public BundleConsumableItem withRemainderItem(RemainderItem remainderItem) {
        this.remainderItem = remainderItem;
        return this;
    }

    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity consumer) {
        if (!level.isClientSide) {
            this.affectConsumer(stack, level, consumer);
        }


        ItemStack containerStack = remainderItem != null ? remainderItem.getRemainderItem() : stack.getCraftingRemainingItem();
        Player player;
        if (stack.isEdible()) {
            super.finishUsingItem(stack, level, consumer);
        } else {
            player = consumer instanceof Player ? (Player)consumer : null;
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
                player = (Player)consumer;
                if (!((Player)consumer).getAbilities().instabuild && !player.getInventory().add(containerStack)) {
                    player.drop(containerStack, false);
                }
            }

            return stack;
        }
    }

    public void affectConsumer(ItemStack stack, Level level, LivingEntity consumer) {
    }

    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag isAdvanced) {
        if (Configuration.FOOD_EFFECT_TOOLTIP.get()) {
            if (this.hasCustomTooltip) {
                MutableComponent textEmpty = TextUtils.getTranslation("tooltip." + this);
                tooltip.add(textEmpty.withStyle(ChatFormatting.BLUE));
            }

            if (this.hasFoodEffectTooltip) {
                TextUtils.addFoodEffectTooltip(stack, tooltip, 1.0F);
            }
        }

    }

    public enum RemainderItem {
        glassTankard("brewinandchewin", "bundledelight:glass_tankard"),
        copperSwig("brewinandchewin_x_miners_delight", "bundledelight:copper_swig"),
        copperCup("miners_{}", "miners_delight:copper_cup"),
        ;

        private final String bundleName;
        private final String remainderItem;

        RemainderItem(String bundleName, String remainderItem) {
            this.bundleName = bundleName;
            this.remainderItem = remainderItem;
        }

        public String getBundleName() {
            return this.bundleName;
        }

        public String getRemainderItemName() {
            return this.remainderItem;
        }

        public ItemStack getRemainderItem() {
            boolean shouldUse = BundleManager.isBundleLoaded(this.bundleName);
            ItemStack remainderItem = new ItemStack(Items.BOWL);
            if (shouldUse) {
                remainderItem = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(this.remainderItem)));
            }
            return remainderItem;
        }
    }
}
