package com.pouffy.bundledelight.compats.miners_delight;

import com.pouffy.bundledelight.BundledDelights;
import com.pouffy.bundledelight.compats.CompatRemainderItem;
import com.pouffy.bundledelight.content.food.FoodValues;
import com.sammy.minersdelight.setup.MDItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.item.DrinkableItem;


public class MinersCompatItems {

    public static final DeferredRegister<Item> ITEMS;

    public static final RegistryObject<Item> BORSCHT_CUP;
    public static final RegistryObject<Item> NETTLE_SOUP_CUP;
    public static final RegistryObject<Item> COPPER_CUP_COMPATITEM;

    public MinersCompatItems(){
    }
    static {
        ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "bundledelight");
        COPPER_CUP_COMPATITEM = ITEMS.register("compat_debug/copper_cup", () -> {
            return new CompatRemainderItem(new Item.Properties(), new ResourceLocation("miners_delight", "copper_cup"));
        });
        BORSCHT_CUP = ITEMS.register("borscht_cup", () -> {
            return new DrinkableItem(new Item.Properties().food(FoodValues.BORSCHT_CUP).craftRemainder(COPPER_CUP_COMPATITEM.get()).stacksTo(16).tab(BundledDelights.CREATIVE_TAB), true);
        });
        NETTLE_SOUP_CUP = ITEMS.register("nettle_soup_cup", () -> {
            return new DrinkableItem(new Item.Properties().food(FoodValues.NETTLE_SOUP_CUP).craftRemainder(COPPER_CUP_COMPATITEM.get()).stacksTo(16).tab(BundledDelights.CREATIVE_TAB), true);
        });
    }
}
