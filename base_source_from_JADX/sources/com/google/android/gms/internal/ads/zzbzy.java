package com.google.android.gms.internal.ads;

public final class zzbzy implements zzepf<zzbzv> {
    private final zzeps<zzbtr> zzfag;
    private final zzeps<zzbxu> zzfkf;

    private zzbzy(zzeps<zzbtr> zzeps, zzeps<zzbxu> zzeps2) {
        this.zzfag = zzeps;
        this.zzfkf = zzeps2;
    }

    public static zzbzy zzx(zzeps<zzbtr> zzeps, zzeps<zzbxu> zzeps2) {
        return new zzbzy(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return new zzbzv(this.zzfag.get(), this.zzfkf.get());
    }
}
