package com.pouffy.bundledelight.compats.abnormals_delight;

import com.pouffy.bundledelight.compats.CompatibleMod;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class AbnormalsCompat extends CompatibleMod {
    public static final String MODID = "abnormals_delight";

    @Override
    public String getModID() {
        return MODID;
    }

    @Override
    protected void onLoad() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        //AbnormalsNeapolitanCompatItems.ITEMS.register(bus);
    }

}
