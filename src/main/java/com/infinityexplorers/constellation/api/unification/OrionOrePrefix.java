package com.infinityexplorers.constellation.api.unification;

import gregtech.api.GTValues;
import gregtech.api.unification.ore.OrePrefix;

public class OrionOrePrefix {

    // Catalyst beds
    public static OrePrefix catalystBedPolymerization = new OrePrefix("catalystBedPolymerization", GTValues.M, null, OrionMaterialIconType.catalystBed, 1L, mat -> false);
    public static OrePrefix catalystBedOxidation = new OrePrefix("catalystBedOxidation", GTValues.M, null, OrionMaterialIconType.catalystBed, 1l, material -> false);
    public static OrePrefix catalystBedCracking = new OrePrefix("catalystBedCracking", GTValues.M, null, OrionMaterialIconType.catalystBed, 1L, mat -> false);
}
