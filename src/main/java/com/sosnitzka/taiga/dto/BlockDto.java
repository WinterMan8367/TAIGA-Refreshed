package com.sosnitzka.taiga.dto;

import lombok.Getter;

import net.minecraft.block.material.Material;

@Getter
public class BlockDto {
    private Material material;
    private float hardness;
    private float resistance;
    private int harvest;
    private float lightLevel;

    public BlockDto(Material material, float hardness, float resistance, int harvest, float lightLevel) {
        this.material = material != null ? material : Material.AIR;
        this.hardness = hardness;
        this.resistance = resistance;
        this.harvest = harvest;
        this.lightLevel = lightLevel;
    }

    public BlockDto(Material material, float hardness, float resistance, int harvest) {
        this(material, hardness, resistance, harvest, 0.0F);
    }
}
