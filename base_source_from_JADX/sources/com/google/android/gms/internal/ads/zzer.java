package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;

final class zzer implements zzeu {
    private final /* synthetic */ Activity val$activity;

    zzer(zzem zzem, Activity activity) {
        this.val$activity = activity;
    }

    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityDestroyed(this.val$activity);
    }
}
