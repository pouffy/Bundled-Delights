package com.pouffydev.bundledelight.init.bundles.builtin.data.recipe;

import com.pouffydev.bundledelight.BundledDelight;
import com.pouffydev.bundledelight.datagen.builder.recipe.BundleShapedRecipeBuilder;
import com.pouffydev.bundledelight.datagen.builder.recipe.BundleShapelessRecipeBuilder;
import com.pouffydev.bundledelight.foundation.data.BundleRecipeGen;
import com.pouffydev.bundledelight.init.bundles.builtin.BuiltinBlocks;
import com.pouffydev.bundledelight.init.bundles.builtin.BuiltinItems;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import vectorwing.farmersdelight.common.tag.ForgeTags;

import java.util.function.Consumer;

public class BuiltinCrafting extends BundleRecipeGen {
    private static final String BUNDLE_NAME = "builtin";
    public BuiltinCrafting() {
    }
    
    public static void register(Consumer<FinishedRecipe> consumer) {
        recipesFoodstuffs(consumer);
        recipesFoodBlocks(consumer);
    }
    
    private static void recipesFoodstuffs(Consumer<FinishedRecipe> consumer) {
        BundleShapelessRecipeBuilder.shapeless(BuiltinItems.sweetBerryJuice.get(), BUNDLE_NAME)
                .requires(Items.SWEET_BERRIES)
                .requires(Items.SWEET_BERRIES)
                .requires(Items.SWEET_BERRIES)
                .requires(Items.SWEET_BERRIES)
                .requires(Items.SUGAR)
                .requires(Items.GLASS_BOTTLE)
                .unlockedBy("has_sweet_berries", InventoryChangeTrigger.TriggerInstance.hasItems(Items.SWEET_BERRIES))
                .save(consumer, new ResourceLocation(BundledDelight.MODID, "food/sweet_berry_juice"));
    }
    
    private static void recipesFoodBlocks(Consumer<FinishedRecipe> consumer) {
        BundleShapedRecipeBuilder.shaped(BuiltinBlocks.carrotCake.get(), BUNDLE_NAME)
                .pattern("mcm")
                .pattern("ses")
                .pattern("wcw")
                .define('m', ForgeTags.MILK)
                .define('s', Items.SUGAR)
                .define('c', Items.CARROT)
                .define('e', Items.EGG)
                .define('w', Items.WHEAT)
                .unlockedBy("has_carrots", InventoryChangeTrigger.TriggerInstance.hasItems(Items.CARROT))
                .save(consumer, new ResourceLocation(BundledDelight.MODID, "food/carrot_cake"));
        BundleShapelessRecipeBuilder.shapeless(BuiltinBlocks.carrotCake.get(), BUNDLE_NAME)
                .requires(BuiltinItems.carrotCakeSlice.get())
                .requires(BuiltinItems.carrotCakeSlice.get())
                .requires(BuiltinItems.carrotCakeSlice.get())
                .requires(BuiltinItems.carrotCakeSlice.get())
                .requires(BuiltinItems.carrotCakeSlice.get())
                .requires(BuiltinItems.carrotCakeSlice.get())
                .requires(BuiltinItems.carrotCakeSlice.get())
                .unlockedBy("has_cake_slice", InventoryChangeTrigger.TriggerInstance.hasItems(BuiltinItems.carrotCakeSlice.get()))
                .save(consumer, new ResourceLocation(BundledDelight.MODID, "food/carrot_cake_from_slices"));
    }
    
    @Override
    public String getBundleName() {
        return BUNDLE_NAME;
    }
}
