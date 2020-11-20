package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.internal.ads.zzayu;
import com.google.android.gms.internal.ads.zzazm;
import com.google.android.gms.internal.ads.zzdyz;

public final class zzb {
    public static void zzal(Context context) {
        if (zzayu.zzbu(context) && !zzayu.zzzh()) {
            zzdyz<?> zzxl = new zze(context).zzxl();
            zzd.zzez("Updating ad debug logging enablement.");
            zzazm.zza(zzxl, "AdDebugLogUpdater.updateEnablement");
        }
    }
}
