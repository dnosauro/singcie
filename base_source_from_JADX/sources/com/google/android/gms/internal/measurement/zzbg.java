package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzag;

final class zzbg extends zzag.zzb {
    private final /* synthetic */ zzt zzc;
    private final /* synthetic */ int zzd;
    private final /* synthetic */ zzag zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbg(zzag zzag, zzt zzt, int i) {
        super(zzag);
        this.zze = zzag;
        this.zzc = zzt;
        this.zzd = i;
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        this.zze.zzm.getTestFlag(this.zzc, this.zzd);
    }

    /* access modifiers changed from: protected */
    public final void zzb() {
        this.zzc.zza((Bundle) null);
    }
}
