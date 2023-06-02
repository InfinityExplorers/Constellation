package com.infinityexplorers.constellation.common.recipes.logic;

import gregtech.api.capability.IEnergyContainer;
import gregtech.api.capability.impl.RecipeLogicEnergy;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.recipeproperties.IRecipePropertyStorage;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

public class ContinuousRecipeLogic extends RecipeLogicEnergy {


    public ContinuousRecipeLogic(MetaTileEntity tileEntity, RecipeMap<?> recipeMap, Supplier<IEnergyContainer> energyContainer) {
        super(tileEntity, recipeMap, energyContainer);
    }

    @Override
    protected int[] performOverclocking(@Nonnull Recipe recipe) {
        return super.performOverclocking(recipe);
    }

    @Override
    protected boolean prepareRecipe(Recipe recipe) {
        return super.prepareRecipe(recipe);
    }

    @Override
    protected int[] runOverclockingLogic(@Nonnull IRecipePropertyStorage propertyStorage, int recipeEUt, long maxVoltage, int duration, int amountOC) {
        return super.runOverclockingLogic(propertyStorage, recipeEUt, maxVoltage, duration, amountOC);
    }

    @Override
    protected long getEnergyInputPerSecond() {
        return 0;
    }

    @Override
    protected long getEnergyStored() {
        return 0;
    }

    @Override
    protected long getEnergyCapacity() {
        return 0;
    }

    @Override
    protected boolean drawEnergy(int i, boolean b) {
        return false;
    }

    @Override
    protected long getMaxVoltage() {
        return 0;
    }
}
