package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;

final /* synthetic */ class zzdep implements zzdvm {
    private final String zzdih;

    zzdep(String str) {
        this.zzdih = str;
    }

    public final Object apply(Object obj) {
        Throwable th = (Throwable) obj;
        String valueOf = String.valueOf(this.zzdih);
        zzd.zzey(valueOf.length() != 0 ? "Error calling adapter: ".concat(valueOf) : new String("Error calling adapter: "));
        return null;
    }
}
