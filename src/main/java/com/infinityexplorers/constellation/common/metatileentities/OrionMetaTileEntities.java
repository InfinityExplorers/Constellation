package com.infinityexplorers.constellation.common.metatileentities;

import com.infinityexplorers.constellation.Constellation;
import com.infinityexplorers.constellation.common.metatileentities.multi.primitive.MetaTileEntityPrimitveAlloySmelter;
import net.minecraft.util.ResourceLocation;

import static gregtech.common.metatileentities.MetaTileEntities.registerMetaTileEntity;

public class OrionMetaTileEntities {

    public static MetaTileEntityPrimitveAlloySmelter PRIMITIVE_ALLOY_SMELTER;



    public static void init() {
        PRIMITIVE_ALLOY_SMELTER = registerMetaTileEntity(14500, new MetaTileEntityPrimitveAlloySmelter(orionId("primtive_alloy_smelter")));

    }



    public static ResourceLocation orionId(String name) {
        return new ResourceLocation(Constellation.MODID, name);
    }
}
