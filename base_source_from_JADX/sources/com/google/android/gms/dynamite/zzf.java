package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

final class zzf implements DynamiteModule.VersionPolicy {
    zzf() {
    }

    public final DynamiteModule.VersionPolicy.zza zza(Context context, String str, DynamiteModule.VersionPolicy.zzb zzb) {
        int i;
        DynamiteModule.VersionPolicy.zza zza = new DynamiteModule.VersionPolicy.zza();
        zza.zza = zzb.zza(context, str);
        zza.zzb = zzb.zza(context, str, true);
        if (zza.zza == 0 && zza.zzb == 0) {
            i = 0;
        } else if (zza.zza >= zza.zzb) {
            i = -1;
        } else {
            zza.zzc = 1;
            return zza;
        }
        zza.zzc = i;
        return zza;
    }
}
