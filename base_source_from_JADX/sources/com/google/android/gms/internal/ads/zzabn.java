package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;

public final class zzabn {
    public static boolean zza(zzabs zzabs, zzabq zzabq, String... strArr) {
        if (zzabs == null || zzabq == null || !zzabs.zzczu || zzabq == null) {
            return false;
        }
        return zzabs.zza(zzabq, zzp.zzkx().elapsedRealtime(), strArr);
    }

    public static zzabq zzb(zzabs zzabs) {
        if (zzabs == null) {
            return null;
        }
        return zzabs.zzex(zzp.zzkx().elapsedRealtime());
    }
}
