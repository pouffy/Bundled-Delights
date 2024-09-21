package com.pouffydev.bundledelight.datagen.blockstate;

import com.pouffydev.bundledelight.common.elements.block.CompatFlavoredCandleCakeBlock;
import com.pouffydev.bundledelight.foundation.util.client.SpecialBlockStateGen;
import com.tterrag.registrate.providers.DataGenContext;
import com.tterrag.registrate.providers.RegistrateBlockstateProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;

public class CandleCakeGenerator extends SpecialBlockStateGen {
    @Override
    protected int getXRotation(BlockState state) {
        return 0;
    }
    
    @Override
    protected int getYRotation(BlockState state) {
        return 0;
    }
    
    @Override
    public <T extends Block> ModelFile getModel(DataGenContext<Block, T> ctx, RegistrateBlockstateProvider prov, BlockState state) {
        return null;
    }
    
    private String getFinalColor(String name, boolean noColor) {
        if (noColor) {
            return "";
        }
        String checkAndRemoveSub = name.contains("/") ? name.split("/")[1] : name;
        String removeCC = checkAndRemoveSub.replace("_candle_cake", "");
        return removeCC.split("_")[0];
    }
    
    private String removeColor(String name) {
        String checkAndRemoveSub = name.contains("/") ? name.split("/")[1] : name;
        for (Color color : Color.values()) {
            if (checkAndRemoveSub.contains(color.name().toLowerCase())) {
                return checkAndRemoveSub.replace(color.name().toLowerCase(), "");
            }
        }
        return checkAndRemoveSub.replace("_candle", "");
    }
    
    public <T extends Block> ModelFile createModel(DataGenContext<Block, T> ctx, RegistrateBlockstateProvider prov, boolean lit, String color) {
        String checkAndRemoveSub = ctx.getName().contains("/") ? ctx.getName().split("/")[1] : ctx.getName();
        String removeColor = checkAndRemoveSub.replace(color + "_", "");
        String cakeName = removeColor.replace("_candle", "");
        ResourceLocation candle = color.equals("none") ? prov.mcLoc("block/candle") : prov.mcLoc("block/" + color + "_candle");
        ResourceLocation candleLit = color.equals("none") ? prov.mcLoc("block/candle_lit") : prov.mcLoc("block/" + color + "_candle_lit");
        ResourceLocation bottom = prov.modLoc("block/" + cakeName + "/bottom");
        ResourceLocation top = prov.modLoc("block/" + cakeName + "/top");
        ResourceLocation side = prov.modLoc("block/" + cakeName + "/side");
        if (lit) {
            return prov.models()
                    .withExistingParent(ctx.getName() + "_lit", prov.mcLoc("block/template_cake_with_candle"))
                    .texture("particle", top)
                    .texture("bottom", bottom)
                    .texture("top", top)
                    .texture("side", side)
                    .texture("candle", candleLit);
        } else {
            return prov.models()
                    .withExistingParent(ctx.getName(), prov.mcLoc("block/template_cake_with_candle"))
                    .texture("particle", top)
                    .texture("bottom", bottom)
                    .texture("top", top)
                    .texture("side", side)
                    .texture("candle", candle);
        }
    }
    
    public final <T extends Block> void generateCustom(DataGenContext<Block, T> ctx, RegistrateBlockstateProvider prov, String color) {
        prov.getVariantBuilder(ctx.getEntry()).forAllStates(bState -> {
            boolean lit = bState.getValue(CompatFlavoredCandleCakeBlock.LIT);
            return ConfiguredModel.builder()
                    .modelFile(createModel(ctx, prov, lit, color))
                    .build();
        });
    }
    
    enum Color {
        WHITE,
        ORANGE,
        MAGENTA,
        LIGHT_BLUE,
        YELLOW,
        LIME,
        PINK,
        GRAY,
        LIGHT_GRAY,
        CYAN,
        PURPLE,
        BLUE,
        BROWN,
        GREEN,
        RED,
        BLACK;
    }
}
