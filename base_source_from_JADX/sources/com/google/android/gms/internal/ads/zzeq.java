package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;

final class zzeq implements zzeu {
    private final /* synthetic */ Activity val$activity;

    zzeq(zzem zzem, Activity activity) {
        this.val$activity = activity;
    }

    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityPaused(this.val$activity);
    }
}
