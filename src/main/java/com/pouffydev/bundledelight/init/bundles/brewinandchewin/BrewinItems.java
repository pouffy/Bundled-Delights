package com.pouffydev.bundledelight.init.bundles.brewinandchewin;

import com.pouffydev.bundledelight.BundledDelight;
import com.pouffydev.bundledelight.common.elements.item.BundleBoozeItem;
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

import static com.pouffydev.bundledelight.foundation.BundledRegistrate.glassTankardFoodItem;
import static com.pouffydev.bundledelight.foundation.BundledRegistrate.glassTankardFoodItemNoEffect;

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
            beerGlass = registrate.boozeItemNoExtraEffect(getBundleContentName("beer_glass"), 1, 8, glassTankardFoodItemNoEffect(), true),
            vodkaGlass = registrate.boozeItemNoExtraEffect(getBundleContentName("vodka_glass"), 1, 12, glassTankardFoodItemNoEffect(), true),
            meadGlass = registrate.boozeItem(getBundleContentName("mead_glass"), 1, 8, glassTankardFoodItem(BrewinFoodValues.MEAD), BundleBoozeItem.Effect.Sweet_Heart, 6000, 0, true),
            riceWineGlass = registrate.boozeItem(getBundleContentName("rice_wine_glass"), 1, 5, glassTankardFoodItem(BrewinFoodValues.RICE_WINE), BundleBoozeItem.Effect.Satisfaction, 6000, 0, true),
            eggGrogGlass = registrate.boozeItemNoExtraEffect(getBundleContentName("egg_grog_glass"), 1, 0, glassTankardFoodItem(BrewinFoodValues.EGG_GROG), true),
            strongrootAleGlass = registrate.boozeItemNoExtraEffect(getBundleContentName("strongroot_ale_glass"), 2, 12, glassTankardFoodItem(BrewinFoodValues.STRONGROOT_ALE), true),
            saccharineRumGlass = registrate.boozeItem(getBundleContentName("saccharine_rum_glass"), 2, 8, glassTankardFoodItem(BrewinFoodValues.SACCHARINE_RUM), BundleBoozeItem.Effect.Sweet_Heart, 9600, 1, true),
            paleJaneGlass = registrate.boozeItem(getBundleContentName("pale_jane_glass"), 1, 5, glassTankardFoodItem(BrewinFoodValues.PALE_JANE), BundleBoozeItem.Effect.Satisfaction, 9600, 1, true),
            saltyFollyGlass = registrate.boozeItemNoExtraEffect(getBundleContentName("salty_folly_glass"), 2, 10, glassTankardFoodItem(BrewinFoodValues.SALTY_FOLLY), true),
            steelToeStoutGlass = registrate.boozeItemNoExtraEffect(getBundleContentName("steel_toe_stout_glass"), 3, 10, glassTankardFoodItem(BrewinFoodValues.STEEL_TOE_STOUT), true),
            glitteringGrenadineGlass = registrate.boozeItemNoExtraEffect(getBundleContentName("glittering_grenadine_glass"), 1, 5, glassTankardFoodItem(BrewinFoodValues.GLITTERING_GRENADINE), true),
            bloodyMaryGlass = registrate.boozeItemNoExtraEffect(getBundleContentName("bloody_mary_glass"), 1, 12, glassTankardFoodItem(BrewinFoodValues.BLOODY_MARY), true),
            redRumGlass = registrate.boozeItemNoExtraEffect(getBundleContentName("red_rum_glass"), 1, 18, glassTankardFoodItem(BrewinFoodValues.RED_RUM), true),
            witheringDrossGlass = registrate.boozeItemNoExtraEffect(getBundleContentName("withering_dross_glass"), 3, 20, glassTankardFoodItem(BrewinFoodValues.WITHERING_DROSS), true);
            //kombuchaGlass = registrate.boozeItem(getBundleContentName("kombucha_glass"), 1, 5, glassTankardFoodItem(FoodValues.KOMBUCHA));
    
    public static final ItemEntry<BundleDreadNogItem>
            dreadNogGlass = registrate.dreadNogItem(getBundleContentName("dread_nog_glass"), 3, 5, glassTankardFoodItemNoEffect(), true);

    public class BrewinFoodValues {
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
