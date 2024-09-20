package com.pouffy.bundledelight.util;

import com.pouffy.bundledelight.BundledDelights;
import com.pouffy.bundledelight.compats.farmersrespite.RespiteMDCompatItems;
import com.pouffy.bundledelight.compats.miners_delight.MinersCompatItems;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import static com.pouffy.bundledelight.compats.brewinandchewin.BrewinCompatItems.GLASS_TANKARD;
import static com.pouffy.bundledelight.compats.brewinandchewin.BrewinMDCompatItems.COPPER_TANKARD;

public class ItemRegistryUtils {
    public static Item.Properties basicItem() {
        return new Item.Properties().tab(BundledDelights.CREATIVE_TAB);
    }
    public static Item.Properties singleItem() {
        return new Item.Properties().tab(BundledDelights.CREATIVE_TAB).stacksTo(1);
    }
    public static Item.Properties foodItem(FoodProperties food) {
        return new Item.Properties().food(food).tab(BundledDelights.CREATIVE_TAB);
    }
    public static Item.Properties bowlFoodItem(FoodProperties food) {
        return new Item.Properties().food(food).craftRemainder(Items.BOWL).stacksTo(16).tab(BundledDelights.CREATIVE_TAB);
    }
    public static Item.Properties drinkItem() {
        return new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16).tab(BundledDelights.CREATIVE_TAB);
    }
    public static Item.Properties steinFoodItem(FoodProperties food) {
        return new Item.Properties().food(food).craftRemainder(COPPER_TANKARD.get()).stacksTo(16).tab(BundledDelights.CREATIVE_TAB);
    }
    public static Item.Properties steinFoodItemNoEffect() {
        return new Item.Properties().craftRemainder(COPPER_TANKARD.get()).stacksTo(16).tab(BundledDelights.CREATIVE_TAB);
    }
    public static Item.Properties glassTankardFoodItem(FoodProperties food) {
        return new Item.Properties().food(food).craftRemainder(GLASS_TANKARD.get()).stacksTo(16).tab(BundledDelights.CREATIVE_TAB);
    }
    public static Item.Properties glassTankardFoodItemNoEffect() {
        return new Item.Properties().craftRemainder(GLASS_TANKARD.get()).stacksTo(16).tab(BundledDelights.CREATIVE_TAB);
    }
    public static Item.Properties cupFoodItem(FoodProperties food) {
        return new Item.Properties().food(food).craftRemainder(MinersCompatItems.COPPER_CUP_COMPATITEM.get()).stacksTo(16).tab(BundledDelights.CREATIVE_TAB);
    }
    public static Item.Properties cupFoodItemHidden(FoodProperties food) {
        return new Item.Properties().food(food).craftRemainder(RespiteMDCompatItems.CUP.get()).stacksTo(16);
    }
    
    public static boolean isClassFound(String className) {
        try {
            Class.forName(className, false, Thread.currentThread().getContextClassLoader());
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
}
