package com.infinityexplorers.constellation.common.items.catalyst;

import com.infinityexplorers.constellation.api.unification.OrionMaterialIconSets;
import com.infinityexplorers.constellation.api.unification.OrionOrePrefix;
import com.infinityexplorers.constellation.common.items.OrionMetaItems;
import com.infinityexplorers.constellation.common.recipes.catalysts.Catalyst;
import com.infinityexplorers.constellation.common.recipes.catalysts.CatalystGroup;
import com.infinityexplorers.constellation.common.recipes.catalysts.CatalystGroups;
import com.infinityexplorers.constellation.utility.OrionValues;
import gregtech.api.items.metaitem.MetaOreDictItem;
import gregtech.api.unification.material.info.MaterialIconSet;
import gregtech.api.unification.ore.OrePrefix;

public class CatalystItems {


    public static MetaOreDictItem.OreDictValueItem[] POLYMERIZATION_CATALYST_BED = new MetaOreDictItem.OreDictValueItem[14];

    public static MetaOreDictItem.OreDictValueItem CRACKING_CATALYST_BED;

    public static void init() {
        initTieredCatalystMetaItems(POLYMERIZATION_CATALYST_BED, 14500, 0x1a75ff, OrionOrePrefix.catalystBedPolymerization);

        CRACKING_CATALYST_BED = OrionMetaItems.oreDictItem.addOreDictItem(28, "standard", 0x728a7a, MaterialIconSet.DULL, OrionOrePrefix.catalystBedCracking);

        initCatalysts();
        CatalystGroups.init();
    }

    public static void initCatalysts() {
        addTieredCatalystGroups(POLYMERIZATION_CATALYST_BED, CatalystGroups.POLYMERIZATION_CATALYST_GROUP);

        CatalystGroups.CRACKING_CATALYST_GROUP.add(CRACKING_CATALYST_BED.getItemStack(), new Catalyst(
                -1,
                1,
                0.95,
                1.25
        ));
    }

    public static void initTieredCatalystMetaItems(MetaOreDictItem.OreDictValueItem[] items, int startId, int RGB, OrePrefix orePrefix) {
        for(int i = 0; i < items.length; i++) {
            items[i] = OrionMetaItems.oreDictItem.addOreDictItem(startId + i, OrionValues.TierMaterials[i].toString(), RGB, OrionMaterialIconSets.TIERS[i], orePrefix);
        }
    }

    public static void addTieredCatalystGroups(MetaOreDictItem.OreDictValueItem[] items, CatalystGroup catalystGroup) {
        for (int i = 0; i < items.length; i++) {
            catalystGroup.add(items[i].getItemStack(), new Catalyst(
                    1,
                    1,
                    0.95,
                    1.25
            ));
        }
    }



}
