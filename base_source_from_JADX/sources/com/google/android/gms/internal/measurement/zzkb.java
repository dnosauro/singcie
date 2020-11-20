package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

final class zzkb extends zzkh {
    private final /* synthetic */ zzka zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zzkb(zzka zzka) {
        super(zzka, (zzjz) null);
        this.zza = zzka;
    }

    /* synthetic */ zzkb(zzka zzka, zzjz zzjz) {
        this(zzka);
    }

    public final Iterator<Map.Entry<K, V>> iterator() {
        return new zzkc(this.zza, (zzjz) null);
    }
}
