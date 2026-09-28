package com.sosnitzka.taiga.generic;

import javax.annotation.Nullable;

import org.apache.commons.lang3.StringUtils;

import com.sosnitzka.taiga.CreativeTab;
import com.sosnitzka.taiga.dto.BlockDto;

import net.minecraft.block.Block;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;

public class ExtraBlock<T extends IRecipe> extends Block {
    private final String oreDictName;
    private T recipe;

    public ExtraBlock(
        String name,
        BlockDto blockProps,
        @Nullable String oreDictName
    ) {
        super(blockProps.getMaterial());

        if (name == null || name.length() == 0) {
            throw new NullPointerException("Block name must not be null or zero-length");
        }

        setUnlocalizedName(name);
        setRegistryName(name);
        setHardness(blockProps.getHardness());
        setResistance(blockProps.getResistance());
        setHarvestLevel("pickaxe", blockProps.getHarvest());
        setLightLevel(blockProps.getLightLevel());
        setCreativeTab(CreativeTab.tabTaigaBlock);

        this.oreDictName = oreDictName;
    }

    public boolean isShapeless() {
        return recipe instanceof ShapelessRecipes;
    }

    public boolean hasRecipe() {
        return recipe != null;
    }

    public T getRecipe() {
        return recipe;
    }

    public ExtraBlock<T> setRecipe(T recipe) {
        if (!(recipe instanceof ShapedRecipes) && !(recipe instanceof ShapelessRecipes)) {
            throw new IllegalArgumentException("Only two subclasses of IRecipe are permitted: ShapedRecipes and ShapelessRecipes");
        }

        this.recipe = recipe;
        return this;
    }

    public String getOreDict() {
        return oreDictName != null ? "block" + StringUtils.capitalize(oreDictName.toLowerCase()) : null;
    }
}
