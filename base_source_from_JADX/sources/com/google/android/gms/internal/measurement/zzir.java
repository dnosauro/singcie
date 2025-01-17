package com.google.android.gms.internal.measurement;

import java.util.List;

final class zzir extends zziq {
    private zzir() {
        super();
    }

    private static <E> zzid<E> zzc(Object obj, long j) {
        return (zzid) zzkt.zzf(obj, j);
    }

    /* access modifiers changed from: package-private */
    public final <L> List<L> zza(Object obj, long j) {
        zzid zzc = zzc(obj, j);
        if (zzc.zza()) {
            return zzc;
        }
        int size = zzc.size();
        zzid zza = zzc.zza(size == 0 ? 10 : size << 1);
        zzkt.zza(obj, j, (Object) zza);
        return zza;
    }

    /* access modifiers changed from: package-private */
    public final <E> void zza(Object obj, Object obj2, long j) {
        zzid zzc = zzc(obj, j);
        zzid zzc2 = zzc(obj2, j);
        int size = zzc.size();
        int size2 = zzc2.size();
        if (size > 0 && size2 > 0) {
            if (!zzc.zza()) {
                zzc = zzc.zza(size2 + size);
            }
            zzc.addAll(zzc2);
        }
        if (size > 0) {
            zzc2 = zzc;
        }
        zzkt.zza(obj, j, (Object) zzc2);
    }

    /* access modifiers changed from: package-private */
    public final void zzb(Object obj, long j) {
        zzc(obj, j).mo17649i_();
    }
}
