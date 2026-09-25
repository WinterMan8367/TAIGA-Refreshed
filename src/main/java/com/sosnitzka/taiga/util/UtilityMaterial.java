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
import com.sosnitzka.taiga.dto.MaterialDto;
import com.sosnitzka.taiga.dto.OreDto;
import com.sosnitzka.taiga.generic.BasicBlock;
import com.sosnitzka.taiga.generic.BasicItem;
import com.sosnitzka.taiga.generic.BasicTinkerFluid;
import com.sosnitzka.taiga.generic.BlockOre;

import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.smeltery.block.BlockMolten;

public class UtilityMaterial {
    private final String name;
    private final BasicItem ingot;
    private final BasicItem dust;
    private final BasicItem nugget;
    private final BasicBlock block;
    private final Material material;
    
    private @Nullable BasicItem crystal;
    private @Nullable BlockOre ore;
    private @Nullable BasicTinkerFluid fluid;
    private @Nullable BlockMolten moltenFluid;
    private @Nullable MaterialDto materialStats;

    public UtilityMaterial(
        String name,
        int textColor,
        BlockDto blockProps,
        @Nullable OreDto oreProps,
        @Nullable MaterialDto materialProps,
        @Nullable FluidDto fluidProps,
        boolean hasCrystal
    ) {
        if (name == null || name.length() == 0) {
            throw new NullPointerException("Material name must not be null or zero-length");
        }

        if (blockProps == null) {
            throw new NullPointerException("Block properties must not be null");
        }

        this.name = name;
        this.ingot = new BasicItem(name + "_" + PREFIX_INGOT, PREFIX_INGOT);
        this.dust = new BasicItem(name + "_" + PREFIX_DUST, PREFIX_DUST);
        this.nugget = new BasicItem(name + "_" + PREFIX_NUGGET, PREFIX_NUGGET);
        this.material = new Material(name, textColor);

        this.materialStats = materialProps;

        this.setOreIfNull(oreProps);

        this.block = new BasicBlock(
            name + "_" + PREFIX_BLOCK,
            blockProps.getMaterial(),
            blockProps.getHardness(),
            blockProps.getResistance(),
            blockProps.getHarvest(),
            blockProps.getLightLevel(),
            PREFIX_BLOCK
        );

        this.setFluidIfNull(fluidProps);

        if (hasCrystal) {
            this.createCrystalIfNull();
        }

        Materials.add(this);
    }

    public UtilityMaterial(String name, int textColor, BlockDto blockProps) {
        this(name, textColor, blockProps, false);
    }

    public UtilityMaterial(String name, int textColor, BlockDto blockProps, boolean hasCrystal) {
        this(name, textColor, blockProps, null, null, null, hasCrystal);
    }

    public UtilityMaterial(String name, int textColor, BlockDto blockProps, OreDto oreProps) {
        this(name, textColor, blockProps, oreProps, null, null);
    }

    public UtilityMaterial(String name, int textColor, BlockDto blockProps, MaterialDto materialProps, FluidDto fluidProps) {
        this(name, textColor, blockProps, null, materialProps, fluidProps);
    }

    public UtilityMaterial(String name, int textColor, BlockDto blockProps, OreDto oreProps, MaterialDto materialProps, FluidDto fluidProps) {
        this(name, textColor, blockProps, oreProps, materialProps, fluidProps, false);
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

    public BasicBlock getBlock() {
        return this.block;
    }

    public Material getTinkerMaterial() {
        return this.material;
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

    @SuppressWarnings("null")
    public UtilityMaterial createMoltenFluidIfNull() {
        if (this.hasFluid() && !this.hasMoltenFluid()) {
            String moltenName = "molten_" + this.getFluid().getName();
            TAIGA.logger.info("FLUID CHECK NAME: " + moltenName);

            this.moltenFluid = new BlockMolten(fluid);
            this.moltenFluid.setUnlocalizedName(moltenName);
            this.moltenFluid.setRegistryName(TAIGA.MODID, moltenName);
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

    public boolean hasMaterialStats() {
        return this.materialStats != null;
    }

    public MaterialDto getMaterialStats() {
        return this.materialStats;
    }

    public UtilityMaterial appendTraits(AbstractTrait ...traits) {
        for (AbstractTrait trait : traits) {
            this.material.addTrait(trait);
        }

        return this;
    }

    public UtilityMaterial appendTraitsByType(String type, AbstractTrait ...traits) {
        for (AbstractTrait trait : traits) {
            this.material.addTrait(trait, type);
        }
        
        return this;
    }
}
