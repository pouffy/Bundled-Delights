package com.pouffydev.bundledelight.foundation.util;

import com.pouffydev.bundledelight.datagen.BundleTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

import java.util.Objects;

public enum Brews {
    BEER("beer"),
    VODKA("vodka"),
    MEAD("mead"),
    RICE_WINE("rice_wine"),
    EGG_GROG("egg_grog"),
    STRONGROOT_ALE("strongroot_ale"),
    SACCHARINE_RUM("saccharine_rum"),
    PALE_JANE("pale_jane"),
    DREAD_NOG("dread_nog"),
    SALTY_FOLLY("salty_folly"),
    STEEL_TOE_STOUT("steel_toe_stout"),
    GLITTERING_GRENADINE("glittering_grenadine"),
    BLOODY_MARY("bloody_mary"),
    RED_RUM("red_rum"),
    WITHERING_DROSS("withering_dross"),
    KOMBUCHA("kombucha"),
    ROOT_BEER("root_beer"),
    ;
    
    private final String id;
    
    Brews(String id) {
        this.id = id;
    }
    
    public String getId() {
        return id;
    }
    
    public TagKey<Item> getTag() {
        return BundleTags.brewinDrinkTag(id);
    }

    public ResourceLocation getTagLoc() {
        return new ResourceLocation("brewinandchewin:drinks/" + id);
    }
    
    public Item getTankard() {
        return Objects.equals(id, ROOT_BEER.getId()) ? CommonUtil.fromBD(id) : CommonUtil.fromBNC(id);
    }
    
    public Item getGlass() {
        return CommonUtil.fromBD(id + "_glass");
    }
    
    public Item getSwig() {
        return CommonUtil.fromBNC(id + "_swig");
    }
    
    public ResourceLocation tankardId() {
        String namespace = Objects.equals(id, ROOT_BEER.getId()) ? "bundledelight" : "brewinandchewin";
        return new ResourceLocation(namespace, id);
    }
    
    public ResourceLocation glassId() {
        return new ResourceLocation("bundledelight", id + "_glass");
    }
    
    public ResourceLocation swigId() {
        return new ResourceLocation("bundledelight", id + "_swig");
    }
}