package com.google.android.gms.internal.measurement;

import java.util.List;

final class zzhd implements zzjw {
    private final zzgy zza;
    private int zzb;
    private int zzc;
    private int zzd = 0;

    private zzhd(zzgy zzgy) {
        this.zza = (zzgy) zzhx.zza(zzgy, "input");
        this.zza.zzc = this;
    }

    public static zzhd zza(zzgy zzgy) {
        return zzgy.zzc != null ? zzgy.zzc : new zzhd(zzgy);
    }

    private final Object zza(zzle zzle, Class<?> cls, zzhi zzhi) {
        switch (zzhc.zza[zzle.ordinal()]) {
            case 1:
                return Boolean.valueOf(zzk());
            case 2:
                return zzn();
            case 3:
                return Double.valueOf(zzd());
            case 4:
                return Integer.valueOf(zzp());
            case 5:
                return Integer.valueOf(zzj());
            case 6:
                return Long.valueOf(zzi());
            case 7:
                return Float.valueOf(zze());
            case 8:
                return Integer.valueOf(zzh());
            case 9:
                return Long.valueOf(zzg());
            case 10:
                zza(2);
                return zzc(zzjr.zza().zza(cls), zzhi);
            case 11:
                return Integer.valueOf(zzq());
            case 12:
                return Long.valueOf(zzr());
            case 13:
                return Integer.valueOf(zzs());
            case 14:
                return Long.valueOf(zzt());
            case 15:
                return zzm();
            case 16:
                return Integer.valueOf(zzo());
            case 17:
                return Long.valueOf(zzf());
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private final void zza(int i) {
        if ((this.zzb & 7) != i) {
            throw zzig.zzf();
        }
    }

    private final void zza(List<String> list, boolean z) {
        int zza2;
        int zza3;
        if ((this.zzb & 7) != 2) {
            throw zzig.zzf();
        } else if (!(list instanceof zzin) || z) {
            do {
                list.add(z ? zzm() : zzl());
                if (!this.zza.zzt()) {
                    zza2 = this.zza.zza();
                } else {
                    return;
                }
            } while (zza2 == this.zzb);
            this.zzd = zza2;
        } else {
            zzin zzin = (zzin) list;
            do {
                zzin.zza(zzn());
                if (!this.zza.zzt()) {
                    zza3 = this.zza.zza();
                } else {
                    return;
                }
            } while (zza3 == this.zzb);
            this.zzd = zza3;
        }
    }

    private static void zzb(int i) {
        if ((i & 7) != 0) {
            throw zzig.zzg();
        }
    }

    private final <T> T zzc(zzjv<T> zzjv, zzhi zzhi) {
        int zzm = this.zza.zzm();
        if (this.zza.zza < this.zza.zzb) {
            int zzc2 = this.zza.zzc(zzm);
            T zza2 = zzjv.zza();
            this.zza.zza++;
            zzjv.zza(zza2, this, zzhi);
            zzjv.zzc(zza2);
            this.zza.zza(0);
            zzgy zzgy = this.zza;
            zzgy.zza--;
            this.zza.zzd(zzc2);
            return zza2;
        }
        throw new zzig("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    private static void zzc(int i) {
        if ((i & 3) != 0) {
            throw zzig.zzg();
        }
    }

    private final <T> T zzd(zzjv<T> zzjv, zzhi zzhi) {
        int i = this.zzc;
        this.zzc = ((this.zzb >>> 3) << 3) | 4;
        try {
            T zza2 = zzjv.zza();
            zzjv.zza(zza2, this, zzhi);
            zzjv.zzc(zza2);
            if (this.zzb == this.zzc) {
                return zza2;
            }
            throw zzig.zzg();
        } finally {
            this.zzc = i;
        }
    }

    private final void zzd(int i) {
        if (this.zza.zzu() != i) {
            throw zzig.zza();
        }
    }

    public final int zza() {
        int i = this.zzd;
        if (i != 0) {
            this.zzb = i;
            this.zzd = 0;
        } else {
            this.zzb = this.zza.zza();
        }
        int i2 = this.zzb;
        if (i2 == 0 || i2 == this.zzc) {
            return Integer.MAX_VALUE;
        }
        return i2 >>> 3;
    }

    public final <T> T zza(zzjv<T> zzjv, zzhi zzhi) {
        zza(2);
        return zzc(zzjv, zzhi);
    }

    public final void zza(List<Double> list) {
        int zza2;
        int zza3;
        if (list instanceof zzhg) {
            zzhg zzhg = (zzhg) list;
            switch (this.zzb & 7) {
                case 1:
                    break;
                case 2:
                    int zzm = this.zza.zzm();
                    zzb(zzm);
                    int zzu = this.zza.zzu() + zzm;
                    do {
                        zzhg.zza(this.zza.zzb());
                    } while (this.zza.zzu() < zzu);
                    return;
                default:
                    throw zzig.zzf();
            }
            do {
                zzhg.zza(this.zza.zzb());
                if (!this.zza.zzt()) {
                    zza3 = this.zza.zza();
                } else {
                    return;
                }
            } while (zza3 == this.zzb);
            this.zzd = zza3;
            return;
        }
        switch (this.zzb & 7) {
            case 1:
                break;
            case 2:
                int zzm2 = this.zza.zzm();
                zzb(zzm2);
                int zzu2 = this.zza.zzu() + zzm2;
                do {
                    list.add(Double.valueOf(this.zza.zzb()));
                } while (this.zza.zzu() < zzu2);
                return;
            default:
                throw zzig.zzf();
        }
        do {
            list.add(Double.valueOf(this.zza.zzb()));
            if (!this.zza.zzt()) {
                zza2 = this.zza.zza();
            } else {
                return;
            }
        } while (zza2 == this.zzb);
        this.zzd = zza2;
    }

    public final <T> void zza(List<T> list, zzjv<T> zzjv, zzhi zzhi) {
        int zza2;
        int i = this.zzb;
        if ((i & 7) == 2) {
            do {
                list.add(zzc(zzjv, zzhi));
                if (!this.zza.zzt() && this.zzd == 0) {
                    zza2 = this.zza.zza();
                } else {
                    return;
                }
            } while (zza2 == i);
            this.zzd = zza2;
            return;
        }
        throw zzig.zzf();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0051, code lost:
        if (zzc() != false) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005b, code lost:
        throw new com.google.android.gms.internal.measurement.zzig("Unable to parse map entry.");
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x004d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <K, V> void zza(java.util.Map<K, V> r6, com.google.android.gms.internal.measurement.zzix<K, V> r7, com.google.android.gms.internal.measurement.zzhi r8) {
        /*
            r5 = this;
            r0 = 2
            r5.zza((int) r0)
            com.google.android.gms.internal.measurement.zzgy r0 = r5.zza
            int r0 = r0.zzm()
            com.google.android.gms.internal.measurement.zzgy r1 = r5.zza
            int r0 = r1.zzc(r0)
            K r1 = r7.zzb
            V r2 = r7.zzd
        L_0x0014:
            int r3 = r5.zza()     // Catch:{ all -> 0x0065 }
            r4 = 2147483647(0x7fffffff, float:NaN)
            if (r3 == r4) goto L_0x005c
            com.google.android.gms.internal.measurement.zzgy r4 = r5.zza     // Catch:{ all -> 0x0065 }
            boolean r4 = r4.zzt()     // Catch:{ all -> 0x0065 }
            if (r4 != 0) goto L_0x005c
            switch(r3) {
                case 1: goto L_0x003a;
                case 2: goto L_0x002d;
                default: goto L_0x0028;
            }
        L_0x0028:
            boolean r3 = r5.zzc()     // Catch:{ zzif -> 0x004d }
            goto L_0x0042
        L_0x002d:
            com.google.android.gms.internal.measurement.zzle r3 = r7.zzc     // Catch:{ zzif -> 0x004d }
            V r4 = r7.zzd     // Catch:{ zzif -> 0x004d }
            java.lang.Class r4 = r4.getClass()     // Catch:{ zzif -> 0x004d }
            java.lang.Object r2 = r5.zza((com.google.android.gms.internal.measurement.zzle) r3, (java.lang.Class<?>) r4, (com.google.android.gms.internal.measurement.zzhi) r8)     // Catch:{ zzif -> 0x004d }
            goto L_0x0014
        L_0x003a:
            com.google.android.gms.internal.measurement.zzle r3 = r7.zza     // Catch:{ zzif -> 0x004d }
            r4 = 0
            java.lang.Object r1 = r5.zza((com.google.android.gms.internal.measurement.zzle) r3, (java.lang.Class<?>) r4, (com.google.android.gms.internal.measurement.zzhi) r4)     // Catch:{ zzif -> 0x004d }
            goto L_0x0014
        L_0x0042:
            if (r3 == 0) goto L_0x0045
            goto L_0x0014
        L_0x0045:
            com.google.android.gms.internal.measurement.zzig r3 = new com.google.android.gms.internal.measurement.zzig     // Catch:{ zzif -> 0x004d }
            java.lang.String r4 = "Unable to parse map entry."
            r3.<init>(r4)     // Catch:{ zzif -> 0x004d }
            throw r3     // Catch:{ zzif -> 0x004d }
        L_0x004d:
            boolean r3 = r5.zzc()     // Catch:{ all -> 0x0065 }
            if (r3 == 0) goto L_0x0054
            goto L_0x0014
        L_0x0054:
            com.google.android.gms.internal.measurement.zzig r6 = new com.google.android.gms.internal.measurement.zzig     // Catch:{ all -> 0x0065 }
            java.lang.String r7 = "Unable to parse map entry."
            r6.<init>(r7)     // Catch:{ all -> 0x0065 }
            throw r6     // Catch:{ all -> 0x0065 }
        L_0x005c:
            r6.put(r1, r2)     // Catch:{ all -> 0x0065 }
            com.google.android.gms.internal.measurement.zzgy r6 = r5.zza
            r6.zzd(r0)
            return
        L_0x0065:
            r6 = move-exception
            com.google.android.gms.internal.measurement.zzgy r7 = r5.zza
            r7.zzd(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzhd.zza(java.util.Map, com.google.android.gms.internal.measurement.zzix, com.google.android.gms.internal.measurement.zzhi):void");
    }

    public final int zzb() {
        return this.zzb;
    }

    public final <T> T zzb(zzjv<T> zzjv, zzhi zzhi) {
        zza(3);
        return zzd(zzjv, zzhi);
    }

    public final void zzb(List<Float> list) {
        int zza2;
        int zza3;
        if (list instanceof zzhu) {
            zzhu zzhu = (zzhu) list;
            int i = this.zzb & 7;
            if (i == 2) {
                int zzm = this.zza.zzm();
                zzc(zzm);
                int zzu = this.zza.zzu() + zzm;
                do {
                    zzhu.zza(this.zza.zzc());
                } while (this.zza.zzu() < zzu);
            } else if (i == 5) {
                do {
                    zzhu.zza(this.zza.zzc());
                    if (!this.zza.zzt()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else {
                throw zzig.zzf();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int zzm2 = this.zza.zzm();
                zzc(zzm2);
                int zzu2 = this.zza.zzu() + zzm2;
                do {
                    list.add(Float.valueOf(this.zza.zzc()));
                } while (this.zza.zzu() < zzu2);
            } else if (i2 == 5) {
                do {
                    list.add(Float.valueOf(this.zza.zzc()));
                    if (!this.zza.zzt()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else {
                throw zzig.zzf();
            }
        }
    }

    public final <T> void zzb(List<T> list, zzjv<T> zzjv, zzhi zzhi) {
        int zza2;
        int i = this.zzb;
        if ((i & 7) == 3) {
            do {
                list.add(zzd(zzjv, zzhi));
                if (!this.zza.zzt() && this.zzd == 0) {
                    zza2 = this.zza.zza();
                } else {
                    return;
                }
            } while (zza2 == i);
            this.zzd = zza2;
            return;
        }
        throw zzig.zzf();
    }

    public final void zzc(List<Long> list) {
        int zza2;
        int zza3;
        if (list instanceof zziu) {
            zziu zziu = (zziu) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zziu.zza(this.zza.zzd());
                    if (!this.zza.zzt()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzu = this.zza.zzu() + this.zza.zzm();
                do {
                    zziu.zza(this.zza.zzd());
                } while (this.zza.zzu() < zzu);
                zzd(zzu);
            } else {
                throw zzig.zzf();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zza.zzd()));
                    if (!this.zza.zzt()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzu2 = this.zza.zzu() + this.zza.zzm();
                do {
                    list.add(Long.valueOf(this.zza.zzd()));
                } while (this.zza.zzu() < zzu2);
                zzd(zzu2);
            } else {
                throw zzig.zzf();
            }
        }
    }

    public final boolean zzc() {
        int i;
        if (this.zza.zzt() || (i = this.zzb) == this.zzc) {
            return false;
        }
        return this.zza.zzb(i);
    }

    public final double zzd() {
        zza(1);
        return this.zza.zzb();
    }

    public final void zzd(List<Long> list) {
        int zza2;
        int zza3;
        if (list instanceof zziu) {
            zziu zziu = (zziu) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zziu.zza(this.zza.zze());
                    if (!this.zza.zzt()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzu = this.zza.zzu() + this.zza.zzm();
                do {
                    zziu.zza(this.zza.zze());
                } while (this.zza.zzu() < zzu);
                zzd(zzu);
            } else {
                throw zzig.zzf();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zza.zze()));
                    if (!this.zza.zzt()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzu2 = this.zza.zzu() + this.zza.zzm();
                do {
                    list.add(Long.valueOf(this.zza.zze()));
                } while (this.zza.zzu() < zzu2);
                zzd(zzu2);
            } else {
                throw zzig.zzf();
            }
        }
    }

    public final float zze() {
        zza(5);
        return this.zza.zzc();
    }

    public final void zze(List<Integer> list) {
        int zza2;
        int zza3;
        if (list instanceof zzhy) {
            zzhy zzhy = (zzhy) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzhy.zzd(this.zza.zzf());
                    if (!this.zza.zzt()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzu = this.zza.zzu() + this.zza.zzm();
                do {
                    zzhy.zzd(this.zza.zzf());
                } while (this.zza.zzu() < zzu);
                zzd(zzu);
            } else {
                throw zzig.zzf();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzf()));
                    if (!this.zza.zzt()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzu2 = this.zza.zzu() + this.zza.zzm();
                do {
                    list.add(Integer.valueOf(this.zza.zzf()));
                } while (this.zza.zzu() < zzu2);
                zzd(zzu2);
            } else {
                throw zzig.zzf();
            }
        }
    }

    public final long zzf() {
        zza(0);
        return this.zza.zzd();
    }

    public final void zzf(List<Long> list) {
        int zza2;
        int zza3;
        if (list instanceof zziu) {
            zziu zziu = (zziu) list;
            switch (this.zzb & 7) {
                case 1:
                    break;
                case 2:
                    int zzm = this.zza.zzm();
                    zzb(zzm);
                    int zzu = this.zza.zzu() + zzm;
                    do {
                        zziu.zza(this.zza.zzg());
                    } while (this.zza.zzu() < zzu);
                    return;
                default:
                    throw zzig.zzf();
            }
            do {
                zziu.zza(this.zza.zzg());
                if (!this.zza.zzt()) {
                    zza3 = this.zza.zza();
                } else {
                    return;
                }
            } while (zza3 == this.zzb);
            this.zzd = zza3;
            return;
        }
        switch (this.zzb & 7) {
            case 1:
                break;
            case 2:
                int zzm2 = this.zza.zzm();
                zzb(zzm2);
                int zzu2 = this.zza.zzu() + zzm2;
                do {
                    list.add(Long.valueOf(this.zza.zzg()));
                } while (this.zza.zzu() < zzu2);
                return;
            default:
                throw zzig.zzf();
        }
        do {
            list.add(Long.valueOf(this.zza.zzg()));
            if (!this.zza.zzt()) {
                zza2 = this.zza.zza();
            } else {
                return;
            }
        } while (zza2 == this.zzb);
        this.zzd = zza2;
    }

    public final long zzg() {
        zza(0);
        return this.zza.zze();
    }

    public final void zzg(List<Integer> list) {
        int zza2;
        int zza3;
        if (list instanceof zzhy) {
            zzhy zzhy = (zzhy) list;
            int i = this.zzb & 7;
            if (i == 2) {
                int zzm = this.zza.zzm();
                zzc(zzm);
                int zzu = this.zza.zzu() + zzm;
                do {
                    zzhy.zzd(this.zza.zzh());
                } while (this.zza.zzu() < zzu);
            } else if (i == 5) {
                do {
                    zzhy.zzd(this.zza.zzh());
                    if (!this.zza.zzt()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else {
                throw zzig.zzf();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int zzm2 = this.zza.zzm();
                zzc(zzm2);
                int zzu2 = this.zza.zzu() + zzm2;
                do {
                    list.add(Integer.valueOf(this.zza.zzh()));
                } while (this.zza.zzu() < zzu2);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.zza.zzh()));
                    if (!this.zza.zzt()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else {
                throw zzig.zzf();
            }
        }
    }

    public final int zzh() {
        zza(0);
        return this.zza.zzf();
    }

    public final void zzh(List<Boolean> list) {
        int zza2;
        int zza3;
        if (list instanceof zzgk) {
            zzgk zzgk = (zzgk) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzgk.zza(this.zza.zzi());
                    if (!this.zza.zzt()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzu = this.zza.zzu() + this.zza.zzm();
                do {
                    zzgk.zza(this.zza.zzi());
                } while (this.zza.zzu() < zzu);
                zzd(zzu);
            } else {
                throw zzig.zzf();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Boolean.valueOf(this.zza.zzi()));
                    if (!this.zza.zzt()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzu2 = this.zza.zzu() + this.zza.zzm();
                do {
                    list.add(Boolean.valueOf(this.zza.zzi()));
                } while (this.zza.zzu() < zzu2);
                zzd(zzu2);
            } else {
                throw zzig.zzf();
            }
        }
    }

    public final long zzi() {
        zza(1);
        return this.zza.zzg();
    }

    public final void zzi(List<String> list) {
        zza(list, false);
    }

    public final int zzj() {
        zza(5);
        return this.zza.zzh();
    }

    public final void zzj(List<String> list) {
        zza(list, true);
    }

    public final void zzk(List<zzgm> list) {
        int zza2;
        if ((this.zzb & 7) == 2) {
            do {
                list.add(zzn());
                if (!this.zza.zzt()) {
                    zza2 = this.zza.zza();
                } else {
                    return;
                }
            } while (zza2 == this.zzb);
            this.zzd = zza2;
            return;
        }
        throw zzig.zzf();
    }

    public final boolean zzk() {
        zza(0);
        return this.zza.zzi();
    }

    public final String zzl() {
        zza(2);
        return this.zza.zzj();
    }

    public final void zzl(List<Integer> list) {
        int zza2;
        int zza3;
        if (list instanceof zzhy) {
            zzhy zzhy = (zzhy) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzhy.zzd(this.zza.zzm());
                    if (!this.zza.zzt()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzu = this.zza.zzu() + this.zza.zzm();
                do {
                    zzhy.zzd(this.zza.zzm());
                } while (this.zza.zzu() < zzu);
                zzd(zzu);
            } else {
                throw zzig.zzf();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzm()));
                    if (!this.zza.zzt()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzu2 = this.zza.zzu() + this.zza.zzm();
                do {
                    list.add(Integer.valueOf(this.zza.zzm()));
                } while (this.zza.zzu() < zzu2);
                zzd(zzu2);
            } else {
                throw zzig.zzf();
            }
        }
    }

    public final String zzm() {
        zza(2);
        return this.zza.zzk();
    }

    public final void zzm(List<Integer> list) {
        int zza2;
        int zza3;
        if (list instanceof zzhy) {
            zzhy zzhy = (zzhy) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzhy.zzd(this.zza.zzn());
                    if (!this.zza.zzt()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzu = this.zza.zzu() + this.zza.zzm();
                do {
                    zzhy.zzd(this.zza.zzn());
                } while (this.zza.zzu() < zzu);
                zzd(zzu);
            } else {
                throw zzig.zzf();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzn()));
                    if (!this.zza.zzt()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzu2 = this.zza.zzu() + this.zza.zzm();
                do {
                    list.add(Integer.valueOf(this.zza.zzn()));
                } while (this.zza.zzu() < zzu2);
                zzd(zzu2);
            } else {
                throw zzig.zzf();
            }
        }
    }

    public final zzgm zzn() {
        zza(2);
        return this.zza.zzl();
    }

    public final void zzn(List<Integer> list) {
        int zza2;
        int zza3;
        if (list instanceof zzhy) {
            zzhy zzhy = (zzhy) list;
            int i = this.zzb & 7;
            if (i == 2) {
                int zzm = this.zza.zzm();
                zzc(zzm);
                int zzu = this.zza.zzu() + zzm;
                do {
                    zzhy.zzd(this.zza.zzo());
                } while (this.zza.zzu() < zzu);
            } else if (i == 5) {
                do {
                    zzhy.zzd(this.zza.zzo());
                    if (!this.zza.zzt()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else {
                throw zzig.zzf();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int zzm2 = this.zza.zzm();
                zzc(zzm2);
                int zzu2 = this.zza.zzu() + zzm2;
                do {
                    list.add(Integer.valueOf(this.zza.zzo()));
                } while (this.zza.zzu() < zzu2);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.zza.zzo()));
                    if (!this.zza.zzt()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else {
                throw zzig.zzf();
            }
        }
    }

    public final int zzo() {
        zza(0);
        return this.zza.zzm();
    }

    public final void zzo(List<Long> list) {
        int zza2;
        int zza3;
        if (list instanceof zziu) {
            zziu zziu = (zziu) list;
            switch (this.zzb & 7) {
                case 1:
                    break;
                case 2:
                    int zzm = this.zza.zzm();
                    zzb(zzm);
                    int zzu = this.zza.zzu() + zzm;
                    do {
                        zziu.zza(this.zza.zzp());
                    } while (this.zza.zzu() < zzu);
                    return;
                default:
                    throw zzig.zzf();
            }
            do {
                zziu.zza(this.zza.zzp());
                if (!this.zza.zzt()) {
                    zza3 = this.zza.zza();
                } else {
                    return;
                }
            } while (zza3 == this.zzb);
            this.zzd = zza3;
            return;
        }
        switch (this.zzb & 7) {
            case 1:
                break;
            case 2:
                int zzm2 = this.zza.zzm();
                zzb(zzm2);
                int zzu2 = this.zza.zzu() + zzm2;
                do {
                    list.add(Long.valueOf(this.zza.zzp()));
                } while (this.zza.zzu() < zzu2);
                return;
            default:
                throw zzig.zzf();
        }
        do {
            list.add(Long.valueOf(this.zza.zzp()));
            if (!this.zza.zzt()) {
                zza2 = this.zza.zza();
            } else {
                return;
            }
        } while (zza2 == this.zzb);
        this.zzd = zza2;
    }

    public final int zzp() {
        zza(0);
        return this.zza.zzn();
    }

    public final void zzp(List<Integer> list) {
        int zza2;
        int zza3;
        if (list instanceof zzhy) {
            zzhy zzhy = (zzhy) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzhy.zzd(this.zza.zzq());
                    if (!this.zza.zzt()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzu = this.zza.zzu() + this.zza.zzm();
                do {
                    zzhy.zzd(this.zza.zzq());
                } while (this.zza.zzu() < zzu);
                zzd(zzu);
            } else {
                throw zzig.zzf();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzq()));
                    if (!this.zza.zzt()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzu2 = this.zza.zzu() + this.zza.zzm();
                do {
                    list.add(Integer.valueOf(this.zza.zzq()));
                } while (this.zza.zzu() < zzu2);
                zzd(zzu2);
            } else {
                throw zzig.zzf();
            }
        }
    }

    public final int zzq() {
        zza(5);
        return this.zza.zzo();
    }

    public final void zzq(List<Long> list) {
        int zza2;
        int zza3;
        if (list instanceof zziu) {
            zziu zziu = (zziu) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zziu.zza(this.zza.zzr());
                    if (!this.zza.zzt()) {
                        zza3 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza3 == this.zzb);
                this.zzd = zza3;
            } else if (i == 2) {
                int zzu = this.zza.zzu() + this.zza.zzm();
                do {
                    zziu.zza(this.zza.zzr());
                } while (this.zza.zzu() < zzu);
                zzd(zzu);
            } else {
                throw zzig.zzf();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zza.zzr()));
                    if (!this.zza.zzt()) {
                        zza2 = this.zza.zza();
                    } else {
                        return;
                    }
                } while (zza2 == this.zzb);
                this.zzd = zza2;
            } else if (i2 == 2) {
                int zzu2 = this.zza.zzu() + this.zza.zzm();
                do {
                    list.add(Long.valueOf(this.zza.zzr()));
                } while (this.zza.zzu() < zzu2);
                zzd(zzu2);
            } else {
                throw zzig.zzf();
            }
        }
    }

    public final long zzr() {
        zza(1);
        return this.zza.zzp();
    }

    public final int zzs() {
        zza(0);
        return this.zza.zzq();
    }

    public final long zzt() {
        zza(0);
        return this.zza.zzr();
    }
}
