package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import org.json.JSONObject;

final /* synthetic */ class zzcot implements Callable {
    private final zzdyz zzfxh;
    private final zzdyz zzggs;

    zzcot(zzdyz zzdyz, zzdyz zzdyz2) {
        this.zzggs = zzdyz;
        this.zzfxh = zzdyz2;
    }

    public final Object call() {
        return new zzcpm((JSONObject) this.zzggs.get(), (zzatr) this.zzfxh.get());
    }
}
