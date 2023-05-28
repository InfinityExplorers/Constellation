package com.infinityexplorers.constellation.common.recipes.catalysts;

public class Catalyst {

    private final int tier;

    private final double energyEfficiency;
    private final double yieldEfficiency;
    private final double speedEfficiency;

    public Catalyst(int tier, double energyEfficiency, double yieldEfficiency, double speedEfficiency) {
        this.tier = tier;

        this.energyEfficiency = energyEfficiency;
        this.yieldEfficiency = yieldEfficiency;
        this.speedEfficiency = speedEfficiency;
    }

    public int getTier() {
        return tier;
    }

    public double getEnergyEfficiency() {
        return energyEfficiency;
    }

    public double getYieldEfficiency() {
        return yieldEfficiency;
    }

    public double getSpeedEfficiency() {
        return speedEfficiency;
    }
}
