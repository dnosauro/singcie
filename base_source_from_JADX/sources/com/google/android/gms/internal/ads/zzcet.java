package com.google.android.gms.internal.ads;

import java.util.List;
import org.json.JSONObject;

final /* synthetic */ class zzcet implements zzdvm {
    private final JSONObject zzfqs;
    private final zzces zzggq;

    zzcet(zzces zzces, JSONObject jSONObject) {
        this.zzggq = zzces;
        this.zzfqs = jSONObject;
    }

    public final Object apply(Object obj) {
        return this.zzggq.zza(this.zzfqs, (List) obj);
    }
}
