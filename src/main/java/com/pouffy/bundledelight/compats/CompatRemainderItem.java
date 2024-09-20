package com.pouffy.bundledelight.compats;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;

public class CompatRemainderItem extends Item {
    private final ResourceLocation itemToBecome;
    
    public CompatRemainderItem(Properties properties, ResourceLocation itemToBecome) {
        super(properties);
        this.itemToBecome = itemToBecome;
    }
    
    private ItemStack getRemainder() {
        Item item = ForgeRegistries.ITEMS.getValue(this.itemToBecome);
        return new ItemStack(item);
    }
    
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        pEntity.getAllSlots().forEach((stack) -> {
            if (stack.getItem() instanceof CompatRemainderItem) {
                replaceItem(stack, getRemainder());
            }
        });
    }
    
    private void replaceItem(ItemStack pStack, ItemStack pRemainder) {
        int count = pStack.getCount();
        pStack.shrink(count);
        if (pStack.isEmpty()) {
            pStack = pRemainder;
        } else {
            if (!pStack.isEmpty() && !pStack.sameItem(pRemainder)) {
                pStack.shrink(count);
                if (pStack.isEmpty()) {
                    pStack = pRemainder;
                } else {
                    pStack.grow(count);
                }
            }
        }
    }
}
