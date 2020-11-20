package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzag;

final class zzaq extends zzag.zzb {
    private final /* synthetic */ long zzc;
    private final /* synthetic */ zzag zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzaq(zzag zzag, long j) {
        super(zzag);
        this.zzd = zzag;
        this.zzc = j;
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        this.zzd.zzm.setMinimumSessionDuration(this.zzc);
    }
}
