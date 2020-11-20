package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;

public final class zzcfx extends zzaew {
    private final String zzchy;
    private final zzcce zzgaq;
    private final zzcbt zzgdx;

    public zzcfx(String str, zzcbt zzcbt, zzcce zzcce) {
        this.zzchy = str;
        this.zzgdx = zzcbt;
        this.zzgaq = zzcce;
    }

    public final void destroy() {
        this.zzgdx.destroy();
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

    public final void performClick(Bundle bundle) {
        this.zzgdx.zzf(bundle);
    }

    public final boolean recordImpression(Bundle bundle) {
        return this.zzgdx.zzh(bundle);
    }

    public final void reportTouchEvent(Bundle bundle) {
        this.zzgdx.zzg(bundle);
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
}
