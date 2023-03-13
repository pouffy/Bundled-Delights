package com.pouffy.bundledelight.compats.miners_delight;

import com.pouffy.bundledelight.BundledDelights;
import com.pouffy.bundledelight.compats.CompatibleMod;
import com.pouffy.bundledelight.compats.farmersrespite.RespiteMDItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import static com.pouffy.bundledelight.compats.brewinandchewin.BrewinMDItems.COPPER_TANKARD;

public class MinersCompat extends CompatibleMod {
    public static final String MODID = "miners_delight";

    public static Item.Properties cupFoodItem(FoodProperties food) {
        return new Item.Properties().food(food).craftRemainder(RespiteMDItems.CUP.get()).stacksTo(16).tab(BundledDelights.CREATIVE_TAB);
    }
    public static Item.Properties cupFoodItemHidden(FoodProperties food) {
        return new Item.Properties().food(food).craftRemainder(RespiteMDItems.CUP.get()).stacksTo(16);
    }
    public static Item.Properties steinFoodItem(FoodProperties food) {
        return new Item.Properties().food(food).craftRemainder(COPPER_TANKARD.get()).stacksTo(16).tab(BundledDelights.CREATIVE_TAB);
    }
    public static Item.Properties steinFoodItemNoEffect() {
        return new Item.Properties().craftRemainder(COPPER_TANKARD.get()).stacksTo(16).tab(BundledDelights.CREATIVE_TAB);
    }
    public static ResourceLocation rl(String path) {
        return new ResourceLocation(MODID, path);
    }

    @Override
    public String getModID() {
        return MODID;
    }

    @Override
    protected void onLoad() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
         MinersItems.ITEMS.register(bus);
    }
}
