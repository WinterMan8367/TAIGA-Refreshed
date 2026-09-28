package com.sosnitzka.taiga;

import com.sosnitzka.taiga.dto.BlockDto;
import com.sosnitzka.taiga.dto.FluidDto;
import com.sosnitzka.taiga.dto.MaterialDto;
import com.sosnitzka.taiga.dto.OreDto;
import com.sosnitzka.taiga.dto.OreDto.InternalItem;
import com.sosnitzka.taiga.generic.BasicBlock;
import com.sosnitzka.taiga.generic.BlockOre;
import com.sosnitzka.taiga.util.UtilityMaterial;

import net.minecraft.block.material.Material;
import net.minecraft.util.text.TextFormatting;
import slimeknights.tconstruct.library.materials.BowMaterialStats;
import slimeknights.tconstruct.library.materials.HandleMaterialStats;
import slimeknights.tconstruct.library.materials.HeadMaterialStats;
import slimeknights.tconstruct.library.materials.MaterialTypes;

import static com.sosnitzka.taiga.MaterialTraits.*;
import static slimeknights.tconstruct.library.utils.HarvestLevels.*;
import static slimeknights.tconstruct.tools.TinkerTraits.crumbling;
import static slimeknights.tconstruct.tools.TinkerTraits.alien;
import static slimeknights.tconstruct.TConstruct.random;

import java.util.LinkedHashSet;

public class Materials {
    private static LinkedHashSet<UtilityMaterial> materials = new LinkedHashSet<>();

    public static void add(UtilityMaterial material) {
        if (material != null) {
            materials.add(material);
        }
    }
    
    public static UtilityMaterial get(String name) {
        for (UtilityMaterial material : materials) {
            if (material.getName().equals(name)) {
                return material;
            }
        }

        return null;
    }

    public static LinkedHashSet<UtilityMaterial> getAll() {
        return materials;
    }

    public static LinkedHashSet<BlockOre> getOres() {
        LinkedHashSet<BlockOre> ores = new LinkedHashSet<>();

        for (UtilityMaterial material : materials) {
            if (material.hasOre()) {
                ores.add(material.getOre());
            }
        }

        return ores;
    }

    public static LinkedHashSet<BasicBlock> getBlocks() {
        LinkedHashSet<BasicBlock> blocks = new LinkedHashSet<>();

        for (UtilityMaterial material : materials) {
            blocks.add(material.getBlock());
        }

        return blocks;
    }

    //////////////////// Metals ////////////////////

    public static UtilityMaterial tin = new UtilityMaterial("tin", 0x0,
        new BlockDto(Material.ROCK, 10.0f, 10f, STONE))
        .ore(new OreDto(Material.ROCK, 10.0f, 10f, STONE))
        .forciblyRemoveMaterial();
    
    public static UtilityMaterial copper = new UtilityMaterial("copper", 0x0,
        new BlockDto(Material.ROCK, 10.0f, 10f, STONE))
        .ore(new OreDto(Material.ROCK, 10.0f, 10f, STONE))
        .forciblyRemoveMaterial();

    public static UtilityMaterial tiberium = new UtilityMaterial("tiberium", TextFormatting.GREEN,
        new BlockDto(Material.GLASS, 10.0f, 15f, STONE, 1f))
        .crystal()
        .ore(new OreDto(Material.ROCK, 10.0f, 2.0f, STONE, 1.0F)
            .explodableChance(0.5F, random.nextFloat() * 2F + 1.5F)
            .explosionChance(0.1F, 1.5F)
            .dropItemAndXp(InternalItem.CRYSTAL, 3, 10))
        .fluid(new FluidDto(0xFFd4ff00, 550, 10, 6000))
        .material(MaterialDto.builder()
            .headStats(new HeadMaterialStats(80, 3.3F, 4F, DIAMOND))
            .handleStats(new HandleMaterialStats(0.7F, -25))
            .extraDurability(50)
            .isCraftable(true)
            .isCastable(false).build())
        .traits(MaterialTraits.instable);

