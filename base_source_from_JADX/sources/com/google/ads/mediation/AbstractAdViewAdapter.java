package com.google.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAdView;
import com.google.android.gms.ads.formats.NativeAdViewHolder;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdView;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.ads.mediation.OnImmersiveModeUpdatedListener;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzayr;
import com.google.android.gms.internal.ads.zzaza;
import com.google.android.gms.internal.ads.zzbgj;
import com.google.android.gms.internal.ads.zzva;
import com.google.android.gms.internal.ads.zzwq;
import com.google.android.gms.internal.ads.zzys;
import java.util.Date;
import java.util.Map;
import java.util.Set;

public abstract class AbstractAdViewAdapter implements MediationBannerAdapter, MediationNativeAdapter, OnImmersiveModeUpdatedListener, com.google.android.gms.ads.mediation.zza, MediationRewardedVideoAdAdapter, zzbgj {
    public static final String AD_UNIT_ID_PARAMETER = "pubid";
    private AdView zzmf;
    private InterstitialAd zzmg;
    private AdLoader zzmh;
    private Context zzmi;
    /* access modifiers changed from: private */
    public InterstitialAd zzmj;
    /* access modifiers changed from: private */
    public MediationRewardedVideoAdListener zzmk;
    @VisibleForTesting
    private final RewardedVideoAdListener zzml = new zzb(this);

    static class zza extends NativeContentAdMapper {
        private final NativeContentAd zzmn;

        public zza(NativeContentAd nativeContentAd) {
            this.zzmn = nativeContentAd;
            setHeadline(nativeContentAd.getHeadline().toString());
            setImages(nativeContentAd.getImages());
            setBody(nativeContentAd.getBody().toString());
            if (nativeContentAd.getLogo() != null) {
                setLogo(nativeContentAd.getLogo());
            }
            setCallToAction(nativeContentAd.getCallToAction().toString());
            setAdvertiser(nativeContentAd.getAdvertiser().toString());
            setOverrideImpressionRecording(true);
            setOverrideClickHandling(true);
            zza(nativeContentAd.getVideoController());
        }

        public final void trackView(View view) {
            if (view instanceof NativeAdView) {
                ((NativeAdView) view).setNativeAd(this.zzmn);
            }
            NativeAdViewHolder nativeAdViewHolder = NativeAdViewHolder.zzbnt.get(view);
            if (nativeAdViewHolder != null) {
                nativeAdViewHolder.setNativeAd((NativeAd) this.zzmn);
            }
        }
    }

    static class zzb extends NativeAppInstallAdMapper {
        private final NativeAppInstallAd zzmo;

        public zzb(NativeAppInstallAd nativeAppInstallAd) {
            this.zzmo = nativeAppInstallAd;
            setHeadline(nativeAppInstallAd.getHeadline().toString());
            setImages(nativeAppInstallAd.getImages());
            setBody(nativeAppInstallAd.getBody().toString());
            setIcon(nativeAppInstallAd.getIcon());
            setCallToAction(nativeAppInstallAd.getCallToAction().toString());
            if (nativeAppInstallAd.getStarRating() != null) {
                setStarRating(nativeAppInstallAd.getStarRating().doubleValue());
            }
            if (nativeAppInstallAd.getStore() != null) {
                setStore(nativeAppInstallAd.getStore().toString());
            }
            if (nativeAppInstallAd.getPrice() != null) {
                setPrice(nativeAppInstallAd.getPrice().toString());
            }
            setOverrideImpressionRecording(true);
            setOverrideClickHandling(true);
            zza(nativeAppInstallAd.getVideoController());
        }

        public final void trackView(View view) {
            if (view instanceof NativeAdView) {
                ((NativeAdView) view).setNativeAd(this.zzmo);
            }
            NativeAdViewHolder nativeAdViewHolder = NativeAdViewHolder.zzbnt.get(view);
            if (nativeAdViewHolder != null) {
                nativeAdViewHolder.setNativeAd((NativeAd) this.zzmo);
            }
        }
    }

    @VisibleForTesting
    static final class zzc extends AdListener implements AppEventListener, zzva {
        @VisibleForTesting
        private final AbstractAdViewAdapter zzmp;
        @VisibleForTesting
        private final MediationBannerListener zzmq;

