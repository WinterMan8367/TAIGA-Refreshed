package com.sosnitzka.taiga.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import net.minecraft.block.material.Material;

@Getter
@SuperBuilder
public class BlockDto {
    @Builder.Default private Material material = Material.AIR;
    private float hardness;
    private float resistance;
    private int harvest;
    private float lightLevel;
}
