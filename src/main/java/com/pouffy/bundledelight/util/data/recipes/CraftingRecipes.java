package com.pouffy.bundledelight.util.data.recipes;

import com.brewinandchewin.core.registry.BCItems;
import com.farmersrespite.core.registry.FRItems;
import com.pouffy.bundledelight.compats.brewinandchewin.BrewinItems;
import com.pouffy.bundledelight.compats.brewinandchewin.BrewinMDItems;
import com.pouffy.bundledelight.compats.farmersrespite.RespiteItems;
import com.pouffy.bundledelight.compats.neapolitan.NeapolitanCompatItems;
import com.teamabnormals.neapolitan.core.registry.NeapolitanItems;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.Tags;
import plus.dragons.respiteful.entries.RespitefulBlocks;
import plus.dragons.respiteful.entries.RespitefulItems;
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
        recipesNeapolitan(consumer);
        recipesRespite(consumer);
    }

    private static void recipesBlocks(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped((ItemLike) RespiteItems.GREEN_TEA_POWDER_BASKET.get(), 1).pattern("###").pattern("###").pattern("###").define('#', (ItemLike) RespiteItems.POWDERED_GREEN_TEA_LEAVES.get()).unlockedBy("has_green_tea_powder", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike) RespiteItems.POWDERED_GREEN_TEA_LEAVES.get())).save(consumer, new ResourceLocation("bundledelight", "packing/green_tea_powder_basket"));
        ShapedRecipeBuilder.shaped((ItemLike) RespiteItems.YELLOW_TEA_POWDER_BASKET.get(), 1).pattern("###").pattern("###").pattern("###").define('#', (ItemLike) RespiteItems.POWDERED_YELLOW_TEA_LEAVES.get()).unlockedBy("has_yellow_tea_powder", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike) RespiteItems.POWDERED_YELLOW_TEA_LEAVES.get())).save(consumer, new ResourceLocation("bundledelight", "packing/yellow_tea_powder_basket"));
        ShapedRecipeBuilder.shaped((ItemLike) RespiteItems.BLACK_TEA_POWDER_BASKET.get(), 1).pattern("###").pattern("###").pattern("###").define('#', (ItemLike) RespiteItems.POWDERED_BLACK_TEA_LEAVES.get()).unlockedBy("has_black_tea_powder", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike) RespiteItems.POWDERED_BLACK_TEA_LEAVES.get())).save(consumer, new ResourceLocation("bundledelight", "packing/black_tea_powder_basket"));
        ShapedRecipeBuilder.shaped((ItemLike) RespiteItems.COFFEE_POWDER_BASKET.get(), 1).pattern("###").pattern("###").pattern("###").define('#', (ItemLike) RespiteItems.POWDERED_COFFEE_BEANS.get()).unlockedBy("has_coffee_powder", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike) RespiteItems.POWDERED_COFFEE_BEANS.get())).save(consumer, new ResourceLocation("bundledelight", "packing/coffee_bean_powder_basket"));
        ShapedRecipeBuilder.shaped((ItemLike) NeapolitanCompatItems.ADZUKI_POWDER_CRATE.get(), 1).pattern("###").pattern("###").pattern("###").define('#', (ItemLike) NeapolitanCompatItems.POWDERED_ADZUKI_BEANS.get()).unlockedBy("has_adzuki_powder", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike) NeapolitanCompatItems.POWDERED_ADZUKI_BEANS.get())).save(consumer, new ResourceLocation("bundledelight", "packing/adzuki_powder_basket"));
        ShapedRecipeBuilder.shaped((ItemLike) NeapolitanCompatItems.VANILLA_POWDER_CRATE.get(), 1).pattern("###").pattern("###").pattern("###").define('#', (ItemLike) NeapolitanCompatItems.POWDERED_VANILLA_PODS.get()).unlockedBy("has_vanilla_powder", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike) NeapolitanCompatItems.POWDERED_VANILLA_PODS.get())).save(consumer, new ResourceLocation("bundledelight", "packing/vanilla_powder_basket"));
        ShapedRecipeBuilder.shaped((ItemLike) NeapolitanCompatItems.MINT_POWDER_CRATE.get(), 1).pattern("###").pattern("###").pattern("###").define('#', (ItemLike) NeapolitanCompatItems.POWDERED_MINT_LEAVES.get()).unlockedBy("has_mint_powder", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike) NeapolitanCompatItems.POWDERED_MINT_LEAVES.get())).save(consumer, new ResourceLocation("bundledelight", "packing/mint_powder_basket"));
        ShapedRecipeBuilder.shaped((ItemLike) RespiteItems.GREEN_TEA_CRATE.get(), 1).pattern("###").pattern("###").pattern("###").define('#', (ItemLike) FRItems.GREEN_TEA_LEAVES.get()).unlockedBy("has_green_tea_leaves", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike) FRItems.GREEN_TEA_LEAVES.get())).save(consumer, new ResourceLocation("bundledelight", "packing/green_tea_basket"));
        ShapedRecipeBuilder.shaped((ItemLike) RespiteItems.YELLOW_TEA_CRATE.get(), 1).pattern("###").pattern("###").pattern("###").define('#', (ItemLike) FRItems.YELLOW_TEA_LEAVES.get()).unlockedBy("has_yellow_tea_leaves", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike) FRItems.YELLOW_TEA_LEAVES.get())).save(consumer, new ResourceLocation("bundledelight", "packing/yellow_tea_basket"));
        ShapedRecipeBuilder.shaped((ItemLike) RespiteItems.BLACK_TEA_CRATE.get(), 1).pattern("###").pattern("###").pattern("###").define('#', (ItemLike) FRItems.BLACK_TEA_LEAVES.get()).unlockedBy("has_black_tea_leaves", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike) FRItems.BLACK_TEA_LEAVES.get())).save(consumer, new ResourceLocation("bundledelight", "packing/black_tea_basket"));
        ShapedRecipeBuilder.shaped((ItemLike) RespiteItems.COFFEE_CRATE.get(), 1).pattern("###").pattern("###").pattern("###").define('#', (ItemLike) FRItems.COFFEE_BEANS.get()).unlockedBy("has_coffee_beans", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike) FRItems.COFFEE_BEANS.get())).save(consumer, new ResourceLocation("bundledelight", "packing/coffee_bean_basket"));
        ShapedRecipeBuilder.shaped((ItemLike) NeapolitanCompatItems.ADZUKI_CRATE.get(), 1).pattern("###").pattern("###").pattern("###").define('#', (ItemLike) NeapolitanItems.ADZUKI_BEANS.get()).unlockedBy("has_adzuki_beans", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike) NeapolitanItems.ADZUKI_BEANS.get())).save(consumer, new ResourceLocation("bundledelight", "packing/adzuki_basket"));
        ShapedRecipeBuilder.shaped((ItemLike) NeapolitanCompatItems.VANILLA_CRATE.get(), 1).pattern("###").pattern("###").pattern("###").define('#', (ItemLike) NeapolitanItems.DRIED_VANILLA_PODS.get()).unlockedBy("has_dried_vanilla_pods", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike) NeapolitanItems.DRIED_VANILLA_PODS.get())).save(consumer, new ResourceLocation("bundledelight", "packing/vanilla_basket"));
        ShapedRecipeBuilder.shaped((ItemLike) NeapolitanCompatItems.MINT_CRATE.get(), 1).pattern("###").pattern("###").pattern("###").define('#', (ItemLike) NeapolitanItems.MINT_LEAVES.get()).unlockedBy("has_mint_leaves", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike) NeapolitanItems.MINT_LEAVES.get())).save(consumer, new ResourceLocation("bundledelight", "packing/mint_basket"));
        ShapedRecipeBuilder.shaped((ItemLike) BrewinMDItems.COPPER_TANKARD.get()).pattern("# #").pattern("- -").pattern("###").define('-', Tags.Items.NUGGETS_IRON).define('#', Tags.Items.INGOTS_COPPER).unlockedBy("has_copper", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COPPER_INGOT)).save(consumer, new ResourceLocation("bundledelight", "crafting/copper_tankard"));
        ShapedRecipeBuilder.shaped((ItemLike) CUP.get()).pattern("# #").pattern(" #-").define('-', ModItems.CANVAS.get()).define('#', Tags.Items.INGOTS_COPPER).unlockedBy("has_copper", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COPPER_INGOT)).save(consumer, new ResourceLocation("bundledelight", "crafting/copper_mug"));
    }

    private static void recipesTools(Consumer<FinishedRecipe> consumer) {
    }

    private static void recipesMaterials(Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(RespiteItems.POWDERED_GREEN_TEA_LEAVES.get(), 9).requires((ItemLike)RespiteItems.GREEN_TEA_POWDER_BASKET.get()).unlockedBy("has_green_tea_powder_basket", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike)RespiteItems.GREEN_TEA_POWDER_BASKET.get())).save(consumer, new ResourceLocation("bundledelight", "unpacking/green_tea_powder_from_basket"));
        ShapelessRecipeBuilder.shapeless(RespiteItems.POWDERED_YELLOW_TEA_LEAVES.get(), 9).requires((ItemLike)RespiteItems.YELLOW_TEA_POWDER_BASKET.get()).unlockedBy("has_yellow_tea_powder_basket", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike)RespiteItems.YELLOW_TEA_POWDER_BASKET.get())).save(consumer, new ResourceLocation("bundledelight", "unpacking/yellow_tea_powder_from_basket"));
        ShapelessRecipeBuilder.shapeless(RespiteItems.POWDERED_BLACK_TEA_LEAVES.get(), 9).requires((ItemLike)RespiteItems.BLACK_TEA_POWDER_BASKET.get()).unlockedBy("has_black_tea_powder_basket", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike)RespiteItems.BLACK_TEA_POWDER_BASKET.get())).save(consumer, new ResourceLocation("bundledelight", "unpacking/black_tea_powder_from_basket"));
        ShapelessRecipeBuilder.shapeless(RespiteItems.POWDERED_COFFEE_BEANS.get(), 9).requires((ItemLike)RespiteItems.COFFEE_POWDER_BASKET.get()).unlockedBy("has_coffee_powder_basket", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike)RespiteItems.COFFEE_POWDER_BASKET.get())).save(consumer, new ResourceLocation("bundledelight", "unpacking/coffee_powder_from_basket"));
        ShapelessRecipeBuilder.shapeless(FRItems.GREEN_TEA_LEAVES.get(), 9).requires((ItemLike)RespiteItems.GREEN_TEA_CRATE.get()).unlockedBy("has_green_tea_basket", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike)RespiteItems.GREEN_TEA_CRATE.get())).save(consumer, new ResourceLocation("bundledelight", "unpacking/green_tea_leaves_from_crate"));
        ShapelessRecipeBuilder.shapeless(FRItems.YELLOW_TEA_LEAVES.get(), 9).requires((ItemLike)RespiteItems.YELLOW_TEA_CRATE.get()).unlockedBy("has_yellow_tea_basket", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike)RespiteItems.YELLOW_TEA_CRATE.get())).save(consumer, new ResourceLocation("bundledelight", "unpacking/yellow_tea_leaves_from_crate"));
        ShapelessRecipeBuilder.shapeless(FRItems.BLACK_TEA_LEAVES.get(), 9).requires((ItemLike)RespiteItems.BLACK_TEA_CRATE.get()).unlockedBy("has_black_tea_basket", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike)RespiteItems.BLACK_TEA_CRATE.get())).save(consumer, new ResourceLocation("bundledelight", "unpacking/black_tea_leaves_from_crate"));
        ShapelessRecipeBuilder.shapeless(FRItems.COFFEE_BEANS.get(), 9).requires((ItemLike)RespiteItems.COFFEE_CRATE.get()).unlockedBy("has_coffee_basket", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike)RespiteItems.COFFEE_CRATE.get())).save(consumer, new ResourceLocation("bundledelight", "unpacking/coffee_beans_from_crate"));
        ShapelessRecipeBuilder.shapeless(NeapolitanItems.ADZUKI_BEANS.get(), 9).requires((ItemLike)NeapolitanCompatItems.ADZUKI_CRATE.get()).unlockedBy("has_adzuki_crate", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike)NeapolitanCompatItems.ADZUKI_CRATE.get())).save(consumer, new ResourceLocation("bundledelight", "unpacking/adzuki_beans_from_crate"));
        ShapelessRecipeBuilder.shapeless(NeapolitanItems.DRIED_VANILLA_PODS.get(), 9).requires((ItemLike)NeapolitanCompatItems.VANILLA_CRATE.get()).unlockedBy("has_vanilla_crate", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike)NeapolitanCompatItems.VANILLA_CRATE.get())).save(consumer, new ResourceLocation("bundledelight", "unpacking/dried_vanilla_pods_from_crate"));
        ShapelessRecipeBuilder.shapeless(NeapolitanItems.MINT_LEAVES.get(), 9).requires((ItemLike)NeapolitanCompatItems.MINT_CRATE.get()).unlockedBy("has_mint_crate", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike)NeapolitanCompatItems.MINT_CRATE.get())).save(consumer, new ResourceLocation("bundledelight", "unpacking/mint_leaves_from_crate"));
        ShapelessRecipeBuilder.shapeless(NeapolitanCompatItems.POWDERED_MINT_LEAVES.get(), 9).requires((ItemLike)NeapolitanCompatItems.MINT_POWDER_CRATE.get()).unlockedBy("has_mint_powder_crate", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike)NeapolitanCompatItems.MINT_POWDER_CRATE.get())).save(consumer, new ResourceLocation("bundledelight", "unpacking/mint_powder_from_basket"));
        ShapelessRecipeBuilder.shapeless(NeapolitanCompatItems.POWDERED_ADZUKI_BEANS.get(), 9).requires((ItemLike)NeapolitanCompatItems.ADZUKI_POWDER_CRATE.get()).unlockedBy("has_adzuki_powder_crate", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike)NeapolitanCompatItems.ADZUKI_POWDER_CRATE.get())).save(consumer, new ResourceLocation("bundledelight", "unpacking/adzuki_powder_from_basket"));
        ShapelessRecipeBuilder.shapeless(NeapolitanCompatItems.POWDERED_VANILLA_PODS.get(), 9).requires((ItemLike)NeapolitanCompatItems.VANILLA_POWDER_CRATE.get()).unlockedBy("has_vanilla_powder_crate", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike)NeapolitanCompatItems.VANILLA_POWDER_CRATE.get())).save(consumer, new ResourceLocation("bundledelight", "unpacking/vanilla_powder_from_basket"));
    }

    private static void recipesFoodstuffs(Consumer<FinishedRecipe> consumer) {
    }

    private static void recipesFoodBlocks(Consumer<FinishedRecipe> consumer) {
    }

    private static void recipesCraftedMeals(Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless((ItemLike) BrewinItems.CHEESEBURGER.get()).requires(ForgeTags.BREAD).requires((ItemLike)ModItems.BEEF_PATTY.get()).requires(ForgeTags.SALAD_INGREDIENTS).requires(ForgeTags.CROPS_TOMATO).requires(ForgeTags.CROPS_ONION).requires((ItemLike) BCItems.FLAXEN_CHEESE_WEDGE.get()).unlockedBy("has_cheeseburger_ingredients", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike)ModItems.BEEF_PATTY.get(), (ItemLike)BCItems.FLAXEN_CHEESE_WEDGE.get())).save(consumer, new ResourceLocation("bundledelight", "food/cheeseburger"));
        ShapelessRecipeBuilder.shapeless((ItemLike) BrewinItems.SCARLET_CHEESEBURGER.get()).requires(ForgeTags.BREAD).requires((ItemLike)ModItems.BEEF_PATTY.get()).requires(ForgeTags.SALAD_INGREDIENTS).requires(ForgeTags.CROPS_TOMATO).requires(ForgeTags.CROPS_ONION).requires((ItemLike) BCItems.SCARLET_CHEESE_WEDGE.get()).unlockedBy("has_scarlet_cheeseburger_ingredients", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike)ModItems.BEEF_PATTY.get(), (ItemLike)BCItems.SCARLET_CHEESE_WEDGE.get())).save(consumer, new ResourceLocation("bundledelight", "food/scarlet_cheeseburger"));
    }
    private static void recipesNeapolitan(Consumer<FinishedRecipe> consumer) {
    }
    private static void recipesRespite(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped((ItemLike)FRItems.GREEN_TEA_COOKIE.get(), 4).pattern("wgw").define('w', Items.WHEAT).define('g', (ItemLike)RespiteItems.POWDERED_GREEN_TEA_LEAVES.get()).unlockedBy("has_leaves", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike)RespiteItems.POWDERED_GREEN_TEA_LEAVES.get())).save(consumer, new ResourceLocation("bundledelight", "food/green_tea_cookie_from_powder"));
        ShapedRecipeBuilder.shaped((ItemLike)FRItems.COFFEE_CAKE.get()).pattern("msm").pattern("cec").pattern("www").define('m', ForgeTags.MILK).define('s', Items.SUGAR).define('c', (ItemLike)RespiteItems.POWDERED_COFFEE_BEANS.get()).define('e', Items.EGG).define('w', Items.WHEAT).unlockedBy("has_beans", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike)RespiteItems.POWDERED_COFFEE_BEANS.get())).save(consumer, new ResourceLocation("bundledelight", "food/coffee_cake_from_powder"));
    }



    }
