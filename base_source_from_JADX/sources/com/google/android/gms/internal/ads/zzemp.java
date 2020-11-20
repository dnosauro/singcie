package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

final class zzemp {
    private static final Class<?> zzirh = zzbjv();
    private static final zzenf<?, ?> zziri = zzbv(false);
    private static final zzenf<?, ?> zzirj = zzbv(true);
    private static final zzenf<?, ?> zzirk = new zzenh();

    static <UT, UB> UB zza(int i, int i2, UB ub, zzenf<UT, UB> zzenf) {
        if (ub == null) {
            ub = zzenf.zzbkf();
        }
        zzenf.zza(ub, i, (long) i2);
        return ub;
    }

    static <UT, UB> UB zza(int i, List<Integer> list, zzekl zzekl, UB ub, zzenf<UT, UB> zzenf) {
        UB ub2;
        if (zzekl == null) {
            return ub;
        }
        if (!(list instanceof RandomAccess)) {
            Iterator<Integer> it = list.iterator();
            loop1:
            while (true) {
                ub2 = ub;
                while (it.hasNext()) {
                    int intValue = it.next().intValue();
                    if (!zzekl.zzi(intValue)) {
                        ub = zza(i, intValue, ub2, zzenf);
                        it.remove();
                    }
                }
                break loop1;
            }
        } else {
            int size = list.size();
            ub2 = ub;
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue2 = list.get(i3).intValue();
                if (zzekl.zzi(intValue2)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue2));
                    }
                    i2++;
                } else {
                    ub2 = zza(i, intValue2, ub2, zzenf);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        }
        return ub2;
    }

    public static void zza(int i, List<String> list, zzeoc zzeoc) {
        if (list != null && !list.isEmpty()) {
            zzeoc.zza(i, list);
        }
    }

    public static void zza(int i, List<?> list, zzeoc zzeoc, zzemn zzemn) {
        if (list != null && !list.isEmpty()) {
            zzeoc.zza(i, list, zzemn);
        }
    }

    public static void zza(int i, List<Double> list, zzeoc zzeoc, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzeoc.zzg(i, list, z);
        }
    }

    static <T, FT extends zzejz<FT>> void zza(zzejw<FT> zzejw, T t, T t2) {
        zzejx<FT> zzai = zzejw.zzai(t2);
        if (!zzai.zzikm.isEmpty()) {
            zzejw.zzaj(t).zza(zzai);
        }
    }

    static <T> void zza(zzell zzell, T t, T t2, long j) {
        zzenl.zza((Object) t, j, zzell.zzf(zzenl.zzp(t, j), zzenl.zzp(t2, j)));
    }

    static <T, UT, UB> void zza(zzenf<UT, UB> zzenf, T t, T t2) {
        zzenf.zzi(t, zzenf.zzk(zzenf.zzay(t), zzenf.zzay(t2)));
    }

    static int zzab(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzelg) {
            zzelg zzelg = (zzelg) list;
            i = 0;
            while (i2 < size) {
                i += zzejo.zzfk(zzelg.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzejo.zzfk(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzac(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzelg) {
            zzelg zzelg = (zzelg) list;
            i = 0;
            while (i2 < size) {
                i += zzejo.zzfl(zzelg.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzejo.zzfl(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzad(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzelg) {
            zzelg zzelg = (zzelg) list;
            i = 0;
            while (i2 < size) {
                i += zzejo.zzfm(zzelg.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzejo.zzfm(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzae(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzeki) {
            zzeki zzeki = (zzeki) list;
            i = 0;
            while (i2 < size) {
                i += zzejo.zzha(zzeki.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzejo.zzha(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzaf(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzeki) {
            zzeki zzeki = (zzeki) list;
            i = 0;
            while (i2 < size) {
                i += zzejo.zzgv(zzeki.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzejo.zzgv(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzag(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzeki) {
            zzeki zzeki = (zzeki) list;
            i = 0;
            while (i2 < size) {
                i += zzejo.zzgw(zzeki.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzejo.zzgw(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzah(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzeki) {
            zzeki zzeki = (zzeki) list;
            i = 0;
            while (i2 < size) {
                i += zzejo.zzgx(zzeki.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzejo.zzgx(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzai(List<?> list) {
        return list.size() << 2;
    }

    static int zzaj(List<?> list) {
        return list.size() << 3;
    }

    static int zzak(List<?> list) {
        return list.size();
    }

    public static void zzb(int i, List<zzeiu> list, zzeoc zzeoc) {
        if (list != null && !list.isEmpty()) {
            zzeoc.zzb(i, list);
        }
    }

    public static void zzb(int i, List<?> list, zzeoc zzeoc, zzemn zzemn) {
        if (list != null && !list.isEmpty()) {
            zzeoc.zzb(i, list, zzemn);
        }
    }

    public static void zzb(int i, List<Float> list, zzeoc zzeoc, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzeoc.zzf(i, list, z);
        }
    }

    public static zzenf<?, ?> zzbjs() {
        return zziri;
    }

    public static zzenf<?, ?> zzbjt() {
        return zzirj;
    }

    public static zzenf<?, ?> zzbju() {
        return zzirk;
    }

    private static Class<?> zzbjv() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zzbjw() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static zzenf<?, ?> zzbv(boolean z) {
        try {
            Class<?> zzbjw = zzbjw();
            if (zzbjw == null) {
                return null;
            }
            return (zzenf) zzbjw.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
        } catch (Throwable unused) {
            return null;
        }
    }

    static int zzc(int i, Object obj, zzemn zzemn) {
        return obj instanceof zzekx ? zzejo.zza(i, (zzekx) obj) : zzejo.zzb(i, (zzels) obj, zzemn);
    }

    static int zzc(int i, List<?> list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int zzgu = zzejo.zzgu(i) * size;
        if (list instanceof zzekz) {
            zzekz zzekz = (zzekz) list;
            while (i2 < size) {
                Object zzhi = zzekz.zzhi(i2);
                zzgu += zzhi instanceof zzeiu ? zzejo.zzaj((zzeiu) zzhi) : zzejo.zzhu((String) zzhi);
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                zzgu += obj instanceof zzeiu ? zzejo.zzaj((zzeiu) obj) : zzejo.zzhu((String) obj);
                i2++;
            }
        }
        return zzgu;
    }

    static int zzc(int i, List<?> list, zzemn zzemn) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzgu = zzejo.zzgu(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            zzgu += obj instanceof zzekx ? zzejo.zza((zzekx) obj) : zzejo.zza((zzels) obj, zzemn);
        }
        return zzgu;
    }

    public static void zzc(int i, List<Long> list, zzeoc zzeoc, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzeoc.zzc(i, list, z);
        }
    }

    static int zzd(int i, List<zzeiu> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzgu = size * zzejo.zzgu(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzgu += zzejo.zzaj(list.get(i2));
        }
        return zzgu;
    }

    static int zzd(int i, List<zzels> list, zzemn zzemn) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzejo.zzc(i, list.get(i3), zzemn);
        }
        return i2;
    }

    public static void zzd(int i, List<Long> list, zzeoc zzeoc, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzeoc.zzd(i, list, z);
        }
    }

    public static void zze(int i, List<Long> list, zzeoc zzeoc, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzeoc.zzn(i, list, z);
        }
    }

    public static void zzf(int i, List<Long> list, zzeoc zzeoc, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzeoc.zze(i, list, z);
        }
    }

    public static void zzg(int i, List<Long> list, zzeoc zzeoc, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzeoc.zzl(i, list, z);
        }
    }

    public static void zzh(int i, List<Integer> list, zzeoc zzeoc, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzeoc.zza(i, list, z);
        }
    }

    static boolean zzh(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static void zzi(int i, List<Integer> list, zzeoc zzeoc, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzeoc.zzj(i, list, z);
        }
    }

    public static void zzi(Class<?> cls) {
        Class<?> cls2;
        if (!zzekh.class.isAssignableFrom(cls) && (cls2 = zzirh) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zzj(int i, List<Integer> list, zzeoc zzeoc, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzeoc.zzm(i, list, z);
        }
    }

    public static void zzk(int i, List<Integer> list, zzeoc zzeoc, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzeoc.zzb(i, list, z);
        }
    }

    public static void zzl(int i, List<Integer> list, zzeoc zzeoc, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzeoc.zzk(i, list, z);
        }
    }

    public static void zzm(int i, List<Integer> list, zzeoc zzeoc, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzeoc.zzh(i, list, z);
        }
    }

    public static void zzn(int i, List<Boolean> list, zzeoc zzeoc, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzeoc.zzi(i, list, z);
        }
    }

    static int zzo(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zzab(list) + (list.size() * zzejo.zzgu(i));
    }

    static int zzp(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzac(list) + (size * zzejo.zzgu(i));
    }

    static int zzq(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzad(list) + (size * zzejo.zzgu(i));
    }

    static int zzr(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzae(list) + (size * zzejo.zzgu(i));
    }

    static int zzs(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzaf(list) + (size * zzejo.zzgu(i));
    }

    static int zzt(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzag(list) + (size * zzejo.zzgu(i));
    }

    static int zzu(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzah(list) + (size * zzejo.zzgu(i));
    }

    static int zzv(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzejo.zzaj(i, 0);
    }

    static int zzw(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzejo.zzo(i, 0);
    }

    static int zzx(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzejo.zzi(i, true);
    }
}
