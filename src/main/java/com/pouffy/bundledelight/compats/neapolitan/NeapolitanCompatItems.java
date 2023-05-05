package com.pouffy.bundledelight.compats.neapolitan;

import com.pouffy.bundledelight.init.BDBlocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.pouffy.bundledelight.init.BDItems.basicItem;

public class NeapolitanCompatItems {
    public static final DeferredRegister<Item> ITEMS;
    public static final RegistryObject<Item> POWDERED_VANILLA_PODS;
    public static final RegistryObject<Item> POWDERED_MINT_LEAVES;
    public static final RegistryObject<Item> POWDERED_ADZUKI_BEANS;
    public static final RegistryObject<Item> ADZUKI_CRATE;
    public static final RegistryObject<Item> MINT_CRATE;
    public static final RegistryObject<Item> VANILLA_CRATE;
    public static final RegistryObject<Item> ADZUKI_POWDER_CRATE;
    public static final RegistryObject<Item> MINT_POWDER_CRATE;
    public static final RegistryObject<Item> VANILLA_POWDER_CRATE;
    public NeapolitanCompatItems(){
    }
    static {
        ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "bundledelight");
        POWDERED_VANILLA_PODS = ITEMS.register("powdered_vanilla_pods", () -> {
            return new Item(basicItem());
        });
        POWDERED_MINT_LEAVES = ITEMS.register("powdered_mint_leaves", () -> {
            return new Item(basicItem());
        });
        POWDERED_ADZUKI_BEANS = ITEMS.register("powdered_adzuki_beans", () -> {
            return new Item(basicItem());
        });
        ADZUKI_CRATE = ITEMS.register("adzuki_bean_crate", () -> {
            return new BlockItem((Block) BDBlocks.ADZUKI_CRATE.get(), basicItem());
        });
        MINT_CRATE = ITEMS.register("mint_leaf_crate", () -> {
            return new BlockItem((Block) BDBlocks.MINT_CRATE.get(), basicItem());
        });
        VANILLA_CRATE = ITEMS.register("dried_vanilla_pod_crate", () -> {
            return new BlockItem((Block) BDBlocks.VANILLA_CRATE.get(), basicItem());
        });
        ADZUKI_POWDER_CRATE = ITEMS.register("adzuki_powder_basket", () -> {
            return new BlockItem((Block) BDBlocks.ADZUKI_POWDER_BASKET.get(), basicItem());
        });
        MINT_POWDER_CRATE = ITEMS.register("mint_powder_basket", () -> {
            return new BlockItem((Block) BDBlocks.MINT_POWDER_BASKET.get(), basicItem());
        });
        VANILLA_POWDER_CRATE = ITEMS.register("vanilla_powder_basket", () -> {
            return new BlockItem((Block) BDBlocks.VANILLA_POWDER_BASKET.get(), basicItem());
        });
    }
}
