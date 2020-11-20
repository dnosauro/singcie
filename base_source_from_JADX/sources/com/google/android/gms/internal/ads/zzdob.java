package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;

public final class zzdob {
    public static void zza(int i, Throwable th, String str) {
        StringBuilder sb = new StringBuilder(31);
        sb.append("Ad failed to load : ");
        sb.append(i);
        zzd.zzez(sb.toString());
        zzd.zza(str, th);
        if (i != 3) {
            zzp.zzku().zzb(th, str);
        }
    }

    public static void zze(Context context, boolean z) {
        String sb;
        if (z) {
            sb = "This request is sent from a test device.";
        } else {
            zzwq.zzqa();
            String zzbn = zzayr.zzbn(context);
            StringBuilder sb2 = new StringBuilder(String.valueOf(zzbn).length() + 101);
            sb2.append("Use RequestConfiguration.Builder().setTestDeviceIds(Arrays.asList(\"");
            sb2.append(zzbn);
            sb2.append("\") to get test ads on this device.");
            sb = sb2.toString();
        }
        zzd.zzez(sb);
    }
}
