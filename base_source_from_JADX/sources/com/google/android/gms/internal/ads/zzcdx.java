package com.google.android.gms.internal.ads;

import androidx.p018c.C0400a;

public final class zzcdx implements zzbsm {
    private final zzcce zzgaq;
    private final zzcci zzgbv;

    public zzcdx(zzcce zzcce, zzcci zzcci) {
        this.zzgaq = zzcce;
        this.zzgbv = zzcci;
    }

    public final void onAdImpression() {
        if (this.zzgaq.zzanj() != null) {
            zzbdv zzani = this.zzgaq.zzani();
            zzbdv zzanh = this.zzgaq.zzanh();
            if (zzani == null) {
                zzani = zzanh != null ? zzanh : null;
            }
            if (this.zzgbv.zzamy() && zzani != null) {
                zzani.zza("onSdkImpression", new C0400a());
            }
        }
    }
}
