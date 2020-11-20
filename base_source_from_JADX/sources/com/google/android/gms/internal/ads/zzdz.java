package com.google.android.gms.internal.ads;

import android.content.Context;

final class zzdz implements Runnable {
    private final /* synthetic */ Context zzxm;

    zzdz(zzdx zzdx, Context context) {
        this.zzxm = context;
    }

    public final void run() {
        try {
            zzdx.zzwi.zzb(this.zzxm);
        } catch (Exception e) {
            zzdx.zzwk.zza(2019, -1, e);
        }
    }
}
