package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzag;

final class zzbe extends zzag.zzb {
    private final /* synthetic */ String zzc;
    private final /* synthetic */ zzt zzd;
    private final /* synthetic */ zzag zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbe(zzag zzag, String str, zzt zzt) {
        super(zzag);
        this.zze = zzag;
        this.zzc = str;
        this.zzd = zzt;
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        this.zze.zzm.getMaxUserProperties(this.zzc, this.zzd);
    }

    /* access modifiers changed from: protected */
    public final void zzb() {
        this.zzd.zza((Bundle) null);
    }
}
