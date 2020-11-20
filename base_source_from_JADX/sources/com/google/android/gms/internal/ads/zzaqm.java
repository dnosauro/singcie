package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;

public final class zzaqm {
    private final zzbdv zzdii;
    private final boolean zzdoy;
    private final String zzdoz;

    public zzaqm(zzbdv zzbdv, Map<String, String> map) {
        this.zzdii = zzbdv;
        this.zzdoz = map.get("forceOrientation");
        this.zzdoy = map.containsKey("allowOrientationChange") ? Boolean.parseBoolean(map.get("allowOrientationChange")) : true;
    }

    public final void execute() {
        int i;
        if (this.zzdii == null) {
            zzd.zzfa("AdWebView is null");
            return;
        }
        if ("portrait".equalsIgnoreCase(this.zzdoz)) {
            zzp.zzks();
            i = 7;
        } else if ("landscape".equalsIgnoreCase(this.zzdoz)) {
            zzp.zzks();
            i = 6;
        } else {
            i = this.zzdoy ? -1 : zzp.zzks().zzyj();
        }
        this.zzdii.setRequestedOrientation(i);
    }
}
