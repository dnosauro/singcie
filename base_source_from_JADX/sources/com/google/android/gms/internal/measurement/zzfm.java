package com.google.android.gms.internal.measurement;

import java.util.AbstractMap;
import java.util.Map;

final class zzfm extends zzew<Map.Entry<K, V>> {
    private final /* synthetic */ zzfn zza;

    zzfm(zzfn zzfn) {
        this.zza = zzfn;
    }

    public final /* synthetic */ Object get(int i) {
        zzdw.zza(i, this.zza.zzd);
        int i2 = i * 2;
        return new AbstractMap.SimpleImmutableEntry(this.zza.zzb[i2], this.zza.zzb[i2 + 1]);
    }

    public final int size() {
        return this.zza.zzd;
    }

    public final boolean zzg() {
        return true;
    }
}
