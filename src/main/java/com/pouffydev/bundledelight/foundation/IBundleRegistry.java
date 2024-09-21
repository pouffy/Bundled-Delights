package com.pouffydev.bundledelight.foundation;

import java.util.Objects;

public interface IBundleRegistry {
    
    static String modid() {
        return "bundledelight";
    }
    
    static String getBundleName(String name) {
        return modid() + "/" + name;
    }
    
    static boolean isBuiltIn() {
        return Objects.equals(modid(), "bundledelight");
    }
    
    static String getBundleContentName(String name) {
        return isBuiltIn() ? name : getBundleName(name);
    }
}