    public static UtilityMaterial aurorium = new UtilityMaterial("aurorium", TextFormatting.RED,
        new BlockDto(Material.ROCK, 15.0f, 15f, COBALT))
        .ore(new OreDto(Material.ROCK, 15.0f, 12f, COBALT, 0.2f))
        .fluid(new FluidDto(0xFFefae94, 750, 10, 10000))
        .material(MaterialDto.builder()
            .headStats(new HeadMaterialStats(750, 3.6F, 3.78F, COBALT))
            .handleStats(new HandleMaterialStats(0.77F, 25))
            .extraDurability(130)
            .bowStats(new BowMaterialStats(0.45f, 1f, 1))
            .isCraftable(false)
            .isCastable(true).build())
        .traits(MaterialTraits.arcane);

    public static UtilityMaterial prometheum = new UtilityMaterial("prometheum", TextFormatting.DARK_PURPLE,
        new BlockDto(Material.ROCK, 20.0f, 15f, DURANITE, 0.5f))
        .ore(new OreDto(Material.ROCK, 20.0f, 12f, DURANITE, 0.4f))
        .fluid(new FluidDto(0xFF372c49, 850, 10, 10000))
        .material(MaterialDto.builder()
            .headStats(new HeadMaterialStats(844, 4.75F, 6.6F, DURANITE))
            .handleStats(new HandleMaterialStats(1.2F, 25))
            .extraDurability(50)
            .bowStats(new BowMaterialStats(0.2f, 0.6f, 3))
            .isCraftable(false)
            .isCastable(true).build())
        .traits(MaterialTypes.HANDLE, MaterialTraits.blind)
        .traits(MaterialTraits.catcher);

    public static UtilityMaterial duranite = new UtilityMaterial("duranite", TextFormatting.YELLOW,
        new BlockDto(Material.ROCK, 20.0f, 800f, DURANITE))
        .ore(new OreDto(Material.ROCK, 25.0f, 1000f, DURANITE))
        .fluid(new FluidDto(0xFFacddeb, 1400, 10, 10000))
        .material(MaterialDto.builder()
            .headStats(new HeadMaterialStats(1550, 3.2F, 3.2F, DURANITE))
            .handleStats(new HandleMaterialStats(1.16F, 100))
            .extraDurability(100)
            .bowStats(new BowMaterialStats(0.3f, 1.4f, 2))
            .isCraftable(false)
            .isCastable(true).build())
        .traits(MaterialTraits.analysing);

    public static UtilityMaterial valyrium = new UtilityMaterial("valyrium", TextFormatting.DARK_GRAY,
        new BlockDto(Material.ROCK, 20.0f, 1500f, VALYRIUM))
        .ore(new OreDto(Material.ROCK, 35.0f, 2000f, VALYRIUM))
        .fluid(new FluidDto(0xFFe85c31, 1915, 10, 10000))
        .material(MaterialDto.builder()
            .headStats(new HeadMaterialStats(1111, 5.37F, 4.8F, VALYRIUM))
            .handleStats(new HandleMaterialStats(1.3F, 100))
            .extraDurability(100)
            .bowStats(new BowMaterialStats(1.1f, 1.2f, 4))
            .isCraftable(false)
            .isCastable(true).build())
        .traits(MaterialTraits.congenial);

    public static UtilityMaterial vibranium = new UtilityMaterial("vibranium", TextFormatting.GRAY,
        new BlockDto(Material.ROCK, 20.0f, 3000f, VIBRANIUM))
        .ore(new OreDto(Material.ROCK, 40.0f, 3000f, VIBRANIUM))
        .fluid(new FluidDto(0xFFbad2d9, 3050, 10, 10000))
        .material(MaterialDto.builder()
            .headStats(new HeadMaterialStats(1235, 7.62F, 8.1F, VIBRANIUM))
            .handleStats(new HandleMaterialStats(1.3F, 100))
            .extraDurability(100)
            .bowStats(new BowMaterialStats(1.1f, 1.8f, 4))
            .isCraftable(false)
            .isCastable(true).build())
        .traits(MaterialTypes.HANDLE, MaterialTraits.resonance)
        .traits(MaterialTypes.HEAD, MaterialTraits.heroic);

