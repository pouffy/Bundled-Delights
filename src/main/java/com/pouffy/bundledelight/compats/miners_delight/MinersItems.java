package com.pouffy.bundledelight.compats.miners_delight;

import com.pouffy.bundledelight.BundledDelights;
import com.pouffy.bundledelight.content.food.FoodValues;
import com.pouffy.bundledelight.init.BDBlocks;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.item.DrinkableItem;

import static com.pouffy.bundledelight.init.BDItems.basicItem;
import static com.sammy.minersdelight.setup.MDItems.COPPER_CUP;

public class MinersItems {
    public static final DeferredRegister<Item> ITEMS;
    public static Item.Properties cupFoodItem(FoodProperties food) {
        return new Item.Properties().food(food).craftRemainder(COPPER_CUP.get()).stacksTo(16).tab(BundledDelights.CREATIVE_TAB);
    }
    public static final RegistryObject<Item> BORSCHT_CUP;
    public static final RegistryObject<Item> NETTLE_SOUP_CUP;

    public MinersItems(){
    }
    static {
        ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "bundledelight");
        BORSCHT_CUP = ITEMS.register("borscht_cup", () -> {
            return new DrinkableItem(cupFoodItem(FoodValues.BORSCHT), true);
        });
        NETTLE_SOUP_CUP = ITEMS.register("nettle_soup_cup", () -> {
            return new DrinkableItem(cupFoodItem(FoodValues.NETTLE_SOUP), true);
        });

    }
}
