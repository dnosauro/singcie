package com.google.android.gms.measurement.internal;

import android.net.Uri;

final class zzif implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ Uri zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ zzic zze;

    zzif(zzic zzic, boolean z, Uri uri, String str, String str2) {
        this.zze = zzic;
        this.zza = z;
        this.zzb = uri;
        this.zzc = str;
        this.zzd = str2;
    }

    public final void run() {
        this.zze.zza(this.zza, this.zzb, this.zzc, this.zzd);
    }
}
