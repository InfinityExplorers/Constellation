package com.infinityexplorers.constellation.loaders;

import com.infinityexplorers.constellation.common.recipes.OrionRecipeMaps;
import com.infinityexplorers.constellation.common.recipes.catalysts.CatalystGroup;
import com.infinityexplorers.constellation.common.recipes.catalysts.CatalystGroups;
import gregtech.api.unification.material.Materials;

import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;

import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.api.GTValues.*;


public class OrionRecipeLoader {

    public static void init() {
        CHEMICAL_RECIPES.recipeBuilder()
                .EUt(512)
                .duration(60)
                .fluidInputs(NitricAcid.getFluid(2000))
                .fluidInputs(Water.getFluid(1000))
                .output(dust, Aluminium)
                .buildAndRegister();

        OrionRecipeMaps.STEAM_ALLOY_SMELTER.recipeBuilder()
                .EUt(VA[0])
                .duration(20)
                .input(dust, Tin, 1)
                .input(dust, Copper, 3)
                .output(ingot, Bronze, 4)
                .buildAndRegister();

        OrionRecipeMaps.TRICKLE_BED_REACTOR.recipeBuilder()
                .EUt(32)
                .duration(15)
                .catalyst(CatalystGroups.POLYMERIZATION_CATALYST_GROUP, 1, 1)
                .fluidInputs(Ethylene.getFluid(2000))
                .output(plate, Polyethylene, 5)
                .buildAndRegister();

        OrionRecipeMaps.CONTINUOUS_STIRRED_TANK_REACTOR.recipeBuilder()
                .EUt(32)
                .duration(100)
                .catalyst(CatalystGroups.POLYMERIZATION_CATALYST_GROUP, 1, 1)
                .fluidInputs(Ethylene.getFluid(2000))
                .fluidOutputs(Polyethylene.getFluid(144))
                .buildAndRegister();

    }
}
