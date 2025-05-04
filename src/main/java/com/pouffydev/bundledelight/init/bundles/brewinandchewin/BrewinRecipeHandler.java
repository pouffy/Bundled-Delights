package com.pouffydev.bundledelight.init.bundles.brewinandchewin;

import com.pouffydev.bundledelight.BundledDelight;
import com.pouffydev.bundledelight.datagen.builder.recipe.BundleShapedRecipeBuilder;
import com.pouffydev.bundledelight.datagen.builder.recipe.BundleShapelessRecipeBuilder;
import com.pouffydev.bundledelight.datagen.builder.recipe.KegPouringRecipeBuilder;
import com.pouffydev.bundledelight.datagen.builder.recipe.KegRecipeBuilder;
import com.pouffydev.bundledelight.foundation.data.FinishedData;
import com.pouffydev.bundledelight.foundation.data.runtime.recipe.AbstractBundleRecipeHandler;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.Tags;
import org.jetbrains.annotations.NotNull;
import umpaz.brewinandchewin.client.recipebook.FermentingRecipeBookTab;
import umpaz.brewinandchewin.common.registry.BnCItems;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.ForgeTags;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

public class BrewinRecipeHandler extends AbstractBundleRecipeHandler {
    private static final String BUNDLE_NAME = "brewinandchewin";

    BrewinRecipeHandler() {}

    private static Map<String, String> drinks = new HashMap<>();
    private static Map<String, String> drinkTypes = new HashMap<>();

    static {
        drinks.put("root_beer", BundledDelight.MODID);
        drinks.put("beer", "brewinandchewin");
        drinks.put("vodka", "brewinandchewin");
        drinks.put("mead", "brewinandchewin");
        drinks.put("rice_wine", "brewinandchewin");
        drinks.put("egg_grog", "brewinandchewin");
        drinks.put("strongroot_ale", "brewinandchewin");
        drinks.put("saccharine_rum", "brewinandchewin");
        drinks.put("pale_jane", "brewinandchewin");
        drinks.put("salty_folly", "brewinandchewin");
        drinks.put("steel_toe_stout", "brewinandchewin");
        drinks.put("glittering_grenadine", "brewinandchewin");
        drinks.put("bloody_mary", "brewinandchewin");
        drinks.put("red_rum", "brewinandchewin");
        drinks.put("withering_dross", "brewinandchewin");
        drinks.put("dread_nog", "brewinandchewin");
        drinks.put("kombucha", "brewinandchewin");

        drinkTypes.put("default", "%s");
        drinkTypes.put("glass", "%s_glass");
    }

    public void run(@NotNull Consumer<FinishedRecipe> provider) {
        BundleShapedRecipeBuilder.shaped(BrewinItems.glassTankard.get(), BUNDLE_NAME)
                .pattern("# #")
                .pattern("# #")
                .pattern(" # ")
                .define('#', Tags.Items.GLASS)
                .unlockedBy("has_glass", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GLASS))
                .save(provider, new ResourceLocation(BundledDelight.MODID, "glass_tankard"));

        BundleShapelessRecipeBuilder.shapeless(BrewinItems.cheeseburger.get(), BUNDLE_NAME)
                .requires(ForgeTags.BREAD)
                .requires(ModItems.BEEF_PATTY.get())
                .requires(ForgeTags.SALAD_INGREDIENTS)
                .requires(ForgeTags.CROPS_TOMATO)
                .requires(ForgeTags.CROPS_ONION)
                .requires(BnCItems.FLAXEN_CHEESE_WEDGE.get())
                .unlockedBy("has_cheeseburger_ingredients", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.BEEF_PATTY.get(), BnCItems.FLAXEN_CHEESE_WEDGE.get()))
                .save(provider, new ResourceLocation(BundledDelight.MODID, "food/cheeseburger"));
        BundleShapelessRecipeBuilder.shapeless(BrewinItems.scarletCheeseburger.get(), BUNDLE_NAME)
                .requires(ForgeTags.BREAD)
                .requires(ModItems.BEEF_PATTY.get())
                .requires(ForgeTags.SALAD_INGREDIENTS)
                .requires(ForgeTags.CROPS_TOMATO)
                .requires(ForgeTags.CROPS_ONION)
                .requires(BnCItems.SCARLET_CHEESE_WEDGE.get())
                .unlockedBy("has_scarlet_cheeseburger_ingredients", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.BEEF_PATTY.get(), BnCItems.SCARLET_CHEESE_WEDGE.get()))
                .save(provider, new ResourceLocation(BundledDelight.MODID, "food/scarlet_cheeseburger"));
    }

    @Override
    public void runCustom(@NotNull Consumer<FinishedData> provider) {
        for (Map.Entry<String, String> drink : drinks.entrySet()) {
            ResourceLocation fluidId = new ResourceLocation(drink.getValue(), drink.getKey());
            for (Map.Entry<String, String> type : drinkTypes.entrySet()) {
                ResourceLocation outId = new ResourceLocation(BundledDelight.MODID, type.getValue().formatted(drink.getKey()));
                if (Objects.equals(type.getKey(), "default") && Objects.equals(drink.getKey(), "root_beer")) {
                    generateTankard(provider, fluidId, outId);
                }
                generateGlass(provider, fluidId, outId);
            }
        }
        fermentBrews(provider);
    }

    private static void fermentBrews(Consumer<FinishedData> consumer) {
        KegRecipeBuilder.kegRecipe(BrewinFluids.rootBeer.getSource(), 1000, 9600, 0.6F, 3, BUNDLE_NAME)
                .addFluidIngredient(Fluids.WATER, 1000)
                .addIngredient(Items.HANGING_ROOTS).addIngredient(Items.SUGAR).addIngredient(ModItems.TREE_BARK.get()).addIngredient(Items.HONEY_BOTTLE)
                .setRecipeBookTab(FermentingRecipeBookTab.DRINKS)
                .build(consumer);
    }

    private static void generateTankard(@NotNull Consumer<FinishedData> provider, ResourceLocation fluidId, ResourceLocation outId) {
        var output = BuiltInRegistries.ITEM.get(outId);
        var fluid = BuiltInRegistries.FLUID.get(fluidId);
        KegPouringRecipeBuilder.kegPouringRecipe(fluid, 250, output, BUNDLE_NAME).withContainer(BnCItems.TANKARD.get()).build(provider);
    }

    private static void generateGlass(@NotNull Consumer<FinishedData> provider, ResourceLocation fluidId, ResourceLocation outId) {
        var output = BuiltInRegistries.ITEM.get(outId);
        var fluid = BuiltInRegistries.FLUID.get(fluidId);
        KegPouringRecipeBuilder.kegPouringRecipe(fluid, 250, output, BUNDLE_NAME).withContainer(BrewinItems.glassTankard).build(provider);
    }
}
