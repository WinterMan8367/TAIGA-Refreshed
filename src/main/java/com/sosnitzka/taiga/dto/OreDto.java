package com.sosnitzka.taiga.dto;

import lombok.Getter;

import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

@Getter
public class OreDto extends BlockDto {
    public enum InternalItem {
        INGOT, DUST, NUGGET, CRYSTAL
    }

    /** The item dropped upon mining and its quantity. If null, the same block is dropped */
    private Item dropItem;
    private InternalItem internalItem;
    private int count;
    /** The amount of experience gained from mining a block. Does not work if dropItem is null */
    private int xpAmount;
    /** Probability of exploding during extraction [0.0 < x <= 1.0] */
    private float explosionChance;
    /** Probability of exploding due to an external explosion [0.0 < x <= 1.0] */
    private float explodableChance;

    public OreDto(Material material, float hardness, float resistance, int harvest, float lightLevel) {
        super(material, hardness, resistance, harvest, lightLevel);
    }

    public OreDto(Material material, float hardness, float resistance, int harvest) {
        super(material, hardness, resistance, harvest);
    }

    public OreDto dropItemAndXp(ItemStack itemStack, int xp) {
        if (itemStack == null) {
            return this;
        }

        internalItem = null;
        dropItem = itemStack.getItem();
        count = itemStack.getCount();
        xpAmount = Math.max(xp, 0);

        return this;
    }

    public OreDto dropItemAndXp(InternalItem item, int count, int xp) {
        if (item == null) {
            return this;
        }

        dropItem = null;
        internalItem = item;
        this.count = count;
        xpAmount = Math.max(xp, 0);

        return this;
    }

    public OreDto explosionChance(float x) {
        explosionChance = x;
        return this;
    }

    public OreDto explodableChance(float x) {
        explodableChance = x;
        return this;
    }
}
