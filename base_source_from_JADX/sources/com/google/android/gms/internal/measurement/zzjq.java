package com.google.android.gms.internal.measurement;

final class zzjq {
    private static final zzjo zza = zzc();
    private static final zzjo zzb = new zzjn();

    static zzjo zza() {
        return zza;
    }

    static zzjo zzb() {
        return zzb;
    }

    private static zzjo zzc() {
        try {
            return (zzjo) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
