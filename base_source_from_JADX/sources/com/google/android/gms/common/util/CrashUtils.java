package com.google.android.gms.common.util;

import android.content.Context;
import android.os.DropBoxManager;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import javax.annotation.concurrent.GuardedBy;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

@KeepForSdk
public final class CrashUtils {
    private static final String[] zza = {"android.", "com.android.", "dalvik.", "java.", "javax."};
    private static DropBoxManager zzb = null;
    private static boolean zzc = false;
    private static int zzd = -1;
    @GuardedBy("CrashUtils.class")
    private static int zze = 0;
    @GuardedBy("CrashUtils.class")
    private static int zzf = 0;

    @KeepForSdk
    public static boolean addDynamiteErrorToDropBox(Context context, Throwable th) {
        return zza(context, th, PKIFailureInfo.duplicateCertReq);
    }

    private static boolean zza(Context context, Throwable th, int i) {
        try {
            Preconditions.checkNotNull(context);
            Preconditions.checkNotNull(th);
            return false;
        } catch (Exception e) {
            Log.e("CrashUtils", "Error adding exception to DropBox!", e);
            return false;
        }
    }
}
