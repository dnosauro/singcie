package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzag;
import com.google.android.gms.measurement.internal.zzhd;

final class zzbf extends zzag.zzb {
    private final /* synthetic */ zzhd zzc;
    private final /* synthetic */ zzag zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbf(zzag zzag, zzhd zzhd) {
        super(zzag);
        this.zzd = zzag;
        this.zzc = zzhd;
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        this.zzd.zzm.setEventInterceptor(new zzag.zza(this.zzc));
    }
}
