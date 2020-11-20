package com.google.android.gms.internal.ads;

import android.support.p002v4.media.session.PlaybackStateCompat;

final class zzlp {
    private static final int[] zzbag = {zzpt.zzbh("isom"), zzpt.zzbh("iso2"), zzpt.zzbh("iso3"), zzpt.zzbh("iso4"), zzpt.zzbh("iso5"), zzpt.zzbh("iso6"), zzpt.zzbh("avc1"), zzpt.zzbh("hvc1"), zzpt.zzbh("hev1"), zzpt.zzbh("mp41"), zzpt.zzbh("mp42"), zzpt.zzbh("3g2a"), zzpt.zzbh("3g2b"), zzpt.zzbh("3gr6"), zzpt.zzbh("3gs6"), zzpt.zzbh("3ge6"), zzpt.zzbh("3gg6"), zzpt.zzbh("M4V "), zzpt.zzbh("M4A "), zzpt.zzbh("f4v "), zzpt.zzbh("kddi"), zzpt.zzbh("M4VP"), zzpt.zzbh("qt  "), zzpt.zzbh("MSNV")};

    private static boolean zza(zzjz zzjz, boolean z) {
        boolean z2;
        boolean z3;
        zzjz zzjz2 = zzjz;
        long length = zzjz.getLength();
        if (length == -1 || length > PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) {
            length = 4096;
        }
        int i = (int) length;
        zzpn zzpn = new zzpn(64);
        int i2 = 0;
        boolean z4 = false;
        while (true) {
            if (i2 >= i) {
                break;
            }
            zzpn.reset(8);
            zzjz2.zza(zzpn.data, 0, 8);
            long zzjc = zzpn.zzjc();
            int readInt = zzpn.readInt();
            int i3 = 16;
            if (zzjc == 1) {
                zzjz2.zza(zzpn.data, 8, 8);
                zzpn.zzbk(16);
                zzjc = zzpn.zzjg();
            } else {
                i3 = 8;
            }
            long j = (long) i3;
            if (zzjc >= j) {
                i2 += i3;
                if (readInt != zzks.zzatr) {
                    if (readInt != zzks.zzaua && readInt != zzks.zzauc) {
                        if ((((long) i2) + zzjc) - j >= ((long) i)) {
                            break;
                        }
                        int i4 = (int) (zzjc - j);
                        i2 += i4;
                        if (readInt == zzks.zzasq) {
                            if (i4 < 8) {
                                return false;
                            }
                            zzpn.reset(i4);
                            zzjz2.zza(zzpn.data, 0, i4);
                            int i5 = i4 / 4;
                            int i6 = 0;
                            while (true) {
                                if (i6 >= i5) {
                                    break;
                                }
                                if (i6 == 1) {
                                    zzpn.zzbm(4);
                                } else {
                                    int readInt2 = zzpn.readInt();
                                    if ((readInt2 >>> 8) != zzpt.zzbh("3gp")) {
                                        int[] iArr = zzbag;
                                        int length2 = iArr.length;
                                        int i7 = 0;
                                        while (true) {
                                            if (i7 >= length2) {
                                                z3 = false;
                                                break;
                                            } else if (iArr[i7] == readInt2) {
                                                break;
                                            } else {
                                                i7++;
                                            }
                                        }
                                    }
                                    z3 = true;
                                    if (z3) {
                                        z4 = true;
                                        break;
                                    }
                                }
                                i6++;
                            }
                            if (!z4) {
                                return false;
                            }
                        } else if (i4 != 0) {
                            zzjz2.zzah(i4);
                        }
                    } else {
                        z2 = true;
                    }
                }
            } else {
                return false;
            }
        }
        z2 = false;
        return z4 && z == z2;
    }

    public static boolean zzd(zzjz zzjz) {
        return zza(zzjz, true);
    }

    public static boolean zze(zzjz zzjz) {
        return zza(zzjz, false);
    }
}
