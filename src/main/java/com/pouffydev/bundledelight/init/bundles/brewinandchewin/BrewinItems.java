package com.pouffydev.bundledelight.init.bundles.brewinandchewin;

import com.pouffydev.bundledelight.BundleDelightCreativeTab;
import com.pouffydev.bundledelight.BundledDelight;
import com.pouffydev.bundledelight.common.elements.item.BundleBoozeItem;
import com.pouffydev.bundledelight.common.elements.item.BundleConsumableItem;
import com.pouffydev.bundledelight.common.elements.item.BundleDreadNogItem;
import com.pouffydev.bundledelight.foundation.BundledRegistrate;
import com.pouffydev.bundledelight.foundation.bundle.BundleRegistryClass;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import umpaz.brewinandchewin.common.registry.BnCEffects;
import umpaz.brewinandchewin.common.registry.BnCFoods;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.registry.ModEffects;

import static com.pouffydev.bundledelight.foundation.BundledRegistrate.tankardFoodItem;
import static com.pouffydev.bundledelight.foundation.BundledRegistrate.tankardFoodItemNoEffect;

public class BrewinItems extends BundleRegistryClass {
    private static final BundledRegistrate registrate = BundledDelight.registrate().setCreativeTab(BundleDelightCreativeTab.MAIN_TAB);
    private static final ResourceLocation sweetHeart = new ResourceLocation("brewinandchewin", "sweet_heart");
    private static final ResourceLocation satisfaction = new ResourceLocation("brewinandchewin", "satisfaction");
    
    public BrewinItems() {
        super("brewinandchewin");
    }
    
    public static final ItemEntry<ConsumableItem>
            cheeseburger = registrate.consumableItem(getBundleContentName("cheeseburger")),
            scarletCheeseburger = registrate.consumableItem(getBundleContentName("scarlet_cheeseburger"));
    
    public static final ItemEntry<Item> glassTankard = registrate.item(getBundleContentName("glass_tankard"), Item::new, p -> p);
    
    public static final ItemEntry<BundleBoozeItem>
            beerGlass = registrate.boozeItemNoExtraEffect(getBundleContentName("beer_glass"), 1, 2400, tankardFoodItemNoEffect(), BundleConsumableItem.RemainderItem.glassTankard),
            vodkaGlass = registrate.boozeItemNoExtraEffect(getBundleContentName("vodka_glass"), 1, 3600, tankardFoodItemNoEffect(), BundleConsumableItem.RemainderItem.glassTankard),
            meadGlass = registrate.boozeItem(getBundleContentName("mead_glass"), 1, 2400, tankardFoodItem(BnCFoods.MEAD), BundleConsumableItem.RemainderItem.glassTankard),
            riceWineGlass = registrate.boozeItemNoExtraEffect(getBundleContentName("rice_wine_glass"), 1, 2400, tankardFoodItem(BnCFoods.RICE_WINE), BundleConsumableItem.RemainderItem.glassTankard),
            eggGrogGlass = registrate.boozeItemNoExtraEffect(getBundleContentName("egg_grog_glass"), 1, 2400, tankardFoodItem(BnCFoods.EGG_GROG), BundleConsumableItem.RemainderItem.glassTankard),
            strongrootAleGlass = registrate.boozeItemNoExtraEffect(getBundleContentName("strongroot_ale_glass"), 2, 2400, tankardFoodItem(BnCFoods.STRONGROOT_ALE), BundleConsumableItem.RemainderItem.glassTankard),
            saccharineRumGlass = registrate.boozeItem(getBundleContentName("saccharine_rum_glass"), 2, 3600, tankardFoodItem(BnCFoods.SACCHARINE_RUM), BundleConsumableItem.RemainderItem.glassTankard),
            paleJaneGlass = registrate.boozeItemNoExtraEffect(getBundleContentName("pale_jane_glass"), 1, 3600, tankardFoodItem(BnCFoods.PALE_JANE), BundleConsumableItem.RemainderItem.glassTankard),
            saltyFollyGlass = registrate.boozeItemNoExtraEffect(getBundleContentName("salty_folly_glass"), 2, 3600, tankardFoodItem(BnCFoods.SALTY_FOLLY), BundleConsumableItem.RemainderItem.glassTankard),
            steelToeStoutGlass = registrate.boozeItemNoExtraEffect(getBundleContentName("steel_toe_stout_glass"), 3, 2400, tankardFoodItem(BnCFoods.STEEL_TOE_STOUT), BundleConsumableItem.RemainderItem.glassTankard),
            glitteringGrenadineGlass = registrate.boozeItemNoExtraEffect(getBundleContentName("glittering_grenadine_glass"), 1, 2400, tankardFoodItem(BnCFoods.GLITTERING_GRENADINE), BundleConsumableItem.RemainderItem.glassTankard),
            bloodyMaryGlass = registrate.boozeItem(getBundleContentName("bloody_mary_glass"), 1, 2400, tankardFoodItem(BnCFoods.BLOODY_MARY), BundleConsumableItem.RemainderItem.glassTankard),
            redRumGlass = registrate.boozeItem(getBundleContentName("red_rum_glass"), 1, 2400, tankardFoodItem(BnCFoods.RED_RUM), BundleConsumableItem.RemainderItem.glassTankard),
            witheringDrossGlass = registrate.boozeItemNoExtraEffect(getBundleContentName("withering_dross_glass"), 3, 3600, tankardFoodItem(BnCFoods.WITHERING_DROSS), BundleConsumableItem.RemainderItem.glassTankard),
            kombuchaGlass = registrate.boozeItemNoExtraEffect(getBundleContentName("kombucha_glass"), 1, 2400, tankardFoodItem(BnCFoods.KOMBUCHA), BundleConsumableItem.RemainderItem.glassTankard),
            rootBeerGlass = registrate.boozeItemNoExtraEffect(getBundleContentName("root_beer_glass"), 1, 2400, tankardFoodItem(BrewinFoodValues.ROOT_BEER), BundleConsumableItem.RemainderItem.glassTankard),
            rootBeer = registrate.boozeItemNoExtraEffect(getBundleContentName("root_beer"), 1, 2400, tankardFoodItem(BrewinFoodValues.ROOT_BEER), BundleConsumableItem.RemainderItem.tankard);
    
    public static final ItemEntry<BundleDreadNogItem>
            dreadNogGlass = registrate.dreadNogItem(getBundleContentName("dread_nog_glass"), 3, 4800, tankardFoodItem(BnCFoods.DREAD_NOG), BundleConsumableItem.RemainderItem.glassTankard);

    public static class BrewinFoodValues {
        public static final FoodProperties ROOT_BEER = (new FoodProperties.Builder())
                .effect(() -> new MobEffectInstance((MobEffect) BnCEffects.TIPSY.get(), 2400, 0), 1.0F)
                .effect(() -> new MobEffectInstance((MobEffect)BnCEffects.INTOXICATION.get(), 1800, 0), 1.0F)
                .alwaysEat().build();
    }
    
    public static void register() {
        BundledDelight.LOGGER.info("Registering Brewin Items");
    }
}
