package com.google.android.gms.ads.internal.util;

import android.util.Log;
import com.google.ads.AdRequest;
import com.google.android.gms.internal.ads.zzada;
import com.google.android.gms.internal.ads.zzaza;

public final class zzd extends zzaza {
    public static void zza(String str, Throwable th) {
        if (zzxn()) {
            Log.v(AdRequest.LOGTAG, str, th);
        }
    }

    public static void zzee(String str) {
        if (zzxn()) {
            Log.v(AdRequest.LOGTAG, str);
        }
    }

    public static boolean zzxn() {
        return isLoggable(2) && zzada.zzdcs.get().booleanValue();
    }
}
