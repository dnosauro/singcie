package com.google.android.gms.measurement.internal;

import android.os.Bundle;

final class zzip implements Runnable {
    private final /* synthetic */ Bundle zza;
    private final /* synthetic */ zzin zzb;
    private final /* synthetic */ zzin zzc;
    private final /* synthetic */ long zzd;
    private final /* synthetic */ zzim zze;

    zzip(zzim zzim, Bundle bundle, zzin zzin, zzin zzin2, long j) {
        this.zze = zzim;
        this.zza = bundle;
        this.zzb = zzin;
        this.zzc = zzin2;
        this.zzd = j;
    }

    public final void run() {
        this.zze.zza(this.zza, this.zzb, this.zzc, this.zzd);
    }
}
