package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

final class zzki implements Iterator<Map.Entry<K, V>> {
    private int zza;
    private boolean zzb;
    private Iterator<Map.Entry<K, V>> zzc;
    private final /* synthetic */ zzka zzd;

    private zzki(zzka zzka) {
        this.zzd = zzka;
        this.zza = -1;
    }

    /* synthetic */ zzki(zzka zzka, zzjz zzjz) {
        this(zzka);
    }

    private final Iterator<Map.Entry<K, V>> zza() {
        if (this.zzc == null) {
            this.zzc = this.zzd.zzc.entrySet().iterator();
        }
        return this.zzc;
    }

    public final boolean hasNext() {
        return this.zza + 1 < this.zzd.zzb.size() || (!this.zzd.zzc.isEmpty() && zza().hasNext());
    }

    public final /* synthetic */ Object next() {
        this.zzb = true;
        int i = this.zza + 1;
        this.zza = i;
        return (Map.Entry) (i < this.zzd.zzb.size() ? this.zzd.zzb.get(this.zza) : zza().next());
    }

    public final void remove() {
        if (this.zzb) {
            this.zzb = false;
            this.zzd.zzf();
            if (this.zza < this.zzd.zzb.size()) {
                zzka zzka = this.zzd;
                int i = this.zza;
                this.zza = i - 1;
                Object unused = zzka.zzc(i);
                return;
            }
            zza().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }
}
