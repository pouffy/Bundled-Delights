package com.pouffydev.bundledelight.mixin;

import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(Item.Properties.class)
public interface ItemPropertiesMixin {

    @Accessor("craftingRemainingItem")
    Item getCraftingRemainingItem();

    @Accessor("craftingRemainingItem")
    void setCraftingRemainingItem(Item item);
}
