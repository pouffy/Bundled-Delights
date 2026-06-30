package com.pouffydev.bundledelight.init.bundles.brewinandchewin;

import com.pouffydev.bundledelight.BundledDelight;
import com.pouffydev.bundledelight.common.elements.item.BundleBoozeItem;
import com.pouffydev.bundledelight.common.elements.item.BundleConsumableItem;
import com.pouffydev.bundledelight.common.elements.item.BundleDreadNogItem;
import com.pouffydev.bundledelight.foundation.BDItemHelper;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import umpaz.brewinandchewin.common.registry.BnCEffects;
import umpaz.brewinandchewin.common.registry.BnCFoods;

import static com.pouffydev.bundledelight.foundation.BundledRegistrate.tankardFoodItem;
import static com.pouffydev.bundledelight.foundation.BundledRegistrate.tankardFoodItemNoEffect;

public class BrewinItems {
    private static final BDItemHelper HELPER = new BDItemHelper(BundledDelight.getRegistryHelper().getItemHelper());
    
    public static final DeferredItem<BundleConsumableItem>
            cheeseburger = HELPER.consumableItem("cheeseburger"),
            scarletCheeseburger = HELPER.consumableItem("scarlet_cheeseburger");
    
    public static final DeferredItem<Item> glassTankard = HELPER.register("glass_tankard", () -> new Item(new Item.Properties()));
    
    public static final DeferredItem<BundleBoozeItem>
            beerGlass = HELPER.boozeItemNoExtraEffect("beer_glass", 1, 2400, tankardFoodItemNoEffect(), BundleConsumableItem.RemainderItem.glassTankard),
            vodkaGlass = HELPER.boozeItemNoExtraEffect("vodka_glass", 1, 3600, tankardFoodItemNoEffect(), BundleConsumableItem.RemainderItem.glassTankard),
            meadGlass = HELPER.boozeItem("mead_glass", 1, 2400, tankardFoodItem(BnCFoods.MEAD), BundleConsumableItem.RemainderItem.glassTankard),
            riceWineGlass = HELPER.boozeItemNoExtraEffect("rice_wine_glass", 1, 2400, tankardFoodItem(BnCFoods.RICE_WINE), BundleConsumableItem.RemainderItem.glassTankard),
            eggGrogGlass = HELPER.boozeItemNoExtraEffect("egg_grog_glass", 1, 2400, tankardFoodItem(BnCFoods.EGG_GROG), BundleConsumableItem.RemainderItem.glassTankard),
            strongrootAleGlass = HELPER.boozeItemNoExtraEffect("strongroot_ale_glass", 2, 2400, tankardFoodItem(BnCFoods.STRONGROOT_ALE), BundleConsumableItem.RemainderItem.glassTankard),
            saccharineRumGlass = HELPER.boozeItem("saccharine_rum_glass", 2, 3600, tankardFoodItem(BnCFoods.SACCHARINE_RUM), BundleConsumableItem.RemainderItem.glassTankard),
            paleJaneGlass = HELPER.boozeItemNoExtraEffect("pale_jane_glass", 1, 3600, tankardFoodItem(BnCFoods.PALE_JANE), BundleConsumableItem.RemainderItem.glassTankard),
            saltyFollyGlass = HELPER.boozeItemNoExtraEffect("salty_folly_glass", 2, 3600, tankardFoodItem(BnCFoods.SALTY_FOLLY), BundleConsumableItem.RemainderItem.glassTankard),
            steelToeStoutGlass = HELPER.boozeItemNoExtraEffect("steel_toe_stout_glass", 3, 2400, tankardFoodItem(BnCFoods.STEEL_TOE_STOUT), BundleConsumableItem.RemainderItem.glassTankard),
            glitteringGrenadineGlass = HELPER.boozeItemNoExtraEffect("glittering_grenadine_glass", 1, 2400, tankardFoodItem(BnCFoods.GLITTERING_GRENADINE), BundleConsumableItem.RemainderItem.glassTankard),
            bloodyMaryGlass = HELPER.boozeItem("bloody_mary_glass", 1, 2400, tankardFoodItem(BnCFoods.BLOODY_MARY), BundleConsumableItem.RemainderItem.glassTankard),
            redRumGlass = HELPER.boozeItem("red_rum_glass", 1, 2400, tankardFoodItem(BnCFoods.RED_RUM), BundleConsumableItem.RemainderItem.glassTankard),
            witheringDrossGlass = HELPER.boozeItemNoExtraEffect("withering_dross_glass", 3, 3600, tankardFoodItem(BnCFoods.WITHERING_DROSS), BundleConsumableItem.RemainderItem.glassTankard),
            kombuchaGlass = HELPER.boozeItemNoExtraEffect("kombucha_glass", 1, 2400, tankardFoodItem(BnCFoods.KOMBUCHA), BundleConsumableItem.RemainderItem.glassTankard),
            rootBeerGlass = HELPER.boozeItemNoExtraEffect("root_beer_glass", 1, 2400, tankardFoodItem(BrewinFoodValues.ROOT_BEER), BundleConsumableItem.RemainderItem.glassTankard),
            rootBeer = HELPER.boozeItemNoExtraEffect("root_beer", 1, 2400, tankardFoodItem(BrewinFoodValues.ROOT_BEER), BundleConsumableItem.RemainderItem.tankard);
    
    public static final DeferredItem<BundleDreadNogItem>
            dreadNogGlass = HELPER.dreadNogItem("dread_nog_glass", 3, 4800, tankardFoodItem(BnCFoods.DREAD_NOG), BundleConsumableItem.RemainderItem.glassTankard);

    public static class BrewinFoodValues {
        public static final FoodProperties ROOT_BEER = (new FoodProperties.Builder())
                .effect(() -> new MobEffectInstance(BnCEffects.TIPSY, 2400, 0), 1.0F)
                .effect(() -> new MobEffectInstance(BnCEffects.INTOXICATION, 1800, 0), 1.0F)
                .alwaysEdible().build();
    }
    
    public static void register() {
        BundledDelight.LOGGER.info("Registering Brewin Items");
    }
}
