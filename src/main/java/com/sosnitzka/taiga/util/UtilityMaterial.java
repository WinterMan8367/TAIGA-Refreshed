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
import com.sosnitzka.taiga.generic.BasicBlock;
import com.sosnitzka.taiga.generic.BasicItem;
import com.sosnitzka.taiga.generic.BasicTinkerFluid;
import com.sosnitzka.taiga.generic.BlockOre;
import com.sosnitzka.taiga.generic.BlockProps;
import com.sosnitzka.taiga.generic.FluidProps;

import slimeknights.tconstruct.smeltery.block.BlockMolten;

public class UtilityMaterial {
    private String name;
    private BasicItem ingot;
    private BasicItem dust;
    private BasicItem nugget;
    private @Nullable BasicTinkerFluid fluid;
    private @Nullable BlockMolten moltenFluid;
    private @Nullable BasicItem crystal;
    private @Nullable BasicBlock block;
    private @Nullable BlockOre ore;

    public UtilityMaterial(
        String name,
        @Nullable FluidProps fluidProps,
        @Nullable BlockProps blockProps,
        @Nullable BlockProps oreProps,
        boolean hasCrystal
    ) {
        this.name = name;
        this.ingot = new BasicItem(name + "_" + PREFIX_INGOT, PREFIX_INGOT);
        this.dust = new BasicItem(name + "_" + PREFIX_DUST, PREFIX_DUST);
        this.nugget = new BasicItem(name + "_" + PREFIX_NUGGET, PREFIX_NUGGET);

        this.setFluidIfNull(fluidProps);
        this.setBlockIfNull(blockProps);
        this.setOreIfNull(oreProps);

        if (hasCrystal) {
            this.createCrystalIfNull();
        }

        Materials.append(this);
    }

    public UtilityMaterial(String name) {
        this(name, null, null, null, false);
    }

    public UtilityMaterial(String name, boolean hasCrystal) {
        this(name, null, null, null, hasCrystal);
    }

    public UtilityMaterial(String name, FluidProps fluidProps) {
        this(name, fluidProps, null, null, false);
    }

    public UtilityMaterial(String name, BlockProps blockProps) {
        this(name, null, blockProps, null, false);
    }

    public UtilityMaterial(String name, BlockProps blockProps, BlockProps oreProps) {
        this(name, null, blockProps, oreProps, false);
    }

    public UtilityMaterial(String name, FluidProps fluidProps, BlockProps blockProps) {
        this(name, fluidProps, blockProps, null, false);
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

    public UtilityMaterial setFluidIfNull(FluidProps fluidProps) {
        if (fluidProps != null && !this.hasFluid()) {
            this.fluid = new BasicTinkerFluid(
                this.name + "_" + PREFIX_FLUID,
                fluidProps.getFluidColor(),
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

    public UtilityMaterial setBlockIfNull(BlockProps blockProps) {
        if (blockProps != null && !this.hasBlock()) {
            this.block = new BasicBlock(
                name + "_" + PREFIX_BLOCK,
                blockProps.getMaterial(),
                blockProps.getHardness(),
                blockProps.getResistance(),
                blockProps.getHarvestLevel(),
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

    public UtilityMaterial setOreIfNull(BlockProps oreProps) {
        if (oreProps != null && !this.hasOre()) {
            this.ore = new BlockOre(
                name + "_" + PREFIX_ORE,
                oreProps.getMaterial(),
                oreProps.getHardness(),
                oreProps.getResistance(),
                oreProps.getHarvestLevel(),
                oreProps.getLightLevel(),
                oreProps.getDropItem(),
                oreProps.getDropItemAmount(), 
                oreProps.getXpAmount()
            );
        }

        return this;
    }
}
