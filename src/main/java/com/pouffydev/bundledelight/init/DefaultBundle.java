package com.pouffydev.bundledelight.init;

import com.pouffydev.bundledelight.BundledDelights;
import com.pouffydev.bundledelight.content.food.FoodValues;
import com.pouffydev.bundledelight.foundation.Bundle;
import com.pouffydev.bundledelight.foundation.BundledRegistrate;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.item.DrinkableItem;

import java.util.List;

public class DefaultBundle extends Bundle {
    private static final BundledRegistrate registrate = BundledDelights.registrate().creativeModeTab(() -> BundledDelights.itemGroup);
    
    public DefaultBundle() {
        super("bundledelight");
    }
    
    @Override
    public List<String> getRequiredClasses() {
        return List.of("com.pouffydev.bundledelight.BundledDelight");
    }
    
    @Override
    protected void onLoad() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        Items.register();
        Blocks.register();
    }
    
    public static class Items {
        public static final ItemEntry<DrinkableItem>
                borscht = drinkableItem(registrate, "borscht"),
                nettleSoup = drinkableItem(registrate, "nettle_soup"),
                sweetBerryJuice = drinkableItem(registrate, "sweet_berry_juice"),
                glassOfConcrete = drinkableItem(registrate, "glass_of_concrete");
        
        public static final ItemEntry<ConsumableItem>
                carrotCakeSlice = consumableItem(registrate, "carrot_cake_slice", BundledRegistrate.foodProps(FoodValues.CARROT_CAKE));
        
        public static void register() {
        }
    }
    
    public static class Blocks {
        public static void register() {
        }
    }
}
