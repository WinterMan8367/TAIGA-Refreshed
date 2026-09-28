package com.sosnitzka.taiga.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FluidDto {
    private int color;
    private int temperature;
    private int luminosity;
    private int viscosity;
}
