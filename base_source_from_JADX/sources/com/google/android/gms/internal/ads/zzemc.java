package com.google.android.gms.internal.ads;

final class zzemc {
    private static final zzema zziqh = zzbjl();
    private static final zzema zziqi = new zzelz();

    static zzema zzbjj() {
        return zziqh;
    }

    static zzema zzbjk() {
        return zziqi;
    }

    private static zzema zzbjl() {
        try {
            return (zzema) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
