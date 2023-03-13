package com.pouffy.bundledelight.compats.miners_delight;

import com.pouffy.bundledelight.compats.CompatibleMod;
import com.pouffy.bundledelight.compats.farmersrespite.RespiteItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class MinersCompat extends CompatibleMod {
    public static final String MODID = "miners_delight";

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
