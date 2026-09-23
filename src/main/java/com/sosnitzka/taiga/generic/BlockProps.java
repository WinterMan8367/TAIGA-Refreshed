package com.sosnitzka.taiga.generic;

import javax.annotation.Nullable;

import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BlockProps {
    public enum BlockType {
        BLOCK, ORE
    }

    private Material material;
    private float hardness;
    private float resistance;
    private int harvest;
    private float lightLevel;
    private BlockType type;
    private @Nullable ItemStack dropItem;
    private int xpAmount;

    public BlockProps(
        Material material,
        float hardness,
        float resistance,
        int harvest,
        float lightLevel,
        BlockType type,
        ItemStack dropItem,
        int xpAmount
    ) {
        this.material = material;
        this.hardness = hardness;
        this.resistance = resistance;
        this.harvest = harvest;
        this.lightLevel = lightLevel;
        this.type = type;
        this.dropItem = dropItem;
        this.xpAmount = xpAmount;
    }

    public BlockProps(
        Material material,
        float hardness,
        float resistance,
        int harvest,
        BlockType type,
        ItemStack dropItem,
        int xpAmount
    ) {
        this(material, hardness, resistance, harvest, 0.0F, type, dropItem, xpAmount);
    }

    public BlockProps(
        Material material,
        float hardness,
        float resistance,
        int harvest,
        float lightLevel,
        BlockType type,
        ItemStack dropItem
    ) {
        this(material, hardness, resistance, harvest, lightLevel, type, dropItem, 0);
    }

    public BlockProps(
        Material material,
        float hardness,
        float resistance,
        int harvest,
        BlockType type,
        ItemStack dropItem
    ) {
        this(material, hardness, resistance, harvest, 0.0F, type, dropItem, 0);
    }

    public BlockProps(
        Material material,
        float hardness,
        float resistance,
        int harvest,
        float lightLevel,
        BlockType type
    ) {
        this(material, hardness, resistance, harvest, lightLevel, type, null, 0);
    }

    public BlockProps(
        Material material,
        float hardness,
        float resistance,
        int harvest,
        BlockType type
    ) {
        this(material, hardness, resistance, harvest, 0.0F, type);
    }

    public BlockProps(
        Material material,
        float hardness,
        float resistance,
        int harvest,
        float lightLevel
    ) {
        this(material, hardness, resistance, harvest, lightLevel, BlockType.BLOCK);
    }

    public BlockProps(
        Material material,
        float hardness,
        float resistance,
        int harvest
    ) {
        this(material, hardness, resistance, harvest, 0.0F);
    }

    public Material getMaterial() {
        return this.material;
    }

    public float getHardness() {
        return this.hardness;
    }

    public float getResistance() {
        return this.resistance;
    }

    public int getHarvestLevel() {
        return this.harvest;
    }

    public float getLightLevel() {
        return this.lightLevel;
    }

    public BlockType getType() {
        return this.type;
    }

    public Item getDropItem() {
        return this.dropItem != null ? this.dropItem.getItem() : null;
    }

    public int getDropItemAmount() {
        return this.dropItem != null ? this.dropItem.getCount() : 0;
    }

    public int getXpAmount() {
        return xpAmount;
    }
}
