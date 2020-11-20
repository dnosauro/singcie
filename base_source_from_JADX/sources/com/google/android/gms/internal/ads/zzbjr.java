package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

public final class zzbjr implements zzbjn {
    private final zzdms zzfpo;

    public zzbjr(zzdms zzdms) {
        this.zzfpo = zzdms;
    }

    public final void zzm(Map<String, String> map) {
        String str = map.get("render_in_browser");
        if (!TextUtils.isEmpty(str)) {
            try {
                this.zzfpo.zzbm(Boolean.parseBoolean(str));
            } catch (Exception unused) {
                throw new IllegalStateException("Invalid render_in_browser state");
            }
        }
    }
}
