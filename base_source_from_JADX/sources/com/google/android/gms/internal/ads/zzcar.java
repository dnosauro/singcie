package com.google.android.gms.internal.ads;

public final class zzcar implements zzepf<zzcap> {
    private final zzcap zzgal;

    private zzcar(zzcap zzcap) {
        this.zzgal = zzcap;
    }

    public static zzcar zzc(zzcap zzcap) {
        return new zzcar(zzcap);
    }

    public final /* synthetic */ Object get() {
        zzcap zzcap = this.zzgal;
        if (zzcap != null) {
            return (zzcap) zzepl.zza(zzcap, "Cannot return null from a non-@Nullable @Provides method");
        }
        throw null;
    }
}
