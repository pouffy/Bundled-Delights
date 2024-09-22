package com.pouffydev.bundledelight.init.bundles.brewinandchewin;

import com.pouffydev.bundledelight.BundledDelight;
import com.pouffydev.bundledelight.common.elements.item.BundleBoozeItem;
import com.pouffydev.bundledelight.common.elements.item.BundleDreadNogItem;
import com.pouffydev.bundledelight.foundation.BundledRegistrate;
import com.pouffydev.bundledelight.foundation.bundle.BundleRegistryClass;
import com.pouffydev.bundledelight.foundation.util.ConsumptionEffect;
import com.pouffydev.bundledelight.init.FoodValues;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import vectorwing.farmersdelight.common.item.ConsumableItem;

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
            beerGlass = registrate.boozeItemNoExtraEffect(getBundleContentName("beer_glass"), 1, 8, glassTankardFoodItemNoEffect()),
            vodkaGlass = registrate.boozeItemNoExtraEffect(getBundleContentName("vodka_glass"), 1, 12, glassTankardFoodItemNoEffect()),
            meadGlass = registrate.boozeItem(getBundleContentName("mead_glass"), 1, 8, glassTankardFoodItem(FoodValues.MEAD), sweetHeart, 6000, 0),
            riceWineGlass = registrate.boozeItem(getBundleContentName("rice_wine_glass"), 1, 5, glassTankardFoodItem(FoodValues.RICE_WINE), satisfaction, 6000, 0),
            eggGrogGlass = registrate.boozeItemNoExtraEffect(getBundleContentName("egg_grog_glass"), 1, 0, glassTankardFoodItem(FoodValues.EGG_GROG)),
            strongrootAleGlass = registrate.boozeItemNoExtraEffect(getBundleContentName("strongroot_ale_glass"), 2, 12, glassTankardFoodItem(FoodValues.STRONGROOT_ALE)),
            saccharineRumGlass = registrate.boozeItem(getBundleContentName("saccharine_rum_glass"), 2, 8, glassTankardFoodItem(FoodValues.SACCHARINE_RUM), sweetHeart, 9600, 1),
            paleJaneGlass = registrate.boozeItem(getBundleContentName("pale_jane_glass"), 1, 5, glassTankardFoodItem(FoodValues.PALE_JANE), satisfaction, 9600, 1),
            saltyFollyGlass = registrate.boozeItemNoExtraEffect(getBundleContentName("salty_folly_glass"), 2, 10, glassTankardFoodItem(FoodValues.SALTY_FOLLY)),
            steelToeStoutGlass = registrate.boozeItemNoExtraEffect(getBundleContentName("steel_toe_stout_glass"), 3, 10, glassTankardFoodItem(FoodValues.STEEL_TOE_STOUT)),
            glitteringGrenadineGlass = registrate.boozeItemNoExtraEffect(getBundleContentName("glittering_grenadine_glass"), 1, 5, glassTankardFoodItem(FoodValues.GLITTERING_GRENADINE)),
            bloodyMaryGlass = registrate.boozeItemNoExtraEffect(getBundleContentName("bloody_mary_glass"), 1, 12, glassTankardFoodItem(FoodValues.BLOODY_MARY)),
            redRumGlass = registrate.boozeItemNoExtraEffect(getBundleContentName("red_rum_glass"), 1, 18, glassTankardFoodItem(FoodValues.RED_RUM)),
            witheringDrossGlass = registrate.boozeItemNoExtraEffect(getBundleContentName("withering_dross_glass"), 3, 20, glassTankardFoodItem(FoodValues.WITHERING_DROSS));
            //kombuchaGlass = registrate.boozeItem(getBundleContentName("kombucha_glass"), 1, 5, glassTankardFoodItem(FoodValues.KOMBUCHA));
    
    public static final ItemEntry<BundleDreadNogItem>
            dreadNogGlass = registrate.dreadNogItem(getBundleContentName("dread_nog_glass"), 3, 5, glassTankardFoodItemNoEffect());
    
    
    
    public static void register() {
        BundledDelight.LOGGER.info("Registering Brewin Items");
    }
}
