package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;
import java.util.List;

public final class zzcgg extends zzagi {
    private final String zzchy;
    private final zzcce zzgaq;
    private final zzcbt zzgdx;

    public zzcgg(String str, zzcbt zzcbt, zzcce zzcce) {
        this.zzchy = str;
        this.zzgdx = zzcbt;
        this.zzgaq = zzcce;
    }

    public final void cancelUnconfirmedClick() {
        this.zzgdx.cancelUnconfirmedClick();
    }

    public final void destroy() {
        this.zzgdx.destroy();
    }

    public final String getAdvertiser() {
        return this.zzgaq.getAdvertiser();
    }

    public final String getBody() {
        return this.zzgaq.getBody();
    }

    public final String getCallToAction() {
        return this.zzgaq.getCallToAction();
    }

    public final Bundle getExtras() {
        return this.zzgaq.getExtras();
    }

    public final String getHeadline() {
        return this.zzgaq.getHeadline();
    }

    public final List<?> getImages() {
        return this.zzgaq.getImages();
    }

    public final String getMediationAdapterClassName() {
        return this.zzchy;
    }

    public final List<?> getMuteThisAdReasons() {
        return isCustomMuteThisAdEnabled() ? this.zzgaq.getMuteThisAdReasons() : Collections.emptyList();
    }

    public final String getPrice() {
        return this.zzgaq.getPrice();
    }

    public final double getStarRating() {
        return this.zzgaq.getStarRating();
    }

    public final String getStore() {
        return this.zzgaq.getStore();
    }

    public final zzys getVideoController() {
        return this.zzgaq.getVideoController();
    }

    public final boolean isCustomClickGestureEnabled() {
        return this.zzgdx.isCustomClickGestureEnabled();
    }

    public final boolean isCustomMuteThisAdEnabled() {
        return !this.zzgaq.getMuteThisAdReasons().isEmpty() && this.zzgaq.zzanf() != null;
    }

    public final void performClick(Bundle bundle) {
        this.zzgdx.zzf(bundle);
    }

    public final void recordCustomClickGesture() {
        this.zzgdx.recordCustomClickGesture();
    }

    public final boolean recordImpression(Bundle bundle) {
        return this.zzgdx.zzh(bundle);
    }

    public final void reportTouchEvent(Bundle bundle) {
        this.zzgdx.zzg(bundle);
    }

    public final void zza(zzage zzage) {
        this.zzgdx.zza(zzage);
    }

    public final void zza(zzxz zzxz) {
        this.zzgdx.zza(zzxz);
    }

    public final void zza(zzyd zzyd) {
        this.zzgdx.zza(zzyd);
    }

    public final void zza(zzym zzym) {
        this.zzgdx.zza(zzym);
    }

    public final zzyn zzkh() {
        if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcxv)).booleanValue()) {
            return null;
        }
        return this.zzgdx.zzajz();
    }

    public final IObjectWrapper zzsv() {
        return ObjectWrapper.wrap(this.zzgdx);
    }

    public final zzaej zzsw() {
        return this.zzgaq.zzsw();
    }

    public final zzaeb zzsx() {
        return this.zzgaq.zzsx();
    }

    public final IObjectWrapper zzsy() {
        return this.zzgaq.zzsy();
    }

    public final void zztg() {
        this.zzgdx.zztg();
    }

    public final zzaee zzth() {
        return this.zzgdx.zzamz().zzth();
    }
}
