package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzag;

final class zzal extends zzag.zzb {
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ Bundle zze;
    private final /* synthetic */ zzag zzf;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzal(zzag zzag, String str, String str2, Bundle bundle) {
        super(zzag);
        this.zzf = zzag;
        this.zzc = str;
        this.zzd = str2;
        this.zze = bundle;
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        this.zzf.zzm.clearConditionalUserProperty(this.zzc, this.zzd, this.zze);
    }
}
