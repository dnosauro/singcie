package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzag;

final class zzap extends zzag.zzb {
    private final /* synthetic */ Boolean zzc;
    private final /* synthetic */ zzag zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzap(zzag zzag, Boolean bool) {
        super(zzag);
        this.zzd = zzag;
        this.zzc = bool;
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        if (this.zzc != null) {
            this.zzd.zzm.setMeasurementEnabled(this.zzc.booleanValue(), this.zza);
        } else {
            this.zzd.zzm.clearMeasurementEnabled(this.zza);
        }
    }
}
