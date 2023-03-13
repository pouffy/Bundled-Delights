package com.pouffy.bundledelight.init;

import com.farmersrespite.core.utility.FRFoods;
import com.pouffy.bundledelight.BundledDelights;
import com.pouffy.bundledelight.content.food.FoodValues;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.item.DrinkableItem;

import static com.sammy.minersdelight.setup.MDItems.COPPER_CUP;

public class BDItems {
    public static final DeferredRegister<Item> ITEMS;
    public static Item.Properties basicItem() {
        return new Item.Properties().tab(BundledDelights.CREATIVE_TAB);
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

    public static final RegistryObject<Item> BORSCHT;
    public static final RegistryObject<Item> NETTLE_SOUP;
    public BDItems(){
}

    static {
        ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "bundledelight");
        BORSCHT = ITEMS.register("borscht", () -> {
            return new DrinkableItem(bowlFoodItem(FoodValues.BORSCHT), true);
        });
        NETTLE_SOUP = ITEMS.register("nettle_soup", () -> {
            return new DrinkableItem(bowlFoodItem(FoodValues.NETTLE_SOUP), true);
        });
    }

}
