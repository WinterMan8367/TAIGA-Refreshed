package com.sosnitzka.taiga.dto;

import lombok.Builder;
import lombok.Getter;
import slimeknights.tconstruct.library.materials.BowMaterialStats;
import slimeknights.tconstruct.library.materials.HandleMaterialStats;
import slimeknights.tconstruct.library.materials.HeadMaterialStats;

@Getter 
@Builder
public class MaterialDto {
    @Builder.Default private HeadMaterialStats headStats = new HeadMaterialStats(0, 0, 0, 0);
    @Builder.Default private HandleMaterialStats handleStats = new HandleMaterialStats(1, 0);
    private int extraDurability;
    @Builder.Default private BowMaterialStats bowStats = new BowMaterialStats(0.2f, 0.4f, -1f);
    private boolean isCraftable;
    private boolean isCastable;
}
