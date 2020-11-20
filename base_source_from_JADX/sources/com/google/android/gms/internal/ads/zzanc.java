package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.measurement.api.AppMeasurementSdk;

final /* synthetic */ class zzanc implements Runnable {
    private final Context zzckm;
    private final String zzdgt;
    private final zzand zzdkr;

    zzanc(zzand zzand, Context context, String str) {
        this.zzdkr = zzand;
        this.zzckm = context;
        this.zzdgt = str;
    }

    public final void run() {
        Context context = this.zzckm;
        String str = this.zzdgt;
        zzabf.initialize(context);
        Bundle bundle = new Bundle();
        bundle.putBoolean("measurementEnabled", ((Boolean) zzwq.zzqe().zzd(zzabf.zzcns)).booleanValue());
        try {
            ((zzbgh) zzazd.zza(context, "com.google.android.gms.ads.measurement.DynamiteMeasurementManager", zzanf.zzbxv)).zza(ObjectWrapper.wrap(context), new zzana(AppMeasurementSdk.getInstance(context, "FA-Ads", "am", str, bundle)));
        } catch (RemoteException | zzazf | NullPointerException e) {
            zzaza.zze("#007 Could not call remote method.", e);
        }
    }
}
