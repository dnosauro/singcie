package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

final class zzd implements DynamiteModule.VersionPolicy {
    zzd() {
    }

    public final DynamiteModule.VersionPolicy.zza zza(Context context, String str, DynamiteModule.VersionPolicy.zzb zzb) {
        DynamiteModule.VersionPolicy.zza zza = new DynamiteModule.VersionPolicy.zza();
        zza.zza = zzb.zza(context, str);
        if (zza.zza != 0) {
            zza.zzc = -1;
        } else {
            zza.zzb = zzb.zza(context, str, true);
            if (zza.zzb != 0) {
                zza.zzc = 1;
            }
        }
        return zza;
    }
}
