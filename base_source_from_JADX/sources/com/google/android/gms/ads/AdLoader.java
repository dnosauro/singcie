package com.google.android.gms.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.formats.OnPublisherAdViewLoadedListener;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzadz;
import com.google.android.gms.internal.ads.zzafj;
import com.google.android.gms.internal.ads.zzafk;
import com.google.android.gms.internal.ads.zzafy;
import com.google.android.gms.internal.ads.zzagp;
import com.google.android.gms.internal.ads.zzags;
import com.google.android.gms.internal.ads.zzagt;
import com.google.android.gms.internal.ads.zzagv;
import com.google.android.gms.internal.ads.zzagx;
import com.google.android.gms.internal.ads.zzanj;
import com.google.android.gms.internal.ads.zzaza;
import com.google.android.gms.internal.ads.zzvg;
import com.google.android.gms.internal.ads.zzvl;
import com.google.android.gms.internal.ads.zzvn;
import com.google.android.gms.internal.ads.zzwq;
import com.google.android.gms.internal.ads.zzwt;
import com.google.android.gms.internal.ads.zzwy;
import com.google.android.gms.internal.ads.zzwz;
import com.google.android.gms.internal.ads.zzza;

public class AdLoader {
    private final Context context;
    private final zzvl zzacp;
    private final zzwy zzacq;

    public static class Builder {
        private final Context context;
        private final zzwz zzacs;

        private Builder(Context context2, zzwz zzwz) {
            this.context = context2;
            this.zzacs = zzwz;
        }

        public Builder(Context context2, String str) {
            this((Context) Preconditions.checkNotNull(context2, "context cannot be null"), zzwq.zzqb().zzb(context2, str, new zzanj()));
        }

        public AdLoader build() {
            try {
                return new AdLoader(this.context, this.zzacs.zzqj());
            } catch (RemoteException e) {
                zzaza.zzc("Failed to build AdLoader.", e);
                return null;
            }
        }

        @Deprecated
        public Builder forAppInstallAd(NativeAppInstallAd.OnAppInstallAdLoadedListener onAppInstallAdLoadedListener) {
            try {
                this.zzacs.zza((zzafj) new zzagt(onAppInstallAdLoadedListener));
            } catch (RemoteException e) {
                zzaza.zzd("Failed to add app install ad listener", e);
            }
            return this;
        }

        @Deprecated
        public Builder forContentAd(NativeContentAd.OnContentAdLoadedListener onContentAdLoadedListener) {
            try {
                this.zzacs.zza((zzafk) new zzags(onContentAdLoadedListener));
            } catch (RemoteException e) {
                zzaza.zzd("Failed to add content ad listener", e);
            }
            return this;
        }

        public Builder forCustomTemplateAd(String str, NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener, NativeCustomTemplateAd.OnCustomClickListener onCustomClickListener) {
            zzagp zzagp = new zzagp(onCustomTemplateAdLoadedListener, onCustomClickListener);
            try {
                this.zzacs.zza(str, zzagp.zzti(), zzagp.zztj());
            } catch (RemoteException e) {
                zzaza.zzd("Failed to add custom template ad listener", e);
            }
            return this;
        }

        public Builder forPublisherAdView(OnPublisherAdViewLoadedListener onPublisherAdViewLoadedListener, AdSize... adSizeArr) {
            if (adSizeArr == null || adSizeArr.length <= 0) {
                throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
            }
            try {
                this.zzacs.zza(new zzagv(onPublisherAdViewLoadedListener), new zzvn(this.context, adSizeArr));
            } catch (RemoteException e) {
                zzaza.zzd("Failed to add publisher banner ad listener", e);
            }
            return this;
        }

        public Builder forUnifiedNativeAd(UnifiedNativeAd.OnUnifiedNativeAdLoadedListener onUnifiedNativeAdLoadedListener) {
            try {
                this.zzacs.zza((zzafy) new zzagx(onUnifiedNativeAdLoadedListener));
            } catch (RemoteException e) {
                zzaza.zzd("Failed to add google native ad listener", e);
            }
            return this;
        }

        public Builder withAdListener(AdListener adListener) {
            try {
                this.zzacs.zzb((zzwt) new zzvg(adListener));
            } catch (RemoteException e) {
                zzaza.zzd("Failed to set AdListener.", e);
            }
            return this;
        }

        @KeepForSdk
        @Deprecated
        public Builder withCorrelator(Correlator correlator) {
            return this;
        }

        public Builder withNativeAdOptions(NativeAdOptions nativeAdOptions) {
            try {
                this.zzacs.zza(new zzadz(nativeAdOptions));
            } catch (RemoteException e) {
                zzaza.zzd("Failed to specify native ad options", e);
            }
            return this;
        }

        public Builder withPublisherAdViewOptions(PublisherAdViewOptions publisherAdViewOptions) {
            try {
                this.zzacs.zza(publisherAdViewOptions);
            } catch (RemoteException e) {
                zzaza.zzd("Failed to specify DFP banner ad options", e);
            }
            return this;
        }
    }

    AdLoader(Context context2, zzwy zzwy) {
        this(context2, zzwy, zzvl.zzcho);
    }

    private AdLoader(Context context2, zzwy zzwy, zzvl zzvl) {
        this.context = context2;
        this.zzacq = zzwy;
        this.zzacp = zzvl;
    }

    private final void zza(zzza zzza) {
        try {
            this.zzacq.zzb(zzvl.zza(this.context, zzza));
        } catch (RemoteException e) {
            zzaza.zzc("Failed to load ad.", e);
        }
    }

    @Deprecated
    public String getMediationAdapterClassName() {
        try {
            return this.zzacq.zzkg();
        } catch (RemoteException e) {
            zzaza.zzd("Failed to get the mediation adapter class name.", e);
            return null;
        }
    }

    public boolean isLoading() {
        try {
            return this.zzacq.isLoading();
        } catch (RemoteException e) {
            zzaza.zzd("Failed to check if ad is loading.", e);
            return false;
        }
    }

    public void loadAd(AdRequest adRequest) {
        zza(adRequest.zzds());
    }

    public void loadAd(PublisherAdRequest publisherAdRequest) {
        zza(publisherAdRequest.zzds());
    }

    public void loadAds(AdRequest adRequest, int i) {
        try {
            this.zzacq.zza(zzvl.zza(this.context, adRequest.zzds()), i);
        } catch (RemoteException e) {
            zzaza.zzc("Failed to load ads.", e);
        }
    }
}
