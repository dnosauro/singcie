package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.atomic.AtomicBoolean;

public final class zzzc {
    private final zzvl zzacp;
    private VideoOptions zzbnq;
    private boolean zzbnx;
    private AppEventListener zzbnz;
    private zzxg zzbul;
    private String zzbum;
    private final zzanj zzbuo;
    private zzva zzcgp;
    private AdListener zzcgw;
    private AdSize[] zzcik;
    private final AtomicBoolean zzcju;
    /* access modifiers changed from: private */
    public final VideoController zzcjv;
    @VisibleForTesting
    private final zzwp zzcjw;
    private OnCustomRenderedAdLoadedListener zzcjx;
    private ViewGroup zzcjy;
    private int zzcjz;
    private OnPaidEventListener zzcka;

    public zzzc(ViewGroup viewGroup) {
        this(viewGroup, (AttributeSet) null, false, zzvl.zzcho, 0);
    }

    public zzzc(ViewGroup viewGroup, int i) {
        this(viewGroup, (AttributeSet) null, false, zzvl.zzcho, i);
    }

    public zzzc(ViewGroup viewGroup, AttributeSet attributeSet, boolean z) {
        this(viewGroup, attributeSet, z, zzvl.zzcho, 0);
    }

    public zzzc(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, int i) {
        this(viewGroup, attributeSet, false, zzvl.zzcho, i);
    }

    @VisibleForTesting
    private zzzc(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, zzvl zzvl, int i) {
        this(viewGroup, attributeSet, z, zzvl, (zzxg) null, i);
    }

    @VisibleForTesting
    private zzzc(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, zzvl zzvl, zzxg zzxg, int i) {
        zzvn zzvn;
        this.zzbuo = new zzanj();
        this.zzcjv = new VideoController();
        this.zzcjw = new zzzb(this);
        this.zzcjy = viewGroup;
        this.zzacp = zzvl;
        this.zzbul = null;
        this.zzcju = new AtomicBoolean(false);
        this.zzcjz = i;
        if (attributeSet != null) {
            Context context = viewGroup.getContext();
            try {
                zzvy zzvy = new zzvy(context, attributeSet);
                this.zzcik = zzvy.zzy(z);
                this.zzbum = zzvy.getAdUnitId();
                if (viewGroup.isInEditMode()) {
                    zzayr zzqa = zzwq.zzqa();
                    AdSize adSize = this.zzcik[0];
                    int i2 = this.zzcjz;
                    if (adSize.equals(AdSize.INVALID)) {
                        zzvn = zzvn.zzpr();
                    } else {
                        zzvn zzvn2 = new zzvn(context, adSize);
                        zzvn2.zzchs = zzcz(i2);
                        zzvn = zzvn2;
                    }
                    zzqa.zza(viewGroup, zzvn, "Ads by Google");
                }
            } catch (IllegalArgumentException e) {
                zzwq.zzqa().zza(viewGroup, new zzvn(context, AdSize.BANNER), e.getMessage(), e.getMessage());
            }
        }
    }

    private static zzvn zza(Context context, AdSize[] adSizeArr, int i) {
        for (AdSize equals : adSizeArr) {
            if (equals.equals(AdSize.INVALID)) {
                return zzvn.zzpr();
            }
        }
        zzvn zzvn = new zzvn(context, adSizeArr);
        zzvn.zzchs = zzcz(i);
        return zzvn;
    }

    private static boolean zzcz(int i) {
        return i == 1;
    }

