package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import org.json.JSONObject;

public final class zzbko implements zzepf<zzqr> {
    private final zzeps<JSONObject> zzeyf;
    private final zzeps<zzdmu> zzfrp;
    private final zzeps<zzazh> zzfrq;
    private final zzeps<String> zzfrr;

    private zzbko(zzeps<zzdmu> zzeps, zzeps<zzazh> zzeps2, zzeps<JSONObject> zzeps3, zzeps<String> zzeps4) {
        this.zzfrp = zzeps;
        this.zzfrq = zzeps2;
        this.zzeyf = zzeps3;
        this.zzfrr = zzeps4;
    }

    public static zzbko zza(zzeps<zzdmu> zzeps, zzeps<zzazh> zzeps2, zzeps<JSONObject> zzeps3, zzeps<String> zzeps4) {
        return new zzbko(zzeps, zzeps2, zzeps3, zzeps4);
    }

    public final /* synthetic */ Object get() {
        zzdmu zzdmu = this.zzfrp.get();
        String str = this.zzfrr.get();
        boolean equals = "native".equals(str);
        zzp.zzkq();
        return (zzqr) zzepl.zza(new zzqr(zzm.zzyf(), this.zzfrq.get(), str, this.zzeyf.get(), false, equals), "Cannot return null from a non-@Nullable @Provides method");
    }
}
