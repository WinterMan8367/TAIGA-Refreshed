package com.sosnitzka.taiga.generic;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
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
    private final float explosionChance;
    private final float explodableChance;

    public BlockOre(
        String name,
        Material material,
        float hardness,
        float resistance,
        int harvest,
        float lightLevel,
        String oreDictPrefix,
        ItemStack item,
        int xp,
        float explosionChance,
        float explodableChance
    ) {
        super(name, material, hardness, resistance, harvest, lightLevel, oreDictPrefix);
        this.dropItem = item;
        this.xpAmount = xp;
        this.explosionChance = Math.max((Math.min(explosionChance, 1.0F)), 0.0F);
        this.explodableChance = Math.max((Math.min(explodableChance, 1.0F)), 0.0F);
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
        if (explodableChance <= 0 || worldIn.isRemote) {
            return;
        }

        if (random.nextFloat() < explodableChance) {
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

    @Override
    @SuppressWarnings("null")
    public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {

        if (explosionChance <= 0 || (state.getBlock().canSilkHarvest(worldIn, pos, worldIn.getBlockState(pos), player)
            && EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, player.getHeldItemMainhand()) > 0)
        ) {
            return;
        }

        if (random.nextFloat() < explosionChance) {
            if (!worldIn.isRemote) {
                worldIn.newExplosion(
                    null,
                    pos.getX(),
                    pos.getY() + 1 / 16f,
                    pos.getZ(),
                    1.5f,
                    true,
                    true
                );
            }
        }
    }
}
