package com.pouffy.bundledelight.compats.brewinandchewin;

import com.pouffy.bundledelight.compats.CompatibleMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class BrewinCompat extends CompatibleMod {
    public static final String MODID = "brewinandchewin";

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
         BrewinItems.ITEMS.register(bus);

    }
}
