package com.pouffy.bundledelight.compat.respiteful;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import plus.dragons.respiteful.entries.RespitefulItems;
import vectorwing.farmersdelight.common.item.DrinkableItem;

import static com.pouffy.bundledelight.util.ItemRegistryUtils.*;
public class RespitefulMDCompatItems {
    public static final DeferredRegister<Item> ITEMS;
    public static final RegistryObject<Item> ADZUKI_MILK_TEA_CUP;
    public static final RegistryObject<Item> MINT_GREEN_TEA_CUP;
    public static final RegistryObject<Item> MOCHA_COFFEE_CUP;
    public static final RegistryObject<Item> VANILLA_MILK_TEA_CUP;

    public RespitefulMDCompatItems() {}

    static {
        ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "bundledelight");

        ADZUKI_MILK_TEA_CUP = ITEMS.register("adzuki_milk_tea_cup", () -> {
            return new DrinkableItem(cupFoodItem(RespitefulItems.RespitefulFoods.ADZUKI_MILK_TEA), true, false);
        });
        MINT_GREEN_TEA_CUP = ITEMS.register("mint_green_tea_cup", () -> {
            return new DrinkableItem(cupFoodItem(RespitefulItems.RespitefulFoods.MINT_GREEN_TEA), true, false);
        });
        MOCHA_COFFEE_CUP = ITEMS.register("mocha_coffee_cup", () -> {
            return new DrinkableItem(cupFoodItem(RespitefulItems.RespitefulFoods.MOCHA_COFFEE), true, false);
        });
        VANILLA_MILK_TEA_CUP = ITEMS.register("vanilla_milk_tea_cup", () -> {
            return new DrinkableItem(cupFoodItem(RespitefulItems.RespitefulFoods.VANILLA_MILK_TEA), true, false);
        });
    }
}
