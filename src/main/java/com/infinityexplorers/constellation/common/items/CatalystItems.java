package com.infinityexplorers.constellation.common.items;

import com.infinityexplorers.constellation.api.unification.OrionMaterialIconSets;
import com.infinityexplorers.constellation.api.unification.OrionOrePrefix;
import com.infinityexplorers.constellation.common.recipes.catalysts.Catalyst;
import com.infinityexplorers.constellation.common.recipes.catalysts.CatalystGroup;
import com.infinityexplorers.constellation.common.recipes.catalysts.CatalystGroups;
import com.infinityexplorers.constellation.utility.OrionValues;
import gregtech.api.items.metaitem.MetaOreDictItem;
import gregtech.api.unification.material.info.MaterialIconSet;
import gregtech.api.unification.ore.OrePrefix;

public class CatalystItems {

    //Catalyst Groups
    public static final MetaOreDictItem.OreDictValueItem[] POLYMERIZATION_CATALYST_BEDS = new MetaOreDictItem.OreDictValueItem[14];

    public static MetaOreDictItem.OreDictValueItem CRACKING_CATALYST_BED;

    public static void init() {

        CRACKING_CATALYST_BED = OrionMetaItems.oreDictItem.addOreDictItem(28, "standard", 0x728a7a, MaterialIconSet.DULL, OrionOrePrefix.catalystBedCracking);

        initCatalysts();
    }

    public static void initCatalysts() {

        addTieredCatalystGroup(POLYMERIZATION_CATALYST_BEDS, CatalystGroups.POLYMERIZATION_CATALYST_GROUP);
    }


    public void addTieredCatalystItem(MetaOreDictItem.OreDictValueItem[] items, int id, int RGB, OrePrefix orePrefix) {
        //Loops through all 14 tiers in the OreDictValueItem array (14) and adds an item for each of those tiers. Logic by Supersymmetry team
        for(int i = 0; i < items.length; i++) {
            OrionMetaItems.oreDictItem.addOreDictItem(id + i, OrionValues.TierMaterials.toString(), RGB, OrionMaterialIconSets.TIERS[i], orePrefix);
        }
    }

    public static void addTieredCatalystGroup(MetaOreDictItem.OreDictValueItem[] items, CatalystGroup catalystGroup) {
        for (int i = 0; i < items.length; i++) {
            catalystGroup.add(items[i].getItemStack(), new Catalyst(
                    i,
                    1,
                    0.95 * i,
                    1.25 * i
            ));
        }
    }
}
