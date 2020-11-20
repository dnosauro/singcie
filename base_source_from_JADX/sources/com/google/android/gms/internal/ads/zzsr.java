package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzsr extends AppOpenAd {
    private final zzsg zzbuk;

    public zzsr(zzsg zzsg) {
        this.zzbuk = zzsg;
    }

    public final ResponseInfo getResponseInfo() {
        zzyn zzyn;
        try {
            zzyn = this.zzbuk.zzkh();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            zzyn = null;
        }
        return ResponseInfo.zza(zzyn);
    }

    public final void show(Activity activity, FullScreenContentCallback fullScreenContentCallback) {
        try {
            this.zzbuk.zza(ObjectWrapper.wrap(activity), new zzsh(fullScreenContentCallback));
        } catch (RemoteException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }

    /* access modifiers changed from: protected */
    public final void zza(zzsm zzsm) {
        try {
            this.zzbuk.zza(zzsm);
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }

    /* access modifiers changed from: protected */
    public final zzxg zzdx() {
        try {
            return this.zzbuk.zzdx();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            return null;
        }
    }
}
