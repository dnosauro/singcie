package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class zzkc implements Iterator<Map.Entry<K, V>> {
    private int zza;
    private Iterator<Map.Entry<K, V>> zzb;
    private final /* synthetic */ zzka zzc;

    private zzkc(zzka zzka) {
        this.zzc = zzka;
        this.zza = this.zzc.zzb.size();
    }

    /* synthetic */ zzkc(zzka zzka, zzjz zzjz) {
        this(zzka);
    }

    private final Iterator<Map.Entry<K, V>> zza() {
        if (this.zzb == null) {
            this.zzb = this.zzc.zzf.entrySet().iterator();
        }
        return this.zzb;
    }

    public final boolean hasNext() {
        int i = this.zza;
        return (i > 0 && i <= this.zzc.zzb.size()) || zza().hasNext();
    }

    public final /* synthetic */ Object next() {
        Object obj;
        if (zza().hasNext()) {
            obj = zza().next();
        } else {
            List zzb2 = this.zzc.zzb;
            int i = this.zza - 1;
            this.zza = i;
            obj = zzb2.get(i);
        }
        return (Map.Entry) obj;
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
