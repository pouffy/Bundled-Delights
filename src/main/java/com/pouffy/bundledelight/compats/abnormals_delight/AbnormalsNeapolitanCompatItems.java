package com.pouffy.bundledelight.compats.abnormals_delight;

import com.teamabnormals.abnormals_delight.core.registry.ADItems;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static com.pouffy.bundledelight.util.ItemRegistryUtils.foodItem;


public class AbnormalsNeapolitanCompatItems {
    public static final DeferredRegister<Item> ITEMS;
    public static final RegistryObject<Item> WHITE_STRAWBERRY_CAKE_SLICE;
    public AbnormalsNeapolitanCompatItems() {}

    static {
        ITEMS = DeferredRegister.create(net.minecraftforge.registries.ForgeRegistries.ITEMS, "bundledelight");
        WHITE_STRAWBERRY_CAKE_SLICE = ITEMS.register("white_strawberry_cake_slice", () -> {
            return new CompatCakeSliceItem(foodItem(ADItems.ADFoods.CAKE_SLICE));
        });
    }
}
