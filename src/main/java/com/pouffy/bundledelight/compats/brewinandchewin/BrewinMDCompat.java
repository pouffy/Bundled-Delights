package com.pouffy.bundledelight.compats.brewinandchewin;

import com.pouffy.bundledelight.compats.CompatibleDoubleMod;
import com.pouffy.bundledelight.compats.CompatibleMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class BrewinMDCompat extends CompatibleDoubleMod {
    public static final String MODID = "brewinandchewin";
    public static final String MD_MODID = "miners_delight";

    public static ResourceLocation rl(String path) {
        return new ResourceLocation(MODID, path);
    }

    @Override
    public String getModID() {
        return MODID;
    }
    @Override
    public String getOtherModID() {
        return MD_MODID;
    }
    @Override
    protected void onLoad() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
         BrewinMDItems.ITEMS.register(bus);
    }
}