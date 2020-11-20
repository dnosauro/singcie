package com.google.android.gms.internal.common;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;

public final class zzm {
    private static volatile boolean zza = (!zza());
    private static boolean zzb = false;

    @TargetApi(24)
    public static Context zza(Context context) {
        return context.isDeviceProtectedStorage() ? context : context.createDeviceProtectedStorageContext();
    }

    public static boolean zza() {
        return Build.VERSION.SDK_INT >= 24;
    }
}
