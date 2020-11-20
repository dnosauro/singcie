package com.google.android.gms.internal.ads;

public final class zzdbx implements zzepf<zzdbv> {
    private final zzeps<zzdjv> zzfws;

    private zzdbx(zzeps<zzdjv> zzeps) {
        this.zzfws = zzeps;
    }

    public static zzdbx zzal(zzeps<zzdjv> zzeps) {
        return new zzdbx(zzeps);
    }

    public static zzdbv zzb(zzdjv zzdjv) {
        return new zzdbv(zzdjv);
    }

    public final /* synthetic */ Object get() {
        return zzb(this.zzfws.get());
    }
}
