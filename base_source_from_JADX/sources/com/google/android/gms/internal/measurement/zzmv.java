package com.google.android.gms.internal.measurement;

public final class zzmv implements zzmw {
    private static final zzdc<Boolean> zza;
    private static final zzdc<Long> zzb;

    static {
        zzdl zzdl = new zzdl(zzdd.zza("com.google.android.gms.measurement"));
        zza = zzdl.zza("measurement.sdk.referrer.delayed_install_referrer_api", false);
        zzb = zzdl.zza("measurement.id.sdk.referrer.delayed_install_referrer_api", 0);
    }

    public final boolean zza() {
        return true;
    }

    public final boolean zzb() {
        return zza.zzc().booleanValue();
    }
}
