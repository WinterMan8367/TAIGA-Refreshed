package com.sosnitzka.taiga.recipes;

import com.sosnitzka.taiga.Blocks;
import com.sosnitzka.taiga.Items;
import com.sosnitzka.taiga.Materials;
import com.sosnitzka.taiga.TAIGA;
import com.sosnitzka.taiga.util.UtilityMaterial;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.util.NonNullList;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = TAIGA.MODID)
public class CraftingRegistry {

    @SuppressWarnings("null")
    @SubscribeEvent
    public static void registerRecipes(Register<IRecipe> event) {
        for (UtilityMaterial material : Materials.getAll()) {
            convertion(event, Item.getItemFromBlock(material.getBlock()), material.getIngot(), material.getNugget());
        }

        convertion(event, Item.getItemFromBlock(Blocks.tinBlock), Items.tinIngot, Items.tinNugget);
        convertion(event, Item.getItemFromBlock(Blocks.copperBlock), Items.copperIngot, Items.copperNugget);
        convertion(event, Item.getItemFromBlock(Blocks.bronzeBlock), Items.bronzeIngot, Items.bronzeNugget);
        convertion(event, Item.getItemFromBlock(Blocks.tiberiumBlock), Items.tiberiumIngot, Items.tiberiumNugget);
        convertion(event, Item.getItemFromBlock(Blocks.auroriumBlock), Items.auroriumIngot, Items.auroriumNugget);
        convertion(event, Item.getItemFromBlock(Blocks.prometheumBlock), Items.prometheumIngot, Items.prometheumNugget);
        convertion(event, Item.getItemFromBlock(Blocks.duraniteBlock), Items.duraniteIngot, Items.duraniteNugget);
        convertion(event, Item.getItemFromBlock(Blocks.valyriumBlock), Items.valyriumIngot, Items.valyriumNugget);
        convertion(event, Item.getItemFromBlock(Blocks.vibraniumBlock), Items.vibraniumIngot, Items.vibraniumNugget);
        convertion(event, Item.getItemFromBlock(Blocks.karmesineBlock), Items.karmesineIngot, Items.karmesineNugget);
        convertion(event, Item.getItemFromBlock(Blocks.oviumBlock), Items.oviumIngot, Items.oviumNugget);
        convertion(event, Item.getItemFromBlock(Blocks.jauxumBlock), Items.jauxumIngot, Items.jauxumNugget);
        convertion(event, Item.getItemFromBlock(Blocks.palladiumBlock), Items.palladiumIngot, Items.palladiumNugget);
        convertion(event, Item.getItemFromBlock(Blocks.uruBlock), Items.uruIngot, Items.uruNugget);
        convertion(event, Item.getItemFromBlock(Blocks.osramBlock), Items.osramIngot, Items.osramNugget);
        convertion(event, Item.getItemFromBlock(Blocks.eezoBlock), Items.eezoIngot, Items.eezoNugget);
        convertion(event, Item.getItemFromBlock(Blocks.abyssumBlock), Items.abyssumIngot, Items.abyssumNugget);
        convertion(event, Item.getItemFromBlock(Blocks.terraxBlock), Items.terraxIngot, Items.terraxNugget);
        convertion(event, Item.getItemFromBlock(Blocks.triberiumBlock), Items.triberiumIngot, Items.triberiumNugget);
        convertion(event, Item.getItemFromBlock(Blocks.fractumBlock), Items.fractumIngot, Items.fractumNugget);
        convertion(event, Item.getItemFromBlock(Blocks.violiumBlock), Items.violiumIngot, Items.violiumNugget);
        convertion(event, Item.getItemFromBlock(Blocks.proxiiBlock), Items.proxiiIngot, Items.proxiiNugget);
        convertion(event, Item.getItemFromBlock(Blocks.tritoniteBlock), Items.tritoniteIngot, Items.tritoniteNugget);
        convertion(event, Item.getItemFromBlock(Blocks.ignitzBlock), Items.ignitzIngot, Items.ignitzNugget);
        convertion(event, Item.getItemFromBlock(Blocks.imperomiteBlock), Items.imperomiteIngot, Items.imperomiteNugget);
        convertion(event, Item.getItemFromBlock(Blocks.solariumBlock), Items.solariumIngot, Items.solariumNugget);
        convertion(event, Item.getItemFromBlock(Blocks.nihiliteBlock), Items.nihiliteIngot, Items.nihiliteNugget);
        convertion(event, Item.getItemFromBlock(Blocks.adamantBlock), Items.adamantIngot, Items.adamantNugget);
        convertion(event, Item.getItemFromBlock(Blocks.dyoniteBlock), Items.dyoniteIngot, Items.dyoniteNugget);
        convertion(event, Item.getItemFromBlock(Blocks.nucleumBlock), Items.nucleumIngot, Items.nucleumNugget);
        convertion(event, Item.getItemFromBlock(Blocks.lumixBlock), Items.lumixIngot, Items.lumixNugget);
        convertion(event, Item.getItemFromBlock(Blocks.seismumBlock), Items.seismumIngot, Items.seismumNugget);
        convertion(event, Item.getItemFromBlock(Blocks.astriumBlock), Items.astriumIngot, Items.astriumNugget);
        convertion(event, Item.getItemFromBlock(Blocks.niobBlock), Items.niobIngot, Items.niobNugget);
        convertion(event, Item.getItemFromBlock(Blocks.yrdeenBlock), Items.yrdeenIngot, Items.yrdeenNugget);
        convertion(event, Item.getItemFromBlock(Blocks.ioxBlock), Items.ioxIngot, Items.ioxNugget);
        convertion(event, Item.getItemFromBlock(Blocks.blockMeteorite), Items.meteoriteIngot, Items.meteoriteNugget);
        convertion(event, Item.getItemFromBlock(Blocks.blockObsidiorite), Items.obsidioriteIngot, Items.obsidioriteNugget);
        convertion(event, Item.getItemFromBlock(Blocks.dilithiumBlock), Items.dilithiumIngot, Items.dilithiumNugget);
    }

