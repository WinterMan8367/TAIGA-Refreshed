package com.sosnitzka.taiga;

import com.sosnitzka.taiga.dto.BlockDto;
import com.sosnitzka.taiga.dto.FluidDto;
import com.sosnitzka.taiga.dto.MaterialDto;
import com.sosnitzka.taiga.dto.OreDto;
import com.sosnitzka.taiga.generic.BasicBlock;
import com.sosnitzka.taiga.generic.BlockOre;
import com.sosnitzka.taiga.util.UtilityMaterial;

import net.minecraft.block.material.Material;

import static slimeknights.tconstruct.library.utils.HarvestLevels.*;
import slimeknights.tconstruct.library.materials.MaterialTypes;

import java.util.HashSet;

public class Materials {

    private static HashSet<UtilityMaterial> materials = new HashSet<>();

    public static void add(UtilityMaterial material) {
        if (material != null) {
            materials.add(material);
        }
    }
    
    public static UtilityMaterial get(String name) {
        for (UtilityMaterial material : materials) {
            if (material.getName().equals(name)) {
                return material;
            }
        }

        return null;
    }

    public static HashSet<UtilityMaterial> getAll() {
        return materials;
    }

    public static HashSet<BlockOre> getOres() {
        HashSet<BlockOre> ores = new HashSet<>();

        for (UtilityMaterial material : materials) {
            if (material.hasOre()) {
                ores.add(material.getOre());
            }
        }

        return ores;
    }

    public static HashSet<BasicBlock> getBlocks() {
        HashSet<BasicBlock> blocks = new HashSet<>();

        for (UtilityMaterial material : materials) {
            blocks.add(material.getBlock());
        }

        return blocks;
    } 

    public static UtilityMaterial test = new UtilityMaterial(
        "test",
        0x0,
        BlockDto.builder().material(Material.ROCK).hardness(10.0F).resistance(10.0F).harvest(STONE).build()
    )
        .ore(OreDto.builder().material(Material.ROCK).hardness(10.0F).resistance(10.0F).harvest(STONE).build());

    public static UtilityMaterial doubletest = new UtilityMaterial(
        "doubletest",
        0x00FF00,
        BlockDto.builder().material(Material.ROCK).hardness(10.0F).resistance(10.0F).harvest(STONE).build()
    )
        .crystal()
        .ore(OreDto.builder().material(Material.ROCK).hardness(10.0F).resistance(10.0F).harvest(STONE).build())
        .fluid(FluidDto.builder().color(0xFF0000).temperature(550).luminosity(10).viscosity(6000).build())
        .material(MaterialDto.builder().isCraftable(true).isCastable(true).build())
        .appendTraits(MaterialTraits.instable, MaterialTraits.arcane)
        .appendTraits(MaterialTypes.HEAD, MaterialTraits.mutate)
        .appendTraits(MaterialTypes.HANDLE, MaterialTraits.naturebound);
}
