package com.google.android.gms.internal.ads;

import java.util.Map;

final class zzbke implements zzahv<Object> {
    final /* synthetic */ zzbjz zzfqo;

    zzbke(zzbjz zzbjz) {
        this.zzfqo = zzbjz;
    }

    public final void zza(Object obj, Map<String, String> map) {
        if (this.zzfqo.zzn(map)) {
            this.zzfqo.executor.execute(new zzbkd(this));
        }
    }
}
