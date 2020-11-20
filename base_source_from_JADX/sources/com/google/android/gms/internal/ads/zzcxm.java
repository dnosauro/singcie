package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbrg;
import com.google.android.gms.internal.ads.zzbwp;
import java.util.Collections;
import javax.annotation.concurrent.GuardedBy;

public final class zzcxm extends zzxf implements zzbue {
    /* access modifiers changed from: private */
    public final ViewGroup zzfsx;
    /* access modifiers changed from: private */
    public final zzbgm zzgss;
    /* access modifiers changed from: private */
    @GuardedBy("this")
    public zzbme zzgvl;
    private final Context zzgvn;
    @GuardedBy("this")
    private final zzdnp zzgvo = new zzdnp();
    /* access modifiers changed from: private */
    public final zzcxq zzgvs = new zzcxq();
    /* access modifiers changed from: private */
    public final zzcyd zzgvt = new zzcyd();
    /* access modifiers changed from: private */
    public final zzbua zzgvu;
    private zzvn zzgvv;
    @GuardedBy("this")
    private zzacb zzgvw;
    /* access modifiers changed from: private */
    @GuardedBy("this")
    public zzdyz<zzbme> zzgvx;

    public zzcxm(zzbgm zzbgm, Context context, zzvn zzvn, String str) {
        this.zzfsx = new FrameLayout(context);
        this.zzgss = zzbgm;
        this.zzgvn = context;
        this.zzgvo.zzf(zzvn).zzgq(str);
        this.zzgvu = zzbgm.zzaeo();
        this.zzgvu.zza(this, this.zzgss.zzaek());
        this.zzgvv = zzvn;
    }

