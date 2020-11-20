package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.common.util.VisibleForTesting;

public final class zzze {
    private final Context context;
    private final zzvl zzacp;
    private AppEventListener zzbnz;
    private boolean zzbpa;
    private zzxg zzbul;
    private String zzbum;
    private final zzanj zzbuo;
    private zzva zzcgp;
    private AdListener zzcgw;
    private AdMetadataListener zzcgx;
    private OnCustomRenderedAdLoadedListener zzcjx;
    private OnPaidEventListener zzcka;
    private RewardedVideoAdListener zzcki;
    private boolean zzckj;

    public zzze(Context context2) {
        this(context2, zzvl.zzcho, (PublisherInterstitialAd) null);
    }

    public zzze(Context context2, PublisherInterstitialAd publisherInterstitialAd) {
        this(context2, zzvl.zzcho, publisherInterstitialAd);
    }

    @VisibleForTesting
    private zzze(Context context2, zzvl zzvl, PublisherInterstitialAd publisherInterstitialAd) {
        this.zzbuo = new zzanj();
        this.context = context2;
        this.zzacp = zzvl;
    }

    private final void zzcn(String str) {
        if (this.zzbul == null) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 63);
            sb.append("The ad unit ID must be set on InterstitialAd before ");
            sb.append(str);
            sb.append(" is called.");
            throw new IllegalStateException(sb.toString());
        }
    }

    public final AdListener getAdListener() {
        return this.zzcgw;
    }

    public final Bundle getAdMetadata() {
        try {
            if (this.zzbul != null) {
                return this.zzbul.getAdMetadata();
            }
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
        return new Bundle();
    }

    public final String getAdUnitId() {
        return this.zzbum;
    }

    public final AppEventListener getAppEventListener() {
        return this.zzbnz;
    }

    public final String getMediationAdapterClassName() {
        try {
            if (this.zzbul != null) {
                return this.zzbul.zzkg();
            }
            return null;
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
            return null;
        }
    }

    public final OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.zzcjx;
    }

    public final ResponseInfo getResponseInfo() {
        zzyn zzyn = null;
        try {
            if (this.zzbul != null) {
                zzyn = this.zzbul.zzkh();
            }
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
        return ResponseInfo.zza(zzyn);
    }

    public final boolean isLoaded() {
        try {
            if (this.zzbul == null) {
                return false;
            }
            return this.zzbul.isReady();
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
            return false;
        }
    }

    public final boolean isLoading() {
        try {
            if (this.zzbul == null) {
                return false;
            }
            return this.zzbul.isLoading();
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
            return false;
        }
    }

    public final void setAdListener(AdListener adListener) {
        try {
            this.zzcgw = adListener;
            if (this.zzbul != null) {
                this.zzbul.zza((zzwt) adListener != null ? new zzvg(adListener) : null);
            }
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setAdMetadataListener(AdMetadataListener adMetadataListener) {
        try {
            this.zzcgx = adMetadataListener;
            if (this.zzbul != null) {
                this.zzbul.zza((zzxj) adMetadataListener != null ? new zzvh(adMetadataListener) : null);
            }
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setAdUnitId(String str) {
        if (this.zzbum == null) {
            this.zzbum = str;
            return;
        }
        throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
    }

    public final void setAppEventListener(AppEventListener appEventListener) {
        try {
            this.zzbnz = appEventListener;
            if (this.zzbul != null) {
                this.zzbul.zza((zzxo) appEventListener != null ? new zzvt(appEventListener) : null);
            }
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setImmersiveMode(boolean z) {
        try {
            this.zzbpa = z;
            if (this.zzbul != null) {
                this.zzbul.setImmersiveMode(z);
            }
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        try {
            this.zzcjx = onCustomRenderedAdLoadedListener;
            if (this.zzbul != null) {
                this.zzbul.zza((zzacb) onCustomRenderedAdLoadedListener != null ? new zzacc(onCustomRenderedAdLoadedListener) : null);
            }
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        try {
            this.zzcka = onPaidEventListener;
            if (this.zzbul != null) {
                this.zzbul.zza((zzym) new zzaaf(onPaidEventListener));
            }
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        try {
            this.zzcki = rewardedVideoAdListener;
            if (this.zzbul != null) {
                this.zzbul.zza((zzaup) rewardedVideoAdListener != null ? new zzaus(rewardedVideoAdListener) : null);
            }
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void show() {
        try {
            zzcn("show");
            this.zzbul.showInterstitial();
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void zza(zzva zzva) {
        try {
            this.zzcgp = zzva;
            if (this.zzbul != null) {
                this.zzbul.zza((zzws) zzva != null ? new zzuz(zzva) : null);
            }
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void zza(zzza zzza) {
        try {
            if (this.zzbul == null) {
                if (this.zzbum == null) {
                    zzcn("loadAd");
                }
                zzvn zzpp = this.zzckj ? zzvn.zzpp() : new zzvn();
                zzvx zzqb = zzwq.zzqb();
                Context context2 = this.context;
                this.zzbul = (zzxg) new zzwh(zzqb, context2, zzpp, this.zzbum, this.zzbuo).zzd(context2, false);
                if (this.zzcgw != null) {
                    this.zzbul.zza((zzwt) new zzvg(this.zzcgw));
                }
                if (this.zzcgp != null) {
                    this.zzbul.zza((zzws) new zzuz(this.zzcgp));
                }
                if (this.zzcgx != null) {
                    this.zzbul.zza((zzxj) new zzvh(this.zzcgx));
                }
                if (this.zzbnz != null) {
                    this.zzbul.zza((zzxo) new zzvt(this.zzbnz));
                }
                if (this.zzcjx != null) {
                    this.zzbul.zza((zzacb) new zzacc(this.zzcjx));
                }
                if (this.zzcki != null) {
                    this.zzbul.zza((zzaup) new zzaus(this.zzcki));
                }
                this.zzbul.zza((zzym) new zzaaf(this.zzcka));
                this.zzbul.setImmersiveMode(this.zzbpa);
            }
            if (this.zzbul.zza(zzvl.zza(this.context, zzza))) {
                this.zzbuo.zzf(zzza.zzqu());
            }
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void zzd(boolean z) {
        this.zzckj = true;
    }
}
