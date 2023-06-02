package com.infinityexplorers.constellation.common.recipes;

import com.infinityexplorers.constellation.common.recipes.catalysts.recipe.CatalystRecipeBuilder;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.builders.PrimitiveRecipeBuilder;
import gregtech.api.recipes.builders.SimpleRecipeBuilder;

public class OrionRecipeMaps {

    public static final RecipeMap<SimpleRecipeBuilder> STEAM_ALLOY_SMELTER = new RecipeMap<>("steam_alloy_smelter", 2, 1, 0, 0, new SimpleRecipeBuilder(), false);


    public static final RecipeMap<CatalystRecipeBuilder> TRICKLE_BED_REACTOR = new RecipeMap<>("trickle_bed_reactor", 1, 0, 3, 2, new CatalystRecipeBuilder(), false);



    public static void init() {

    }
}
