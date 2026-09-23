package com.sosnitzka.taiga.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FluidDto {
    private int color;
    private int temperature;
    private int luminosity;
    private int viscosity;
}
