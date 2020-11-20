package com.google.android.gms.internal.measurement;

public final class zzok implements zzoh {
    private static final zzdc<Long> zza;
    private static final zzdc<Long> zzb;

    static {
        zzdl zzdl = new zzdl(zzdd.zza("com.google.android.gms.measurement"));
        zza = zzdl.zza("measurement.id.max_bundles_per_iteration", 0);
        zzb = zzdl.zza("measurement.max_bundles_per_iteration", 2);
    }

    public final long zza() {
        return zzb.zzc().longValue();
    }
}