    public static UtilityMaterial karmesine = new UtilityMaterial("karmesine", TextFormatting.RED,
        new BlockDto(Material.ROCK, 10.0f, 12f, COBALT))
        .ore(new OreDto(Material.ROCK, 10.0f, 10f, COBALT))
        .fluid(new FluidDto(0xFFeb484a, 750, 10, 9000));

    public static UtilityMaterial ovium = new UtilityMaterial("ovium", TextFormatting.BLUE,
        new BlockDto(Material.ROCK, 10.0f, 12f, COBALT))
        .ore(new OreDto(Material.ROCK, 10.0f, 10f, COBALT))
        .fluid(new FluidDto(0xFF7d77c3, 750, 10, 9000));

    public static UtilityMaterial jauxum = new UtilityMaterial("jauxum", TextFormatting.YELLOW,
        new BlockDto(Material.ROCK, 10.0f, 12f, COBALT))
        .ore(new OreDto(Material.ROCK, 10.0f, 10f, COBALT))
        .fluid(new FluidDto(0xFF68c663, 750, 10, 9000));

    public static UtilityMaterial palladium = new UtilityMaterial("palladium", TextFormatting.GOLD,
        new BlockDto(Material.ROCK, 25.0f, 150f, DURANITE, 0.5f))
        .ore(new OreDto(Material.ROCK, 25.0f, 150f, DURANITE, 0.4f))
        .fluid(new FluidDto(0xFFee8736, 690, 10, 10000))
        .material(MaterialDto.builder()
            .headStats(new HeadMaterialStats(797, 4.35F, 6.8F, DURANITE))
            .handleStats(new HandleMaterialStats(1.3F, 130))
            .extraDurability(-50)
            .bowStats(new BowMaterialStats(0.5f, 0.2f, 3))
            .isCraftable(false)
            .isCastable(true).build())
        .traits(MaterialTraits.dark, MaterialTraits.cursed);

    public static UtilityMaterial uru = new UtilityMaterial("uru", TextFormatting.DARK_RED,
        new BlockDto(Material.ROCK, 30.0f, 500f, VALYRIUM))
        .ore(new OreDto(Material.ROCK, 35.0f, 500f, VALYRIUM))
        .fluid(new FluidDto(0xFFbfb9f0, 1200, 10, 10000))
        .material(MaterialDto.builder()
            .headStats(new HeadMaterialStats(877, 2.0F, 7.2F, VALYRIUM))
            .handleStats(new HandleMaterialStats(1.5F, -50))
            .extraDurability(175)
            .bowStats(new BowMaterialStats(1.3f, 0.8f, 6))
            .isCraftable(false)
            .isCastable(true).build())
        .traits(MaterialTraits.diffuse);

    public static UtilityMaterial osram = new UtilityMaterial("osram", TextFormatting.GOLD,
        new BlockDto(Material.ROCK, 15.0f, 12f, COBALT))
        .ore(new OreDto(Material.ROCK, 15.0f, 35.0f, COBALT))
        .fluid(new FluidDto(0xFFffbc90, 800, 10, 4000));

    public static UtilityMaterial eezo = new UtilityMaterial("eezo", TextFormatting.GOLD,
        new BlockDto(Material.ROCK, 20.0f, 1000f, COBALT))
        .ore(new OreDto(Material.ROCK, 50.0f, 50000.0f, COBALT))
        .fluid(new FluidDto(0xFF58798a, 450, 0, 1000))
        .material(MaterialDto.builder()
            .headStats(new HeadMaterialStats(50, 23.0F, 3.5F, COBALT))
            .handleStats(new HandleMaterialStats(0.1F, 10))
            .extraDurability(10)
            .isCraftable(true)
            .isCastable(false).build())
        .traits(MaterialTraits.dissolving, MaterialTraits.superheavy);

