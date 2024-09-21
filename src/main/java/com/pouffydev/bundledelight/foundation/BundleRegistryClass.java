package com.pouffydev.bundledelight.foundation;

import java.util.Objects;

import static com.pouffydev.bundledelight.foundation.BundleRegistryClass.getModid;

public class BundleRegistryClass {
    private static String modid = "bundledelight";
    
    public BundleRegistryClass() {
    }
    
    public BundleRegistryClass(String pModid) {
        modid = pModid;
    }
    
    public static String getModid() {
        return modid;
    }
    
    public static String getBundleName(String name) {
        return modid + "/" + name;
    }
    
    public static boolean isBuiltIn() {
        return Objects.equals(modid, "bundledelight");
    }
    
    public static String getBundleContentName(String name) {
        return isBuiltIn() ? name : getBundleName(name);
    }
}
