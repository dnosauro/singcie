package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import java.io.InputStream;
import java.io.InputStreamReader;

final /* synthetic */ class zzczv implements zzdyb {
    private final zzatl zzfye;

    zzczv(zzatl zzatl) {
        this.zzfye = zzatl;
    }

    public final zzdyz zzf(Object obj) {
        return zzdyr.zzag(new zzczx(new JsonReader(new InputStreamReader((InputStream) obj))).zzn(this.zzfye.zzdvx));
    }
}
