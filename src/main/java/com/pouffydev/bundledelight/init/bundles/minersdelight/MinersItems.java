package com.pouffydev.bundledelight.init.bundles.minersdelight;

import com.pouffydev.bundledelight.BundledDelight;
import com.pouffydev.bundledelight.common.elements.item.BundleConsumableItem;
import com.pouffydev.bundledelight.common.elements.item.BundleDrinkableItem;
import com.pouffydev.bundledelight.common.elements.item.BundleMelonJuiceItem;
import com.pouffydev.bundledelight.foundation.BundledRegistrate;
import com.pouffydev.bundledelight.foundation.bundle.BundleRegistryClass;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.resources.ResourceLocation;
import vectorwing.farmersdelight.common.FoodValues;

public class MinersItems extends BundleRegistryClass {
    private static final BundledRegistrate registrate = BundledDelight.registrate().creativeModeTab(() -> BundledDelight.itemGroup);

    public MinersItems() {
        super("miners_delight");
    }

    public static final ItemEntry<BundleDrinkableItem>
            borscht = registrate.drinkableItem(getBundleContentName("borscht")),
            nettleSoup = registrate.drinkableItem(getBundleContentName("nettle_soup")),
            sweetBerryJuice = registrate.drinkableItem(getBundleContentName("sweet_berry_juice")),
            glassOfConcrete = registrate.drinkableItem(getBundleContentName("glass_of_concrete"));

    public static final ItemEntry<BundleDrinkableItem> appleCiderCup = registrate.item(getBundleContentName("apple_cider_cup"), (p) -> new BundleDrinkableItem(p).withRemainderItem(BundleConsumableItem.RemainderItem.copperCup))
            .properties(p -> p.food(FoodValues.APPLE_CIDER).stacksTo(16))
            .model((c, p) -> p.withExistingParent(c.getName(), new ResourceLocation("bundledelight", "item/mug")).texture("layer0", p.modLoc("item/" + c.getName())))
            .lang("Apple Cider Cup")
            .register();

    public static final ItemEntry<BundleMelonJuiceItem> melonJuiceCup = registrate.item(getBundleContentName("melon_juice_cup"), (p) -> new BundleMelonJuiceItem(p, 2.0F))
            .properties(p -> p.stacksTo(16))
            .model((c, p) -> p.withExistingParent(c.getName(), new ResourceLocation("bundledelight", "item/mug")).texture("layer0", p.modLoc("item/" + c.getName())))
            .lang("Melon Juice Cup")
            .register();

    public static void register() {
        BundledDelight.LOGGER.info("Registering Miner's Delight items");
    }
}
