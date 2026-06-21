package com.pouffydev.bundledelight.init.bundles.builtin;

import com.pouffydev.bundledelight.BundledDelight;
import com.pouffydev.bundledelight.common.elements.item.BundleCakeSliceItem;
import com.pouffydev.bundledelight.common.elements.item.BundleConsumableItem;
import com.pouffydev.bundledelight.common.elements.item.BundleDrinkableItem;
import com.pouffydev.bundledelight.foundation.BDItemHelper;
import com.pouffydev.bundledelight.init.FoodValues;
import com.pouffydev.krystal_core.KrystalCore;
import net.neoforged.neoforge.registries.DeferredItem;

public class BuiltinItems {
    private static final BDItemHelper HELPER = new BDItemHelper(BundledDelight.getRegistryHelper().getItemHelper());

    public static final DeferredItem<BundleDrinkableItem>
            borscht = HELPER.drinkableItem(formatName("borscht")),
            nettleSoup = HELPER.drinkableItem(formatName("nettle_soup")),
            sweetBerryJuice = HELPER.drinkableItem(formatName("sweet_berry_juice"));

    public static final DeferredItem<BundleConsumableItem>
            carrotCookie = HELPER.consumableItem(formatName("carrot_cookie"), HELPER.foodProps(FoodValues.CARROT_COOKIE));

    public static final DeferredItem<BundleCakeSliceItem>
            carrotCakeSlice = HELPER.cakeSliceItem(formatName("carrot_cake_slice"), HELPER.foodProps(FoodValues.CARROT_CAKE));
    
    
    public static void register() {
        BundledDelight.LOGGER.info("Registering Builtin Items");
    }

    private static String formatName(String name) {
        var bundle = KrystalCore.getBundle(BundledDelight.location("builtin"));
        return bundle == null ? name : bundle.getBundleContentName(name);
    }
}
