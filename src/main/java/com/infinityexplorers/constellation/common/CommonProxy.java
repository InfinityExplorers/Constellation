package com.infinityexplorers.constellation.common;

import com.infinityexplorers.constellation.Constellation;
import com.infinityexplorers.constellation.common.items.OrionMetaItems;
import com.infinityexplorers.constellation.common.recipes.OrionRecipeMaps;
import com.infinityexplorers.constellation.loaders.OrionRecipeLoader;

import gregtech.api.GregTechAPI;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = Constellation.MODID)
public class CommonProxy {

    public void preLoad() {
        OrionRecipeMaps.init();
    }

    @SubscribeEvent(priority = EventPriority.HIGH)
    public void registerMaterials(GregTechAPI.MaterialEvent event) {

    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();
        OrionMetaItems.initSubItems();


    }

    @SubscribeEvent
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event) {

        OrionRecipeLoader.init();
    }
}
