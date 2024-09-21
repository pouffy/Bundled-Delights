package com.pouffydev.bundledelight.foundation.util.data;

import com.pouffydev.bundledelight.compat.brewinandchewin.BrewinCompatItems;
import com.pouffydev.bundledelight.compat.farmersrespite.RespiteCompatItems;
import com.pouffydev.bundledelight.compat.neapolitan.NeapolitanCompatItems;
import com.pouffydev.bundledelight.content.tag.BDTags;
import com.pouffydev.bundledelight.foundation.util.data.lists.Brews;
import com.pouffydev.bundledelight.foundation.util.data.lists.Teas;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
public class ItemTags extends ItemTagsProvider {
    public ItemTags(DataGenerator generatorIn, BlockTagsProvider blockTagProvider, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(generatorIn, blockTagProvider, modId, existingFileHelper);
    }

    protected void addTags() {
        //this.copy(ModTags.WILD_CROPS, ModTags.WILD_CROPS_ITEM);
        //this.copy(BlockTags.CARPETS, net.minecraft.tags.ItemTags.CARPETS);
        //this.copy(BlockTags.SMALL_FLOWERS, net.minecraft.tags.ItemTags.SMALL_FLOWERS);
        //this.tag(net.minecraft.tags.ItemTags.TALL_FLOWERS).add((Item) ModItems.WILD_RICE.get());
        //this.tag(net.minecraft.tags.ItemTags.PIGLIN_LOVED).add((Item)ModItems.GOLDEN_KNIFE.get());
        this.registerModTags();
        this.registerForgeTags();
        this.registerBrewinTags();
    }

    private void registerBrewinTags() {
        for (Brews brew : Brews.values()) {
            this.tag(brew.getTag()).add(brew.getTankard()).addOptional(brew.swigId()).addOptional(brew.glassId());
            this.tag(BDTags.BELT_UPRIGHT).addTag(brew.getTag());
        }
    }

    private void registerModTags() {
        for (Teas tea : Teas.values()) {
            this.tag(tea.getTag()).add(tea.getTea()).addOptional(tea.teaCupId());
            this.tag(BDTags.BELT_UPRIGHT).addTag(tea.getTag());
        }
        this.tag(BDTags.BEESECHURGER).add(BrewinCompatItems.CHEESEBURGER.get(), BrewinCompatItems.SCARLET_CHEESEBURGER.get());

        this.tag(BDTags.GREEN_TEA_POWDER).add(RespiteCompatItems.POWDERED_GREEN_TEA_LEAVES.get());
        this.tag(BDTags.YELLOW_TEA_POWDER).add(RespiteCompatItems.POWDERED_YELLOW_TEA_LEAVES.get());
        this.tag(BDTags.BLACK_TEA_POWDER).add(RespiteCompatItems.POWDERED_BLACK_TEA_LEAVES.get());
        this.tag(BDTags.COFFEE_POWDER).add(RespiteCompatItems.POWDERED_COFFEE_BEANS.get());
        this.tag(BDTags.ADZUKI_POWDER).add(NeapolitanCompatItems.POWDERED_ADZUKI_BEANS.get());
        this.tag(BDTags.VANILLA_POWDER).add(NeapolitanCompatItems.POWDERED_VANILLA_PODS.get());
        this.tag(BDTags.MINT_POWDER).add(NeapolitanCompatItems.POWDERED_MINT_LEAVES.get());
        this.tag(BDTags.TEA_POWDER).add(RespiteCompatItems.POWDERED_YELLOW_TEA_LEAVES.get(), RespiteCompatItems.POWDERED_GREEN_TEA_LEAVES.get(), RespiteCompatItems.POWDERED_BLACK_TEA_LEAVES.get());

    }

    private void registerForgeTags() {
        ResourceLocation teaSeeds = new ResourceLocation("farmersrespite", "tea_seeds");
        ResourceLocation coffeeSeeds = new ResourceLocation("farmersrespite", "coffee_beans");
        this.tag(BDTags.SEEDS).addOptional(teaSeeds).addOptional(coffeeSeeds);
        this.tag(BDTags.SEEDS_TEA).addOptional(teaSeeds);
        this.tag(BDTags.SEEDS_COFFEE).addOptional(coffeeSeeds);
    }

    }
