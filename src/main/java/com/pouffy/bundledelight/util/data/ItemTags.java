package com.pouffy.bundledelight.util.data;

import com.brewinandchewin.core.registry.BCItems;
import com.farmersrespite.core.registry.FRItems;
import com.pouffy.bundledelight.compats.brewinandchewin.BrewinItems;
import com.pouffy.bundledelight.compats.brewinandchewin.BrewinMDItems;
import com.pouffy.bundledelight.compats.farmersrespite.RespiteItems;
import com.pouffy.bundledelight.compats.farmersrespite.RespiteMDItems;
import com.pouffy.bundledelight.content.tag.ModTags;
import com.pouffy.bundledelight.init.BDItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
@SuppressWarnings("unchecked")
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
        this.tag(ModTags.BEER).add(BCItems.BEER.get(), BrewinMDItems.BEER_SWIG.get());
        this.tag(ModTags.VODKA).add(BCItems.VODKA.get(), BrewinMDItems.VODKA_SWIG.get());
        this.tag(ModTags.MEAD).add(BCItems.MEAD.get(), BrewinMDItems.MEAD_SWIG.get());
        this.tag(ModTags.RICE_WINE).add(BCItems.RICE_WINE.get(), BrewinMDItems.RICE_WINE_SWIG.get());
        this.tag(ModTags.EGG_GROG).add(BCItems.EGG_GROG.get(), BrewinMDItems.EGG_GROG_SWIG.get());
        this.tag(ModTags.STRONGROOT_ALE).add(BCItems.STRONGROOT_ALE.get(), BrewinMDItems.STRONGROOT_ALE_SWIG.get());
        this.tag(ModTags.SACCHARINE_RUM).add(BCItems.SACCHARINE_RUM.get(), BrewinMDItems.SACCHARINE_RUM_SWIG.get());
        this.tag(ModTags.PALE_JANE).add(BCItems.PALE_JANE.get(), BrewinMDItems.PALE_JANE_SWIG.get());
        this.tag(ModTags.DREAD_NOG).add(BCItems.DREAD_NOG.get(), BrewinMDItems.DREAD_NOG_SWIG.get());
        this.tag(ModTags.SALTY_FOLLY).add(BCItems.SALTY_FOLLY.get(), BrewinMDItems.SALTY_FOLLY_SWIG.get());
        this.tag(ModTags.STEEL_TOE_STOUT).add(BCItems.STEEL_TOE_STOUT.get(), BrewinMDItems.STEEL_TOE_STOUT_SWIG.get());
        this.tag(ModTags.GLITTERING_GRENADINE).add(BCItems.GLITTERING_GRENADINE.get(), BrewinMDItems.GLITTERING_GRENADINE_SWIG.get());
        this.tag(ModTags.BLOODY_MARY).add(BCItems.BLOODY_MARY.get(), BrewinMDItems.BLOODY_MARY_SWIG.get());
        this.tag(ModTags.RED_RUM).add(BCItems.RED_RUM.get(), BrewinMDItems.RED_RUM_SWIG.get());
        this.tag(ModTags.WITHERING_DROSS).add(BCItems.WITHERING_DROSS.get(), BrewinMDItems.WITHERING_DROSS_SWIG.get());
        this.tag(ModTags.KOMBUCHA).add(BCItems.KOMBUCHA.get(), BrewinMDItems.KOMBUCHA_SWIG.get());
        this.tag(ModTags.RADIANT_BREW).add(BrewinItems.RADIANT_BREW.get(), BrewinMDItems.RADIANT_BREW_SWIG.get());

    }

    private void registerModTags() {
        this.tag(ModTags.GREEN_TEA).add(FRItems.GREEN_TEA.get(), RespiteMDItems.GREEN_TEA_CUP.get());
        this.tag(ModTags.YELLOW_TEA).add(FRItems.YELLOW_TEA.get(), RespiteMDItems.YELLOW_TEA_CUP.get());
        this.tag(ModTags.BLACK_TEA).add(FRItems.BLACK_TEA.get(), RespiteMDItems.BLACK_TEA_CUP.get());
        this.tag(ModTags.PURULENT_TEA).add(FRItems.PURULENT_TEA.get(), RespiteMDItems.PURULENT_TEA_CUP.get());
        this.tag(ModTags.ROSE_HIP_TEA).add(FRItems.ROSE_HIP_TEA.get(), RespiteMDItems.ROSE_HIP_TEA_CUP.get());
        this.tag(ModTags.DANDELION_TEA).add(FRItems.DANDELION_TEA.get(), RespiteMDItems.DANDELION_TEA_CUP.get());
        this.tag(ModTags.COFFEE).add(FRItems.COFFEE.get(), RespiteMDItems.COFFEE_CUP.get());

        this.tag(ModTags.BELT_UPRIGHT).addTags(ModTags.GREEN_TEA, ModTags.YELLOW_TEA, ModTags.BLACK_TEA, ModTags.PURULENT_TEA, ModTags.ROSE_HIP_TEA, ModTags.DANDELION_TEA, ModTags.COFFEE,
                ModTags.BEER, ModTags.VODKA, ModTags.MEAD, ModTags.RICE_WINE, ModTags.EGG_GROG, ModTags.STRONGROOT_ALE, ModTags.SACCHARINE_RUM, ModTags.PALE_JANE, ModTags.DREAD_NOG, ModTags.SALTY_FOLLY,
                ModTags.STEEL_TOE_STOUT, ModTags.GLITTERING_GRENADINE, ModTags.BLOODY_MARY, ModTags.RED_RUM, ModTags.WITHERING_DROSS, ModTags.KOMBUCHA, ModTags.RADIANT_BREW);

        this.tag(ModTags.BEESECHURGER).add(BrewinItems.CHEESEBURGER.get(), BrewinItems.SCARLET_CHEESEBURGER.get());

        this.tag(ModTags.GREEN_TEA_POWDER).add(RespiteItems.POWDERED_GREEN_TEA_LEAVES.get());
        this.tag(ModTags.YELLOW_TEA_POWDER).add(RespiteItems.POWDERED_YELLOW_TEA_LEAVES.get());
        this.tag(ModTags.BLACK_TEA_POWDER).add(RespiteItems.POWDERED_BLACK_TEA_LEAVES.get());
        this.tag(ModTags.COFFEE_POWDER).add(RespiteItems.POWDERED_COFFEE_BEANS.get());
        this.tag(ModTags.TEA_POWDER).add(RespiteItems.POWDERED_YELLOW_TEA_LEAVES.get(), RespiteItems.POWDERED_GREEN_TEA_LEAVES.get(), RespiteItems.POWDERED_BLACK_TEA_LEAVES.get());

    }

    private void registerForgeTags() {
        this.tag(ModTags.SEEDS).add(FRItems.TEA_SEEDS.get());
        this.tag(ModTags.SEEDS_TEA).add(FRItems.TEA_SEEDS.get());
    }

    }
