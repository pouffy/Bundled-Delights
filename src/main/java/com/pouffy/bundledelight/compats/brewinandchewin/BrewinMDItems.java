package com.pouffy.bundledelight.compats.brewinandchewin;

import com.brewinandchewin.common.item.BoozeItem;
import com.brewinandchewin.core.utility.BCFoods;
import com.pouffy.bundledelight.BundledDelights;
import com.pouffy.bundledelight.content.food.FoodValues;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.brewinandchewin.core.registry.BCItems.TANKARD;
import static com.pouffy.bundledelight.init.BDItems.basicItem;
import static com.pouffy.bundledelight.init.BDItems.foodItem;

public class BrewinMDItems {
    public static final DeferredRegister<Item> ITEMS;

    public static Item.Properties steinFoodItem(FoodProperties food) {
        return new Item.Properties().food(food).craftRemainder(COPPER_TANKARD.get()).stacksTo(16).tab(BundledDelights.CREATIVE_TAB);
    }
    public static Item.Properties steinFoodItemNoEffect() {
        return new Item.Properties().craftRemainder(COPPER_TANKARD.get()).stacksTo(16).tab(BundledDelights.CREATIVE_TAB);
    }
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
    public BrewinMDItems() {}

    static {
        ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "bundledelight");
        COPPER_TANKARD = ITEMS.register("copper_tankard", () -> {
            return new Item(basicItem());
        });
        BEER_SWIG = ITEMS.register("beer_swig", () -> {
            return new BoozeItem(1, 8, steinFoodItemNoEffect());
        });
        VODKA_SWIG = ITEMS.register("vodka_swig", () -> {
            return new BoozeItem(1, 12, steinFoodItemNoEffect());
        });
        MEAD_SWIG = ITEMS.register("mead_swig", () -> {
            return new BoozeItem(1, 8, steinFoodItem(BCFoods.MEAD));
        });
        RICE_WINE_SWIG = ITEMS.register("rice_wine_swig", () -> {
            return new BoozeItem(1, 5, steinFoodItem(BCFoods.RICE_WINE));
        });
        EGG_GROG_SWIG = ITEMS.register("egg_grog_swig", () -> {
            return new BoozeItem(1, 0, steinFoodItem(BCFoods.EGG_GROG));
        });
        STRONGROOT_ALE_SWIG = ITEMS.register("strongroot_ale_swig", () -> {
            return new BoozeItem(2, 12, steinFoodItem(BCFoods.STRONGROOT_ALE));
        });
        SACCHARINE_RUM_SWIG = ITEMS.register("saccharine_rum_swig", () -> {
            return new BoozeItem(2, 8, steinFoodItem(BCFoods.SACCHARINE_RUM));
        });
        PALE_JANE_SWIG = ITEMS.register("pale_jane_swig", () -> {
            return new BoozeItem(1, 5, steinFoodItem(BCFoods.PALE_JANE));
        });
        DREAD_NOG_SWIG = ITEMS.register("dread_nog_swig", () -> {
            return new DreadNogSwigItem(3, 5, steinFoodItemNoEffect());
        });
        SALTY_FOLLY_SWIG = ITEMS.register("salty_folly_swig", () -> {
            return new BoozeItem(2, 10, steinFoodItem(BCFoods.SALTY_FOLLY));
        });
        STEEL_TOE_STOUT_SWIG = ITEMS.register("steel_toe_stout_swig", () -> {
            return new BoozeItem(3, 10, steinFoodItem(BCFoods.STEEL_TOE_STOUT));
        });
        GLITTERING_GRENADINE_SWIG = ITEMS.register("glittering_grenadine_swig", () -> {
            return new BoozeItem(1, 5, steinFoodItem(BCFoods.GLITTERING_GRENADINE));
        });
        BLOODY_MARY_SWIG = ITEMS.register("bloody_mary_swig", () -> {
            return new BoozeItem(1, 12, steinFoodItem(BCFoods.BLOODY_MARY));
        });
        RED_RUM_SWIG = ITEMS.register("red_rum_swig", () -> {
            return new BoozeItem(1, 18, steinFoodItem(BCFoods.RED_RUM));
        });
        WITHERING_DROSS_SWIG = ITEMS.register("withering_dross_swig", () -> {
            return new BoozeItem(3, 20, steinFoodItem(BCFoods.WITHERING_DROSS));
        });
        KOMBUCHA_SWIG = ITEMS.register("kombucha_swig", () -> {
            return new BoozeItem(1, 5, steinFoodItem(BCFoods.KOMBUHCA));
        });
        RADIANT_BREW_SWIG = ITEMS.register("radiant_brew_swig", () -> {
            return new BoozeItem(1, 6, steinFoodItem(FoodValues.RADIANT_BREW));
        });
    }
}
