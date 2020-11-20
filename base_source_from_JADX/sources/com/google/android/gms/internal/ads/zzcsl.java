package com.google.android.gms.internal.ads;

import android.net.Uri;

final /* synthetic */ class zzcsl implements zzdyb {
    private final Uri zzeda;
    private final zzdnj zzgqx;
    private final zzcsm zzgrr;
    private final zzdmu zzgrs;

    zzcsl(zzcsm zzcsm, Uri uri, zzdnj zzdnj, zzdmu zzdmu) {
        this.zzgrr = zzcsm;
        this.zzeda = uri;
        this.zzgqx = zzdnj;
        this.zzgrs = zzdmu;
    }

    public final zzdyz zzf(Object obj) {
        return this.zzgrr.zza(this.zzeda, this.zzgqx, this.zzgrs, obj);
    }
}
