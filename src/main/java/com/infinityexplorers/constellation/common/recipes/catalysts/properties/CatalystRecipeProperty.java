package com.infinityexplorers.constellation.common.recipes.catalysts.properties;

import gregtech.api.GTValues;
import gregtech.api.recipes.recipeproperties.RecipeProperty;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;

public class CatalystRecipeProperty extends RecipeProperty<CatalystPropertyValue> {

    private static CatalystRecipeProperty INSTANCE;

    protected CatalystRecipeProperty() {
        super("catalyst", CatalystPropertyValue.class);
    }

    public static CatalystRecipeProperty getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new CatalystRecipeProperty();
        }
        return INSTANCE;
    }

    @Override
    public void drawInfo(Minecraft minecraft, int x, int y, int color, Object o) {
        CatalystPropertyValue propertyValue = castValue(o);
        int tier = propertyValue.getTier();

        String localisedGroupName = I18n.format("constellation.catalyst_group." + propertyValue.getCatalystGroup().getName() + ".name");

        minecraft.fontRenderer.drawString(I18n.format("constellation.recipe.catalyst", GTValues.VN[tier], localisedGroupName), x, y, color);
    }
}
