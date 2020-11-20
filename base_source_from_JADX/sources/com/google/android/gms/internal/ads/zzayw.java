package com.google.android.gms.internal.ads;

import android.util.JsonWriter;
import java.util.Map;

final /* synthetic */ class zzayw implements zzazb {
    private final int zzegh;
    private final Map zzegi;

    zzayw(int i, Map map) {
        this.zzegh = i;
        this.zzegi = map;
    }

    public final void zzb(JsonWriter jsonWriter) {
        zzayu.zza(this.zzegh, this.zzegi, jsonWriter);
    }
}
