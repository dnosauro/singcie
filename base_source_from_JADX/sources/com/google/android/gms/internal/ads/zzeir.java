package com.google.android.gms.internal.ads;

final class zzeir {
    private static final Class<?> zziiq = zzhr("libcore.io.Memory");
    private static final boolean zziir = (zzhr("org.robolectric.Robolectric") != null);

    static boolean zzbfn() {
        return zziiq != null && !zziir;
    }

    static Class<?> zzbfo() {
        return zziiq;
    }

    private static <T> Class<T> zzhr(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
