package com.google.android.gms.internal.ads;

import android.util.Pair;

public final class zzpf {
    private static final byte[] zzbjq = {0, 0, 0, 1};
    private static final int[] zzbjr = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};
    private static final int[] zzbjs = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    private static int zza(zzpk zzpk) {
        int zzbh = zzpk.zzbh(5);
        return zzbh == 31 ? zzpk.zzbh(6) + 32 : zzbh;
    }

    private static int zzb(zzpk zzpk) {
        int zzbh = zzpk.zzbh(4);
        if (zzbh == 15) {
            return zzpk.zzbh(24);
        }
        zzpc.checkArgument(zzbh < 13);
        return zzbjr[zzbh];
    }

    public static byte[] zzc(byte[] bArr, int i, int i2) {
        byte[] bArr2 = zzbjq;
        byte[] bArr3 = new byte[(bArr2.length + i2)];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, i, bArr3, zzbjq.length, i2);
        return bArr3;
    }

    public static Pair<Integer, Integer> zze(byte[] bArr) {
        zzpk zzpk = new zzpk(bArr);
        int zza = zza(zzpk);
        int zzb = zzb(zzpk);
        int zzbh = zzpk.zzbh(4);
        if (zza == 5 || zza == 29) {
            zzb = zzb(zzpk);
            if (zza(zzpk) == 22) {
                zzbh = zzpk.zzbh(4);
            }
        }
        int i = zzbjs[zzbh];
        zzpc.checkArgument(i != -1);
        return Pair.create(Integer.valueOf(zzb), Integer.valueOf(i));
    }
}
