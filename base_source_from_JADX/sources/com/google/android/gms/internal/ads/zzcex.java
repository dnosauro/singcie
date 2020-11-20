package com.google.android.gms.internal.ads;

final /* synthetic */ class zzcex implements zzdyb {
    private final zzdyz zzggs;

    zzcex(zzdyz zzdyz) {
        this.zzggs = zzdyz;
    }

    public final zzdyz zzf(Object obj) {
        return obj != null ? this.zzggs : zzdyr.immediateFailedFuture(new zzcuq(zzdok.INTERNAL_ERROR, "Retrieve required value in native ad response failed."));
    }
}
