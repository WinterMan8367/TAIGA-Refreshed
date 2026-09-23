package com.sosnitzka.taiga.util;

import static com.sosnitzka.taiga.util.Utils.PREFIX_BLOCK;
import static com.sosnitzka.taiga.util.Utils.PREFIX_CRYSTAL;
import static com.sosnitzka.taiga.util.Utils.PREFIX_DUST;
import static com.sosnitzka.taiga.util.Utils.PREFIX_FLUID;
import static com.sosnitzka.taiga.util.Utils.PREFIX_INGOT;
import static com.sosnitzka.taiga.util.Utils.PREFIX_NUGGET;
import static com.sosnitzka.taiga.util.Utils.PREFIX_ORE;

import javax.annotation.Nullable;

import com.sosnitzka.taiga.Materials;
import com.sosnitzka.taiga.TAIGA;
import com.sosnitzka.taiga.dto.BlockDto;
import com.sosnitzka.taiga.dto.FluidDto;
import com.sosnitzka.taiga.dto.OreDto;
import com.sosnitzka.taiga.generic.BasicBlock;
import com.sosnitzka.taiga.generic.BasicItem;
import com.sosnitzka.taiga.generic.BasicTinkerFluid;
import com.sosnitzka.taiga.generic.BlockOre;

import slimeknights.tconstruct.smeltery.block.BlockMolten;

public class UtilityMaterial {
    private String name;
    private BasicItem ingot;
    private BasicItem dust;
    private BasicItem nugget;
    private @Nullable BasicItem crystal;
    private @Nullable BlockOre ore;
    private BasicBlock block;
    private @Nullable BasicTinkerFluid fluid;
    private @Nullable BlockMolten moltenFluid;

    public UtilityMaterial(
        String name,
        BlockDto blockProps,
        @Nullable OreDto oreProps,
        @Nullable FluidDto fluidProps,
        boolean hasCrystal
    ) {
        this.name = name;
        this.ingot = new BasicItem(name + "_" + PREFIX_INGOT, PREFIX_INGOT);
        this.dust = new BasicItem(name + "_" + PREFIX_DUST, PREFIX_DUST);
        this.nugget = new BasicItem(name + "_" + PREFIX_NUGGET, PREFIX_NUGGET);

        this.setBlockIfNull(blockProps);
        this.setOreIfNull(oreProps);
        this.setFluidIfNull(fluidProps);

        if (hasCrystal) {
            this.createCrystalIfNull();
        }

        Materials.append(this);
    }

    public UtilityMaterial(String name, BlockDto blockProps) {
        this(name, blockProps, null, null, false);
    }

    public UtilityMaterial(String name, BlockDto blockProps, boolean hasCrystal) {
        this(name, blockProps, null, null, hasCrystal);
    }

    public UtilityMaterial(String name, BlockDto blockProps, OreDto oreProps) {
        this(name, blockProps, oreProps, null, false);
    }

    public UtilityMaterial(String name, BlockDto blockProps, FluidDto fluidProps) {
        this(name, blockProps, null, fluidProps, false);
    }

    public UtilityMaterial(String name, BlockDto blockProps, OreDto oreProps, FluidDto fluidProps) {
        this(name, blockProps, oreProps, fluidProps, false);
    }

    public String getName() {
        return this.name;
    }

    public BasicItem getIngot() {
        return this.ingot;
    }

    public BasicItem getDust() {
        return this.dust;
    }

    public BasicItem getNugget() {
        return this.nugget;
    }

    public boolean hasFluid() {
        return this.fluid != null;
    }

    public BasicTinkerFluid getFluid() {
        return this.fluid;
    }

    public UtilityMaterial setFluidIfNull(FluidDto fluidProps) {
        if (fluidProps != null && !this.hasFluid()) {
            this.fluid = new BasicTinkerFluid(
                this.name + "_" + PREFIX_FLUID,
                fluidProps.getColor(),
                fluidProps.getTemperature(),
                fluidProps.getLuminosity(),
                fluidProps.getViscosity()
            );
        }
        
        return this;
    }

    public boolean hasMoltenFluid() {
        return this.moltenFluid != null;
    }

    public BlockMolten getMoltenFluid() {
        return this.moltenFluid;
    }

    public UtilityMaterial createMoltenFluidIfNull() {
        if (this.hasFluid() && !this.hasMoltenFluid()) {
            String moltenName = "molten_" + this.getFluid().getName();

            this.moltenFluid = new BlockMolten(fluid);
            this.moltenFluid
                .setUnlocalizedName(moltenName)
                .setRegistryName(TAIGA.MODID, moltenName);
        }

        return this;
    }

    public boolean hasCrystal() {
        return this.crystal != null;
    }

    public BasicItem getCrystal() {
        return this.crystal;
    }

    public UtilityMaterial createCrystalIfNull() {
        if (!this.hasCrystal()) {
            this.crystal = new BasicItem(name + "_" + PREFIX_CRYSTAL, PREFIX_CRYSTAL);
        }

        return this;
    }

    public boolean hasBlock() {
        return this.block != null;
    }

    public BasicBlock getBlock() {
        return this.block;
    }

    public UtilityMaterial setBlockIfNull(BlockDto blockProps) {
        if (blockProps != null && !this.hasBlock()) {
            this.block = new BasicBlock(
                name + "_" + PREFIX_BLOCK,
                blockProps.getMaterial(),
                blockProps.getHardness(),
                blockProps.getResistance(),
                blockProps.getHarvest(),
                blockProps.getLightLevel(),
                PREFIX_BLOCK
            );
        }

        return this;
    }

    public boolean hasOre() {
        return this.ore != null;
    }

    public BlockOre getOre() {
        return this.ore;
    }

    public UtilityMaterial setOreIfNull(OreDto oreProps) {
        if (oreProps != null && !this.hasOre()) {
            this.ore = new BlockOre(
                name + "_" + PREFIX_ORE,
                oreProps.getMaterial(),
                oreProps.getHardness(),
                oreProps.getResistance(),
                oreProps.getHarvest(),
                oreProps.getLightLevel(),
                PREFIX_ORE,
                oreProps.getDropItem(),
                oreProps.getXpAmount()
            );
        }

        return this;
    }
}
