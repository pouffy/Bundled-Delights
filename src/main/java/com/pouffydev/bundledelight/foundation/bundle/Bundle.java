package com.pouffydev.bundledelight.foundation.bundle;

import com.pouffydev.bundledelight.BundledDelight;
import com.pouffydev.bundledelight.foundation.BundledRegistrate;
import com.tterrag.registrate.builders.ItemBuilder;
import com.tterrag.registrate.util.entry.ItemEntry;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import com.tterrag.registrate.util.nullness.NonNullUnaryOperator;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.loading.DatagenModLoader;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.item.DrinkableItem;

import java.util.List;
import java.util.Objects;

public abstract class Bundle {
    private boolean isLoaded;
    protected final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
    private final String modid;
    
    public abstract List<String> getRequiredClasses();
    
    public Bundle() {
        modid = getName();
    }
    
    public String getModid() {
        return this.modid;
    }
    
    public abstract String getName();
    
    public void tryLoad() {
        if (DatagenModLoader.isRunningDataGen()) {
            BundledDelight.LOGGER.info("Skipping required class check for bundle {} as data gen is running", modid);
            this.isLoaded = true;
            this.onLoad();
        } else {
            boolean allClassesFound = false;
            BundledDelight.LOGGER.info("Checking required classes for bundle {}", modid);
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
                BundledDelight.LOGGER.info("Bundle for {} is loaded", modid);
            }
        }
    }
    
    protected abstract void onLoad();
    
    public boolean isLoaded() {
        return this.isLoaded;
    }
    
    public ResourceLocation getLocation(String path) {
        return new ResourceLocation(modid, path);
    }
    
    public String getBundleContentName(String name) {
        return Objects.equals(modid, "bundledelight") ? name : modid + "/" + name;
    }
    
    public <T extends Item> ItemEntry<T> item(BundledRegistrate reg, String name, NonNullFunction<Item.Properties, T> factory, NonNullUnaryOperator<Item.Properties> properties) {
        ItemBuilder<T, ?> builder = reg.item(getBundleContentName(name), factory).properties(properties);
        return builder.register();
    }
    
    public ItemEntry<ConsumableItem> consumableItem(BundledRegistrate reg, String name) {
        return reg.consumableItem(getBundleContentName(name));
    }
    
    public ItemEntry<ConsumableItem> consumableItem(BundledRegistrate reg, String name, NonNullUnaryOperator<Item.Properties> properties) {
        return reg.consumableItem(getBundleContentName(name), properties);
    }
    
    public ItemEntry<ConsumableItem> consumableItem(BundledRegistrate reg, String name, Item.Properties properties) {
        return reg.consumableItem(getBundleContentName(name), (p) -> properties);
    }
    
    public ItemEntry<DrinkableItem> drinkableItem(BundledRegistrate reg, String name) {
        return reg.drinkableItem(getBundleContentName(name));
    }
    
    public ItemEntry<DrinkableItem> drinkableItem(BundledRegistrate reg, String name, NonNullUnaryOperator<Item.Properties> properties) {
        return reg.drinkableItem(getBundleContentName(name), properties);
    }
    
    public ItemEntry<DrinkableItem> drinkableItem(BundledRegistrate reg, String name, Item.Properties properties) {
        return reg.drinkableItem(getBundleContentName(name), (p) -> properties);
    }
    
    public abstract void runDatagen(DataGenerator generator, ExistingFileHelper existingFileHelper, boolean client, boolean server);
}
