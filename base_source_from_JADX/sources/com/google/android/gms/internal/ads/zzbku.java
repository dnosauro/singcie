package com.google.android.gms.internal.ads;

import org.json.JSONObject;

final /* synthetic */ class zzbku implements Runnable {
    private final JSONObject zzfqs;
    private final zzbkr zzfrt;

    zzbku(zzbkr zzbkr, JSONObject jSONObject) {
        this.zzfrt = zzbkr;
        this.zzfqs = jSONObject;
    }

    public final void run() {
        this.zzfrt.zzi(this.zzfqs);
    }
}
