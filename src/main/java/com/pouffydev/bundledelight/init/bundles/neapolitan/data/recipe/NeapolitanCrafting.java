package com.pouffydev.bundledelight.init.bundles.neapolitan.data.recipe;

import com.pouffydev.bundledelight.BundledDelight;
import com.pouffydev.bundledelight.datagen.RecipeShortcuts;
import com.pouffydev.bundledelight.datagen.builder.recipe.BundleShapedRecipeBuilder;
import com.pouffydev.bundledelight.datagen.builder.recipe.BundleShapelessRecipeBuilder;
import com.pouffydev.bundledelight.foundation.data.BundleRecipeGen;
import com.pouffydev.bundledelight.init.bundles.neapolitan.NeapolitanBlocks;
import com.pouffydev.bundledelight.init.bundles.neapolitan.NeapolitanItems;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import vectorwing.farmersdelight.common.tag.ForgeTags;

import java.util.function.Consumer;

public class NeapolitanCrafting extends BundleRecipeGen {
    private static final String BUNDLE_NAME = "neapolitan";

    public NeapolitanCrafting() {
        super();
    }

    public static void register(Consumer<FinishedRecipe> consumer) {
        recipesFoodstuffs(consumer);
        recipesFoodBlocks(consumer);
    }

    private static void recipesFoodstuffs(Consumer<FinishedRecipe> consumer) {
        createIceCream(NeapolitanItems.whiteStrawberryIceCream.get(), com.teamabnormals.neapolitan.core.registry.NeapolitanItems.WHITE_STRAWBERRIES.get()).save(consumer, new ResourceLocation(BundledDelight.MODID, "food/white_strawberry_ice_cream"));
        createIceCream(NeapolitanItems.sweetBerryIceCream.get(), Items.SWEET_BERRIES).save(consumer, new ResourceLocation(BundledDelight.MODID, "food/sweet_berry_ice_cream"));
        createMilkshake(NeapolitanItems.whiteStrawberryMilkshake.get(), NeapolitanItems.whiteStrawberryIceCream.get()).save(consumer, new ResourceLocation(BundledDelight.MODID, "food/white_strawberry_milkshake"));
        createMilkshake(NeapolitanItems.sweetBerryMilkshake.get(), NeapolitanItems.sweetBerryIceCream.get()).save(consumer, new ResourceLocation(BundledDelight.MODID, "food/sweet_berry_milkshake"));
    }

