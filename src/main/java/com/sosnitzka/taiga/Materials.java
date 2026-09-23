package com.sosnitzka.taiga;

import com.sosnitzka.taiga.generic.BlockProps;
import com.sosnitzka.taiga.generic.FluidProps;
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
import slimeknights.tconstruct.smeltery.block.BlockMolten;

import java.util.HashSet;

@Mod.EventBusSubscriber(modid = TAIGA.MODID)
public class Materials {

    private static HashSet<UtilityMaterial> materials = new HashSet<>();

    public static void append(UtilityMaterial material) {
        if (material != null) {
            materials.add(material);
        }
    }

    // public static UtilityMaterial tin = new UtilityMaterial(
    //     "tin",
    //     new BlockProps(Material.ROCK, 10.0f, 10f, STONE),
    //     new BlockProps(Material.ROCK, 10.0f, 10f, STONE)
    // );
    // public static UtilityMaterial copper = new UtilityMaterial(
    //     "copper",
    //     new BlockProps(Material.ROCK, 10.0f, 10f, STONE),
    //     new BlockProps(Material.ROCK, 10.0f, 10f, STONE)
    // );
    // public static UtilityMaterial bronze = new UtilityMaterial(
    //     "bronze",
    //     new BlockProps(Material.ROCK, 10.0f, 10f, STONE),
    //     new BlockProps(Material.ROCK, 10.0f, 10f, STONE)
    // );

    public static UtilityMaterial test = new UtilityMaterial(
        "test",
        new BlockProps(Material.ROCK, 10.0f, 10f, STONE),
        new BlockProps(Material.ROCK, 10.0f, 10f, STONE)
    );

    public static UtilityMaterial doubleTest = new UtilityMaterial(
        "doubleTest",
        new FluidProps(0x0, 550, 10, 6000),
        new BlockProps(Material.ROCK, 10.0f, 10f, STONE),
        new BlockProps(Material.ROCK, 10.0f, 10f, STONE),
        true
    );

    public static UtilityMaterial onlyItems = new UtilityMaterial("onlyItems");

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
            if (material.hasBlock()) {
                Block block = material.getBlock();
                block.setCreativeTab(CreativeTab.tabTaigaBlock);
                event.getRegistry().register(block);
                logger.info("Material: <" + material.getName() + ">. [BLOCK] registered");
            }

            if (material.hasOre()) {
                Block ore = material.getOre();
                ore.setCreativeTab(CreativeTab.tabTaigaBlock);
                event.getRegistry().register(ore);
                logger.info("Material: <" + material.getName() + ">. [ORE] registered");
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
            Item ingot = material.getIngot();
            ingot.setCreativeTab(CreativeTab.tabTaigaItem);
            event.getRegistry().register(ingot);
            logger.info("Material: <" + material.getName() + ">. [INGOT] registered");

            Item dust = material.getDust();
            dust.setCreativeTab(CreativeTab.tabTaigaItem);
            event.getRegistry().register(dust);
            logger.info("Material: <" + material.getName() + ">. [DUST] registered");

            Item nugget = material.getNugget();
            nugget.setCreativeTab(CreativeTab.tabTaigaItem);
            event.getRegistry().register(nugget);
            logger.info("Material: <" + material.getName() + ">. [NUGGET] registered");

            if (material.hasCrystal()) {
                Item crystal = material.getCrystal();
                crystal.setCreativeTab(CreativeTab.tabTaigaItem);
                event.getRegistry().register(crystal);
                logger.info("Material: <" + material.getName() + ">. [CRYSTALs] registered");
            }

            if (material.hasFluid()) {
                Block moltenFluid = material.getMoltenFluid();
                event.getRegistry().register(new ItemBlock(moltenFluid).setRegistryName(moltenFluid.getRegistryName()));
                logger.info("Material: <" + material.getName() + ">. [MOLTEN FLUID as ITEM] registered");
            }

            if (material.hasOre()) {
                Block ore = material.getOre();
                event.getRegistry().register(new ItemBlock(ore).setRegistryName(ore.getRegistryName()));
                logger.info("Material: <" + material.getName() + ">. [ORE as ITEM] registered");
            }

            if (material.hasBlock()) {
                Block block = material.getBlock();
                event.getRegistry().register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
                logger.info("Material: <" + material.getName() + ">. [BLOCK as ITEM] registered");
            }
        }
    }
}
