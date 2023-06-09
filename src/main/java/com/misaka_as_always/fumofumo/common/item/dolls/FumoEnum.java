package com.misaka_as_always.fumofumo.common.item.dolls;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.IStringSerializable;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public enum FumoEnum implements IStringSerializable {
    DEFAULT(0, "default"),
    AYA(1, "aya"),
    BLUE_REIMU(2, "blue_reimu"),
    CHEN(3, "chen"),
    CIRNO(4, "cirno"),
    CLOWNPIECE(5, "clownpiece"),
    FLAN(6, "flan"),
    HATATE(7, "hatate"),
    KAGUYA(8, "kaguya"),
    KOISHI(9, "koishi"),
    MARISA(10, "marisa"),
    MELON(11, "melon"),
    MOKOU(12, "mokou"),
    NEBULA(13, "nebula"),
    NEBUMO(14, "nebumo"),
    NUE(15, "nue"),
    PARSEE(16, "parsee"),
    PATCHOULI(17, "patchouli"),
    PC98_MARISA(18, "pc98_marisa"),
    RAN(19, "ran"),
    REIMU(20, "reimu"),
    REISEN(21, "reisen"),
    RUMIA(22, "rumia"),
    SAKUYA(23, "sakuya"),
    SATORI(24, "satori"),
    SEIJA(25, "seija"),
    SHION(26, "shion"),
    SMART_CIRNO(27, "smart_cirno"),
    SUIKA(28, "suika"),
    TENSHI(29, "tenshi"),
    TEWI(30, "tewi"),
    UTSUHO(31, "utsuho"),
    WAKASAGIHIME(32, "wakasagihime"),
    YOUMU(33, "youmu"),
    YUKARI(34, "yukari"),
    YUUKA(35, "yuuka"),
    YUYUKO(36, "yuyuko"),
    REMILIA(37, "remilia"),
    AUNN(38, "aunn"),
    BYAKUREN(39, "byakuren"),
    DOREMY(40, "doremy"),
    EIRIN(41, "eirin"),
    KOKORO(42, "kokoro"),
    KAGIYAMA(43, "kagiyama"),
    HECATIA(44, "hecatia");

    @Override
    public String toString() {
        return this.name;
    }

    public void putBasicNBT(CompoundNBT compoundNBT) {
        compoundNBT.putString("FumoType", name);
        compoundNBT.putByte("CustomModelData", nbtID);
    }

    private final byte nbtID;
    private final String name;

    FumoEnum(int i_NBT_ID, String i_name) {
        this.nbtID = (byte) i_NBT_ID;
        this.name = i_name;
    }

    public static FumoEnum fromNBT(CompoundNBT compoundNBT) {
        String fumoType = "";
        if (compoundNBT != null && compoundNBT.contains("FumoType")) {
            fumoType = compoundNBT.getString("FumoType");
        }
        Optional<FumoEnum> fumo = getFumoFromName(fumoType);
        return fumo.orElse(DEFAULT);
    }

    private static Optional<FumoEnum> getFumoFromID(byte ID) {
        for (FumoEnum fumo : FumoEnum.values()) {
            if (fumo.nbtID == ID) return Optional.of(fumo);
        }
        return Optional.empty();
    }

    private static Optional<FumoEnum> getFumoFromName(String name) {
        for (FumoEnum fumo : FumoEnum.values()) {
            if (fumo.name.equals(name)) return Optional.of(fumo);
        }
        return Optional.empty();
    }

    @Override
    public @NotNull String getSerializedName() {
        return this.name;
    }
}
