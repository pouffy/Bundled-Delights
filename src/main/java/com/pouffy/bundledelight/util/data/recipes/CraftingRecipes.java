package com.pouffy.bundledelight.util.data.recipes;

import com.pouffy.bundledelight.BundledDelights;
import com.pouffy.bundledelight.compats.abnormals_delight.AbnormalsNeapolitanCompatItems;
import com.pouffy.bundledelight.compats.brewinandchewin.BrewinCompatItems;
import com.pouffy.bundledelight.compats.brewinandchewin.BrewinMDCompatItems;
import com.pouffy.bundledelight.compats.farmersrespite.RespiteCompatItems;
import com.pouffy.bundledelight.compats.neapolitan.NeapolitanCompatItems;
import com.pouffy.bundledelight.init.BDItems;
import com.teamabnormals.neapolitan.core.registry.NeapolitanItems;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.Tags;
import umpaz.brewinandchewin.common.registry.BCItems;
import umpaz.farmersrespite.common.registry.FRItems;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.ForgeTags;

import java.util.function.Consumer;

import static com.pouffy.bundledelight.compats.farmersrespite.RespiteMDCompatItems.CUP;

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
        ShapedRecipeBuilder.shaped((ItemLike) RespiteCompatItems.GREEN_TEA_POWDER_BASKET.get(), 1).pattern("###").pattern("###").pattern("###").define('#', (ItemLike) RespiteCompatItems.POWDERED_GREEN_TEA_LEAVES.get()).unlockedBy("has_green_tea_powder", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike) RespiteCompatItems.POWDERED_GREEN_TEA_LEAVES.get())).save(consumer, new ResourceLocation("bundledelight", "packing/green_tea_powder_basket"));
        ShapedRecipeBuilder.shaped((ItemLike) RespiteCompatItems.YELLOW_TEA_POWDER_BASKET.get(), 1).pattern("###").pattern("###").pattern("###").define('#', (ItemLike) RespiteCompatItems.POWDERED_YELLOW_TEA_LEAVES.get()).unlockedBy("has_yellow_tea_powder", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike) RespiteCompatItems.POWDERED_YELLOW_TEA_LEAVES.get())).save(consumer, new ResourceLocation("bundledelight", "packing/yellow_tea_powder_basket"));
        ShapedRecipeBuilder.shaped((ItemLike) RespiteCompatItems.BLACK_TEA_POWDER_BASKET.get(), 1).pattern("###").pattern("###").pattern("###").define('#', (ItemLike) RespiteCompatItems.POWDERED_BLACK_TEA_LEAVES.get()).unlockedBy("has_black_tea_powder", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike) RespiteCompatItems.POWDERED_BLACK_TEA_LEAVES.get())).save(consumer, new ResourceLocation("bundledelight", "packing/black_tea_powder_basket"));
        ShapedRecipeBuilder.shaped((ItemLike) RespiteCompatItems.COFFEE_POWDER_BASKET.get(), 1).pattern("###").pattern("###").pattern("###").define('#', (ItemLike) RespiteCompatItems.POWDERED_COFFEE_BEANS.get()).unlockedBy("has_coffee_powder", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike) RespiteCompatItems.POWDERED_COFFEE_BEANS.get())).save(consumer, new ResourceLocation("bundledelight", "packing/coffee_bean_powder_basket"));
        ShapedRecipeBuilder.shaped((ItemLike) NeapolitanCompatItems.ADZUKI_POWDER_CRATE.get(), 1).pattern("###").pattern("###").pattern("###").define('#', (ItemLike) NeapolitanCompatItems.POWDERED_ADZUKI_BEANS.get()).unlockedBy("has_adzuki_powder", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike) NeapolitanCompatItems.POWDERED_ADZUKI_BEANS.get())).save(consumer, new ResourceLocation("bundledelight", "packing/adzuki_powder_basket"));
        ShapedRecipeBuilder.shaped((ItemLike) NeapolitanCompatItems.VANILLA_POWDER_CRATE.get(), 1).pattern("###").pattern("###").pattern("###").define('#', (ItemLike) NeapolitanCompatItems.POWDERED_VANILLA_PODS.get()).unlockedBy("has_vanilla_powder", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike) NeapolitanCompatItems.POWDERED_VANILLA_PODS.get())).save(consumer, new ResourceLocation("bundledelight", "packing/vanilla_powder_basket"));
        ShapedRecipeBuilder.shaped((ItemLike) NeapolitanCompatItems.MINT_POWDER_CRATE.get(), 1).pattern("###").pattern("###").pattern("###").define('#', (ItemLike) NeapolitanCompatItems.POWDERED_MINT_LEAVES.get()).unlockedBy("has_mint_powder", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike) NeapolitanCompatItems.POWDERED_MINT_LEAVES.get())).save(consumer, new ResourceLocation("bundledelight", "packing/mint_powder_basket"));
        ShapedRecipeBuilder.shaped((ItemLike) RespiteCompatItems.GREEN_TEA_CRATE.get(), 1).pattern("###").pattern("###").pattern("###").define('#', (ItemLike) FRItems.GREEN_TEA_LEAVES.get()).unlockedBy("has_green_tea_leaves", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike) FRItems.GREEN_TEA_LEAVES.get())).save(consumer, new ResourceLocation("bundledelight", "packing/green_tea_basket"));
        ShapedRecipeBuilder.shaped((ItemLike) RespiteCompatItems.YELLOW_TEA_CRATE.get(), 1).pattern("###").pattern("###").pattern("###").define('#', (ItemLike) FRItems.YELLOW_TEA_LEAVES.get()).unlockedBy("has_yellow_tea_leaves", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike) FRItems.YELLOW_TEA_LEAVES.get())).save(consumer, new ResourceLocation("bundledelight", "packing/yellow_tea_basket"));
        ShapedRecipeBuilder.shaped((ItemLike) RespiteCompatItems.BLACK_TEA_CRATE.get(), 1).pattern("###").pattern("###").pattern("###").define('#', (ItemLike) FRItems.BLACK_TEA_LEAVES.get()).unlockedBy("has_black_tea_leaves", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike) FRItems.BLACK_TEA_LEAVES.get())).save(consumer, new ResourceLocation("bundledelight", "packing/black_tea_basket"));
        ShapedRecipeBuilder.shaped((ItemLike) RespiteCompatItems.COFFEE_CRATE.get(), 1).pattern("###").pattern("###").pattern("###").define('#', (ItemLike) FRItems.COFFEE_BEANS.get()).unlockedBy("has_coffee_beans", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike) FRItems.COFFEE_BEANS.get())).save(consumer, new ResourceLocation("bundledelight", "packing/coffee_bean_basket"));
        ShapedRecipeBuilder.shaped((ItemLike) NeapolitanCompatItems.ADZUKI_CRATE.get(), 1).pattern("###").pattern("###").pattern("###").define('#', (ItemLike) NeapolitanItems.ADZUKI_BEANS.get()).unlockedBy("has_adzuki_beans", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike) NeapolitanItems.ADZUKI_BEANS.get())).save(consumer, new ResourceLocation("bundledelight", "packing/adzuki_basket"));
        ShapedRecipeBuilder.shaped((ItemLike) NeapolitanCompatItems.VANILLA_CRATE.get(), 1).pattern("###").pattern("###").pattern("###").define('#', (ItemLike) NeapolitanItems.DRIED_VANILLA_PODS.get()).unlockedBy("has_dried_vanilla_pods", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike) NeapolitanItems.DRIED_VANILLA_PODS.get())).save(consumer, new ResourceLocation("bundledelight", "packing/vanilla_basket"));
        ShapedRecipeBuilder.shaped((ItemLike) NeapolitanCompatItems.MINT_CRATE.get(), 1).pattern("###").pattern("###").pattern("###").define('#', (ItemLike) NeapolitanItems.MINT_LEAVES.get()).unlockedBy("has_mint_leaves", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike) NeapolitanItems.MINT_LEAVES.get())).save(consumer, new ResourceLocation("bundledelight", "packing/mint_basket"));
        ShapedRecipeBuilder.shaped((ItemLike) BrewinMDCompatItems.COPPER_TANKARD.get()).pattern("# #").pattern("- -").pattern("###").define('-', Tags.Items.NUGGETS_IRON).define('#', Tags.Items.INGOTS_COPPER).unlockedBy("has_copper", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COPPER_INGOT)).save(consumer, new ResourceLocation("bundledelight", "crafting/copper_tankard"));
        ShapedRecipeBuilder.shaped((ItemLike) CUP.get()).pattern("# #").pattern(" #-").define('-', ModItems.CANVAS.get()).define('#', Tags.Items.INGOTS_COPPER).unlockedBy("has_copper", InventoryChangeTrigger.TriggerInstance.hasItems(Items.COPPER_INGOT)).save(consumer, new ResourceLocation("bundledelight", "crafting/copper_mug"));
        ShapedRecipeBuilder.shaped((ItemLike) BrewinCompatItems.GLASS_TANKARD.get()).pattern("# #").pattern("# #").pattern(" # ").define('#', Tags.Items.GLASS).unlockedBy("has_glass", InventoryChangeTrigger.TriggerInstance.hasItems(Items.GLASS)).save(consumer, new ResourceLocation("bundledelight", "crafting/glass_tankard"));

    }

    private static void recipesTools(Consumer<FinishedRecipe> consumer) {
    }

    private static void recipesMaterials(Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(RespiteCompatItems.POWDERED_GREEN_TEA_LEAVES.get(), 9).requires((ItemLike) RespiteCompatItems.GREEN_TEA_POWDER_BASKET.get()).unlockedBy("has_green_tea_powder_basket", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike) RespiteCompatItems.GREEN_TEA_POWDER_BASKET.get())).save(consumer, new ResourceLocation("bundledelight", "unpacking/green_tea_powder_from_basket"));
        ShapelessRecipeBuilder.shapeless(RespiteCompatItems.POWDERED_YELLOW_TEA_LEAVES.get(), 9).requires((ItemLike) RespiteCompatItems.YELLOW_TEA_POWDER_BASKET.get()).unlockedBy("has_yellow_tea_powder_basket", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike) RespiteCompatItems.YELLOW_TEA_POWDER_BASKET.get())).save(consumer, new ResourceLocation("bundledelight", "unpacking/yellow_tea_powder_from_basket"));
        ShapelessRecipeBuilder.shapeless(RespiteCompatItems.POWDERED_BLACK_TEA_LEAVES.get(), 9).requires((ItemLike) RespiteCompatItems.BLACK_TEA_POWDER_BASKET.get()).unlockedBy("has_black_tea_powder_basket", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike) RespiteCompatItems.BLACK_TEA_POWDER_BASKET.get())).save(consumer, new ResourceLocation("bundledelight", "unpacking/black_tea_powder_from_basket"));
        ShapelessRecipeBuilder.shapeless(RespiteCompatItems.POWDERED_COFFEE_BEANS.get(), 9).requires((ItemLike) RespiteCompatItems.COFFEE_POWDER_BASKET.get()).unlockedBy("has_coffee_powder_basket", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike) RespiteCompatItems.COFFEE_POWDER_BASKET.get())).save(consumer, new ResourceLocation("bundledelight", "unpacking/coffee_powder_from_basket"));
        ShapelessRecipeBuilder.shapeless(FRItems.GREEN_TEA_LEAVES.get(), 9).requires((ItemLike) RespiteCompatItems.GREEN_TEA_CRATE.get()).unlockedBy("has_green_tea_basket", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike) RespiteCompatItems.GREEN_TEA_CRATE.get())).save(consumer, new ResourceLocation("bundledelight", "unpacking/green_tea_leaves_from_crate"));
        ShapelessRecipeBuilder.shapeless(FRItems.YELLOW_TEA_LEAVES.get(), 9).requires((ItemLike) RespiteCompatItems.YELLOW_TEA_CRATE.get()).unlockedBy("has_yellow_tea_basket", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike) RespiteCompatItems.YELLOW_TEA_CRATE.get())).save(consumer, new ResourceLocation("bundledelight", "unpacking/yellow_tea_leaves_from_crate"));
        ShapelessRecipeBuilder.shapeless(FRItems.BLACK_TEA_LEAVES.get(), 9).requires((ItemLike) RespiteCompatItems.BLACK_TEA_CRATE.get()).unlockedBy("has_black_tea_basket", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike) RespiteCompatItems.BLACK_TEA_CRATE.get())).save(consumer, new ResourceLocation("bundledelight", "unpacking/black_tea_leaves_from_crate"));
        ShapelessRecipeBuilder.shapeless(FRItems.COFFEE_BEANS.get(), 9).requires((ItemLike) RespiteCompatItems.COFFEE_CRATE.get()).unlockedBy("has_coffee_basket", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike) RespiteCompatItems.COFFEE_CRATE.get())).save(consumer, new ResourceLocation("bundledelight", "unpacking/coffee_beans_from_crate"));
        ShapelessRecipeBuilder.shapeless(NeapolitanItems.ADZUKI_BEANS.get(), 9).requires((ItemLike)NeapolitanCompatItems.ADZUKI_CRATE.get()).unlockedBy("has_adzuki_crate", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike)NeapolitanCompatItems.ADZUKI_CRATE.get())).save(consumer, new ResourceLocation("bundledelight", "unpacking/adzuki_beans_from_crate"));
        ShapelessRecipeBuilder.shapeless(NeapolitanItems.DRIED_VANILLA_PODS.get(), 9).requires((ItemLike)NeapolitanCompatItems.VANILLA_CRATE.get()).unlockedBy("has_vanilla_crate", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike)NeapolitanCompatItems.VANILLA_CRATE.get())).save(consumer, new ResourceLocation("bundledelight", "unpacking/dried_vanilla_pods_from_crate"));
        ShapelessRecipeBuilder.shapeless(NeapolitanItems.MINT_LEAVES.get(), 9).requires((ItemLike)NeapolitanCompatItems.MINT_CRATE.get()).unlockedBy("has_mint_crate", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike)NeapolitanCompatItems.MINT_CRATE.get())).save(consumer, new ResourceLocation("bundledelight", "unpacking/mint_leaves_from_crate"));
        ShapelessRecipeBuilder.shapeless(NeapolitanCompatItems.POWDERED_MINT_LEAVES.get(), 9).requires((ItemLike)NeapolitanCompatItems.MINT_POWDER_CRATE.get()).unlockedBy("has_mint_powder_crate", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike)NeapolitanCompatItems.MINT_POWDER_CRATE.get())).save(consumer, new ResourceLocation("bundledelight", "unpacking/mint_powder_from_basket"));
        ShapelessRecipeBuilder.shapeless(NeapolitanCompatItems.POWDERED_ADZUKI_BEANS.get(), 9).requires((ItemLike)NeapolitanCompatItems.ADZUKI_POWDER_CRATE.get()).unlockedBy("has_adzuki_powder_crate", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike)NeapolitanCompatItems.ADZUKI_POWDER_CRATE.get())).save(consumer, new ResourceLocation("bundledelight", "unpacking/adzuki_powder_from_basket"));
        ShapelessRecipeBuilder.shapeless(NeapolitanCompatItems.POWDERED_VANILLA_PODS.get(), 9).requires((ItemLike)NeapolitanCompatItems.VANILLA_POWDER_CRATE.get()).unlockedBy("has_vanilla_powder_crate", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike)NeapolitanCompatItems.VANILLA_POWDER_CRATE.get())).save(consumer, new ResourceLocation("bundledelight", "unpacking/vanilla_powder_from_basket"));
    }

    private static void recipesFoodstuffs(Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(BDItems.SWEET_BERRY_JUICE.get())
                .requires(Items.SWEET_BERRIES)
                .requires(Items.SWEET_BERRIES)
                .requires(Items.SWEET_BERRIES)
                .requires(Items.SWEET_BERRIES)
                .requires(Items.SUGAR)
                .requires(Items.GLASS_BOTTLE)
                .unlockedBy("has_sweet_berries", InventoryChangeTrigger.TriggerInstance.hasItems(Items.SWEET_BERRIES))
                .save(consumer, new ResourceLocation(BundledDelights.MODID, "food/sweet_berry_juice"));
    }

    private static void recipesFoodBlocks(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped((ItemLike)BDItems.CARROT_CAKE.get()).pattern("mcm").pattern("ses").pattern("wcw").define('m', ForgeTags.MILK).define('s', Items.SUGAR).define('c', (ItemLike)Items.CARROT).define('e', Items.EGG).define('w', Items.WHEAT).unlockedBy("has_carrots", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike)Items.CARROT)).save(consumer, new ResourceLocation("bundledelight", "food/carrot_cake"));
        ShapelessRecipeBuilder.shapeless(BDItems.CARROT_CAKE.get())
                .requires(BDItems.CARROT_CAKE_SLICE.get())
                .requires(BDItems.CARROT_CAKE_SLICE.get())
                .requires(BDItems.CARROT_CAKE_SLICE.get())
                .requires(BDItems.CARROT_CAKE_SLICE.get())
                .requires(BDItems.CARROT_CAKE_SLICE.get())
                .requires(BDItems.CARROT_CAKE_SLICE.get())
                .requires(BDItems.CARROT_CAKE_SLICE.get())
                .unlockedBy("has_cake_slice", InventoryChangeTrigger.TriggerInstance.hasItems(BDItems.CARROT_CAKE_SLICE.get()))
                .save(consumer, new ResourceLocation(BundledDelights.MODID, "food/carrot_cake_from_slices"));
    }

    private static void recipesCraftedMeals(Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless((ItemLike) BrewinCompatItems.CHEESEBURGER.get())
                .requires(ForgeTags.BREAD)
                .requires((ItemLike)ModItems.BEEF_PATTY.get())
                .requires(ForgeTags.SALAD_INGREDIENTS)
                .requires(ForgeTags.CROPS_TOMATO)
                .requires(ForgeTags.CROPS_ONION)
                .requires((ItemLike) BCItems.FLAXEN_CHEESE_WEDGE.get())
                .unlockedBy("has_cheeseburger_ingredients", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike)ModItems.BEEF_PATTY.get(), (ItemLike)BCItems.FLAXEN_CHEESE_WEDGE.get()))
                .save(consumer, new ResourceLocation("bundledelight", "food/cheeseburger"));
        ShapelessRecipeBuilder.shapeless((ItemLike) BrewinCompatItems.SCARLET_CHEESEBURGER.get())
                .requires(ForgeTags.BREAD)
                .requires((ItemLike)ModItems.BEEF_PATTY.get())
                .requires(ForgeTags.SALAD_INGREDIENTS)
                .requires(ForgeTags.CROPS_TOMATO)
                .requires(ForgeTags.CROPS_ONION)
                .requires((ItemLike) BCItems.SCARLET_CHEESE_WEDGE.get())
                .unlockedBy("has_scarlet_cheeseburger_ingredients", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike)ModItems.BEEF_PATTY.get(), (ItemLike)BCItems.SCARLET_CHEESE_WEDGE.get()))
                .save(consumer, new ResourceLocation("bundledelight", "food/scarlet_cheeseburger"));
        ShapelessRecipeBuilder.shapeless((ItemLike) NeapolitanCompatItems.WHITE_STRAWBERRY_ICE_CREAM.get())
                .requires((ItemLike)Items.BOWL)
                .requires((ItemLike)NeapolitanItems.WHITE_STRAWBERRIES.get())
                .requires(ForgeTags.MILK)
                .requires((ItemLike)NeapolitanItems.ICE_CUBES.get())
                .requires((ItemLike) Items.SUGAR)
                .unlockedBy("has_strawberries", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike)NeapolitanItems.WHITE_STRAWBERRIES.get()))
                .save(consumer, new ResourceLocation("bundledelight", "food/white_strawberry_ice_cream"));
        ShapelessRecipeBuilder.shapeless((ItemLike) NeapolitanCompatItems.WHITE_STRAWBERRY_MILKSHAKE.get(), 3)
                .requires((ItemLike)Items.GLASS_BOTTLE)
                .requires((ItemLike)Items.GLASS_BOTTLE)
                .requires((ItemLike)Items.GLASS_BOTTLE)
                .requires((ItemLike)NeapolitanItems.WHITE_STRAWBERRIES.get())
                .requires((ItemLike)NeapolitanItems.VANILLA_ICE_CREAM.get())
                .requires(ForgeTags.MILK)
                .unlockedBy("has_strawberries", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike)NeapolitanItems.WHITE_STRAWBERRIES.get()))
                .save(consumer, new ResourceLocation("bundledelight", "food/white_strawberry_milkshake"));
        ShapelessRecipeBuilder.shapeless((ItemLike) NeapolitanCompatItems.WHITE_STRAWBERRY_MILKSHAKE.get(), 3)
                .requires((ItemLike)Items.GLASS_BOTTLE)
                .requires((ItemLike)Items.GLASS_BOTTLE)
                .requires((ItemLike)Items.GLASS_BOTTLE)
                .requires((ItemLike)NeapolitanCompatItems.WHITE_STRAWBERRY_ICE_CREAM.get())
                .requires((ItemLike)NeapolitanItems.DRIED_VANILLA_PODS.get())
                .requires(ForgeTags.MILK)
                .unlockedBy("has_strawberries", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike)NeapolitanCompatItems.WHITE_STRAWBERRY_ICE_CREAM.get()))
                .save(consumer, new ResourceLocation("bundledelight", "food/white_strawberry_milkshake_from_ice_cream"));
        ShapelessRecipeBuilder.shapeless(NeapolitanCompatItems.STRAWBERRY_CAKE.get())
                .requires(AbnormalsNeapolitanCompatItems.WHITE_STRAWBERRY_CAKE_SLICE.get())
                .requires(AbnormalsNeapolitanCompatItems.WHITE_STRAWBERRY_CAKE_SLICE.get())
                .requires(AbnormalsNeapolitanCompatItems.WHITE_STRAWBERRY_CAKE_SLICE.get())
                .requires(AbnormalsNeapolitanCompatItems.WHITE_STRAWBERRY_CAKE_SLICE.get())
                .requires(AbnormalsNeapolitanCompatItems.WHITE_STRAWBERRY_CAKE_SLICE.get())
                .requires(AbnormalsNeapolitanCompatItems.WHITE_STRAWBERRY_CAKE_SLICE.get())
                .requires(AbnormalsNeapolitanCompatItems.WHITE_STRAWBERRY_CAKE_SLICE.get())
                .unlockedBy("has_cake_slice", InventoryChangeTrigger.TriggerInstance.hasItems(AbnormalsNeapolitanCompatItems.WHITE_STRAWBERRY_CAKE_SLICE.get()))
                .save(consumer, new ResourceLocation(BundledDelights.MODID, "food/white_strawberry_cake_from_slices"));
    }
    private static void recipesNeapolitan(Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless((ItemLike) NeapolitanItems.ADZUKI_MILKSHAKE.get(), 3)
                .requires((ItemLike)Items.GLASS_BOTTLE)
                .requires((ItemLike)Items.GLASS_BOTTLE)
                .requires((ItemLike)Items.GLASS_BOTTLE)
                .requires((ItemLike)NeapolitanCompatItems.POWDERED_ADZUKI_BEANS.get())
                .requires((ItemLike)NeapolitanItems.VANILLA_ICE_CREAM.get())
                .requires(ForgeTags.MILK)
                .unlockedBy("has_adzuki_powder", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike)NeapolitanCompatItems.POWDERED_ADZUKI_BEANS.get()))
                .save(consumer, new ResourceLocation("bundledelight", "food/adzuki_milkshake_from_powder"));
        ShapelessRecipeBuilder.shapeless((ItemLike) NeapolitanItems.MINT_MILKSHAKE.get(), 3)
                .requires((ItemLike)Items.GLASS_BOTTLE)
                .requires((ItemLike)Items.GLASS_BOTTLE)
                .requires((ItemLike)Items.GLASS_BOTTLE)
                .requires((ItemLike)NeapolitanCompatItems.POWDERED_MINT_LEAVES.get())
                .requires((ItemLike)NeapolitanItems.VANILLA_ICE_CREAM.get())
                .requires(ForgeTags.MILK)
                .unlockedBy("has_mint_powder", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike)NeapolitanCompatItems.POWDERED_MINT_LEAVES.get()))
                .save(consumer, new ResourceLocation("bundledelight", "food/mint_milkshake_from_powder"));
        ShapelessRecipeBuilder.shapeless((ItemLike) NeapolitanItems.ADZUKI_MILKSHAKE.get(), 3)
                .requires((ItemLike)Items.GLASS_BOTTLE)
                .requires((ItemLike)Items.GLASS_BOTTLE)
                .requires((ItemLike)Items.GLASS_BOTTLE)
                .requires((ItemLike)NeapolitanItems.ADZUKI_ICE_CREAM.get())
                .requires((ItemLike)NeapolitanCompatItems.POWDERED_VANILLA_PODS.get())
                .requires(ForgeTags.MILK)
                .unlockedBy("has_vanilla_powder", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike)NeapolitanCompatItems.POWDERED_VANILLA_PODS.get()))
                .save(consumer, new ResourceLocation("bundledelight", "food/adzuki_milkshake_from_ice_cream_and_powder"));
        ShapelessRecipeBuilder.shapeless((ItemLike) NeapolitanItems.MINT_MILKSHAKE.get(), 3)
                .requires((ItemLike)Items.GLASS_BOTTLE)
                .requires((ItemLike)Items.GLASS_BOTTLE)
                .requires((ItemLike)Items.GLASS_BOTTLE)
                .requires((ItemLike)NeapolitanItems.MINT_ICE_CREAM.get())
                .requires((ItemLike)NeapolitanCompatItems.POWDERED_VANILLA_PODS.get())
                .requires(ForgeTags.MILK)
                .unlockedBy("has_vanilla_powder", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike)NeapolitanCompatItems.POWDERED_VANILLA_PODS.get()))
                .save(consumer, new ResourceLocation("bundledelight", "food/mint_milkshake_from_ice_cream_and_powder"));
        ShapelessRecipeBuilder.shapeless((ItemLike) NeapolitanItems.BANANA_MILKSHAKE.get(), 3)
                .requires((ItemLike)Items.GLASS_BOTTLE)
                .requires((ItemLike)Items.GLASS_BOTTLE)
                .requires((ItemLike)Items.GLASS_BOTTLE)
                .requires((ItemLike)NeapolitanItems.BANANA_ICE_CREAM.get())
                .requires((ItemLike)NeapolitanCompatItems.POWDERED_VANILLA_PODS.get())
                .requires(ForgeTags.MILK)
                .unlockedBy("has_vanilla_powder", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike)NeapolitanCompatItems.POWDERED_VANILLA_PODS.get()))
                .save(consumer, new ResourceLocation("bundledelight", "food/banana_milkshake_from_ice_cream_and_powder"));
        ShapelessRecipeBuilder.shapeless((ItemLike) NeapolitanItems.STRAWBERRY_MILKSHAKE.get(), 3)
                .requires((ItemLike)Items.GLASS_BOTTLE)
                .requires((ItemLike)Items.GLASS_BOTTLE)
                .requires((ItemLike)Items.GLASS_BOTTLE)
                .requires((ItemLike)NeapolitanItems.STRAWBERRY_ICE_CREAM.get())
                .requires((ItemLike)NeapolitanCompatItems.POWDERED_VANILLA_PODS.get())
                .requires(ForgeTags.MILK)
                .unlockedBy("has_vanilla_powder", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike)NeapolitanCompatItems.POWDERED_VANILLA_PODS.get()))
                .save(consumer, new ResourceLocation("bundledelight", "food/strawberry_milkshake_from_ice_cream_and_powder"));
        ShapelessRecipeBuilder.shapeless((ItemLike) NeapolitanItems.CHOCOLATE_MILKSHAKE.get(), 3)
                .requires((ItemLike)Items.GLASS_BOTTLE)
                .requires((ItemLike)Items.GLASS_BOTTLE)
                .requires((ItemLike)Items.GLASS_BOTTLE)
                .requires((ItemLike)NeapolitanItems.CHOCOLATE_ICE_CREAM.get())
                .requires((ItemLike)NeapolitanCompatItems.POWDERED_VANILLA_PODS.get())
                .requires(ForgeTags.MILK)
                .unlockedBy("has_vanilla_powder", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike)NeapolitanCompatItems.POWDERED_VANILLA_PODS.get()))
                .save(consumer, new ResourceLocation("bundledelight", "food/chocolate_milkshake_from_ice_cream_and_powder"));
        ShapelessRecipeBuilder.shapeless((ItemLike) NeapolitanCompatItems.WHITE_STRAWBERRY_MILKSHAKE.get(), 3)
                .requires((ItemLike)Items.GLASS_BOTTLE)
                .requires((ItemLike)Items.GLASS_BOTTLE)
                .requires((ItemLike)Items.GLASS_BOTTLE)
                .requires((ItemLike)NeapolitanCompatItems.WHITE_STRAWBERRY_ICE_CREAM.get())
                .requires((ItemLike)NeapolitanCompatItems.POWDERED_VANILLA_PODS.get())
                .requires(ForgeTags.MILK)
                .unlockedBy("has_vanilla_powder", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike)NeapolitanCompatItems.POWDERED_VANILLA_PODS.get()))
                .save(consumer, new ResourceLocation("bundledelight", "food/white_strawberry_milkshake_from_ice_cream_and_powder"));
        ShapelessRecipeBuilder.shapeless((ItemLike) NeapolitanItems.ADZUKI_ICE_CREAM.get())
                .requires((ItemLike)Items.BOWL)
                .requires((ItemLike)NeapolitanCompatItems.POWDERED_ADZUKI_BEANS.get())
                .requires(ForgeTags.MILK)
                .requires((ItemLike)NeapolitanItems.ICE_CUBES.get())
                .requires((ItemLike) Items.SUGAR)
                .unlockedBy("has_adzuki_powder", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike)NeapolitanCompatItems.POWDERED_ADZUKI_BEANS.get()))
                .save(consumer, new ResourceLocation("bundledelight", "food/adzuki_ice_cream_from_powder"));
        ShapelessRecipeBuilder.shapeless((ItemLike) NeapolitanItems.MINT_ICE_CREAM.get())
                .requires((ItemLike)Items.BOWL)
                .requires((ItemLike)NeapolitanCompatItems.POWDERED_MINT_LEAVES.get())
                .requires(ForgeTags.MILK)
                .requires((ItemLike)NeapolitanItems.ICE_CUBES.get())
                .requires((ItemLike) Items.SUGAR)
                .unlockedBy("has_mint_powder", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike)NeapolitanCompatItems.POWDERED_MINT_LEAVES.get()))
                .save(consumer, new ResourceLocation("bundledelight", "food/mint_ice_cream_from_powder"));
        ShapelessRecipeBuilder.shapeless((ItemLike) NeapolitanItems.VANILLA_ICE_CREAM.get())
                .requires((ItemLike)Items.BOWL)
                .requires((ItemLike)NeapolitanCompatItems.POWDERED_VANILLA_PODS.get())
                .requires(ForgeTags.MILK)
                .requires((ItemLike)NeapolitanItems.ICE_CUBES.get())
                .requires((ItemLike) Items.SUGAR)
                .unlockedBy("has_vanilla_powder", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike)NeapolitanCompatItems.POWDERED_VANILLA_PODS.get()))
                .save(consumer, new ResourceLocation("bundledelight", "food/vanilla_ice_cream_from_powder"));
        ShapelessRecipeBuilder.shapeless((ItemLike) NeapolitanItems.VANILLA_PUDDING.get())
                .requires((ItemLike)Items.EGG)
                .requires((ItemLike)NeapolitanCompatItems.POWDERED_VANILLA_PODS.get())
                .requires((ItemLike)Items.BOWL)
                .requires((ItemLike) Items.SUGAR)
                .unlockedBy("has_vanilla_powder", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike)NeapolitanCompatItems.POWDERED_VANILLA_PODS.get()))
                .save(consumer, new ResourceLocation("bundledelight", "food/vanilla_pudding_from_powder"));
        ShapelessRecipeBuilder.shapeless((ItemLike) NeapolitanItems.VANILLA_FUDGE.get(), 2)
                .requires(ForgeTags.MILK)
                .requires((ItemLike) Items.SUGAR)
                .requires((ItemLike)NeapolitanCompatItems.POWDERED_VANILLA_PODS.get())
                .requires((ItemLike)NeapolitanCompatItems.POWDERED_VANILLA_PODS.get())
                .unlockedBy("has_vanilla_powder", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike)NeapolitanCompatItems.POWDERED_VANILLA_PODS.get()))
                .save(consumer, new ResourceLocation("bundledelight", "food/vanilla_fudge_from_powder"));
    }
    private static void recipesRespite(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped((ItemLike)FRItems.GREEN_TEA_COOKIE.get(), 4).pattern("wgw").define('w', Items.WHEAT).define('g', (ItemLike) RespiteCompatItems.POWDERED_GREEN_TEA_LEAVES.get()).unlockedBy("has_leaves", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike) RespiteCompatItems.POWDERED_GREEN_TEA_LEAVES.get())).save(consumer, new ResourceLocation("bundledelight", "food/green_tea_cookie_from_powder"));
        ShapedRecipeBuilder.shaped((ItemLike)FRItems.COFFEE_CAKE.get()).pattern("msm").pattern("cec").pattern("www").define('m', ForgeTags.MILK).define('s', Items.SUGAR).define('c', (ItemLike) RespiteCompatItems.POWDERED_COFFEE_BEANS.get()).define('e', Items.EGG).define('w', Items.WHEAT).unlockedBy("has_beans", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike) RespiteCompatItems.POWDERED_COFFEE_BEANS.get())).save(consumer, new ResourceLocation("bundledelight", "food/coffee_cake_from_powder"));

        ShapedRecipeBuilder.shaped((ItemLike)NeapolitanItems.ADZUKI_CAKE.get()).pattern("msm").pattern("cec").pattern("wsw").define('m', ForgeTags.MILK).define('s', NeapolitanCompatItems.POWDERED_ADZUKI_BEANS.get()).define('c', Items.SUGAR).define('e', Items.EGG).define('w', Items.WHEAT).unlockedBy("has_adzuki_powder", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike) NeapolitanCompatItems.POWDERED_ADZUKI_BEANS.get())).save(consumer, new ResourceLocation("bundledelight", "food/adzuki_cake_from_powder"));
        ShapedRecipeBuilder.shaped((ItemLike)NeapolitanItems.MINT_CAKE.get()).pattern("msm").pattern("cec").pattern("wsw").define('m', ForgeTags.MILK).define('s', NeapolitanCompatItems.POWDERED_MINT_LEAVES.get()).define('c', Items.SUGAR).define('e', Items.EGG).define('w', Items.WHEAT).unlockedBy("has_mint_powder", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike) NeapolitanCompatItems.POWDERED_MINT_LEAVES.get())).save(consumer, new ResourceLocation("bundledelight", "food/mint_cake_from_powder"));
        ShapedRecipeBuilder.shaped((ItemLike)NeapolitanItems.VANILLA_CAKE.get()).pattern("msm").pattern("cec").pattern("wsw").define('m', ForgeTags.MILK).define('s', NeapolitanCompatItems.POWDERED_VANILLA_PODS.get()).define('c', Items.SUGAR).define('e', Items.EGG).define('w', Items.WHEAT).unlockedBy("has_vanilla_powder", InventoryChangeTrigger.TriggerInstance.hasItems((ItemLike) NeapolitanCompatItems.POWDERED_VANILLA_PODS.get())).save(consumer, new ResourceLocation("bundledelight", "food/vanilla_cake_from_powder"));

    }



    }
