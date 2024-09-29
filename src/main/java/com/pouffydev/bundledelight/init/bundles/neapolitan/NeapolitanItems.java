package com.pouffydev.bundledelight.init.bundles.neapolitan;

import com.pouffydev.bundledelight.BundledDelight;
import com.pouffydev.bundledelight.common.elements.item.BundleCakeSliceItem;
import com.pouffydev.bundledelight.common.elements.item.BundleIceCreamItem;
import com.pouffydev.bundledelight.common.elements.item.BundleMilkshakeItem;
import com.pouffydev.bundledelight.foundation.BundledRegistrate;
import com.pouffydev.bundledelight.foundation.bundle.BundleRegistryClass;
import com.pouffydev.bundledelight.init.FoodValues;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;

public class NeapolitanItems extends BundleRegistryClass {
    private static final BundledRegistrate registrate = BundledDelight.registrate().creativeModeTab(() -> BundledDelight.itemGroup);

    public NeapolitanItems() {
        super("neapolitan");
    }

    public static final ItemEntry<BundleMilkshakeItem>
            whiteStrawberryMilkshake = registrate.milkshakeItem(getBundleContentName("white_strawberry_milkshake"), FoodValues.STRAWBERRY_MILKSHAKE, 3.0F, (p) -> p),
            sweetBerryMilkshake = registrate.milkshakeItem(getBundleContentName("sweet_berry_milkshake"), FoodValues.SWEET_BERRY_MILKSHAKE, (p) -> p);

    public static final ItemEntry<BundleIceCreamItem>
            whiteStrawberryIceCream = registrate.iceCreamItem(getBundleContentName("white_strawberry_ice_cream"), FoodValues.STRAWBERRY_ICE_CREAM, 3.0F, (p) -> p),
            sweetBerryIceCream = registrate.iceCreamItem(getBundleContentName("sweet_berry_ice_cream"), FoodValues.SWEET_BERRY_ICE_CREAM, (p) -> p);

    public static final ItemEntry<BundleCakeSliceItem>
            whiteStrawberryCakeSlice = registrate.cakeSliceItem(getBundleContentName("white_strawberry_cake_slice"), 2.0F, FoodValues.STRAWBERRY_CAKE, (p) -> p);

    public static final ItemEntry<Item>
            powderedAdzukiBeans = registrate.item(getBundleContentName("powdered_adzuki_beans"), Item::new).register(),
            powderedMintLeaves = registrate.item(getBundleContentName("powdered_mint_leaves"), Item::new).register(),
            powderedVanilla = registrate.item(getBundleContentName("powdered_vanilla"), Item::new).register();

    public static void register() {
        BundledDelight.LOGGER.info("Registering Neapolitan Items");
    }
}
