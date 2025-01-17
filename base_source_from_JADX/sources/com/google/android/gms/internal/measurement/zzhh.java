package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzhv;
import java.util.List;
import java.util.Map;

final class zzhh implements zzlk {
    private final zzhf zza;

    private zzhh(zzhf zzhf) {
        this.zza = (zzhf) zzhx.zza(zzhf, "output");
        this.zza.zza = this;
    }

    public static zzhh zza(zzhf zzhf) {
        return zzhf.zza != null ? zzhf.zza : new zzhh(zzhf);
    }

    public final int zza() {
        return zzhv.zze.zzj;
    }

    public final void zza(int i) {
        this.zza.zza(i, 3);
    }

    public final void zza(int i, double d) {
        this.zza.zza(i, d);
    }

    public final void zza(int i, float f) {
        this.zza.zza(i, f);
    }

    public final void zza(int i, int i2) {
        this.zza.zze(i, i2);
    }

    public final void zza(int i, long j) {
        this.zza.zza(i, j);
    }

    public final void zza(int i, zzgm zzgm) {
        this.zza.zza(i, zzgm);
    }

    public final <K, V> void zza(int i, zzix<K, V> zzix, Map<K, V> map) {
        for (Map.Entry next : map.entrySet()) {
            this.zza.zza(i, 2);
            this.zza.zzb(zziy.zza(zzix, next.getKey(), next.getValue()));
            zziy.zza(this.zza, zzix, next.getKey(), next.getValue());
        }
    }

    public final void zza(int i, Object obj) {
        if (obj instanceof zzgm) {
            this.zza.zzb(i, (zzgm) obj);
        } else {
            this.zza.zza(i, (zzjg) obj);
        }
    }

    public final void zza(int i, Object obj, zzjv zzjv) {
        this.zza.zza(i, (zzjg) obj, zzjv);
    }

    public final void zza(int i, String str) {
        this.zza.zza(i, str);
    }

    public final void zza(int i, List<String> list) {
        int i2 = 0;
        if (list instanceof zzin) {
            zzin zzin = (zzin) list;
            while (i2 < list.size()) {
                Object zzb = zzin.zzb(i2);
                if (zzb instanceof String) {
                    this.zza.zza(i, (String) zzb);
                } else {
                    this.zza.zza(i, (zzgm) zzb);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zza(i, list.get(i2));
            i2++;
        }
    }

    public final void zza(int i, List<?> list, zzjv zzjv) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zza(i, (Object) list.get(i2), zzjv);
        }
    }

    public final void zza(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.zza.zza(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzhf.zzf(list.get(i4).intValue());
            }
            this.zza.zzb(i3);
            while (i2 < list.size()) {
                this.zza.zza(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzb(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zza(int i, boolean z) {
        this.zza.zza(i, z);
    }

    public final void zzb(int i) {
        this.zza.zza(i, 4);
    }

    public final void zzb(int i, int i2) {
        this.zza.zzb(i, i2);
    }

    public final void zzb(int i, long j) {
        this.zza.zzc(i, j);
    }

    public final void zzb(int i, Object obj, zzjv zzjv) {
        zzhf zzhf = this.zza;
        zzhf.zza(i, 3);
        zzjv.zza((zzjg) obj, (zzlk) zzhf.zza);
        zzhf.zza(i, 4);
    }

    public final void zzb(int i, List<zzgm> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zza.zza(i, list.get(i2));
        }
    }

    public final void zzb(int i, List<?> list, zzjv zzjv) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzb(i, (Object) list.get(i2), zzjv);
        }
    }

    public final void zzb(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.zza.zza(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzhf.zzi(list.get(i4).intValue());
            }
            this.zza.zzb(i3);
            while (i2 < list.size()) {
                this.zza.zzd(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zze(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzc(int i, int i2) {
        this.zza.zzb(i, i2);
    }

    public final void zzc(int i, long j) {
        this.zza.zza(i, j);
    }

    public final void zzc(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.zza.zza(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzhf.zzd(list.get(i4).longValue());
            }
            this.zza.zzb(i3);
            while (i2 < list.size()) {
                this.zza.zza(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zza(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zzd(int i, int i2) {
        this.zza.zze(i, i2);
    }

    public final void zzd(int i, long j) {
        this.zza.zzc(i, j);
    }

    public final void zzd(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.zza.zza(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzhf.zze(list.get(i4).longValue());
            }
            this.zza.zzb(i3);
            while (i2 < list.size()) {
                this.zza.zza(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zza(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zze(int i, int i2) {
        this.zza.zzc(i, i2);
    }

    public final void zze(int i, long j) {
        this.zza.zzb(i, j);
    }

    public final void zze(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.zza.zza(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzhf.zzg(list.get(i4).longValue());
            }
            this.zza.zzb(i3);
            while (i2 < list.size()) {
                this.zza.zzc(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzc(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zzf(int i, int i2) {
        this.zza.zzd(i, i2);
    }

    public final void zzf(int i, List<Float> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.zza.zza(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzhf.zzb(list.get(i4).floatValue());
            }
            this.zza.zzb(i3);
            while (i2 < list.size()) {
                this.zza.zza(list.get(i2).floatValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zza(i, list.get(i2).floatValue());
            i2++;
        }
    }

    public final void zzg(int i, List<Double> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.zza.zza(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzhf.zzb(list.get(i4).doubleValue());
            }
            this.zza.zzb(i3);
            while (i2 < list.size()) {
                this.zza.zza(list.get(i2).doubleValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zza(i, list.get(i2).doubleValue());
            i2++;
        }
    }

    public final void zzh(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.zza.zza(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzhf.zzk(list.get(i4).intValue());
            }
            this.zza.zzb(i3);
            while (i2 < list.size()) {
                this.zza.zza(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzb(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzi(int i, List<Boolean> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.zza.zza(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzhf.zzb(list.get(i4).booleanValue());
            }
            this.zza.zzb(i3);
            while (i2 < list.size()) {
                this.zza.zza(list.get(i2).booleanValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zza(i, list.get(i2).booleanValue());
            i2++;
        }
    }

    public final void zzj(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.zza.zza(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzhf.zzg(list.get(i4).intValue());
            }
            this.zza.zzb(i3);
            while (i2 < list.size()) {
                this.zza.zzb(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzc(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzk(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.zza.zza(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzhf.zzj(list.get(i4).intValue());
            }
            this.zza.zzb(i3);
            while (i2 < list.size()) {
                this.zza.zzd(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zze(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzl(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.zza.zza(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzhf.zzh(list.get(i4).longValue());
            }
            this.zza.zzb(i3);
            while (i2 < list.size()) {
                this.zza.zzc(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzc(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zzm(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.zza.zza(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzhf.zzh(list.get(i4).intValue());
            }
            this.zza.zzb(i3);
            while (i2 < list.size()) {
                this.zza.zzc(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzd(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzn(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.zza.zza(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzhf.zzf(list.get(i4).longValue());
            }
            this.zza.zzb(i3);
            while (i2 < list.size()) {
                this.zza.zzb(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzb(i, list.get(i2).longValue());
            i2++;
        }
    }
}
