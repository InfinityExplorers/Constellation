package com.infinityexplorers.constellation.common.recipes.catalysts;

import java.util.ArrayList;
import java.util.List;

public class CatalystGroups {

    public static List<CatalystGroup> catalystGroups = new ArrayList<>();

    public static final CatalystGroup POLYMERIZATION_CATALYST_GROUP = new CatalystGroup("polymerization_catalyst_bed");
    public static final CatalystGroup OXIDATION_CATALYST_GROUP = new CatalystGroup("oxidation_catalyst_bed");

    public static final CatalystGroup CRACKING_CATALYST_GROUP = new CatalystGroup("cracking_catalyst_bed");


    private CatalystGroups() {
    }

    public static void init() {
        catalystGroups.add(POLYMERIZATION_CATALYST_GROUP);
        catalystGroups.add(CRACKING_CATALYST_GROUP);
    }

    public static List<CatalystGroup> getCatalystGroups() {
        return catalystGroups;
    }
}
