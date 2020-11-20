package com.google.android.gms.internal.ads;

public final class zzbqp implements zzepf<zzbxy<zzbui>> {
    private final zzeps<zzbqo> zzfrk;
    private final zzbqq zzfwj;

    private zzbqp(zzbqq zzbqq, zzeps<zzbqo> zzeps) {
        this.zzfwj = zzbqq;
        this.zzfrk = zzeps;
    }

    public static zzbqp zza(zzbqq zzbqq, zzeps<zzbqo> zzeps) {
        return new zzbqp(zzbqq, zzeps);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.zzfrk.get(), zzazj.zzegu), "Cannot return null from a non-@Nullable @Provides method");
    }
}