        public zzc(AbstractAdViewAdapter abstractAdViewAdapter, MediationBannerListener mediationBannerListener) {
            this.zzmp = abstractAdViewAdapter;
            this.zzmq = mediationBannerListener;
        }

        public final void onAdClicked() {
            this.zzmq.onAdClicked(this.zzmp);
        }

        public final void onAdClosed() {
            this.zzmq.onAdClosed(this.zzmp);
        }

        public final void onAdFailedToLoad(int i) {
            this.zzmq.onAdFailedToLoad((MediationBannerAdapter) this.zzmp, i);
        }

        public final void onAdLeftApplication() {
            this.zzmq.onAdLeftApplication(this.zzmp);
        }

        public final void onAdLoaded() {
            this.zzmq.onAdLoaded(this.zzmp);
        }

        public final void onAdOpened() {
            this.zzmq.onAdOpened(this.zzmp);
        }

        public final void onAppEvent(String str, String str2) {
            this.zzmq.zza(this.zzmp, str, str2);
        }
    }

    static class zzd extends UnifiedNativeAdMapper {
        private final UnifiedNativeAd zzmr;

        public zzd(UnifiedNativeAd unifiedNativeAd) {
            this.zzmr = unifiedNativeAd;
            setHeadline(unifiedNativeAd.getHeadline());
            setImages(unifiedNativeAd.getImages());
            setBody(unifiedNativeAd.getBody());
            setIcon(unifiedNativeAd.getIcon());
            setCallToAction(unifiedNativeAd.getCallToAction());
            setAdvertiser(unifiedNativeAd.getAdvertiser());
            setStarRating(unifiedNativeAd.getStarRating());
            setStore(unifiedNativeAd.getStore());
            setPrice(unifiedNativeAd.getPrice());
            zzn(unifiedNativeAd.zzjw());
            setOverrideImpressionRecording(true);
            setOverrideClickHandling(true);
            zza(unifiedNativeAd.getVideoController());
        }

        public final void trackViews(View view, Map<String, View> map, Map<String, View> map2) {
            if (view instanceof UnifiedNativeAdView) {
                ((UnifiedNativeAdView) view).setNativeAd(this.zzmr);
                return;
            }
            NativeAdViewHolder nativeAdViewHolder = NativeAdViewHolder.zzbnt.get(view);
            if (nativeAdViewHolder != null) {
                nativeAdViewHolder.setNativeAd(this.zzmr);
            }
        }
    }

    @VisibleForTesting
    static final class zze extends AdListener implements NativeAppInstallAd.OnAppInstallAdLoadedListener, NativeContentAd.OnContentAdLoadedListener, NativeCustomTemplateAd.OnCustomClickListener, NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener, UnifiedNativeAd.OnUnifiedNativeAdLoadedListener {
        @VisibleForTesting
        private final AbstractAdViewAdapter zzmp;
        @VisibleForTesting
        private final MediationNativeListener zzms;

        public zze(AbstractAdViewAdapter abstractAdViewAdapter, MediationNativeListener mediationNativeListener) {
            this.zzmp = abstractAdViewAdapter;
            this.zzms = mediationNativeListener;
        }

        public final void onAdClicked() {
            this.zzms.onAdClicked(this.zzmp);
        }

        public final void onAdClosed() {
            this.zzms.onAdClosed(this.zzmp);
        }

        public final void onAdFailedToLoad(int i) {
            this.zzms.onAdFailedToLoad((MediationNativeAdapter) this.zzmp, i);
        }

        public final void onAdImpression() {
            this.zzms.onAdImpression(this.zzmp);
        }

        public final void onAdLeftApplication() {
            this.zzms.onAdLeftApplication(this.zzmp);
        }

        public final void onAdLoaded() {
        }

        public final void onAdOpened() {
            this.zzms.onAdOpened(this.zzmp);
        }

        public final void onAppInstallAdLoaded(NativeAppInstallAd nativeAppInstallAd) {
            this.zzms.onAdLoaded((MediationNativeAdapter) this.zzmp, (NativeAdMapper) new zzb(nativeAppInstallAd));
        }

