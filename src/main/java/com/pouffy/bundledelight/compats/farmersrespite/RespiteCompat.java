package com.pouffy.bundledelight.compats.farmersrespite;

import com.pouffy.bundledelight.compats.CompatibleMod;
import com.pouffy.bundledelight.compats.brewinandchewin.BrewinItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class RespiteCompat extends CompatibleMod {
    public static final String MODID = "farmersrespite";

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
         RespiteItems.ITEMS.register(bus);
    }
}
