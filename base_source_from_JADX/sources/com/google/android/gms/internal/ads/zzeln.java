package com.google.android.gms.internal.ads;

final class zzeln {
    private static final zzell zzipn = zzbjf();
    private static final zzell zzipo = new zzelo();

    static zzell zzbjd() {
        return zzipn;
    }

    static zzell zzbje() {
        return zzipo;
    }

    private static zzell zzbjf() {
        try {
            return (zzell) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
