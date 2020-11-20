package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;

public final class zzbdh extends zzbcx {
    public zzbdh(zzbbe zzbbe) {
        super(zzbbe);
    }

    public final void abort() {
    }

    public final boolean zzfj(String str) {
        zzbbe zzbbe = (zzbbe) this.zzeog.get();
        if (zzbbe != null) {
            zzbbe.zza(zzfk(str), (zzbcx) this);
        }
        zzd.zzfa("VideoStreamNoopCache is doing nothing.");
        zza(str, zzfk(str), "noop", "Noop cache is a noop.");
        return false;
    }
}
