package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzd;

public final class zzbjt implements zzbsp {
    private final zzdoe zzfpp;

    public zzbjt(zzdoe zzdoe) {
        this.zzfpp = zzdoe;
    }

    public final void zzcc(Context context) {
        try {
            this.zzfpp.pause();
        } catch (zzdnr e) {
            zzd.zzd("Cannot invoke onPause for the mediation adapter.", e);
        }
    }

    public final void zzcd(Context context) {
        try {
            this.zzfpp.resume();
            if (context != null) {
                this.zzfpp.onContextChanged(context);
            }
        } catch (zzdnr e) {
            zzd.zzd("Cannot invoke onResume for the mediation adapter.", e);
        }
    }

    public final void zzce(Context context) {
        try {
            this.zzfpp.destroy();
        } catch (zzdnr e) {
            zzd.zzd("Cannot invoke onDestroy for the mediation adapter.", e);
        }
    }
}
