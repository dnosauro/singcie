package com.google.android.gms.internal.measurement;

public final class zzng implements zznd {
    private static final zzdc<Boolean> zza;
    private static final zzdc<Boolean> zzb;
    private static final zzdc<Boolean> zzc;

    static {
        zzdl zzdl = new zzdl(zzdd.zza("com.google.android.gms.measurement"));
        zza = zzdl.zza("measurement.client.sessions.check_on_reset_and_enable2", true);
        zzb = zzdl.zza("measurement.client.sessions.check_on_startup", true);
        zzc = zzdl.zza("measurement.client.sessions.start_session_before_view_screen", true);
    }

    public final boolean zza() {
        return true;
    }

    public final boolean zzb() {
        return zza.zzc().booleanValue();
    }
}
