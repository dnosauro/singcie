package com.google.android.gms.internal.ads;

import org.json.JSONObject;

public final class zzccj implements zzepf<zzcch> {
    private final zzeps<JSONObject> zzeyc;
    private final zzeps<zzdmu> zzfrp;

    public zzccj(zzeps<zzdmu> zzeps, zzeps<JSONObject> zzeps2) {
        this.zzfrp = zzeps;
        this.zzeyc = zzeps2;
    }

    public final /* synthetic */ Object get() {
        return new zzcch(this.zzfrp.get(), this.zzeyc.get());
    }
}
