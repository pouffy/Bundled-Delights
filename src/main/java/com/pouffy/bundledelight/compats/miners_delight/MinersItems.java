package com.pouffy.bundledelight.compats.miners_delight;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

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
