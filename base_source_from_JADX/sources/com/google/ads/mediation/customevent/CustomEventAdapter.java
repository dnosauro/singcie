package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzaza;

@KeepName
public final class CustomEventAdapter implements MediationBannerAdapter<CustomEventExtras, CustomEventServerParameters>, MediationInterstitialAdapter<CustomEventExtras, CustomEventServerParameters> {
    private View zznb;
    @VisibleForTesting
    private CustomEventBanner zznc;
    @VisibleForTesting
    private CustomEventInterstitial zznd;

    @VisibleForTesting
    static final class zza implements CustomEventBannerListener {
        private final CustomEventAdapter zzmz;
        private final MediationBannerListener zzna;

        public zza(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.zzmz = customEventAdapter;
            this.zzna = mediationBannerListener;
        }

        public final void onClick() {
            zzaza.zzeb("Custom event adapter called onFailedToReceiveAd.");
            this.zzna.onClick(this.zzmz);
        }

        public final void onDismissScreen() {
            zzaza.zzeb("Custom event adapter called onFailedToReceiveAd.");
            this.zzna.onDismissScreen(this.zzmz);
        }

        public final void onFailedToReceiveAd() {
            zzaza.zzeb("Custom event adapter called onFailedToReceiveAd.");
            this.zzna.onFailedToReceiveAd(this.zzmz, AdRequest.ErrorCode.NO_FILL);
        }

        public final void onLeaveApplication() {
            zzaza.zzeb("Custom event adapter called onFailedToReceiveAd.");
            this.zzna.onLeaveApplication(this.zzmz);
        }

        public final void onPresentScreen() {
            zzaza.zzeb("Custom event adapter called onFailedToReceiveAd.");
            this.zzna.onPresentScreen(this.zzmz);
        }

        public final void onReceivedAd(View view) {
            zzaza.zzeb("Custom event adapter called onReceivedAd.");
            this.zzmz.zza(view);
            this.zzna.onReceivedAd(this.zzmz);
        }
    }

    @VisibleForTesting
    class zzb implements CustomEventInterstitialListener {
        private final CustomEventAdapter zzmz;
        private final MediationInterstitialListener zzne;

        public zzb(CustomEventAdapter customEventAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.zzmz = customEventAdapter;
            this.zzne = mediationInterstitialListener;
        }

        public final void onDismissScreen() {
            zzaza.zzeb("Custom event adapter called onDismissScreen.");
            this.zzne.onDismissScreen(this.zzmz);
        }

        public final void onFailedToReceiveAd() {
            zzaza.zzeb("Custom event adapter called onFailedToReceiveAd.");
            this.zzne.onFailedToReceiveAd(this.zzmz, AdRequest.ErrorCode.NO_FILL);
        }

        public final void onLeaveApplication() {
            zzaza.zzeb("Custom event adapter called onLeaveApplication.");
            this.zzne.onLeaveApplication(this.zzmz);
        }

        public final void onPresentScreen() {
            zzaza.zzeb("Custom event adapter called onPresentScreen.");
            this.zzne.onPresentScreen(this.zzmz);
        }

        public final void onReceivedAd() {
            zzaza.zzeb("Custom event adapter called onReceivedAd.");
            this.zzne.onReceivedAd(CustomEventAdapter.this);
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

    public final void destroy() {
        CustomEventBanner customEventBanner = this.zznc;
        if (customEventBanner != null) {
            customEventBanner.destroy();
        }
        CustomEventInterstitial customEventInterstitial = this.zznd;
        if (customEventInterstitial != null) {
            customEventInterstitial.destroy();
        }
    }

    public final Class<CustomEventExtras> getAdditionalParametersType() {
        return CustomEventExtras.class;
    }

    public final View getBannerView() {
        return this.zznb;
    }

    public final Class<CustomEventServerParameters> getServerParametersType() {
        return CustomEventServerParameters.class;
    }

    public final void requestBannerAd(MediationBannerListener mediationBannerListener, Activity activity, CustomEventServerParameters customEventServerParameters, AdSize adSize, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        this.zznc = (CustomEventBanner) zzal(customEventServerParameters.className);
        if (this.zznc == null) {
            mediationBannerListener.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
            return;
        }
        this.zznc.requestBannerAd(new zza(this, mediationBannerListener), activity, customEventServerParameters.label, customEventServerParameters.parameter, adSize, mediationAdRequest, customEventExtras == null ? null : customEventExtras.getExtra(customEventServerParameters.label));
    }

    public final void requestInterstitialAd(MediationInterstitialListener mediationInterstitialListener, Activity activity, CustomEventServerParameters customEventServerParameters, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        this.zznd = (CustomEventInterstitial) zzal(customEventServerParameters.className);
        if (this.zznd == null) {
            mediationInterstitialListener.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
            return;
        }
        this.zznd.requestInterstitialAd(new zzb(this, mediationInterstitialListener), activity, customEventServerParameters.label, customEventServerParameters.parameter, mediationAdRequest, customEventExtras == null ? null : customEventExtras.getExtra(customEventServerParameters.label));
    }

    public final void showInterstitial() {
        this.zznd.showInterstitial();
    }
}