    public static UtilityMaterial abyssum = new UtilityMaterial("abyssum", TextFormatting.GOLD,
        new BlockDto(Material.ROCK, 15.0f, 35.0f, COBALT))
        .ore(new OreDto(Material.ROCK, 15.0f, 35.0f, COBALT))
        .fluid(new FluidDto(0xFF21bcc2, 700, 10, 10000));

    public static UtilityMaterial dilithium = new UtilityMaterial("dilithium", TextFormatting.BLUE,
        new BlockDto(Material.GLASS, 18f, 18f, DIAMOND, 0.73f))
        .crystal()
        .ore(new OreDto(Material.GLASS, 18f, 18f, DIAMOND, 0.73f)
            .explodableChance(0.5F, random.nextFloat() * 4F + 1.5F)
            .dropItemAndXp(InternalItem.CRYSTAL, 3, 10))
        .fluid(new FluidDto(0xFF79aea6, 1500, 10, 5000));

    //////////////////// Alloys ////////////////////

    public static UtilityMaterial bronze = new UtilityMaterial("bronze", 0x0,
        new BlockDto(Material.ROCK, 10.0f, 10f, STONE))
        .forciblyRemoveMaterial();

    public static UtilityMaterial terrax = new UtilityMaterial("terrax", TextFormatting.DARK_GRAY,
        new BlockDto(Material.ROCK, 10.0f, 15f, COBALT))
        .fluid(new FluidDto(0xFFa5978e, 850, 10, 9000))
        .material(MaterialDto.builder()
            .headStats(new HeadMaterialStats(444, 4.77F, 2.9F, COBALT))
            .handleStats(new HandleMaterialStats(0.8F, 100))
            .extraDurability(50)
            .isCraftable(true)
            .isCastable(true).build())
        .traits(MaterialTraits.slaughtering);

    public static UtilityMaterial triberium = new UtilityMaterial("triberium", TextFormatting.GREEN,
        new BlockDto(Material.ROCK, 15.0f, 15f, OBSIDIAN, 1f))
        .fluid(new FluidDto(0xFF66f136, 550, 10, 9000))
        .material(MaterialDto.builder()
            .headStats(new HeadMaterialStats(223, 6.2F, 8.35F, DIAMOND))
            .handleStats(new HandleMaterialStats(0.63F, 50))
            .extraDurability(50)
            .isCraftable(true)
            .isCastable(true).build())
        .traits(MaterialTraits.fragile);

    public static UtilityMaterial fractum = new UtilityMaterial("fractum", TextFormatting.DARK_RED,
        new BlockDto(Material.ROCK, 15.0f, 25f, COBALT))
        .fluid(new FluidDto(0xFFd2c583, 750, 10, 10000))
        .material(MaterialDto.builder()
            .headStats(new HeadMaterialStats(538, 5.71f, 6.93f, DIAMOND))
            .handleStats(new HandleMaterialStats(0.88f, 58))
            .extraDurability(117)
            .isCraftable(false)
            .isCastable(true).build())
        .traits(MaterialTraits.fracture);

    public static UtilityMaterial violium = new UtilityMaterial("violium", TextFormatting.DARK_PURPLE,
        new BlockDto(Material.ROCK, 15.0f, 25f, COBALT))
        .fluid(new FluidDto(0xFFbfb0e2, 850, 10, 10000))
        .material(MaterialDto.builder()
            .headStats(new HeadMaterialStats(925, 3.8f, 3.75f, COBALT))
            .handleStats(new HandleMaterialStats(0.90f, 175))
            .extraDurability(50)
            .bowStats(new BowMaterialStats(0.45f, 0.95f, 1))
            .isCraftable(false)
            .isCastable(true).build())
        .traits(MaterialTraits.arcane);

