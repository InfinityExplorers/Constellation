package com.infinityexplorers.constellation.common.items;

import com.infinityexplorers.constellation.api.unification.OrionMaterialIconSets;
import com.infinityexplorers.constellation.api.unification.OrionOrePrefix;
import com.infinityexplorers.constellation.common.items.catalyst.CatalystItems;
import gregtech.api.items.metaitem.MetaOreDictItem;
import gregtech.api.items.metaitem.StandardMetaItem;
import gregtech.api.unification.material.info.MaterialIconSet;

public class OrionMetaItems {

    private static StandardMetaItem metaItem;
    public static MetaOreDictItem oreDictItem;




    public static void initMetaItems() {
        metaItem = new StandardMetaItem();
        metaItem.setRegistryName("meta_item");
        oreDictItem = new MetaOreDictItem((short) 0);
        oreDictItem.setRegistryName("orion_oredict_item");

        metaItem.addItem(14500, "test");

        CatalystItems.init();
    }

    public static void initSubItems() {
        CatalystItems.initCatalysts();


    }



}
