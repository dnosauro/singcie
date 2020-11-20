package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzf;

public final class zzbjp implements zzepf<zzbjq> {
    private final zzeps<zzf> zzfcl;

    private zzbjp(zzeps<zzf> zzeps) {
        this.zzfcl = zzeps;
    }

    public static zzbjp zza(zzeps<zzf> zzeps) {
        return new zzbjp(zzeps);
    }

    public final /* synthetic */ Object get() {
        return new zzbjq(this.zzfcl.get());
    }
}
