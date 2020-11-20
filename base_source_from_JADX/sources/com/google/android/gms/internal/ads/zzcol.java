package com.google.android.gms.internal.ads;

import java.io.InputStream;

final /* synthetic */ class zzcol implements zzdyb {
    private final zzatl zzfye;

    zzcol(zzatl zzatl) {
        this.zzfye = zzatl;
    }

    public final zzdyz zzf(Object obj) {
        zzatl zzatl = this.zzfye;
        zzatl.zzdwb = new String(zzdxj.toByteArray((InputStream) obj), zzdvk.UTF_8);
        return zzdyr.zzag(zzatl);
    }
}
