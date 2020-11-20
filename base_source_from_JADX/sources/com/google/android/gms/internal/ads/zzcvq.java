package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;

final class zzcvq implements zzbyl {
    private final /* synthetic */ zzdmu zzgsy;
    private final /* synthetic */ zzdnj zzgtq;
    private final /* synthetic */ zzcrb zzgtr;
    final /* synthetic */ zzcvo zzgts;

    zzcvq(zzcvo zzcvo, zzdnj zzdnj, zzdmu zzdmu, zzcrb zzcrb) {
        this.zzgts = zzcvo;
        this.zzgtq = zzdnj;
        this.zzgsy = zzdmu;
        this.zzgtr = zzcrb;
    }

    public final void onInitializationSucceeded() {
        this.zzgts.zzfqx.execute(new zzcvp(this, this.zzgtq, this.zzgsy, this.zzgtr));
    }

    public final void zzdy(int i) {
        String valueOf = String.valueOf(this.zzgtr.zzchy);
        zzd.zzfa(valueOf.length() != 0 ? "Fail to initialize adapter ".concat(valueOf) : new String("Fail to initialize adapter "));
    }
}
