package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzbkf implements zzepf<zzbkg> {
    private final zzeps<Context> zzevi;
    private final zzeps<zzqr> zzfqq;

    private zzbkf(zzeps<Context> zzeps, zzeps<zzqr> zzeps2) {
        this.zzevi = zzeps;
        this.zzfqq = zzeps2;
    }

    public static zzbkf zza(zzeps<Context> zzeps, zzeps<zzqr> zzeps2) {
        return new zzbkf(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return new zzbkg(this.zzevi.get(), this.zzfqq.get());
    }
}
