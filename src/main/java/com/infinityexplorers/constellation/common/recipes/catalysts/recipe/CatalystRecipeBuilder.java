package com.infinityexplorers.constellation.common.recipes.catalysts.recipe;

import com.infinityexplorers.constellation.common.recipes.catalysts.CatalystGroup;
import com.infinityexplorers.constellation.common.recipes.catalysts.properties.CatalystPropertyValue;
import com.infinityexplorers.constellation.common.recipes.catalysts.properties.CatalystRecipeProperty;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.ingredients.GTRecipeInput;
import gregtech.api.recipes.ingredients.GTRecipeItemInput;
import net.minecraft.item.ItemStack;

import java.util.Map;

public class CatalystRecipeBuilder extends RecipeBuilder<CatalystRecipeBuilder> {

    public CatalystRecipeBuilder() {
    }

    @SuppressWarnings("unused")
    public CatalystRecipeBuilder(Recipe recipe, RecipeMap<CatalystRecipeBuilder> recipeMap) {
        super(recipe, recipeMap);
    }

    public CatalystRecipeBuilder(RecipeBuilder<CatalystRecipeBuilder> recipeBuilder) {
        super(recipeBuilder);
    }

    public CatalystRecipeBuilder catalyst(CatalystGroup catalystGroup, int tier, int amount) {
        applyProperty(CatalystRecipeProperty.getInstance(), new CatalystPropertyValue(tier, catalystGroup));

        ItemStack[] inputStacks = catalystGroup.getCatalysts().streamEntries()
                .filter(entry -> entry.getValue().getTier() >= tier)
                .map(Map.Entry::getKey)
                .map(is -> {
                    is = is.copy();
                    is.setCount(amount);
                    return is;
                }).toArray(ItemStack[]::new);

        return this.notConsumable(GTRecipeItemInput.getOrCreate(inputStacks));
    }
}