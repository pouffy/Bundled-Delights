package com.pouffydev.bundledelight.datagen.blockstate;

import com.pouffydev.bundledelight.foundation.util.client.SpecialBlockStateGen;
import com.tterrag.registrate.providers.DataGenContext;
import com.tterrag.registrate.providers.RegistrateBlockstateProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;

public class SackGenerator extends SpecialBlockStateGen {
    @Override
    protected int getXRotation(BlockState state) {
        return 0;
    }

    @Override
    protected int getYRotation(BlockState state) {
        return 0;
    }

    public <T extends Block> ModelFile sack(DataGenContext<Block, T> ctx, RegistrateBlockstateProvider prov) {
        ResourceLocation bottom = prov.modLoc("block/" + ctx.getName() + "/bottom");
        ResourceLocation top = prov.modLoc("block/" + ctx.getName() + "/top");
        ResourceLocation side = prov.modLoc("block/" + ctx.getName() + "/side");
        ResourceLocation sideTied = prov.modLoc("block/" + ctx.getName() + "/side_tied");
        return prov.models()
                .withExistingParent(ctx.getName(), prov.mcLoc("block/cube"))
                .texture("particle", top)
                .texture("down", bottom)
                .texture("east", side)
                .texture("north", sideTied)
                .texture("west", side)
                .texture("south", sideTied)
                .texture("up", top);
    }

    public <T extends Block> ModelFile crate(DataGenContext<Block, T> ctx, RegistrateBlockstateProvider prov) {
        ResourceLocation bottom = prov.modLoc("block/" + ctx.getName() + "/bottom");
        ResourceLocation top = prov.modLoc("block/" + ctx.getName() + "/top");
        ResourceLocation side = prov.modLoc("block/" + ctx.getName() + "/side");
        return prov.models()
                .withExistingParent(ctx.getName(), prov.mcLoc("block/cube_bottom_top"))
                .texture("bottom", bottom)
                .texture("top", top)
                .texture("side", side);
    }

    @Override
    public <T extends Block> ModelFile getModel(DataGenContext<Block, T> ctx, RegistrateBlockstateProvider prov, BlockState state) {
        return null;
    }

    public final <T extends Block> void generateSack(DataGenContext<Block, T> ctx, RegistrateBlockstateProvider prov) {
        prov.getVariantBuilder(ctx.getEntry()).forAllStates(bState -> ConfiguredModel.builder()
                .modelFile(sack(ctx, prov)).build());
    }

    public final <T extends Block> void generateCrate(DataGenContext<Block, T> ctx, RegistrateBlockstateProvider prov) {
        prov.getVariantBuilder(ctx.getEntry()).forAllStates(bState -> ConfiguredModel.builder()
                .modelFile(crate(ctx, prov)).build());
    }
}
