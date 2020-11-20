package com.google.android.gms.internal.ads;

public final class zzcbo implements zzepf<zzcgh> {
    private final zzcbh zzgbp;

    public zzcbo(zzcbh zzcbh) {
        this.zzgbp = zzcbh;
    }

    public static zzcgh zza(zzcbh zzcbh) {
        return (zzcgh) zzepl.zza(zzcbh.zzamv(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzgbp);
    }
}
