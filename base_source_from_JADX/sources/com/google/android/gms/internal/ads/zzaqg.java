package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.zzp;

final class zzaqg implements Runnable {
    private final /* synthetic */ AdOverlayInfoParcel zzdod;
    private final /* synthetic */ zzaqe zzdoe;

    zzaqg(zzaqe zzaqe, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.zzdoe = zzaqe;
        this.zzdod = adOverlayInfoParcel;
    }

    public final void run() {
        zzp.zzkp();
        zzo.zza(this.zzdoe.zzdob, this.zzdod, true);
    }
}
