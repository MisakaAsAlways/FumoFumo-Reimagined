package com.misaka_as_always.fumofumo.common.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemTier;
import net.minecraft.item.SwordItem;

public class Gohei extends SwordItem {
    public Gohei(ItemGroup itemGroup) { super(ItemTier.DIAMOND, 3, 1.7F,
            new Properties().stacksTo(1).durability(250).tab(itemGroup)); }
}
