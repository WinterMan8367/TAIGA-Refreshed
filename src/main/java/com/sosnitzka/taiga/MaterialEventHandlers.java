package com.sosnitzka.taiga;

import static com.sosnitzka.taiga.util.Utils.registerFluid;

import org.apache.commons.lang3.StringUtils;

import com.sosnitzka.taiga.generic.BasicBlock;
import com.sosnitzka.taiga.generic.BasicItem;
import com.sosnitzka.taiga.generic.BlockOre;
import com.sosnitzka.taiga.util.UtilityMaterial;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary;

@Mod.EventBusSubscriber(modid = TAIGA.MODID)
public class MaterialEventHandlers {
    public static void manualRegisterFluids() {
        for (UtilityMaterial material : Materials.getAll()) {
            if (material.hasFluid()) {
                Fluid fluid = material.getFluid();
                registerFluid(fluid);
                material.createMoltenFluid();
            }
        }
    }

    @SubscribeEvent
    public static void registerBlocks(Register<Block> event) {
        for (BlockOre ore : Materials.getOres()) {
            event.getRegistry().register(ore);
        }

        for (BasicBlock block : Materials.getBlocks()) {
            event.getRegistry().register(block);
        }

        for (UtilityMaterial material : Materials.getAll()) {
            if (material.hasFluid()) {
                event.getRegistry().register(material.getMoltenFluid());
            }
        }
    }

    @SuppressWarnings("null")
    @SubscribeEvent
    public static void registerItems(Register<Item> event) {
        for (UtilityMaterial material : Materials.getAll()) {
            BasicItem ingot = material.getIngot();
            event.getRegistry().register(ingot);
            OreDictionary.registerOre(ingot.getOreDict(), ingot);

            BasicItem dust = material.getDust();
            event.getRegistry().register(dust);
            OreDictionary.registerOre(dust.getOreDict(), dust);

            BasicItem nugget = material.getNugget();
            event.getRegistry().register(nugget);
            OreDictionary.registerOre(nugget.getOreDict(), nugget);

            if (material.hasCrystal()) {
                BasicItem crystal = material.getCrystal();
                event.getRegistry().register(crystal);
                OreDictionary.registerOre(crystal.getOreDict(), crystal);
            }

            if (material.hasFluid()) {
                Block moltenFluid = material.getMoltenFluid();
                event.getRegistry().register(new ItemBlock(moltenFluid).setRegistryName(moltenFluid.getRegistryName()));
            }

            if (material.hasOre()) {
                BlockOre ore = material.getOre();
                event.getRegistry().register(new ItemBlock(ore).setRegistryName(ore.getRegistryName()));
                if (ore.isOreDict()) {
                    OreDictionary.registerOre(ore.getOreDictPrefix() + StringUtils.capitalize(material.getName().toLowerCase()), ore);
                }
            }

            BasicBlock block = material.getBlock();
            event.getRegistry().register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
            if (block.isOreDict()) {
                OreDictionary.registerOre(block.getOreDictPrefix() + StringUtils.capitalize(material.getName().toLowerCase()), block);
            }
        }
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        for (UtilityMaterial material : Materials.getAll()) {
            if (material.hasFluid()) {
                TAIGA.proxy.registerFluidModels(material.getFluid());
            }
        }
    }
}
