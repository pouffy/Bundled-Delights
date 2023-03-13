package com.pouffy.bundledelight.compats.miners_delight;

import com.pouffy.bundledelight.content.food.FoodValues;
import com.sammy.minersdelight.setup.MDItems;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;
import vectorwing.farmersdelight.common.item.DrinkableItem;

import static com.pouffy.bundledelight.compats.miners_delight.MinersCompat.cupFoodItem;

public class MinersItems {

    public static final DeferredRegister<Item> ITEMS;

    //public static final RegistryObject<Item> BORSCHT_CUP;
    //public static final RegistryObject<Item> NETTLE_SOUP_CUP;

    public MinersItems(){
    }
    static {
        ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "bundledelight");
        //BORSCHT_CUP = ITEMS.register("borscht_cup", () -> {
        //    return new DrinkableItem(cupFoodItem(FoodValues.BORSCHT), true);
        //});
        //NETTLE_SOUP_CUP = ITEMS.register("nettle_soup_cup", () -> {
        //    return new DrinkableItem(cupFoodItem(FoodValues.NETTLE_SOUP), true);
        //});

    }
}
