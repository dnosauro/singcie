package com.google.android.gms.internal.ads;

import org.json.JSONObject;

final /* synthetic */ class zzbkh implements Runnable {
    private final zzbdv zzesw;
    private final JSONObject zzfqs;

    zzbkh(zzbdv zzbdv, JSONObject jSONObject) {
        this.zzesw = zzbdv;
        this.zzfqs = jSONObject;
    }

    public final void run() {
        this.zzesw.zza("AFMA_updateActiveView", this.zzfqs);
    }
}
