package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzddg implements zzdfj<Bundle> {
    private final zzdms zzfpo;

    public zzddg(zzdms zzdms) {
        this.zzfpo = zzdms;
    }

    public final /* synthetic */ void zzs(Object obj) {
        Bundle bundle = (Bundle) obj;
        zzdms zzdms = this.zzfpo;
        if (zzdms != null) {
            bundle.putBoolean("render_in_browser", zzdms.zzaui());
            bundle.putBoolean("disable_ml", this.zzfpo.zzauj());
        }
    }
}
