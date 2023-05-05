package com.pouffy.bundledelight.compats.brewinandchewin;

import com.pouffy.bundledelight.content.food.FoodValues;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.pouffy.bundledelight.init.BDItems.foodItem;

public class BrewinItems {
    public static final DeferredRegister<Item> ITEMS;
    public static final RegistryObject<Item> CHEESEBURGER;
    public static final RegistryObject<Item> SCARLET_CHEESEBURGER;
    //public static final RegistryObject<Item> RADIANT_BREW;

    public BrewinItems() {}

    static {
        ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "bundledelight");

        CHEESEBURGER = ITEMS.register("cheeseburger", () -> {
            return new Item(foodItem(FoodValues.CHEESEBURGER));
        });
        SCARLET_CHEESEBURGER = ITEMS.register("scarlet_cheeseburger", () -> {
            return new Item(foodItem(FoodValues.CHEESEBURGER));
        });
        //RADIANT_BREW = ITEMS.register("radiant_brew", () -> {
        //    return new BoozeItem(1, 6, new Item.Properties().food(FoodValues.RADIANT_BREW).craftRemainder(BCItems.TANKARD.get()).stacksTo(16).tab(BundledDelights.CREATIVE_TAB));
        //});
    }
}
