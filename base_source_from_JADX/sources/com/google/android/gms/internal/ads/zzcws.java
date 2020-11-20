package com.google.android.gms.internal.ads;

public final class zzcws implements zzepf<zzcwq> {
    private final zzcwq zzguw;

    private zzcws(zzcwq zzcwq) {
        this.zzguw = zzcwq;
    }

    public static zzcws zzd(zzcwq zzcwq) {
        return new zzcws(zzcwq);
    }

    public final /* synthetic */ Object get() {
        zzcwq zzcwq = this.zzguw;
        if (zzcwq != null) {
            return (zzcwq) zzepl.zza(zzcwq, "Cannot return null from a non-@Nullable @Provides method");
        }
        throw null;
    }
}
