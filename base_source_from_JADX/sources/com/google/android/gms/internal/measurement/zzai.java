package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzag;

final class zzai extends zzag.zzb {
    private final /* synthetic */ Bundle zzc;
    private final /* synthetic */ zzag zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzai(zzag zzag, Bundle bundle) {
        super(zzag);
        this.zzd = zzag;
        this.zzc = bundle;
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        this.zzd.zzm.setConditionalUserProperty(this.zzc, this.zza);
    }
}
