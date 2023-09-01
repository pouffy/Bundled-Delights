package com.pouffy.bundledelight.compat.neapolitan;

import com.mojang.datafixers.util.Pair;
import com.pouffy.bundledelight.BundledDelights;
import com.pouffy.bundledelight.compat.CompatFoodValues;
import com.pouffy.bundledelight.util.Configuration;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectUtil;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
@Mod.EventBusSubscriber(modid = BundledDelights.MODID, value = Dist.CLIENT)
public class ToolTips {
    @SubscribeEvent
    public static void addTooltipToVanillaSoups(ItemTooltipEvent event) {
        if (!Configuration.NEAPOLITAN_TOOLTIPS.get()) {
            return;
        }
        else if (!ModList.get().isLoaded("neapolitan")) {
            return;
        }
        else if (ModList.get().isLoaded("neapolitan") && !Configuration.NEAPOLITAN_TOOLTIPS.get()) {
            return;
        }
        Item food = event.getItemStack().getItem();

        FoodProperties nEffects = CompatFoodValues.NEAPOLITAN_EFFECTS.get(food);

        if (nEffects != null) {
            List<Component> tooltip = event.getToolTip();
            for (Pair<MobEffectInstance, Float> pair : nEffects.getEffects()) {
                MobEffectInstance effect = pair.getFirst();
                MutableComponent effectText = new TranslatableComponent(effect.getDescriptionId());
                if (effect.getDuration() > 20) {
                    effectText = new TranslatableComponent("potion.withDuration", effectText, MobEffectUtil.formatDuration(effect, 1));
                }
                tooltip.add(effectText.withStyle(effect.getEffect().getCategory().getTooltipFormatting()));
            }
        }
    }
}
