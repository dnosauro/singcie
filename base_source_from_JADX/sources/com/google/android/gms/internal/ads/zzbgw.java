package com.google.android.gms.internal.ads;

public final class zzbgw implements zzepf<zzazh> {
    private final zzbgl zzevc;

    public zzbgw(zzbgl zzbgl) {
        this.zzevc = zzbgl;
    }

    public static zzazh zzb(zzbgl zzbgl) {
        return (zzazh) zzepl.zza(zzbgl.zzaeh(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zzb(this.zzevc);
    }
}
