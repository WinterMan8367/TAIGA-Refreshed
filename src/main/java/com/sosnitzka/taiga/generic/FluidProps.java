package com.sosnitzka.taiga.generic;

public class FluidProps {
    private int color;
    private int temp;
    private int lumen;
    private int visk;

    public FluidProps(int color, int temp, int lumen, int visk) {
        this.color = color;
        this.temp = temp;
        this.lumen = lumen;
        this.visk = visk;
    }

    public int getFluidColor() {
        return this.color;
    }

    public int getTemperature() {
        return this.temp;
    }

    public int getLuminosity() {
        return this.lumen;
    }

    public int getViscosity() {
        return this.visk;
    }
}
