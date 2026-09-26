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

import static com.sosnitzka.taiga.util.Utils.*;

public class Items {
    public static Item tinIngot = new BasicItem("tin", PREFIX_INGOT);
    public static Item tinDust = new BasicItem("tin", PREFIX_DUST);
    public static Item tinNugget = new BasicItem("tin", PREFIX_NUGGET);

    public static Item copperIngot = new BasicItem("copper", PREFIX_INGOT);
    public static Item copperDust = new BasicItem("copper", PREFIX_DUST);
    public static Item copperNugget = new BasicItem("copper", PREFIX_NUGGET);

    public static Item bronzeIngot = new BasicItem("bronze", PREFIX_INGOT);
    public static Item bronzeDust = new BasicItem("bronze", PREFIX_DUST);
    public static Item bronzeNugget = new BasicItem("bronze", PREFIX_NUGGET);

    public static Item ironNugget = new BasicItem("iron", PREFIX_NUGGET);

    public static Item tiberiumIngot = new BasicItem("tiberium", PREFIX_INGOT);
    public static Item tiberiumDust = new BasicItem("tiberium", PREFIX_DUST);
    public static Item tiberiumNugget = new BasicItem("tiberium", PREFIX_NUGGET);

    public static Item auroriumIngot = new BasicItem("aurorium", PREFIX_INGOT);
    public static Item auroriumDust = new BasicItem("aurorium", PREFIX_DUST);
    public static Item auroriumNugget = new BasicItem("aurorium", PREFIX_NUGGET);

    public static Item prometheumIngot = new BasicItem("prometheum", PREFIX_INGOT);
    public static Item prometheumDust = new BasicItem("prometheum", PREFIX_DUST);
    public static Item prometheumNugget = new BasicItem("prometheum", PREFIX_NUGGET);

    public static Item duraniteIngot = new BasicItem("duranite", PREFIX_INGOT);
    public static Item duraniteDust = new BasicItem("duranite", PREFIX_DUST);
    public static Item duraniteNugget = new BasicItem("duranite", PREFIX_NUGGET);

    public static Item valyriumIngot = new BasicItem("valyrium", PREFIX_INGOT);
    public static Item valyriumDust = new BasicItem("valyrium", PREFIX_DUST);
    public static Item valyriumNugget = new BasicItem("valyrium", PREFIX_NUGGET);

    public static Item vibraniumIngot = new BasicItem("vibranium", PREFIX_INGOT);
    public static Item vibraniumDust = new BasicItem("vibranium", PREFIX_DUST);
    public static Item vibraniumNugget = new BasicItem("vibranium", PREFIX_NUGGET);

    public static Item karmesineIngot = new BasicItem("karmesine", PREFIX_INGOT);
    public static Item karmesineDust = new BasicItem("karmesine", PREFIX_DUST);
    public static Item karmesineNugget = new BasicItem("karmesine", PREFIX_NUGGET);

    public static Item oviumIngot = new BasicItem("ovium", PREFIX_INGOT);
    public static Item oviumDust = new BasicItem("ovium", PREFIX_DUST);
    public static Item oviumNugget = new BasicItem("ovium", PREFIX_NUGGET);

    public static Item jauxumIngot = new BasicItem("jauxum", PREFIX_INGOT);
    public static Item jauxumDust = new BasicItem("jauxum", PREFIX_DUST);
    public static Item jauxumNugget = new BasicItem("jauxum", PREFIX_NUGGET);

    public static Item terraxIngot = new BasicItem("terrax", PREFIX_INGOT);
    public static Item terraxDust = new BasicItem("terrax", PREFIX_DUST);
    public static Item terraxNugget = new BasicItem("terrax", PREFIX_NUGGET);

    public static Item palladiumIngot = new BasicItem("palladium", PREFIX_INGOT);
    public static Item palladiumDust = new BasicItem("palladium", PREFIX_DUST);
    public static Item palladiumNugget = new BasicItem("palladium", PREFIX_NUGGET);

    public static Item uruIngot = new BasicItem("uru", PREFIX_INGOT);
    public static Item uruDust = new BasicItem("uru", PREFIX_DUST);
    public static Item uruNugget = new BasicItem("uru", PREFIX_NUGGET);

    public static Item osramIngot = new BasicItem("osram", PREFIX_INGOT);
    public static Item osramDust = new BasicItem("osram", PREFIX_DUST);
    public static Item osramNugget = new BasicItem("osram", PREFIX_NUGGET);

    public static Item abyssumIngot = new BasicItem("abyssum", PREFIX_INGOT);
    public static Item abyssumDust = new BasicItem("abyssum", PREFIX_DUST);
    public static Item abyssumNugget = new BasicItem("abyssum", PREFIX_NUGGET);

    public static Item eezoIngot = new BasicItem("eezo", PREFIX_INGOT);
    public static Item eezoDust = new BasicItem("eezo", PREFIX_DUST);
    public static Item eezoNugget = new BasicItem("eezo", PREFIX_NUGGET);

    public static Item triberiumIngot = new BasicItem("triberium", PREFIX_INGOT);
    public static Item triberiumDust = new BasicItem("triberium", PREFIX_DUST);
    public static Item triberiumNugget = new BasicItem("triberium", PREFIX_NUGGET);

    public static Item fractumIngot = new BasicItem("fractum", PREFIX_INGOT);
    public static Item fractumDust = new BasicItem("fractum", PREFIX_DUST);
    public static Item fractumNugget = new BasicItem("fractum", PREFIX_NUGGET);

    public static Item violiumIngot = new BasicItem("violium", PREFIX_INGOT);
    public static Item violiumDust = new BasicItem("violium", PREFIX_DUST);
    public static Item violiumNugget = new BasicItem("violium", PREFIX_NUGGET);

