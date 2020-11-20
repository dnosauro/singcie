package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzboc;
import com.google.android.gms.internal.ads.zzbre;

final class zzdjt<R extends zzbre<AdT>, AdT extends zzboc> implements zzdqc<AdT> {
    private final zzdkl<R, zzdpn<AdT>> zzhey;

    public zzdjt(zzdkl<R, zzdpn<AdT>> zzdkl) {
        this.zzhey = zzdkl;
    }

    public final zzdyz<zzdpn<AdT>> zza(zzdqb zzdqb) {
        zzdjs zzdjs = (zzdjs) zzdqb;
        return this.zzhey.zza(zzdjs.zzhew, zzdjs.zzhev);
    }

    public final void zza(zzdpn<AdT> zzdpn) {
        zzdpn.zzhmb = ((zzbre) this.zzhey.zzaty()).zzagh();
    }

    public final void zzb(Throwable th) {
    }
}
