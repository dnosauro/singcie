package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

@TargetApi(14)
final class zzrj implements Application.ActivityLifecycleCallbacks {
    private Context context;
    /* access modifiers changed from: private */
    public boolean foreground = true;
    /* access modifiers changed from: private */
    public final Object lock = new Object();
    private Activity zzaap;
    /* access modifiers changed from: private */
    public boolean zzbsq = false;
    /* access modifiers changed from: private */
    @GuardedBy("lock")
    public final List<zzrl> zzbsr = new ArrayList();
    @GuardedBy("lock")
    private final List<zzrw> zzbss = new ArrayList();
    private Runnable zzbst;
    private long zzbsu;
    private boolean zzzi = false;

    zzrj() {
    }

    private final void setActivity(Activity activity) {
        synchronized (this.lock) {
            if (!activity.getClass().getName().startsWith(MobileAds.ERROR_DOMAIN)) {
                this.zzaap = activity;
            }
        }
    }

    public final Activity getActivity() {
        return this.zzaap;
    }

    public final Context getContext() {
        return this.context;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.lock) {
            if (this.zzaap != null) {
                if (this.zzaap.equals(activity)) {
                    this.zzaap = null;
                }
                Iterator<zzrw> it = this.zzbss.iterator();
                while (it.hasNext()) {
                    try {
                        if (it.next().zza(activity)) {
                            it.remove();
                        }
                    } catch (Exception e) {
                        zzp.zzku().zza(e, "AppActivityTracker.ActivityListener.onActivityDestroyed");
                        zzaza.zzc("", e);
                    }
                }
            }
        }
    }

    public final void onActivityPaused(Activity activity) {
        setActivity(activity);
        synchronized (this.lock) {
            for (zzrw onActivityPaused : this.zzbss) {
                try {
                    onActivityPaused.onActivityPaused(activity);
                } catch (Exception e) {
                    zzp.zzku().zza(e, "AppActivityTracker.ActivityListener.onActivityPaused");
                    zzaza.zzc("", e);
                }
            }
        }
        this.zzbsq = true;
        if (this.zzbst != null) {
            zzm.zzedd.removeCallbacks(this.zzbst);
        }
        zzduw zzduw = zzm.zzedd;
        zzri zzri = new zzri(this);
        this.zzbst = zzri;
        zzduw.postDelayed(zzri, this.zzbsu);
    }

    public final void onActivityResumed(Activity activity) {
        setActivity(activity);
        this.zzbsq = false;
        boolean z = !this.foreground;
        this.foreground = true;
        if (this.zzbst != null) {
            zzm.zzedd.removeCallbacks(this.zzbst);
        }
        synchronized (this.lock) {
            for (zzrw onActivityResumed : this.zzbss) {
                try {
                    onActivityResumed.onActivityResumed(activity);
                } catch (Exception e) {
                    zzp.zzku().zza(e, "AppActivityTracker.ActivityListener.onActivityResumed");
                    zzaza.zzc("", e);
                }
            }
            if (z) {
                for (zzrl zzp : this.zzbsr) {
                    try {
                        zzp.zzp(true);
                    } catch (Exception e2) {
                        zzaza.zzc("", e2);
                    }
                }
            } else {
                zzd.zzeb("App is still foreground.");
            }
        }
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
        setActivity(activity);
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void zza(Application application, Context context2) {
        if (!this.zzzi) {
            application.registerActivityLifecycleCallbacks(this);
            if (context2 instanceof Activity) {
                setActivity((Activity) context2);
            }
            this.context = application;
            this.zzbsu = ((Long) zzwq.zzqe().zzd(zzabf.zzcoo)).longValue();
            this.zzzi = true;
        }
    }

    public final void zza(zzrl zzrl) {
        synchronized (this.lock) {
            this.zzbsr.add(zzrl);
        }
    }

    public final void zzb(zzrl zzrl) {
        synchronized (this.lock) {
            this.zzbsr.remove(zzrl);
        }
    }
}
