package com.pouffydev.bundledelight.init.bundles.miners_brew;

import com.pouffydev.bundledelight.BundleDelightCreativeTab;
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
    private static final BundledRegistrate registrate = BundledDelight.registrate().setCreativeTab(BundleDelightCreativeTab.MAIN_TAB);

    public MinersBrewItems() {
        super("miners_brew");
    }

    public static final ItemEntry<Item> copperSwig = registrate.item(getBundleContentName("copper_swig"), Item::new, p -> p);

    public static final ItemEntry<BundleBoozeItem>
            beerSwig = registrate.boozeItemNoExtraEffect(getBundleContentName("beer_swig"), 1, 2400, 1800, tankardFoodItemNoEffect(), BundleConsumableItem.RemainderItem.copperSwig),
            vodkaSwig = registrate.boozeItemNoExtraEffect(getBundleContentName("vodka_swig"), 1, 3600, 3000, tankardFoodItemNoEffect(), BundleConsumableItem.RemainderItem.copperSwig),
            meadSwig = registrate.boozeItem(getBundleContentName("mead_swig"), 1, 2400, tankardFoodItem(BrewinItems.BrewinFoodValues.MEAD), BundleBoozeItem.Effect.Sweet_Heart, 2400, 0, 1800, BundleConsumableItem.RemainderItem.copperSwig),
            riceWineSwig = registrate.boozeItemNoExtraEffect(getBundleContentName("rice_wine_swig"), 1, 2400, 1800, tankardFoodItem(BrewinItems.BrewinFoodValues.RICE_WINE), BundleConsumableItem.RemainderItem.copperSwig),
            eggGrogSwig = registrate.boozeItemNoExtraEffect(getBundleContentName("egg_grog_swig"), 1, 2400, 1800, tankardFoodItem(BrewinItems.BrewinFoodValues.EGG_GROG), BundleConsumableItem.RemainderItem.copperSwig),
            strongrootAleSwig = registrate.boozeItemNoExtraEffect(getBundleContentName("strongroot_ale_swig"), 2, 2400, 1800, tankardFoodItem(BrewinItems.BrewinFoodValues.STRONGROOT_ALE), BundleConsumableItem.RemainderItem.copperSwig),
            saccharineRumSwig = registrate.boozeItem(getBundleContentName("saccharine_rum_swig"), 2, 3600, tankardFoodItem(BrewinItems.BrewinFoodValues.SACCHARINE_RUM), BundleBoozeItem.Effect.Sweet_Heart, 3600, 1, 2400, BundleConsumableItem.RemainderItem.copperSwig),
            paleJaneSwig = registrate.boozeItemNoExtraEffect(getBundleContentName("pale_jane_swig"), 1, 3600, 3000, tankardFoodItem(BrewinItems.BrewinFoodValues.PALE_JANE), BundleConsumableItem.RemainderItem.copperSwig),
            saltyFollySwig = registrate.boozeItemNoExtraEffect(getBundleContentName("salty_folly_swig"), 2, 3600, 3000, tankardFoodItem(BrewinItems.BrewinFoodValues.SALTY_FOLLY), BundleConsumableItem.RemainderItem.copperSwig),
            steelToeStoutSwig = registrate.boozeItemNoExtraEffect(getBundleContentName("steel_toe_stout_swig"), 3, 2400, 1800, tankardFoodItem(BrewinItems.BrewinFoodValues.STEEL_TOE_STOUT), BundleConsumableItem.RemainderItem.copperSwig),
            glitteringGrenadineSwig = registrate.boozeItemNoExtraEffect(getBundleContentName("glittering_grenadine_swig"), 1, 2400, 1800, tankardFoodItem(BrewinItems.BrewinFoodValues.GLITTERING_GRENADINE), BundleConsumableItem.RemainderItem.copperSwig),
            bloodyMarySwig = registrate.boozeItem(getBundleContentName("bloody_mary_swig"), 1, 2400, tankardFoodItem(BrewinItems.BrewinFoodValues.BLOODY_MARY), BundleBoozeItem.Effect.Raging, 1200, 0, 1800, BundleConsumableItem.RemainderItem.copperSwig),
            redRumSwig = registrate.boozeItem(getBundleContentName("red_rum_swig"), 1, 2400, tankardFoodItem(BrewinItems.BrewinFoodValues.RED_RUM), BundleBoozeItem.Effect.Raging, 2400, 0, 1800, BundleConsumableItem.RemainderItem.copperSwig),
            witheringDrossSwig = registrate.boozeItemNoExtraEffect(getBundleContentName("withering_dross_swig"), 3, 3600, 3000, tankardFoodItem(BrewinItems.BrewinFoodValues.WITHERING_DROSS), BundleConsumableItem.RemainderItem.copperSwig),
            kombuchaSwig = registrate.boozeItemNoExtraEffect(getBundleContentName("kombucha_swig"), 1, 2400, 1800, tankardFoodItem(BrewinItems.BrewinFoodValues.KOMBUCHA), BundleConsumableItem.RemainderItem.copperSwig),
            rootBeerSwig = registrate.boozeItemNoExtraEffect(getBundleContentName("root_beer_swig"), 1, 2400, 1800, tankardFoodItemNoEffect(), BundleConsumableItem.RemainderItem.copperSwig);

    public static final ItemEntry<BundleDreadNogItem>
            dreadNogSwig = registrate.dreadNogItem(getBundleContentName("dread_nog_swig"), 3, 4800, tankardFoodItemNoEffect(), BundleConsumableItem.RemainderItem.copperSwig);


    public static void register() {
        BundledDelight.LOGGER.info("Registering Miner's Brew items");
    }
}
