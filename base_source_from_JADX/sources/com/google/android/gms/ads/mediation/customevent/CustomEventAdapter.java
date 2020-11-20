package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzaza;

@KeepName
@KeepForSdkWithMembers
public final class CustomEventAdapter implements MediationBannerAdapter, MediationInterstitialAdapter, MediationNativeAdapter {
    @VisibleForTesting
    private static final AdError zzeup = new AdError(0, "Could not instantiate custom event adapter", MobileAds.ERROR_DOMAIN);
    @VisibleForTesting
    private CustomEventBanner zzeuq;
    @VisibleForTesting
    private CustomEventInterstitial zzeur;
    @VisibleForTesting
    private CustomEventNative zzeus;
    private View zznb;

    @VisibleForTesting
    class zza implements CustomEventInterstitialListener {
        private final CustomEventAdapter zzeut;
        private final MediationInterstitialListener zzeuu;

        public zza(CustomEventAdapter customEventAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.zzeut = customEventAdapter;
            this.zzeuu = mediationInterstitialListener;
        }

        public final void onAdClicked() {
            zzaza.zzeb("Custom event adapter called onAdClicked.");
            this.zzeuu.onAdClicked(this.zzeut);
        }

        public final void onAdClosed() {
            zzaza.zzeb("Custom event adapter called onAdClosed.");
            this.zzeuu.onAdClosed(this.zzeut);
        }

        public final void onAdFailedToLoad(int i) {
            zzaza.zzeb("Custom event adapter called onFailedToReceiveAd.");
            this.zzeuu.onAdFailedToLoad((MediationInterstitialAdapter) this.zzeut, i);
        }

        public final void onAdFailedToLoad(AdError adError) {
            zzaza.zzeb("Custom event adapter called onFailedToReceiveAd.");
            this.zzeuu.onAdFailedToLoad((MediationInterstitialAdapter) this.zzeut, adError);
        }

        public final void onAdLeftApplication() {
            zzaza.zzeb("Custom event adapter called onAdLeftApplication.");
            this.zzeuu.onAdLeftApplication(this.zzeut);
        }

        public final void onAdLoaded() {
            zzaza.zzeb("Custom event adapter called onReceivedAd.");
            this.zzeuu.onAdLoaded(CustomEventAdapter.this);
        }

        public final void onAdOpened() {
            zzaza.zzeb("Custom event adapter called onAdOpened.");
            this.zzeuu.onAdOpened(this.zzeut);
        }
    }

    @VisibleForTesting
    static final class zzb implements CustomEventBannerListener {
        private final CustomEventAdapter zzeut;
        private final MediationBannerListener zzeuw;

        public zzb(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.zzeut = customEventAdapter;
            this.zzeuw = mediationBannerListener;
        }

        public final void onAdClicked() {
            zzaza.zzeb("Custom event adapter called onAdClicked.");
            this.zzeuw.onAdClicked(this.zzeut);
        }

        public final void onAdClosed() {
            zzaza.zzeb("Custom event adapter called onAdClosed.");
            this.zzeuw.onAdClosed(this.zzeut);
        }

        public final void onAdFailedToLoad(int i) {
            zzaza.zzeb("Custom event adapter called onAdFailedToLoad.");
            this.zzeuw.onAdFailedToLoad((MediationBannerAdapter) this.zzeut, i);
        }

        public final void onAdFailedToLoad(AdError adError) {
            zzaza.zzeb("Custom event adapter called onAdFailedToLoad.");
            this.zzeuw.onAdFailedToLoad((MediationBannerAdapter) this.zzeut, adError);
        }

        public final void onAdLeftApplication() {
            zzaza.zzeb("Custom event adapter called onAdLeftApplication.");
            this.zzeuw.onAdLeftApplication(this.zzeut);
        }

        public final void onAdLoaded(View view) {
            zzaza.zzeb("Custom event adapter called onAdLoaded.");
            this.zzeut.zza(view);
            this.zzeuw.onAdLoaded(this.zzeut);
        }

        public final void onAdOpened() {
            zzaza.zzeb("Custom event adapter called onAdOpened.");
            this.zzeuw.onAdOpened(this.zzeut);
        }
    }

    @VisibleForTesting
    static class zzc implements CustomEventNativeListener {
        private final CustomEventAdapter zzeut;
        private final MediationNativeListener zzeux;

        public zzc(CustomEventAdapter customEventAdapter, MediationNativeListener mediationNativeListener) {
            this.zzeut = customEventAdapter;
            this.zzeux = mediationNativeListener;
        }

        public final void onAdClicked() {
            zzaza.zzeb("Custom event adapter called onAdClicked.");
            this.zzeux.onAdClicked(this.zzeut);
        }

        public final void onAdClosed() {
            zzaza.zzeb("Custom event adapter called onAdClosed.");
            this.zzeux.onAdClosed(this.zzeut);
        }