    private static void recipesFoodBlocks(Consumer<FinishedRecipe> consumer) {
        RecipeShortcuts.cake(NeapolitanBlocks.whiteStrawberryCake.get(), com.teamabnormals.neapolitan.core.registry.NeapolitanItems.WHITE_STRAWBERRIES.get(), BUNDLE_NAME).save(consumer, new ResourceLocation(BundledDelight.MODID, "food/white_strawberry_cake"));
        RecipeShortcuts.compactCakeFromSlices(NeapolitanBlocks.whiteStrawberryCake.get(), NeapolitanItems.whiteStrawberryCakeSlice.get(), BUNDLE_NAME).save(consumer, new ResourceLocation(BundledDelight.MODID, "food/white_strawberry_cake_from_slices"));

        RecipeShortcuts.compact3x3(NeapolitanBlocks.mintLeafSack.get(), com.teamabnormals.neapolitan.core.registry.NeapolitanItems.MINT_LEAVES.get(), BUNDLE_NAME).save(consumer, new ResourceLocation(BundledDelight.MODID, "storage/mint_leaf_sack"));
        RecipeShortcuts.compact3x3(NeapolitanBlocks.adzukiBeanSack.get(), com.teamabnormals.neapolitan.core.registry.NeapolitanItems.ADZUKI_BEANS.get(), BUNDLE_NAME).save(consumer, new ResourceLocation(BundledDelight.MODID, "storage/adzuki_bean_sack"));
        RecipeShortcuts.compact3x3(NeapolitanBlocks.roastedAdzukiBeanSack.get(), com.teamabnormals.neapolitan.core.registry.NeapolitanItems.ROASTED_ADZUKI_BEANS.get(), BUNDLE_NAME).save(consumer, new ResourceLocation(BundledDelight.MODID, "storage/roasted_adzuki_bean_sack"));

        RecipeShortcuts.compact3x3(NeapolitanBlocks.powderedAdzukiBeansSack.get(), NeapolitanItems.powderedAdzukiBeans.get(), BUNDLE_NAME).save(consumer, new ResourceLocation(BundledDelight.MODID, "storage/powdered_adzuki_beans_sack"));
        RecipeShortcuts.compact3x3(NeapolitanBlocks.powderedMintLeavesSack.get(), NeapolitanItems.powderedMintLeaves.get(), BUNDLE_NAME).save(consumer, new ResourceLocation(BundledDelight.MODID, "storage/powdered_mint_leaves_sack"));
        RecipeShortcuts.compact3x3(NeapolitanBlocks.powderedVanillaSack.get(), NeapolitanItems.powderedVanilla.get(), BUNDLE_NAME).save(consumer, new ResourceLocation(BundledDelight.MODID, "storage/powdered_vanilla_sack"));

        RecipeShortcuts.decompact3x3(com.teamabnormals.neapolitan.core.registry.NeapolitanItems.MINT_LEAVES.get(), NeapolitanBlocks.mintLeafSack.get(), BUNDLE_NAME).save(consumer, new ResourceLocation(BundledDelight.MODID, "storage/mint_leaves_from_sack"));
        RecipeShortcuts.decompact3x3(com.teamabnormals.neapolitan.core.registry.NeapolitanItems.ADZUKI_BEANS.get(), NeapolitanBlocks.adzukiBeanSack.get(), BUNDLE_NAME).save(consumer, new ResourceLocation(BundledDelight.MODID, "storage/adzuki_beans_from_sack"));
        RecipeShortcuts.decompact3x3(com.teamabnormals.neapolitan.core.registry.NeapolitanItems.ROASTED_ADZUKI_BEANS.get(), NeapolitanBlocks.roastedAdzukiBeanSack.get(), BUNDLE_NAME).save(consumer, new ResourceLocation(BundledDelight.MODID, "storage/roasted_adzuki_beans_from_sack"));

        RecipeShortcuts.decompact3x3(NeapolitanItems.powderedAdzukiBeans.get(), NeapolitanBlocks.powderedAdzukiBeansSack.get(), BUNDLE_NAME).save(consumer, new ResourceLocation(BundledDelight.MODID, "storage/powdered_adzuki_beans_from_sack"));
        RecipeShortcuts.decompact3x3(NeapolitanItems.powderedMintLeaves.get(), NeapolitanBlocks.powderedMintLeavesSack.get(), BUNDLE_NAME).save(consumer, new ResourceLocation(BundledDelight.MODID, "storage/powdered_mint_leaves_from_sack"));
        RecipeShortcuts.decompact3x3(NeapolitanItems.powderedVanilla.get(), NeapolitanBlocks.powderedVanillaSack.get(), BUNDLE_NAME).save(consumer, new ResourceLocation(BundledDelight.MODID, "storage/powdered_vanilla_from_sack"));

        createIceCreamBlock(NeapolitanBlocks.whiteStrawberryIceCreamBlock.get(), NeapolitanItems.whiteStrawberryIceCream.get()).save(consumer, new ResourceLocation(BundledDelight.MODID, "storage/white_strawberry_ice_cream_block"));
        createIceCreamBlock(NeapolitanBlocks.sweetBerryIceCreamBlock.get(), NeapolitanItems.sweetBerryIceCream.get()).save(consumer, new ResourceLocation(BundledDelight.MODID, "storage/sweet_berry_ice_cream_block"));
    }

    private static BundleShapelessRecipeBuilder createIceCream(ItemLike result, ItemLike mainIngredient) {
        return BundleShapelessRecipeBuilder.shapeless(result, BUNDLE_NAME)
                .requires(Items.BOWL)
                .requires(mainIngredient)
                .requires(ForgeTags.MILK)
                .requires(com.teamabnormals.neapolitan.core.registry.NeapolitanItems.ICE_CUBES.get())
                .requires(Items.SUGAR)
                .unlockedBy("has_ingredient", InventoryChangeTrigger.TriggerInstance.hasItems(mainIngredient));
    }

    private static BundleShapelessRecipeBuilder createMilkshake(ItemLike result, ItemLike iceCream) {
        return BundleShapelessRecipeBuilder.shapeless(result, BUNDLE_NAME)
                .requires(Items.GLASS_BOTTLE)
                .requires(Items.GLASS_BOTTLE)
                .requires(Items.GLASS_BOTTLE)
                .requires(iceCream)
                .requires(ForgeTags.MILK)
                .unlockedBy("has_ingredient", InventoryChangeTrigger.TriggerInstance.hasItems(iceCream));
    }

    private static BundleShapedRecipeBuilder createIceCreamBlock(ItemLike result, ItemLike iceCream) {
        return RecipeShortcuts.doughnutCraft(result, iceCream, Items.SNOW_BLOCK, BUNDLE_NAME);
    }

    @Override
    public String getBundleName() {
        return BUNDLE_NAME;
    }
}
