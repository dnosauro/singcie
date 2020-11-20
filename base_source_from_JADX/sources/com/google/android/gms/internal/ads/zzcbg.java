package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;

final class zzcbg implements zzahv<Object> {
    private WeakReference<zzcbb> zzgbj;

    private zzcbg(zzcbb zzcbb) {
        this.zzgbj = new WeakReference<>(zzcbb);
    }

    public final void zza(Object obj, Map<String, String> map) {
        zzcbb zzcbb = (zzcbb) this.zzgbj.get();
        if (zzcbb != null) {
            zzcbb.zzgas.onAdClicked();
        }
    }
}
