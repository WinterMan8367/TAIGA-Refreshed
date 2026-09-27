package com.sosnitzka.taiga;


import com.sosnitzka.taiga.generic.BasicTinkerFluid;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.smeltery.block.BlockMolten;

import java.lang.reflect.Field;

import static com.sosnitzka.taiga.util.Utils.registerFluid;

public class Fluids {
    public static BasicTinkerFluid meteoriteFluid = new BasicTinkerFluid("meteorite_fluid", 0xFF374f3d, 950, 10, 7000);
    public static BasicTinkerFluid obsidioriteFluid = new BasicTinkerFluid("obsidiorite_fluid", 0xFF224853, 1050, 10,
            7000);
    public static BasicTinkerFluid magmaFluid = new BasicTinkerFluid("magma_fluid", 0xFFffc000, 2000, 10, 5000);
    public static BasicTinkerFluid nitroniteFluid = new BasicTinkerFluid("nitronite_fluid", 0xFFCCFF00, 3100, 10, 5000);

    /**
     * Registers all materials' fluids <br>
     * Detailed summary: <br>
     * Gets the fluids declared in the class (fields and reflection) and iterates through them: <br>
     * Checks that the field is static, registers the field (fluids), and registers the models on the client
     */
    static void register() {
        Field[] declaredFields = Fluids.class.getDeclaredFields(); // Gets the blocks and ores declared above
        for (Field field : declaredFields) { // Iterates through the fields declared above
            if (java.lang.reflect.Modifier.isStatic(field.getModifiers())) { // Checks that the fields are static
                Class<?> targetType = field.getType();
                try {
                    BasicTinkerFluid fluid = (BasicTinkerFluid) field.get(targetType); // Gets the field as a
                    // BasicTinkerFluid
                    registerFluid(fluid); // Registers the fluid into the game along wit its bucket

                    BlockMolten block = new BlockMolten(fluid);
                    // Sets names
                    block.setUnlocalizedName("molten_" + fluid.getName());
                    block.setRegistryName(TAIGA.MODID, "molten_" + fluid.getName());
                    // Registers the fluid in its block form and its corresponding item (block/fluid as item in
                    // inventory)
                    ForgeRegistries.BLOCKS.register(block);
                    ForgeRegistries.ITEMS.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
                    TAIGA.proxy.registerFluidModels(fluid);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Registers special smeltery recipes (not alloying)
     */
    static void registerfromItem() {
        TinkerRegistry.registerMelting(Blocks.blockMeteoriteCobble, meteoriteFluid, 288);
        TinkerRegistry.registerMelting(Blocks.blockObsidioriteCobble, obsidioriteFluid, 288);
        TinkerRegistry.registerMelting(net.minecraft.init.Blocks.MAGMA, magmaFluid, 288);
        TinkerRegistry.registerMelting(Materials.dilithium.getCrystal(), Materials.dilithium.getFluid(), 72);
        TinkerRegistry.registerMelting(Materials.tiberium.getCrystal(), Materials.tiberium.getFluid(), 72);

        TinkerRegistry.registerSmelteryFuel(new FluidStack(magmaFluid, 50), 100);
        TinkerRegistry.registerSmelteryFuel(new FluidStack(nitroniteFluid, 100), 500);
        TinkerRegistry.registerSmelteryFuel(new FluidStack(Materials.dilithium.getFluid(), 50), 100);
    }

}
