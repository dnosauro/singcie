package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;

final class zzcgt<T> implements zzahv<Object> {
    private final WeakReference<T> zzghv;
    private final String zzghw;
    private final zzahv<T> zzghx;
    private final /* synthetic */ zzcgh zzghy;

    private zzcgt(zzcgh zzcgh, WeakReference<T> weakReference, String str, zzahv<T> zzahv) {
        this.zzghy = zzcgh;
        this.zzghv = weakReference;
        this.zzghw = str;
        this.zzghx = zzahv;
    }

    /* synthetic */ zzcgt(zzcgh zzcgh, WeakReference weakReference, String str, zzahv zzahv, zzcgm zzcgm) {
        this(zzcgh, weakReference, str, zzahv);
    }

    public final void zza(Object obj, Map<String, String> map) {
        Object obj2 = this.zzghv.get();
        if (obj2 == null) {
            this.zzghy.zzb(this.zzghw, this);
        } else {
            this.zzghx.zza(obj2, map);
        }
    }
}
