package com.pouffydev.bundledelight.foundation;

import com.pouffydev.bundledelight.BundledDelights;
import com.tterrag.registrate.util.entry.ItemEntry;
import com.tterrag.registrate.util.nullness.NonNullUnaryOperator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.item.DrinkableItem;

import java.util.List;
import java.util.Objects;

public abstract class Bundle {
    private boolean isLoaded;
    private final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
    private static String modid;
    
    public abstract List<String> getRequiredClasses();
    
    public Bundle(String pModid) {
        modid = pModid;
    }
    
    public static String getModid() {
        return modid;
    }
    
    public void tryLoad() {
        boolean allClassesFound = false;
        for (String className : getRequiredClasses()) {
            if (BundledRegistrate.isClassFound(className)) {
                allClassesFound = true;
            } else {
                allClassesFound = false;
                break;
            }
        }
        if (allClassesFound) {
            this.isLoaded = true;
            this.onLoad();
            BundledDelights.LOGGER.info("Bundle for {} is loaded", modid);
        }
    }
    
    protected abstract void onLoad();
    
    public boolean isLoaded() {
        return this.isLoaded;
    }
    
    public ResourceLocation getLocation(String path) {
        return new ResourceLocation(modid, path);
    }
    
    public static ItemEntry<ConsumableItem> consumableItem(BundledRegistrate reg, String name) {
        String itemName = Objects.equals(getModid(), "bundledelight") ? name : getModid() + "/" + name;
        return reg.consumableItem(itemName);
    }
    
    public static ItemEntry<ConsumableItem> consumableItem(BundledRegistrate reg, String name, NonNullUnaryOperator<Item.Properties> properties) {
        String itemName = Objects.equals(getModid(), "bundledelight") ? name : getModid() + "/" + name;
        return reg.consumableItem(itemName, properties);
    }
    
    public static ItemEntry<ConsumableItem> consumableItem(BundledRegistrate reg, String name, Item.Properties properties) {
        String itemName = Objects.equals(getModid(), "bundledelight") ? name : getModid() + "/" + name;
        return reg.consumableItem(itemName, (p) -> properties);
    }
    
    public static ItemEntry<DrinkableItem> drinkableItem(BundledRegistrate reg, String name) {
        String itemName = Objects.equals(getModid(), "bundledelight") ? name : getModid() + "/" + name;
        return reg.drinkableItem(itemName);
    }
    
    public static ItemEntry<DrinkableItem> drinkableItem(BundledRegistrate reg, String name, NonNullUnaryOperator<Item.Properties> properties) {
        String itemName = Objects.equals(getModid(), "bundledelight") ? name : getModid() + "/" + name;
        return reg.drinkableItem(itemName, properties);
    }
    
    public static ItemEntry<DrinkableItem> drinkableItem(BundledRegistrate reg, String name, Item.Properties properties) {
        String itemName = Objects.equals(getModid(), "bundledelight") ? name : getModid() + "/" + name;
        return reg.drinkableItem(itemName, (p) -> properties);
    }
}
