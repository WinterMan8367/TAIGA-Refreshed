package com.sosnitzka.taiga.dto;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import net.minecraft.item.ItemStack;

@Getter
@SuperBuilder
public class OreDto extends BlockDto {
    /** The item dropped upon mining and its quantity. If null, the same block is dropped */
    private ItemStack dropItem;
    /** The amount of experience gained from mining a block. Does not work if dropItem is null */
    private int xpAmount;
    /** Probability of exploding during extraction [0.0 < x <= 1.0] */
    private float explosionChance;
    /** Probability of exploding due to an external explosion [0.0 < x <= 1.0] */
    private float explodableChance;
}
