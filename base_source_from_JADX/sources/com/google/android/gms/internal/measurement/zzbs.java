package com.google.android.gms.internal.measurement;

import android.app.Activity;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzag;

final class zzbs extends zzag.zzb {
    private final /* synthetic */ Activity zzc;
    private final /* synthetic */ zzt zzd;
    private final /* synthetic */ zzag.zzc zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbs(zzag.zzc zzc2, Activity activity, zzt zzt) {
        super(zzag.this);
        this.zze = zzc2;
        this.zzc = activity;
        this.zzd = zzt;
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        zzag.this.zzm.onActivitySaveInstanceState(ObjectWrapper.wrap(this.zzc), this.zzd, this.zzb);
    }
}
