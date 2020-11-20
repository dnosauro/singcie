package com.google.android.gms.internal.ads;

import org.json.JSONObject;

public final class zzbkw implements zzepf<JSONObject> {
    private final zzeps<zzdmu> zzfrp;

    private zzbkw(zzeps<zzdmu> zzeps) {
        this.zzfrp = zzeps;
    }

    public static zzbkw zzc(zzeps<zzdmu> zzeps) {
        return new zzbkw(zzeps);
    }

    public final /* synthetic */ Object get() {
        return zzbkt.zza(this.zzfrp.get());
    }
}
