package com.infinityexplorers.constellation.common.recipes.catalysts;


import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;
import java.util.Objects;

public class CatalystGroup {

    public Catalysts catalystList = new Catalysts();
    public final String name;

    public CatalystGroup(@Nonnull String name) {
        this.name = name;
    }

    public void add(@Nonnull ItemStack itemStack, Catalyst catalyst) {
        if (itemStack == ItemStack.EMPTY) return;
        this.catalystList.put(itemStack, catalyst);
    }

    public String getName() {
        return name;
    }

    public Catalysts getCatalysts() {
        return catalystList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CatalystGroup that = (CatalystGroup) o;

        return Objects.equals(catalystList, that.catalystList) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(catalystList, name);
    }
}
