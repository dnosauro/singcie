package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

final class zza implements DynamiteModule.VersionPolicy {
    zza() {
    }

    public final DynamiteModule.VersionPolicy.zza zza(Context context, String str, DynamiteModule.VersionPolicy.zzb zzb) {
        DynamiteModule.VersionPolicy.zza zza = new DynamiteModule.VersionPolicy.zza();
        zza.zzb = zzb.zza(context, str, true);
        if (zza.zzb != 0) {
            zza.zzc = 1;
        } else {
            zza.zza = zzb.zza(context, str);
            if (zza.zza != 0) {
                zza.zzc = -1;
            }
        }
        return zza;
    }
}
