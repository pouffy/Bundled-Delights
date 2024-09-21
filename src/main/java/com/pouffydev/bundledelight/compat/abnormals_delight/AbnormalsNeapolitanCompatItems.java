package com.pouffydev.bundledelight.compat.abnormals_delight;

import com.pouffydev.bundledelight.content.food.FoodValues;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static com.pouffydev.bundledelight.foundation.BundledRegistrate.foodProps;


public class AbnormalsNeapolitanCompatItems {
    public static final DeferredRegister<Item> ITEMS;
    public static final RegistryObject<Item> WHITE_STRAWBERRY_CAKE_SLICE;
    public AbnormalsNeapolitanCompatItems() {}

    static {
        ITEMS = DeferredRegister.create(net.minecraftforge.registries.ForgeRegistries.ITEMS, "bundledelight");
        WHITE_STRAWBERRY_CAKE_SLICE = ITEMS.register("white_strawberry_cake_slice", () -> {
            return new CompatCakeSliceItem(foodProps(FoodValues.CAKE_SLICE));
        });
    }
}
