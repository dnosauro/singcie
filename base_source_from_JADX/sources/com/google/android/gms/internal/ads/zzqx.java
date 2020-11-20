package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zzd;
import java.lang.ref.WeakReference;

final class zzqx implements Application.ActivityLifecycleCallbacks {
    private final Application zzyh;
    private final WeakReference<Application.ActivityLifecycleCallbacks> zzyi;
    private boolean zzyj = false;

    public zzqx(Application application, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.zzyi = new WeakReference<>(activityLifecycleCallbacks);
        this.zzyh = application;
    }

    private final void zza(zzrf zzrf) {
        try {
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = (Application.ActivityLifecycleCallbacks) this.zzyi.get();
            if (activityLifecycleCallbacks != null) {
                zzrf.zza(activityLifecycleCallbacks);
            } else if (!this.zzyj) {
                this.zzyh.unregisterActivityLifecycleCallbacks(this);
                this.zzyj = true;
            }
        } catch (Exception e) {
            zzd.zzc("Error while dispatching lifecycle callback.", e);
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zza(new zzqw(this, activity, bundle));
    }

    public final void onActivityDestroyed(Activity activity) {
        zza(new zzrc(this, activity));
    }

    public final void onActivityPaused(Activity activity) {
        zza(new zzrb(this, activity));
    }

    public final void onActivityResumed(Activity activity) {
        zza(new zzqy(this, activity));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zza(new zzrd(this, activity, bundle));
    }

    public final void onActivityStarted(Activity activity) {
        zza(new zzqz(this, activity));
    }

    public final void onActivityStopped(Activity activity) {
        zza(new zzra(this, activity));
    }
}
