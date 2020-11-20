package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzm;

final /* synthetic */ class zzalf implements zzakr {
    private final zzalb zzdiq;
    private final zzals zzdiy;
    private final zzako zzdiz;

    zzalf(zzalb zzalb, zzals zzals, zzako zzako) {
        this.zzdiq = zzalb;
        this.zzdiy = zzals;
        this.zzdiz = zzako;
    }

    public final void zztt() {
        zzm.zzedd.postDelayed(new zzale(this.zzdiq, this.zzdiy, this.zzdiz), (long) zzalm.zzdji);
    }
}