    public static UtilityMaterial proxii = new UtilityMaterial("proxii", TextFormatting.LIGHT_PURPLE,
        new BlockDto(Material.ROCK, 15.0f, 25f, DURANITE))
        .fluid(new FluidDto(0xFFcefde1, 750, 10, 10000))
        .material(MaterialDto.builder()
            .headStats(new HeadMaterialStats(625, 6.8f, 4.21f, DURANITE))
            .handleStats(new HandleMaterialStats(1.25f, 80))
            .extraDurability(25)
            .bowStats(new BowMaterialStats(0.35f, 0.5f, 3))
            .isCraftable(false)
            .isCastable(true).build())
        .traits(MaterialTraits.curvature);

    public static UtilityMaterial tritonite = new UtilityMaterial("tritonite", TextFormatting.GOLD,
        new BlockDto(Material.ROCK, 15.0f, 25f, COBALT))
        .fluid(new FluidDto(0xFF8edeff, 550, 10, 10000))
        .material(MaterialDto.builder()
            .headStats(new HeadMaterialStats(780, 8f, 3.3f, COBALT))
            .handleStats(new HandleMaterialStats(1.45f, -25))
            .extraDurability(150)
            .isCraftable(false)
            .isCastable(true).build())
        .traits(MaterialTraits.whirl);

    public static UtilityMaterial ignitz = new UtilityMaterial("ignitz", TextFormatting.RED,
        new BlockDto(Material.ROCK, 20.0f, 20f, COBALT))
        .fluid(new FluidDto(0xFFff284b, 950, 10, 6000))
        .material(MaterialDto.builder()
            .headStats(new HeadMaterialStats(350, 2f, 6.66f, COBALT))
            .handleStats(new HandleMaterialStats(0.85f, 150))
            .extraDurability(250)
            .bowStats(new BowMaterialStats(0.8f, 0.8f, 3))
            .isCraftable(false)
            .isCastable(true).build())
        .traits(MaterialTraits.melting)
        .traits(MaterialTypes.HANDLE, garishly);

    public static UtilityMaterial imperomite = new UtilityMaterial("imperomite", TextFormatting.DARK_RED,
        new BlockDto(Material.ROCK, 20.0f, 25f, DURANITE))
        .fluid(new FluidDto(0xFF7fefa0, 900, 10, 10000))
        .material(MaterialDto.builder()
            .headStats(new HeadMaterialStats(1350, 4.65f, 5.9f, DURANITE))
            .handleStats(new HandleMaterialStats(1.15f, -100))
            .extraDurability(150)
            .bowStats(new BowMaterialStats(1.2f, 1.8f, 2))
            .isCraftable(false)
            .isCastable(true).build())
        .traits(MaterialTraits.hollow);

    public static UtilityMaterial solarium = new UtilityMaterial("solarium", TextFormatting.YELLOW,
        new BlockDto(Material.ROCK, 25.0f, 25f, VIBRANIUM))
        .fluid(new FluidDto(0xFFfef864, 1500, 10, 2000))
        .material(MaterialDto.builder()
            .headStats(new HeadMaterialStats(1100, 24f, 7f, VIBRANIUM))
            .handleStats(new HandleMaterialStats(1.25f, 150))
            .extraDurability(150)
            .bowStats(new BowMaterialStats(0.8f, 1.5f, 5))
            .isCraftable(false)
            .isCastable(true).build())
        .traits(MaterialTraits.superheavy, MaterialTraits.crushing);

    public static UtilityMaterial nihilite = new UtilityMaterial("nihilite", TextFormatting.DARK_GRAY,
        new BlockDto(Material.ROCK, 10.0f, 25f, VALYRIUM))
        .fluid(new FluidDto(0xFF6645ba, 580, 10, 10000))
        .material(MaterialDto.builder()
            .headStats(new HeadMaterialStats(400, 2.8f, 4.50f, VALYRIUM))
            .handleStats(new HandleMaterialStats(.77f, 350))
            .extraDurability(155)
            .bowStats(new BowMaterialStats(1.5f, 0.8f, 3))
            .isCraftable(false)
            .isCastable(true).build())
        .traits(MaterialTraits.souleater);

