package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;

final class zzra implements zzrf {
    private final /* synthetic */ Activity val$activity;

    zzra(zzqx zzqx, Activity activity) {
        this.val$activity = activity;
    }

    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityStopped(this.val$activity);
    }
}
