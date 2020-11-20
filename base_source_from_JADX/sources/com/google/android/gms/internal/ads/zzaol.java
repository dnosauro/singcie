package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class zzaol extends zzanu {
    private final NativeAppInstallAdMapper zzdne;

    public zzaol(NativeAppInstallAdMapper nativeAppInstallAdMapper) {
        this.zzdne = nativeAppInstallAdMapper;
    }

    public final String getBody() {
        return this.zzdne.getBody();
    }

    public final String getCallToAction() {
        return this.zzdne.getCallToAction();
    }

    public final Bundle getExtras() {
        return this.zzdne.getExtras();
    }

    public final String getHeadline() {
        return this.zzdne.getHeadline();
    }

    public final List getImages() {
        List<NativeAd.Image> images = this.zzdne.getImages();
        if (images == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (NativeAd.Image next : images) {
            arrayList.add(new zzadv(next.getDrawable(), next.getUri(), next.getScale(), next.getWidth(), next.getHeight()));
        }
        return arrayList;
    }

    public final boolean getOverrideClickHandling() {
        return this.zzdne.getOverrideClickHandling();
    }

    public final boolean getOverrideImpressionRecording() {
        return this.zzdne.getOverrideImpressionRecording();
    }

    public final String getPrice() {
        return this.zzdne.getPrice();
    }

    public final double getStarRating() {
        return this.zzdne.getStarRating();
    }

    public final String getStore() {
        return this.zzdne.getStore();
    }

    public final zzys getVideoController() {
        if (this.zzdne.getVideoController() != null) {
            return this.zzdne.getVideoController().zzdw();
        }
        return null;
    }

    public final void recordImpression() {
        this.zzdne.recordImpression();
    }

    public final void zzc(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        this.zzdne.trackViews((View) ObjectWrapper.unwrap(iObjectWrapper), (HashMap) ObjectWrapper.unwrap(iObjectWrapper2), (HashMap) ObjectWrapper.unwrap(iObjectWrapper3));
    }

    public final zzaej zzsw() {
        NativeAd.Image icon = this.zzdne.getIcon();
        if (icon != null) {
            return new zzadv(icon.getDrawable(), icon.getUri(), icon.getScale(), icon.getWidth(), icon.getHeight());
        }
        return null;
    }

    public final zzaeb zzsx() {
        return null;
    }

    public final IObjectWrapper zzsy() {
        return null;
    }

    public final void zzu(IObjectWrapper iObjectWrapper) {
        this.zzdne.handleClick((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final IObjectWrapper zzup() {
        View adChoicesContent = this.zzdne.getAdChoicesContent();
        if (adChoicesContent == null) {
            return null;
        }
        return ObjectWrapper.wrap(adChoicesContent);
    }

    public final IObjectWrapper zzuq() {
        View zzaee = this.zzdne.zzaee();
        if (zzaee == null) {
            return null;
        }
        return ObjectWrapper.wrap(zzaee);
    }

    public final void zzv(IObjectWrapper iObjectWrapper) {
        this.zzdne.trackView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final void zzw(IObjectWrapper iObjectWrapper) {
        this.zzdne.untrackView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }
}
