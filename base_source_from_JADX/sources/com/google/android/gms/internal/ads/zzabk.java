package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzabk {
    public static void zza(zzabi zzabi, zzabj zzabj) {
        if (zzabj.getContext() == null) {
            throw new IllegalArgumentException("Context can't be null. Please set up context in CsiConfiguration.");
        } else if (!TextUtils.isEmpty(zzabj.zzlv())) {
            zzabi.zza(zzabj.getContext(), zzabj.zzlv(), zzabj.zzrs(), zzabj.zzrt());
        } else {
            throw new IllegalArgumentException("AfmaVersion can't be null or empty. Please set up afmaVersion in CsiConfiguration.");
        }
    }
}
