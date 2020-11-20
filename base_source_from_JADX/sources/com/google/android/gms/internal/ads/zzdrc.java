package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Callable;

public final class zzdrc {
    private final E zzhnm;
    private final List<zzdyz<?>> zzhnr;
    private final /* synthetic */ zzdra zzhns;

    private zzdrc(zzdra zzdra, E e, List<zzdyz<?>> list) {
        this.zzhns = zzdra;
        this.zzhnm = e;
        this.zzhnr = list;
    }

    public final <O> zzdrg<O> zzb(Callable<O> callable) {
        zzdys<V> zzk = zzdyr.zzk(this.zzhnr);
        zzdyz<C> zza = zzk.zza(zzdrb.zzgzz, zzazj.zzegu);
        zzdra zzdra = this.zzhns;
        return new zzdrg(zzdra, this.zzhnm, (String) null, zza, this.zzhnr, zzk.zza(callable, zzdra.zzggb), (zzdqz) null);
    }
}
