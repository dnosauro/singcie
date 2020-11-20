package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzejz;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class zzejx<T extends zzejz<T>> {
    private static final zzejx zzikp = new zzejx(true);
    final zzems<T, Object> zzikm;
    private boolean zzikn;
    private boolean zziko;

    private zzejx() {
        this.zzikm = zzems.zzhs(16);
    }

    private zzejx(zzems<T, Object> zzems) {
        this.zzikm = zzems;
        zzbfl();
    }

    private zzejx(boolean z) {
        this(zzems.zzhs(0));
        zzbfl();
    }

    static int zza(zzenw zzenw, int i, Object obj) {
        int zzgu = zzejo.zzgu(i);
        if (zzenw == zzenw.GROUP) {
            zzekk.zzk((zzels) obj);
            zzgu <<= 1;
        }
        return zzgu + zzb(zzenw, obj);
    }

    private final Object zza(T t) {
        Object obj = this.zzikm.get(t);
        if (!(obj instanceof zzekt)) {
            return obj;
        }
        zzekt zzekt = (zzekt) obj;
        return zzekt.zzbir();
    }

    static void zza(zzejo zzejo, zzenw zzenw, int i, Object obj) {
        if (zzenw == zzenw.GROUP) {
            zzels zzels = (zzels) obj;
            zzekk.zzk(zzels);
            zzejo.writeTag(i, 3);
            zzels.zzb(zzejo);
            zzejo.writeTag(i, 4);
            return;
        }
        zzejo.writeTag(i, zzenw.zzbkq());
        switch (zzeka.zzikd[zzenw.ordinal()]) {
            case 1:
                zzejo.zzc(((Double) obj).doubleValue());
                return;
            case 2:
                zzejo.zzf(((Float) obj).floatValue());
                return;
            case 3:
                zzejo.zzfh(((Long) obj).longValue());
                return;
            case 4:
                zzejo.zzfh(((Long) obj).longValue());
                return;
            case 5:
                zzejo.zzgq(((Integer) obj).intValue());
                return;
            case 6:
                zzejo.zzfj(((Long) obj).longValue());
                return;
            case 7:
                zzejo.zzgt(((Integer) obj).intValue());
                return;
            case 8:
                zzejo.zzbs(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzels) obj).zzb(zzejo);
                return;
            case 10:
                zzejo.zzg((zzels) obj);
                return;
            case 11:
                if (obj instanceof zzeiu) {
                    zzejo.zzai((zzeiu) obj);
                    return;
                } else {
                    zzejo.zzht((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzeiu) {
                    zzejo.zzai((zzeiu) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                zzejo.zzk(bArr, 0, bArr.length);
                return;
            case 13:
                zzejo.zzgr(((Integer) obj).intValue());
                return;
            case 14:
                zzejo.zzgt(((Integer) obj).intValue());
                return;
            case 15:
                zzejo.zzfj(((Long) obj).longValue());
                return;
            case 16:
                zzejo.zzgs(((Integer) obj).intValue());
                return;
            case 17:
                zzejo.zzfi(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof zzekj) {
                    zzejo.zzgq(((zzekj) obj).zzv());
                    return;
                } else {
                    zzejo.zzgq(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    private final void zza(T t, Object obj) {
        if (!t.zzbhn()) {
            zza(t.zzbhl(), obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList2.get(i);
                i++;
                zza(t.zzbhl(), obj2);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzekt) {
            this.zziko = true;
        }
        this.zzikm.put(t, obj);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0025, code lost:
        if ((r3 instanceof com.google.android.gms.internal.ads.zzekj) == false) goto L_0x0014;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        if ((r3 instanceof byte[]) == false) goto L_0x0014;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001c, code lost:
        if ((r3 instanceof com.google.android.gms.internal.ads.zzekt) == false) goto L_0x0014;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zza(com.google.android.gms.internal.ads.zzenw r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.ads.zzekk.checkNotNull(r3)
            int[] r0 = com.google.android.gms.internal.ads.zzeka.zziks
            com.google.android.gms.internal.ads.zzenz r2 = r2.zzbkp()
            int r2 = r2.ordinal()
            r2 = r0[r2]
            r0 = 1
            r1 = 0
            switch(r2) {
                case 1: goto L_0x0040;
                case 2: goto L_0x003d;
                case 3: goto L_0x003a;
                case 4: goto L_0x0037;
                case 5: goto L_0x0034;
                case 6: goto L_0x0031;
                case 7: goto L_0x0028;
                case 8: goto L_0x001f;
                case 9: goto L_0x0016;
                default: goto L_0x0014;
            }
        L_0x0014:
            r0 = 0
            goto L_0x0042
        L_0x0016:
            boolean r2 = r3 instanceof com.google.android.gms.internal.ads.zzels
            if (r2 != 0) goto L_0x0042
            boolean r2 = r3 instanceof com.google.android.gms.internal.ads.zzekt
            if (r2 == 0) goto L_0x0014
            goto L_0x0042
        L_0x001f:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L_0x0042
            boolean r2 = r3 instanceof com.google.android.gms.internal.ads.zzekj
            if (r2 == 0) goto L_0x0014
            goto L_0x0042
        L_0x0028:
            boolean r2 = r3 instanceof com.google.android.gms.internal.ads.zzeiu
            if (r2 != 0) goto L_0x0042
            boolean r2 = r3 instanceof byte[]
            if (r2 == 0) goto L_0x0014
            goto L_0x0042
        L_0x0031:
            boolean r0 = r3 instanceof java.lang.String
            goto L_0x0042
        L_0x0034:
            boolean r0 = r3 instanceof java.lang.Boolean
            goto L_0x0042
        L_0x0037:
            boolean r0 = r3 instanceof java.lang.Double
            goto L_0x0042
        L_0x003a:
            boolean r0 = r3 instanceof java.lang.Float
            goto L_0x0042
        L_0x003d:
            boolean r0 = r3 instanceof java.lang.Long
            goto L_0x0042
        L_0x0040:
            boolean r0 = r3 instanceof java.lang.Integer
        L_0x0042:
            if (r0 == 0) goto L_0x0045
            return
        L_0x0045:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Wrong object type used with protocol message reflection."
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzejx.zza(com.google.android.gms.internal.ads.zzenw, java.lang.Object):void");
    }

    private static Object zzal(Object obj) {
        if (obj instanceof zzelx) {
            return ((zzelx) obj).zzbfi();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public static int zzb(zzejz<?> zzejz, Object obj) {
        zzenw zzbhl = zzejz.zzbhl();
        int zzv = zzejz.zzv();
        if (!zzejz.zzbhn()) {
            return zza(zzbhl, zzv, obj);
        }
        int i = 0;
        if (zzejz.zzbho()) {
            for (Object zzb : (List) obj) {
                i += zzb(zzbhl, zzb);
            }
            return zzejo.zzgu(zzv) + i + zzejo.zzhc(i);
        }
        for (Object zza : (List) obj) {
            i += zza(zzbhl, zzv, zza);
        }
        return i;
    }

    private static int zzb(zzenw zzenw, Object obj) {
        switch (zzeka.zzikd[zzenw.ordinal()]) {
            case 1:
                return zzejo.zzd(((Double) obj).doubleValue());
            case 2:
                return zzejo.zzg(((Float) obj).floatValue());
            case 3:
                return zzejo.zzfk(((Long) obj).longValue());
            case 4:
                return zzejo.zzfl(((Long) obj).longValue());
            case 5:
                return zzejo.zzgv(((Integer) obj).intValue());
            case 6:
                return zzejo.zzfn(((Long) obj).longValue());
            case 7:
                return zzejo.zzgy(((Integer) obj).intValue());
            case 8:
                return zzejo.zzbt(((Boolean) obj).booleanValue());
            case 9:
                return zzejo.zzi((zzels) obj);
            case 10:
                return obj instanceof zzekt ? zzejo.zza((zzekt) obj) : zzejo.zzh((zzels) obj);
            case 11:
                return obj instanceof zzeiu ? zzejo.zzaj((zzeiu) obj) : zzejo.zzhu((String) obj);
            case 12:
                return obj instanceof zzeiu ? zzejo.zzaj((zzeiu) obj) : zzejo.zzw((byte[]) obj);
            case 13:
                return zzejo.zzgw(((Integer) obj).intValue());
            case 14:
                return zzejo.zzgz(((Integer) obj).intValue());
            case 15:
                return zzejo.zzfo(((Long) obj).longValue());
            case 16:
                return zzejo.zzgx(((Integer) obj).intValue());
            case 17:
                return zzejo.zzfm(((Long) obj).longValue());
            case 18:
                return obj instanceof zzekj ? zzejo.zzha(((zzekj) obj).zzv()) : zzejo.zzha(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    private static <T extends zzejz<T>> boolean zzb(Map.Entry<T, Object> entry) {
        zzejz zzejz = (zzejz) entry.getKey();
        if (zzejz.zzbhm() == zzenz.MESSAGE) {
            if (zzejz.zzbhn()) {
                for (zzels isInitialized : (List) entry.getValue()) {
                    if (!isInitialized.isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzels) {
                    if (!((zzels) value).isInitialized()) {
                        return false;
                    }
                } else if (value instanceof zzekt) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public static <T extends zzejz<T>> zzejx<T> zzbhg() {
        return zzikp;
    }

    private final void zzc(Map.Entry<T, Object> entry) {
        zzejz zzejz = (zzejz) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzekt) {
            zzekt zzekt = (zzekt) value;
            value = zzekt.zzbir();
        }
        if (zzejz.zzbhn()) {
            Object zza = zza(zzejz);
            if (zza == null) {
                zza = new ArrayList();
            }
            for (Object zzal : (List) value) {
                ((List) zza).add(zzal(zzal));
            }
            this.zzikm.put(zzejz, zza);
        } else if (zzejz.zzbhm() == zzenz.MESSAGE) {
            Object zza2 = zza(zzejz);
            if (zza2 == null) {
                this.zzikm.put(zzejz, zzal(value));
            } else {
                this.zzikm.put(zzejz, zza2 instanceof zzelx ? zzejz.zza((zzelx) zza2, (zzelx) value) : zzejz.zza(((zzels) zza2).zzbid(), (zzels) value).zzbhv());
            }
        } else {
            this.zzikm.put(zzejz, zzal(value));
        }
    }

    private static int zzd(Map.Entry<T, Object> entry) {
        zzejz zzejz = (zzejz) entry.getKey();
        Object value = entry.getValue();
        return (zzejz.zzbhm() != zzenz.MESSAGE || zzejz.zzbhn() || zzejz.zzbho()) ? zzb((zzejz<?>) zzejz, value) : value instanceof zzekt ? zzejo.zzb(((zzejz) entry.getKey()).zzv(), (zzekx) (zzekt) value) : zzejo.zzb(((zzejz) entry.getKey()).zzv(), (zzels) value);
    }

    public final /* synthetic */ Object clone() {
        zzejx zzejx = new zzejx();
        for (int i = 0; i < this.zzikm.zzbjx(); i++) {
            Map.Entry<T, Object> zzht = this.zzikm.zzht(i);
            zzejx.zza((zzejz) zzht.getKey(), zzht.getValue());
        }
        for (Map.Entry next : this.zzikm.zzbjy()) {
            zzejx.zza((zzejz) next.getKey(), next.getValue());
        }
        zzejx.zziko = this.zziko;
        return zzejx;
    }

    /* access modifiers changed from: package-private */
    public final Iterator<Map.Entry<T, Object>> descendingIterator() {
        return this.zziko ? new zzeky(this.zzikm.zzbjz().iterator()) : this.zzikm.zzbjz().iterator();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzejx)) {
            return false;
        }
        return this.zzikm.equals(((zzejx) obj).zzikm);
    }

    public final int hashCode() {
        return this.zzikm.hashCode();
    }

    public final boolean isImmutable() {
        return this.zzikn;
    }

    public final boolean isInitialized() {
        for (int i = 0; i < this.zzikm.zzbjx(); i++) {
            if (!zzb(this.zzikm.zzht(i))) {
                return false;
            }
        }
        for (Map.Entry<T, Object> zzb : this.zzikm.zzbjy()) {
            if (!zzb(zzb)) {
                return false;
            }
        }
        return true;
    }

    public final Iterator<Map.Entry<T, Object>> iterator() {
        return this.zziko ? new zzeky(this.zzikm.entrySet().iterator()) : this.zzikm.entrySet().iterator();
    }

    public final void zza(zzejx<T> zzejx) {
        for (int i = 0; i < zzejx.zzikm.zzbjx(); i++) {
            zzc(zzejx.zzikm.zzht(i));
        }
        for (Map.Entry<T, Object> zzc : zzejx.zzikm.zzbjy()) {
            zzc(zzc);
        }
    }

    public final void zzbfl() {
        if (!this.zzikn) {
            this.zzikm.zzbfl();
            this.zzikn = true;
        }
    }

    public final int zzbhh() {
        int i = 0;
        for (int i2 = 0; i2 < this.zzikm.zzbjx(); i2++) {
            i += zzd(this.zzikm.zzht(i2));
        }
        for (Map.Entry<T, Object> zzd : this.zzikm.zzbjy()) {
            i += zzd(zzd);
        }
        return i;
    }
}
