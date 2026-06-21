package com.pouffydev.bundledelight.foundation;

import com.pouffydev.bundledelight.common.elements.item.BundleCakeSliceItem;
import com.pouffydev.bundledelight.common.elements.item.BundleConsumableItem;
import com.pouffydev.bundledelight.common.elements.item.BundleDrinkableItem;
import com.pouffydev.krystal_core.foundation.registry.item.ItemRegistryHelper;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;
import java.util.function.Supplier;

@SuppressWarnings("unchecked")
public class BDItemHelper extends ItemRegistryHelper {
    public final DeferredRegister<Item> ITEMS;

    public BDItemHelper(ItemRegistryHelper helper) {
        super(helper.getModId(), helper.getEventBus());
        ITEMS = this.createRegister(Registries.ITEM);
    }

    public <T extends Item> DeferredItem<T> register(String name, Supplier<T> constructor) {
        return (DeferredItem<T>) ITEMS.register(name, constructor);
    }

    public <T extends BundleDrinkableItem> DeferredItem<T> drinkableItem(String name) {
        return this.drinkableItem(name, (p) -> p);
    }

    public <T extends BundleDrinkableItem> DeferredItem<T> drinkableItem(String name, Function<Item.Properties, Item.Properties> properties) {
        return (DeferredItem<T>) register(name, () -> new BundleDrinkableItem(properties.apply(new Item.Properties())));
    }

    public <T extends BundleConsumableItem> DeferredItem<T> consumableItem(String name) {
        return consumableItem(name, (p) -> p);
    }

    public <T extends BundleConsumableItem> DeferredItem<T> consumableItem(String name, Function<Item.Properties, Item.Properties> properties) {
        return (DeferredItem<T>) register(name, () -> new BundleConsumableItem(properties.apply(new Item.Properties())));
    }

    public <T extends BundleCakeSliceItem> DeferredItem<T> cakeSliceItem(String name) {
        return cakeSliceItem(name, (p) -> p);
    }

    public <T extends BundleCakeSliceItem> DeferredItem<T> cakeSliceItem(String name, Function<Item.Properties, Item.Properties> properties) {
        return (DeferredItem<T>) register(name, () -> new BundleCakeSliceItem(properties.apply(new Item.Properties())));
    }

    public Function<Item.Properties, Item.Properties> foodProps(FoodProperties properties) {
        return p -> p.food(properties);
    }
}
