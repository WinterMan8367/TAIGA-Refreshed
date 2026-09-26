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

import lombok.Getter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.smeltery.block.BlockMolten;

@Getter
public class UtilityMaterial {
    private final String name;
    private final BasicItem ingot;
    private final BasicItem dust;
    private final BasicItem nugget;
    private final BasicBlock block;
    private @Nullable Material tinkerMaterial;
    
    private @Nullable BasicItem crystal;
    private @Nullable BlockOre ore;
    private @Nullable BasicTinkerFluid fluid;
    private @Nullable BlockMolten moltenFluid;
    private @Nullable MaterialDto materialStats;

    public UtilityMaterial(
        String name,
        int nameHexColor,
        BlockDto blockProps
    ) {
        if (name == null || name.length() == 0) {
            throw new NullPointerException("Material name must not be null or zero-length");
        }

        if (blockProps == null) {
            throw new NullPointerException("Block properties must not be null");
        }

        this.name = name;
        ingot = new BasicItem(name, PREFIX_INGOT);
        dust = new BasicItem(name, PREFIX_DUST);
        nugget = new BasicItem(name, PREFIX_NUGGET);
        tinkerMaterial = new Material(name, nameHexColor);

        block = new BasicBlock(
            name + "_" + PREFIX_BLOCK,
            blockProps.getMaterial(),
            blockProps.getHardness(),
            blockProps.getResistance(),
            blockProps.getHarvest(),
            blockProps.getLightLevel(),
            PREFIX_BLOCK
        );

        Materials.add(this);
    }

    public UtilityMaterial forciblyRemoveMaterial() {
        tinkerMaterial = null;
        return this;
    }

    public UtilityMaterial ore(@Nullable OreDto oreProps) {
        if (oreProps != null && !hasOre()) {
            Item item = null;

            if (oreProps.getDropItem() != null) {
                item = oreProps.getDropItem();
            } else if (oreProps.getInternalItem() != null) {
                switch (oreProps.getInternalItem()) {
                    case INGOT:
                        item = ingot;
                    case DUST:
                        item = dust;
                    case NUGGET:
                        item = nugget;
                    case CRYSTAL:
                        if (hasCrystal()) {
                            item = crystal;
                        }
                }
            }

            ItemStack itemStack = item != null ? new ItemStack(item, oreProps.getCount()) : null;

            ore = new BlockOre(
                name + "_" + PREFIX_ORE,
                oreProps.getMaterial(),
                oreProps.getHardness(),
                oreProps.getResistance(),
                oreProps.getHarvest(),
                oreProps.getLightLevel(),
                PREFIX_ORE,
                itemStack,
                oreProps.getXpAmount(),
                oreProps.getExplosionChance(),
                oreProps.getExplodableChance()
            );
        }

        return this;
    }

    public UtilityMaterial material(@Nullable MaterialDto materialProps) {
        if (materialProps != null && !hasMaterialStats()) {
            materialStats = materialProps;
        }

        return this;
    }

    public UtilityMaterial fluid(@Nullable FluidDto fluidProps) {
        if (fluidProps != null && !hasFluid()) {
            fluid = new BasicTinkerFluid(
                name + "_" + PREFIX_FLUID,
                fluidProps.getColor(),
                fluidProps.getTemperature(),
                fluidProps.getLuminosity(),
                fluidProps.getViscosity()
            );
        }

        return this;
    }

    public UtilityMaterial crystal() {
        if (!hasCrystal()) {
            crystal = new BasicItem(name, PREFIX_CRYSTAL);
        }

        return this;
    }

    public UtilityMaterial traits(AbstractTrait ...traits) {
        for (AbstractTrait trait : traits) {
            if (tinkerMaterial == null) {
                throw new NullPointerException("An attempt to assign a trait to material that was forcibly removed when the variable was declared");
            }

            tinkerMaterial.addTrait(trait);
        }

        return this;
    }

    public UtilityMaterial traits(String type, AbstractTrait ...traits) {
        for (AbstractTrait trait : traits) {
            if (tinkerMaterial == null) {
                throw new NullPointerException("An attempt to assign a trait to material that was forcibly removed when the variable was declared");
            }
            
            tinkerMaterial.addTrait(trait, type);
        }
        
        return this;
    }

    public boolean hasFluid() {
        return fluid != null;
    }

    public boolean hasMoltenFluid() {
        return moltenFluid != null;
    }

    public boolean hasCrystal() {
        return crystal != null;
    }

    public boolean hasOre() {
        return ore != null;
    }

    public boolean hasMaterialStats() {
        return materialStats != null;
    }

    @SuppressWarnings("null")
    public void createMoltenFluid() {
        if (!hasFluid() || hasMoltenFluid()) {
            return;
        }

        String moltenName = "molten_" + fluid.getName();

        moltenFluid = new BlockMolten(fluid);
        moltenFluid.setUnlocalizedName(moltenName);
        moltenFluid.setRegistryName(TAIGA.MODID, moltenName);
    }
}
