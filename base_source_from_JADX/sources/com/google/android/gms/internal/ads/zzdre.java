package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.concurrent.Callable;

public final class zzdre {
    private final E zzhnm;
    private final /* synthetic */ zzdra zzhns;

    private zzdre(zzdra zzdra, E e) {
        this.zzhns = zzdra;
        this.zzhnm = e;
    }

    private final <O> zzdrg<O> zza(Callable<O> callable, zzdzc zzdzc) {
        return new zzdrg(this.zzhns, this.zzhnm, (String) null, zzdra.zzhnp, Collections.emptyList(), zzdzc.zze(callable), (zzdqz) null);
    }

    public final zzdrg<?> zza(zzdqy zzdqy, zzdzc zzdzc) {
        return zza(new zzdrd(zzdqy), zzdzc);
    }

    public final <O> zzdrg<O> zzc(Callable<O> callable) {
        return zza(callable, this.zzhns.zzggb);
    }

    public final <O> zzdrg<O> zze(zzdyz<O> zzdyz) {
        return new zzdrg(this.zzhns, this.zzhnm, (String) null, zzdra.zzhnp, Collections.emptyList(), zzdyz, (zzdqz) null);
    }
}
