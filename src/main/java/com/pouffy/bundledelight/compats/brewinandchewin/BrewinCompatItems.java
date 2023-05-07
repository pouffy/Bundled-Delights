package com.pouffy.bundledelight.compats.brewinandchewin;

import com.brewinandchewin.common.item.BoozeItem;
import com.brewinandchewin.core.registry.BCItems;
import com.brewinandchewin.core.utility.BCFoods;
import com.pouffy.bundledelight.BundledDelights;
import com.pouffy.bundledelight.content.food.FoodValues;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.pouffy.bundledelight.util.ItemRegistryUtils.*;
import static com.pouffy.bundledelight.util.ItemRegistryUtils.glassTankardFoodItemNoEffect;


public class BrewinCompatItems {
    public static final DeferredRegister<Item> ITEMS;
    public static final RegistryObject<Item> CHEESEBURGER;
    public static final RegistryObject<Item> SCARLET_CHEESEBURGER;
    public static final RegistryObject<Item> RADIANT_BREW;
    public static final RegistryObject<Item> ROOT_BEER;
    public static final RegistryObject<Item> GLASS_TANKARD;
    public static final RegistryObject<Item> BEER_GLASS;
    public static final RegistryObject<Item> VODKA_GLASS;
    public static final RegistryObject<Item> MEAD_GLASS;
    public static final RegistryObject<Item> RICE_WINE_GLASS;
    public static final RegistryObject<Item> EGG_GROG_GLASS;
    public static final RegistryObject<Item> STRONGROOT_ALE_GLASS;
    public static final RegistryObject<Item> SACCHARINE_RUM_GLASS;
    public static final RegistryObject<Item> PALE_JANE_GLASS;
    public static final RegistryObject<Item> DREAD_NOG_GLASS;
    public static final RegistryObject<Item> SALTY_FOLLY_GLASS;
    public static final RegistryObject<Item> STEEL_TOE_STOUT_GLASS;
    public static final RegistryObject<Item> GLITTERING_GRENADINE_GLASS;
    public static final RegistryObject<Item> BLOODY_MARY_GLASS;
    public static final RegistryObject<Item> RED_RUM_GLASS;
    public static final RegistryObject<Item> WITHERING_DROSS_GLASS;
    public static final RegistryObject<Item> KOMBUCHA_GLASS;
    public static final RegistryObject<Item> RADIANT_BREW_GLASS;
    public static final RegistryObject<Item> ROOT_BEER_GLASS;

    public BrewinCompatItems() {}

    static {
        ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "bundledelight");

        CHEESEBURGER = ITEMS.register("cheeseburger", () -> {
            return new Item(foodItem(FoodValues.CHEESEBURGER));
        });
        SCARLET_CHEESEBURGER = ITEMS.register("scarlet_cheeseburger", () -> {
            return new Item(foodItem(FoodValues.CHEESEBURGER));
        });
        RADIANT_BREW = ITEMS.register("radiant_brew", () -> {
            return new BoozeItem(1, 6, new Item.Properties().food(FoodValues.RADIANT_BREW).craftRemainder(BCItems.TANKARD.get()).stacksTo(16).tab(BundledDelights.CREATIVE_TAB));
        });
        ROOT_BEER = ITEMS.register("root_beer", () -> {
            return new BoozeItem(2, 8, new Item.Properties().craftRemainder(BCItems.TANKARD.get()).stacksTo(16).tab(BundledDelights.CREATIVE_TAB));
        });
        GLASS_TANKARD = ITEMS.register("glass_tankard", () -> {
            return new Item(singleItem());
        });
        BEER_GLASS = ITEMS.register("beer_glass", () -> {
            return new BoozeItem(1, 8, glassTankardFoodItemNoEffect());
        });
        VODKA_GLASS = ITEMS.register("vodka_glass", () -> {
            return new BoozeItem(1, 12, glassTankardFoodItemNoEffect());
        });
        MEAD_GLASS = ITEMS.register("mead_glass", () -> {
            return new BoozeItem(1, 8, glassTankardFoodItem(BCFoods.MEAD));
        });
        RICE_WINE_GLASS = ITEMS.register("rice_wine_glass", () -> {
            return new BoozeItem(1, 5, glassTankardFoodItem(BCFoods.RICE_WINE));
        });
        EGG_GROG_GLASS = ITEMS.register("egg_grog_glass", () -> {
            return new BoozeItem(1, 0, glassTankardFoodItem(BCFoods.EGG_GROG));
        });
        STRONGROOT_ALE_GLASS = ITEMS.register("strongroot_ale_glass", () -> {
            return new BoozeItem(2, 12, glassTankardFoodItem(BCFoods.STRONGROOT_ALE));
        });
        SACCHARINE_RUM_GLASS = ITEMS.register("saccharine_rum_glass", () -> {
            return new BoozeItem(2, 8, glassTankardFoodItem(BCFoods.SACCHARINE_RUM));
        });
        PALE_JANE_GLASS = ITEMS.register("pale_jane_glass", () -> {
            return new BoozeItem(1, 5, glassTankardFoodItem(BCFoods.PALE_JANE));
        });
        DREAD_NOG_GLASS = ITEMS.register("dread_nog_glass", () -> {
            return new BundledDreadNogItem(3, 5, glassTankardFoodItemNoEffect());
        });
        SALTY_FOLLY_GLASS = ITEMS.register("salty_folly_glass", () -> {
            return new BoozeItem(2, 10, glassTankardFoodItem(BCFoods.SALTY_FOLLY));
        });
        STEEL_TOE_STOUT_GLASS = ITEMS.register("steel_toe_stout_glass", () -> {
            return new BoozeItem(3, 10, glassTankardFoodItem(BCFoods.STEEL_TOE_STOUT));
        });
        GLITTERING_GRENADINE_GLASS = ITEMS.register("glittering_grenadine_glass", () -> {
            return new BoozeItem(1, 5, glassTankardFoodItem(BCFoods.GLITTERING_GRENADINE));
        });
        BLOODY_MARY_GLASS = ITEMS.register("bloody_mary_glass", () -> {
            return new BoozeItem(1, 12, glassTankardFoodItem(BCFoods.BLOODY_MARY));
        });
        RED_RUM_GLASS = ITEMS.register("red_rum_glass", () -> {
            return new BoozeItem(1, 18, glassTankardFoodItem(BCFoods.RED_RUM));
        });
        WITHERING_DROSS_GLASS = ITEMS.register("withering_dross_glass", () -> {
            return new BoozeItem(3, 20, glassTankardFoodItem(BCFoods.WITHERING_DROSS));
        });
        KOMBUCHA_GLASS = ITEMS.register("kombucha_glass", () -> {
            return new BoozeItem(1, 5, glassTankardFoodItem(BCFoods.KOMBUHCA));
        });
        RADIANT_BREW_GLASS = ITEMS.register("radiant_brew_glass", () -> {
            return new BoozeItem(1, 6, glassTankardFoodItem(FoodValues.RADIANT_BREW));
        });
        ROOT_BEER_GLASS = ITEMS.register("root_beer_glass", () -> {
            return new BoozeItem(2, 8, glassTankardFoodItemNoEffect());
        });

    }
}
