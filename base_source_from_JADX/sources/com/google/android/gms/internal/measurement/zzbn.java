package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzag;

final class zzbn extends zzag.zzb {
    private final /* synthetic */ Long zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ String zze;
    private final /* synthetic */ Bundle zzf;
    private final /* synthetic */ boolean zzg;
    private final /* synthetic */ boolean zzh;
    private final /* synthetic */ zzag zzi;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbn(zzag zzag, Long l, String str, String str2, Bundle bundle, boolean z, boolean z2) {
        super(zzag);
        this.zzi = zzag;
        this.zzc = l;
        this.zzd = str;
        this.zze = str2;
        this.zzf = bundle;
        this.zzg = z;
        this.zzh = z2;
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        Long l = this.zzc;
        this.zzi.zzm.logEvent(this.zzd, this.zze, this.zzf, this.zzg, this.zzh, l == null ? this.zza : l.longValue());
    }
}
