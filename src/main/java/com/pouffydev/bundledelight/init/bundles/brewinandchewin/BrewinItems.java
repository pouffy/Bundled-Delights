package com.pouffydev.bundledelight.init.bundles.brewinandchewin;

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
    private static final BundledRegistrate registrate = BundledDelight.registrate().creativeModeTab(() -> BundledDelight.itemGroup);
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
            beerGlass = registrate.boozeItemNoExtraEffect(getBundleContentName("beer_glass"), 1, 8, tankardFoodItemNoEffect(), BundleConsumableItem.RemainderItem.glassTankard),
            vodkaGlass = registrate.boozeItemNoExtraEffect(getBundleContentName("vodka_glass"), 1, 12, tankardFoodItemNoEffect(), BundleConsumableItem.RemainderItem.glassTankard),
            meadGlass = registrate.boozeItem(getBundleContentName("mead_glass"), 1, 8, tankardFoodItem(BrewinFoodValues.MEAD), BundleBoozeItem.Effect.Sweet_Heart, 6000, 0, BundleConsumableItem.RemainderItem.glassTankard),
            riceWineGlass = registrate.boozeItem(getBundleContentName("rice_wine_glass"), 1, 5, tankardFoodItem(BrewinFoodValues.RICE_WINE), BundleBoozeItem.Effect.Satisfaction, 6000, 0, BundleConsumableItem.RemainderItem.glassTankard),
            eggGrogGlass = registrate.boozeItemNoExtraEffect(getBundleContentName("egg_grog_glass"), 1, 0, tankardFoodItem(BrewinFoodValues.EGG_GROG), BundleConsumableItem.RemainderItem.glassTankard),
            strongrootAleGlass = registrate.boozeItemNoExtraEffect(getBundleContentName("strongroot_ale_glass"), 2, 12, tankardFoodItem(BrewinFoodValues.STRONGROOT_ALE), BundleConsumableItem.RemainderItem.glassTankard),
            saccharineRumGlass = registrate.boozeItem(getBundleContentName("saccharine_rum_glass"), 2, 8, tankardFoodItem(BrewinFoodValues.SACCHARINE_RUM), BundleBoozeItem.Effect.Sweet_Heart, 9600, 1, BundleConsumableItem.RemainderItem.glassTankard),
            paleJaneGlass = registrate.boozeItem(getBundleContentName("pale_jane_glass"), 1, 5, tankardFoodItem(BrewinFoodValues.PALE_JANE), BundleBoozeItem.Effect.Satisfaction, 9600, 1, BundleConsumableItem.RemainderItem.glassTankard),
            saltyFollyGlass = registrate.boozeItemNoExtraEffect(getBundleContentName("salty_folly_glass"), 2, 10, tankardFoodItem(BrewinFoodValues.SALTY_FOLLY), BundleConsumableItem.RemainderItem.glassTankard),
            steelToeStoutGlass = registrate.boozeItemNoExtraEffect(getBundleContentName("steel_toe_stout_glass"), 3, 10, tankardFoodItem(BrewinFoodValues.STEEL_TOE_STOUT), BundleConsumableItem.RemainderItem.glassTankard),
            glitteringGrenadineGlass = registrate.boozeItemNoExtraEffect(getBundleContentName("glittering_grenadine_glass"), 1, 5, tankardFoodItem(BrewinFoodValues.GLITTERING_GRENADINE), BundleConsumableItem.RemainderItem.glassTankard),
            bloodyMaryGlass = registrate.boozeItemNoExtraEffect(getBundleContentName("bloody_mary_glass"), 1, 12, tankardFoodItem(BrewinFoodValues.BLOODY_MARY), BundleConsumableItem.RemainderItem.glassTankard),
            redRumGlass = registrate.boozeItemNoExtraEffect(getBundleContentName("red_rum_glass"), 1, 18, tankardFoodItem(BrewinFoodValues.RED_RUM), BundleConsumableItem.RemainderItem.glassTankard),
            witheringDrossGlass = registrate.boozeItemNoExtraEffect(getBundleContentName("withering_dross_glass"), 3, 20, tankardFoodItem(BrewinFoodValues.WITHERING_DROSS), BundleConsumableItem.RemainderItem.glassTankard),
            kombuchaGlass = registrate.boozeItem(getBundleContentName("kombucha_glass"), 1, 5, tankardFoodItem(BrewinFoodValues.KOMBUCHA), BundleBoozeItem.Effect.Satisfaction, 3600, 0, BundleConsumableItem.RemainderItem.glassTankard),
            rootBeerGlass = registrate.boozeItemNoExtraEffect(getBundleContentName("root_beer_glass"), 1, 8, tankardFoodItemNoEffect(), BundleConsumableItem.RemainderItem.glassTankard),
            rootBeer = registrate.boozeItemNoExtraEffect(getBundleContentName("root_beer"), 1, 8, tankardFoodItemNoEffect(), BundleConsumableItem.RemainderItem.tankard);
    
    public static final ItemEntry<BundleDreadNogItem>
            dreadNogGlass = registrate.dreadNogItem(getBundleContentName("dread_nog_glass"), 3, 5, tankardFoodItemNoEffect(), BundleConsumableItem.RemainderItem.glassTankard);

    public static class BrewinFoodValues {
        public static final FoodProperties MEAD = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.1F).alwaysEat().build();
        public static final FoodProperties RICE_WINE = (new FoodProperties.Builder()).alwaysEat().build();
        public static final FoodProperties EGG_GROG = (new FoodProperties.Builder()).effect(() -> {
            return new MobEffectInstance(MobEffects.ABSORPTION, 3600, 0);
        }, 1.0F).alwaysEat().build();
        public static final FoodProperties STRONGROOT_ALE = (new FoodProperties.Builder()).effect(() -> {
            return new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6000, 0);
        }, 1.0F).alwaysEat().build();
        public static final FoodProperties SACCHARINE_RUM = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.1F).alwaysEat().build();
        public static final FoodProperties PALE_JANE = (new FoodProperties.Builder()).alwaysEat().build();
        public static final FoodProperties SALTY_FOLLY = (new FoodProperties.Builder()).effect(() -> {
            return new MobEffectInstance(MobEffects.WATER_BREATHING, 9600, 0);
        }, 1.0F).alwaysEat().build();
        public static final FoodProperties STEEL_TOE_STOUT = (new FoodProperties.Builder()).effect(() -> {
            return new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 12000, 1);
        }, 1.0F).alwaysEat().build();
        public static final FoodProperties GLITTERING_GRENADINE = (new FoodProperties.Builder()).effect(() -> {
            return new MobEffectInstance(MobEffects.GLOWING, 12000, 0);
        }, 1.0F).effect(() -> {
            return new MobEffectInstance(MobEffects.NIGHT_VISION, 12000, 0);
        }, 1.0F).alwaysEat().build();
        public static final FoodProperties BLOODY_MARY = (new FoodProperties.Builder()).effect(() -> {
            return new MobEffectInstance((MobEffect) ModEffects.COMFORT.get(), 6000, 0);
        }, 1.0F).alwaysEat().build();
        public static final FoodProperties RED_RUM = (new FoodProperties.Builder()).effect(() -> {
            return new MobEffectInstance((MobEffect)ModEffects.COMFORT.get(), 9600, 1);
        }, 1.0F).alwaysEat().build();
        public static final FoodProperties WITHERING_DROSS = (new FoodProperties.Builder()).effect(() -> {
            return new MobEffectInstance(MobEffects.BLINDNESS, 12000, 0);
        }, 0.75F).effect(() -> {
            return new MobEffectInstance(MobEffects.WEAKNESS, 12000, 0);
        }, 0.75F).effect(() -> {
            return new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 12000, 0);
        }, 0.75F).effect(() -> {
            return new MobEffectInstance(MobEffects.WITHER, 12000, 0);
        }, 1.0F).alwaysEat().build();
        public static final FoodProperties KOMBUCHA = (new FoodProperties.Builder()).effect(() -> {
            return new MobEffectInstance(MobEffects.DIG_SPEED, 6000, 0);
        }, 1.0F).alwaysEat().build();
        public static final FoodProperties KIMCHI = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.6F).build();
    }
    
    public static void register() {
        BundledDelight.LOGGER.info("Registering Brewin Items");
    }
}
