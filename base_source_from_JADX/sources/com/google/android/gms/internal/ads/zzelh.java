package com.google.android.gms.internal.ads;

final class zzelh implements zzelp {
    private zzelp[] zzipi;

    zzelh(zzelp... zzelpArr) {
        this.zzipi = zzelpArr;
    }

    public final boolean zzc(Class<?> cls) {
        for (zzelp zzc : this.zzipi) {
            if (zzc.zzc(cls)) {
                return true;
            }
        }
        return false;
    }

    public final zzelq zzd(Class<?> cls) {
        for (zzelp zzelp : this.zzipi) {
            if (zzelp.zzc(cls)) {
                return zzelp.zzd(cls);
            }
        }
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? "No factory is available for message type: ".concat(valueOf) : new String("No factory is available for message type: "));
    }
}
