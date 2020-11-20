package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzmb;
import java.util.concurrent.Callable;

final class zzks implements Callable<String> {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ zzkp zzb;

    zzks(zzkp zzkp, zzn zzn) {
        this.zzb = zzkp;
        this.zza = zzn;
    }

    public final /* synthetic */ Object call() {
        zzez zzh;
        String str;
        if (!zzmb.zzb() || !this.zzb.zzb().zza(zzat.zzcp) || (this.zzb.zza(this.zza.zza).zze() && zzad.zza(this.zza.zzw).zze())) {
            zzf zzc = this.zzb.zzc(this.zza);
            if (zzc != null) {
                return zzc.zzd();
            }
            zzh = this.zzb.zzq().zzh();
            str = "App info was null when attempting to get app instance id";
        } else {
            zzh = this.zzb.zzq().zzw();
            str = "Analytics storage consent denied. Returning null app instance id";
        }
        zzh.zza(str);
        return null;
    }
}
