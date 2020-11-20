package com.google.android.gms.internal.measurement;

public final class zzll implements zzlm {
    private static final zzdc<Boolean> zza;
    private static final zzdc<Boolean> zzb;
    private static final zzdc<Boolean> zzc;
    private static final zzdc<Long> zzd;

    static {
        zzdl zzdl = new zzdl(zzdd.zza("com.google.android.gms.measurement"));
        zza = zzdl.zza("measurement.client.ad_impression.dev", false);
        zzb = zzdl.zza("measurement.service.separate_public_internal_event_blacklisting", false);
        zzc = zzdl.zza("measurement.service.ad_impression", false);
        zzd = zzdl.zza("measurement.id.service.ad_impression", 0);
    }

    public final boolean zza() {
        return true;
    }

    public final boolean zzb() {
        return zza.zzc().booleanValue();
    }

    public final boolean zzc() {
        return zzb.zzc().booleanValue();
    }

    public final boolean zzd() {
        return zzc.zzc().booleanValue();
    }
}
