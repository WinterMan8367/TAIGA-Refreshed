package com.sosnitzka.taiga;


import net.minecraftforge.fluids.FluidStack;
import slimeknights.tconstruct.shared.TinkerFluids;

import static com.sosnitzka.taiga.Fluids.*;
import static com.sosnitzka.taiga.util.Utils.registerTinkerAlloy;

public class Alloys {

    /**
     * Registers alloying in the smeltery
     */
    public static void register() {
        registerTinkerAlloy(new FluidStack(Materials.terrax.getFluid(), 2), new FluidStack(Materials.karmesine.getFluid(), 1), new FluidStack
                (Materials.ovium.getFluid(), 1), new FluidStack(Materials.jauxum.getFluid(), 1));
        registerTinkerAlloy(new FluidStack(Materials.triberium.getFluid(), 1), new FluidStack(Materials.tiberium.getFluid(), 5), new FluidStack
                (Materials.basalt.getFluid(), 1));
        registerTinkerAlloy(new FluidStack(Materials.triberium.getFluid(), 1), new FluidStack(Materials.tiberium.getFluid(), 5), new FluidStack
                (Materials.dilithium.getFluid(), 2));
        registerTinkerAlloy(new FluidStack(Materials.fractum.getFluid(), 2), new FluidStack(Materials.triberium.getFluid(), 3), new FluidStack
                (TinkerFluids.obsidian, 3), new FluidStack(Materials.abyssum.getFluid(), 1));
        registerTinkerAlloy(new FluidStack(Materials.violium.getFluid(), 2), new FluidStack(Materials.aurorium.getFluid(), 3), new FluidStack
                (TinkerFluids.ardite, 2));
        registerTinkerAlloy(new FluidStack(Materials.proxii.getFluid(), 3), new FluidStack(Materials.prometheum.getFluid(), 3), new FluidStack
                (Materials.palladium.getFluid(), 3), new FluidStack(Materials.eezo.getFluid(), 1));
        registerTinkerAlloy(new FluidStack(Materials.tritonite.getFluid(), 2), new FluidStack(TinkerFluids.cobalt, 3), new FluidStack
                (Materials.terrax.getFluid(), 2));
        registerTinkerAlloy(new FluidStack(Materials.ignitz.getFluid(), 2), new FluidStack(TinkerFluids.ardite, 2), new FluidStack
                (Materials.terrax.getFluid(), 2), new FluidStack(Materials.osram.getFluid(), 1));
        registerTinkerAlloy(new FluidStack(Materials.imperomite.getFluid(), 2), new FluidStack(Materials.duranite.getFluid(), 3), new FluidStack
                (Materials.prometheum.getFluid(), 1), new FluidStack(Materials.abyssum.getFluid(), 1));
        registerTinkerAlloy(new FluidStack(Materials.solarium.getFluid(), 2), new FluidStack(Materials.valyrium.getFluid(), 2), new FluidStack
                (Materials.uru.getFluid(), 2), new FluidStack(Materials.nucleum.getFluid(), 1));
        registerTinkerAlloy(new FluidStack(Materials.adamant.getFluid(), 3), new FluidStack(Materials.nihilite.getFluid(), 1), new FluidStack
                (Materials.iox.getFluid(), 3));
        registerTinkerAlloy(new FluidStack(Materials.nihilite.getFluid(), 1), new FluidStack(Materials.vibranium.getFluid(), 1), new FluidStack
                (Materials.solarium.getFluid(), 1));
        registerTinkerAlloy(new FluidStack(Materials.seismum.getFluid(), 4), new FluidStack(TinkerFluids.obsidian, 4), new FluidStack
                (Materials.triberium.getFluid(), 2), new FluidStack(Materials.eezo.getFluid(), 1));
        registerTinkerAlloy(new FluidStack(Materials.astrium.getFluid(), 2), new FluidStack(Materials.terrax.getFluid(), 3), new FluidStack
                (Materials.aurorium.getFluid(), 2));
        registerTinkerAlloy(new FluidStack(Materials.niob.getFluid(), 3), new FluidStack(Materials.palladium.getFluid(), 3), new FluidStack
                (Materials.duranite.getFluid(), 1), new FluidStack(Materials.osram.getFluid(), 1));
        registerTinkerAlloy(new FluidStack(Materials.yrdeen.getFluid(), 3), new FluidStack(Materials.uru.getFluid(), 3), new FluidStack
                (Materials.valyrium.getFluid(), 3), new FluidStack(Materials.osram.getFluid(), 1));
        registerTinkerAlloy(new FluidStack(Materials.yrdeen.getFluid(), 3), new FluidStack(Materials.uru.getFluid(), 3), new FluidStack
                (Materials.valyrium.getFluid(), 3), new FluidStack(Materials.eezo.getFluid(), 1));
        registerTinkerAlloy(new FluidStack(Materials.yrdeen.getFluid(), 3), new FluidStack(Materials.uru.getFluid(), 3), new FluidStack
                (Materials.valyrium.getFluid(), 3), new FluidStack(Materials.abyssum.getFluid(), 1));
        registerTinkerAlloy(new FluidStack(Materials.iox.getFluid(), 1), new FluidStack(Materials.eezo.getFluid(), 2), new FluidStack(Materials.abyssum.getFluid(),
                2), new FluidStack(Materials.osram.getFluid(), 2), new FluidStack(Materials.obsidiorite.getFluid(), 9));
        registerTinkerAlloy(new FluidStack(Materials.iox.getFluid(), 1), new FluidStack(Materials.eezo.getFluid(), 2), new FluidStack(Materials.abyssum.getFluid(),
                2), new FluidStack(Materials.osram.getFluid(), 2), new FluidStack(Materials.meteorite.getFluid(), 9), new FluidStack(TinkerFluids
                .obsidian, 9));
        registerTinkerAlloy(new FluidStack(Materials.lumix.getFluid(), 1), new FluidStack(Materials.palladium.getFluid(), 1), new FluidStack
                (Materials.terrax.getFluid(), 1));
        registerTinkerAlloy(new FluidStack(Materials.obsidiorite.getFluid(), 1), new FluidStack(Materials.meteorite.getFluid(), 1), new FluidStack
                (TinkerFluids.obsidian, 1));
        registerTinkerAlloy(new FluidStack(Materials.nucleum.getFluid(), 3), new FluidStack(Materials.proxii.getFluid(), 3), new FluidStack
                (Materials.abyssum.getFluid(), 1), new FluidStack(Materials.osram.getFluid(), 1));
        registerTinkerAlloy(new FluidStack(Materials.nucleum.getFluid(), 3), new FluidStack(Materials.imperomite.getFluid(), 3), new FluidStack
                (Materials.osram.getFluid(), 1), new FluidStack(Materials.eezo.getFluid(), 1));
        registerTinkerAlloy(new FluidStack(Materials.nucleum.getFluid(), 3), new FluidStack(Materials.niob.getFluid(), 3), new FluidStack(Materials.eezo.getFluid(),
                1), new FluidStack(Materials.abyssum.getFluid(), 1));
        registerTinkerAlloy(new FluidStack(Materials.dyonite.getFluid(), 3), new FluidStack(Materials.triberium.getFluid(), 3), new FluidStack
                (Materials.fractum.getFluid(), 1), new FluidStack(Materials.seismum.getFluid(), 1), new FluidStack(Materials.osram.getFluid(), 1));
        registerTinkerAlloy(new FluidStack(Materials.dyonite.getFluid(), 3), new FluidStack(Materials.tiberium.getFluid(), 12), new FluidStack
                (Materials.fractum.getFluid(), 1), new FluidStack(Materials.seismum.getFluid(), 1), new FluidStack(Materials.osram.getFluid(), 1));
        registerTinkerAlloy(new FluidStack(nitroniteFluid, 6), new FluidStack(magmaFluid, 6), new FluidStack
                (Materials.osram.getFluid(), 1));

    }
}
