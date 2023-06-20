package com.infinityexplorers.constellation.client;

import com.infinityexplorers.constellation.Constellation;
import com.infinityexplorers.constellation.common.CommonProxy;
import com.infinityexplorers.constellation.common.recipes.catalysts.Catalyst;
import com.infinityexplorers.constellation.common.recipes.catalysts.CatalystGroup;
import com.infinityexplorers.constellation.common.recipes.catalysts.CatalystGroups;
import gregtech.api.GTValues;
import gregtech.api.items.metaitem.MetaOreDictItem;
import gregtech.api.unification.OreDictUnifier;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@SideOnly(Side.CLIENT)
@Mod.EventBusSubscriber(modid = Constellation.MODID, value = Side.CLIENT)
public class ClientProxy extends CommonProxy {

    //code blatantly stolen from SuSy Core, Credits to them for making it
    @SubscribeEvent
    public static void addCatalystTooltipHandler(@Nonnull ItemTooltipEvent event) {
        ItemStack itemStack = event.getItemStack();

        Collection<String> tooltips = new ArrayList<>();

        if(itemStack.getItem() instanceof MetaOreDictItem) {
            System.out.println("oredict");
            MetaOreDictItem oreDictItem = (MetaOreDictItem) itemStack.getItem();
            Optional<String> oreDictName = OreDictUnifier.getOreDictionaryNames(itemStack).stream().findFirst();
            if(oreDictName.isPresent() && oreDictItem.OREDICT_TO_FORMULA.containsKey(oreDictName.get()) && !oreDictItem.OREDICT_TO_FORMULA.get(oreDictName.get()).isEmpty()) {
                tooltips.add(TextFormatting.YELLOW + oreDictItem.OREDICT_TO_FORMULA.get(oreDictName.get()));
            }


            event.getToolTip().addAll(tooltips);

        }
    }

}
