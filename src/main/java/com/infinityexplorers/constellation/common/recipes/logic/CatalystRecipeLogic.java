package com.infinityexplorers.constellation.common.recipes.logic;

import com.infinityexplorers.constellation.common.recipes.catalysts.Catalyst;
import com.infinityexplorers.constellation.common.recipes.catalysts.properties.CatalystPropertyValue;
import com.infinityexplorers.constellation.common.recipes.catalysts.properties.CatalystRecipeProperty;
import com.infinityexplorers.constellation.common.recipes.logic.overclocking.OrionOverclockingLogic;
import gregtech.api.capability.IEnergyContainer;
import gregtech.api.capability.impl.RecipeLogicEnergy;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.logic.OverclockingLogic;
import gregtech.api.recipes.recipeproperties.IRecipePropertyStorage;
import gregtech.api.util.GTUtility;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

import static gregtech.api.GTValues.ULV;

public class CatalystRecipeLogic extends RecipeLogicEnergy {

    private Catalyst catalyst;
    private int requiredCatalystTier;

    public CatalystRecipeLogic(MetaTileEntity tileEntity, RecipeMap<?> recipeMap, Supplier<IEnergyContainer> energyContainer) {
        super(tileEntity, recipeMap, energyContainer);
    }


    public void tryFindCatalyst(@Nonnull Recipe recipe) {
        this.catalyst = null;
        this.requiredCatalystTier = -1;

        if(recipe.hasProperty(CatalystRecipeProperty.getInstance())) {
            CatalystPropertyValue propertyValue = recipe.getProperty(CatalystRecipeProperty.getInstance(), null);

            if(propertyValue.getTier() == -1) {
                return;
            }

            for(int i = 0; i < getInputInventory().getSlots(); i++) {
                ItemStack itemStack = getInputInventory().getStackInSlot(i);
                if(!itemStack.isEmpty()) {
                    Catalyst catalyst1 = propertyValue.getCatalystGroup().getCatalysts().get(itemStack);

                    if(catalyst1 != null) {
                        if(this.catalyst == null) {
                            this.catalyst = catalyst1;
                        } else if(this.catalyst.compareTo(catalyst1) > 0) {
                            this.catalyst = catalyst1;
                        }
                    }
                }
            }

            if(this.catalyst != null) {
                System.out.println("motherfucker");
                this.requiredCatalystTier = propertyValue.getTier();
            }
        }
    }

    @Override
    protected boolean prepareRecipe(Recipe recipe) {
        recipe = Recipe.trimRecipeOutputs(recipe, this.getRecipeMap(), this.metaTileEntity.getItemOutputLimit(), this.metaTileEntity.getFluidOutputLimit());

        recipe = findParallelRecipe(this, recipe, getInputInventory(), getInputTank(), getOutputInventory(), getOutputTank(), getMaxParallelVoltage(), getParallelLimit());

        if(recipe != null && this.setupAndConsumeRecipeInputs(recipe, this.getInputInventory())) {
            this.setupRecipe(recipe);
            return true;
        }
        return false;
    }

    @Override
    protected int[] runOverclockingLogic(@Nonnull IRecipePropertyStorage propertyStorage, int recipeEUt, long maxVoltage, int duration, int amountOC) {
        if(requiredCatalystTier != -1 && catalyst != null) {
            return OrionOverclockingLogic.catalystOverclockingLogic(
                    recipeEUt,
                    maxVoltage,
                    duration,
                    amountOC,
                    catalyst,
                    requiredCatalystTier,
                    getOverclockingDurationDivisor(),
                    getOverclockingVoltageMultiplier()
            );
        } else {
            return OverclockingLogic.standardOverclockingLogic(
                    recipeEUt,
                    maxVoltage,
                    duration,
                    amountOC,
                    this.getOverclockingDurationDivisor(),
                    this.getOverclockingVoltageMultiplier()
            );
        }
    }

    @Override
    protected int[] performOverclocking(@Nonnull Recipe recipe) {
        int recipeTier = GTUtility.getTierByVoltage(recipe.getEUt());
        int maximumTier = getOverclockForTier(getMaximumOverclockVoltage());

        int numberOfOCs = maximumTier - recipeTier;
        if (recipeTier == ULV) numberOfOCs--;

        return runOverclockingLogic(recipe.getRecipePropertyStorage(), recipe.getEUt(), getMaximumOverclockVoltage(), recipe.getDuration(), numberOfOCs);
    }
}
