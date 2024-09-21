package com.pouffydev.bundledelight.datagen.blockstate;

import com.pouffydev.bundledelight.common.elements.block.CompatFlavoredCakeBlock;
import com.pouffydev.bundledelight.foundation.util.client.SpecialBlockStateGen;
import com.tterrag.registrate.providers.DataGenContext;
import com.tterrag.registrate.providers.RegistrateBlockstateProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;

public class CakeGenerator extends SpecialBlockStateGen {
    public CakeGenerator() {
    }
    
    @Override
    protected int getXRotation(BlockState state) {
        return 0;
    }
    
    @Override
    protected int getYRotation(BlockState state) {
        return 0;
    }
    
    public <T extends Block> ModelFile createModel(DataGenContext<Block, T> ctx, RegistrateBlockstateProvider prov, int bites) {
        ResourceLocation bottom = prov.modLoc("block/" + ctx.getName() + "/bottom");
        ResourceLocation top = prov.modLoc("block/" + ctx.getName() + "/top");
        ResourceLocation side = prov.modLoc("block/" + ctx.getName() + "/side");
        ResourceLocation inside = prov.modLoc("block/" + ctx.getName() + "/inner");
        if (bites == 0) {
            return prov.models()
                    .withExistingParent(ctx.getName(), prov.mcLoc("block/cake"))
                    .texture("particle", top)
                    .texture("bottom", bottom)
                    .texture("top", top)
                    .texture("side", side)
                    .texture("inside", inside);
        } else {
            return prov.models()
                    .withExistingParent(ctx.getName() + "_slice" + bites, prov.mcLoc("block/cake_slice" + bites))
                    .texture("particle", top)
                    .texture("bottom", bottom)
                    .texture("top", top)
                    .texture("side", side)
                    .texture("inside", inside);
        }
    }
    
    @Override
    public <T extends Block> ModelFile getModel(DataGenContext<Block, T> ctx, RegistrateBlockstateProvider prov, BlockState state) {
        return null;
    }
    
    public final <T extends Block> void generateCustom(DataGenContext<Block, T> ctx, RegistrateBlockstateProvider prov) {
        prov.getVariantBuilder(ctx.getEntry()).forAllStates(bState -> {
            int bites = bState.getValue(CompatFlavoredCakeBlock.BITES);
            return ConfiguredModel.builder()
                    .modelFile(createModel(ctx, prov, bites))
                    .build();
        });
    }
}
