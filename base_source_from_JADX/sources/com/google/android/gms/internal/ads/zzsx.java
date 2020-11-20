package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.concurrent.GuardedBy;

public final class zzsx {
    @GuardedBy("lock")
    private Context context;
    /* access modifiers changed from: private */
    public final Object lock = new Object();
    private final Runnable zzbuq = new zzsw(this);
    /* access modifiers changed from: private */
    @GuardedBy("lock")
    public zztc zzbur;
    /* access modifiers changed from: private */
    @GuardedBy("lock")
    public zztg zzbus;

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0024, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void connect() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.lock
            monitor-enter(r0)
            android.content.Context r1 = r3.context     // Catch:{ all -> 0x0025 }
            if (r1 == 0) goto L_0x0023
            com.google.android.gms.internal.ads.zztc r1 = r3.zzbur     // Catch:{ all -> 0x0025 }
            if (r1 == 0) goto L_0x000c
            goto L_0x0023
        L_0x000c:
            com.google.android.gms.internal.ads.zzsy r1 = new com.google.android.gms.internal.ads.zzsy     // Catch:{ all -> 0x0025 }
            r1.<init>(r3)     // Catch:{ all -> 0x0025 }
            com.google.android.gms.internal.ads.zztb r2 = new com.google.android.gms.internal.ads.zztb     // Catch:{ all -> 0x0025 }
            r2.<init>(r3)     // Catch:{ all -> 0x0025 }
            com.google.android.gms.internal.ads.zztc r1 = r3.zza((com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks) r1, (com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener) r2)     // Catch:{ all -> 0x0025 }
            r3.zzbur = r1     // Catch:{ all -> 0x0025 }
            com.google.android.gms.internal.ads.zztc r1 = r3.zzbur     // Catch:{ all -> 0x0025 }
            r1.checkAvailabilityAndConnect()     // Catch:{ all -> 0x0025 }
            monitor-exit(r0)     // Catch:{ all -> 0x0025 }
            return
        L_0x0023:
            monitor-exit(r0)     // Catch:{ all -> 0x0025 }
            return
        L_0x0025:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0025 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzsx.connect():void");
    }

    /* access modifiers changed from: private */
    public final void disconnect() {
        synchronized (this.lock) {
            if (this.zzbur != null) {
                if (this.zzbur.isConnected() || this.zzbur.isConnecting()) {
                    this.zzbur.disconnect();
                }
                this.zzbur = null;
                this.zzbus = null;
                Binder.flushPendingCommands();
            }
        }
    }

    @VisibleForTesting
    private final synchronized zztc zza(BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        return new zztc(this.context, zzp.zzle().zzyw(), baseConnectionCallbacks, baseOnConnectionFailedListener);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0047, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void initialize(android.content.Context r3) {
        /*
            r2 = this;
            if (r3 != 0) goto L_0x0003
            return
        L_0x0003:
            java.lang.Object r0 = r2.lock
            monitor-enter(r0)
            android.content.Context r1 = r2.context     // Catch:{ all -> 0x0048 }
            if (r1 == 0) goto L_0x000c
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            return
        L_0x000c:
            android.content.Context r3 = r3.getApplicationContext()     // Catch:{ all -> 0x0048 }
            r2.context = r3     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r3 = com.google.android.gms.internal.ads.zzabf.zzctb     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzabb r1 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ all -> 0x0048 }
            java.lang.Object r3 = r1.zzd(r3)     // Catch:{ all -> 0x0048 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ all -> 0x0048 }
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x0048 }
            if (r3 == 0) goto L_0x0028
            r2.connect()     // Catch:{ all -> 0x0048 }
            goto L_0x0046
        L_0x0028:
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r3 = com.google.android.gms.internal.ads.zzabf.zzcta     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzabb r1 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ all -> 0x0048 }
            java.lang.Object r3 = r1.zzd(r3)     // Catch:{ all -> 0x0048 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ all -> 0x0048 }
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x0048 }
            if (r3 == 0) goto L_0x0046
            com.google.android.gms.internal.ads.zzsz r3 = new com.google.android.gms.internal.ads.zzsz     // Catch:{ all -> 0x0048 }
            r3.<init>(r2)     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzrg r1 = com.google.android.gms.ads.internal.zzp.zzkt()     // Catch:{ all -> 0x0048 }
            r1.zza(r3)     // Catch:{ all -> 0x0048 }
        L_0x0046:
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            return
        L_0x0048:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzsx.initialize(android.content.Context):void");
    }

    public final zzta zza(zztf zztf) {
        synchronized (this.lock) {
            if (this.zzbus == null) {
                zzta zzta = new zzta();
                return zzta;
            }
            try {
                if (this.zzbur.zznd()) {
                    zzta zzc = this.zzbus.zzc(zztf);
                    return zzc;
                }
                zzta zza = this.zzbus.zza(zztf);
                return zza;
            } catch (RemoteException e) {
                zzd.zzc("Unable to call into cache service.", e);
                return new zzta();
            }
        }
    }

    public final long zzb(zztf zztf) {
        synchronized (this.lock) {
            if (this.zzbus == null) {
                return -2;
            }
            if (this.zzbur.zznd()) {
                try {
                    long zzb = this.zzbus.zzb(zztf);
                    return zzb;
                } catch (RemoteException e) {
                    zzd.zzc("Unable to call into cache service.", e);
                    return -2;
                }
            }
        }
    }

    public final void zzmu() {
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzctc)).booleanValue()) {
            synchronized (this.lock) {
                connect();
                zzm.zzedd.removeCallbacks(this.zzbuq);
                zzm.zzedd.postDelayed(this.zzbuq, ((Long) zzwq.zzqe().zzd(zzabf.zzctd)).longValue());
            }
        }
    }
}
