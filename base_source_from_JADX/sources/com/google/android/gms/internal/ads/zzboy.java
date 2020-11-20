package com.google.android.gms.internal.ads;

public final class zzboy implements zzepf<zzbov> {
    private final zzeps<zzbsu> zzeyy;

    private zzboy(zzeps<zzbsu> zzeps) {
        this.zzeyy = zzeps;
    }

    public static zzboy zze(zzeps<zzbsu> zzeps) {
        return new zzboy(zzeps);
    }

    public final /* synthetic */ Object get() {
        return new zzbov(this.zzeyy.get());
    }
}
