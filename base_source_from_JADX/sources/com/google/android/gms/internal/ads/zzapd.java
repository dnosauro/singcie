package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class zzapd extends zzaoa {
    private final UnifiedNativeAdMapper zzdno;

    public zzapd(UnifiedNativeAdMapper unifiedNativeAdMapper) {
        this.zzdno = unifiedNativeAdMapper;
    }

    public final String getAdvertiser() {
        return this.zzdno.getAdvertiser();
    }

    public final String getBody() {
        return this.zzdno.getBody();
    }

    public final String getCallToAction() {
        return this.zzdno.getCallToAction();
    }

    public final Bundle getExtras() {
        return this.zzdno.getExtras();
    }

    public final String getHeadline() {
        return this.zzdno.getHeadline();
    }

    public final List getImages() {
        List<NativeAd.Image> images = this.zzdno.getImages();
        ArrayList arrayList = new ArrayList();
        if (images != null) {
            for (NativeAd.Image next : images) {
                arrayList.add(new zzadv(next.getDrawable(), next.getUri(), next.getScale(), next.getWidth(), next.getHeight()));
            }
        }
        return arrayList;
    }

    public final float getMediaContentAspectRatio() {
        return this.zzdno.getMediaContentAspectRatio();
    }

    public final boolean getOverrideClickHandling() {
        return this.zzdno.getOverrideClickHandling();
    }

    public final boolean getOverrideImpressionRecording() {
        return this.zzdno.getOverrideImpressionRecording();
    }

    public final String getPrice() {
        return this.zzdno.getPrice();
    }

    public final double getStarRating() {
        if (this.zzdno.getStarRating() != null) {
            return this.zzdno.getStarRating().doubleValue();
        }
        return -1.0d;
    }

    public final String getStore() {
        return this.zzdno.getStore();
    }

    public final zzys getVideoController() {
        if (this.zzdno.getVideoController() != null) {
            return this.zzdno.getVideoController().zzdw();
        }
        return null;
    }

    public final float getVideoCurrentTime() {
        return this.zzdno.getCurrentTime();
    }

    public final float getVideoDuration() {
        return this.zzdno.getDuration();
    }

    public final void recordImpression() {
        this.zzdno.recordImpression();
    }

    public final void zzc(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        this.zzdno.trackViews((View) ObjectWrapper.unwrap(iObjectWrapper), (HashMap) ObjectWrapper.unwrap(iObjectWrapper2), (HashMap) ObjectWrapper.unwrap(iObjectWrapper3));
    }

    public final zzaej zzsw() {
        NativeAd.Image icon = this.zzdno.getIcon();
        if (icon != null) {
            return new zzadv(icon.getDrawable(), icon.getUri(), icon.getScale(), icon.getWidth(), icon.getHeight());
        }
        return null;
    }

    public final zzaeb zzsx() {
        return null;
    }

    public final IObjectWrapper zzsy() {
        Object zzjw = this.zzdno.zzjw();
        if (zzjw == null) {
            return null;
        }
        return ObjectWrapper.wrap(zzjw);
    }

    public final void zzu(IObjectWrapper iObjectWrapper) {
        this.zzdno.handleClick((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final IObjectWrapper zzup() {
        View adChoicesContent = this.zzdno.getAdChoicesContent();
        if (adChoicesContent == null) {
            return null;
        }
        return ObjectWrapper.wrap(adChoicesContent);
    }

    public final IObjectWrapper zzuq() {
        View zzaee = this.zzdno.zzaee();
        if (zzaee == null) {
            return null;
        }
        return ObjectWrapper.wrap(zzaee);
    }

    public final void zzw(IObjectWrapper iObjectWrapper) {
        this.zzdno.untrackView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }
}
