package com.infinityexplorers.constellation.common.recipes.catalysts;

import gregtech.api.util.ItemStackHashStrategy;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenCustomHashMap;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;
import java.util.Map;
import java.util.stream.Stream;

public class Catalysts {

    private final Map<ItemStack, Catalyst> map = new Object2ObjectOpenCustomHashMap<>(ItemStackHashStrategy.comparingAllButCount());

    public void put(@Nonnull ItemStack itemStack, @Nonnull Catalyst catalyst) {
        this.map.put(itemStack, catalyst);
    }

    public Catalyst get(@Nonnull ItemStack itemStack) {
        this.map.get(itemStack);
    }

    public Stream<Map.Entry<ItemStack, Catalyst>> streamEntries() {
        return map.entrySet().stream();
    }
}

