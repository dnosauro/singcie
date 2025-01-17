package com.google.android.gms.internal.measurement;

import org.spongycastle.asn1.eac.CertificateBody;

final class zzgi {
    static int zza(int i, byte[] bArr, int i2, int i3, zzgl zzgl) {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 5) {
                return i2 + 4;
            }
            switch (i4) {
                case 0:
                    return zzb(bArr, i2, zzgl);
                case 1:
                    return i2 + 8;
                case 2:
                    return zza(bArr, i2, zzgl) + zzgl.zza;
                case 3:
                    int i5 = (i & -8) | 4;
                    int i6 = 0;
                    while (i2 < i3) {
                        i2 = zza(bArr, i2, zzgl);
                        i6 = zzgl.zza;
                        if (i6 != i5) {
                            i2 = zza(i6, bArr, i2, i3, zzgl);
                        } else if (i2 > i3 && i6 == i5) {
                            return i2;
                        } else {
                            throw zzig.zzg();
                        }
                    }
                    if (i2 > i3) {
                    }
                    throw zzig.zzg();
                default:
                    throw zzig.zzd();
            }
        } else {
            throw zzig.zzd();
        }
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzid<?> zzid, zzgl zzgl) {
        zzhy zzhy = (zzhy) zzid;
        int zza = zza(bArr, i2, zzgl);
        while (true) {
            zzhy.zzd(zzgl.zza);
            if (zza >= i3) {
                break;
            }
            int zza2 = zza(bArr, zza, zzgl);
            if (i != zzgl.zza) {
                break;
            }
            zza = zza(bArr, zza2, zzgl);
        }
        return zza;
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzkq zzkq, zzgl zzgl) {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 != 5) {
                switch (i4) {
                    case 0:
                        int zzb = zzb(bArr, i2, zzgl);
                        zzkq.zza(i, (Object) Long.valueOf(zzgl.zzb));
                        return zzb;
                    case 1:
                        zzkq.zza(i, (Object) Long.valueOf(zzb(bArr, i2)));
                        return i2 + 8;
                    case 2:
                        int zza = zza(bArr, i2, zzgl);
                        int i5 = zzgl.zza;
                        if (i5 < 0) {
                            throw zzig.zzb();
                        } else if (i5 <= bArr.length - zza) {
                            zzkq.zza(i, (Object) i5 == 0 ? zzgm.zza : zzgm.zza(bArr, zza, i5));
                            return zza + i5;
                        } else {
                            throw zzig.zza();
                        }
                    case 3:
                        zzkq zzb2 = zzkq.zzb();
                        int i6 = (i & -8) | 4;
                        int i7 = 0;
                        while (true) {
                            if (i2 < i3) {
                                int zza2 = zza(bArr, i2, zzgl);
                                int i8 = zzgl.zza;
                                if (i8 != i6) {
                                    i7 = i8;
                                    i2 = zza(i8, bArr, zza2, i3, zzb2, zzgl);
                                } else {
                                    i7 = i8;
                                    i2 = zza2;
                                }
                            }
                        }
                        if (i2 > i3 || i7 != i6) {
                            throw zzig.zzg();
                        }
                        zzkq.zza(i, (Object) zzb2);
                        return i2;
                    default:
                        throw zzig.zzd();
                }
            } else {
                zzkq.zza(i, (Object) Integer.valueOf(zza(bArr, i2)));
                return i2 + 4;
            }
        } else {
            throw zzig.zzd();
        }
    }

    static int zza(int i, byte[] bArr, int i2, zzgl zzgl) {
        int i3;
        int i4;
        int i5 = i & CertificateBody.profileType;
        int i6 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            i4 = b << 7;
        } else {
            int i7 = i5 | ((b & Byte.MAX_VALUE) << 7);
            int i8 = i6 + 1;
            byte b2 = bArr[i6];
            if (b2 >= 0) {
                i3 = b2 << 14;
            } else {
                i5 = i7 | ((b2 & Byte.MAX_VALUE) << 14);
                i6 = i8 + 1;
                byte b3 = bArr[i8];
                if (b3 >= 0) {
                    i4 = b3 << 21;
                } else {
                    i7 = i5 | ((b3 & Byte.MAX_VALUE) << 21);
                    i8 = i6 + 1;
                    byte b4 = bArr[i6];
                    if (b4 >= 0) {
                        i3 = b4 << 28;
                    } else {
                        int i9 = i7 | ((b4 & Byte.MAX_VALUE) << 28);
                        while (true) {
                            int i10 = i8 + 1;
                            if (bArr[i8] >= 0) {
                                zzgl.zza = i9;
                                return i10;
                            }
                            i8 = i10;
                        }
                    }
                }
            }
            zzgl.zza = i7 | i3;
            return i8;
        }
        zzgl.zza = i5 | i4;
        return i6;
    }

    static int zza(zzjv<?> zzjv, int i, byte[] bArr, int i2, int i3, zzid<?> zzid, zzgl zzgl) {
        int zza = zza((zzjv) zzjv, bArr, i2, i3, zzgl);
        while (true) {
            zzid.add(zzgl.zzc);
            if (zza >= i3) {
                break;
            }
            int zza2 = zza(bArr, zza, zzgl);
            if (i != zzgl.zza) {
                break;
            }
            zza = zza((zzjv) zzjv, bArr, zza2, i3, zzgl);
        }
        return zza;
    }

    static int zza(zzjv zzjv, byte[] bArr, int i, int i2, int i3, zzgl zzgl) {
        zzjk zzjk = (zzjk) zzjv;
        Object zza = zzjk.zza();
        int zza2 = zzjk.zza(zza, bArr, i, i2, i3, zzgl);
        zzjk.zzc(zza);
        zzgl.zzc = zza;
        return zza2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int zza(com.google.android.gms.internal.measurement.zzjv r6, byte[] r7, int r8, int r9, com.google.android.gms.internal.measurement.zzgl r10) {
        /*
            int r0 = r8 + 1
            byte r8 = r7[r8]
            if (r8 >= 0) goto L_0x000c
            int r0 = zza((int) r8, (byte[]) r7, (int) r0, (com.google.android.gms.internal.measurement.zzgl) r10)
            int r8 = r10.zza
        L_0x000c:
            r3 = r0
            if (r8 < 0) goto L_0x0025
            int r9 = r9 - r3
            if (r8 > r9) goto L_0x0025
            java.lang.Object r9 = r6.zza()
            int r8 = r8 + r3
            r0 = r6
            r1 = r9
            r2 = r7
            r4 = r8
            r5 = r10
            r0.zza(r1, r2, r3, r4, r5)
            r6.zzc(r9)
            r10.zzc = r9
            return r8
        L_0x0025:
            com.google.android.gms.internal.measurement.zzig r6 = com.google.android.gms.internal.measurement.zzig.zza()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgi.zza(com.google.android.gms.internal.measurement.zzjv, byte[], int, int, com.google.android.gms.internal.measurement.zzgl):int");
    }

    static int zza(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << Tnaf.POW_2_WIDTH);
    }

    static int zza(byte[] bArr, int i, zzgl zzgl) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zza((int) b, bArr, i2, zzgl);
        }
        zzgl.zza = b;
        return i2;
    }

    static int zza(byte[] bArr, int i, zzid<?> zzid, zzgl zzgl) {
        zzhy zzhy = (zzhy) zzid;
        int zza = zza(bArr, i, zzgl);
        int i2 = zzgl.zza + zza;
        while (zza < i2) {
            zza = zza(bArr, zza, zzgl);
            zzhy.zzd(zzgl.zza);
        }
        if (zza == i2) {
            return zza;
        }
        throw zzig.zza();
    }

    static int zzb(byte[] bArr, int i, zzgl zzgl) {
        int i2 = i + 1;
        long j = (long) bArr[i];
        if (j >= 0) {
            zzgl.zzb = j;
            return i2;
        }
        int i3 = i2 + 1;
        byte b = bArr[i2];
        long j2 = (j & 127) | (((long) (b & Byte.MAX_VALUE)) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            i4 += 7;
            j2 |= ((long) (b2 & Byte.MAX_VALUE)) << i4;
            int i6 = i5;
            b = b2;
            i3 = i6;
        }
        zzgl.zzb = j2;
        return i3;
    }

    static long zzb(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    static double zzc(byte[] bArr, int i) {
        return Double.longBitsToDouble(zzb(bArr, i));
    }

    static int zzc(byte[] bArr, int i, zzgl zzgl) {
        int zza = zza(bArr, i, zzgl);
        int i2 = zzgl.zza;
        if (i2 < 0) {
            throw zzig.zzb();
        } else if (i2 == 0) {
            zzgl.zzc = "";
            return zza;
        } else {
            zzgl.zzc = new String(bArr, zza, i2, zzhx.zza);
            return zza + i2;
        }
    }

    static float zzd(byte[] bArr, int i) {
        return Float.intBitsToFloat(zza(bArr, i));
    }

    static int zzd(byte[] bArr, int i, zzgl zzgl) {
        int zza = zza(bArr, i, zzgl);
        int i2 = zzgl.zza;
        if (i2 < 0) {
            throw zzig.zzb();
        } else if (i2 == 0) {
            zzgl.zzc = "";
            return zza;
        } else {
            zzgl.zzc = zzkw.zzb(bArr, zza, i2);
            return zza + i2;
        }
    }

    static int zze(byte[] bArr, int i, zzgl zzgl) {
        int zza = zza(bArr, i, zzgl);
        int i2 = zzgl.zza;
        if (i2 < 0) {
            throw zzig.zzb();
        } else if (i2 > bArr.length - zza) {
            throw zzig.zza();
        } else if (i2 == 0) {
            zzgl.zzc = zzgm.zza;
            return zza;
        } else {
            zzgl.zzc = zzgm.zza(bArr, zza, i2);
            return zza + i2;
        }
    }
}
