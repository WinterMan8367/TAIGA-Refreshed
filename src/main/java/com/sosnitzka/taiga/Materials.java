package com.sosnitzka.taiga;

import com.sosnitzka.taiga.dto.BlockDto;
import com.sosnitzka.taiga.dto.FluidDto;
import com.sosnitzka.taiga.dto.OreDto;
import com.sosnitzka.taiga.generic.BasicBlock;
import com.sosnitzka.taiga.generic.BasicItem;
import com.sosnitzka.taiga.generic.BlockOre;
import com.sosnitzka.taiga.util.UtilityMaterial;
import static com.sosnitzka.taiga.TAIGA.logger;
import static com.sosnitzka.taiga.util.Utils.registerFluid;
import static slimeknights.tconstruct.library.utils.HarvestLevels.*;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary;

import java.util.HashSet;

import org.apache.commons.lang3.StringUtils;

@Mod.EventBusSubscriber(modid = TAIGA.MODID)
public class Materials {

    private static HashSet<UtilityMaterial> materials = new HashSet<>();

    public static void append(UtilityMaterial material) {
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

    public static UtilityMaterial test = new UtilityMaterial(
        "test",
        BlockDto.builder().material(Material.ROCK).hardness(10.0F).resistance(10.0F).harvest(STONE).build(),
        OreDto.builder().material(Material.ROCK).hardness(10.0F).resistance(10.0F).harvest(STONE).build()
    );

    public static UtilityMaterial doubleTest = new UtilityMaterial(
        "doubleTest",
        BlockDto.builder().material(Material.ROCK).hardness(10.0F).resistance(10.0F).harvest(STONE).build(),
        OreDto.builder().material(Material.ROCK).hardness(10.0F).resistance(10.0F).harvest(STONE).build(),
        FluidDto.builder().color(0x0).temperature(550).luminosity(10).viscosity(6000).build(),
        true
    );

    public static void manualRegisterFluids() {
        logger.warn("MANUAL REGISTER FLUIDS");
        for (UtilityMaterial material : materials) {
            if (material.hasFluid()) {
                Fluid fluid = material.getFluid();
                registerFluid(fluid);
                material.createMoltenFluidIfNull();
                TAIGA.proxy.registerFluidModels(fluid);
                logger.info("Material: <" + material.getName() + ">. [FLUID] registered");
            }
        }   
    }

    @SubscribeEvent
    public static void registerBlocks(Register<Block> event) {
        logger.warn("EVENT REGISTER BLOCKS");
        for (UtilityMaterial material : materials) {
            if (material.hasOre()) {
                Block ore = material.getOre();
                ore.setCreativeTab(CreativeTab.tabTaigaBlock);
                event.getRegistry().register(ore);
                logger.info("Material: <" + material.getName() + ">. [ORE] registered");
            }

            if (material.hasBlock()) {
                Block block = material.getBlock();
                block.setCreativeTab(CreativeTab.tabTaigaBlock);
                event.getRegistry().register(block);
                logger.info("Material: <" + material.getName() + ">. [BLOCK] registered");
            }

            if (material.hasFluid()) {
                Block moltenFluid = material.getMoltenFluid();
                event.getRegistry().register(moltenFluid);
                logger.info("Material: <" + material.getName() + ">. [MOLTEN FLUID] registered");
            }
        }
    }

    @SubscribeEvent
    public static void registerItems(Register<Item> event) {
        logger.warn("EVENT REGISTER ITEMS");
        for (UtilityMaterial material : materials) {
            BasicItem ingot = material.getIngot();
            ingot.setCreativeTab(CreativeTab.tabTaigaItem);
            event.getRegistry().register(ingot);
            OreDictionary.registerOre(ingot.getOreDictPrefix() + StringUtils.capitalize(material.getName().toLowerCase()), ingot);
            logger.info("Material: <" + material.getName() + ">. [INGOT] registered");

            BasicItem dust = material.getDust();
            dust.setCreativeTab(CreativeTab.tabTaigaItem);
            event.getRegistry().register(dust);
            OreDictionary.registerOre(dust.getOreDictPrefix() + StringUtils.capitalize(material.getName().toLowerCase()), dust);
            logger.info("Material: <" + material.getName() + ">. [DUST] registered");

            BasicItem nugget = material.getNugget();
            nugget.setCreativeTab(CreativeTab.tabTaigaItem);
            event.getRegistry().register(nugget);
            OreDictionary.registerOre(nugget.getOreDictPrefix() + StringUtils.capitalize(material.getName().toLowerCase()), nugget);
            logger.info("Material: <" + material.getName() + ">. [NUGGET] registered");

            if (material.hasCrystal()) {
                BasicItem crystal = material.getCrystal();
                crystal.setCreativeTab(CreativeTab.tabTaigaItem);
                event.getRegistry().register(crystal);
                OreDictionary.registerOre(crystal.getOreDictPrefix() + StringUtils.capitalize(material.getName().toLowerCase()), crystal);
                logger.info("Material: <" + material.getName() + ">. [CRYSTALs] registered");
            }

            if (material.hasFluid()) {
                Block moltenFluid = material.getMoltenFluid();
                event.getRegistry().register(new ItemBlock(moltenFluid).setRegistryName(moltenFluid.getRegistryName()));
                logger.info("Material: <" + material.getName() + ">. [MOLTEN FLUID as ITEM] registered");
            }

            if (material.hasOre()) {
                BlockOre ore = material.getOre();
                event.getRegistry().register(new ItemBlock(ore).setRegistryName(ore.getRegistryName()));
                if (ore.isOreDict()) {
                    OreDictionary.registerOre(ore.getOreDictPrefix() + StringUtils.capitalize(material.getName().toLowerCase()), ore);
                }
                logger.info("Material: <" + material.getName() + ">. [ORE as ITEM] registered");
            }

            if (material.hasBlock()) {
                BasicBlock block = material.getBlock();
                event.getRegistry().register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
                if (block.isOreDict()) {
                    OreDictionary.registerOre(block.getOreDictPrefix() + StringUtils.capitalize(material.getName().toLowerCase()), block);
                }
                logger.info("Material: <" + material.getName() + ">. [BLOCK as ITEM] registered");
            }
        }
    }
}
