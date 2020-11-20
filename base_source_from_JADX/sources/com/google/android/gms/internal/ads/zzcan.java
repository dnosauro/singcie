package com.google.android.gms.internal.ads;

import java.util.Map;

final class zzcan implements zzbod<zzboi> {
    private final zzccl zzftd;
    private final Map<String, zzcqz<zzboi>> zzfux;
    private final Map<String, zzcqz<zzcbt>> zzgaf;
    private final Map<String, zzcto<zzcbt>> zzgag;
    private final zzeps<zzbod<zzbme>> zzgah;

    zzcan(Map<String, zzcqz<zzboi>> map, Map<String, zzcqz<zzcbt>> map2, Map<String, zzcto<zzcbt>> map3, zzeps<zzbod<zzbme>> zzeps, zzccl zzccl) {
        this.zzfux = map;
        this.zzgaf = map2;
        this.zzgag = map3;
        this.zzgah = zzeps;
        this.zzftd = zzccl;
    }

    public final zzcqz<zzboi> zze(int i, String str) {
        zzcqz zze;
        zzcqz<zzboi> zzcqz = this.zzfux.get(str);
        if (zzcqz != null) {
            return zzcqz;
        }
        if (i != 1) {
            if (i != 4) {
                return null;
            }
            zzcto zzcto = this.zzgag.get(str);
            if (zzcto != null) {
                return zzboi.zza((zzcto<? extends zzboc>) zzcto);
            }
            zzcqz zzcqz2 = this.zzgaf.get(str);
            if (zzcqz2 != null) {
                return zzboi.zza((zzcqz<? extends zzboc>) zzcqz2);
            }
            return null;
        } else if (this.zzftd.zzanu() == null || (zze = this.zzgah.get().zze(i, str)) == null) {
            return null;
        } else {
            return zzboi.zza((zzcqz<? extends zzboc>) zze);
        }
    }
}
