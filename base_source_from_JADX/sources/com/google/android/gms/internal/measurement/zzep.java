package com.google.android.gms.internal.measurement;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzep extends AbstractSet<Map.Entry<K, V>> {
    private final /* synthetic */ zzel zza;

    zzep(zzel zzel) {
        this.zza = zzel;
    }

    public final void clear() {
        this.zza.clear();
    }

    public final boolean contains(@NullableDecl Object obj) {
        Map zzb = this.zza.zzb();
        if (zzb != null) {
            return zzb.entrySet().contains(obj);
        }
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            int zzb2 = this.zza.zza(entry.getKey());
            return zzb2 != -1 && zzdu.zza(this.zza.zzc[zzb2], entry.getValue());
        }
    }

    public final Iterator<Map.Entry<K, V>> iterator() {
        return this.zza.zzf();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0021, code lost:
        r0 = r9.zza.zzi();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean remove(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object r10) {
        /*
            r9 = this;
            com.google.android.gms.internal.measurement.zzel r0 = r9.zza
            java.util.Map r0 = r0.zzb()
            if (r0 == 0) goto L_0x0011
            java.util.Set r0 = r0.entrySet()
            boolean r10 = r0.remove(r10)
            return r10
        L_0x0011:
            boolean r0 = r10 instanceof java.util.Map.Entry
            r1 = 0
            if (r0 == 0) goto L_0x005b
            java.util.Map$Entry r10 = (java.util.Map.Entry) r10
            com.google.android.gms.internal.measurement.zzel r0 = r9.zza
            boolean r0 = r0.zza()
            if (r0 == 0) goto L_0x0021
            return r1
        L_0x0021:
            com.google.android.gms.internal.measurement.zzel r0 = r9.zza
            int r0 = r0.zzi()
            java.lang.Object r2 = r10.getKey()
            java.lang.Object r3 = r10.getValue()
            com.google.android.gms.internal.measurement.zzel r10 = r9.zza
            java.lang.Object r5 = r10.zze
            com.google.android.gms.internal.measurement.zzel r10 = r9.zza
            int[] r6 = r10.zza
            com.google.android.gms.internal.measurement.zzel r10 = r9.zza
            java.lang.Object[] r7 = r10.zzb
            com.google.android.gms.internal.measurement.zzel r10 = r9.zza
            java.lang.Object[] r8 = r10.zzc
            r4 = r0
            int r10 = com.google.android.gms.internal.measurement.zzes.zza(r2, r3, r4, r5, r6, r7, r8)
            r2 = -1
            if (r10 != r2) goto L_0x004a
            return r1
        L_0x004a:
            com.google.android.gms.internal.measurement.zzel r1 = r9.zza
            r1.zza((int) r10, (int) r0)
            com.google.android.gms.internal.measurement.zzel r10 = r9.zza
            com.google.android.gms.internal.measurement.zzel.zzd(r10)
            com.google.android.gms.internal.measurement.zzel r10 = r9.zza
            r10.zzc()
            r10 = 1
            return r10
        L_0x005b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzep.remove(java.lang.Object):boolean");
    }

    public final int size() {
        return this.zza.size();
    }
}
