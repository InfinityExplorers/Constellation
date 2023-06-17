package com.infinityexplorers.constellation.common.recipes.catalysts;

import javax.annotation.Nonnull;

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

    public int compareTo(@Nonnull Catalyst o) {
        // compare order: Tier, Speed, Yield, Energy
        int result = Integer.compare(this.getTier(), o.getTier());
        if (result != 0) return result;
        result = Double.compare(this.getSpeedEfficiency(), o.getSpeedEfficiency());
        if (result != 0) return result;
        result = Double.compare(this.getYieldEfficiency(), o.getYieldEfficiency());
        if (result != 0) return result;
        result = Double.compare(this.getEnergyEfficiency(), o.getEnergyEfficiency());
        return result;
    }
}
