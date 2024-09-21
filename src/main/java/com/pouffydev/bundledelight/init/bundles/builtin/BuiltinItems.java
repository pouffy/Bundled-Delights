package com.pouffydev.bundledelight.init.bundles.builtin;

import com.pouffydev.bundledelight.BundledDelights;
import com.pouffydev.bundledelight.content.food.FoodValues;
import com.pouffydev.bundledelight.foundation.BundleRegistry;
import com.pouffydev.bundledelight.foundation.BundleRegistryClass;
import com.pouffydev.bundledelight.foundation.BundledRegistrate;
import com.tterrag.registrate.util.entry.ItemEntry;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.item.DrinkableItem;

@BundleRegistry
public class BuiltinItems extends BundleRegistryClass {
    private static final BundledRegistrate registrate = BundledDelights.registrate().creativeModeTab(() -> BundledDelights.itemGroup);
    
    public static final ItemEntry<DrinkableItem>
            borscht = registrate.drinkableItem(getBundleContentName("borscht")),
            nettleSoup = registrate.drinkableItem(getBundleContentName("nettle_soup")),
            sweetBerryJuice = registrate.drinkableItem(getBundleContentName("sweet_berry_juice")),
            glassOfConcrete = registrate.drinkableItem(getBundleContentName("glass_of_concrete"));
    
    public final ItemEntry<ConsumableItem>
            carrotCakeSlice = registrate.consumableItem(getBundleContentName("carrot_cake_slice"), BundledRegistrate.foodProps(FoodValues.CARROT_CAKE));
    
    public static void register() {
    }
}
