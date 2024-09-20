package com.pouffy.bundledelight.compats.respiteful;

import com.pouffy.bundledelight.compats.CompatibleDoubleMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class RespitefulMDCompat extends CompatibleDoubleMod {
    public static final String MODID = "respiteful";
    public static final String MD_MODID = "miners_delight";
    
    public static final String CLASS = "plus.dragons.respiteful.Respiteful";
    public static final String MD_CLASS = "com.sammy.minersdelight.MinersDelightMod";
    
    public static ResourceLocation rl(String path) {
        return new ResourceLocation(MODID, path);
    }

    @Override
    public String getModid() {
        return MODID;
    }

    @Override
    public String getRequiredClass() {
        return CLASS;
    }
    
    @Override
    public String getOtherRequiredClass() {
        return MD_CLASS;
    }

    @Override
    protected void onLoad() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        RespitefulMDCompatItems.ITEMS.register(bus);
    }
}
