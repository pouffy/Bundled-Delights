package com.pouffydev.bundledelight.foundation.util;

import com.pouffydev.bundledelight.BundledDelights;
import com.pouffydev.bundledelight.compat.farmersrespite.RespiteMDCompatItems;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import static com.pouffydev.bundledelight.compat.brewinandchewin.BrewinCompatItems.GLASS_TANKARD;
import static com.pouffydev.bundledelight.compat.brewinandchewin.BrewinMDCompatItems.COPPER_TANKARD;

public class ItemRegistryUtils {
    public static Item.Properties basicItem() {
        return new Item.Properties().tab(BundledDelights.itemGroup);
    }
    public static Item.Properties singleItem() {
        return new Item.Properties().tab(BundledDelights.itemGroup).stacksTo(1);
    }
    public static Item.Properties foodItem(FoodProperties food) {
        return new Item.Properties().food(food).tab(BundledDelights.itemGroup);
    }
    public static Item.Properties bowlFoodItem(FoodProperties food) {
        return new Item.Properties().food(food).craftRemainder(Items.BOWL).stacksTo(16).tab(BundledDelights.itemGroup);
    }
    public static Item.Properties drinkItem() {
        return new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16).tab(BundledDelights.itemGroup);
    }
    public static Item.Properties steinFoodItem(FoodProperties food) {
        return new Item.Properties().food(food).craftRemainder(COPPER_TANKARD.get()).stacksTo(16).tab(BundledDelights.itemGroup);
    }
    public static Item.Properties steinFoodItemNoEffect() {
        return new Item.Properties().craftRemainder(COPPER_TANKARD.get()).stacksTo(16).tab(BundledDelights.itemGroup);
    }
    public static Item.Properties glassTankardFoodItem(FoodProperties food) {
        return new Item.Properties().food(food).craftRemainder(GLASS_TANKARD.get()).stacksTo(16).tab(BundledDelights.itemGroup);
    }
    public static Item.Properties glassTankardFoodItemNoEffect() {
        return new Item.Properties().craftRemainder(GLASS_TANKARD.get()).stacksTo(16).tab(BundledDelights.itemGroup);
    }
    public static Item.Properties cupFoodItem(FoodProperties food) {
        return new Item.Properties().food(food).craftRemainder(RespiteMDCompatItems.CUP.get()).stacksTo(16).tab(BundledDelights.itemGroup);
    }
    public static Item.Properties cupFoodItemHidden(FoodProperties food) {
        return new Item.Properties().food(food).craftRemainder(RespiteMDCompatItems.CUP.get()).stacksTo(16);
    }
    public static Item.Properties compatEffectDrink() {
        return new Item.Properties().craftRemainder(RespiteMDCompatItems.CUP.get()).stacksTo(16);
    }
}
