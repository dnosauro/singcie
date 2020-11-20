package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzf;
import java.util.Map;

public final class zzbjq implements zzbjn {
    private zzf zzebt;

    public zzbjq(zzf zzf) {
        this.zzebt = zzf;
    }

    public final void zzm(Map<String, String> map) {
        this.zzebt.zzao(Boolean.parseBoolean(map.get("content_url_opted_out")));
    }
}
