package com.google.android.gms.internal.ads;

import java.util.List;

final class zzeld extends zzelc {
    private zzeld() {
        super();
    }

    private static <E> zzekp<E> zzc(Object obj, long j) {
        return (zzekp) zzenl.zzp(obj, j);
    }

    /* access modifiers changed from: package-private */
    public final <L> List<L> zza(Object obj, long j) {
        zzekp zzc = zzc(obj, j);
        if (zzc.zzbfk()) {
            return zzc;
        }
        int size = zzc.size();
        zzekp zzfx = zzc.zzfx(size == 0 ? 10 : size << 1);
        zzenl.zza(obj, j, (Object) zzfx);
        return zzfx;
    }

    /* access modifiers changed from: package-private */
    public final <E> void zza(Object obj, Object obj2, long j) {
        zzekp zzc = zzc(obj, j);
        zzekp zzc2 = zzc(obj2, j);
        int size = zzc.size();
        int size2 = zzc2.size();
        if (size > 0 && size2 > 0) {
            if (!zzc.zzbfk()) {
                zzc = zzc.zzfx(size2 + size);
            }
            zzc.addAll(zzc2);
        }
        if (size > 0) {
            zzc2 = zzc;
        }
        zzenl.zza(obj, j, (Object) zzc2);
    }

    /* access modifiers changed from: package-private */
    public final void zzb(Object obj, long j) {
        zzc(obj, j).zzbfl();
    }
}
