package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

final class zzb implements DynamiteModule.VersionPolicy.zzb {
    zzb() {
    }

    public final int zza(Context context, String str) {
        return DynamiteModule.getLocalVersion(context, str);
    }

    public final int zza(Context context, String str, boolean z) {
        return DynamiteModule.zza(context, str, z);
    }
}
