package com.google.android.gms.internal.ads;

final /* synthetic */ class zzcev implements zzdyb {
    private final zzdyz zzggs;

    zzcev(zzdyz zzdyz) {
        this.zzggs = zzdyz;
    }

    public final zzdyz zzf(Object obj) {
        zzdyz zzdyz = this.zzggs;
        zzbdv zzbdv = (zzbdv) obj;
        if (zzbdv != null && zzbdv.zzaah() != null) {
            return zzdyz;
        }
        throw new zzcuq(zzdok.INTERNAL_ERROR, "Retrieve video view in instream ad response failed.");
    }
}
