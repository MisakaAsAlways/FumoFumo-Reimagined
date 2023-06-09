package com.misaka_as_always.fumofumo.common.item;

import com.misaka_as_always.fumofumo.common.item.dolls.FumoDoll;
import com.misaka_as_always.fumofumo.common.item.dolls.FumoEnum;
import com.misaka_as_always.fumofumo.register.ModItems;
import com.misaka_as_always.fumofumo.other.RandomCollection;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.ThreadLocalRandom;

public class FumoBox extends Item {
    private final FumoEnum[] MYTHICAL = {
            FumoEnum.BLUE_REIMU, FumoEnum.SMART_CIRNO, FumoEnum.PC98_MARISA,
            FumoEnum.HECATIA
    };
    private final FumoEnum[] LEGENDARY = {
            FumoEnum.FLAN, FumoEnum.UTSUHO, FumoEnum.KOISHI,
            FumoEnum.KAGUYA, FumoEnum.MOKOU, FumoEnum.NUE,
            FumoEnum.YUYUKO, FumoEnum.YUKARI
    };
    private final FumoEnum[] EPIC = {
            FumoEnum.CIRNO, FumoEnum.CLOWNPIECE, FumoEnum.SATORI,
            FumoEnum.REISEN, FumoEnum.TENSHI, FumoEnum.PATCHOULI,
            FumoEnum.YUUKA, FumoEnum.SUIKA, FumoEnum.REMILIA,
            FumoEnum.BYAKUREN, FumoEnum.DOREMY, FumoEnum.EIRIN,
            FumoEnum.KOKORO
    };
    private final FumoEnum[] RARE = {
            FumoEnum.REIMU, FumoEnum.MARISA, FumoEnum.TEWI,
            FumoEnum.SAKUYA, FumoEnum.SEIJA, FumoEnum.RAN,
            FumoEnum.YOUMU, FumoEnum.AUNN,
    };
    private final FumoEnum[] COMMON = {
            FumoEnum.AYA, FumoEnum.CHEN, FumoEnum.WAKASAGIHIME,
            FumoEnum.RUMIA, FumoEnum.HATATE, FumoEnum.PARSEE,
            FumoEnum.SHION, FumoEnum.KAGIYAMA
    };

    @NotNull
    @Override
    public ActionResult<ItemStack> use(@NotNull World world, @NotNull PlayerEntity player, @NotNull Hand hand) {
        RandomCollection<Object> fumoCategory = new RandomCollection<>()
                .add(70, COMMON).add(23, RARE).add(6.8, EPIC).add(0.19, LEGENDARY)
                .add(0.01, MYTHICAL);

        FumoEnum[] fumoEnums = (FumoEnum[]) fumoCategory.next();
        int random_int = ThreadLocalRandom.current().nextInt(0, fumoEnums.length);

        return ActionResult.success(FumoDoll.createFumo(ModItems.FUMO.get(), fumoEnums[random_int]));
    }

    public FumoBox(ItemGroup itemGroup) { super(new Properties().stacksTo(1).tab(itemGroup)); }
}
