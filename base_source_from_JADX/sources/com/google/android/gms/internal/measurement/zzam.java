package com.google.android.gms.internal.measurement;

import android.app.Activity;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzag;

final class zzam extends zzag.zzb {
    private final /* synthetic */ Activity zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ String zze;
    private final /* synthetic */ zzag zzf;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzam(zzag zzag, Activity activity, String str, String str2) {
        super(zzag);
        this.zzf = zzag;
        this.zzc = activity;
        this.zzd = str;
        this.zze = str2;
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        this.zzf.zzm.setCurrentScreen(ObjectWrapper.wrap(this.zzc), this.zzd, this.zze, this.zza);
    }
}
