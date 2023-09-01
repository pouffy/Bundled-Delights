package com.pouffy.bundledelight.compat.item;

import com.pouffy.bundledelight.BundledDelights;
import com.pouffy.bundledelight.init.BDEffects;
import net.minecraft.core.NonNullList;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.ModList;
import org.jetbrains.annotations.NotNull;
import vectorwing.farmersdelight.common.item.DrinkableItem;

public class CompatEffectDrink extends DrinkableItem {
    private String modTarget() {
        return targetedMod;
    }
    private boolean isTargetedModLoaded;
    public void findModAndAddProperties() {
        if (ModList.get().isLoaded(this.modTarget())) {
            this.isTargetedModLoaded = true;
        }
    }
    private final boolean isAlwaysHidden;
    private final String targetedMod;
    private final FoodProperties fallbackProperties = new FoodProperties.Builder().effect(() -> {
        return new MobEffectInstance(BDEffects.MISSING_EFFECT.get());
        }, 1.0F).build();
    private final FoodProperties intendedProperties;
    @SuppressWarnings("deprecation")
    public FoodProperties getFoodProperties() {
        if (this.isTargetedModLoaded) {
            return this.intendedProperties;
        } else {
            return this.fallbackProperties;
        }
    }
    @Override
    public void fillItemCategory(@NotNull CreativeModeTab group, @NotNull NonNullList<ItemStack> items) {
        if (group == BundledDelights.CREATIVE_TAB) {
            ItemStack stack = new ItemStack(this);
            if (!this.isAlwaysHidden) {
                items.add(stack);
            }
        }
    }
    public CompatEffectDrink(Properties properties, FoodProperties intendedProperties, String targetedMod) {
        super(properties);
        this.targetedMod = targetedMod;
        this.intendedProperties = intendedProperties;
        this.isAlwaysHidden = false;
    }
    public CompatEffectDrink(Properties properties, FoodProperties intendedProperties, String targetedMod, boolean isAlwaysHidden) {
        super(properties);
        this.targetedMod = targetedMod;
        this.intendedProperties = intendedProperties;
        this.isAlwaysHidden = isAlwaysHidden;
    }
}
