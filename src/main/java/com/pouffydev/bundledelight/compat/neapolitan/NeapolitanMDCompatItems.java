package com.pouffydev.bundledelight.compat.neapolitan;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;

public class NeapolitanMDCompatItems {
    public static final DeferredRegister<Item> ITEMS;
    //public static final RegistryObject<Item> ADZUKI_CURRY_CUP;

    public NeapolitanMDCompatItems() {
    }

    static {
        ITEMS = DeferredRegister.create(net.minecraftforge.registries.ForgeRegistries.ITEMS, "bundledelight");
        //ADZUKI_CURRY_CUP = ITEMS.register("adzuki_curry_cup", () -> {
        //    return new DrinkableItem(cupFoodItem(CompatFoodValues.ADZUKI_CURRY_CUP), true, true);
        //});
    }
}
