package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

final class zzqw implements zzrf {
    private final /* synthetic */ Activity val$activity;
    private final /* synthetic */ Bundle zzyg;

    zzqw(zzqx zzqx, Activity activity, Bundle bundle) {
        this.val$activity = activity;
        this.zzyg = bundle;
    }

    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityCreated(this.val$activity, this.zzyg);
    }
}
