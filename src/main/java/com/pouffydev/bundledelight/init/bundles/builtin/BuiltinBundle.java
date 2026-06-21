package com.pouffydev.bundledelight.init.bundles.builtin;

import com.pouffydev.bundledelight.BundledDelight;
import com.pouffydev.bundledelight.foundation.data.BundleRecipeGen;
import com.pouffydev.krystal_core.foundation.bundle.Bundle;

import com.pouffydev.krystal_core.foundation.bundle.BundleManager;
import com.pouffydev.krystal_core.foundation.bundle.runtime.AbstractBundleRecipeHandler;
import com.pouffydev.krystal_core.foundation.dynamicpack.data.recipe.custom.farmersdelight.CookingPotRecipe;
import com.pouffydev.krystal_core.foundation.dynamicpack.data.recipe.output.CustomRecipeOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import org.jetbrains.annotations.NotNull;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.CommonTags;

import java.util.List;

public class BuiltinBundle extends Bundle {

    public BuiltinBundle(BundleManager manager) {
        super(manager);
    }

    @Override
    public List<String> getRequiredClasses() {
        return List.of();
    }
    
    @Override
    public String getName() {
        return "builtin";
    }
    
    @Override
    protected void onLoad() {
        BuiltinItems.register();
        BuiltinBlocks.register();
    }

    @Override
    public void runDatagen(GatherDataEvent gatherDataEvent) {
        BundledDelight.LOGGER.info("Running Builtin datagen");
        BuiltinDatagen.gatherData(gatherDataEvent.getGenerator(), gatherDataEvent.getExistingFileHelper(), gatherDataEvent.includeClient(), gatherDataEvent.includeServer());
    }

    @Override
    public void addCreative(BuildCreativeModeTabContentsEvent buildCreativeModeTabContentsEvent) {

    }

    @Override
    public AbstractBundleRecipeHandler getRecipeHandler() {
        return new AbstractBundleRecipeHandler() {
            @Override
            public void run(@NotNull RecipeOutput recipeOutput) {

            }

            @Override
            public void runCustom(@NotNull CustomRecipeOutput output) {
                output.accept(BundledDelight.location("cooking/borscht"),
                        CookingPotRecipe.cookingPotRecipe(BuiltinItems.borscht.get(), 1, BundleRecipeGen.NORMAL_COOKING, BundleRecipeGen.MEDIUM_EXP)
                        .addIngredient(CommonTags.Items.FOODS_RAW_BEEF)
                        .addIngredient(Items.BEETROOT)
                        .addIngredient(CommonTags.Items.CROPS_CABBAGE)
                        .addIngredient(ModItems.TOMATO_SAUCE.get())
                        .setRecipeBookTab(CookingPotRecipe.CookingPotRecipeBookTab.MEALS), null);
            }
        };
    }
}
