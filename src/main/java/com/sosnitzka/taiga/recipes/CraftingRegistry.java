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

        convertion(event, Item.getItemFromBlock(Blocks.blockMeteorite), Items.meteoriteIngot, Items.meteoriteNugget);
        convertion(event, Item.getItemFromBlock(Blocks.blockObsidiorite), Items.obsidioriteIngot, Items.obsidioriteNugget);
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
