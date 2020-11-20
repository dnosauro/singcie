package com.google.android.gms.internal.ads;

final class zzejy {
    private static final zzejw<?> zzikq = new zzejv();
    private static final zzejw<?> zzikr = zzbhi();

    private static zzejw<?> zzbhi() {
        try {
            return (zzejw) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    static zzejw<?> zzbhj() {
        return zzikq;
    }

    static zzejw<?> zzbhk() {
        zzejw<?> zzejw = zzikr;
        if (zzejw != null) {
            return zzejw;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
