package com.pouffy.bundledelight.util.data.recipes;

import com.brewinandchewin.core.registry.BCItems;
import com.farmersrespite.core.registry.FRItems;
import com.pouffy.bundledelight.compats.brewinandchewin.BrewinItems;
import com.pouffy.bundledelight.compats.brewinandchewin.BrewinMDItems;
import com.pouffy.bundledelight.compats.farmersrespite.RespiteItems;
import com.pouffy.bundledelight.init.BDItems;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.Tags;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.ForgeTags;

import java.util.function.Consumer;

import static com.pouffy.bundledelight.compats.farmersrespite.RespiteMDItems.CUP;

public class CraftingRecipes {

    public CraftingRecipes() {
    }

    public static void register(Consumer<FinishedRecipe> consumer) {
        recipesBlocks(consumer);
        recipesTools(consumer);
        recipesMaterials(consumer);
        recipesFoodstuffs(consumer);
        recipesFoodBlocks(consumer);
        recipesCraftedMeals(consumer);
    }

    private static void recipesBlocks(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped((ItemLike) RespiteItems.GREEN_TEA_POWDER_BASKET.get(), 1).pattern("###").pattern("###").pattern("###").define('#', (ItemLike) RespiteItems.POWDERED_GREEN_TEA_LEAVES.get()).unlockedBy("has_green_tea_powder", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike) RespiteItems.POWDERED_GREEN_TEA_LEAVES.get())).save(consumer);
        ShapedRecipeBuilder.shaped((ItemLike) RespiteItems.YELLOW_TEA_POWDER_BASKET.get(), 1).pattern("###").pattern("###").pattern("###").define('#', (ItemLike) RespiteItems.POWDERED_YELLOW_TEA_LEAVES.get()).unlockedBy("has_yellow_tea_powder", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike) RespiteItems.POWDERED_YELLOW_TEA_LEAVES.get())).save(consumer);
        ShapedRecipeBuilder.shaped((ItemLike) RespiteItems.BLACK_TEA_POWDER_BASKET.get(), 1).pattern("###").pattern("###").pattern("###").define('#', (ItemLike) RespiteItems.POWDERED_BLACK_TEA_LEAVES.get()).unlockedBy("has_black_tea_powder", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike) RespiteItems.POWDERED_BLACK_TEA_LEAVES.get())).save(consumer);
        ShapedRecipeBuilder.shaped((ItemLike) RespiteItems.COFFEE_POWDER_BASKET.get(), 1).pattern("###").pattern("###").pattern("###").define('#', (ItemLike) RespiteItems.POWDERED_COFFEE_BEANS.get()).unlockedBy("has_coffee_powder", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike) RespiteItems.POWDERED_COFFEE_BEANS.get())).save(consumer);

        ShapedRecipeBuilder.shaped((ItemLike) RespiteItems.GREEN_TEA_CRATE.get(), 1).pattern("###").pattern("###").pattern("###").define('#', (ItemLike) FRItems.GREEN_TEA_LEAVES.get()).unlockedBy("has_green_tea_leaves", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike) FRItems.GREEN_TEA_LEAVES.get())).save(consumer);
        ShapedRecipeBuilder.shaped((ItemLike) RespiteItems.YELLOW_TEA_CRATE.get(), 1).pattern("###").pattern("###").pattern("###").define('#', (ItemLike) FRItems.YELLOW_TEA_LEAVES.get()).unlockedBy("has_yellow_tea_leaves", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike) FRItems.YELLOW_TEA_LEAVES.get())).save(consumer);
        ShapedRecipeBuilder.shaped((ItemLike) RespiteItems.BLACK_TEA_CRATE.get(), 1).pattern("###").pattern("###").pattern("###").define('#', (ItemLike) FRItems.BLACK_TEA_LEAVES.get()).unlockedBy("has_black_tea_leaves", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike) FRItems.BLACK_TEA_LEAVES.get())).save(consumer);
        ShapedRecipeBuilder.shaped((ItemLike) RespiteItems.COFFEE_CRATE.get(), 1).pattern("###").pattern("###").pattern("###").define('#', (ItemLike) FRItems.COFFEE_BEANS.get()).unlockedBy("has_coffee_beans", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike) FRItems.COFFEE_BEANS.get())).save(consumer);

        ShapedRecipeBuilder.shaped((ItemLike) BrewinMDItems.COPPER_TANKARD.get()).pattern("# #").pattern("- -").pattern("###").define('-', Tags.Items.NUGGETS_IRON).define('#', Tags.Items.INGOTS_COPPER).unlockedBy("has_copper", InventoryChangeTrigger.TriggerInstance.hasItems(new ItemLike[]{Items.COPPER_INGOT})).save(consumer);
        ShapedRecipeBuilder.shaped((ItemLike) CUP.get()).pattern("# #").pattern(" #-").define('-', ModItems.CANVAS.get()).define('#', Tags.Items.INGOTS_COPPER).unlockedBy("has_copper", InventoryChangeTrigger.TriggerInstance.hasItems(new ItemLike[]{Items.COPPER_INGOT})).save(consumer);

    }

    private static void recipesTools(Consumer<FinishedRecipe> consumer) {

    }

    private static void recipesMaterials(Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(RespiteItems.POWDERED_GREEN_TEA_LEAVES.get(), 9).requires((ItemLike)RespiteItems.GREEN_TEA_POWDER_BASKET.get()).unlockedBy("has_green_tea_powder_basket", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike)RespiteItems.GREEN_TEA_POWDER_BASKET.get())).save(consumer, new ResourceLocation("bundledelight", "green_tea_powder_from_basket"));
        ShapelessRecipeBuilder.shapeless(RespiteItems.POWDERED_YELLOW_TEA_LEAVES.get(), 9).requires((ItemLike)RespiteItems.YELLOW_TEA_POWDER_BASKET.get()).unlockedBy("has_yellow_tea_powder_basket", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike)RespiteItems.YELLOW_TEA_POWDER_BASKET.get())).save(consumer, new ResourceLocation("bundledelight", "yellow_tea_powder_from_basket"));
        ShapelessRecipeBuilder.shapeless(RespiteItems.POWDERED_BLACK_TEA_LEAVES.get(), 9).requires((ItemLike)RespiteItems.BLACK_TEA_POWDER_BASKET.get()).unlockedBy("has_black_tea_powder_basket", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike)RespiteItems.BLACK_TEA_POWDER_BASKET.get())).save(consumer, new ResourceLocation("bundledelight", "black_tea_powder_from_basket"));
        ShapelessRecipeBuilder.shapeless(RespiteItems.POWDERED_COFFEE_BEANS.get(), 9).requires((ItemLike)RespiteItems.COFFEE_POWDER_BASKET.get()).unlockedBy("has_coffee_powder_basket", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike)RespiteItems.COFFEE_POWDER_BASKET.get())).save(consumer, new ResourceLocation("bundledelight", "coffee_powder_from_basket"));

        ShapelessRecipeBuilder.shapeless(FRItems.GREEN_TEA_LEAVES.get(), 9).requires((ItemLike)RespiteItems.GREEN_TEA_CRATE.get()).unlockedBy("has_green_tea_basket", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike)RespiteItems.GREEN_TEA_CRATE.get())).save(consumer, new ResourceLocation("bundledelight", "green_tea_leaves_from_crate"));
        ShapelessRecipeBuilder.shapeless(FRItems.YELLOW_TEA_LEAVES.get(), 9).requires((ItemLike)RespiteItems.YELLOW_TEA_CRATE.get()).unlockedBy("has_yellow_tea_basket", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike)RespiteItems.YELLOW_TEA_CRATE.get())).save(consumer, new ResourceLocation("bundledelight", "yellow_tea_leaves_from_crate"));
        ShapelessRecipeBuilder.shapeless(FRItems.BLACK_TEA_LEAVES.get(), 9).requires((ItemLike)RespiteItems.BLACK_TEA_CRATE.get()).unlockedBy("has_black_tea_basket", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike)RespiteItems.BLACK_TEA_CRATE.get())).save(consumer, new ResourceLocation("bundledelight", "black_tea_leaves_from_crate"));
        ShapelessRecipeBuilder.shapeless(FRItems.COFFEE_BEANS.get(), 9).requires((ItemLike)RespiteItems.COFFEE_CRATE.get()).unlockedBy("has_coffee_basket", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike)RespiteItems.COFFEE_CRATE.get())).save(consumer, new ResourceLocation("bundledelight", "coffee_beans_from_crate"));

    }

    private static void recipesFoodstuffs(Consumer<FinishedRecipe> consumer) {

    }

    private static void recipesFoodBlocks(Consumer<FinishedRecipe> consumer) {

    }

    private static void recipesCraftedMeals(Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless((ItemLike) BrewinItems.CHEESEBURGER.get()).requires(ForgeTags.BREAD).requires((ItemLike)ModItems.BEEF_PATTY.get()).requires(ForgeTags.SALAD_INGREDIENTS).requires(ForgeTags.CROPS_TOMATO).requires(ForgeTags.CROPS_ONION).requires((ItemLike) BCItems.FLAXEN_CHEESE_WEDGE.get()).unlockedBy("has_cheeseburger_ingredients", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike)ModItems.BEEF_PATTY.get(), (ItemLike)BCItems.FLAXEN_CHEESE_WEDGE.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless((ItemLike) BrewinItems.SCARLET_CHEESEBURGER.get()).requires(ForgeTags.BREAD).requires((ItemLike)ModItems.BEEF_PATTY.get()).requires(ForgeTags.SALAD_INGREDIENTS).requires(ForgeTags.CROPS_TOMATO).requires(ForgeTags.CROPS_ONION).requires((ItemLike) BCItems.SCARLET_CHEESE_WEDGE.get()).unlockedBy("has_scarlet_cheeseburger_ingredients", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike)ModItems.BEEF_PATTY.get(), (ItemLike)BCItems.SCARLET_CHEESE_WEDGE.get())).save(consumer);
    }




    }
