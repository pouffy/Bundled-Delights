package com.pouffydev.bundledelight.foundation.util;

import com.pouffydev.bundledelight.datagen.BundleTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public enum Teas {
    //FR
    GREEN_TEA("green_tea"),
    LONG_GREEN_TEA("long_green_tea"),
    STRONG_GREEN_TEA("strong_green_tea"),
    YELLOW_TEA("yellow_tea"),
    LONG_YELLOW_TEA("long_yellow_tea"),
    STRONG_YELLOW_TEA("strong_yellow_tea"),
    BLACK_TEA("black_tea"),
    LONG_BLACK_TEA("long_black_tea"),
    STRONG_BLACK_TEA("strong_black_tea"),
    ROSE_HIP_TEA("rose_hip_tea"),
    STRONG_ROSE_HIP_TEA("strong_rose_hip_tea"),
    DANDELION_TEA("dandelion_tea"),
    LONG_DANDELION_TEA("long_dandelion_tea"),
    PURULENT_TEA("purulent_tea"),
    LONG_PURULENT_TEA("long_purulent_tea"),
    COFFEE("coffee"),
    STRONG_COFFEE("strong_coffee"),
    LONG_COFFEE("long_coffee"),
    //Respiteful
    ADZUKI_MILK_TEA("adzuki_milk_tea"),
    MINT_GREEN_TEA("mint_green_tea"),
    MOCHA_COFFEE("mocha_coffee"),
    VANILLA_MILK_TEA("vanilla_milk_tea")
    
    ;
    
    private final String id;
    private String namespace = "farmersrespite";
    
    Teas(String id) {
        this.id = id;
    }
    Teas(String id, String namespace) {
        this.id = id;
        this.namespace = namespace;
    }
    
    public String getId() {
        return id;
    }
    
    public String getNamespace() {
        return namespace;
    }
    
    public TagKey<Item> getTag() {
        return BundleTags.respiteDrinkTag(id);
    }

    public ResourceLocation getTagLoc() {
        return new ResourceLocation("farmersrespite:drinks/" + id);
    }
    
    public Item getTea() {
        ResourceLocation location = new ResourceLocation(namespace, id);
        return CommonUtil.getItem(location);
    }
    
    public Item getTeaCup() {
        ResourceLocation location = new ResourceLocation("bundledelight", getNamespace() + "/" + id + "_cup");
        return CommonUtil.getItem(location);
    }
    
    public ResourceLocation teaCupId() {
        return new ResourceLocation("bundledelight", getNamespace() + "/" + id + "_cup");
    }

    public ResourceLocation getTeaLoc() {
        return new ResourceLocation(namespace, id);
    }

    public ResourceLocation getTeaCupLoc() {
        return new ResourceLocation("bundledelight", id + "_cup");
    }
}