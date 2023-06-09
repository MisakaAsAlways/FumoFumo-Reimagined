package com.misaka_as_always.fumofumo.common.item.dolls;

import com.misaka_as_always.fumofumo.FumoFumo;
import com.misaka_as_always.fumofumo.common.FumoCreativeTab;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.registries.ObjectHolder;

public class FumoSkin extends Item {
    @ObjectHolder(FumoFumo.MOD_ID)
    public static class Items {
        public static final Item FAIRICH = null;
    }
    public static final ItemGroup fumoGroup = new FumoCreativeTab("fumofumo_user",
            () -> new ItemStack(Items.FAIRICH));

    public FumoSkin() {
        super(new Item.Properties().stacksTo(1).tab(fumoGroup));
    }
}
