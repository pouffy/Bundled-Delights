package com.pouffy.bundledelight.compats.brewinandchewin;

import com.pouffy.bundledelight.compats.CompatibleMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class BrewinCompat extends CompatibleMod {
    public static final String CLASS = "umpaz.brewinandchewin.BrewinAndChewin";
    public static final String MODID = "brewinandchewin";

    public static ResourceLocation rl(String path) {
        return new ResourceLocation(MODID, path);
    }
    
    @Override
    public String getRequiredClass() {
        return CLASS;
    }
    
    @Override
    public String getModid() {
        return MODID;
    }

    @Override
    protected void onLoad() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
         BrewinCompatItems.ITEMS.register(bus);

    }
}
