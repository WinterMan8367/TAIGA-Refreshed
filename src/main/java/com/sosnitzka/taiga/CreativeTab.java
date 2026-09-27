package com.sosnitzka.taiga;


import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


public class CreativeTab {

    public static final CreativeTabs tabTaigaBlock = new CreativeTabs("taiga_block") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(Item.getItemFromBlock(Materials.adamant.getBlock()));
        }
    };

    public static final CreativeTabs tabTaigaItem = new CreativeTabs("taiga_item") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(Materials.solarium.getIngot());
        }
    };
}