        public final void onContentAdLoaded(NativeContentAd nativeContentAd) {
            this.zzms.onAdLoaded((MediationNativeAdapter) this.zzmp, (NativeAdMapper) new zza(nativeContentAd));
        }

        public final void onCustomClick(NativeCustomTemplateAd nativeCustomTemplateAd, String str) {
            this.zzms.zza(this.zzmp, nativeCustomTemplateAd, str);
        }

        public final void onCustomTemplateAdLoaded(NativeCustomTemplateAd nativeCustomTemplateAd) {
            this.zzms.zza(this.zzmp, nativeCustomTemplateAd);
        }

        public final void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
            this.zzms.onAdLoaded((MediationNativeAdapter) this.zzmp, (UnifiedNativeAdMapper) new zzd(unifiedNativeAd));
        }
    }

    @VisibleForTesting
    static final class zzf extends AdListener implements zzva {
        @VisibleForTesting
        private final AbstractAdViewAdapter zzmp;
        @VisibleForTesting
        private final MediationInterstitialListener zzmt;

        public zzf(AbstractAdViewAdapter abstractAdViewAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.zzmp = abstractAdViewAdapter;
            this.zzmt = mediationInterstitialListener;
        }

        public final void onAdClicked() {
            this.zzmt.onAdClicked(this.zzmp);
        }

        public final void onAdClosed() {
            this.zzmt.onAdClosed(this.zzmp);
        }

        public final void onAdFailedToLoad(int i) {
            this.zzmt.onAdFailedToLoad((MediationInterstitialAdapter) this.zzmp, i);
        }

        public final void onAdLeftApplication() {
            this.zzmt.onAdLeftApplication(this.zzmp);
        }

        public final void onAdLoaded() {
            this.zzmt.onAdLoaded(this.zzmp);
        }

        public final void onAdOpened() {
            this.zzmt.onAdOpened(this.zzmp);
        }
    }

    private final AdRequest zza(Context context, MediationAdRequest mediationAdRequest, Bundle bundle, Bundle bundle2) {
        AdRequest.Builder builder = new AdRequest.Builder();
        Date birthday = mediationAdRequest.getBirthday();
        if (birthday != null) {
            builder.setBirthday(birthday);
        }
        int gender = mediationAdRequest.getGender();
        if (gender != 0) {
            builder.setGender(gender);
        }
        Set<String> keywords = mediationAdRequest.getKeywords();
        if (keywords != null) {
            for (String addKeyword : keywords) {
                builder.addKeyword(addKeyword);
            }
        }
        Location location = mediationAdRequest.getLocation();
        if (location != null) {
            builder.setLocation(location);
        }
        if (mediationAdRequest.isTesting()) {
            zzwq.zzqa();
            builder.addTestDevice(zzayr.zzbn(context));
        }
        if (mediationAdRequest.taggedForChildDirectedTreatment() != -1) {
            boolean z = true;
            if (mediationAdRequest.taggedForChildDirectedTreatment() != 1) {
                z = false;
            }
            builder.tagForChildDirectedTreatment(z);
        }
        builder.setIsDesignedForFamilies(mediationAdRequest.isDesignedForFamilies());
        builder.addNetworkExtrasBundle(AdMobAdapter.class, zza(bundle, bundle2));
        return builder.build();
    }

    public String getAdUnitId(Bundle bundle) {
        return bundle.getString(AD_UNIT_ID_PARAMETER);
    }

    public View getBannerView() {
        return this.zzmf;
    }

    public Bundle getInterstitialAdapterInfo() {
        return new MediationAdapter.zza().zzdw(1).zzaed();
    }

    public zzys getVideoController() {
        VideoController videoController;
        AdView adView = this.zzmf;
        if (adView == null || (videoController = adView.getVideoController()) == null) {
            return null;
        }
        return videoController.zzdw();
    }

    public void initialize(Context context, MediationAdRequest mediationAdRequest, String str, MediationRewardedVideoAdListener mediationRewardedVideoAdListener, Bundle bundle, Bundle bundle2) {
        this.zzmi = context.getApplicationContext();
        this.zzmk = mediationRewardedVideoAdListener;
        this.zzmk.onInitializationSucceeded(this);
    }

    public boolean isInitialized() {
        return this.zzmk != null;
    }

    public void loadAd(MediationAdRequest mediationAdRequest, Bundle bundle, Bundle bundle2) {
        Context context = this.zzmi;
        if (context == null || this.zzmk == null) {
            zzaza.zzey("AdMobAdapter.loadAd called before initialize.");
            return;
        }
        this.zzmj = new InterstitialAd(context);
        this.zzmj.zzd(true);
        this.zzmj.setAdUnitId(getAdUnitId(bundle));
        this.zzmj.setRewardedVideoAdListener(this.zzml);
        this.zzmj.setAdMetadataListener(new zza(this));
        this.zzmj.loadAd(zza(this.zzmi, mediationAdRequest, bundle2, bundle));
    }

    public void onDestroy() {
        AdView adView = this.zzmf;
        if (adView != null) {
            adView.destroy();
            this.zzmf = null;
        }
        if (this.zzmg != null) {
            this.zzmg = null;
        }
        if (this.zzmh != null) {
            this.zzmh = null;
        }
        if (this.zzmj != null) {
            this.zzmj = null;
        }
    }

    public void onImmersiveModeUpdated(boolean z) {
        InterstitialAd interstitialAd = this.zzmg;
        if (interstitialAd != null) {
            interstitialAd.setImmersiveMode(z);
        }
        InterstitialAd interstitialAd2 = this.zzmj;
        if (interstitialAd2 != null) {
            interstitialAd2.setImmersiveMode(z);
        }
    }

    public void onPause() {
        AdView adView = this.zzmf;
        if (adView != null) {
            adView.pause();
        }
    }

    public void onResume() {
        AdView adView = this.zzmf;
        if (adView != null) {
            adView.resume();
        }
    }

    public void requestBannerAd(Context context, MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzmf = new AdView(context);
        this.zzmf.setAdSize(new AdSize(adSize.getWidth(), adSize.getHeight()));
        this.zzmf.setAdUnitId(getAdUnitId(bundle));
        this.zzmf.setAdListener(new zzc(this, mediationBannerListener));
        this.zzmf.loadAd(zza(context, mediationAdRequest, bundle2, bundle));
    }

    public void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzmg = new InterstitialAd(context);
        this.zzmg.setAdUnitId(getAdUnitId(bundle));
        this.zzmg.setAdListener(new zzf(this, mediationInterstitialListener));
        this.zzmg.loadAd(zza(context, mediationAdRequest, bundle2, bundle));
    }

    public void requestNativeAd(Context context, MediationNativeListener mediationNativeListener, Bundle bundle, NativeMediationAdRequest nativeMediationAdRequest, Bundle bundle2) {
        zze zze2 = new zze(this, mediationNativeListener);
        AdLoader.Builder withAdListener = new AdLoader.Builder(context, bundle.getString(AD_UNIT_ID_PARAMETER)).withAdListener(zze2);
        NativeAdOptions nativeAdOptions = nativeMediationAdRequest.getNativeAdOptions();
        if (nativeAdOptions != null) {
            withAdListener.withNativeAdOptions(nativeAdOptions);
        }
        if (nativeMediationAdRequest.isUnifiedNativeAdRequested()) {
            withAdListener.forUnifiedNativeAd(zze2);
        }
        if (nativeMediationAdRequest.isAppInstallAdRequested()) {
            withAdListener.forAppInstallAd(zze2);
        }
        if (nativeMediationAdRequest.isContentAdRequested()) {
            withAdListener.forContentAd(zze2);
        }
        if (nativeMediationAdRequest.zzuu()) {
            for (String next : nativeMediationAdRequest.zzuv().keySet()) {
                withAdListener.forCustomTemplateAd(next, zze2, nativeMediationAdRequest.zzuv().get(next).booleanValue() ? zze2 : null);
            }
        }
        this.zzmh = withAdListener.build();
        this.zzmh.loadAd(zza(context, nativeMediationAdRequest, bundle2, bundle));
    }

    public void showInterstitial() {
        this.zzmg.show();
    }

    public void showVideo() {
        this.zzmj.show();
    }

    /* access modifiers changed from: protected */
    public abstract Bundle zza(Bundle bundle, Bundle bundle2);
}
