package com.pouffydev.bundledelight.compat.miners_delight;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class MinersCompatItems {

    public static final DeferredRegister<Item> ITEMS;

    //public static final RegistryObject<Item> BORSCHT_CUP;
    //public static final RegistryObject<Item> NETTLE_SOUP_CUP;

    public MinersCompatItems(){
    }
    static {
        ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "bundledelight");
        //BORSCHT_CUP = ITEMS.register("borscht_cup", () -> {
        //    return new DrinkableItem(new Item.Properties().food(FoodValues.BORSCHT_CUP).craftRemainder(MDItems.COPPER_CUP.get()).stacksTo(16).tab(BundledDelights.CREATIVE_TAB), true);
        //});
        //NETTLE_SOUP_CUP = ITEMS.register("nettle_soup_cup", () -> {
        //    return new DrinkableItem(new Item.Properties().food(FoodValues.NETTLE_SOUP_CUP).craftRemainder(MDItems.COPPER_CUP.get()).stacksTo(16).tab(BundledDelights.CREATIVE_TAB), true);
        //});

    }
}
