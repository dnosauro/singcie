package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;

public final class zzcxi extends zzxf {
    private final Context context;
    private final ViewGroup zzfsx;
    private final zzdnn zzfvl;
    private final zzwt zzgai;
    private final zzbme zzgvl;

    public zzcxi(Context context2, zzwt zzwt, zzdnn zzdnn, zzbme zzbme) {
        this.context = context2;
        this.zzgai = zzwt;
        this.zzfvl = zzdnn;
        this.zzgvl = zzbme;
        FrameLayout frameLayout = new FrameLayout(this.context);
        frameLayout.removeAllViews();
        frameLayout.addView(this.zzgvl.zzaiz(), zzp.zzks().zzyk());
        frameLayout.setMinimumHeight(zzkf().heightPixels);
        frameLayout.setMinimumWidth(zzkf().widthPixels);
        this.zzfsx = frameLayout;
    }

    public final void destroy() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.zzgvl.destroy();
    }

    public final Bundle getAdMetadata() {
        zzd.zzez("getAdMetadata is not supported in Publisher AdView returned by AdLoader.");
        return new Bundle();
    }

    public final String getAdUnitId() {
        return this.zzfvl.zzhip;
    }

    public final String getMediationAdapterClassName() {
        if (this.zzgvl.zzajz() != null) {
            return this.zzgvl.zzajz().getMediationAdapterClassName();
        }
        return null;
    }

    public final zzys getVideoController() {
        return this.zzgvl.getVideoController();
    }

    public final boolean isLoading() {
        return false;
    }

    public final boolean isReady() {
        return false;
    }

    public final void pause() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.zzgvl.zzajy().zzcc((Context) null);
    }

    public final void resume() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.zzgvl.zzajy().zzcd((Context) null);
    }

    public final void setImmersiveMode(boolean z) {
    }

    public final void setManualImpressionsEnabled(boolean z) {
        zzd.zzez("setManualImpressionsEnabled is not supported in Publisher AdView returned by AdLoader.");
    }

    public final void setUserId(String str) {
    }

    public final void showInterstitial() {
    }

    public final void stopLoading() {
    }

    public final void zza(zzaak zzaak) {
        zzd.zzez("setVideoOptions is not supported in Publisher AdView returned by AdLoader.");
    }

    public final void zza(zzacb zzacb) {
        zzd.zzez("setOnCustomRenderedAdLoadedListener is not supported in Publisher AdView returned by AdLoader.");
    }

    public final void zza(zzart zzart) {
    }

    public final void zza(zzarz zzarz, String str) {
    }

    public final void zza(zzaup zzaup) {
    }

    public final void zza(zzsl zzsl) {
    }

    public final void zza(zzvn zzvn) {
        Preconditions.checkMainThread("setAdSize must be called on the main UI thread.");
        zzbme zzbme = this.zzgvl;
        if (zzbme != null) {
            zzbme.zza(this.zzfsx, zzvn);
        }
    }

    public final void zza(zzvw zzvw) {
    }

    public final void zza(zzws zzws) {
        zzd.zzez("setAdClickListener is not supported in Publisher AdView returned by AdLoader.");
    }

    public final void zza(zzwt zzwt) {
        zzd.zzez("setAdListener is not supported in Publisher AdView returned by AdLoader.");
    }

    public final void zza(zzxj zzxj) {
        zzd.zzez("setAdMetadataListener is not supported in Publisher AdView returned by AdLoader.");
    }

    public final void zza(zzxo zzxo) {
        zzd.zzez("setAppEventListener is not supported in Publisher AdView returned by AdLoader.");
    }

    public final void zza(zzxu zzxu) {
        zzd.zzez("setCorrelationIdProvider is not supported in Publisher AdView returned by AdLoader.");
    }

    public final void zza(zzym zzym) {
        zzd.zzez("setOnPaidEventListener is not supported in Publisher AdView returned by AdLoader.");
    }

    public final void zza(zzyy zzyy) {
    }

    public final boolean zza(zzvk zzvk) {
        zzd.zzez("loadAd is not supported for a Publisher AdView returned from AdLoader.");
        return false;
    }

    public final void zzbl(String str) {
    }

    public final IObjectWrapper zzkd() {
        return ObjectWrapper.wrap(this.zzfsx);
    }

    public final void zzke() {
        this.zzgvl.zzke();
    }

    public final zzvn zzkf() {
        Preconditions.checkMainThread("getAdSize must be called on the main UI thread.");
        return zzdns.zzb(this.context, Collections.singletonList(this.zzgvl.zzaiy()));
    }

    public final String zzkg() {
        if (this.zzgvl.zzajz() != null) {
            return this.zzgvl.zzajz().getMediationAdapterClassName();
        }
        return null;
    }

    public final zzyn zzkh() {
        return this.zzgvl.zzajz();
    }

    public final zzxo zzki() {
        return this.zzfvl.zzhiu;
    }

    public final zzwt zzkj() {
        return this.zzgai;
    }
}
