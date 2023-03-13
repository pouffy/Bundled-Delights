package com.pouffy.bundledelight.compats.miners_delight;

import com.pouffy.bundledelight.init.BDItems;
import com.sammy.minersdelight.setup.CupConversionHandler;
import com.sammy.minersdelight.setup.MDItems;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class CupConversions extends CupConversionHandler {

    @SubscribeEvent
    public static void addCupConversions(FMLCommonSetupEvent event) {
        BOWL_TO_CUP.put((Item) BDItems.BORSCHT.get(), (Item)MinersItems.BORSCHT_CUP.get());
        BOWL_TO_CUP.put((Item) BDItems.NETTLE_SOUP.get(), (Item)MinersItems.NETTLE_SOUP_CUP.get());
    }
}
