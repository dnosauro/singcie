package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import org.json.JSONObject;

final /* synthetic */ class zzcow implements Callable {
    private final zzdyz zzfvd;
    private final zzdyz zzfxh;
    private final zzdyz zzggs;

    zzcow(zzdyz zzdyz, zzdyz zzdyz2, zzdyz zzdyz3) {
        this.zzggs = zzdyz;
        this.zzfxh = zzdyz2;
        this.zzfvd = zzdyz3;
    }

    public final Object call() {
        return new zzcpi((zzcpl) this.zzggs.get(), (JSONObject) this.zzfxh.get(), (zzatr) this.zzfvd.get());
    }
}