    public static UtilityMaterial adamant = new UtilityMaterial("adamant", TextFormatting.GOLD,
        new BlockDto(Material.ROCK, 25.0f, 25f, VIBRANIUM))
        .fluid(new FluidDto(0xFFff8efe, 1650, 10, 10000))
        .material(MaterialDto.builder()
            .headStats(new HeadMaterialStats(1750, 6f, 6f, VIBRANIUM))
            .handleStats(new HandleMaterialStats(2.0F, 0))
            .extraDurability(0)
            .bowStats(new BowMaterialStats(0.35f, 1.85f, 8))
            .isCraftable(false)
            .isCastable(true).build())
        .traits(MaterialTraits.berserk);

    public static UtilityMaterial dyonite = new UtilityMaterial("dyonite", TextFormatting.GREEN,
        new BlockDto(Material.ROCK, 10.0f, 25f, DURANITE))
        .fluid(new FluidDto(0xFFffbd3f, 660, 10, 7000))
        .material(MaterialDto.builder()
            .headStats(new HeadMaterialStats(900, 6.45f, 5f, DURANITE))
            .handleStats(new HandleMaterialStats(0.66f, -50))
            .extraDurability(250)
            .bowStats(new BowMaterialStats(2, 0.9f, -1))
            .isCraftable(false)
            .isCastable(true).build())
        .traits(MaterialTraits.tantrum);

    public static UtilityMaterial nucleum = new UtilityMaterial("nucleum", TextFormatting.YELLOW,
        new BlockDto(Material.ROCK, 10.0f, 25f, VALYRIUM))
        .fluid(new FluidDto(0xFFe6ff40, 490, 10, 10000))
        .material(MaterialDto.builder()
            .headStats(new HeadMaterialStats(505, 17.5f, 9.5f, VALYRIUM))
            .handleStats(new HandleMaterialStats(1.05f, 100))
            .extraDurability(125)
            .isCraftable(false)
            .isCastable(true).build())
        .traits(MaterialTraits.decay, MaterialTraits.mutate);

    public static UtilityMaterial lumix = new UtilityMaterial("lumix", TextFormatting.YELLOW,
        new BlockDto(Material.ROCK, 15.0f, 25f, COBALT))
        .fluid(new FluidDto(0xFFf9f3cc, 450, 10, 8000))
        .material(MaterialDto.builder()
            .headStats(new HeadMaterialStats(666, 3.84f, 3.92f, COBALT))
            .handleStats(new HandleMaterialStats(0.85f, 250))
            .extraDurability(200)
            .bowStats(new BowMaterialStats(0.8f, 1.3f, 1))
            .isCraftable(false)
            .isCastable(true).build())
        .traits(MaterialTypes.HANDLE, MaterialTraits.bright)
        .traits(MaterialTypes.HEAD, MaterialTraits.glimmer);

    public static UtilityMaterial seismum = new UtilityMaterial("seismum", TextFormatting.GREEN,
        new BlockDto(Material.ROCK, 15.0f, 25f, COBALT))
        .fluid(new FluidDto(0xFFecbca8, 720, 10, 10000))
        .material(MaterialDto.builder()
            .headStats(new HeadMaterialStats(780, 3.66f, 6.05f, COBALT))
            .handleStats(new HandleMaterialStats(0.95f, 250))
            .extraDurability(50)
            .isCraftable(false)
            .isCastable(true).build())
        .traits(MaterialTraits.cascade);