    @SuppressWarnings("null")
    public static void convertion(Register<IRecipe> event, Item block, Item ingot, Item nugget) {
        NonNullList<Ingredient> ingotFromBlockIngredients = NonNullList.from(Ingredient.EMPTY, Ingredient.fromItem(block));
        NonNullList<Ingredient> blockFromIngotsIngredients = NonNullList.create();
        NonNullList<Ingredient> ingotFromNuggetIngredients = NonNullList.from(Ingredient.EMPTY, Ingredient.fromItem(ingot));
        NonNullList<Ingredient> nuggetFromIngotIngredients = NonNullList.create();

        for (int i = 0; i < 9; i++) {
            blockFromIngotsIngredients.add(Ingredient.fromStacks(new ItemStack(ingot)));
            nuggetFromIngotIngredients.add(Ingredient.fromStacks(new ItemStack(nugget)));
        }

        ShapelessRecipes ingotFromBlockRecipe = new ShapelessRecipes(
            "",
            new ItemStack(ingot, 9), 
            ingotFromBlockIngredients
        );
        ingotFromBlockRecipe.setRegistryName(TAIGA.MODID + ":recipe_ingot_from_block_" + block.getUnlocalizedName());
        event.getRegistry().register(ingotFromBlockRecipe);

        ShapelessRecipes blockFromIngotsRecipe = new ShapelessRecipes(
            "",
            new ItemStack(block), 
            blockFromIngotsIngredients
        );
        blockFromIngotsRecipe.setRegistryName(TAIGA.MODID + ":recipe_block_from_ingot_" + block.getUnlocalizedName());
        event.getRegistry().register(blockFromIngotsRecipe);

        ShapelessRecipes ingotFromNuggetRecipes = new ShapelessRecipes(
            "",
            new ItemStack(nugget, 9), 
            ingotFromNuggetIngredients
        );
        ingotFromNuggetRecipes.setRegistryName(TAIGA.MODID + ":recipe_ingot_from_nugget_" + block.getUnlocalizedName());
        event.getRegistry().register(ingotFromNuggetRecipes);

        ShapelessRecipes nuggetFromIngotRecipe = new ShapelessRecipes(
            "",
            new ItemStack(ingot),
            nuggetFromIngotIngredients
        );
        nuggetFromIngotRecipe.setRegistryName(TAIGA.MODID + ":recipe_nugget_from_ingot_" + block.getUnlocalizedName());
        event.getRegistry().register(nuggetFromIngotRecipe);
    }
}
