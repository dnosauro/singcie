package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class zzaok extends zzanz {
    private final NativeContentAdMapper zzdnd;

    public zzaok(NativeContentAdMapper nativeContentAdMapper) {
        this.zzdnd = nativeContentAdMapper;
    }

    public final String getAdvertiser() {
        return this.zzdnd.getAdvertiser();
    }

    public final String getBody() {
        return this.zzdnd.getBody();
    }

    public final String getCallToAction() {
        return this.zzdnd.getCallToAction();
    }

    public final Bundle getExtras() {
        return this.zzdnd.getExtras();
    }

    public final String getHeadline() {
        return this.zzdnd.getHeadline();
    }

    public final List getImages() {
        List<NativeAd.Image> images = this.zzdnd.getImages();
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
        return this.zzdnd.getOverrideClickHandling();
    }

    public final boolean getOverrideImpressionRecording() {
        return this.zzdnd.getOverrideImpressionRecording();
    }

    public final zzys getVideoController() {
        if (this.zzdnd.getVideoController() != null) {
            return this.zzdnd.getVideoController().zzdw();
        }
        return null;
    }

    public final void recordImpression() {
        this.zzdnd.recordImpression();
    }

    public final void zzc(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        this.zzdnd.trackViews((View) ObjectWrapper.unwrap(iObjectWrapper), (HashMap) ObjectWrapper.unwrap(iObjectWrapper2), (HashMap) ObjectWrapper.unwrap(iObjectWrapper3));
    }

    public final zzaeb zzsx() {
        return null;
    }

    public final IObjectWrapper zzsy() {
        return null;
    }

    public final zzaej zzsz() {
        NativeAd.Image logo = this.zzdnd.getLogo();
        if (logo != null) {
            return new zzadv(logo.getDrawable(), logo.getUri(), logo.getScale(), logo.getWidth(), logo.getHeight());
        }
        return null;
    }

    public final void zzu(IObjectWrapper iObjectWrapper) {
        this.zzdnd.handleClick((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final IObjectWrapper zzup() {
        View adChoicesContent = this.zzdnd.getAdChoicesContent();
        if (adChoicesContent == null) {
            return null;
        }
        return ObjectWrapper.wrap(adChoicesContent);
    }

    public final IObjectWrapper zzuq() {
        View zzaee = this.zzdnd.zzaee();
        if (zzaee == null) {
            return null;
        }
        return ObjectWrapper.wrap(zzaee);
    }

    public final void zzv(IObjectWrapper iObjectWrapper) {
        this.zzdnd.trackView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final void zzw(IObjectWrapper iObjectWrapper) {
        this.zzdnd.untrackView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }
}
