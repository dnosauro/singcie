package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzcii implements zzbsp {
    private final zzbdv zzdii;

    zzcii(zzbdv zzbdv) {
        this.zzdii = !((Boolean) zzwq.zzqe().zzd(zzabf.zzcoh)).booleanValue() ? null : zzbdv;
    }

    public final void zzcc(Context context) {
        zzbdv zzbdv = this.zzdii;
        if (zzbdv != null) {
            zzbdv.onPause();
        }
    }

    public final void zzcd(Context context) {
        zzbdv zzbdv = this.zzdii;
        if (zzbdv != null) {
            zzbdv.onResume();
        }
    }

    public final void zzce(Context context) {
        zzbdv zzbdv = this.zzdii;
        if (zzbdv != null) {
            zzbdv.destroy();
        }
    }
}
