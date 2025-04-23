package com.pouffydev.bundledelight.init.bundles.neapolitans_brew;

import com.pouffydev.bundledelight.BundleDelightCreativeTab;
import com.pouffydev.bundledelight.BundledDelight;
import com.pouffydev.bundledelight.common.elements.item.BundleCakeSliceItem;
import com.pouffydev.bundledelight.common.elements.item.BundleConsumableItem;
import com.pouffydev.bundledelight.common.elements.item.BundleIceCreamItem;
import com.pouffydev.bundledelight.common.elements.item.BundleMilkshakeItem;
import com.pouffydev.bundledelight.foundation.BundledRegistrate;
import com.pouffydev.bundledelight.foundation.bundle.BundleRegistryClass;
import com.pouffydev.bundledelight.init.FoodValues;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;

public class NeapolitansBrewItems extends BundleRegistryClass {
    private static final BundledRegistrate registrate = BundledDelight.registrate().setCreativeTab(BundleDelightCreativeTab.MAIN_TAB);

    public NeapolitansBrewItems() {
        super("neapolitans_brew");
    }

    public static final ItemEntry<BundleMilkshakeItem>
            whiteStrawberryJam = registrate.milkshakeItem(getBundleContentName("white_strawberry_jam"), FoodValues.STRAWBERRY_MILKSHAKE, 3.0F, (p) -> p),
            strawberryJam = registrate.milkshakeItem(getBundleContentName("strawberry_jam"), FoodValues.SWEET_BERRY_MILKSHAKE, 3.0F, (p) -> p);

    public static void register() {
        BundledDelight.LOGGER.info("Registering Neapolitan's Brew Items");
    }
}
