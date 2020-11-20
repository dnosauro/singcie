package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.LoadAdError;

final class zzzb extends zzwp {
    private final /* synthetic */ zzzc zzcjt;

    zzzb(zzzc zzzc) {
        this.zzcjt = zzzc;
    }

    public final void onAdFailedToLoad(int i) {
        this.zzcjt.zzcjv.zza(this.zzcjt.zzdw());
        super.onAdFailedToLoad(i);
    }

    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        this.zzcjt.zzcjv.zza(this.zzcjt.zzdw());
        super.onAdFailedToLoad(loadAdError);
    }

    public final void onAdLoaded() {
        this.zzcjt.zzcjv.zza(this.zzcjt.zzdw());
        super.onAdLoaded();
    }
}
