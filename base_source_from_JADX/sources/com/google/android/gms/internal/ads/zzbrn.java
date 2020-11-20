package com.google.android.gms.internal.ads;

public final class zzbrn implements zzepf<zzdnn> {
    private final zzbrg zzfxl;

    private zzbrn(zzbrg zzbrg) {
        this.zzfxl = zzbrg;
    }

    public static zzbrn zzn(zzbrg zzbrg) {
        return new zzbrn(zzbrg);
    }

    public static zzdnn zzo(zzbrg zzbrg) {
        return (zzdnn) zzepl.zza(zzbrg.zzakt(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zzo(this.zzfxl);
    }
}
