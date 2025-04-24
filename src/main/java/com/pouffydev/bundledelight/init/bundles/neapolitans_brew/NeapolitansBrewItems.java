package com.pouffydev.bundledelight.init.bundles.neapolitans_brew;

import com.pouffydev.bundledelight.BundleDelightCreativeTab;
import com.pouffydev.bundledelight.BundledDelight;
import com.pouffydev.bundledelight.common.elements.item.*;
import com.pouffydev.bundledelight.foundation.BundledRegistrate;
import com.pouffydev.bundledelight.foundation.bundle.BundleRegistryClass;
import com.pouffydev.bundledelight.init.FoodValues;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class NeapolitansBrewItems extends BundleRegistryClass {
    private static final BundledRegistrate registrate = BundledDelight.registrate().setCreativeTab(BundleDelightCreativeTab.MAIN_TAB);

    public NeapolitansBrewItems() {
        super("neapolitans_brew");
    }

    public static final FoodProperties JAM = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.4F).build();

    public static final ItemEntry<BundleJamJarItem>
            whiteStrawberryJam = registrate.jamJarItem(getBundleContentName("white_strawberry_jam"), JAM, 3.0F, (p) -> p),
            strawberryJam = registrate.jamJarItem(getBundleContentName("strawberry_jam"), JAM, 3.0F, (p) -> p);



    public static void register() {
        BundledDelight.LOGGER.info("Registering Neapolitan's Brew Items");
    }
}
