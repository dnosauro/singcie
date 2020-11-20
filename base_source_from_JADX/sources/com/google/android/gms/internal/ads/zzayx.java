package com.google.android.gms.internal.ads;

import android.util.JsonWriter;
import java.util.Map;

final /* synthetic */ class zzayx implements zzazb {
    private final String zzdha;
    private final Map zzdie;
    private final String zzdih;
    private final byte[] zzegj;

    zzayx(String str, String str2, Map map, byte[] bArr) {
        this.zzdih = str;
        this.zzdha = str2;
        this.zzdie = map;
        this.zzegj = bArr;
    }

    public final void zzb(JsonWriter jsonWriter) {
        zzayu.zza(this.zzdih, this.zzdha, this.zzdie, this.zzegj, jsonWriter);
    }
}
