package com.google.android.gms.internal.measurement;

public final class zzlr implements zzls {
    private static final zzdc<Boolean> zza;
    private static final zzdc<Boolean> zzb;

    static {
        zzdl zzdl = new zzdl(zzdd.zza("com.google.android.gms.measurement"));
        zza = zzdl.zza("measurement.androidId.delete_feature", true);
        zzb = zzdl.zza("measurement.log_androidId_enabled", false);
    }

    public final boolean zza() {
        return zza.zzc().booleanValue();
    }
}
