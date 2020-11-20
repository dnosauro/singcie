package com.google.android.gms.internal.measurement;

final class zzhl {
    private static final zzhk<?> zza = new zzhm();
    private static final zzhk<?> zzb = zzc();

    static zzhk<?> zza() {
        return zza;
    }

    static zzhk<?> zzb() {
        zzhk<?> zzhk = zzb;
        if (zzhk != null) {
            return zzhk;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    private static zzhk<?> zzc() {
        try {
            return (zzhk) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