    public final void destroy() {
        try {
            if (this.zzbul != null) {
                this.zzbul.destroy();
            }
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final AdListener getAdListener() {
        return this.zzcgw;
    }

    public final AdSize getAdSize() {
        zzvn zzkf;
        try {
            if (!(this.zzbul == null || (zzkf = this.zzbul.zzkf()) == null)) {
                return zzkf.zzps();
            }
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
        AdSize[] adSizeArr = this.zzcik;
        if (adSizeArr != null) {
            return adSizeArr[0];
        }
        return null;
    }

    public final AdSize[] getAdSizes() {
        return this.zzcik;
    }

    public final String getAdUnitId() {
        zzxg zzxg;
        if (this.zzbum == null && (zzxg = this.zzbul) != null) {
            try {
                this.zzbum = zzxg.getAdUnitId();
            } catch (RemoteException e) {
                zzaza.zze("#007 Could not call remote method.", e);
            }
        }
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

    public final VideoController getVideoController() {
        return this.zzcjv;
    }

    public final VideoOptions getVideoOptions() {
        return this.zzbnq;
    }

    public final boolean isLoading() {
        try {
            if (this.zzbul != null) {
                return this.zzbul.isLoading();
            }
            return false;
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
            return false;
        }
    }

    public final void pause() {
        try {
            if (this.zzbul != null) {
                this.zzbul.pause();
            }
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void recordManualImpression() {
        if (!this.zzcju.getAndSet(true)) {
            try {
                if (this.zzbul != null) {
                    this.zzbul.zzke();
                }
            } catch (RemoteException e) {
                zzaza.zze("#007 Could not call remote method.", e);
            }
        }
    }

    public final void resume() {
        try {
            if (this.zzbul != null) {
                this.zzbul.resume();
            }
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setAdListener(AdListener adListener) {
        this.zzcgw = adListener;
        this.zzcjw.zza(adListener);
    }

    public final void setAdSizes(AdSize... adSizeArr) {
        if (this.zzcik == null) {
            zza(adSizeArr);
            return;
        }
        throw new IllegalStateException("The ad size can only be set once on AdView.");
    }

    public final void setAdUnitId(String str) {
        if (this.zzbum == null) {
            this.zzbum = str;
            return;
        }
        throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
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

    public final void setManualImpressionsEnabled(boolean z) {
        this.zzbnx = z;
        try {
            if (this.zzbul != null) {
                this.zzbul.setManualImpressionsEnabled(this.zzbnx);
            }
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzcjx = onCustomRenderedAdLoadedListener;
        try {
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
            zzaza.zze("#008 Must be called on the main UI thread.", e);
        }
    }

    public final void setVideoOptions(VideoOptions videoOptions) {
        this.zzbnq = videoOptions;
        try {
            if (this.zzbul != null) {
                this.zzbul.zza(videoOptions == null ? null : new zzaak(videoOptions));
            }
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
        Object zzd;
        try {
            if (this.zzbul == null) {
                if ((this.zzcik == null || this.zzbum == null) && this.zzbul == null) {
                    throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
                }
                Context context = this.zzcjy.getContext();
                zzvn zza = zza(context, this.zzcik, this.zzcjz);
                if ("search_v2".equals(zza.zzacv)) {
                    zzd = new zzwi(zzwq.zzqb(), context, zza, this.zzbum).zzd(context, false);
                } else {
                    zzd = new zzwa(zzwq.zzqb(), context, zza, this.zzbum, this.zzbuo).zzd(context, false);
                }
                this.zzbul = (zzxg) zzd;
                this.zzbul.zza((zzwt) new zzvg(this.zzcjw));
                if (this.zzcgp != null) {
                    this.zzbul.zza((zzws) new zzuz(this.zzcgp));
                }
                if (this.zzbnz != null) {
                    this.zzbul.zza((zzxo) new zzvt(this.zzbnz));
                }
                if (this.zzcjx != null) {
                    this.zzbul.zza((zzacb) new zzacc(this.zzcjx));
                }
                if (this.zzbnq != null) {
                    this.zzbul.zza(new zzaak(this.zzbnq));
                }
                this.zzbul.zza((zzym) new zzaaf(this.zzcka));
                this.zzbul.setManualImpressionsEnabled(this.zzbnx);
                try {
                    IObjectWrapper zzkd = this.zzbul.zzkd();
                    if (zzkd != null) {
                        this.zzcjy.addView((View) ObjectWrapper.unwrap(zzkd));
                    }
                } catch (RemoteException e) {
                    zzaza.zze("#007 Could not call remote method.", e);
                }
            }
            if (this.zzbul.zza(zzvl.zza(this.zzcjy.getContext(), zzza))) {
                this.zzbuo.zzf(zzza.zzqu());
            }
        } catch (RemoteException e2) {
            zzaza.zze("#007 Could not call remote method.", e2);
        }
    }

    public final void zza(AdSize... adSizeArr) {
        this.zzcik = adSizeArr;
        try {
            if (this.zzbul != null) {
                this.zzbul.zza(zza(this.zzcjy.getContext(), this.zzcik, this.zzcjz));
            }
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
        this.zzcjy.requestLayout();
    }

    public final boolean zza(zzxg zzxg) {
        if (zzxg == null) {
            return false;
        }
        try {
            IObjectWrapper zzkd = zzxg.zzkd();
            if (zzkd == null || ((View) ObjectWrapper.unwrap(zzkd)).getParent() != null) {
                return false;
            }
            this.zzcjy.addView((View) ObjectWrapper.unwrap(zzkd));
            this.zzbul = zzxg;
            return true;
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
            return false;
        }
    }

    public final zzys zzdw() {
        zzxg zzxg = this.zzbul;
        if (zzxg == null) {
            return null;
        }
        try {
            return zzxg.getVideoController();
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
            return null;
        }
    }
}
