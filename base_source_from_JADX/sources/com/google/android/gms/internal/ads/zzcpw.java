package com.google.android.gms.internal.ads;

public final class zzcpw implements zzepf<zzcpr> {
    private final zzeps<zzcpp> zzffn;
    private final zzeps<zzdzc> zzgpb;

    private zzcpw(zzeps<zzcpp> zzeps, zzeps<zzdzc> zzeps2) {
        this.zzffn = zzeps;
        this.zzgpb = zzeps2;
    }

    public static zzcpw zzax(zzeps<zzcpp> zzeps, zzeps<zzdzc> zzeps2) {
        return new zzcpw(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return new zzcpr(this.zzffn.get(), this.zzgpb.get());
    }
}
