package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

public final class zzbjv implements zzbru, zzbsi, zzbsm, zzbtj, zzva {
    /* access modifiers changed from: private */
    public final Context context;
    private final Executor executor;
    private final View view;
    private final zzacg zzerc;
    private final ScheduledExecutorService zzfpq;
    /* access modifiers changed from: private */
    public final zzdnj zzfpr;
    /* access modifiers changed from: private */
    public final zzdmu zzfps;
    /* access modifiers changed from: private */
    public final zzdrx zzfpt;
    /* access modifiers changed from: private */
    public final zzdnv zzfpu;
    private final zzef zzfpv;
    private final zzacl zzfpw;
    @GuardedBy("this")
    private boolean zzfpx;
    @GuardedBy("this")
    private boolean zzfpy;

    public zzbjv(Context context2, Executor executor2, ScheduledExecutorService scheduledExecutorService, zzdnj zzdnj, zzdmu zzdmu, zzdrx zzdrx, zzdnv zzdnv, View view2, zzef zzef, zzacg zzacg, zzacl zzacl) {
        this.context = context2;
        this.executor = executor2;
        this.zzfpq = scheduledExecutorService;
        this.zzfpr = zzdnj;
        this.zzfps = zzdmu;
        this.zzfpt = zzdrx;
        this.zzfpu = zzdnv;
        this.zzfpv = zzef;
        this.view = view2;
        this.zzerc = zzacg;
        this.zzfpw = zzacl;
    }

    public final void onAdClicked() {
        if ((((Boolean) zzwq.zzqe().zzd(zzabf.zzcny)).booleanValue() && this.zzfpr.zzhik.zzerj.zzhhy) || !zzacy.zzdcd.get().booleanValue()) {
            zzdnv zzdnv = this.zzfpu;
            zzdrx zzdrx = this.zzfpt;
            zzdnj zzdnj = this.zzfpr;
            zzdmu zzdmu = this.zzfps;
            List<String> zza = zzdrx.zza(zzdnj, zzdmu, zzdmu.zzdls);
            zzp.zzkq();
            zzdnv.zza(zza, zzm.zzbc(this.context) ? zzcql.zzgqc : zzcql.zzgqb);
            return;
        }
        zzdyr.zza(zzdyi.zzg(this.zzfpw.zza(this.context, this.zzerc.zzsg(), this.zzerc.zzsh())).zza(((Long) zzwq.zzqe().zzd(zzabf.zzcor)).longValue(), TimeUnit.MILLISECONDS, this.zzfpq), new zzbjy(this), this.executor);
    }