    private final synchronized zzbna zzb(zzdnn zzdnn) {
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcyp)).booleanValue()) {
            return this.zzgss.zzaer().zzd(new zzbrg.zza().zzcg(this.zzgvn).zza(zzdnn).zzakx()).zzd(new zzbwp.zza().zzalt()).zza(new zzcwq(this.zzgvw)).zzb(new zzcap(zzccl.zzgdq, (zzwt) null)).zza(new zzbnv(this.zzgvu)).zzd(new zzblz(this.zzfsx)).zzagz();
        }
        return this.zzgss.zzaer().zzd(new zzbrg.zza().zzcg(this.zzgvn).zza(zzdnn).zzakx()).zzd(new zzbwp.zza().zza((zzva) this.zzgvs, this.zzgss.zzaek()).zza((zzva) this.zzgvt, this.zzgss.zzaek()).zza((zzbsm) this.zzgvs, this.zzgss.zzaek()).zza((zzbru) this.zzgvs, this.zzgss.zzaek()).zza((zzbtj) this.zzgvs, this.zzgss.zzaek()).zza((zzbrz) this.zzgvs, this.zzgss.zzaek()).zza((AppEventListener) this.zzgvs, this.zzgss.zzaek()).zza((zzbub) this.zzgvs, this.zzgss.zzaek()).zzalt()).zza(new zzcwq(this.zzgvw)).zzb(new zzcap(zzccl.zzgdq, (zzwt) null)).zza(new zzbnv(this.zzgvu)).zzd(new zzblz(this.zzfsx)).zzagz();
    }

    private final synchronized void zze(zzvn zzvn) {
        this.zzgvo.zzf(zzvn);
        this.zzgvo.zzbn(this.zzgvv.zzchw);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002c, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized boolean zzg(com.google.android.gms.internal.ads.zzvk r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.lang.String r0 = "loadAd must be called on the main UI thread."
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r0)     // Catch:{ all -> 0x008e }
            com.google.android.gms.ads.internal.zzp.zzkq()     // Catch:{ all -> 0x008e }
            android.content.Context r0 = r4.zzgvn     // Catch:{ all -> 0x008e }
            boolean r0 = com.google.android.gms.ads.internal.util.zzm.zzbb(r0)     // Catch:{ all -> 0x008e }
            r1 = 0
            r2 = 0
            if (r0 == 0) goto L_0x002d
            com.google.android.gms.internal.ads.zzvc r0 = r5.zzchn     // Catch:{ all -> 0x008e }
            if (r0 != 0) goto L_0x002d
            java.lang.String r5 = "Failed to load the ad because app ID is missing."
            com.google.android.gms.ads.internal.util.zzd.zzey(r5)     // Catch:{ all -> 0x008e }
            com.google.android.gms.internal.ads.zzcxq r5 = r4.zzgvs     // Catch:{ all -> 0x008e }
            if (r5 == 0) goto L_0x002b
            com.google.android.gms.internal.ads.zzcxq r5 = r4.zzgvs     // Catch:{ all -> 0x008e }
            com.google.android.gms.internal.ads.zzdok r0 = com.google.android.gms.internal.ads.zzdok.APP_ID_MISSING     // Catch:{ all -> 0x008e }
            com.google.android.gms.internal.ads.zzve r0 = com.google.android.gms.internal.ads.zzdoi.zza(r0, r2, r2)     // Catch:{ all -> 0x008e }
            r5.zzk(r0)     // Catch:{ all -> 0x008e }
        L_0x002b:
            monitor-exit(r4)
            return r1
        L_0x002d:
            com.google.android.gms.internal.ads.zzdyz<com.google.android.gms.internal.ads.zzbme> r0 = r4.zzgvx     // Catch:{ all -> 0x008e }
            if (r0 == 0) goto L_0x0033
            monitor-exit(r4)
            return r1
        L_0x0033:
            android.content.Context r0 = r4.zzgvn     // Catch:{ all -> 0x008e }
            boolean r3 = r5.zzchb     // Catch:{ all -> 0x008e }
            com.google.android.gms.internal.ads.zzdob.zze(r0, r3)     // Catch:{ all -> 0x008e }
            com.google.android.gms.internal.ads.zzdnp r0 = r4.zzgvo     // Catch:{ all -> 0x008e }
            com.google.android.gms.internal.ads.zzdnp r5 = r0.zzh((com.google.android.gms.internal.ads.zzvk) r5)     // Catch:{ all -> 0x008e }
            com.google.android.gms.internal.ads.zzdnn r5 = r5.zzaus()     // Catch:{ all -> 0x008e }
            com.google.android.gms.internal.ads.zzacn<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzadc.zzdcx     // Catch:{ all -> 0x008e }
            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x008e }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x008e }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x008e }
            if (r0 == 0) goto L_0x006d
            com.google.android.gms.internal.ads.zzdnp r0 = r4.zzgvo     // Catch:{ all -> 0x008e }
            com.google.android.gms.internal.ads.zzvn r0 = r0.zzkf()     // Catch:{ all -> 0x008e }
            boolean r0 = r0.zzcht     // Catch:{ all -> 0x008e }
            if (r0 == 0) goto L_0x006d
            com.google.android.gms.internal.ads.zzcxq r0 = r4.zzgvs     // Catch:{ all -> 0x008e }
            if (r0 == 0) goto L_0x006d
            com.google.android.gms.internal.ads.zzcxq r5 = r4.zzgvs     // Catch:{ all -> 0x008e }
            com.google.android.gms.internal.ads.zzdok r0 = com.google.android.gms.internal.ads.zzdok.INVALID_AD_SIZE     // Catch:{ all -> 0x008e }
            com.google.android.gms.internal.ads.zzve r0 = com.google.android.gms.internal.ads.zzdoi.zza(r0, r2, r2)     // Catch:{ all -> 0x008e }
            r5.zzk(r0)     // Catch:{ all -> 0x008e }
            monitor-exit(r4)
            return r1
        L_0x006d:
            com.google.android.gms.internal.ads.zzbna r5 = r4.zzb((com.google.android.gms.internal.ads.zzdnn) r5)     // Catch:{ all -> 0x008e }
            com.google.android.gms.internal.ads.zzboz r0 = r5.zzagh()     // Catch:{ all -> 0x008e }
            com.google.android.gms.internal.ads.zzdyz r0 = r0.zzakj()     // Catch:{ all -> 0x008e }
            r4.zzgvx = r0     // Catch:{ all -> 0x008e }
            com.google.android.gms.internal.ads.zzdyz<com.google.android.gms.internal.ads.zzbme> r0 = r4.zzgvx     // Catch:{ all -> 0x008e }
            com.google.android.gms.internal.ads.zzcxl r1 = new com.google.android.gms.internal.ads.zzcxl     // Catch:{ all -> 0x008e }
            r1.<init>(r4, r5)     // Catch:{ all -> 0x008e }
            com.google.android.gms.internal.ads.zzbgm r5 = r4.zzgss     // Catch:{ all -> 0x008e }
            java.util.concurrent.Executor r5 = r5.zzaek()     // Catch:{ all -> 0x008e }
            com.google.android.gms.internal.ads.zzdyr.zza(r0, r1, r5)     // Catch:{ all -> 0x008e }
            r5 = 1
            monitor-exit(r4)
            return r5
        L_0x008e:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcxm.zzg(com.google.android.gms.internal.ads.zzvk):boolean");
    }

    public final synchronized void destroy() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        if (this.zzgvl != null) {
            this.zzgvl.destroy();
        }
    }

    public final Bundle getAdMetadata() {
        Preconditions.checkMainThread("getAdMetadata must be called on the main UI thread.");
        return new Bundle();
    }

    public final synchronized String getAdUnitId() {
        return this.zzgvo.zzauq();
    }

    public final synchronized String getMediationAdapterClassName() {
        if (this.zzgvl == null || this.zzgvl.zzajz() == null) {
            return null;
        }
        return this.zzgvl.zzajz().getMediationAdapterClassName();
    }

    public final synchronized zzys getVideoController() {
        Preconditions.checkMainThread("getVideoController must be called from the main thread.");
        if (this.zzgvl == null) {
            return null;
        }
        return this.zzgvl.getVideoController();
    }

    public final synchronized boolean isLoading() {
        return this.zzgvx != null && !this.zzgvx.isDone();
    }

    public final boolean isReady() {
        return false;
    }

    public final synchronized void pause() {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
        if (this.zzgvl != null) {
            this.zzgvl.zzajy().zzcc((Context) null);
        }
    }

    public final synchronized void resume() {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
        if (this.zzgvl != null) {
            this.zzgvl.zzajy().zzcd((Context) null);
        }
    }

    public final void setImmersiveMode(boolean z) {
    }

    public final synchronized void setManualImpressionsEnabled(boolean z) {
        Preconditions.checkMainThread("setManualImpressionsEnabled must be called from the main thread.");
        this.zzgvo.zzbo(z);
    }

    public final void setUserId(String str) {
    }

    public final void showInterstitial() {
    }

    public final void stopLoading() {
    }

    public final synchronized void zza(zzaak zzaak) {
        Preconditions.checkMainThread("setVideoOptions must be called on the main UI thread.");
        this.zzgvo.zzc(zzaak);
    }

    public final synchronized void zza(zzacb zzacb) {
        Preconditions.checkMainThread("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.zzgvw = zzacb;
    }

    public final void zza(zzart zzart) {
    }

    public final void zza(zzarz zzarz, String str) {
    }

    public final void zza(zzaup zzaup) {
    }

    public final void zza(zzsl zzsl) {
    }

    public final synchronized void zza(zzvn zzvn) {
        Preconditions.checkMainThread("setAdSize must be called on the main UI thread.");
        this.zzgvo.zzf(zzvn);
        this.zzgvv = zzvn;
        if (this.zzgvl != null) {
            this.zzgvl.zza(this.zzfsx, zzvn);
        }
    }

    public final void zza(zzvw zzvw) {
    }

    public final void zza(zzws zzws) {
        Preconditions.checkMainThread("setAdListener must be called on the main UI thread.");
        this.zzgvt.zzb(zzws);
    }

    public final void zza(zzwt zzwt) {
        Preconditions.checkMainThread("setAdListener must be called on the main UI thread.");
        this.zzgvs.zzc(zzwt);
    }

    public final void zza(zzxj zzxj) {
        Preconditions.checkMainThread("setAdMetadataListener must be called on the main UI thread.");
    }

    public final void zza(zzxo zzxo) {
        Preconditions.checkMainThread("setAppEventListener must be called on the main UI thread.");
        this.zzgvs.zzb(zzxo);
    }

    public final synchronized void zza(zzxu zzxu) {
        Preconditions.checkMainThread("setCorrelationIdProvider must be called on the main UI thread");
        this.zzgvo.zzc(zzxu);
    }

    public final void zza(zzym zzym) {
        Preconditions.checkMainThread("setPaidEventListener must be called on the main UI thread.");
        this.zzgvs.zzb(zzym);
    }

    public final void zza(zzyy zzyy) {
    }

    public final synchronized boolean zza(zzvk zzvk) {
        zze(this.zzgvv);
        return zzg(zzvk);
    }

    public final synchronized void zzald() {
        boolean z;
        ViewParent parent = this.zzfsx.getParent();
        if (!(parent instanceof View)) {
            z = false;
        } else {
            View view = (View) parent;
            z = zzp.zzkq().zza(view, view.getContext());
        }
        if (z) {
            zzvn zzkf = this.zzgvo.zzkf();
            if (!(this.zzgvl == null || this.zzgvl.zzajh() == null || !this.zzgvo.zzaut())) {
                zzkf = zzdns.zzb(this.zzgvn, Collections.singletonList(this.zzgvl.zzajh()));
            }
            zze(zzkf);
            zzg(this.zzgvo.zzaup());
            return;
        }
        this.zzgvu.zzdx(60);
    }

    public final void zzbl(String str) {
    }

    public final IObjectWrapper zzkd() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        return ObjectWrapper.wrap(this.zzfsx);
    }

    public final synchronized void zzke() {
        Preconditions.checkMainThread("recordManualImpression must be called on the main UI thread.");
        if (this.zzgvl != null) {
            this.zzgvl.zzke();
        }
    }

    public final synchronized zzvn zzkf() {
        Preconditions.checkMainThread("getAdSize must be called on the main UI thread.");
        if (this.zzgvl != null) {
            return zzdns.zzb(this.zzgvn, Collections.singletonList(this.zzgvl.zzaiy()));
        }
        return this.zzgvo.zzkf();
    }

    public final synchronized String zzkg() {
        if (this.zzgvl == null || this.zzgvl.zzajz() == null) {
            return null;
        }
        return this.zzgvl.zzajz().getMediationAdapterClassName();
    }

    public final synchronized zzyn zzkh() {
        if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcxv)).booleanValue()) {
            return null;
        }
        if (this.zzgvl == null) {
            return null;
        }
        return this.zzgvl.zzajz();
    }

    public final zzxo zzki() {
        return this.zzgvs.zzaru();
    }

    public final zzwt zzkj() {
        return this.zzgvs.zzart();
    }
}
