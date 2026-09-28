package com.sosnitzka.taiga;


import com.google.common.base.Joiner;
import com.sosnitzka.taiga.generic.BasicItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.oredict.OreDictionary;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.Arrays;

public class Items {
    /**
     * Registers all materials' ingots and nuggets <br>
     * Detailed summary: <br>
     * Gets the ingots declared in the class (fields and reflection) and iterates through them: <br>
     * Checks that the field is static, registers the field (item), and adds an oreDict entry if needed
     */
    @SubscribeEvent
    public static void register() {
        Field[] declaredFields = Items.class.getDeclaredFields(); // Gets the fields (ingots) declared above
        for (Field field : declaredFields) { // Iterates through the fields declared above
            if (java.lang.reflect.Modifier.isStatic(field.getModifiers())) { // Checks that the fields are static
                Class<?> targetType = field.getType();
                try {
                    Item item = (Item) field.get(targetType); // Gets the field as a BasicItem which is then casted
                    // to an Item
                    // if (item.equals(ironNugget) && OreDictionary.doesOreNameExist("nuggetIron")) {
                    //     System.out.println("TAIGA: Skipped registration of nuggetIron which already exists.");
                    //     continue;
                    // }
                    item.setCreativeTab(CreativeTab.tabTaigaItem);
                    ForgeRegistries.ITEMS.register(item); // Registers the item into the game
                    if (item instanceof BasicItem) {  // Checks that the item is a BasicItem
                        if (((BasicItem) item).isOreDict()) { // Checks if this item should be registered into the
                            // oreDict and registers it
                            String oreDictName;
                            String[] nameParts = item.getUnlocalizedName().replace("item.", "").split("_");

                            if (nameParts.length > 2) {
                                oreDictName = Joiner.on("_").join(Arrays.copyOfRange(nameParts, 0, nameParts.length -
                                        1));
                            } else {
                                oreDictName = nameParts[0];
                            }

                            OreDictionary.registerOre(((BasicItem) item).getOreDictPrefix() + StringUtils.capitalize
                                    (oreDictName), item); // Registers into oreDict
                        }
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
