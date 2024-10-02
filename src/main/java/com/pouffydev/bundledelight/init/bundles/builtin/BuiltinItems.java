package com.pouffydev.bundledelight.init.bundles.builtin;

import com.pouffydev.bundledelight.BundledDelight;
import com.pouffydev.bundledelight.common.elements.item.BundleCakeSliceItem;
import com.pouffydev.bundledelight.common.elements.item.BundleDrinkableItem;
import com.pouffydev.bundledelight.foundation.BundledRegistrate;
import com.pouffydev.bundledelight.foundation.bundle.BundleRegistryClass;
import com.pouffydev.bundledelight.init.FoodValues;
import com.tterrag.registrate.util.entry.ItemEntry;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.item.DrinkableItem;
import vectorwing.farmersdelight.common.registry.ModItems;

public class BuiltinItems extends BundleRegistryClass {
    private static final BundledRegistrate registrate = BundledDelight.registrate().creativeModeTab(() -> BundledDelight.itemGroup, "Bundled Delights");
    
    public BuiltinItems() {
        super("bundledelight");
    }
    
    public static final ItemEntry<BundleDrinkableItem>
            borscht = registrate.drinkableItem(getBundleContentName("borscht")),
            nettleSoup = registrate.drinkableItem(getBundleContentName("nettle_soup")),
            sweetBerryJuice = registrate.drinkableItem(getBundleContentName("sweet_berry_juice")),
            glassOfConcrete = registrate.drinkableItem(getBundleContentName("glass_of_concrete"));

    public static final ItemEntry<ConsumableItem>
            carrotCookie = registrate.consumableItem(getBundleContentName("carrot_cookie"), BundledRegistrate.foodProps(FoodValues.CARROT_COOKIE));

    public static final ItemEntry<BundleCakeSliceItem>
            carrotCakeSlice = registrate.cakeSliceItem(getBundleContentName("carrot_cake_slice"), FoodValues.CARROT_CAKE, (p) -> p);
    
    
    public static void register() {
        BundledDelight.LOGGER.info("Registering Builtin Items");
    }
}
