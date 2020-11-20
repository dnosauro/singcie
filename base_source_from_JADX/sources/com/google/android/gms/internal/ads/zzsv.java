package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.appopen.AppOpenAd;

public final class zzsv {
    private final Context context;
    @AppOpenAd.AppOpenAdOrientation
    private final int orientation;
    private final zzvl zzacp;
    private final zzza zzacr;
    private zzxg zzbul;
    private final String zzbum;
    private final AppOpenAd.AppOpenAdLoadCallback zzbun;
    private final zzanj zzbuo = new zzanj();

    public zzsv(Context context2, String str, zzza zzza, @AppOpenAd.AppOpenAdOrientation int i, AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback) {
        this.context = context2;
        this.zzbum = str;
        this.zzacr = zzza;
        this.orientation = i;
        this.zzbun = appOpenAdLoadCallback;
        this.zzacp = zzvl.zzcho;
    }

    public final void zzmt() {
        try {
            this.zzbul = zzwq.zzqb().zza(this.context, zzvn.zzpq(), this.zzbum, this.zzbuo);
            this.zzbul.zza(new zzvw(this.orientation));
            this.zzbul.zza((zzsl) new zzsf(this.zzbun));
            this.zzbul.zza(zzvl.zza(this.context, this.zzacr));
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }
}
