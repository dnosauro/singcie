package com.google.android.gms.common.wrappers;

import android.content.Context;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;

@KeepForSdk
public class InstantApps {
    private static Context zza;
    private static Boolean zzb;

    @KeepForSdk
    public static synchronized boolean isInstantApp(Context context) {
        boolean z;
        synchronized (InstantApps.class) {
            Context applicationContext = context.getApplicationContext();
            if (zza == null || zzb == null || zza != applicationContext) {
                zzb = null;
                if (PlatformVersion.isAtLeastO()) {
                    z = Boolean.valueOf(applicationContext.getPackageManager().isInstantApp());
                } else {
                    try {
                        context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                        zzb = true;
                    } catch (ClassNotFoundException unused) {
                        z = false;
                    }
                    zza = applicationContext;
                    boolean booleanValue = zzb.booleanValue();
                    return booleanValue;
                }
                zzb = z;
                zza = applicationContext;
                boolean booleanValue2 = zzb.booleanValue();
                return booleanValue2;
            }
            boolean booleanValue3 = zzb.booleanValue();
            return booleanValue3;
        }
    }
}
