package com.sosnitzka.taiga.dto;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import net.minecraft.block.material.Material;

@Getter
@SuperBuilder
public class BlockDto {
    private Material material;
    private float hardness;
    private float resistance;
    private int harvest;
    private float lightLevel;
    private boolean includeOreDict;
}
