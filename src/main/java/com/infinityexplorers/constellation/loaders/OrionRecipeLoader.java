package com.infinityexplorers.constellation.loaders;

import com.infinityexplorers.constellation.common.recipes.OrionRecipeMaps;
import gregtech.api.unification.material.Materials;

import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;

import static gregtech.api.unification.ore.OrePrefix.*;


public class OrionRecipeLoader {

    public static void init() {
        CHEMICAL_RECIPES.recipeBuilder()
                .EUt(512)
                .duration(60)
                .fluidInputs(NitricAcid.getFluid(2000))
                .fluidInputs(Water.getFluid(1000))
                .output(dust, Aluminium)
                .buildAndRegister();

        OrionRecipeMaps.PRIMITIVE_ALLOY_SMELTER.recipeBuilder()
                .duration(20)
                .input(dust, Copper, 3)
                .input(dust, Tin, 1)
                .output(ingot, Bronze, 4)
                .buildAndRegister();

    }
}
