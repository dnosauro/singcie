package com.google.android.gms.ads.internal.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.telephony.TelephonyManager;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.ads.zzuo;

@TargetApi(26)
public class zzac extends zzz {
    public final zzuo zza(Context context, TelephonyManager telephonyManager) {
        zzp.zzkq();
        return zzm.zzp(context, "android.permission.ACCESS_NETWORK_STATE") ? telephonyManager.isDataEnabled() ? zzuo.ENUM_TRUE : zzuo.ENUM_FALSE : zzuo.ENUM_FALSE;
    }
}
