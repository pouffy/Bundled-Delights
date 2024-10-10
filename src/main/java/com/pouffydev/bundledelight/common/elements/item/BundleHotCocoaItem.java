package com.pouffydev.bundledelight.common.elements.item;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.MobEffectEvent;

import java.util.ArrayList;
import java.util.Iterator;

public class BundleHotCocoaItem extends BundleDrinkableItem {

    public BundleHotCocoaItem(Properties properties) {
        super(properties, false, true);
        remainderItem = RemainderItem.copperCup;
    }

    public void affectConsumer(ItemStack stack, Level level, LivingEntity consumer) {
        Iterator<MobEffectInstance> itr = consumer.getActiveEffects().iterator();
        ArrayList<MobEffect> compatibleEffects = new ArrayList<>();

        MobEffectInstance selectedEffect;
        while(itr.hasNext()) {
            selectedEffect = itr.next();
            if (selectedEffect.getEffect().getCategory().equals(MobEffectCategory.HARMFUL) && selectedEffect.isCurativeItem(new ItemStack(Items.MILK_BUCKET))) {
                compatibleEffects.add(selectedEffect.getEffect());
            }
        }

        if (!compatibleEffects.isEmpty()) {
            selectedEffect = consumer.getEffect(compatibleEffects.get(level.random.nextInt(compatibleEffects.size())));
            if (selectedEffect != null && !MinecraftForge.EVENT_BUS.post(new MobEffectEvent.Remove(consumer, selectedEffect))) {
                consumer.removeEffect(selectedEffect.getEffect());
            }
        }

        if (compatibleEffects.size() > 1) {
            selectedEffect = consumer.getEffect(compatibleEffects.get(level.random.nextInt(compatibleEffects.size())));
            if (selectedEffect != null && !MinecraftForge.EVENT_BUS.post(new MobEffectEvent.Remove(consumer, selectedEffect))) {
                consumer.removeEffect(selectedEffect.getEffect());
            }
        }

    }
}
