package com.pouffy.bundledelight.util.data;

import com.brewinandchewin.core.registry.BCItems;
import com.farmersrespite.core.registry.FRItems;
import com.pouffy.bundledelight.compat.brewinandchewin.BrewinCompatItems;
import com.pouffy.bundledelight.compat.brewinandchewin.BrewinMDCompatItems;
import com.pouffy.bundledelight.compat.farmersrespite.RespiteCompatItems;
import com.pouffy.bundledelight.compat.farmersrespite.RespiteMDCompatItems;
import com.pouffy.bundledelight.compat.neapolitan.NeapolitanCompatItems;
import com.pouffy.bundledelight.content.tag.BDTags;
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
        this.tag(BDTags.BEER).add(BCItems.BEER.get(), BrewinMDCompatItems.BEER_SWIG.get(), BrewinCompatItems.BEER_GLASS.get());
        this.tag(BDTags.VODKA).add(BCItems.VODKA.get(), BrewinMDCompatItems.VODKA_SWIG.get(), BrewinCompatItems.VODKA_GLASS.get());
        this.tag(BDTags.MEAD).add(BCItems.MEAD.get(), BrewinMDCompatItems.MEAD_SWIG.get(), BrewinCompatItems.MEAD_GLASS.get());
        this.tag(BDTags.RICE_WINE).add(BCItems.RICE_WINE.get(), BrewinMDCompatItems.RICE_WINE_SWIG.get(), BrewinCompatItems.RICE_WINE_GLASS.get());
        this.tag(BDTags.EGG_GROG).add(BCItems.EGG_GROG.get(), BrewinMDCompatItems.EGG_GROG_SWIG.get(), BrewinCompatItems.EGG_GROG_GLASS.get());
        this.tag(BDTags.STRONGROOT_ALE).add(BCItems.STRONGROOT_ALE.get(), BrewinMDCompatItems.STRONGROOT_ALE_SWIG.get(), BrewinCompatItems.STRONGROOT_ALE_GLASS.get());
        this.tag(BDTags.SACCHARINE_RUM).add(BCItems.SACCHARINE_RUM.get(), BrewinMDCompatItems.SACCHARINE_RUM_SWIG.get(), BrewinCompatItems.SACCHARINE_RUM_GLASS.get());
        this.tag(BDTags.PALE_JANE).add(BCItems.PALE_JANE.get(), BrewinMDCompatItems.PALE_JANE_SWIG.get(), BrewinCompatItems.PALE_JANE_GLASS.get());
        this.tag(BDTags.DREAD_NOG).add(BCItems.DREAD_NOG.get(), BrewinMDCompatItems.DREAD_NOG_SWIG.get(), BrewinCompatItems.DREAD_NOG_GLASS.get());
        this.tag(BDTags.SALTY_FOLLY).add(BCItems.SALTY_FOLLY.get(), BrewinMDCompatItems.SALTY_FOLLY_SWIG.get(), BrewinCompatItems.SALTY_FOLLY_GLASS.get());
        this.tag(BDTags.STEEL_TOE_STOUT).add(BCItems.STEEL_TOE_STOUT.get(), BrewinMDCompatItems.STEEL_TOE_STOUT_SWIG.get(), BrewinCompatItems.STEEL_TOE_STOUT_GLASS.get());
        this.tag(BDTags.GLITTERING_GRENADINE).add(BCItems.GLITTERING_GRENADINE.get(), BrewinMDCompatItems.GLITTERING_GRENADINE_SWIG.get(), BrewinCompatItems.GLITTERING_GRENADINE_GLASS.get());
        this.tag(BDTags.BLOODY_MARY).add(BCItems.BLOODY_MARY.get(), BrewinMDCompatItems.BLOODY_MARY_SWIG.get(), BrewinCompatItems.BLOODY_MARY_GLASS.get());
        this.tag(BDTags.RED_RUM).add(BCItems.RED_RUM.get(), BrewinMDCompatItems.RED_RUM_SWIG.get(), BrewinCompatItems.RED_RUM_GLASS.get());
        this.tag(BDTags.WITHERING_DROSS).add(BCItems.WITHERING_DROSS.get(), BrewinMDCompatItems.WITHERING_DROSS_SWIG.get(), BrewinCompatItems.WITHERING_DROSS_GLASS.get());
        this.tag(BDTags.KOMBUCHA).add(BCItems.KOMBUCHA.get(), BrewinMDCompatItems.KOMBUCHA_SWIG.get(), BrewinCompatItems.KOMBUCHA_GLASS.get());
        this.tag(BDTags.RADIANT_BREW).add(BrewinMDCompatItems.RADIANT_BREW_SWIG.get(), BrewinCompatItems.RADIANT_BREW_GLASS.get());
        this.tag(BDTags.ROOT_BEER).add(BrewinMDCompatItems.ROOT_BEER_SWIG.get(), BrewinCompatItems.ROOT_BEER_GLASS.get());
    }

    private void registerModTags() {
        this.tag(BDTags.GREEN_TEA).add(FRItems.GREEN_TEA.get(), RespiteMDCompatItems.GREEN_TEA_CUP.get());
        this.tag(BDTags.YELLOW_TEA).add(FRItems.YELLOW_TEA.get(), RespiteMDCompatItems.YELLOW_TEA_CUP.get());
        this.tag(BDTags.BLACK_TEA).add(FRItems.BLACK_TEA.get(), RespiteMDCompatItems.BLACK_TEA_CUP.get());
        this.tag(BDTags.PURULENT_TEA).add(FRItems.PURULENT_TEA.get(), RespiteMDCompatItems.PURULENT_TEA_CUP.get());
        this.tag(BDTags.ROSE_HIP_TEA).add(FRItems.ROSE_HIP_TEA.get(), RespiteMDCompatItems.ROSE_HIP_TEA_CUP.get());
        this.tag(BDTags.DANDELION_TEA).add(FRItems.DANDELION_TEA.get(), RespiteMDCompatItems.DANDELION_TEA_CUP.get());
        this.tag(BDTags.COFFEE).add(FRItems.COFFEE.get(), RespiteMDCompatItems.COFFEE_CUP.get());

        this.tag(BDTags.BELT_UPRIGHT).addTags(BDTags.GREEN_TEA, BDTags.YELLOW_TEA, BDTags.BLACK_TEA, BDTags.PURULENT_TEA, BDTags.ROSE_HIP_TEA, BDTags.DANDELION_TEA, BDTags.COFFEE,
                BDTags.BEER, BDTags.VODKA, BDTags.MEAD, BDTags.RICE_WINE, BDTags.EGG_GROG, BDTags.STRONGROOT_ALE, BDTags.SACCHARINE_RUM, BDTags.PALE_JANE, BDTags.DREAD_NOG, BDTags.SALTY_FOLLY,
                BDTags.STEEL_TOE_STOUT, BDTags.GLITTERING_GRENADINE, BDTags.BLOODY_MARY, BDTags.RED_RUM, BDTags.WITHERING_DROSS, BDTags.KOMBUCHA, BDTags.RADIANT_BREW);

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
        this.tag(BDTags.SEEDS)
                .add(FRItems.TEA_SEEDS.get(), FRItems.COFFEE_BEANS.get());
        this.tag(BDTags.SEEDS_TEA).add(FRItems.TEA_SEEDS.get());
        this.tag(BDTags.SEEDS_COFFEE).add(FRItems.COFFEE_BEANS.get());
    }

    }
