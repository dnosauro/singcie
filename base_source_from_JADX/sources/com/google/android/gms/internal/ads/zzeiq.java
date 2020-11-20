package com.google.android.gms.internal.ads;

import org.spongycastle.asn1.eac.CertificateBody;

final class zzeiq {
    static int zza(int i, byte[] bArr, int i2, int i3, zzeit zzeit) {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 5) {
                return i2 + 4;
            }
            switch (i4) {
                case 0:
                    return zzb(bArr, i2, zzeit);
                case 1:
                    return i2 + 8;
                case 2:
                    return zza(bArr, i2, zzeit) + zzeit.zziiu;
                case 3:
                    int i5 = (i & -8) | 4;
                    int i6 = 0;
                    while (i2 < i3) {
                        i2 = zza(bArr, i2, zzeit);
                        i6 = zzeit.zziiu;
                        if (i6 != i5) {
                            i2 = zza(i6, bArr, i2, i3, zzeit);
                        } else if (i2 > i3 && i6 == i5) {
                            return i2;
                        } else {
                            throw zzeks.zzbip();
                        }
                    }
                    if (i2 > i3) {
                    }
                    throw zzeks.zzbip();
                default:
                    throw zzeks.zzbil();
            }
        } else {
            throw zzeks.zzbil();
        }
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzekp<?> zzekp, zzeit zzeit) {
        zzeki zzeki = (zzeki) zzekp;
        int zza = zza(bArr, i2, zzeit);
        while (true) {
            zzeki.zzhg(zzeit.zziiu);
            if (zza >= i3) {
                break;
            }
            int zza2 = zza(bArr, zza, zzeit);
            if (i != zzeit.zziiu) {
                break;
            }
            zza = zza(bArr, zza2, zzeit);
        }
        return zza;
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzeni zzeni, zzeit zzeit) {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 != 5) {
                switch (i4) {
                    case 0:
                        int zzb = zzb(bArr, i2, zzeit);
                        zzeni.zzd(i, Long.valueOf(zzeit.zziiv));
                        return zzb;
                    case 1:
                        zzeni.zzd(i, Long.valueOf(zzi(bArr, i2)));
                        return i2 + 8;
                    case 2:
                        int zza = zza(bArr, i2, zzeit);
                        int i5 = zzeit.zziiu;
                        if (i5 < 0) {
                            throw zzeks.zzbij();
                        } else if (i5 <= bArr.length - zza) {
                            zzeni.zzd(i, i5 == 0 ? zzeiu.zziiy : zzeiu.zzh(bArr, zza, i5));
                            return zza + i5;
                        } else {
                            throw zzeks.zzbii();
                        }
                    case 3:
                        zzeni zzbkh = zzeni.zzbkh();
                        int i6 = (i & -8) | 4;
                        int i7 = 0;
                        while (true) {
                            if (i2 < i3) {
                                int zza2 = zza(bArr, i2, zzeit);
                                int i8 = zzeit.zziiu;
                                if (i8 != i6) {
                                    i7 = i8;
                                    i2 = zza(i8, bArr, zza2, i3, zzbkh, zzeit);
                                } else {
                                    i7 = i8;
                                    i2 = zza2;
                                }
                            }
                        }
                        if (i2 > i3 || i7 != i6) {
                            throw zzeks.zzbip();
                        }
                        zzeni.zzd(i, zzbkh);
                        return i2;
                    default:
                        throw zzeks.zzbil();
                }
            } else {
                zzeni.zzd(i, Integer.valueOf(zzh(bArr, i2)));
                return i2 + 4;
            }
        } else {
            throw zzeks.zzbil();
        }
    }

    static int zza(int i, byte[] bArr, int i2, zzeit zzeit) {
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
                                zzeit.zziiu = i9;
                                return i10;
                            }
                            i8 = i10;
                        }
                    }
                }
            }
            zzeit.zziiu = i7 | i3;
            return i8;
        }
        zzeit.zziiu = i5 | i4;
        return i6;
    }

    static int zza(zzemn<?> zzemn, int i, byte[] bArr, int i2, int i3, zzekp<?> zzekp, zzeit zzeit) {
        int zza = zza((zzemn) zzemn, bArr, i2, i3, zzeit);
        while (true) {
            zzekp.add(zzeit.zziiw);
            if (zza >= i3) {
                break;
            }
            int zza2 = zza(bArr, zza, zzeit);
            if (i != zzeit.zziiu) {
                break;
            }
            zza = zza((zzemn) zzemn, bArr, zza2, i3, zzeit);
        }
        return zza;
    }

    static int zza(zzemn zzemn, byte[] bArr, int i, int i2, int i3, zzeit zzeit) {
        zzelw zzelw = (zzelw) zzemn;
        Object newInstance = zzelw.newInstance();
        int zza = zzelw.zza(newInstance, bArr, i, i2, i3, zzeit);
        zzelw.zzak(newInstance);
        zzeit.zziiw = newInstance;
        return zza;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int zza(com.google.android.gms.internal.ads.zzemn r6, byte[] r7, int r8, int r9, com.google.android.gms.internal.ads.zzeit r10) {
        /*
            int r0 = r8 + 1
            byte r8 = r7[r8]
            if (r8 >= 0) goto L_0x000c
            int r0 = zza((int) r8, (byte[]) r7, (int) r0, (com.google.android.gms.internal.ads.zzeit) r10)
            int r8 = r10.zziiu
        L_0x000c:
            r3 = r0
            if (r8 < 0) goto L_0x0025
            int r9 = r9 - r3
            if (r8 > r9) goto L_0x0025
            java.lang.Object r9 = r6.newInstance()
            int r8 = r8 + r3
            r0 = r6
            r1 = r9
            r2 = r7
            r4 = r8
            r5 = r10
            r0.zza(r1, r2, r3, r4, r5)
            r6.zzak(r9)
            r10.zziiw = r9
            return r8
        L_0x0025:
            com.google.android.gms.internal.ads.zzeks r6 = com.google.android.gms.internal.ads.zzeks.zzbii()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeiq.zza(com.google.android.gms.internal.ads.zzemn, byte[], int, int, com.google.android.gms.internal.ads.zzeit):int");
    }

    static int zza(byte[] bArr, int i, zzeit zzeit) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zza((int) b, bArr, i2, zzeit);
        }
        zzeit.zziiu = b;
        return i2;
    }

    static int zza(byte[] bArr, int i, zzekp<?> zzekp, zzeit zzeit) {
        zzeki zzeki = (zzeki) zzekp;
        int zza = zza(bArr, i, zzeit);
        int i2 = zzeit.zziiu + zza;
        while (zza < i2) {
            zza = zza(bArr, zza, zzeit);
            zzeki.zzhg(zzeit.zziiu);
        }
        if (zza == i2) {
            return zza;
        }
        throw zzeks.zzbii();
    }

    static int zzb(byte[] bArr, int i, zzeit zzeit) {
        int i2 = i + 1;
        long j = (long) bArr[i];
        if (j >= 0) {
            zzeit.zziiv = j;
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
        zzeit.zziiv = j2;
        return i3;
    }

    static int zzc(byte[] bArr, int i, zzeit zzeit) {
        int zza = zza(bArr, i, zzeit);
        int i2 = zzeit.zziiu;
        if (i2 < 0) {
            throw zzeks.zzbij();
        } else if (i2 == 0) {
            zzeit.zziiw = "";
            return zza;
        } else {
            zzeit.zziiw = new String(bArr, zza, i2, zzekk.UTF_8);
            return zza + i2;
        }
    }

    static int zzd(byte[] bArr, int i, zzeit zzeit) {
        int zza = zza(bArr, i, zzeit);
        int i2 = zzeit.zziiu;
        if (i2 < 0) {
            throw zzeks.zzbij();
        } else if (i2 == 0) {
            zzeit.zziiw = "";
            return zza;
        } else {
            zzeit.zziiw = zzeno.zzo(bArr, zza, i2);
            return zza + i2;
        }
    }

    static int zze(byte[] bArr, int i, zzeit zzeit) {
        int zza = zza(bArr, i, zzeit);
        int i2 = zzeit.zziiu;
        if (i2 < 0) {
            throw zzeks.zzbij();
        } else if (i2 > bArr.length - zza) {
            throw zzeks.zzbii();
        } else if (i2 == 0) {
            zzeit.zziiw = zzeiu.zziiy;
            return zza;
        } else {
            zzeit.zziiw = zzeiu.zzh(bArr, zza, i2);
            return zza + i2;
        }
    }

    static int zzh(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << Tnaf.POW_2_WIDTH);
    }

    static long zzi(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    static double zzj(byte[] bArr, int i) {
        return Double.longBitsToDouble(zzi(bArr, i));
    }

    static float zzk(byte[] bArr, int i) {
        return Float.intBitsToFloat(zzh(bArr, i));
    }
}
