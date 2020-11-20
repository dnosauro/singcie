package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import org.json.JSONObject;

public final class zzcbq implements zzepf<zzqr> {
    private final zzeps<zzazh> zzfrq;
    private final zzeps<String> zzfrr;

    public zzcbq(zzeps<zzazh> zzeps, zzeps<String> zzeps2) {
        this.zzfrq = zzeps;
        this.zzfrr = zzeps2;
    }

    public final /* synthetic */ Object get() {
        zzp.zzkq();
        return (zzqr) zzepl.zza(new zzqr(zzm.zzyf(), this.zzfrq.get(), this.zzfrr.get(), new JSONObject(), false, true), "Cannot return null from a non-@Nullable @Provides method");
    }
}
