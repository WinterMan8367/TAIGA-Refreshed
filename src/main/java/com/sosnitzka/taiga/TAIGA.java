package com.sosnitzka.taiga;

import com.google.common.collect.Lists;
import com.sosnitzka.taiga.dto.MaterialDto;
import com.sosnitzka.taiga.net.NetManager;
import com.sosnitzka.taiga.proxy.CommonProxy;
import com.sosnitzka.taiga.recipes.SmeltingRegistry;
import com.sosnitzka.taiga.util.UtilityMaterial;
import com.sosnitzka.taiga.world.WorldGen;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.Logger;
import slimeknights.tconstruct.library.MaterialIntegration;
import slimeknights.tconstruct.library.materials.BowMaterialStats;

import java.util.List;

import static com.sosnitzka.taiga.Fluids.*;
import static com.sosnitzka.taiga.MaterialTraits.*;
import static com.sosnitzka.taiga.util.Utils.integrateMaterial;
import static com.sosnitzka.taiga.util.Utils.integrateOre;
import static slimeknights.tconstruct.library.utils.HarvestLevels.*;

@Mod(modid = TAIGA.MODID, version = TAIGA.VERSION, guiFactory = TAIGA.GUIFACTORY, dependencies =
        "required-after:tconstruct@[1.10.2-2.5.0,);" + "required-after:mantle@[1.10.2-1.0.0,)")
public class TAIGA {

    public static final String MODID = "taiga";
    public static final String VERSION = "@VERSION@";
    public static final String GUIFACTORY = "com.sosnitzka.taiga.TAIGAGuiFactory";
    public static Logger logger;

    @SidedProxy(clientSide = "com.sosnitzka.taiga.proxy.ClientProxy", serverSide = "com.sosnitzka.taiga.proxy" +
            ".CommonProxy")
    public static CommonProxy proxy;

    public static List<MaterialIntegration> integrateList = Lists.newArrayList(); // List of materials needed to be integrated

    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        logger = e.getModLog();

        MaterialEventHandlers.manualRegisterFluids();
        Fluids.register();
        Blocks.register(false);
        Blocks.registerItems();
        Items.register();

        proxy.initConfig();

        registerTinkerMaterials();
    }

    NetManager a;

    @EventHandler
    public void init(FMLInitializationEvent e) {
        a = NetManager.INSTANCE;

        proxy.registerModels(); // Registers models on the client side
        proxy.regsiterKeyBindings();

        Fluids.registerfromItem(); // Registers some special smeltery recipes (not alloying)
        GameRegistry.registerWorldGenerator(WorldGen.getInstance(), 100); // Generates ores
        // GameRegistry.registerFuelHandler(new FuelHandler());  Registeres fuels' burn times

        // Adds new harvest levels' names
        proxy.registerHarvestLevels();

        Blocks.register(true);

        Alloys.register(); // Registers alloying recipes

        SmeltingRegistry.register(); // Registers smelting recipess

        for (MaterialIntegration m : integrateList) {
            m.integrate();
        }
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.registerBookPages();
    }

    @EventHandler
    public void serverLoad(FMLServerStartingEvent event) {
        proxy.registerServerCommands(event);
    }


    /**
     * Registers materials and associated fluids and stats into tconstruct
     */
    @SuppressWarnings("null")
    private void registerTinkerMaterials() {
        for (UtilityMaterial material : Materials.getAll()) {
            if (!material.hasFluid()) {
                continue;
            }

            if (!material.hasMaterialStats()) {
                integrateOre(StringUtils.capitalize(material.getName()), material.getFluid());
                continue;
            }

            MaterialDto materialStats = material.getMaterialStats();

            integrateMaterial(
                StringUtils.capitalize(material.getName()),
                material.getTinkerMaterial(),
                material.getFluid(),
                materialStats.getHeadStats().durability,
                materialStats.getHeadStats().miningspeed, 
                materialStats.getHeadStats().attack,
                materialStats.getHandleStats().modifier,
                materialStats.getHandleStats().durability,
                materialStats.getExtraDurability(),
                materialStats.getHeadStats().harvestLevel,
                materialStats.getBowStats()
            );
        }

        BowMaterialStats shitty = new BowMaterialStats(0.2f, 0.4f, -1f);

        integrateMaterial("Meteorite", meteorite, meteoriteFluid, 1500, 1.5f, 1.5f, .5f, 0, 0, OBSIDIAN, shitty);
        integrateMaterial("Obsidiorite", obsidiorite, obsidioriteFluid, 1500, .5f, .5f, 1, -100, 100, COBALT, shitty);
    }
}