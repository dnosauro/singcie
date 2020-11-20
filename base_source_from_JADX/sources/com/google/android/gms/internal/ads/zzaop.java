package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.AdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;

public final class zzaop<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> implements MediationBannerListener, MediationInterstitialListener {
    /* access modifiers changed from: private */
    public final zzano zzdmz;

    public zzaop(zzano zzano) {
        this.zzdmz = zzano;
    }

    public final void onClick(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzaza.zzeb("Adapter called onClick.");
        zzwq.zzqa();
        if (!zzayr.zzze()) {
            zzaza.zze("#008 Must be called on the main UI thread.", (Throwable) null);
            zzayr.zzzz.post(new zzaoo(this));
            return;
        }
        try {
            this.zzdmz.onAdClicked();
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onDismissScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzaza.zzeb("Adapter called onDismissScreen.");
        zzwq.zzqa();
        if (!zzayr.zzze()) {
            zzaza.zzfa("#008 Must be called on the main UI thread.");
            zzayr.zzzz.post(new zzaot(this));
            return;
        }
        try {
            this.zzdmz.onAdClosed();
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onDismissScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzaza.zzeb("Adapter called onDismissScreen.");
        zzwq.zzqa();
        if (!zzayr.zzze()) {
            zzaza.zze("#008 Must be called on the main UI thread.", (Throwable) null);
            zzayr.zzzz.post(new zzaow(this));
            return;
        }
        try {
            this.zzdmz.onAdClosed();
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onFailedToReceiveAd(MediationBannerAdapter<?, ?> mediationBannerAdapter, AdRequest.ErrorCode errorCode) {
        String valueOf = String.valueOf(errorCode);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
        sb.append("Adapter called onFailedToReceiveAd with error. ");
        sb.append(valueOf);
        zzaza.zzeb(sb.toString());
        zzwq.zzqa();
        if (!zzayr.zzze()) {
            zzaza.zze("#008 Must be called on the main UI thread.", (Throwable) null);
            zzayr.zzzz.post(new zzaos(this, errorCode));
            return;
        }
        try {
            this.zzdmz.onAdFailedToLoad(zzapb.zza(errorCode));
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter, AdRequest.ErrorCode errorCode) {
        String valueOf = String.valueOf(errorCode);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
        sb.append("Adapter called onFailedToReceiveAd with error ");
        sb.append(valueOf);
        sb.append(".");
        zzaza.zzeb(sb.toString());
        zzwq.zzqa();
        if (!zzayr.zzze()) {
            zzaza.zze("#008 Must be called on the main UI thread.", (Throwable) null);
            zzayr.zzzz.post(new zzaoz(this, errorCode));
            return;
        }
        try {
            this.zzdmz.onAdFailedToLoad(zzapb.zza(errorCode));
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onLeaveApplication(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzaza.zzeb("Adapter called onLeaveApplication.");
        zzwq.zzqa();
        if (!zzayr.zzze()) {
            zzaza.zze("#008 Must be called on the main UI thread.", (Throwable) null);
            zzayr.zzzz.post(new zzaov(this));
            return;
        }
        try {
            this.zzdmz.onAdLeftApplication();
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onLeaveApplication(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzaza.zzeb("Adapter called onLeaveApplication.");
        zzwq.zzqa();
        if (!zzayr.zzze()) {
            zzaza.zze("#008 Must be called on the main UI thread.", (Throwable) null);
            zzayr.zzzz.post(new zzaoy(this));
            return;
        }
        try {
            this.zzdmz.onAdLeftApplication();
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onPresentScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzaza.zzeb("Adapter called onPresentScreen.");
        zzwq.zzqa();
        if (!zzayr.zzze()) {
            zzaza.zze("#008 Must be called on the main UI thread.", (Throwable) null);
            zzayr.zzzz.post(new zzaou(this));
            return;
        }
        try {
            this.zzdmz.onAdOpened();
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onPresentScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzaza.zzeb("Adapter called onPresentScreen.");
        zzwq.zzqa();
        if (!zzayr.zzze()) {
            zzaza.zze("#008 Must be called on the main UI thread.", (Throwable) null);
            zzayr.zzzz.post(new zzaor(this));
            return;
        }
        try {
            this.zzdmz.onAdOpened();
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onReceivedAd(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzaza.zzeb("Adapter called onReceivedAd.");
        zzwq.zzqa();
        if (!zzayr.zzze()) {
            zzaza.zze("#008 Must be called on the main UI thread.", (Throwable) null);
            zzayr.zzzz.post(new zzaox(this));
            return;
        }
        try {
            this.zzdmz.onAdLoaded();
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void onReceivedAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzaza.zzeb("Adapter called onReceivedAd.");
        zzwq.zzqa();
        if (!zzayr.zzze()) {
            zzaza.zze("#008 Must be called on the main UI thread.", (Throwable) null);
            zzayr.zzzz.post(new zzaoq(this));
            return;
        }
        try {
            this.zzdmz.onAdLoaded();
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }
}
