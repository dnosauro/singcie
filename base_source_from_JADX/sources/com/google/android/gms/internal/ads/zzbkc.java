package com.google.android.gms.internal.ads;

import java.util.Map;

final class zzbkc implements zzahv<Object> {
    final /* synthetic */ zzbjz zzfqo;

    zzbkc(zzbjz zzbjz) {
        this.zzfqo = zzbjz;
    }

    public final void zza(Object obj, Map<String, String> map) {
        if (this.zzfqo.zzn(map)) {
            this.zzfqo.executor.execute(new zzbkb(this));
        }
    }
}