    public static Item proxiiIngot = new BasicItem("proxii", PREFIX_INGOT);
    public static Item proxiiDust = new BasicItem("proxii", PREFIX_DUST);
    public static Item proxiiNugget = new BasicItem("proxii", PREFIX_NUGGET);

    public static Item tritoniteIngot = new BasicItem("tritonite", PREFIX_INGOT);
    public static Item tritoniteDust = new BasicItem("tritonite", PREFIX_DUST);
    public static Item tritoniteNugget = new BasicItem("tritonite", PREFIX_NUGGET);

    public static Item ignitzIngot = new BasicItem("ignitz", PREFIX_INGOT);
    public static Item ignitzDust = new BasicItem("ignitz", PREFIX_DUST);
    public static Item ignitzNugget = new BasicItem("ignitz", PREFIX_NUGGET);

    public static Item imperomiteIngot = new BasicItem("imperomite", PREFIX_INGOT);
    public static Item imperomiteDust = new BasicItem("imperomite", PREFIX_DUST);
    public static Item imperomiteNugget = new BasicItem("imperomite", PREFIX_NUGGET);

    public static Item solariumIngot = new BasicItem("solarium", PREFIX_INGOT);
    public static Item solariumDust = new BasicItem("solarium", PREFIX_DUST);
    public static Item solariumNugget = new BasicItem("solarium", PREFIX_NUGGET);

    public static Item nihiliteIngot = new BasicItem("nihilite", PREFIX_INGOT);
    public static Item nihiliteDust = new BasicItem("nihilite", PREFIX_DUST);
    public static Item nihiliteNugget = new BasicItem("nihilite", PREFIX_NUGGET);

    public static Item adamantIngot = new BasicItem("adamant", PREFIX_INGOT);
    public static Item adamantDust = new BasicItem("adamant", PREFIX_DUST);
    public static Item adamantNugget = new BasicItem("adamant", PREFIX_NUGGET);

    public static Item dyoniteIngot = new BasicItem("dyonite", PREFIX_INGOT);
    public static Item dyoniteDust = new BasicItem("dyonite", PREFIX_DUST);
    public static Item dyoniteNugget = new BasicItem("dyonite", PREFIX_NUGGET);

    public static Item nucleumIngot = new BasicItem("nucleum", PREFIX_INGOT);
    public static Item nucleumDust = new BasicItem("nucleum", PREFIX_DUST);
    public static Item nucleumNugget = new BasicItem("nucleum", PREFIX_NUGGET);

    public static Item lumixIngot = new BasicItem("lumix", PREFIX_INGOT);
    public static Item lumixDust = new BasicItem("lumix", PREFIX_DUST);
    public static Item lumixNugget = new BasicItem("lumix", PREFIX_NUGGET);

    public static Item seismumIngot = new BasicItem("seismum", PREFIX_INGOT);
    public static Item seismumDust = new BasicItem("seismum", PREFIX_DUST);
    public static Item seismumNugget = new BasicItem("seismum", PREFIX_NUGGET);

    public static Item astriumIngot = new BasicItem("astrium", PREFIX_INGOT);
    public static Item astriumDust = new BasicItem("astrium", PREFIX_DUST);
    public static Item astriumNugget = new BasicItem("astrium", PREFIX_NUGGET);

    public static Item niobIngot = new BasicItem("niob", PREFIX_INGOT);
    public static Item niobDust = new BasicItem("niob", PREFIX_DUST);
    public static Item niobNugget = new BasicItem("niob", PREFIX_NUGGET);

    public static Item yrdeenIngot = new BasicItem("yrdeen", PREFIX_INGOT);
    public static Item yrdeenDust = new BasicItem("yrdeen", PREFIX_DUST);
    public static Item yrdeenNugget = new BasicItem("yrdeen", PREFIX_NUGGET);

    public static Item ioxIngot = new BasicItem("iox", PREFIX_INGOT);
    public static Item ioxDust = new BasicItem("iox", PREFIX_DUST);
    public static Item ioxNugget = new BasicItem("iox", PREFIX_NUGGET);

    public static Item meteoriteIngot = new BasicItem("meteorite", PREFIX_INGOT);
    public static Item meteoriteDust = new BasicItem("meteorite", PREFIX_DUST);
    public static Item meteoriteNugget = new BasicItem("meteorite", PREFIX_NUGGET);

    public static Item basaltIngot = new BasicItem("basalt", PREFIX_INGOT);
    public static Item basaltDust = new BasicItem("basalt", PREFIX_DUST);
    public static Item basaltNugget = new BasicItem("basalt", PREFIX_NUGGET);

    public static Item obsidioriteIngot = new BasicItem("obsidiorite", PREFIX_INGOT);
    public static Item obsidioriteDust = new BasicItem("obsidiorite", PREFIX_DUST);
    public static Item obsidioriteNugget = new BasicItem("obsidiorite", PREFIX_NUGGET);

    public static Item dilithiumIngot = new BasicItem("dilithium", PREFIX_INGOT);
    public static Item dilithiumDust = new BasicItem("dilithium", PREFIX_DUST);
    public static Item dilithiumCrystal = new BasicItem("dilithium", PREFIX_CRYSTAL);
    public static Item tiberiumCrystal = new BasicItem("tiberium", PREFIX_CRYSTAL);
    public static Item dilithiumNugget = new BasicItem("dilithium", PREFIX_NUGGET);

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
                    if (item.equals(ironNugget) && OreDictionary.doesOreNameExist("nuggetIron")) {
                        System.out.println("TAIGA: Skipped registration of nuggetIron which already exists.");
                        continue;
                    }
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
