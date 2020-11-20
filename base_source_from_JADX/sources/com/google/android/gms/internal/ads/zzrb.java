package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;

final class zzrb implements zzrf {
    private final /* synthetic */ Activity val$activity;

    zzrb(zzqx zzqx, Activity activity) {
        this.val$activity = activity;
    }

    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityPaused(this.val$activity);
    }
}
