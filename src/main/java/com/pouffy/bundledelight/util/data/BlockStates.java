package com.pouffy.bundledelight.util.data;

import com.pouffy.bundledelight.init.BDBlocks;
import net.minecraft.core.Direction;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.client.model.generators.*;
import net.minecraftforge.common.data.ExistingFileHelper;
import vectorwing.farmersdelight.common.block.CabinetBlock;
import vectorwing.farmersdelight.common.block.FeastBlock;
import vectorwing.farmersdelight.common.block.PieBlock;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Function;

public class BlockStates extends BlockStateProvider {
    private static final int DEFAULT_ANGLE_OFFSET = 180;

    public BlockStates(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, "bundledelight", exFileHelper);
    }

    private String blockName(Block block) {
        return block.getRegistryName().getPath();
    }

    public ResourceLocation resourceBlock(String path) {
        return new ResourceLocation("bundledelight", "block/" + path);
    }

    public ModelFile existingModel(Block block) {
        return new ModelFile.ExistingModelFile(this.resourceBlock(this.blockName(block)), this.models().existingFileHelper);
    }

    public ModelFile existingModel(String path) {
        return new ModelFile.ExistingModelFile(this.resourceBlock(path), this.models().existingFileHelper);
    }

    protected void registerStatesAndModels() {
        String greenTeaPdr = this.blockName((Block) BDBlocks.GREEN_TEA_POWDER_BASKET.get());
        String yellowTeaPdr = this.blockName((Block) BDBlocks.YELLOW_TEA_POWDER_BASKET.get());
        String blackTeaPdr = this.blockName((Block) BDBlocks.BLACK_TEA_POWDER_BASKET.get());
        String coffeePdr = this.blockName((Block) BDBlocks.COFFEE_POWDER_BASKET.get());

        String greenTea = this.blockName((Block) BDBlocks.GREEN_TEA_CRATE.get());
        String yellowTea = this.blockName((Block) BDBlocks.YELLOW_TEA_CRATE.get());
        String blackTea = this.blockName((Block) BDBlocks.BLACK_TEA_CRATE.get());
        String coffee = this.blockName((Block) BDBlocks.COFFEE_CRATE.get());


        this.simpleBlock((Block) BDBlocks.GREEN_TEA_POWDER_BASKET.get(), ((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(greenTeaPdr, "cube")).texture("particle", this.resourceBlock(greenTeaPdr + "_top"))).texture("down", this.resourceBlock("basket_bottom"))).texture("up", this.resourceBlock(greenTeaPdr + "_top"))).texture("north", this.resourceBlock("basket_side_handle"))).texture("south", this.resourceBlock("basket_side_handle"))).texture("east", this.resourceBlock("basket_side"))).texture("west", this.resourceBlock("basket_side")));
        this.simpleBlock((Block) BDBlocks.YELLOW_TEA_POWDER_BASKET.get(), ((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(yellowTeaPdr, "cube")).texture("particle", this.resourceBlock(yellowTeaPdr + "_top"))).texture("down", this.resourceBlock("basket_bottom"))).texture("up", this.resourceBlock(yellowTeaPdr + "_top"))).texture("north", this.resourceBlock("basket_side_handle"))).texture("south", this.resourceBlock("basket_side_handle"))).texture("east", this.resourceBlock("basket_side")).texture("west", this.resourceBlock("basket_side")));
        this.simpleBlock((Block) BDBlocks.BLACK_TEA_POWDER_BASKET.get(), ((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(blackTeaPdr, "cube")).texture("particle", this.resourceBlock(blackTeaPdr + "_top"))).texture("down", this.resourceBlock("basket_bottom"))).texture("up", this.resourceBlock(blackTeaPdr + "_top"))).texture("north", this.resourceBlock("basket_side_handle"))).texture("south", this.resourceBlock("basket_side_handle")).texture("east", this.resourceBlock("basket_side")).texture("west", this.resourceBlock("basket_side")));
        this.simpleBlock((Block) BDBlocks.COFFEE_POWDER_BASKET.get(), ((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(coffeePdr, "cube")).texture("particle", this.resourceBlock(coffeePdr + "_top"))).texture("down", this.resourceBlock("basket_bottom"))).texture("up", this.resourceBlock(coffeePdr + "_top"))).texture("north", this.resourceBlock("basket_side_handle")).texture("south", this.resourceBlock("basket_side_handle")).texture("east", this.resourceBlock("basket_side")).texture("west", this.resourceBlock("basket_side")));

        this.simpleBlock((Block) BDBlocks.GREEN_TEA_CRATE.get(), ((BlockModelBuilder) ((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(greenTea, "cube")).texture("particle", this.resourceBlock(greenTea + "_top"))).texture("down", this.resourceBlock("basket_bottom")).texture("up", this.resourceBlock(greenTea + "_top"))).texture("north", this.resourceBlock(greenTea + "_side")).texture("south", this.resourceBlock(greenTea + "_side")).texture("east", this.resourceBlock(greenTea + "_side")).texture("west", this.resourceBlock(greenTea + "_side")));
        this.simpleBlock((Block) BDBlocks.YELLOW_TEA_CRATE.get(), ((BlockModelBuilder) ((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)((BlockModelBuilder)this.models().withExistingParent(yellowTea, "cube")).texture("particle", this.resourceBlock(yellowTea + "_top"))).texture("down", this.resourceBlock("basket_bottom"))).texture("up", this.resourceBlock(yellowTea + "_top"))).texture("north", this.resourceBlock(yellowTea + "_side")).texture("south", this.resourceBlock(yellowTea + "_side"))).texture("east", this.resourceBlock(yellowTea + "_side")).texture("west", this.resourceBlock(yellowTea + "_side")));
        this.simpleBlock((Block) BDBlocks.BLACK_TEA_CRATE.get(), ((BlockModelBuilder) ((BlockModelBuilder)this.models().withExistingParent(blackTea, "cube")).texture("particle", this.resourceBlock(blackTea + "_top")).texture("down", this.resourceBlock("basket_bottom")).texture("up", this.resourceBlock(blackTea + "_top"))).texture("north", this.resourceBlock(blackTea + "_side")).texture("south", this.resourceBlock(blackTea + "_side")).texture("east", this.resourceBlock(blackTea + "_side")).texture("west", this.resourceBlock(blackTea + "_side")));
        this.simpleBlock((Block) BDBlocks.COFFEE_CRATE.get(), ((BlockModelBuilder)this.models().withExistingParent(coffee, "cube")).texture("particle", this.resourceBlock(coffee + "_top")).texture("down", this.resourceBlock("basket_bottom")).texture("up", this.resourceBlock(coffee + "_top")).texture("north", this.resourceBlock(coffee + "_side")).texture("south", this.resourceBlock(coffee + "_side")).texture("east", this.resourceBlock(coffee + "_side")).texture("west", this.resourceBlock(coffee + "_side")));
    }
    public ConfiguredModel[] cubeRandomRotation(Block block, String suffix) {
        String var10000 = this.blockName(block);
        String formattedName = var10000 + (suffix.isEmpty() ? "" : "_" + suffix);
        return ConfiguredModel.allYRotations(this.models().cubeAll(formattedName, this.resourceBlock(formattedName)), 0, false);
    }

    public void customDirectionalBlock(Block block, Function<BlockState, ModelFile> modelFunc, Property<?>... ignored) {
        this.getVariantBuilder(block).forAllStatesExcept((state) -> {
            Direction dir = (Direction)state.getValue(BlockStateProperties.FACING);
            return ConfiguredModel.builder().modelFile((ModelFile)modelFunc.apply(state)).rotationX(dir == Direction.DOWN ? 180 : (dir.getAxis().isHorizontal() ? 90 : 0)).rotationY(dir.getAxis().isVertical() ? 0 : ((int)dir.toYRot() + 180) % 360).build();
        }, ignored);
    }

    public void customHorizontalBlock(Block block, Function<BlockState, ModelFile> modelFunc, Property<?>... ignored) {
        this.getVariantBuilder(block).forAllStatesExcept((state) -> {
            return ConfiguredModel.builder().modelFile((ModelFile)modelFunc.apply(state)).rotationY(((int)((Direction)state.getValue(BlockStateProperties.HORIZONTAL_FACING)).toYRot() + 180) % 360).build();
        }, ignored);
    }

    public void stageBlock(Block block, IntegerProperty ageProperty, Property<?>... ignored) {
        this.getVariantBuilder(block).forAllStatesExcept((state) -> {
            int ageSuffix = (Integer)state.getValue(ageProperty);
            String var10000 = this.blockName(block);
            String stageName = var10000 + "_stage" + ageSuffix;
            return ConfiguredModel.builder().modelFile(this.models().cross(stageName, this.resourceBlock(stageName))).build();
        }, ignored);
    }

    public void customStageBlock(Block block, @Nullable ResourceLocation parent, String textureKey, IntegerProperty ageProperty, List<Integer> suffixes, Property<?>... ignored) {
        this.getVariantBuilder(block).forAllStatesExcept((state) -> {
            int ageSuffix = (Integer)state.getValue(ageProperty);
            String var10000 = this.blockName(block);
            String stageName = var10000 + "_stage";
            stageName = stageName + (suffixes.isEmpty() ? ageSuffix : (Integer)suffixes.get(Math.min(suffixes.size(), ageSuffix)));
            return parent == null ? ConfiguredModel.builder().modelFile(this.models().cross(stageName, this.resourceBlock(stageName))).build() : ConfiguredModel.builder().modelFile(this.models().singleTexture(stageName, parent, textureKey, this.resourceBlock(stageName))).build();
        }, ignored);
    }

    public void wildCropBlock(Block block) {
        this.wildCropBlock(block, false);
    }

    public void wildCropBlock(Block block, boolean isBushCrop) {
        if (isBushCrop) {
            this.simpleBlock(block, this.models().singleTexture(this.blockName(block), this.resourceBlock("bush_crop"), "crop", this.resourceBlock(this.blockName(block))));
        } else {
            this.simpleBlock(block, this.models().cross(this.blockName(block), this.resourceBlock(this.blockName(block))));
        }

    }

    public void crateBlock(Block block, String cropName) {
        this.simpleBlock(block, this.models().cubeBottomTop(this.blockName(block), this.resourceBlock(cropName + "_crate_side"), this.resourceBlock("crate_bottom"), this.resourceBlock(cropName + "_crate_top")));
    }

    public void cabinetBlock(Block block, String woodType) {
        this.horizontalBlock(block, (state) -> {
            String suffix = (Boolean)state.getValue(CabinetBlock.OPEN) ? "_open" : "";
            return this.models().orientable(this.blockName(block) + suffix, this.resourceBlock(woodType + "_cabinet_side"), this.resourceBlock(woodType + "_cabinet_front" + suffix), this.resourceBlock(woodType + "_cabinet_top"));
        });
    }

    public void feastBlock(FeastBlock block) {
        this.getVariantBuilder(block).forAllStates((state) -> {
            IntegerProperty servingsProperty = block.getServingsProperty();
            int servings = (Integer)state.getValue(servingsProperty);
            String suffix = "_stage" + (block.getMaxServings() - servings);
            if (servings == 0) {
                suffix = block.hasLeftovers ? "_leftover" : "_stage" + (servingsProperty.getPossibleValues().toArray().length - 2);
            }

            ConfiguredModel.Builder var10000 = ConfiguredModel.builder();
            String var10002 = this.blockName(block);
            return var10000.modelFile(this.existingModel(var10002 + suffix)).rotationY(((int)((Direction)state.getValue(FeastBlock.FACING)).toYRot() + 180) % 360).build();
        });
    }

    public void doublePlantBlock(Block block) {
        ConfiguredModel.Builder var10000 = this.getVariantBuilder(block).partialState().with(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER).modelForState();
        BlockModelProvider var10001 = this.models();
        String var10002 = this.blockName(block) + "_bottom";
        String var10004 = this.blockName(block);
        var10000 = ((VariantBlockStateBuilder)var10000.modelFile(var10001.cross(var10002, this.resourceBlock(var10004 + "_bottom"))).addModel()).partialState().with(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER).modelForState();
        var10001 = this.models();
        var10002 = this.blockName(block) + "_top";
        var10004 = this.blockName(block);
        var10000.modelFile(var10001.cross(var10002, this.resourceBlock(var10004 + "_top"))).addModel();
    }

    public void pieBlock(Block block) {
        this.getVariantBuilder(block).forAllStates((state) -> {
            int bites = (Integer)state.getValue(PieBlock.BITES);
            String suffix = bites > 0 ? "_slice" + bites : "";
            ConfiguredModel.Builder var10000 = ConfiguredModel.builder();
            String var10002 = this.blockName(block);
            return var10000.modelFile(this.existingModel(var10002 + suffix)).rotationY(((int)((Direction)state.getValue(PieBlock.FACING)).toYRot() + 180) % 360).build();
        });
    }
}