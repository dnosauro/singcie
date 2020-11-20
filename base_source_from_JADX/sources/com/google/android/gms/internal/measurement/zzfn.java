package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

final class zzfn<K, V> extends zzff<Map.Entry<K, V>> {
    private final transient zzfb<K, V> zza;
    /* access modifiers changed from: private */
    public final transient Object[] zzb;
    private final transient int zzc = 0;
    /* access modifiers changed from: private */
    public final transient int zzd;

    zzfn(zzfb<K, V> zzfb, Object[] objArr, int i, int i2) {
        this.zza = zzfb;
        this.zzb = objArr;
        this.zzd = i2;
    }

    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            return value != null && value.equals(this.zza.get(key));
        }
    }

    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }

    public final int size() {
        return this.zzd;
    }

    /* access modifiers changed from: package-private */
    public final int zzb(Object[] objArr, int i) {
        return zzc().zzb(objArr, i);
    }

    public final zzfs<Map.Entry<K, V>> zzb() {
        return (zzfs) zzc().iterator();
    }

    /* access modifiers changed from: package-private */
    public final boolean zzg() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public final zzew<Map.Entry<K, V>> zzh() {
        return new zzfm(this);
    }
}
