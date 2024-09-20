package com.pouffy.bundledelight.compats.abnormals_delight;

import com.pouffy.bundledelight.compats.CompatibleDoubleMod;
import com.pouffy.bundledelight.compats.brewinandchewin.BrewinMDCompatItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class AbnormalsNeapolitanCompat extends CompatibleDoubleMod {
    public static final String MODID = "abnormals_delight";
    public static final String MD_MODID = "neapolitan";
    
    public static final String CLASS = "com.teamabnormals.abnormals_delight.core.AbnormalsDelight";
    public static final String MD_CLASS = "com.teamabnormals.neapolitan.core.Neapolitan";

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
        return MD_MODID;
    }
    @Override
    protected void onLoad() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
         AbnormalsNeapolitanCompatItems.ITEMS.register(bus);
    }
}
