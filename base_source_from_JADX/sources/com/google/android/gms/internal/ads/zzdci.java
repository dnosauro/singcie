package com.google.android.gms.internal.ads;

import android.location.Location;

final /* synthetic */ class zzdci implements zzdvm {
    private final zzdcg zzgzt;

    zzdci(zzdcg zzdcg) {
        this.zzgzt = zzdcg;
    }

    public final Object apply(Object obj) {
        Location location = (Location) obj;
        return location != null ? location : this.zzgzt.zzfvl.zzhio.zzmy;
    }
}
