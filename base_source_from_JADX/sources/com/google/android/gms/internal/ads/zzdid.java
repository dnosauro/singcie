package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.overlay.zzq;
import com.google.android.gms.ads.internal.overlay.zzr;
import com.google.android.gms.ads.internal.overlay.zzz;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.GuardedBy;

public final class zzdid extends zzxf implements zzz, zzbto, zzsc {
    /* access modifiers changed from: private */
    public final zzazh zzbos;
    private final String zzbum;
    /* access modifiers changed from: private */
    public final ViewGroup zzfsx;
    private final zzbgm zzgss;
    private final Context zzgvn;
    private AtomicBoolean zzhdd = new AtomicBoolean();
    private final zzdib zzhde;
    /* access modifiers changed from: private */
    public final zzdir zzhdf;
    private long zzhdg = -1;
    private zzbkv zzhdh;
    @GuardedBy("this")
    protected zzbll zzhdi;

    public zzdid(zzbgm zzbgm, Context context, String str, zzdib zzdib, zzdir zzdir, zzazh zzazh) {
        this.zzfsx = new FrameLayout(context);
        this.zzgss = zzbgm;
        this.zzgvn = context;
        this.zzbum = str;
        this.zzhde = zzdib;
        this.zzhdf = zzdir;
        zzdir.zza((zzbto) this);
        this.zzbos = zzazh;
    }

    /* access modifiers changed from: private */
    public final zzr zza(zzbll zzbll) {
        boolean zzaby = zzbll.zzaby();
        int intValue = ((Integer) zzwq.zzqe().zzd(zzabf.zzcub)).intValue();
        zzq zzq = new zzq();
        zzq.size = 50;
        zzq.paddingLeft = zzaby ? intValue : 0;
        zzq.paddingRight = zzaby ? 0 : intValue;
        zzq.paddingTop = 0;
        zzq.paddingBottom = intValue;
        return new zzr(this.zzgvn, zzq, this);
    }

    /* access modifiers changed from: private */
    public final zzvn zzats() {
        return zzdns.zzb(this.zzgvn, Collections.singletonList(this.zzhdi.zzaiy()));
    }

    /* access modifiers changed from: private */
    public static RelativeLayout.LayoutParams zzb(zzbll zzbll) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(zzbll.zzaby() ? 11 : 9);
        return layoutParams;
    }

    /* access modifiers changed from: private */
    public final void zzc(zzbll zzbll) {
        zzbll.zza((zzsc) this);
    }

    private final synchronized void zzeb(int i) {
        if (this.zzhdd.compareAndSet(false, true)) {
            if (!(this.zzhdi == null || this.zzhdi.zzajb() == null)) {
                this.zzhdf.zzb(this.zzhdi.zzajb());
            }
            this.zzhdf.onAdClosed();
            this.zzfsx.removeAllViews();
            if (this.zzhdh != null) {
                zzp.zzkt().zzb(this.zzhdh);
            }
            if (this.zzhdi != null) {
                long j = -1;
                if (this.zzhdg != -1) {
                    j = zzp.zzkx().elapsedRealtime() - this.zzhdg;
                }
                this.zzhdi.zzb(j, i);
            }
            destroy();
        }
    }

    public final synchronized void destroy() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        if (this.zzhdi != null) {
            this.zzhdi.destroy();
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
        return this.zzhde.isLoading();
    }

    public final boolean isReady() {
        return false;
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

    public final void showInterstitial() {
    }

    public final void stopLoading() {
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
        this.zzhde.zza(zzvw);
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
        zzp.zzkq();
        if (zzm.zzbb(this.zzgvn) && zzvk.zzchn == null) {
            zzd.zzey("Failed to load the ad because app ID is missing.");
            this.zzhdf.zzk(zzdoi.zza(zzdok.APP_ID_MISSING, (String) null, (zzve) null));
            return false;
        } else if (isLoading()) {
            return false;
        } else {
            this.zzhdd = new AtomicBoolean();
            return this.zzhde.zza(zzvk, this.zzbum, new zzdie(this), new zzdih(this));
        }
    }

    public final void zzakz() {
        if (this.zzhdi != null) {
            this.zzhdg = zzp.zzkx().elapsedRealtime();
            int zzaip = this.zzhdi.zzaip();
            if (zzaip > 0) {
                this.zzhdh = new zzbkv(this.zzgss.zzael(), zzp.zzkx());
                this.zzhdh.zza(zzaip, new zzdif(this));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzatt() {
        zzwq.zzqa();
        if (zzayr.zzze()) {
            zzeb(zzblb.zzfsj);
        } else {
            this.zzgss.zzaek().execute(new zzdic(this));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzatu() {
        zzeb(zzblb.zzfsj);
    }

    public final void zzbl(String str) {
    }

    public final IObjectWrapper zzkd() {
        Preconditions.checkMainThread("getAdFrame must be called on the main UI thread.");
        return ObjectWrapper.wrap(this.zzfsx);
    }

    public final synchronized void zzke() {
    }

    public final synchronized zzvn zzkf() {
        Preconditions.checkMainThread("getAdSize must be called on the main UI thread.");
        if (this.zzhdi == null) {
            return null;
        }
        return zzdns.zzb(this.zzgvn, Collections.singletonList(this.zzhdi.zzaiy()));
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

    public final void zzvd() {
        zzeb(zzblb.zzfsi);
    }
}
