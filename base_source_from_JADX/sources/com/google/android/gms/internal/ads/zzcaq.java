package com.google.android.gms.internal.ads;

import java.util.Map;

public final class zzcaq implements zzepf<zzcan> {
    private final zzeps<zzccl> zzftk;
    private final zzeps<Map<String, zzcqz<zzboi>>> zzfuw;
    private final zzeps<zzbod<zzbme>> zzgah;
    private final zzeps<Map<String, zzcqz<zzcbt>>> zzgaj;
    private final zzeps<Map<String, zzcto<zzcbt>>> zzgak;

    public zzcaq(zzeps<Map<String, zzcqz<zzboi>>> zzeps, zzeps<Map<String, zzcqz<zzcbt>>> zzeps2, zzeps<Map<String, zzcto<zzcbt>>> zzeps3, zzeps<zzbod<zzbme>> zzeps4, zzeps<zzccl> zzeps5) {
        this.zzfuw = zzeps;
        this.zzgaj = zzeps2;
        this.zzgak = zzeps3;
        this.zzgah = zzeps4;
        this.zzftk = zzeps5;
    }

    public final /* synthetic */ Object get() {
        return new zzcan(this.zzfuw.get(), this.zzgaj.get(), this.zzgak.get(), this.zzgah, this.zzftk.get());
    }
}
