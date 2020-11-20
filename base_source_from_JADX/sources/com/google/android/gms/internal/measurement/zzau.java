package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzag;

final class zzau extends zzag.zzb {
    private final /* synthetic */ String zzc;
    private final /* synthetic */ zzag zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzau(zzag zzag, String str) {
        super(zzag);
        this.zzd = zzag;
        this.zzc = str;
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        this.zzd.zzm.endAdUnitExposure(this.zzc, this.zzb);
    }
}