        public final void onAdFailedToLoad(int i) {
            zzaza.zzeb("Custom event adapter called onAdFailedToLoad.");
            this.zzeux.onAdFailedToLoad((MediationNativeAdapter) this.zzeut, i);
        }

        public final void onAdFailedToLoad(AdError adError) {
            zzaza.zzeb("Custom event adapter called onAdFailedToLoad.");
            this.zzeux.onAdFailedToLoad((MediationNativeAdapter) this.zzeut, adError);
        }

        public final void onAdImpression() {
            zzaza.zzeb("Custom event adapter called onAdImpression.");
            this.zzeux.onAdImpression(this.zzeut);
        }

        public final void onAdLeftApplication() {
            zzaza.zzeb("Custom event adapter called onAdLeftApplication.");
            this.zzeux.onAdLeftApplication(this.zzeut);
        }

        public final void onAdLoaded(NativeAdMapper nativeAdMapper) {
            zzaza.zzeb("Custom event adapter called onAdLoaded.");
            this.zzeux.onAdLoaded((MediationNativeAdapter) this.zzeut, nativeAdMapper);
        }

        public final void onAdLoaded(UnifiedNativeAdMapper unifiedNativeAdMapper) {
            zzaza.zzeb("Custom event adapter called onAdLoaded.");
            this.zzeux.onAdLoaded((MediationNativeAdapter) this.zzeut, unifiedNativeAdMapper);
        }

        public final void onAdOpened() {
            zzaza.zzeb("Custom event adapter called onAdOpened.");
            this.zzeux.onAdOpened(this.zzeut);
        }
    }

    /* access modifiers changed from: private */
    public final void zza(View view) {
        this.zznb = view;
    }

    private static <T> T zzal(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (Throwable th) {
            String message = th.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 46 + String.valueOf(message).length());
            sb.append("Could not instantiate custom event adapter: ");
            sb.append(str);
            sb.append(". ");
            sb.append(message);
            zzaza.zzfa(sb.toString());
            return null;
        }
    }

    public final View getBannerView() {
        return this.zznb;
    }

    public final void onDestroy() {
        CustomEventBanner customEventBanner = this.zzeuq;
        if (customEventBanner != null) {
            customEventBanner.onDestroy();
        }
        CustomEventInterstitial customEventInterstitial = this.zzeur;
        if (customEventInterstitial != null) {
            customEventInterstitial.onDestroy();
        }
        CustomEventNative customEventNative = this.zzeus;
        if (customEventNative != null) {
            customEventNative.onDestroy();
        }
    }

    public final void onPause() {
        CustomEventBanner customEventBanner = this.zzeuq;
        if (customEventBanner != null) {
            customEventBanner.onPause();
        }
        CustomEventInterstitial customEventInterstitial = this.zzeur;
        if (customEventInterstitial != null) {
            customEventInterstitial.onPause();
        }
        CustomEventNative customEventNative = this.zzeus;
        if (customEventNative != null) {
            customEventNative.onPause();
        }
    }

    public final void onResume() {
        CustomEventBanner customEventBanner = this.zzeuq;
        if (customEventBanner != null) {
            customEventBanner.onResume();
        }
        CustomEventInterstitial customEventInterstitial = this.zzeur;
        if (customEventInterstitial != null) {
            customEventInterstitial.onResume();
        }
        CustomEventNative customEventNative = this.zzeus;
        if (customEventNative != null) {
            customEventNative.onResume();
        }
    }

    public final void requestBannerAd(Context context, MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzeuq = (CustomEventBanner) zzal(bundle.getString("class_name"));
        if (this.zzeuq == null) {
            mediationBannerListener.onAdFailedToLoad((MediationBannerAdapter) this, zzeup);
            return;
        }
        this.zzeuq.requestBannerAd(context, new zzb(this, mediationBannerListener), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), adSize, mediationAdRequest, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
    }

    public final void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzeur = (CustomEventInterstitial) zzal(bundle.getString("class_name"));
        if (this.zzeur == null) {
            mediationInterstitialListener.onAdFailedToLoad((MediationInterstitialAdapter) this, zzeup);
            return;
        }
        this.zzeur.requestInterstitialAd(context, new zza(this, mediationInterstitialListener), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), mediationAdRequest, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
    }

    public final void requestNativeAd(Context context, MediationNativeListener mediationNativeListener, Bundle bundle, NativeMediationAdRequest nativeMediationAdRequest, Bundle bundle2) {
        this.zzeus = (CustomEventNative) zzal(bundle.getString("class_name"));
        if (this.zzeus == null) {
            mediationNativeListener.onAdFailedToLoad((MediationNativeAdapter) this, zzeup);
            return;
        }
        this.zzeus.requestNativeAd(context, new zzc(this, mediationNativeListener), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), nativeMediationAdRequest, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
    }

    public final void showInterstitial() {
        this.zzeur.showInterstitial();
    }
}