    public final void onAdClosed() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00a3, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void onAdImpression() {
        /*
            r9 = this;
            monitor-enter(r9)
            boolean r0 = r9.zzfpy     // Catch:{ all -> 0x00a4 }
            if (r0 != 0) goto L_0x00a2
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabf.zzcrp     // Catch:{ all -> 0x00a4 }
            com.google.android.gms.internal.ads.zzabb r1 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ all -> 0x00a4 }
            java.lang.Object r0 = r1.zzd(r0)     // Catch:{ all -> 0x00a4 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x00a4 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x00a4 }
            r1 = 0
            if (r0 == 0) goto L_0x0026
            com.google.android.gms.internal.ads.zzef r0 = r9.zzfpv     // Catch:{ all -> 0x00a4 }
            com.google.android.gms.internal.ads.zzdv r0 = r0.zzca()     // Catch:{ all -> 0x00a4 }
            android.content.Context r2 = r9.context     // Catch:{ all -> 0x00a4 }
            android.view.View r3 = r9.view     // Catch:{ all -> 0x00a4 }
            java.lang.String r1 = r0.zza((android.content.Context) r2, (android.view.View) r3, (android.app.Activity) r1)     // Catch:{ all -> 0x00a4 }
        L_0x0026:
            r5 = r1
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabf.zzcny     // Catch:{ all -> 0x00a4 }
            com.google.android.gms.internal.ads.zzabb r1 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ all -> 0x00a4 }
            java.lang.Object r0 = r1.zzd(r0)     // Catch:{ all -> 0x00a4 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x00a4 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x00a4 }
            r8 = 1
            if (r0 == 0) goto L_0x0046
            com.google.android.gms.internal.ads.zzdnj r0 = r9.zzfpr     // Catch:{ all -> 0x00a4 }
            com.google.android.gms.internal.ads.zzdnh r0 = r0.zzhik     // Catch:{ all -> 0x00a4 }
            com.google.android.gms.internal.ads.zzdmz r0 = r0.zzerj     // Catch:{ all -> 0x00a4 }
            boolean r0 = r0.zzhhy     // Catch:{ all -> 0x00a4 }
            if (r0 == 0) goto L_0x0046
            r0 = 1
            goto L_0x0047
        L_0x0046:
            r0 = 0
        L_0x0047:
            if (r0 != 0) goto L_0x0089
            com.google.android.gms.internal.ads.zzacn<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzacy.zzdce     // Catch:{ all -> 0x00a4 }
            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x00a4 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x00a4 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x00a4 }
            if (r0 != 0) goto L_0x0058
            goto L_0x0089
        L_0x0058:
            com.google.android.gms.internal.ads.zzacl r0 = r9.zzfpw     // Catch:{ all -> 0x00a4 }
            android.content.Context r1 = r9.context     // Catch:{ all -> 0x00a4 }
            com.google.android.gms.internal.ads.zzdyz r0 = r0.zzk(r1)     // Catch:{ all -> 0x00a4 }
            com.google.android.gms.internal.ads.zzdyi r0 = com.google.android.gms.internal.ads.zzdyi.zzg(r0)     // Catch:{ all -> 0x00a4 }
            com.google.android.gms.internal.ads.zzaaq<java.lang.Long> r1 = com.google.android.gms.internal.ads.zzabf.zzcor     // Catch:{ all -> 0x00a4 }
            com.google.android.gms.internal.ads.zzabb r2 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ all -> 0x00a4 }
            java.lang.Object r1 = r2.zzd(r1)     // Catch:{ all -> 0x00a4 }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ all -> 0x00a4 }
            long r1 = r1.longValue()     // Catch:{ all -> 0x00a4 }
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x00a4 }
            java.util.concurrent.ScheduledExecutorService r4 = r9.zzfpq     // Catch:{ all -> 0x00a4 }
            com.google.android.gms.internal.ads.zzdyi r0 = r0.zza((long) r1, (java.util.concurrent.TimeUnit) r3, (java.util.concurrent.ScheduledExecutorService) r4)     // Catch:{ all -> 0x00a4 }
            com.google.android.gms.internal.ads.zzbjx r1 = new com.google.android.gms.internal.ads.zzbjx     // Catch:{ all -> 0x00a4 }
            r1.<init>(r9, r5)     // Catch:{ all -> 0x00a4 }
            java.util.concurrent.Executor r2 = r9.executor     // Catch:{ all -> 0x00a4 }
            com.google.android.gms.internal.ads.zzdyr.zza(r0, r1, r2)     // Catch:{ all -> 0x00a4 }
            r9.zzfpy = r8     // Catch:{ all -> 0x00a4 }
            goto L_0x00a2
        L_0x0089:
            com.google.android.gms.internal.ads.zzdnv r0 = r9.zzfpu     // Catch:{ all -> 0x00a4 }
            com.google.android.gms.internal.ads.zzdrx r1 = r9.zzfpt     // Catch:{ all -> 0x00a4 }
            com.google.android.gms.internal.ads.zzdnj r2 = r9.zzfpr     // Catch:{ all -> 0x00a4 }
            com.google.android.gms.internal.ads.zzdmu r3 = r9.zzfps     // Catch:{ all -> 0x00a4 }
            r4 = 0
            r6 = 0
            com.google.android.gms.internal.ads.zzdmu r7 = r9.zzfps     // Catch:{ all -> 0x00a4 }
            java.util.List<java.lang.String> r7 = r7.zzdlt     // Catch:{ all -> 0x00a4 }
            java.util.List r1 = r1.zza(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x00a4 }
            r0.zzi(r1)     // Catch:{ all -> 0x00a4 }
            r9.zzfpy = r8     // Catch:{ all -> 0x00a4 }
            monitor-exit(r9)
            return
        L_0x00a2:
            monitor-exit(r9)
            return
        L_0x00a4:
            r0 = move-exception
            monitor-exit(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbjv.onAdImpression():void");
    }

    public final void onAdLeftApplication() {
    }

    public final synchronized void onAdLoaded() {
        zzdnv zzdnv;
        List<String> zza;
        if (this.zzfpx) {
            ArrayList arrayList = new ArrayList(this.zzfps.zzdlt);
            arrayList.addAll(this.zzfps.zzhgr);
            zzdnv = this.zzfpu;
            zza = this.zzfpt.zza(this.zzfpr, this.zzfps, true, (String) null, (String) null, arrayList);
        } else {
            this.zzfpu.zzi(this.zzfpt.zza(this.zzfpr, this.zzfps, this.zzfps.zzhgt));
            zzdnv = this.zzfpu;
            zza = this.zzfpt.zza(this.zzfpr, this.zzfps, this.zzfps.zzhgr);
        }
        zzdnv.zzi(zza);
        this.zzfpx = true;
    }

    public final void onAdOpened() {
    }

    public final void onRewardedVideoCompleted() {
        zzdnv zzdnv = this.zzfpu;
        zzdrx zzdrx = this.zzfpt;
        zzdnj zzdnj = this.zzfpr;
        zzdmu zzdmu = this.zzfps;
        zzdnv.zzi(zzdrx.zza(zzdnj, zzdmu, zzdmu.zzhgs));
    }

    public final void onRewardedVideoStarted() {
        zzdnv zzdnv = this.zzfpu;
        zzdrx zzdrx = this.zzfpt;
        zzdnj zzdnj = this.zzfpr;
        zzdmu zzdmu = this.zzfps;
        zzdnv.zzi(zzdrx.zza(zzdnj, zzdmu, zzdmu.zzdvc));
    }

    public final void zzb(zzauf zzauf, String str, String str2) {
        zzdnv zzdnv = this.zzfpu;
        zzdrx zzdrx = this.zzfpt;
        zzdmu zzdmu = this.zzfps;
        zzdnv.zzi(zzdrx.zza(zzdmu, zzdmu.zzdvd, zzauf));
    }

    public final void zzj(zzve zzve) {
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcqg)).booleanValue()) {
            this.zzfpu.zzi(this.zzfpt.zza(this.zzfpr, this.zzfps, zzdrx.zza(2, zzve.errorCode, this.zzfps.zzhgu)));
        }
    }
}
