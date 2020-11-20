package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

final class zzes implements zzeu {
    private final /* synthetic */ Activity val$activity;
    private final /* synthetic */ Bundle zzyg;

    zzes(zzem zzem, Activity activity, Bundle bundle) {
        this.val$activity = activity;
        this.zzyg = bundle;
    }

    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivitySaveInstanceState(this.val$activity, this.zzyg);
    }
}
