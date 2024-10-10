package com.pouffydev.bundledelight.init.bundles.minersparlour;

import com.pouffydev.bundledelight.BundledDelight;
import com.pouffydev.bundledelight.common.elements.item.BundleConsumableItem;
import com.pouffydev.bundledelight.common.elements.item.BundleIceCreamItem;
import com.pouffydev.bundledelight.foundation.BundledRegistrate;
import com.pouffydev.bundledelight.foundation.bundle.BundleRegistryClass;
import com.pouffydev.bundledelight.init.FoodValues;
import com.tterrag.registrate.util.entry.ItemEntry;

public class MinersParlourItems extends BundleRegistryClass {
    private static final BundledRegistrate registrate = BundledDelight.registrate().creativeModeTab(() -> BundledDelight.itemGroup);

    public MinersParlourItems() {
        super("miners_parlour");
    }

    public static final ItemEntry<BundleIceCreamItem>
            whiteStrawberryIceCream = registrate.iceCreamItem(getBundleContentName("white_strawberry_ice_cream_cup"), FoodValues.copyAndAddHaste(FoodValues.STRAWBERRY_ICE_CREAM), 3.0F, (p) -> p, BundleConsumableItem.RemainderItem.copperCup),
            sweetBerryIceCream = registrate.iceCreamItem(getBundleContentName("sweet_berry_ice_cream_cup"), FoodValues.copyAndAddHaste(FoodValues.SWEET_BERRY_ICE_CREAM), (p) -> p, BundleConsumableItem.RemainderItem.copperCup);

    public static void register() {
        BundledDelight.LOGGER.info("Registering Miner's Parlour Items");
    }
}
