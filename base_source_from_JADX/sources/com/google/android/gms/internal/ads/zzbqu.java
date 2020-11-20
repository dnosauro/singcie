package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final class zzbqu implements zzbru, zzbsi, zzbvz, zzbxn {
    private final Executor executor;
    /* access modifiers changed from: private */
    public final zzbsl zzfwm;
    private final zzdmu zzfwn;
    private final ScheduledExecutorService zzfwo;
    private zzdzh<Boolean> zzfwp = zzdzh.zzazp();
    private ScheduledFuture<?> zzfwq;

    public zzbqu(zzbsl zzbsl, zzdmu zzdmu, ScheduledExecutorService scheduledExecutorService, Executor executor2) {
        this.zzfwm = zzbsl;
        this.zzfwn = zzdmu;
        this.zzfwo = scheduledExecutorService;
        this.executor = executor2;
    }

    public final void onAdClosed() {
    }

    public final void onAdLeftApplication() {
    }

    public final void onAdOpened() {
        if (this.zzfwn.zzhhj == 0 || this.zzfwn.zzhhj == 1) {
            this.zzfwm.onAdImpression();
        }
    }

    public final void onRewardedVideoCompleted() {
    }

    public final void onRewardedVideoStarted() {
    }

    public final void zzakl() {
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcqh)).booleanValue() && this.zzfwn.zzhhj == 2) {
            if (this.zzfwn.zzhgv == 0) {
                this.zzfwm.onAdImpression();
                return;
            }
            zzdyr.zza(this.zzfwp, new zzbqw(this), this.executor);
            this.zzfwq = this.zzfwo.schedule(new zzbqt(this), (long) this.zzfwn.zzhgv, TimeUnit.MILLISECONDS);
        }
    }

    public final synchronized void zzakm() {
        if (!this.zzfwp.isDone()) {
            if (this.zzfwq != null) {
                this.zzfwq.cancel(true);
            }
            this.zzfwp.set(true);
        }
    }

    public final void zzakn() {
    }

    public final void zzako() {
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzakp() {
        synchronized (this) {
            if (!this.zzfwp.isDone()) {
                this.zzfwp.set(true);
            }
        }
    }

    public final void zzb(zzauf zzauf, String str, String str2) {
    }

    public final synchronized void zzj(zzve zzve) {
        if (!this.zzfwp.isDone()) {
            if (this.zzfwq != null) {
                this.zzfwq.cancel(true);
            }
            this.zzfwp.setException(new Exception());
        }
    }
}
