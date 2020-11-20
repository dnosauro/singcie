package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.Map;

final class zzejr implements zzeoc {
    private final zzejo zzije;

    private zzejr(zzejo zzejo) {
        this.zzije = (zzejo) zzekk.zza(zzejo, "output");
        this.zzije.zzikc = this;
    }

    public static zzejr zza(zzejo zzejo) {
        return zzejo.zzikc != null ? zzejo.zzikc : new zzejr(zzejo);
    }

    public final void zza(int i, float f) {
        this.zzije.zza(i, f);
    }

    public final void zza(int i, zzeiu zzeiu) {
        this.zzije.zza(i, zzeiu);
    }

    public final <K, V> void zza(int i, zzelj<K, V> zzelj, Map<K, V> map) {
        for (Map.Entry next : map.entrySet()) {
            this.zzije.writeTag(i, 2);
            this.zzije.zzgr(zzelk.zza(zzelj, next.getKey(), next.getValue()));
            zzelk.zza(this.zzije, zzelj, next.getKey(), next.getValue());
        }
    }

    public final void zza(int i, Object obj, zzemn zzemn) {
        this.zzije.zza(i, (zzels) obj, zzemn);
    }

    public final void zza(int i, List<String> list) {
        int i2 = 0;
        if (list instanceof zzekz) {
            zzekz zzekz = (zzekz) list;
            while (i2 < list.size()) {
                Object zzhi = zzekz.zzhi(i2);
                if (zzhi instanceof String) {
                    this.zzije.zzi(i, (String) zzhi);
                } else {
                    this.zzije.zza(i, (zzeiu) zzhi);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzije.zzi(i, list.get(i2));
            i2++;
        }
    }

    public final void zza(int i, List<?> list, zzemn zzemn) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zza(i, (Object) list.get(i2), zzemn);
        }
    }

    public final void zza(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.zzije.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzejo.zzgv(list.get(i4).intValue());
            }
            this.zzije.zzgr(i3);
            while (i2 < list.size()) {
                this.zzije.zzgq(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzije.zzac(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzac(int i, int i2) {
        this.zzije.zzac(i, i2);
    }

    public final void zzad(int i, int i2) {
        this.zzije.zzad(i, i2);
    }

    public final void zzae(int i, int i2) {
        this.zzije.zzae(i, i2);
    }

    public final void zzaf(int i, int i2) {
        this.zzije.zzaf(i, i2);
    }

    public final void zzam(int i, int i2) {
        this.zzije.zzaf(i, i2);
    }

    public final void zzan(int i, int i2) {
        this.zzije.zzac(i, i2);
    }

    public final void zzb(int i, double d) {
        this.zzije.zzb(i, d);
    }

    public final void zzb(int i, Object obj, zzemn zzemn) {
        zzejo zzejo = this.zzije;
        zzejo.writeTag(i, 3);
        zzemn.zza((zzels) obj, zzejo.zzikc);
        zzejo.writeTag(i, 4);
    }

    public final void zzb(int i, List<zzeiu> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zzije.zza(i, list.get(i2));
        }
    }

    public final void zzb(int i, List<?> list, zzemn zzemn) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzb(i, (Object) list.get(i2), zzemn);
        }
    }

    public final void zzb(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.zzije.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzejo.zzgy(list.get(i4).intValue());
            }
            this.zzije.zzgr(i3);
            while (i2 < list.size()) {
                this.zzije.zzgt(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzije.zzaf(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final int zzbhd() {
        return zzeob.zziug;
    }

    public final void zzc(int i, Object obj) {
        if (obj instanceof zzeiu) {
            this.zzije.zzb(i, (zzeiu) obj);
        } else {
            this.zzije.zza(i, (zzels) obj);
        }
    }

    public final void zzc(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.zzije.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzejo.zzfk(list.get(i4).longValue());
            }
            this.zzije.zzgr(i3);
            while (i2 < list.size()) {
                this.zzije.zzfh(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzije.zzi(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zzd(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.zzije.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzejo.zzfl(list.get(i4).longValue());
            }
            this.zzije.zzgr(i3);
            while (i2 < list.size()) {
                this.zzije.zzfh(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzije.zzi(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zze(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.zzije.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzejo.zzfn(list.get(i4).longValue());
            }
            this.zzije.zzgr(i3);
            while (i2 < list.size()) {
                this.zzije.zzfj(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzije.zzk(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zzf(int i, List<Float> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.zzije.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzejo.zzg(list.get(i4).floatValue());
            }
            this.zzije.zzgr(i3);
            while (i2 < list.size()) {
                this.zzije.zzf(list.get(i2).floatValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzije.zza(i, list.get(i2).floatValue());
            i2++;
        }
    }

    public final void zzg(int i, List<Double> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.zzije.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzejo.zzd(list.get(i4).doubleValue());
            }
            this.zzije.zzgr(i3);
            while (i2 < list.size()) {
                this.zzije.zzc(list.get(i2).doubleValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzije.zzb(i, list.get(i2).doubleValue());
            i2++;
        }
    }

    public final void zzh(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.zzije.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzejo.zzha(list.get(i4).intValue());
            }
            this.zzije.zzgr(i3);
            while (i2 < list.size()) {
                this.zzije.zzgq(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzije.zzac(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzh(int i, boolean z) {
        this.zzije.zzh(i, z);
    }

    public final void zzhd(int i) {
        this.zzije.writeTag(i, 3);
    }

    public final void zzhe(int i) {
        this.zzije.writeTag(i, 4);
    }

    public final void zzi(int i, long j) {
        this.zzije.zzi(i, j);
    }

    public final void zzi(int i, String str) {
        this.zzije.zzi(i, str);
    }

    public final void zzi(int i, List<Boolean> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.zzije.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzejo.zzbt(list.get(i4).booleanValue());
            }
            this.zzije.zzgr(i3);
            while (i2 < list.size()) {
                this.zzije.zzbs(list.get(i2).booleanValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzije.zzh(i, list.get(i2).booleanValue());
            i2++;
        }
    }

    public final void zzj(int i, long j) {
        this.zzije.zzj(i, j);
    }

    public final void zzj(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.zzije.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzejo.zzgw(list.get(i4).intValue());
            }
            this.zzije.zzgr(i3);
            while (i2 < list.size()) {
                this.zzije.zzgr(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzije.zzad(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzk(int i, long j) {
        this.zzije.zzk(i, j);
    }

    public final void zzk(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.zzije.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzejo.zzgz(list.get(i4).intValue());
            }
            this.zzije.zzgr(i3);
            while (i2 < list.size()) {
                this.zzije.zzgt(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzije.zzaf(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzl(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.zzije.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzejo.zzfo(list.get(i4).longValue());
            }
            this.zzije.zzgr(i3);
            while (i2 < list.size()) {
                this.zzije.zzfj(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzije.zzk(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zzm(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.zzije.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzejo.zzgx(list.get(i4).intValue());
            }
            this.zzije.zzgr(i3);
            while (i2 < list.size()) {
                this.zzije.zzgs(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzije.zzae(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzn(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.zzije.writeTag(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzejo.zzfm(list.get(i4).longValue());
            }
            this.zzije.zzgr(i3);
            while (i2 < list.size()) {
                this.zzije.zzfi(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzije.zzj(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zzq(int i, long j) {
        this.zzije.zzi(i, j);
    }

    public final void zzr(int i, long j) {
        this.zzije.zzk(i, j);
    }
}
