package com.sosnitzka.taiga;


import com.sosnitzka.taiga.traits.*;
import net.minecraft.util.text.TextFormatting;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.materials.MaterialTypes;
import slimeknights.tconstruct.library.traits.AbstractTrait;

import static com.sosnitzka.taiga.Fluids.obsidioriteFluid;
import static slimeknights.tconstruct.tools.TinkerTraits.alien;
import static slimeknights.tconstruct.tools.TinkerTraits.crumbling;

public class MaterialTraits {

    // new hardness levels
    public static final int DURANITE = 5;
    public static final int VALYRIUM = 6;
    public static final int VIBRANIUM = 7;

    // Init of new traits
    public static final AbstractTrait instable = new TraitUnstable();
    public static final AbstractTrait naturebound = new TraitNatureBound();
    public static final AbstractTrait softy = new TraitSofty();
    public static final AbstractTrait curvature = new TraitCurvature();
    public static final AbstractTrait resonance = new TraitResonance();
    public static final AbstractTrait fracture = new TraitFracture();
    public static final AbstractTrait glimmer = new TraitGlimmer();
    public static final AbstractTrait garishly = new TraitGarishly();
    public static final AbstractTrait pulverizing = new TraitPulverizing();
    public static final AbstractTrait analysing = new TraitAnalysing();
    public static final AbstractTrait cascade = new TraitCascade();
    public static final AbstractTrait blind = new TraitBlind();
    public static final AbstractTrait dark = new TraitDark();
    public static final AbstractTrait bright = new TraitBright();
    public static final AbstractTrait slaughtering = new TraitSlaughtering();
    public static final AbstractTrait fragile = new TraitFragile();
    public static final AbstractTrait dissolving = new TraitDissolving();
    public static final AbstractTrait arcane = new TraitArcane();
    public static final AbstractTrait heroic = new TraitHeroic();
    public static final AbstractTrait hollow = new TraitHollow();
    public static final AbstractTrait diffuse = new TraitDiffuse();
    public static final AbstractTrait reviving = new TraitReviving();
    public static final AbstractTrait melting = new TraitMelting();
    public static final AbstractTrait tantrum = new TraitTantrum();
    public static final AbstractTrait catcher = new TraitCatcher();
    public static final AbstractTrait congenial = new TraitCongenial();
    public static final AbstractTrait souleater = new TraitSoulEater();
    public static final AbstractTrait cursed = new TraitCursed();
    public static final AbstractTrait ported = new TraitPorted();
    public static final AbstractTrait decay = new TraitDecay();
    public static final AbstractTrait whirl = new TraitWhirl();
    public static final AbstractTrait superheavy = new TraitSuperHeavy();
    public static final AbstractTrait berserk = new TraitBerserk();
    public static final AbstractTrait crushing = new TraitCrushing();
    public static final AbstractTrait mutate = new TraitMutate();

    public static Material meteorite = new Material("meteorite", TextFormatting.DARK_GREEN).addTrait(crumbling, MaterialTypes.HEAD).addTrait(pulverizing);
    public static Material obsidiorite = new Material("obsidiorite", obsidioriteFluid.getColor()).addTrait(alien);
}
