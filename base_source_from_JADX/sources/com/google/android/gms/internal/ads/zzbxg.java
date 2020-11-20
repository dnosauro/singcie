package com.google.android.gms.internal.ads;

public final class zzbxg implements zzepf<zzbwp> {
    private final zzbwp zzfzf;

    private zzbxg(zzbwp zzbwp) {
        this.zzfzf = zzbwp;
    }

    public static zzbxg zzy(zzbwp zzbwp) {
        return new zzbxg(zzbwp);
    }

    public final /* synthetic */ Object get() {
        zzbwp zzbwp = this.zzfzf;
        if (zzbwp != null) {
            return (zzbwp) zzepl.zza(zzbwp, "Cannot return null from a non-@Nullable @Provides method");
        }
        throw null;
    }
}
