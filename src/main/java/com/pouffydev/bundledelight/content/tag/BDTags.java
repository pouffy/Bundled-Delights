package com.pouffydev.bundledelight.content.tag;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;

public class BDTags {
    public static final TagKey<Item> GREEN_TEA = respiteDrinkTag("green_tea");
    public static final TagKey<Item> YELLOW_TEA = respiteDrinkTag("yellow_tea");
    public static final TagKey<Item> BLACK_TEA = respiteDrinkTag("black_tea");
    public static final TagKey<Item> ROSE_HIP_TEA = respiteDrinkTag("rose_hip_tea");
    public static final TagKey<Item> DANDELION_TEA = respiteDrinkTag("dandelion_tea");
    public static final TagKey<Item> PURULENT_TEA = respiteDrinkTag("purulent_tea");
    public static final TagKey<Item> COFFEE = respiteDrinkTag("coffee");
    public static final TagKey<Item> BEER = brewinDrinkTag("beer");
    public static final TagKey<Item> VODKA = brewinDrinkTag("vodka");
    public static final TagKey<Item> MEAD = brewinDrinkTag("mead");
    public static final TagKey<Item> RICE_WINE = brewinDrinkTag("rice_wine");
    public static final TagKey<Item> EGG_GROG = brewinDrinkTag("egg_grog");
    public static final TagKey<Item> STRONGROOT_ALE = brewinDrinkTag("strongroot_ale");
    public static final TagKey<Item> SACCHARINE_RUM = brewinDrinkTag("saccharine_rum");
    public static final TagKey<Item> PALE_JANE = brewinDrinkTag("pale_jane");
    public static final TagKey<Item> DREAD_NOG = brewinDrinkTag("dread_nog");
    public static final TagKey<Item> SALTY_FOLLY = brewinDrinkTag("salty_folly");
    public static final TagKey<Item> STEEL_TOE_STOUT = brewinDrinkTag("steel_toe_stout");
    public static final TagKey<Item> GLITTERING_GRENADINE = brewinDrinkTag("glittering_grenadine");
    public static final TagKey<Item> BLOODY_MARY = brewinDrinkTag("bloody_mary");
    public static final TagKey<Item> RED_RUM = brewinDrinkTag("red_rum");
    public static final TagKey<Item> WITHERING_DROSS = brewinDrinkTag("withering_dross");
    public static final TagKey<Item> KOMBUCHA = brewinDrinkTag("kombucha");
    public static final TagKey<Item> RADIANT_BREW = brewinDrinkTag("radiant_brew");
    public static final TagKey<Item> ROOT_BEER = brewinDrinkTag("root_beer");
    public static final TagKey<Item> GREEN_TEA_POWDER = modItemTag("powders/green_tea");
    public static final TagKey<Item> YELLOW_TEA_POWDER = modItemTag("powders/yellow_tea");
    public static final TagKey<Item> BLACK_TEA_POWDER = modItemTag("powders/black_tea");
    public static final TagKey<Item> COFFEE_POWDER = modItemTag("powders/coffee");
    public static final TagKey<Item> ADZUKI_POWDER = modItemTag("powders/adzuki");
    public static final TagKey<Item> VANILLA_POWDER = modItemTag("powders/vanilla");
    public static final TagKey<Item> MINT_POWDER = modItemTag("powders/mint");
    public static final TagKey<Item> TEA_POWDER = modItemTag("tea_powders");
    public static final TagKey<Item> BEESECHURGER = modItemTag("cheeseburger");
    public static final TagKey<Item> SEEDS = forgeItemTag("seeds");
    public static final TagKey<Item> SEEDS_TEA = forgeItemTag("seeds/tea");
    public static final TagKey<Item> SEEDS_COFFEE = forgeItemTag("seeds/coffee");
    public static final TagKey<Item> BELT_UPRIGHT = createItemTag("upright_on_belt");

    public static final TagKey<Block> DROPS_CARROT_CAKE_SLICE = modBlockTag("drops_carrot_cake_slice");
    public static final TagKey<Block> DROPS_CAKE_SLICE = modBlockTag("drops_cake_slice");
    public static final TagKey<Block> DROPS_WHITE_STRAWBERRY_CAKE_SLICE = modBlockTag("drops_white_strawberry_cake_slice");

    public static final TagKey<Fluid> WATER = modFluidTag("water");

    public BDTags() {
    }

    private static TagKey<Item> modItemTag(String path) {
        return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("bundledelight:" + path));
    }

    private static TagKey<Item> respiteItemTag(String path) {
        return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("farmersrespite:" + path));
    }
    private static TagKey<Item> respiteDrinkTag(String path) {
        return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("farmersrespite:drinks/" + path));
    }
    private static TagKey<Item> brewinItemTag(String path) {
        return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("brewinandchewin:" + path));
    }
    private static TagKey<Item> brewinDrinkTag(String path) {
        return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("brewinandchewin:drinks/" + path));
    }
    private static TagKey<Item> forgeItemTag(String path) {
        return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge:" + path));
    }
    private static TagKey<Fluid> forgeFluidTag(String path) {
        return TagKey.create(Registry.FLUID_REGISTRY, new ResourceLocation("forge:" + path));
    }
    private static TagKey<Fluid> fluidTag(String path) {
        return TagKey.create(Registry.FLUID_REGISTRY, new ResourceLocation("minecraft:" + path));
    }
    private static TagKey<Fluid> modFluidTag(String path) {
        return TagKey.create(Registry.FLUID_REGISTRY, new ResourceLocation("bundledelight:" + path));
    }
    public static TagKey<Item> createItemTag(String path) {
        return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("create:" + path));
    }

    private static TagKey<Block> modBlockTag(String path) {
        return TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation("bundledelight:" + path));
    }

    private static TagKey<EntityType<?>> modEntityTag(String path) {
        return TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation("bundledelight:" + path));
    }
}
