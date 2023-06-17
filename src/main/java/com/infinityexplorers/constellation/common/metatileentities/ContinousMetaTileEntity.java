package com.infinityexplorers.constellation.common.metatileentities;

import com.infinityexplorers.constellation.common.recipes.logic.CatalystRecipeLogic;
import com.infinityexplorers.constellation.common.recipes.logic.ContinuousRecipeLogic;
import gregtech.api.capability.impl.RecipeLogicEnergy;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.SimpleMachineMetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.recipes.RecipeMap;
import gregtech.client.renderer.ICubeRenderer;
import net.minecraft.util.ResourceLocation;

import java.util.function.Function;

public class ContinousMetaTileEntity extends SimpleMachineMetaTileEntity {
    public ContinousMetaTileEntity(ResourceLocation metaTileEntityId, RecipeMap<?> recipeMap, ICubeRenderer renderer, int tier, boolean hasFrontFacing, Function<Integer, Integer> tankScalingFunction) {
        super(metaTileEntityId, recipeMap, renderer, tier, hasFrontFacing, tankScalingFunction);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new ContinousMetaTileEntity(this.metaTileEntityId, this.workable.getRecipeMap(), this.renderer, this.getTier(), this.hasFrontFacing(), this.getTankScalingFunction());
    }

    @Override
    protected RecipeLogicEnergy createWorkable(RecipeMap<?> recipeMap) {
        return new CatalystRecipeLogic(this, recipeMap, () -> this.energyContainer);
    }
}
