package com.infinityexplorers.constellation.common.metatileentities;

import com.infinityexplorers.constellation.Constellation;
import com.infinityexplorers.constellation.common.metatileentities.multi.steam.MetaTileEntitySteamAlloySmelter;
import net.minecraft.util.ResourceLocation;

import static gregtech.common.metatileentities.MetaTileEntities.registerMetaTileEntity;

public class OrionMetaTileEntities {

    public static MetaTileEntitySteamAlloySmelter STEAM_ALLOY_SMELTER;



    public static void init() {
        STEAM_ALLOY_SMELTER = registerMetaTileEntity(14500, new MetaTileEntitySteamAlloySmelter(orionId("steam_alloy_smelter")));

    }



    public static ResourceLocation orionId(String name) {
        return new ResourceLocation(Constellation.MODID, name);
    }
}
