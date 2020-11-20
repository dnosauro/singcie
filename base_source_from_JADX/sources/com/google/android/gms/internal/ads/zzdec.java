package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzdec implements zzepf<zzdea> {
    private final zzeps<zzdzc> zzevg;
    private final zzeps<Bundle> zzhal;

    private zzdec(zzeps<zzdzc> zzeps, zzeps<Bundle> zzeps2) {
        this.zzevg = zzeps;
        this.zzhal = zzeps2;
    }

    public static zzdec zzbf(zzeps<zzdzc> zzeps, zzeps<Bundle> zzeps2) {
        return new zzdec(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return new zzdea(this.zzevg.get(), this.zzhal.get());
    }
}
