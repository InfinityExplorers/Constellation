package com.infinityexplorers.constellation.common.metatileentities;

import com.infinityexplorers.constellation.Constellation;

import com.infinityexplorers.constellation.client.OrionTextures;
import com.infinityexplorers.constellation.common.recipes.OrionRecipeMaps;
import gregtech.api.GTValues;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.util.GTUtility;
import gregtech.client.renderer.ICubeRenderer;
import net.minecraft.util.ResourceLocation;

import java.util.function.Function;

import static gregtech.common.metatileentities.MetaTileEntities.registerMetaTileEntity;

public class OrionMetaTileEntities {


    private static ContinousMetaTileEntity[] CONTINUOUS_STIRRED_TANK_REACTOR;
    private static ContinousMetaTileEntity[] TRICKLE_BED_REACTOR;

    public static void init() {

        CONTINUOUS_STIRRED_TANK_REACTOR = new ContinousMetaTileEntity[GTValues.OpV];
        TRICKLE_BED_REACTOR = new ContinousMetaTileEntity[GTValues.OpV];


        registerContinuousMTE(CONTINUOUS_STIRRED_TANK_REACTOR, 12, 12589, "continuous_stirred_tank_reactor", OrionRecipeMaps.CONTINUOUS_STIRRED_TANK_REACTOR, OrionTextures.CONTINUOUS_STIRRED_TANK_REACTOR, true, GTUtility.defaultTankSizeFunction);
        registerContinuousMTE(TRICKLE_BED_REACTOR, 12, 14567, "trickle_bed_reactor", OrionRecipeMaps.TRICKLE_BED_REACTOR, OrionTextures.TRICKLE_BED_REACTOR_OVERLAY, true, GTUtility.defaultTankSizeFunction);


    }


    public static void registerContinuousMTE(ContinousMetaTileEntity[] machines, int maxTier, int startId, String name, RecipeMap<?> map, ICubeRenderer renderer, boolean hasFrontFacing, Function<Integer, Integer> tankScalingFunction) {
        for(int i = 0; i <= maxTier; i++) {
            machines[i] = registerMetaTileEntity(startId + i, new ContinousMetaTileEntity(orionId(String.format("%s.%s", name, GTValues.VN[i + 1].toLowerCase())), map, renderer, i + 1, hasFrontFacing, tankScalingFunction));
        }
    }

    public static ResourceLocation orionId(String name) {
        return new ResourceLocation(Constellation.MODID, name);
    }
}
