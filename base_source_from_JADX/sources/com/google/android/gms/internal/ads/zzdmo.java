package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.concurrent.GuardedBy;

public final class zzdmo extends zzaul {
    private final zzdni zzfxk;
    @GuardedBy("this")
    private boolean zzgwm = false;
    private final zzdma zzhgg;
    private final zzdlf zzhgh;
    /* access modifiers changed from: private */
    @GuardedBy("this")
    public zzchc zzhgi;

    public zzdmo(zzdma zzdma, zzdlf zzdlf, zzdni zzdni) {
        this.zzhgg = zzdma;
        this.zzhgh = zzdlf;
        this.zzfxk = zzdni;
    }

    private final synchronized boolean zzary() {
        return this.zzhgi != null && !this.zzhgi.isClosed();
    }

    public final void destroy() {
        zzl((IObjectWrapper) null);
    }

    public final Bundle getAdMetadata() {
        Preconditions.checkMainThread("getAdMetadata can only be called from the UI thread.");
        zzchc zzchc = this.zzhgi;
        return zzchc != null ? zzchc.getAdMetadata() : new Bundle();
    }

    public final synchronized String getMediationAdapterClassName() {
        if (this.zzhgi == null || this.zzhgi.zzajz() == null) {
            return null;
        }
        return this.zzhgi.zzajz().getMediationAdapterClassName();
    }

    public final boolean isLoaded() {
        Preconditions.checkMainThread("isLoaded must be called on the main UI thread.");
        return zzary();
    }

    public final void pause() {
        zzj((IObjectWrapper) null);
    }

    public final void resume() {
        zzk((IObjectWrapper) null);
    }

    public final void setAppPackageName(String str) {
    }

    public final synchronized void setCustomData(String str) {
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcon)).booleanValue()) {
            Preconditions.checkMainThread("#008 Must be called on the main UI thread.: setCustomData");
            this.zzfxk.zzdxz = str;
        }
    }

    public final synchronized void setImmersiveMode(boolean z) {
        Preconditions.checkMainThread("setImmersiveMode must be called on the main UI thread.");
        this.zzgwm = z;
    }

    public final synchronized void setUserId(String str) {
        Preconditions.checkMainThread("setUserId must be called on the main UI thread.");
        this.zzfxk.zzdxy = str;
    }

    public final synchronized void show() {
        zzi((IObjectWrapper) null);
    }

    public final void zza(zzaug zzaug) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.: setRewardedAdSkuListener");
        this.zzhgh.zzb(zzaug);
    }

    public final void zza(zzaup zzaup) {
        Preconditions.checkMainThread("setRewardedVideoAdListener can only be called from the UI thread.");
        this.zzhgh.zzb(zzaup);
    }

    public final synchronized void zza(zzauv zzauv) {
        Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        if (!zzabh.zzcp(zzauv.zzbum)) {
            if (zzary()) {
                if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcvd)).booleanValue()) {
                    return;
                }
            }
            zzdmb zzdmb = new zzdmb((String) null);
            this.zzhgi = null;
            this.zzhgg.zzec(zzdnf.zzhic);
            this.zzhgg.zza(zzauv.zzdsr, zzauv.zzbum, zzdmb, new zzdmr(this));
        }
    }

    public final void zza(zzxj zzxj) {
        Preconditions.checkMainThread("setAdMetadataListener can only be called from the UI thread.");
        if (zzxj == null) {
            this.zzhgh.zza((AdMetadataListener) null);
        } else {
            this.zzhgh.zza(new zzdmq(this, zzxj));
        }
    }

    public final synchronized void zzi(IObjectWrapper iObjectWrapper) {
        Activity activity;
        Preconditions.checkMainThread("showAd must be called on the main UI thread.");
        if (this.zzhgi != null) {
            if (iObjectWrapper != null) {
                Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
                if (unwrap instanceof Activity) {
                    activity = (Activity) unwrap;
                    this.zzhgi.zzb(this.zzgwm, activity);
                }
            }
            activity = null;
            this.zzhgi.zzb(this.zzgwm, activity);
        }
    }

    public final synchronized void zzj(IObjectWrapper iObjectWrapper) {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
        if (this.zzhgi != null) {
            this.zzhgi.zzajy().zzcc(iObjectWrapper == null ? null : (Context) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public final synchronized void zzk(IObjectWrapper iObjectWrapper) {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
        if (this.zzhgi != null) {
            this.zzhgi.zzajy().zzcd(iObjectWrapper == null ? null : (Context) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public final synchronized zzyn zzkh() {
        if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcxv)).booleanValue()) {
            return null;
        }
        if (this.zzhgi == null) {
            return null;
        }
        return this.zzhgi.zzajz();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: android.content.Context} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzl(com.google.android.gms.dynamic.IObjectWrapper r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.lang.String r0 = "destroy must be called on the main UI thread."
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r0)     // Catch:{ all -> 0x0025 }
            com.google.android.gms.internal.ads.zzdlf r0 = r2.zzhgh     // Catch:{ all -> 0x0025 }
            r1 = 0
            r0.zza(r1)     // Catch:{ all -> 0x0025 }
            com.google.android.gms.internal.ads.zzchc r0 = r2.zzhgi     // Catch:{ all -> 0x0025 }
            if (r0 == 0) goto L_0x0023
            if (r3 != 0) goto L_0x0013
            goto L_0x001a
        L_0x0013:
            java.lang.Object r3 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r3)     // Catch:{ all -> 0x0025 }
            r1 = r3
            android.content.Context r1 = (android.content.Context) r1     // Catch:{ all -> 0x0025 }
        L_0x001a:
            com.google.android.gms.internal.ads.zzchc r3 = r2.zzhgi     // Catch:{ all -> 0x0025 }
            com.google.android.gms.internal.ads.zzbso r3 = r3.zzajy()     // Catch:{ all -> 0x0025 }
            r3.zzce(r1)     // Catch:{ all -> 0x0025 }
        L_0x0023:
            monitor-exit(r2)
            return
        L_0x0025:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdmo.zzl(com.google.android.gms.dynamic.IObjectWrapper):void");
    }

    public final boolean zzrf() {
        zzchc zzchc = this.zzhgi;
        return zzchc != null && zzchc.zzrf();
    }
}
