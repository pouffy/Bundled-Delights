package com.pouffydev.bundledelight.compat.brewinandchewin;

import com.pouffydev.bundledelight.content.food.FoodValues;
import com.pouffydev.bundledelight.content.item.BundleBoozeItem;
import com.pouffydev.bundledelight.content.item.BundleDreadNogItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.pouffydev.bundledelight.foundation.util.ItemRegistryUtils.*;


public class BrewinMDCompatItems {
    public static final DeferredRegister<Item> ITEMS;


    public static final RegistryObject<Item> COPPER_TANKARD;
    public static final RegistryObject<Item> BEER_SWIG;
    public static final RegistryObject<Item> VODKA_SWIG;
    public static final RegistryObject<Item> MEAD_SWIG;
    public static final RegistryObject<Item> RICE_WINE_SWIG;
    public static final RegistryObject<Item> EGG_GROG_SWIG;
    public static final RegistryObject<Item> STRONGROOT_ALE_SWIG;
    public static final RegistryObject<Item> SACCHARINE_RUM_SWIG;
    public static final RegistryObject<Item> PALE_JANE_SWIG;
    public static final RegistryObject<Item> DREAD_NOG_SWIG;
    public static final RegistryObject<Item> SALTY_FOLLY_SWIG;
    public static final RegistryObject<Item> STEEL_TOE_STOUT_SWIG;
    public static final RegistryObject<Item> GLITTERING_GRENADINE_SWIG;
    public static final RegistryObject<Item> BLOODY_MARY_SWIG;
    public static final RegistryObject<Item> RED_RUM_SWIG;
    public static final RegistryObject<Item> WITHERING_DROSS_SWIG;
    public static final RegistryObject<Item> KOMBUCHA_SWIG;
    public static final RegistryObject<Item> RADIANT_BREW_SWIG;
    public static final RegistryObject<Item> ROOT_BEER_SWIG;
    public BrewinMDCompatItems() {}

    static {
        ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "bundledelight");
        COPPER_TANKARD = ITEMS.register("copper_tankard", () -> {
            return new Item(basicItem());
        });
        BEER_SWIG = ITEMS.register("beer_swig", () -> {
            return new BundleBoozeItem(1, 8, steinFoodItemNoEffect());
        });
        VODKA_SWIG = ITEMS.register("vodka_swig", () -> {
            return new BundleBoozeItem(1, 12, steinFoodItemNoEffect());
        });
        MEAD_SWIG = ITEMS.register("mead_swig", () -> {
            return new BundleBoozeItem(1, 8, steinFoodItem(FoodValues.MEAD));
        });
        RICE_WINE_SWIG = ITEMS.register("rice_wine_swig", () -> {
            return new BundleBoozeItem(1, 5, steinFoodItem(FoodValues.RICE_WINE));
        });
        EGG_GROG_SWIG = ITEMS.register("egg_grog_swig", () -> {
            return new BundleBoozeItem(1, 0, steinFoodItem(FoodValues.EGG_GROG));
        });
        STRONGROOT_ALE_SWIG = ITEMS.register("strongroot_ale_swig", () -> {
            return new BundleBoozeItem(2, 12, steinFoodItem(FoodValues.STRONGROOT_ALE));
        });
        SACCHARINE_RUM_SWIG = ITEMS.register("saccharine_rum_swig", () -> {
            return new BundleBoozeItem(2, 8, steinFoodItem(FoodValues.SACCHARINE_RUM));
        });
        PALE_JANE_SWIG = ITEMS.register("pale_jane_swig", () -> {
            return new BundleBoozeItem(1, 5, steinFoodItem(FoodValues.PALE_JANE));
        });
        DREAD_NOG_SWIG = ITEMS.register("dread_nog_swig", () -> {
            return new BundleDreadNogItem(3, 5, steinFoodItemNoEffect());
        });
        SALTY_FOLLY_SWIG = ITEMS.register("salty_folly_swig", () -> {
            return new BundleBoozeItem(2, 10, steinFoodItem(FoodValues.SALTY_FOLLY));
        });
        STEEL_TOE_STOUT_SWIG = ITEMS.register("steel_toe_stout_swig", () -> {
            return new BundleBoozeItem(3, 10, steinFoodItem(FoodValues.STEEL_TOE_STOUT));
        });
        GLITTERING_GRENADINE_SWIG = ITEMS.register("glittering_grenadine_swig", () -> {
            return new BundleBoozeItem(1, 5, steinFoodItem(FoodValues.GLITTERING_GRENADINE));
        });
        BLOODY_MARY_SWIG = ITEMS.register("bloody_mary_swig", () -> {
            return new BundleBoozeItem(1, 12, steinFoodItem(FoodValues.BLOODY_MARY));
        });
        RED_RUM_SWIG = ITEMS.register("red_rum_swig", () -> {
            return new BundleBoozeItem(1, 18, steinFoodItem(FoodValues.RED_RUM));
        });
        WITHERING_DROSS_SWIG = ITEMS.register("withering_dross_swig", () -> {
            return new BundleBoozeItem(3, 20, steinFoodItem(FoodValues.WITHERING_DROSS));
        });
        KOMBUCHA_SWIG = ITEMS.register("kombucha_swig", () -> {
            return new BundleBoozeItem(1, 5, steinFoodItem(FoodValues.KOMBUHCA));
        });
        RADIANT_BREW_SWIG = ITEMS.register("radiant_brew_swig", () -> {
            return new BundleBoozeItem(1, 6, steinFoodItem(FoodValues.RADIANT_BREW));
        });
        ROOT_BEER_SWIG = ITEMS.register("root_beer_swig", () -> {
            return new BundleBoozeItem(2, 8, steinFoodItemNoEffect());
        });
    }
}
