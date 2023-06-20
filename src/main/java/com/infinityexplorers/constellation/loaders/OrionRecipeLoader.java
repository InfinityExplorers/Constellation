package com.infinityexplorers.constellation.loaders;

import com.infinityexplorers.constellation.common.recipes.OrionRecipeMaps;
import com.infinityexplorers.constellation.common.recipes.catalysts.CatalystGroup;
import com.infinityexplorers.constellation.common.recipes.catalysts.CatalystGroups;
import com.infinityexplorers.constellation.loaders.recipes.chemistry.ChemistryOverhaul;
import com.infinityexplorers.constellation.loaders.recipes.chemistry.PetroChem;
import com.infinityexplorers.constellation.loaders.recipes.circuits.PrimitiveCircuits;
import com.infinityexplorers.constellation.loaders.recipes.circuits.lithography.LithographyLine;
import gregtech.api.unification.material.Materials;

import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;

import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.api.GTValues.*;


public class OrionRecipeLoader {

    public static void init() {
        // Chemistry
        ChemistryOverhaul.init();
        PetroChem.init();

        //Circuitry
        LithographyLine.init();

        PrimitiveCircuits.init();

    }
}
