package com.google.android.gms.internal.measurement;

final class zzjb {
    private static final zziz zza = zzc();
    private static final zziz zzb = new zzjc();

    static zziz zza() {
        return zza;
    }

    static zziz zzb() {
        return zzb;
    }

    private static zziz zzc() {
        try {
            return (zziz) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
