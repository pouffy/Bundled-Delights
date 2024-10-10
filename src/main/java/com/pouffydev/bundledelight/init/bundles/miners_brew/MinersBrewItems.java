package com.pouffydev.bundledelight.init.bundles.miners_brew;

import com.pouffydev.bundledelight.BundledDelight;
import com.pouffydev.bundledelight.common.elements.item.BundleBoozeItem;
import com.pouffydev.bundledelight.common.elements.item.BundleConsumableItem;
import com.pouffydev.bundledelight.common.elements.item.BundleDreadNogItem;
import com.pouffydev.bundledelight.foundation.BundledRegistrate;
import com.pouffydev.bundledelight.foundation.bundle.BundleRegistryClass;
import com.pouffydev.bundledelight.init.bundles.brewinandchewin.BrewinItems;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;

import static com.pouffydev.bundledelight.foundation.BundledRegistrate.tankardFoodItem;
import static com.pouffydev.bundledelight.foundation.BundledRegistrate.tankardFoodItemNoEffect;


public class MinersBrewItems extends BundleRegistryClass {
    private static final BundledRegistrate registrate = BundledDelight.registrate().creativeModeTab(() -> BundledDelight.itemGroup);

    public MinersBrewItems() {
        super("miners_brew");
    }

    public static final ItemEntry<Item> copperSwig = registrate.item(getBundleContentName("copper_swig"), Item::new, p -> p);

    public static final ItemEntry<BundleBoozeItem>
            beerSwig = registrate.boozeItemNoExtraEffect(getBundleContentName("beer_swig"), 1, 8, tankardFoodItemNoEffect(), BundleConsumableItem.RemainderItem.copperSwig),
            vodkaSwig = registrate.boozeItemNoExtraEffect(getBundleContentName("vodka_swig"), 1, 12, tankardFoodItemNoEffect(), BundleConsumableItem.RemainderItem.copperSwig),
            meadSwig = registrate.boozeItem(getBundleContentName("mead_swig"), 1, 8, tankardFoodItem(BrewinItems.BrewinFoodValues.MEAD), BundleBoozeItem.Effect.Sweet_Heart, 6000, 0, BundleConsumableItem.RemainderItem.copperSwig),
            riceWineSwig = registrate.boozeItem(getBundleContentName("rice_wine_swig"), 1, 5, tankardFoodItem(BrewinItems.BrewinFoodValues.RICE_WINE), BundleBoozeItem.Effect.Satisfaction, 6000, 0, BundleConsumableItem.RemainderItem.copperSwig),
            eggGrogSwig = registrate.boozeItemNoExtraEffect(getBundleContentName("egg_grog_swig"), 1, 0, tankardFoodItem(BrewinItems.BrewinFoodValues.EGG_GROG), BundleConsumableItem.RemainderItem.copperSwig),
            strongrootAleSwig = registrate.boozeItemNoExtraEffect(getBundleContentName("strongroot_ale_swig"), 2, 12, tankardFoodItem(BrewinItems.BrewinFoodValues.STRONGROOT_ALE), BundleConsumableItem.RemainderItem.copperSwig),
            saccharineRumSwig = registrate.boozeItem(getBundleContentName("saccharine_rum_swig"), 2, 8, tankardFoodItem(BrewinItems.BrewinFoodValues.SACCHARINE_RUM), BundleBoozeItem.Effect.Sweet_Heart, 9600, 1, BundleConsumableItem.RemainderItem.copperSwig),
            paleJaneSwig = registrate.boozeItem(getBundleContentName("pale_jane_swig"), 1, 5, tankardFoodItem(BrewinItems.BrewinFoodValues.PALE_JANE), BundleBoozeItem.Effect.Satisfaction, 9600, 1, BundleConsumableItem.RemainderItem.copperSwig),
            saltyFollySwig = registrate.boozeItemNoExtraEffect(getBundleContentName("salty_folly_swig"), 2, 10, tankardFoodItem(BrewinItems.BrewinFoodValues.SALTY_FOLLY), BundleConsumableItem.RemainderItem.copperSwig),
            steelToeStoutSwig = registrate.boozeItemNoExtraEffect(getBundleContentName("steel_toe_stout_swig"), 3, 10, tankardFoodItem(BrewinItems.BrewinFoodValues.STEEL_TOE_STOUT), BundleConsumableItem.RemainderItem.copperSwig),
            glitteringGrenadineSwig = registrate.boozeItemNoExtraEffect(getBundleContentName("glittering_grenadine_swig"), 1, 5, tankardFoodItem(BrewinItems.BrewinFoodValues.GLITTERING_GRENADINE), BundleConsumableItem.RemainderItem.copperSwig),
            bloodyMarySwig = registrate.boozeItemNoExtraEffect(getBundleContentName("bloody_mary_swig"), 1, 12, tankardFoodItem(BrewinItems.BrewinFoodValues.BLOODY_MARY), BundleConsumableItem.RemainderItem.copperSwig),
            redRumSwig = registrate.boozeItemNoExtraEffect(getBundleContentName("red_rum_swig"), 1, 18, tankardFoodItem(BrewinItems.BrewinFoodValues.RED_RUM), BundleConsumableItem.RemainderItem.copperSwig),
            witheringDrossSwig = registrate.boozeItemNoExtraEffect(getBundleContentName("withering_dross_swig"), 3, 20, tankardFoodItem(BrewinItems.BrewinFoodValues.WITHERING_DROSS), BundleConsumableItem.RemainderItem.copperSwig),
            kombuchaSwig = registrate.boozeItem(getBundleContentName("kombucha_swig"), 1, 5, tankardFoodItem(BrewinItems.BrewinFoodValues.KOMBUCHA), BundleBoozeItem.Effect.Satisfaction, 3600, 0, BundleConsumableItem.RemainderItem.copperSwig),
            rootBeerSwig = registrate.boozeItemNoExtraEffect(getBundleContentName("root_beer_swig"), 1, 8, tankardFoodItemNoEffect(), BundleConsumableItem.RemainderItem.copperSwig);

    public static final ItemEntry<BundleDreadNogItem>
            dreadNogSwig = registrate.dreadNogItem(getBundleContentName("dread_nog_swig"), 3, 5, tankardFoodItemNoEffect(), BundleConsumableItem.RemainderItem.copperSwig);


    public static void register() {
        BundledDelight.LOGGER.info("Registering Miner's Brew items");
    }
}
