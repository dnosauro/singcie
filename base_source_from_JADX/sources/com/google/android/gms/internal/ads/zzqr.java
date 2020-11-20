package com.google.android.gms.internal.ads;

import org.json.JSONObject;

public final class zzqr {
    private final String zzbrc;
    private final JSONObject zzbrd;
    private final String zzbre;
    private final String zzbrf;
    private final boolean zzbrg = false;
    private final boolean zzbrh;

    public zzqr(String str, zzazh zzazh, String str2, JSONObject jSONObject, boolean z, boolean z2) {
        this.zzbrf = zzazh.zzbrf;
        this.zzbrd = jSONObject;
        this.zzbre = str;
        this.zzbrc = str2;
        this.zzbrh = z2;
    }

    public final String getUniqueId() {
        return this.zzbre;
    }

    public final boolean isNative() {
        return this.zzbrh;
    }

    public final String zzlu() {
        return this.zzbrc;
    }

    public final String zzlv() {
        return this.zzbrf;
    }

    public final JSONObject zzlw() {
        return this.zzbrd;
    }
}
