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
import umpaz.brewinandchewin.common.registry.BnCFoods;

import static com.pouffydev.bundledelight.foundation.BundledRegistrate.tankardFoodItem;
import static com.pouffydev.bundledelight.foundation.BundledRegistrate.tankardFoodItemNoEffect;


public class MinersBrewItems extends BundleRegistryClass {
    private static final BundledRegistrate registrate = BundledDelight.registrate().setCreativeTab(BundleDelightCreativeTab.MAIN_TAB);

    public MinersBrewItems() {
        super("miners_brew");
    }

    public static final ItemEntry<Item> copperSwig = registrate.item(getBundleContentName("copper_swig"), Item::new, p -> p);

    public static final ItemEntry<BundleBoozeItem>
            beerSwig = registrate.boozeItemNoExtraEffect(getBundleContentName("beer_swig"), 1, 2400, tankardFoodItemNoEffect(), BundleConsumableItem.RemainderItem.copperSwig),
            vodkaSwig = registrate.boozeItemNoExtraEffect(getBundleContentName("vodka_swig"), 1, 3600, tankardFoodItemNoEffect(), BundleConsumableItem.RemainderItem.copperSwig),
            meadSwig = registrate.boozeItem(getBundleContentName("mead_swig"), 1, 2400, tankardFoodItem(BnCFoods.MEAD), BundleConsumableItem.RemainderItem.copperSwig),
            riceWineSwig = registrate.boozeItemNoExtraEffect(getBundleContentName("rice_wine_swig"), 1, 2400, tankardFoodItem(BnCFoods.RICE_WINE), BundleConsumableItem.RemainderItem.copperSwig),
            eggGrogSwig = registrate.boozeItemNoExtraEffect(getBundleContentName("egg_grog_swig"), 1, 2400, tankardFoodItem(BnCFoods.EGG_GROG), BundleConsumableItem.RemainderItem.copperSwig),
            strongrootAleSwig = registrate.boozeItemNoExtraEffect(getBundleContentName("strongroot_ale_swig"), 2, 2400, tankardFoodItem(BnCFoods.STRONGROOT_ALE), BundleConsumableItem.RemainderItem.copperSwig),
            saccharineRumSwig = registrate.boozeItem(getBundleContentName("saccharine_rum_swig"), 2, 3600, tankardFoodItem(BnCFoods.SACCHARINE_RUM), BundleConsumableItem.RemainderItem.copperSwig),
            paleJaneSwig = registrate.boozeItemNoExtraEffect(getBundleContentName("pale_jane_swig"), 1, 3600, tankardFoodItem(BnCFoods.PALE_JANE), BundleConsumableItem.RemainderItem.copperSwig),
            saltyFollySwig = registrate.boozeItemNoExtraEffect(getBundleContentName("salty_folly_swig"), 2, 3600, tankardFoodItem(BnCFoods.SALTY_FOLLY), BundleConsumableItem.RemainderItem.copperSwig),
            steelToeStoutSwig = registrate.boozeItemNoExtraEffect(getBundleContentName("steel_toe_stout_swig"), 3, 2400, tankardFoodItem(BnCFoods.STEEL_TOE_STOUT), BundleConsumableItem.RemainderItem.copperSwig),
            glitteringGrenadineSwig = registrate.boozeItemNoExtraEffect(getBundleContentName("glittering_grenadine_swig"), 1, 2400, tankardFoodItem(BnCFoods.GLITTERING_GRENADINE), BundleConsumableItem.RemainderItem.copperSwig),
            bloodyMarySwig = registrate.boozeItem(getBundleContentName("bloody_mary_swig"), 1, 2400, tankardFoodItem(BnCFoods.BLOODY_MARY), BundleConsumableItem.RemainderItem.copperSwig),
            redRumSwig = registrate.boozeItem(getBundleContentName("red_rum_swig"), 1, 2400, tankardFoodItem(BnCFoods.RED_RUM), BundleConsumableItem.RemainderItem.copperSwig),
            witheringDrossSwig = registrate.boozeItemNoExtraEffect(getBundleContentName("withering_dross_swig"), 3, 3600, tankardFoodItem(BnCFoods.WITHERING_DROSS), BundleConsumableItem.RemainderItem.copperSwig),
            kombuchaSwig = registrate.boozeItemNoExtraEffect(getBundleContentName("kombucha_swig"), 1, 2400, tankardFoodItem(BnCFoods.KOMBUCHA), BundleConsumableItem.RemainderItem.copperSwig),
            rootBeerSwig = registrate.boozeItemNoExtraEffect(getBundleContentName("root_beer_swig"), 1, 2400, tankardFoodItem(BrewinItems.BrewinFoodValues.ROOT_BEER), BundleConsumableItem.RemainderItem.copperSwig);

    public static final ItemEntry<BundleDreadNogItem>
            dreadNogSwig = registrate.dreadNogItem(getBundleContentName("dread_nog_swig"), 3, 4800, tankardFoodItem(BnCFoods.DREAD_NOG), BundleConsumableItem.RemainderItem.copperSwig);


    public static void register() {
        BundledDelight.LOGGER.info("Registering Miner's Brew items");
    }
}
