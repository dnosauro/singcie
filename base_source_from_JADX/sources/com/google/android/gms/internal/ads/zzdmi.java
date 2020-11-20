package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.concurrent.GuardedBy;

public final class zzdmi extends zzavg {
    private final String zzbum;
    private final zzdni zzfxk;
    private final Context zzgvn;
    private final zzdma zzhgg;
    private final zzdlf zzhgh;
    /* access modifiers changed from: private */
    @GuardedBy("this")
    public zzchc zzhgi;

    public zzdmi(String str, zzdma zzdma, Context context, zzdlf zzdlf, zzdni zzdni) {
        this.zzbum = str;
        this.zzhgg = zzdma;
        this.zzhgh = zzdlf;
        this.zzfxk = zzdni;
        this.zzgvn = context;
    }

    private final synchronized void zza(zzvk zzvk, zzavp zzavp, int i) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        this.zzhgh.zzb(zzavp);
        zzp.zzkq();
        if (zzm.zzbb(this.zzgvn) && zzvk.zzchn == null) {
            zzd.zzey("Failed to load the ad because app ID is missing.");
            this.zzhgh.zzk(zzdoi.zza(zzdok.APP_ID_MISSING, (String) null, (zzve) null));
        } else if (this.zzhgi == null) {
            zzdmb zzdmb = new zzdmb((String) null);
            this.zzhgg.zzec(i);
            this.zzhgg.zza(zzvk, this.zzbum, zzdmb, new zzdmk(this));
        }
    }

    public final Bundle getAdMetadata() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
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
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzchc zzchc = this.zzhgi;
        return zzchc != null && !zzchc.isUsed();
    }

    public final synchronized void zza(IObjectWrapper iObjectWrapper, boolean z) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.zzhgi == null) {
            zzd.zzfa("Rewarded can not be shown before loaded");
            this.zzhgh.zzj(zzdoi.zza(zzdok.NOT_READY, (String) null, (zzve) null));
            return;
        }
        this.zzhgi.zzb(z, (Activity) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final void zza(zzavi zzavi) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        this.zzhgh.zzb(zzavi);
    }

    public final void zza(zzavq zzavq) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        this.zzhgh.zzb(zzavq);
    }

    public final synchronized void zza(zzavy zzavy) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzdni zzdni = this.zzfxk;
        zzdni.zzdxy = zzavy.zzdxy;
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcon)).booleanValue()) {
            zzdni.zzdxz = zzavy.zzdxz;
        }
    }

    public final synchronized void zza(zzvk zzvk, zzavp zzavp) {
        zza(zzvk, zzavp, zzdnf.zzhid);
    }

    public final void zza(zzyh zzyh) {
        if (zzyh == null) {
            this.zzhgh.zza((AdMetadataListener) null);
        } else {
            this.zzhgh.zza(new zzdml(this, zzyh));
        }
    }

    public final void zza(zzym zzym) {
        Preconditions.checkMainThread("setOnPaidEventListener must be called on the main UI thread.");
        this.zzhgh.zzd(zzym);
    }

    public final synchronized void zzb(zzvk zzvk, zzavp zzavp) {
        zza(zzvk, zzavp, zzdnf.zzhie);
    }

    public final synchronized void zzh(IObjectWrapper iObjectWrapper) {
        zza(iObjectWrapper, false);
    }

    public final zzyn zzkh() {
        zzchc zzchc;
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcxv)).booleanValue() && (zzchc = this.zzhgi) != null) {
            return zzchc.zzajz();
        }
        return null;
    }

    public final zzavc zzre() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzchc zzchc = this.zzhgi;
        if (zzchc != null) {
            return zzchc.zzre();
        }
        return null;
    }
}
