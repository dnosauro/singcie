package com.google.android.gms.internal.measurement;

import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzeq extends zzeh<K, V> {
    @NullableDecl
    private final K zza;
    private int zzb;
    private final /* synthetic */ zzel zzc;

    zzeq(zzel zzel, int i) {
        this.zzc = zzel;
        this.zza = zzel.zzb[i];
        this.zzb = i;
    }

    private final void zza() {
        int i = this.zzb;
        if (i == -1 || i >= this.zzc.size() || !zzdu.zza(this.zza, this.zzc.zzb[this.zzb])) {
            this.zzb = this.zzc.zza((Object) this.zza);
        }
    }

    @NullableDecl
    public final K getKey() {
        return this.zza;
    }

    @NullableDecl
    public final V getValue() {
        Map zzb2 = this.zzc.zzb();
        if (zzb2 != null) {
            return zzb2.get(this.zza);
        }
        zza();
        if (this.zzb == -1) {
            return null;
        }
        return this.zzc.zzc[this.zzb];
    }

    public final V setValue(V v) {
        Map zzb2 = this.zzc.zzb();
        if (zzb2 != null) {
            return zzb2.put(this.zza, v);
        }
        zza();
        if (this.zzb == -1) {
            this.zzc.put(this.zza, v);
            return null;
        }
        V v2 = this.zzc.zzc[this.zzb];
        this.zzc.zzc[this.zzb] = v;
        return v2;
    }
}
