package com.pouffydev.bundledelight.init.bundles.farmersrespite;

import com.pouffydev.bundledelight.BundledDelight;
import com.pouffydev.bundledelight.foundation.BundledRegistrate;
import com.pouffydev.bundledelight.foundation.bundle.BundleRegistryClass;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;

public class RespiteItems extends BundleRegistryClass {
    private static final BundledRegistrate registrate = BundledDelight.registrate().creativeModeTab(() -> BundledDelight.itemGroup);

    public RespiteItems() {
        super("farmersrespite");
    }

    public static final ItemEntry<Item>
            powderedGreenTeaLeaves = registrate.item(getBundleContentName("powdered_green_tea_leaves"), Item::new, p -> p),
            powderedYellowTeaLeaves = registrate.item(getBundleContentName("powdered_yellow_tea_leaves"), Item::new, p -> p),
            powderedBlackTeaLeaves = registrate.item(getBundleContentName("powdered_black_tea_leaves"), Item::new, p -> p),
            powderedCoffeeBeans = registrate.item(getBundleContentName("powdered_coffee_beans"), Item::new, p -> p);


    public static void register() {
        BundledDelight.LOGGER.info("Registering Respite Items");
    }
}
