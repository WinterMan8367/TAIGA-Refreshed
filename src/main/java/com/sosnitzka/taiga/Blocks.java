package com.sosnitzka.taiga;

import com.google.common.base.Joiner;
import com.sosnitzka.taiga.blocks.BlockCobble;
import com.sosnitzka.taiga.blocks.BlockMeteoriteRock;
import com.sosnitzka.taiga.generic.BasicBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.oredict.OreDictionary;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.Arrays;

import static com.sosnitzka.taiga.MaterialTraits.*;
import static slimeknights.tconstruct.library.utils.HarvestLevels.*;

public class Blocks {
    public static Block blockMeteoriteCobble = new BlockCobble("meteorite_cobblestone", Material.ROCK, 20f, 10f,
            COBALT, 0.075f, null);
    public static Block blockObsidioriteCobble = new BlockCobble("obsidiorite_cobblestone", Material.ROCK, 25f, 20f,
            DURANITE, 0.035f, null);
    public static Block blockMeteoriteStone = new BlockMeteoriteRock("meteorite_stone", Material.ROCK, 40f, 2000f, COBALT,
            0.15f, null, blockMeteoriteCobble.getDefaultState());
    public static Block blockObsidioriteStone = new BlockMeteoriteRock("obsidiorite_stone", Material.ROCK, 50f, 4000f,
            DURANITE, 0.2f, null, blockObsidioriteCobble.getDefaultState());

    /**
     * Registers all materials' ingots and nuggets <br>
     * Detailed summary: <br>
     * Gets the ingots declared in the class (fields and reflection) and iterates
     * through them: <br>
     * Checks that the field is static, registers the field (item), and adds an
     * oreDict entry if needed
     */
    @SubscribeEvent
    public static void register(boolean oreDict) {
        Field[] declaredFields = Blocks.class.getDeclaredFields(); // Gets the fields (ingots) declared above
        for (Field field : declaredFields) { // Iterates through the fields declared above
            if (java.lang.reflect.Modifier.isStatic(field.getModifiers())) { // Checks that the fields are static
                Class<?> targetType = field.getType();
                try {
                    Block block = (Block) field.get(targetType);
                    if (!oreDict) {
                        block.setCreativeTab(CreativeTab.tabTaigaBlock);
                        ForgeRegistries.BLOCKS.register(block); // Registers block and its item
                    } else {
                        if (block instanceof BasicBlock) { // Checks that the block is a BasicBlock
                            if (((BasicBlock) block).isOreDict()) { // Checks that the block has an oreDict entry
                                String oreDictName;
                                String[] nameParts = block.getUnlocalizedName().replace("tile.", "").split("_");

                                if (nameParts.length > 2) {
                                    oreDictName = Joiner.on("_")
                                            .join(Arrays.copyOfRange(nameParts, 0, nameParts.length - 1));
                                } else {
                                    oreDictName = nameParts[0];
                                }
                                OreDictionary.registerOre(((BasicBlock) block).getOreDictPrefix() + StringUtils
                                        .capitalize(oreDictName), block); // Registers the block's oreDict
                            }
                        }
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @SubscribeEvent
    public static void registerItems() {
        Field[] declaredFields = Blocks.class.getDeclaredFields(); // Gets the fields (ingots) declared above
        for (Field field : declaredFields) { // Iterates through the fields declared above
            if (java.lang.reflect.Modifier.isStatic(field.getModifiers())) { // Checks that the fields are static
                Class<?> targetType = field.getType();
                try {
                    Block block = (Block) field.get(targetType); // Gets the field as a BasicBlock which is then
                    // casted to an Block
                    ForgeRegistries.ITEMS.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
