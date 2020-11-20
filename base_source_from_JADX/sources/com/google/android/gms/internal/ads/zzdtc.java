package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzcf;

@VisibleForTesting
final class zzdtc implements zzdtb {
    private static final zzcf.zza zzhql = ((zzcf.zza) ((zzekh) zzcf.zza.zzaq().zzv("E").zzbhv()));

    zzdtc() {
    }

    public final zzcf.zza zzaxi() {
        return zzhql;
    }

    public final zzcf.zza zzcm(Context context) {
        return zzdsp.zzj(context, context.getPackageName(), Integer.toString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode));
    }
}
