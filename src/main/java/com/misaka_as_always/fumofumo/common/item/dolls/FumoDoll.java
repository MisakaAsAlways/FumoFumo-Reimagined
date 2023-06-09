package com.misaka_as_always.fumofumo.common.item.dolls;

import com.misaka_as_always.fumofumo.common.FumoCreativeTab;
import com.misaka_as_always.fumofumo.FumoFumo;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.registries.ObjectHolder;
import org.jetbrains.annotations.NotNull;

public class FumoDoll extends Item {
    @ObjectHolder(FumoFumo.MOD_ID + ":fumo")
    public static final Item TAB_ICON = null;

    public static final ItemGroup fumoGroup = new FumoCreativeTab("fumofumo_touhou",
            () -> new ItemStack(TAB_ICON));

    @Override
    public void fillItemCategory(@NotNull ItemGroup tab, @NotNull NonNullList<ItemStack> subItems) {
        if (this.allowdedIn(tab)) {
            for (FumoEnum fumo : FumoEnum.values()) {
                if (fumo.equals(FumoEnum.DEFAULT)) { continue; }

                ItemStack itemStack = new ItemStack(this, 1);
                setFumoType(itemStack, fumo);
                subItems.add(itemStack);
            }
        }
    }

    public static ItemStack createFumo(Item item, FumoEnum fumoEnum) {
        ItemStack itemStack = new ItemStack(item);

        FumoDoll.setFumoType(itemStack, fumoEnum);

        return itemStack;
    }

    public static void setFumoType(ItemStack itemStack, FumoEnum fumoType) {
        fumoType.putBasicNBT(itemStack.getOrCreateTag());
    }

    public static FumoEnum getFumoType(ItemStack itemStack) {
        return FumoEnum.fromNBT(itemStack.getOrCreateTag());
    }

    @Override
    public @NotNull ITextComponent getName(@NotNull ItemStack stack)
    {
        String fumoTypeText = getFumoType(stack).getSerializedName();
        return new TranslationTextComponent("item." + FumoFumo.MOD_ID + "." + fumoTypeText);
    }

    public static void defaultTotemBehavior(LivingDeathEvent event, LivingEntity entity, ItemStack heldItem, boolean removeItem) {
        event.setCanceled(true);
        if (removeItem)
            heldItem.shrink(1);
        entity.setHealth(1.0F);
        entity.removeAllEffects();
        Minecraft.getInstance().particleEngine.createTrackingEmitter(entity, ParticleTypes.ENCHANT, 30);
        entity.level.playSound(null, entity.getX(), entity.getY(), entity.getZ(), SoundEvents.TOTEM_USE, SoundCategory.PLAYERS, 1.0F, 1.0F);
        entity.playSound(SoundEvents.TOTEM_USE, 1.0F, 1.0F);
    }


    public FumoDoll(Rarity rarity) {
        super(new Properties().stacksTo(1).tab(fumoGroup).rarity(rarity));
    }
}
