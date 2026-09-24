package com.sosnitzka.taiga.generic;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.ParametersAreNonnullByDefault;

import java.util.Random;

import static slimeknights.tconstruct.TConstruct.random;

public class BlockOre extends BasicBlock {
    private final ItemStack dropItem;
    private final int xpAmount;

    public BlockOre(
        String name,
        Material material,
        float hardness,
        float resistance,
        int harvest,
        float lightLevel,
        String oreDictPrefix,
        ItemStack item,
        int xp
    ) {
        super(name, material, hardness, resistance, harvest, lightLevel, oreDictPrefix);
        this.dropItem = item;
        this.xpAmount = xp;
    }

    @Override
    @ParametersAreNonnullByDefault
    public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
        if (xpAmount <= 0 || dropItem == null) {
            return super.getExpDrop(state, world, pos, fortune);
        }

        return random.nextInt(xpAmount) + fortune;
    }

    @Override
    @ParametersAreNonnullByDefault
    public int quantityDropped(IBlockState state, int fortune, Random random) {
        if (dropItem == null) {
            return super.quantityDropped(state, fortune, random);
        }

        return (random.nextInt(dropItem.getCount() + fortune) + 1);
    }

    @Override
    @ParametersAreNonnullByDefault
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        if (dropItem == null) {
            return super.getItemDropped(state, rand, fortune);
        }

        return dropItem.getItem();
    }

    @Override
    @ParametersAreNonnullByDefault
    public void onBlockDestroyedByExplosion(World worldIn, BlockPos pos, Explosion explosionIn) {
        if (!worldIn.isRemote) {
            if (random.nextFloat() < 0.5) {
                worldIn.newExplosion(
                    null,
                    pos.getX(),
                    pos.getY(),
                    pos.getZ(),
                    random.nextFloat() * 4f + 1.5f,
                    true,
                    true
                );
            }
        }
    }
}
