package com.infinityexplorers.constellation.common.recipes.logic.overclocking;

import com.infinityexplorers.constellation.common.recipes.catalysts.Catalyst;

import javax.annotation.Nonnull;

import static gregtech.api.recipes.logic.OverclockingLogic.*;

public class OrionOverclockingLogic {

    public static int[] catalystOverclockingLogic(int recipeEUt, long maximumVoltage, int recipeDuration, int maxOverclocks, @Nonnull Catalyst catalyst, int requiredCatalystTier, double durationDivisor, double voltageMultiplier) {
        int amountAboveTier = catalyst.getTier() - requiredCatalystTier;

        double energyEfficiency = catalyst.getEnergyEfficiency();
        double catalystDurationDivisor = catalyst.getSpeedEfficiency();

        if(amountAboveTier > 0) {

            //TODO: change formula
            recipeEUt *= Math.min(1, Math.pow(energyEfficiency, amountAboveTier));

            double resultDurationDouble = recipeDuration / Math.pow(catalystDurationDivisor, amountAboveTier);

            recipeDuration = resultDurationDouble < 1 ? 1 : (int) resultDurationDouble;

            return standardOverclockingLogic(recipeEUt, maximumVoltage, recipeDuration, maxOverclocks, durationDivisor, voltageMultiplier);
        }

        return standardOverclockingLogic(recipeEUt, maximumVoltage, recipeDuration, maxOverclocks, durationDivisor, voltageMultiplier);
    }
}
