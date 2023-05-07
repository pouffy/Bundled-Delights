package com.pouffy.bundledelight.compats.miners_delight;

import com.pouffy.bundledelight.BundledDelights;
import com.pouffy.bundledelight.content.food.FoodValues;
import com.sammy.minersdelight.setup.MDItems;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.item.DrinkableItem;


public class MinersCompatItems {
    public static Item.Properties cupFoodItem(FoodProperties food) {
        return new Item.Properties().food(food).craftRemainder(MDItems.COPPER_CUP.get()).stacksTo(16).tab(BundledDelights.CREATIVE_TAB);
    }
    public static final DeferredRegister<Item> ITEMS;

    public static final RegistryObject<Item> BORSCHT_CUP;
    public static final RegistryObject<Item> NETTLE_SOUP_CUP;

    public MinersCompatItems(){
    }
    static {
        ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "bundledelight");
        BORSCHT_CUP = ITEMS.register("borscht_cup", () -> {
            return new DrinkableItem(cupFoodItem(FoodValues.BORSCHT_CUP), true);
        });
        NETTLE_SOUP_CUP = ITEMS.register("nettle_soup_cup", () -> {
            return new DrinkableItem(cupFoodItem(FoodValues.NETTLE_SOUP_CUP), true);
        });

    }
}
