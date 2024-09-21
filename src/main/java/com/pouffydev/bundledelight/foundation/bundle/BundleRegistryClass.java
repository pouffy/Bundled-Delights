package com.pouffydev.bundledelight.foundation.bundle;

import java.util.Objects;

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
