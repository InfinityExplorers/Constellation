package com.infinityexplorers.constellation.common.items;

import gregtech.api.items.metaitem.MetaOreDictItem;
import gregtech.api.items.metaitem.StandardMetaItem;

public class OrionMetaItems {

    private static StandardMetaItem metaItem;
    public static MetaOreDictItem oreDictItem;

    public static void initMetaItems() {
        metaItem = new StandardMetaItem();
        metaItem.setRegistryName("meta_item");
        oreDictItem = new MetaOreDictItem((short) 0);
        oreDictItem.setRegistryName("orion_oredict_item");

        CatalystItems.init();
    }

    public static void initSubItems() {

        CatalystItems.initCatalysts();
    }
}
