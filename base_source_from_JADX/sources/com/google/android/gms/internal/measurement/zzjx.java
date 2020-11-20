package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

final class zzjx {
    private static final Class<?> zza = zzd();
    private static final zzkn<?, ?> zzb = zza(false);
    private static final zzkn<?, ?> zzc = zza(true);
    private static final zzkn<?, ?> zzd = new zzkp();

    static int zza(int i, Object obj, zzjv zzjv) {
        return obj instanceof zzil ? zzhf.zza(i, (zzil) obj) : zzhf.zzb(i, (zzjg) obj, zzjv);
    }

    static int zza(int i, List<?> list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int zze = zzhf.zze(i) * size;
        if (list instanceof zzin) {
            zzin zzin = (zzin) list;
            while (i2 < size) {
                Object zzb2 = zzin.zzb(i2);
                zze += zzb2 instanceof zzgm ? zzhf.zzb((zzgm) zzb2) : zzhf.zzb((String) zzb2);
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                zze += obj instanceof zzgm ? zzhf.zzb((zzgm) obj) : zzhf.zzb((String) obj);
                i2++;
            }
        }
        return zze;
    }

    static int zza(int i, List<?> list, zzjv zzjv) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zze = zzhf.zze(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            zze += obj instanceof zzil ? zzhf.zza((zzil) obj) : zzhf.zza((zzjg) obj, zzjv);
        }
        return zze;
    }

    static int zza(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zza(list) + (list.size() * zzhf.zze(i));
    }

    static int zza(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zziu) {
            zziu zziu = (zziu) list;
            i = 0;
            while (i2 < size) {
                i += zzhf.zzd(zziu.zzb(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzhf.zzd(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static zzkn<?, ?> zza() {
        return zzb;
    }

    private static zzkn<?, ?> zza(boolean z) {
        try {
            Class<?> zze = zze();
            if (zze == null) {
                return null;
            }
            return (zzkn) zze.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
        } catch (Throwable unused) {
            return null;
        }
    }

    static <UT, UB> UB zza(int i, int i2, UB ub, zzkn<UT, UB> zzkn) {
        if (ub == null) {
            ub = zzkn.zza();
        }
        zzkn.zza(ub, i, (long) i2);
        return ub;
    }

    static <UT, UB> UB zza(int i, List<Integer> list, zzic zzic, UB ub, zzkn<UT, UB> zzkn) {
        UB ub2;
        if (zzic == null) {
            return ub;
        }
        if (!(list instanceof RandomAccess)) {
            Iterator<Integer> it = list.iterator();
            loop1:
            while (true) {
                ub2 = ub;
                while (it.hasNext()) {
                    int intValue = it.next().intValue();
                    if (!zzic.zza(intValue)) {
                        ub = zza(i, intValue, ub2, zzkn);
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
                if (zzic.zza(intValue2)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue2));
                    }
                    i2++;
                } else {
                    ub2 = zza(i, intValue2, ub2, zzkn);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        }
        return ub2;
    }

    public static void zza(int i, List<String> list, zzlk zzlk) {
        if (list != null && !list.isEmpty()) {
            zzlk.zza(i, list);
        }
    }

    public static void zza(int i, List<?> list, zzlk zzlk, zzjv zzjv) {
        if (list != null && !list.isEmpty()) {
            zzlk.zza(i, list, zzjv);
        }
    }

    public static void zza(int i, List<Double> list, zzlk zzlk, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzlk.zzg(i, list, z);
        }
    }

    static <T, FT extends zzhq<FT>> void zza(zzhk<FT> zzhk, T t, T t2) {
        zzho<FT> zza2 = zzhk.zza((Object) t2);
        if (!zza2.zza.isEmpty()) {
            zzhk.zzb(t).zza(zza2);
        }
    }

    static <T> void zza(zziz zziz, T t, T t2, long j) {
        zzkt.zza((Object) t, j, zziz.zza(zzkt.zzf(t, j), zzkt.zzf(t2, j)));
    }

    static <T, UT, UB> void zza(zzkn<UT, UB> zzkn, T t, T t2) {
        zzkn.zza((Object) t, zzkn.zzc(zzkn.zzb(t), zzkn.zzb(t2)));
    }

    public static void zza(Class<?> cls) {
        Class<?> cls2;
        if (!zzhv.class.isAssignableFrom(cls) && (cls2 = zza) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    static boolean zza(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static int zzb(int i, List<zzgm> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zze = size * zzhf.zze(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            zze += zzhf.zzb(list.get(i2));
        }
        return zze;
    }

    static int zzb(int i, List<zzjg> list, zzjv zzjv) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzhf.zzc(i, list.get(i3), zzjv);
        }
        return i2;
    }

    static int zzb(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzb(list) + (size * zzhf.zze(i));
    }

    static int zzb(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zziu) {
            zziu zziu = (zziu) list;
            i = 0;
            while (i2 < size) {
                i += zzhf.zze(zziu.zzb(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzhf.zze(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static zzkn<?, ?> zzb() {
        return zzc;
    }

    public static void zzb(int i, List<zzgm> list, zzlk zzlk) {
        if (list != null && !list.isEmpty()) {
            zzlk.zzb(i, list);
        }
    }

    public static void zzb(int i, List<?> list, zzlk zzlk, zzjv zzjv) {
        if (list != null && !list.isEmpty()) {
            zzlk.zzb(i, list, zzjv);
        }
    }

    public static void zzb(int i, List<Float> list, zzlk zzlk, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzlk.zzf(i, list, z);
        }
    }

    static int zzc(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzc(list) + (size * zzhf.zze(i));
    }

    static int zzc(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zziu) {
            zziu zziu = (zziu) list;
            i = 0;
            while (i2 < size) {
                i += zzhf.zzf(zziu.zzb(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzhf.zzf(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static zzkn<?, ?> zzc() {
        return zzd;
    }

    public static void zzc(int i, List<Long> list, zzlk zzlk, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzlk.zzc(i, list, z);
        }
    }

    static int zzd(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzd(list) + (size * zzhf.zze(i));
    }

    static int zzd(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzhy) {
            zzhy zzhy = (zzhy) list;
            i = 0;
            while (i2 < size) {
                i += zzhf.zzk(zzhy.zzc(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzhf.zzk(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    private static Class<?> zzd() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void zzd(int i, List<Long> list, zzlk zzlk, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzlk.zzd(i, list, z);
        }
    }

    static int zze(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zze(list) + (size * zzhf.zze(i));
    }

    static int zze(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzhy) {
            zzhy zzhy = (zzhy) list;
            i = 0;
            while (i2 < size) {
                i += zzhf.zzf(zzhy.zzc(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzhf.zzf(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    private static Class<?> zze() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void zze(int i, List<Long> list, zzlk zzlk, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzlk.zzn(i, list, z);
        }
    }

    static int zzf(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzf(list) + (size * zzhf.zze(i));
    }

    static int zzf(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzhy) {
            zzhy zzhy = (zzhy) list;
            i = 0;
            while (i2 < size) {
                i += zzhf.zzg(zzhy.zzc(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzhf.zzg(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static void zzf(int i, List<Long> list, zzlk zzlk, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzlk.zze(i, list, z);
        }
    }

    static int zzg(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzg(list) + (size * zzhf.zze(i));
    }

    static int zzg(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzhy) {
            zzhy zzhy = (zzhy) list;
            i = 0;
            while (i2 < size) {
                i += zzhf.zzh(zzhy.zzc(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzhf.zzh(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static void zzg(int i, List<Long> list, zzlk zzlk, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzlk.zzl(i, list, z);
        }
    }

    static int zzh(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzhf.zzi(i, 0);
    }

    static int zzh(List<?> list) {
        return list.size() << 2;
    }

    public static void zzh(int i, List<Integer> list, zzlk zzlk, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzlk.zza(i, list, z);
        }
    }

    static int zzi(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzhf.zzg(i, 0);
    }

    static int zzi(List<?> list) {
        return list.size() << 3;
    }

    public static void zzi(int i, List<Integer> list, zzlk zzlk, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzlk.zzj(i, list, z);
        }
    }

    static int zzj(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzhf.zzb(i, true);
    }

    static int zzj(List<?> list) {
        return list.size();
    }

    public static void zzj(int i, List<Integer> list, zzlk zzlk, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzlk.zzm(i, list, z);
        }
    }

    public static void zzk(int i, List<Integer> list, zzlk zzlk, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzlk.zzb(i, list, z);
        }
    }

    public static void zzl(int i, List<Integer> list, zzlk zzlk, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzlk.zzk(i, list, z);
        }
    }

    public static void zzm(int i, List<Integer> list, zzlk zzlk, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzlk.zzh(i, list, z);
        }
    }

    public static void zzn(int i, List<Boolean> list, zzlk zzlk, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzlk.zzi(i, list, z);
        }
    }
}
