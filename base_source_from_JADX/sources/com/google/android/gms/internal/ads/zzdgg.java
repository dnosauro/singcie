package com.google.android.gms.internal.ads;

import android.content.Context;
import org.json.JSONObject;

public final class zzdgg implements zzdfi<zzdgh> {
    private final Context context;
    private final String packageName;
    private final zzdzc zzggb;
    private final zzato zzhcd;

    public zzdgg(zzato zzato, Context context2, String str, zzdzc zzdzc) {
        this.zzhcd = zzato;
        this.context = context2;
        this.packageName = str;
        this.zzggb = zzdzc;
    }

    public final zzdyz<zzdgh> zzasm() {
        return this.zzggb.zze(new zzdgj(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdgh zzath() {
        JSONObject jSONObject = new JSONObject();
        zzato zzato = this.zzhcd;
        if (zzato != null) {
            zzato.zza(this.context, this.packageName, jSONObject);
        }
        return new zzdgh(jSONObject);
    }
}
