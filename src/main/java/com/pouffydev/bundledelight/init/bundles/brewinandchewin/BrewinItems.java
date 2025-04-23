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
            beerGlass = registrate.boozeItemNoExtraEffect(getBundleContentName("beer_glass"), 1, 2400, 1800, tankardFoodItemNoEffect(), BundleConsumableItem.RemainderItem.glassTankard),
            vodkaGlass = registrate.boozeItemNoExtraEffect(getBundleContentName("vodka_glass"), 1, 3600, 3000, tankardFoodItemNoEffect(), BundleConsumableItem.RemainderItem.glassTankard),
            meadGlass = registrate.boozeItem(getBundleContentName("mead_glass"), 1, 2400, tankardFoodItem(BrewinFoodValues.MEAD), BundleBoozeItem.Effect.Sweet_Heart, 2400, 0, 1800, BundleConsumableItem.RemainderItem.glassTankard),
            riceWineGlass = registrate.boozeItemNoExtraEffect(getBundleContentName("rice_wine_glass"), 1, 2400, 1800, tankardFoodItem(BrewinFoodValues.RICE_WINE), BundleConsumableItem.RemainderItem.glassTankard),
            eggGrogGlass = registrate.boozeItemNoExtraEffect(getBundleContentName("egg_grog_glass"), 1, 2400, 1800, tankardFoodItem(BrewinFoodValues.EGG_GROG), BundleConsumableItem.RemainderItem.glassTankard),
            strongrootAleGlass = registrate.boozeItemNoExtraEffect(getBundleContentName("strongroot_ale_glass"), 2, 2400, 1800, tankardFoodItem(BrewinFoodValues.STRONGROOT_ALE), BundleConsumableItem.RemainderItem.glassTankard),
            saccharineRumGlass = registrate.boozeItem(getBundleContentName("saccharine_rum_glass"), 2, 3600, tankardFoodItem(BrewinFoodValues.SACCHARINE_RUM), BundleBoozeItem.Effect.Sweet_Heart, 3600, 1, 2400, BundleConsumableItem.RemainderItem.glassTankard),
            paleJaneGlass = registrate.boozeItemNoExtraEffect(getBundleContentName("pale_jane_glass"), 1, 3600, 3000, tankardFoodItem(BrewinFoodValues.PALE_JANE), BundleConsumableItem.RemainderItem.glassTankard),
            saltyFollyGlass = registrate.boozeItemNoExtraEffect(getBundleContentName("salty_folly_glass"), 2, 3600, 3000, tankardFoodItem(BrewinFoodValues.SALTY_FOLLY), BundleConsumableItem.RemainderItem.glassTankard),
            steelToeStoutGlass = registrate.boozeItemNoExtraEffect(getBundleContentName("steel_toe_stout_glass"), 3, 2400, 1800, tankardFoodItem(BrewinFoodValues.STEEL_TOE_STOUT), BundleConsumableItem.RemainderItem.glassTankard),
            glitteringGrenadineGlass = registrate.boozeItemNoExtraEffect(getBundleContentName("glittering_grenadine_glass"), 1, 2400, 1800, tankardFoodItem(BrewinFoodValues.GLITTERING_GRENADINE), BundleConsumableItem.RemainderItem.glassTankard),
            bloodyMaryGlass = registrate.boozeItem(getBundleContentName("bloody_mary_glass"), 1, 2400, tankardFoodItem(BrewinFoodValues.BLOODY_MARY), BundleBoozeItem.Effect.Raging, 1200, 0, 1800, BundleConsumableItem.RemainderItem.glassTankard),
            redRumGlass = registrate.boozeItem(getBundleContentName("red_rum_glass"), 1, 2400, tankardFoodItem(BrewinFoodValues.RED_RUM), BundleBoozeItem.Effect.Raging, 2400, 0, 1800, BundleConsumableItem.RemainderItem.glassTankard),
            witheringDrossGlass = registrate.boozeItemNoExtraEffect(getBundleContentName("withering_dross_glass"), 3, 3600, 3000, tankardFoodItem(BrewinFoodValues.WITHERING_DROSS), BundleConsumableItem.RemainderItem.glassTankard),
            kombuchaGlass = registrate.boozeItemNoExtraEffect(getBundleContentName("kombucha_glass"), 1, 2400, 1800, tankardFoodItem(BrewinFoodValues.KOMBUCHA), BundleConsumableItem.RemainderItem.glassTankard),
            rootBeerGlass = registrate.boozeItemNoExtraEffect(getBundleContentName("root_beer_glass"), 1, 2400, 1800, tankardFoodItemNoEffect(), BundleConsumableItem.RemainderItem.glassTankard),
            rootBeer = registrate.boozeItemNoExtraEffect(getBundleContentName("root_beer"), 1, 2400, 1800, tankardFoodItemNoEffect(), BundleConsumableItem.RemainderItem.tankard);
    
    public static final ItemEntry<BundleDreadNogItem>
            dreadNogGlass = registrate.dreadNogItem(getBundleContentName("dread_nog_glass"), 3, 4800, tankardFoodItemNoEffect(), BundleConsumableItem.RemainderItem.glassTankard);

    public static class BrewinFoodValues {
        public static final FoodProperties MEAD = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.1F).alwaysEat().build();
        public static final FoodProperties RICE_WINE = (new FoodProperties.Builder()).effect(() -> {
            return new MobEffectInstance(ModEffects.COMFORT.get(), 1200, 0);
        }, 1.0F).alwaysEat().build();
        public static final FoodProperties EGG_GROG = (new FoodProperties.Builder()).effect(() -> {
            return new MobEffectInstance(MobEffects.ABSORPTION, 3600, 0);
        }, 1.0F).alwaysEat().build();
        public static final FoodProperties STRONGROOT_ALE = (new FoodProperties.Builder()).effect(() -> {
            return new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600, 0);
        }, 1.0F).alwaysEat().build();
        public static final FoodProperties SACCHARINE_RUM = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.1F).alwaysEat().build();
        public static final FoodProperties PALE_JANE = (new FoodProperties.Builder()).effect(() -> {
            return new MobEffectInstance(ModEffects.COMFORT.get(), 2400, 0);
        }, 1.0F).alwaysEat().build();
        public static final FoodProperties SALTY_FOLLY = (new FoodProperties.Builder()).effect(() -> {
            return new MobEffectInstance(MobEffects.WATER_BREATHING, 1800, 0);
        }, 1.0F).alwaysEat().build();
        public static final FoodProperties STEEL_TOE_STOUT = (new FoodProperties.Builder()).effect(() -> {
            return new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1200, 1);
        }, 1.0F).alwaysEat().build();
        public static final FoodProperties GLITTERING_GRENADINE = (new FoodProperties.Builder()).effect(() -> {
            return new MobEffectInstance(MobEffects.GLOWING, 600, 0);
        }, 1.0F).effect(() -> {
            return new MobEffectInstance(MobEffects.NIGHT_VISION, 600, 0);
        }, 1.0F).alwaysEat().build();
        public static final FoodProperties BLOODY_MARY = (new FoodProperties.Builder()).alwaysEat().build();
        public static final FoodProperties RED_RUM = (new FoodProperties.Builder()).alwaysEat().build();
        public static final FoodProperties WITHERING_DROSS = (new FoodProperties.Builder()).effect(() -> {
            return new MobEffectInstance(MobEffects.BLINDNESS, 200, 0);
        }, 1.0F).effect(() -> {
            return new MobEffectInstance(MobEffects.WEAKNESS, 3000, 0);
        }, 1.0F).effect(() -> {
            return new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 3000, 0);
        }, 1.0F).effect(() -> {
            return new MobEffectInstance(MobEffects.WITHER, 1200, 0);
        }, 1.0F).alwaysEat().build();
        public static final FoodProperties KOMBUCHA = (new FoodProperties.Builder()).effect(() -> {
            return new MobEffectInstance(MobEffects.DIG_SPEED, 1200, 1);
        }, 1.0F).alwaysEat().build();
        public static final FoodProperties KIMCHI = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.6F).build();
    }
    
    public static void register() {
        BundledDelight.LOGGER.info("Registering Brewin Items");
    }
}
