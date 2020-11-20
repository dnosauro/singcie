package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;

final class zzalq implements zzazu<zzalz> {
    private final /* synthetic */ zzalo zzdjl;

    zzalq(zzalo zzalo) {
        this.zzdjl = zzalo;
    }

    public final /* synthetic */ void zzh(Object obj) {
        zzalz zzalz = (zzalz) obj;
        zzd.zzee("Releasing engine reference.");
        this.zzdjl.zzdjj.zztw();
    }
}
