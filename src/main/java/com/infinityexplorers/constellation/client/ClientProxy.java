package com.infinityexplorers.constellation.client;

import com.infinityexplorers.constellation.Constellation;
import com.infinityexplorers.constellation.common.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
@Mod.EventBusSubscriber(modid = Constellation.MODID, value = Side.CLIENT)
public class ClientProxy extends CommonProxy {


}
