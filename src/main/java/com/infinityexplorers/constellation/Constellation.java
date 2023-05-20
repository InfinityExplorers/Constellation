package com.infinityexplorers.constellation;

import com.infinityexplorers.constellation.common.CommonProxy;
import com.infinityexplorers.constellation.common.metatileentities.OrionMetaTileEntities;
import gregtech.api.GregTechAPI;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(name = Constellation.NAME, modid = Constellation.MODID, dependencies = "required-after:gcym")
public class Constellation {

    public static final String NAME = "Constellation";
    public static final String MODID = "constellation";

    @SidedProxy(modId = MODID, clientSide = "com.infinityexplorers.constellation.client.ClientProxy", serverSide = "constellation.common.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preLoad();

        OrionMetaTileEntities.init();
    }
}
