package com.google.android.gms.internal.measurement;

public final class zzof implements zzog {
    private static final zzdc<Boolean> zza;
    private static final zzdc<Boolean> zzb;

    static {
        zzdl zzdl = new zzdl(zzdd.zza("com.google.android.gms.measurement"));
        zza = zzdl.zza("measurement.sdk.screen.manual_screen_view_logging", true);
        zzb = zzdl.zza("measurement.sdk.screen.disabling_automatic_reporting", true);
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
}
