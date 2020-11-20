package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzf;
import java.util.Map;

public final class zzbjs implements zzbjn {
    private zzf zzebt;

    public zzbjs(zzf zzf) {
        this.zzebt = zzf;
    }

    public final void zzm(Map<String, String> map) {
        this.zzebt.zzap(Boolean.parseBoolean(map.get("content_vertical_opted_out")));
    }
}
