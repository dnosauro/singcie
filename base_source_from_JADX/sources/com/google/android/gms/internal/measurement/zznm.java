package com.google.android.gms.internal.measurement;

public final class zznm implements zznj {
    private static final zzdc<Boolean> zza;
    private static final zzdc<Boolean> zzb;
    private static final zzdc<Long> zzc;

    static {
        zzdl zzdl = new zzdl(zzdd.zza("com.google.android.gms.measurement"));
        zza = zzdl.zza("measurement.collection.efficient_engagement_reporting_enabled_2", true);
        zzb = zzdl.zza("measurement.collection.redundant_engagement_removal_enabled", false);
        zzc = zzdl.zza("measurement.id.collection.redundant_engagement_removal_enabled", 0);
    }

    public final boolean zza() {
        return zza.zzc().booleanValue();
    }

    public final boolean zzb() {
        return zzb.zzc().booleanValue();
    }
}
