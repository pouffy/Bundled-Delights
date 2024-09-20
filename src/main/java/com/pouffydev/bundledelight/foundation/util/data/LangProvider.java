package com.pouffydev.bundledelight.foundation.util.data;

import com.pouffydev.bundledelight.BundledDelights;
import com.pouffydev.bundledelight.compat.abnormals_delight.AbnormalsNeapolitanCompatItems;
import com.pouffydev.bundledelight.compat.brewinandchewin.BrewinCompatItems;
import com.pouffydev.bundledelight.compat.brewinandchewin.BrewinMDCompatItems;
import com.pouffydev.bundledelight.compat.farmersrespite.RespiteCompatItems;
import com.pouffydev.bundledelight.compat.farmersrespite.RespiteMDCompatItems;
import com.pouffydev.bundledelight.compat.neapolitan.NeapolitanCompatItems;
import com.pouffydev.bundledelight.compat.respiteful.RespitefulMDCompatItems;
import com.pouffydev.bundledelight.init.BDItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.commons.lang3.text.WordUtils;

public class LangProvider extends LanguageProvider {

    public LangProvider(DataGenerator gen) {
        super(gen, BundledDelights.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        this.add("itemGroup.bundled_delights", "Bundled Delights");
        //BASE ITEMS
        this.add((Item) BDItems.BORSCHT.get());
        this.add((Item) BDItems.NETTLE_SOUP.get());
        this.add((Item) BDItems.SWEET_BERRY_JUICE.get());
        this.addSlice((Item) BDItems.CARROT_CAKE_SLICE.get());
        this.add((Item) BDItems.CARROT_CAKE.get());
        //ABNORMAL'S DELIGHT
        this.addSlice((Item) AbnormalsNeapolitanCompatItems.WHITE_STRAWBERRY_CAKE_SLICE.get());
        //NEAPOLITAN
        this.add((Item) NeapolitanCompatItems.POWDERED_VANILLA_PODS.get());
        this.add((Item) NeapolitanCompatItems.POWDERED_ADZUKI_BEANS.get());
        this.add((Item) NeapolitanCompatItems.POWDERED_MINT_LEAVES.get());
        this.add((Item) NeapolitanCompatItems.WHITE_STRAWBERRY_ICE_CREAM.get());
        this.add((Item) NeapolitanCompatItems.WHITE_STRAWBERRY_MILKSHAKE.get());
        this.add((Item) NeapolitanCompatItems.WHITE_STRAWBERRY_ICE_CREAM_BLOCK.get());
        this.add((Item) NeapolitanCompatItems.STRAWBERRY_CAKE.get());
        this.add((Item) NeapolitanCompatItems.ADZUKI_CRATE.get());
        this.add((Item) NeapolitanCompatItems.MINT_CRATE.get());
        this.add((Item) NeapolitanCompatItems.VANILLA_CRATE.get());
        this.addBasket((Item) NeapolitanCompatItems.ADZUKI_POWDER_CRATE.get());
        this.addBasket((Item) NeapolitanCompatItems.MINT_POWDER_CRATE.get());
        this.addBasket((Item) NeapolitanCompatItems.VANILLA_POWDER_CRATE.get());
        //BREWIN' & CHEWIN'
        this.add("brewinandchewin.tooltip.dread_nog_glass", "Bad Omen (10:00)");
        this.addGlass((Item) BrewinCompatItems.BEER_GLASS.get());
        this.addGlass((Item) BrewinCompatItems.VODKA_GLASS.get());
        this.addGlass((Item) BrewinCompatItems.MEAD_GLASS.get());
        this.addGlass((Item) BrewinCompatItems.RICE_WINE_GLASS.get());
        this.addGlass((Item) BrewinCompatItems.EGG_GROG_GLASS.get());
        this.addGlass((Item) BrewinCompatItems.STRONGROOT_ALE_GLASS.get());
        this.addGlass((Item) BrewinCompatItems.SACCHARINE_RUM_GLASS.get());
        this.addGlass((Item) BrewinCompatItems.PALE_JANE_GLASS.get());
        this.addGlass((Item) BrewinCompatItems.DREAD_NOG_GLASS.get());
        this.addGlass((Item) BrewinCompatItems.SALTY_FOLLY_GLASS.get());
        this.addGlass((Item) BrewinCompatItems.STEEL_TOE_STOUT_GLASS.get());
        this.addGlass((Item) BrewinCompatItems.GLITTERING_GRENADINE_GLASS.get());
        this.addGlass((Item) BrewinCompatItems.BLOODY_MARY_GLASS.get());
        this.addGlass((Item) BrewinCompatItems.RED_RUM_GLASS.get());
        this.addGlass((Item) BrewinCompatItems.WITHERING_DROSS_GLASS.get());
        this.addGlass((Item) BrewinCompatItems.KOMBUCHA_GLASS.get());
        this.addGlass((Item) BrewinCompatItems.RADIANT_BREW_GLASS.get());
        this.addGlass((Item) BrewinCompatItems.ROOT_BEER_GLASS.get());
        this.add((Item) BrewinCompatItems.CHEESEBURGER.get());
        this.add((Item) BrewinCompatItems.SCARLET_CHEESEBURGER.get());
        this.add((Item) BrewinCompatItems.GLASS_TANKARD.get());
        //BREWIN' & CHEWIN' + MINER'S DELIGHT
        this.add("brewinandchewin.tooltip.dread_nog_swig", "Bad Omen (10:00)");
        this.add((Item) BrewinMDCompatItems.COPPER_TANKARD.get());
        this.addSwig((Item) BrewinMDCompatItems.BEER_SWIG.get());
        this.addSwig((Item) BrewinMDCompatItems.VODKA_SWIG.get());
        this.addSwig((Item) BrewinMDCompatItems.MEAD_SWIG.get());
        this.addSwig((Item) BrewinMDCompatItems.RICE_WINE_SWIG.get());
        this.addSwig((Item) BrewinMDCompatItems.EGG_GROG_SWIG.get());
        this.addSwig((Item) BrewinMDCompatItems.STRONGROOT_ALE_SWIG.get());
        this.addSwig((Item) BrewinMDCompatItems.SACCHARINE_RUM_SWIG.get());
        this.addSwig((Item) BrewinMDCompatItems.PALE_JANE_SWIG.get());
        this.addSwig((Item) BrewinMDCompatItems.DREAD_NOG_SWIG.get());
        this.addSwig((Item) BrewinMDCompatItems.SALTY_FOLLY_SWIG.get());
        this.addSwig((Item) BrewinMDCompatItems.STEEL_TOE_STOUT_SWIG.get());
        this.addSwig((Item) BrewinMDCompatItems.GLITTERING_GRENADINE_SWIG.get());
        this.addSwig((Item) BrewinMDCompatItems.BLOODY_MARY_SWIG.get());
        this.addSwig((Item) BrewinMDCompatItems.RED_RUM_SWIG.get());
        this.addSwig((Item) BrewinMDCompatItems.WITHERING_DROSS_SWIG.get());
        this.addSwig((Item) BrewinMDCompatItems.KOMBUCHA_SWIG.get());
        this.addSwig((Item) BrewinMDCompatItems.RADIANT_BREW_SWIG.get());
        this.addSwig((Item) BrewinMDCompatItems.ROOT_BEER_SWIG.get());
        //FARMER'S RESPITE
        this.add((Item) RespiteCompatItems.COFFEE_CRATE.get());
        this.add((Item) RespiteCompatItems.GREEN_TEA_CRATE.get());
        this.add((Item) RespiteCompatItems.BLACK_TEA_CRATE.get());
        this.add((Item) RespiteCompatItems.YELLOW_TEA_CRATE.get());
        this.add((Item) RespiteCompatItems.COFFEE_POWDER_BASKET.get());
        this.add((Item) RespiteCompatItems.GREEN_TEA_POWDER_BASKET.get());
        this.add((Item) RespiteCompatItems.BLACK_TEA_POWDER_BASKET.get());
        this.add((Item) RespiteCompatItems.YELLOW_TEA_POWDER_BASKET.get());
        this.add((Item) RespiteCompatItems.POWDERED_COFFEE_BEANS.get());
        this.add((Item) RespiteCompatItems.POWDERED_GREEN_TEA_LEAVES.get());
        this.add((Item) RespiteCompatItems.POWDERED_BLACK_TEA_LEAVES.get());
        this.add((Item) RespiteCompatItems.POWDERED_YELLOW_TEA_LEAVES.get());
        //FARMER'S RESPITE + MINER'S DELIGHT
        this.add("item.bundledelight.cup", "Copper Mug");
        this.addCup((Item) RespiteMDCompatItems.COFFEE_CUP.get());
        this.addStrongCup((Item) RespiteMDCompatItems.STRONG_COFFEE_CUP.get());
        this.addLongCup((Item) RespiteMDCompatItems.LONG_COFFEE_CUP.get());
        this.addCup((Item) RespiteMDCompatItems.GREEN_TEA_CUP.get());
        this.addStrongCup((Item) RespiteMDCompatItems.STRONG_GREEN_TEA_CUP.get());
        this.addLongCup((Item) RespiteMDCompatItems.LONG_GREEN_TEA_CUP.get());
        this.addCup((Item) RespiteMDCompatItems.BLACK_TEA_CUP.get());
        this.addStrongCup((Item) RespiteMDCompatItems.STRONG_BLACK_TEA_CUP.get());
        this.addLongCup((Item) RespiteMDCompatItems.LONG_BLACK_TEA_CUP.get());
        this.addCup((Item) RespiteMDCompatItems.YELLOW_TEA_CUP.get());
        this.addStrongCup((Item) RespiteMDCompatItems.STRONG_YELLOW_TEA_CUP.get());
        this.addLongCup((Item) RespiteMDCompatItems.LONG_YELLOW_TEA_CUP.get());
        this.add((Item) RespiteMDCompatItems.ROSE_HIP_TEA_CUP.get());
        this.addStrongCup((Item) RespiteMDCompatItems.STRONG_ROSE_HIP_TEA_CUP.get());
        this.addCup((Item) RespiteMDCompatItems.DANDELION_TEA_CUP.get());
        this.addLongCup((Item) RespiteMDCompatItems.LONG_DANDELION_TEA_CUP.get());
        this.add((Item) RespiteMDCompatItems.PURULENT_TEA_CUP.get());
        this.addStrongCup((Item) RespiteMDCompatItems.STRONG_PURULENT_TEA_CUP.get());
        //RESPITEFUL + MINER'S DELIGHT
        this.addCup((Item) RespitefulMDCompatItems.MINT_GREEN_TEA_CUP.get());
        this.addCup((Item) RespitefulMDCompatItems.MOCHA_COFFEE_CUP.get());
        this.addCup((Item) RespitefulMDCompatItems.VANILLA_MILK_TEA_CUP.get());
        this.addCup((Item) RespitefulMDCompatItems.ADZUKI_MILK_TEA_CUP.get());
    }

    private void add(Item item) {
        if (ForgeRegistries.ITEMS.getKey(item) != null) {
            this.add(item, this.format(ForgeRegistries.ITEMS.getKey(item)));
        }
    }
    private void addBasket(Item item) {
        if (ForgeRegistries.ITEMS.getKey(item) != null) {
            String var10002 = this.format(ForgeRegistries.ITEMS.getKey(item));
            this.add(item, var10002.replace(" Crate", "") + " Basket");
        }
    }
    private void addGlass(Item item) {
        if (ForgeRegistries.ITEMS.getKey(item) != null) {
            String var10002 = this.format(ForgeRegistries.ITEMS.getKey(item));
            this.add(item, "Glass of " + var10002.replace(" Glass", ""));
        }
    }
    private void addSwig(Item item) {
        if (ForgeRegistries.ITEMS.getKey(item) != null) {
            String var10002 = this.format(ForgeRegistries.ITEMS.getKey(item));
            this.add(item, "Swig of " + var10002.replace(" Swig", ""));
        }
    }
    private void addCup(Item item) {
        if (ForgeRegistries.ITEMS.getKey(item) != null) {
            String var10002 = this.format(ForgeRegistries.ITEMS.getKey(item));
            this.add(item, "Mug of " + var10002.replace(" Cup", ""));
        }
    }
    private void addLongCup(Item item) {
        if (ForgeRegistries.ITEMS.getKey(item) != null) {
            String var10002 = this.format(ForgeRegistries.ITEMS.getKey(item));
            this.add(item, "Mug of " + var10002.replace(" Cup", "").replace("Long ", ""));
        }
    }
    private void addStrongCup(Item item) {
        if (ForgeRegistries.ITEMS.getKey(item) != null) {
            String var10002 = this.format(ForgeRegistries.ITEMS.getKey(item));
            this.add(item, "Mug of " + var10002.replace(" Cup", "").replace("Strong ", ""));
        }
    }
    private void addRaw(Item item) {
        if (ForgeRegistries.ITEMS.getKey(item) != null) {
            String var10002 = this.format(ForgeRegistries.ITEMS.getKey(item));
            this.add(item, "Raw " + var10002);
        }

    }

    private void add(Block block) {
        if (ForgeRegistries.BLOCKS.getKey(block) != null) {
            this.add(block, this.format(ForgeRegistries.BLOCKS.getKey(block)));
        }

    }

    private String format(ResourceLocation registryName) {
        return WordUtils.capitalizeFully(registryName.getPath().replace("_", " ")).replace("With", "with");
    }

    private void addSlice(Item item) {
        if (ForgeRegistries.ITEMS.getKey(item) != null) {
            String var10002 = this.format(ForgeRegistries.ITEMS.getKey(item));
            this.add(item, "Slice of " + var10002.replace(" Slice", ""));
        }

    }
}
