package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.GuardedBy;

public final class zzdjf extends zzxf implements zzp, zzsc {
    private final String zzbum;
    private final zzbgm zzgss;
    private final Context zzgvn;
    private AtomicBoolean zzhdd = new AtomicBoolean();
    /* access modifiers changed from: private */
    public final zzdir zzhdf;
    @GuardedBy("this")
    private zzbkv zzhdh;
    private final zzdjd zzhec;
    @GuardedBy("this")
    private long zzhed = -1;
    @GuardedBy("this")
    protected zzblv zzhee;

    public zzdjf(zzbgm zzbgm, Context context, String str, zzdjd zzdjd, zzdir zzdir) {
        this.zzgss = zzbgm;
        this.zzgvn = context;
        this.zzbum = str;
        this.zzhec = zzdjd;
        this.zzhdf = zzdir;
        zzdir.zza((zzp) this);
    }

    /* access modifiers changed from: private */
    public final void zza(zzblv zzblv) {
        zzblv.zza(this);
    }

    private final synchronized void zzeb(int i) {
        if (this.zzhdd.compareAndSet(false, true)) {
            this.zzhdf.onAdClosed();
            if (this.zzhdh != null) {
                com.google.android.gms.ads.internal.zzp.zzkt().zzb(this.zzhdh);
            }
            if (this.zzhee != null) {
                long j = -1;
                if (this.zzhed != -1) {
                    j = com.google.android.gms.ads.internal.zzp.zzkx().elapsedRealtime() - this.zzhed;
                }
                this.zzhee.zzb(j, i);
            }
            destroy();
        }
    }

    public final synchronized void destroy() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        if (this.zzhee != null) {
            this.zzhee.destroy();
        }
    }

    public final Bundle getAdMetadata() {
        return new Bundle();
    }

    public final synchronized String getAdUnitId() {
        return this.zzbum;
    }

    public final synchronized String getMediationAdapterClassName() {
        return null;
    }

    public final synchronized zzys getVideoController() {
        return null;
    }

    public final synchronized boolean isLoading() {
        return this.zzhec.isLoading();
    }

    public final boolean isReady() {
        return false;
    }

    public final void onPause() {
    }

    public final void onResume() {
    }

    public final synchronized void onUserLeaveHint() {
        if (this.zzhee != null) {
            this.zzhee.zzb(com.google.android.gms.ads.internal.zzp.zzkx().elapsedRealtime() - this.zzhed, zzblb.zzfsf);
        }
    }

    public final synchronized void pause() {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
    }

    public final synchronized void resume() {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
    }

    public final void setImmersiveMode(boolean z) {
    }

    public final synchronized void setManualImpressionsEnabled(boolean z) {
    }

    public final void setUserId(String str) {
    }

    public final synchronized void showInterstitial() {
    }

    public final void stopLoading() {
    }

    public final void zza(zzl zzl) {
        int i;
        switch (zzdji.zzhef[zzl.ordinal()]) {
            case 1:
                i = zzblb.zzfsh;
                break;
            case 2:
                i = zzblb.zzfsg;
                break;
            case 3:
                i = zzblb.zzfsi;
                break;
            case 4:
                zzeb(zzblb.zzfsk);
                return;
            default:
                return;
        }
        zzeb(i);
    }

    public final synchronized void zza(zzaak zzaak) {
    }

    public final synchronized void zza(zzacb zzacb) {
    }

    public final void zza(zzart zzart) {
    }

    public final void zza(zzarz zzarz, String str) {
    }

    public final void zza(zzaup zzaup) {
    }

    public final void zza(zzsl zzsl) {
        this.zzhdf.zzb(zzsl);
    }

    public final synchronized void zza(zzvn zzvn) {
        Preconditions.checkMainThread("setAdSize must be called on the main UI thread.");
    }

    public final void zza(zzvw zzvw) {
        this.zzhec.zza(zzvw);
    }

    public final void zza(zzws zzws) {
    }

    public final void zza(zzwt zzwt) {
    }

    public final void zza(zzxj zzxj) {
    }

    public final void zza(zzxo zzxo) {
    }

    public final synchronized void zza(zzxu zzxu) {
    }

    public final void zza(zzym zzym) {
    }

    public final void zza(zzyy zzyy) {
    }

    public final synchronized boolean zza(zzvk zzvk) {
        Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        com.google.android.gms.ads.internal.zzp.zzkq();
        if (zzm.zzbb(this.zzgvn) && zzvk.zzchn == null) {
            zzd.zzey("Failed to load the ad because app ID is missing.");
            this.zzhdf.zzk(zzdoi.zza(zzdok.APP_ID_MISSING, (String) null, (zzve) null));
            return false;
        } else if (isLoading()) {
            return false;
        } else {
            this.zzhdd = new AtomicBoolean();
            return this.zzhec.zza(zzvk, this.zzbum, new zzdjg(this), new zzdjj(this));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzatw() {
        this.zzgss.zzaek().execute(new zzdje(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzatx() {
        zzeb(zzblb.zzfsj);
    }

    public final void zzbl(String str) {
    }

    public final IObjectWrapper zzkd() {
        return null;
    }

    public final synchronized void zzke() {
    }

    public final synchronized zzvn zzkf() {
        return null;
    }

    public final synchronized String zzkg() {
        return null;
    }

    public final synchronized zzyn zzkh() {
        return null;
    }

    public final zzxo zzki() {
        return null;
    }

    public final zzwt zzkj() {
        return null;
    }

    public final void zzms() {
        zzeb(zzblb.zzfsh);
    }

    public final synchronized void zzux() {
        if (this.zzhee != null) {
            this.zzhed = com.google.android.gms.ads.internal.zzp.zzkx().elapsedRealtime();
            int zzaip = this.zzhee.zzaip();
            if (zzaip > 0) {
                this.zzhdh = new zzbkv(this.zzgss.zzael(), com.google.android.gms.ads.internal.zzp.zzkx());
                this.zzhdh.zza(zzaip, new zzdjh(this));
            }
        }
    }
}
