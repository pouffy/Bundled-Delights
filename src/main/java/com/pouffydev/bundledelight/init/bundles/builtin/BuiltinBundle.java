package com.pouffydev.bundledelight.init.bundles.builtin;

import com.pouffydev.bundledelight.foundation.bundle.Bundle;

import java.util.List;

public class BuiltinBundle extends Bundle {
    public BuiltinBundle() {
        super("bundledelight");
    }
    
    @Override
    public List<String> getRequiredClasses() {
        return List.of("com.pouffydev.bundledelight.BundledDelight");
    }
    
    @Override
    public void tryLoad() {
    
    }
    
    @Override
    protected void onLoad() {
    
    }
}
