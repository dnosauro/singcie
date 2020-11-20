package com.google.android.gms.ads.internal.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.ads.zzabf;
import com.google.android.gms.internal.ads.zzayr;
import com.google.android.gms.internal.ads.zzwq;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;

@TargetApi(24)
public class zzz extends zzaa {
    private static boolean zze(int i, int i2, int i3) {
        return Math.abs(i - i2) <= i3;
    }

    public final boolean zza(Activity activity, Configuration configuration) {
        if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcty)).booleanValue()) {
            return false;
        }
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcua)).booleanValue()) {
            return activity.isInMultiWindowMode();
        }
        zzwq.zzqa();
        int zzc = zzayr.zzc(activity, configuration.screenHeightDp);
        int zzc2 = zzayr.zzc(activity, configuration.screenWidthDp);
        zzp.zzkq();
        DisplayMetrics zza = zzm.zza((WindowManager) activity.getApplicationContext().getSystemService("window"));
        int i = zza.heightPixels;
        int i2 = zza.widthPixels;
        int identifier = activity.getResources().getIdentifier("status_bar_height", "dimen", AbstractSpiCall.ANDROID_CLIENT_TYPE);
        int dimensionPixelSize = identifier > 0 ? activity.getResources().getDimensionPixelSize(identifier) : 0;
        int round = ((int) Math.round(((double) activity.getResources().getDisplayMetrics().density) + 0.5d)) * ((Integer) zzwq.zzqe().zzd(zzabf.zzctx)).intValue();
        return !(zze(i, zzc + dimensionPixelSize, round) && zze(i2, zzc2, round));
    }
}
