package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import javax.annotation.concurrent.GuardedBy;

public final class zzcyg extends zzxf {
    private final zzvn zzbpe;
    private final String zzbum;
    private final Context zzgvn;
    private final zzcxq zzgvs;
    private final zzdkv zzgwj;
    private final zzdlf zzgwk;
    /* access modifiers changed from: private */
    @GuardedBy("this")
    public zzbyx zzgwl;
    @GuardedBy("this")
    private boolean zzgwm = false;

    public zzcyg(Context context, zzvn zzvn, String str, zzdkv zzdkv, zzcxq zzcxq, zzdlf zzdlf) {
        this.zzbpe = zzvn;
        this.zzbum = str;
        this.zzgvn = context;
        this.zzgwj = zzdkv;
        this.zzgvs = zzcxq;
        this.zzgwk = zzdlf;
    }

    private final synchronized boolean zzary() {
        return this.zzgwl != null && !this.zzgwl.isClosed();
    }

    public final synchronized void destroy() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        if (this.zzgwl != null) {
            this.zzgwl.zzajy().zzce((Context) null);
        }
    }

    public final Bundle getAdMetadata() {
        Preconditions.checkMainThread("getAdMetadata must be called on the main UI thread.");
        return new Bundle();
    }

    public final synchronized String getAdUnitId() {
        return this.zzbum;
    }

    public final synchronized String getMediationAdapterClassName() {
        if (this.zzgwl == null || this.zzgwl.zzajz() == null) {
            return null;
        }
        return this.zzgwl.zzajz().getMediationAdapterClassName();
    }

    public final zzys getVideoController() {
        return null;
    }

    public final synchronized boolean isLoading() {
        return this.zzgwj.isLoading();
    }

    public final synchronized boolean isReady() {
        Preconditions.checkMainThread("isLoaded must be called on the main UI thread.");
        return zzary();
    }

    public final synchronized void pause() {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
        if (this.zzgwl != null) {
            this.zzgwl.zzajy().zzcc((Context) null);
        }
    }

    public final synchronized void resume() {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
        if (this.zzgwl != null) {
            this.zzgwl.zzajy().zzcd((Context) null);
        }
    }

    public final synchronized void setImmersiveMode(boolean z) {
        Preconditions.checkMainThread("setImmersiveMode must be called on the main UI thread.");
        this.zzgwm = z;
    }

    public final void setManualImpressionsEnabled(boolean z) {
    }

    public final void setUserId(String str) {
    }

    public final synchronized void showInterstitial() {
        Preconditions.checkMainThread("showInterstitial must be called on the main UI thread.");
        if (this.zzgwl != null) {
            this.zzgwl.zzbh(this.zzgwm);
        }
    }

    public final void stopLoading() {
    }

    public final void zza(zzaak zzaak) {
    }

    public final synchronized void zza(zzacb zzacb) {
        Preconditions.checkMainThread("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.zzgwj.zza(zzacb);
    }

    public final void zza(zzart zzart) {
    }

    public final void zza(zzarz zzarz, String str) {
    }

    public final void zza(zzaup zzaup) {
        this.zzgwk.zzb(zzaup);
    }

    public final void zza(zzsl zzsl) {
    }

    public final void zza(zzvn zzvn) {
    }

    public final void zza(zzvw zzvw) {
    }

    public final void zza(zzws zzws) {
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

    public final void zza(zzxu zzxu) {
    }

    public final void zza(zzym zzym) {
        Preconditions.checkMainThread("setPaidEventListener must be called on the main UI thread.");
        this.zzgvs.zzb(zzym);
    }

    public final void zza(zzyy zzyy) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002c, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zza(com.google.android.gms.internal.ads.zzvk r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.lang.String r0 = "loadAd must be called on the main UI thread."
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r0)     // Catch:{ all -> 0x0054 }
            com.google.android.gms.ads.internal.zzp.zzkq()     // Catch:{ all -> 0x0054 }
            android.content.Context r0 = r4.zzgvn     // Catch:{ all -> 0x0054 }
            boolean r0 = com.google.android.gms.ads.internal.util.zzm.zzbb(r0)     // Catch:{ all -> 0x0054 }
            r1 = 0
            r2 = 0
            if (r0 == 0) goto L_0x002d
            com.google.android.gms.internal.ads.zzvc r0 = r5.zzchn     // Catch:{ all -> 0x0054 }
            if (r0 != 0) goto L_0x002d
            java.lang.String r5 = "Failed to load the ad because app ID is missing."
            com.google.android.gms.ads.internal.util.zzd.zzey(r5)     // Catch:{ all -> 0x0054 }
            com.google.android.gms.internal.ads.zzcxq r5 = r4.zzgvs     // Catch:{ all -> 0x0054 }
            if (r5 == 0) goto L_0x002b
            com.google.android.gms.internal.ads.zzcxq r5 = r4.zzgvs     // Catch:{ all -> 0x0054 }
            com.google.android.gms.internal.ads.zzdok r0 = com.google.android.gms.internal.ads.zzdok.APP_ID_MISSING     // Catch:{ all -> 0x0054 }
            com.google.android.gms.internal.ads.zzve r0 = com.google.android.gms.internal.ads.zzdoi.zza(r0, r2, r2)     // Catch:{ all -> 0x0054 }
            r5.zzk(r0)     // Catch:{ all -> 0x0054 }
        L_0x002b:
            monitor-exit(r4)
            return r1
        L_0x002d:
            boolean r0 = r4.zzary()     // Catch:{ all -> 0x0054 }
            if (r0 == 0) goto L_0x0035
            monitor-exit(r4)
            return r1
        L_0x0035:
            android.content.Context r0 = r4.zzgvn     // Catch:{ all -> 0x0054 }
            boolean r1 = r5.zzchb     // Catch:{ all -> 0x0054 }
            com.google.android.gms.internal.ads.zzdob.zze(r0, r1)     // Catch:{ all -> 0x0054 }
            r4.zzgwl = r2     // Catch:{ all -> 0x0054 }
            com.google.android.gms.internal.ads.zzdkv r0 = r4.zzgwj     // Catch:{ all -> 0x0054 }
            java.lang.String r1 = r4.zzbum     // Catch:{ all -> 0x0054 }
            com.google.android.gms.internal.ads.zzdks r2 = new com.google.android.gms.internal.ads.zzdks     // Catch:{ all -> 0x0054 }
            com.google.android.gms.internal.ads.zzvn r3 = r4.zzbpe     // Catch:{ all -> 0x0054 }
            r2.<init>(r3)     // Catch:{ all -> 0x0054 }
            com.google.android.gms.internal.ads.zzcyf r3 = new com.google.android.gms.internal.ads.zzcyf     // Catch:{ all -> 0x0054 }
            r3.<init>(r4)     // Catch:{ all -> 0x0054 }
            boolean r5 = r0.zza(r5, r1, r2, r3)     // Catch:{ all -> 0x0054 }
            monitor-exit(r4)
            return r5
        L_0x0054:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcyg.zza(com.google.android.gms.internal.ads.zzvk):boolean");
    }

    public final void zzbl(String str) {
    }

    public final IObjectWrapper zzkd() {
        return null;
    }

    public final void zzke() {
    }

    public final zzvn zzkf() {
        return null;
    }

    public final synchronized String zzkg() {
        if (this.zzgwl == null || this.zzgwl.zzajz() == null) {
            return null;
        }
        return this.zzgwl.zzajz().getMediationAdapterClassName();
    }

    public final synchronized zzyn zzkh() {
        if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcxv)).booleanValue()) {
            return null;
        }
        if (this.zzgwl == null) {
            return null;
        }
        return this.zzgwl.zzajz();
    }

    public final zzxo zzki() {
        return this.zzgvs.zzaru();
    }

    public final zzwt zzkj() {
        return this.zzgvs.zzart();
    }
}