    public static UtilityMaterial astrium = new UtilityMaterial("astrium", TextFormatting.DARK_PURPLE,
        new BlockDto(Material.ROCK, 15.0f, 25f, COBALT))
        .fluid(new FluidDto(0xFF8f385f, 680, 10, 10000))
        .material(MaterialDto.builder()
            .headStats(new HeadMaterialStats(750, 8.35f, 5.4f, COBALT))
            .handleStats(new HandleMaterialStats(0.95f, -100))
            .extraDurability(200)
            .bowStats(new BowMaterialStats(0.7f, 0.8f, 2))
            .isCraftable(false)
            .isCastable(true).build())
        .traits(MaterialTraits.ported);

    public static UtilityMaterial niob = new UtilityMaterial("niob", TextFormatting.RED,
        new BlockDto(Material.ROCK, 15.0f, 25f, DURANITE))
        .fluid(new FluidDto(0xFF7398b9, 550, 10, 10000))
        .material(MaterialDto.builder()
            .headStats(new HeadMaterialStats(700, 4.5f, 4.5f, COBALT))
            .handleStats(new HandleMaterialStats(2f, 200))
            .extraDurability(50)
            .isCraftable(false)
            .isCastable(true).build())
        .traits(MaterialTraits.reviving);

    public static UtilityMaterial yrdeen = new UtilityMaterial("yrdeen", TextFormatting.RED,
        new BlockDto(Material.ROCK, 15.0f, 25f, VALYRIUM))
        .fluid(new FluidDto(0xFF8f385f, 710, 10, 10000))
        .material(MaterialDto.builder()
            .headStats(new HeadMaterialStats(999, 9.1f, 3f, COBALT))
            .handleStats(new HandleMaterialStats(1.35f, 150))
            .extraDurability(250)
            .isCraftable(false)
            .isCastable(true).build())
        .traits(MaterialTraits.naturebound);

    public static UtilityMaterial iox = new UtilityMaterial("iox", TextFormatting.RED,
        new BlockDto(Material.ROCK, 20.0f, 25f, DURANITE))
        .fluid(new FluidDto(0xFF99323c, 900, 10, 10000));

    //////////////////// Non-metals ////////////////////

    public static UtilityMaterial basalt = new UtilityMaterial("basalt", TextFormatting.WHITE,
        new BlockDto(Material.ROCK, 20.0f, 35.0f, IRON))
        .fluid(new FluidDto(0xFFe4ddc3, 550, 10, 6000))
        .material(MaterialDto.builder()
            .headStats(new HeadMaterialStats(200, 3.0F, 2.5F, STONE))
            .handleStats(new HandleMaterialStats(0.5F, -25))
            .extraDurability(25)
            .isCraftable(true)
            .isCastable(false).build())
        .traits(MaterialTraits.softy);

    public static UtilityMaterial meteorite = new UtilityMaterial("meteorite", TextFormatting.DARK_GREEN,
        new BlockDto(Material.ROCK, 40f, 2000f, COBALT, 0.15f))
        .fluid(new FluidDto(0xFF374f3d, 950, 10, 7000))
        .material(MaterialDto.builder()
            .headStats(new HeadMaterialStats(1500, 1.5f, 1.5f, OBSIDIAN))
            .handleStats(new HandleMaterialStats(0.5F, 0))
            .extraDurability(0)
            .isCraftable(false)
            .isCastable(true).build())
        .traits(MaterialTypes.HEAD, crumbling)
        .traits(MaterialTraits.pulverizing);

    public static UtilityMaterial obsidiorite = new UtilityMaterial("obsidiorite", 0xFF224853,
        new BlockDto(Material.ROCK, 50f, 4000f, DURANITE, 0.2f))
        .fluid(new FluidDto(0xFF224853, 1050, 10, 7000))
        .material(MaterialDto.builder()
            .headStats(new HeadMaterialStats(1500, 0.5f, 0.5f, COBALT))
            .handleStats(new HandleMaterialStats(1.0F, -100))
            .extraDurability(100)
            .isCraftable(false)
            .isCastable(true).build())
        .traits(alien);
}
