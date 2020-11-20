package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzaza;
import com.google.android.gms.internal.ads.zzxg;
import com.google.android.gms.internal.ads.zzzc;

public final class PublisherAdView extends ViewGroup {
    private final zzzc zzadz;

    public PublisherAdView(Context context) {
        super(context);
        this.zzadz = new zzzc(this);
    }

    public PublisherAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.zzadz = new zzzc(this, attributeSet, true);
        Preconditions.checkNotNull(context, "Context cannot be null");
    }

    public PublisherAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zzadz = new zzzc(this, attributeSet, true);
    }

    public final void destroy() {
        this.zzadz.destroy();
    }

    public final AdListener getAdListener() {
        return this.zzadz.getAdListener();
    }

    public final AdSize getAdSize() {
        return this.zzadz.getAdSize();
    }

    public final AdSize[] getAdSizes() {
        return this.zzadz.getAdSizes();
    }

    public final String getAdUnitId() {
        return this.zzadz.getAdUnitId();
    }

    public final AppEventListener getAppEventListener() {
        return this.zzadz.getAppEventListener();
    }

    @Deprecated
    public final String getMediationAdapterClassName() {
        return this.zzadz.getMediationAdapterClassName();
    }

    public final OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.zzadz.getOnCustomRenderedAdLoadedListener();
    }

    public final ResponseInfo getResponseInfo() {
        return this.zzadz.getResponseInfo();
    }

    public final VideoController getVideoController() {
        return this.zzadz.getVideoController();
    }

    public final VideoOptions getVideoOptions() {
        return this.zzadz.getVideoOptions();
    }

    public final boolean isLoading() {
        return this.zzadz.isLoading();
    }

    public final void loadAd(PublisherAdRequest publisherAdRequest) {
        this.zzadz.zza(publisherAdRequest.zzds());
    }

    /* access modifiers changed from: protected */
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt = getChildAt(0);
        if (childAt != null && childAt.getVisibility() != 8) {
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            int i5 = ((i3 - i) - measuredWidth) / 2;
            int i6 = ((i4 - i2) - measuredHeight) / 2;
            childAt.layout(i5, i6, measuredWidth + i5, measuredHeight + i6);
        }
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i, int i2) {
        int i3;
        int i4 = 0;
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            AdSize adSize = null;
            try {
                adSize = getAdSize();
            } catch (NullPointerException e) {
                zzaza.zzc("Unable to retrieve ad size.", e);
            }
            if (adSize != null) {
                Context context = getContext();
                int widthInPixels = adSize.getWidthInPixels(context);
                i3 = adSize.getHeightInPixels(context);
                i4 = widthInPixels;
            } else {
                i3 = 0;
            }
        } else {
            measureChild(childAt, i, i2);
            i4 = childAt.getMeasuredWidth();
            i3 = childAt.getMeasuredHeight();
        }
        setMeasuredDimension(View.resolveSize(Math.max(i4, getSuggestedMinimumWidth()), i), View.resolveSize(Math.max(i3, getSuggestedMinimumHeight()), i2));
    }

    public final void pause() {
        this.zzadz.pause();
    }

    public final void recordManualImpression() {
        this.zzadz.recordManualImpression();
    }

    public final void resume() {
        this.zzadz.resume();
    }

    public final void setAdListener(AdListener adListener) {
        this.zzadz.setAdListener(adListener);
    }

    public final void setAdSizes(AdSize... adSizeArr) {
        if (adSizeArr == null || adSizeArr.length <= 0) {
            throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
        }
        this.zzadz.zza(adSizeArr);
    }

    public final void setAdUnitId(String str) {
        this.zzadz.setAdUnitId(str);
    }

    public final void setAppEventListener(AppEventListener appEventListener) {
        this.zzadz.setAppEventListener(appEventListener);
    }

    @KeepForSdk
    @Deprecated
    public final void setCorrelator(Correlator correlator) {
    }

    public final void setManualImpressionsEnabled(boolean z) {
        this.zzadz.setManualImpressionsEnabled(z);
    }

    public final void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzadz.setOnCustomRenderedAdLoadedListener(onCustomRenderedAdLoadedListener);
    }

    public final void setVideoOptions(VideoOptions videoOptions) {
        this.zzadz.setVideoOptions(videoOptions);
    }

    public final boolean zza(zzxg zzxg) {
        return this.zzadz.zza(zzxg);
    }
}
