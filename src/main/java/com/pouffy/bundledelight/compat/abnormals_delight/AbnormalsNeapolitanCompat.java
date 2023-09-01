package com.pouffy.bundledelight.compat.abnormals_delight;

import com.pouffy.bundledelight.compat.CompatibleDoubleMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class AbnormalsNeapolitanCompat extends CompatibleDoubleMod {
    public static final String MODID = "abnormals_delight";
    public static final String MD_MODID = "neapolitan";

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
         AbnormalsNeapolitanCompatItems.ITEMS.register(bus);
    }
}
