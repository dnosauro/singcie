package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

final class zzjm<T> implements zzjv<T> {
    private final zzjg zza;
    private final zzkn<?, ?> zzb;
    private final boolean zzc;
    private final zzhk<?> zzd;

    private zzjm(zzkn<?, ?> zzkn, zzhk<?> zzhk, zzjg zzjg) {
        this.zzb = zzkn;
        this.zzc = zzhk.zza(zzjg);
        this.zzd = zzhk;
        this.zza = zzjg;
    }

    static <T> zzjm<T> zza(zzkn<?, ?> zzkn, zzhk<?> zzhk, zzjg zzjg) {
        return new zzjm<>(zzkn, zzhk, zzjg);
    }

    public final int zza(T t) {
        int hashCode = this.zzb.zzb(t).hashCode();
        return this.zzc ? (hashCode * 53) + this.zzd.zza((Object) t).hashCode() : hashCode;
    }

    public final T zza() {
        return this.zza.zzbu().zzx();
    }

    public final void zza(T t, zzjw zzjw, zzhi zzhi) {
        boolean z;
        zzkn<?, ?> zzkn = this.zzb;
        zzhk<?> zzhk = this.zzd;
        Object zzc2 = zzkn.zzc(t);
        zzho<?> zzb2 = zzhk.zzb(t);
        do {
            try {
                if (zzjw.zza() == Integer.MAX_VALUE) {
                    zzkn.zzb((Object) t, zzc2);
                    return;
                }
                int zzb3 = zzjw.zzb();
                if (zzb3 == 11) {
                    int i = 0;
                    Object obj = null;
                    zzgm zzgm = null;
                    while (zzjw.zza() != Integer.MAX_VALUE) {
                        int zzb4 = zzjw.zzb();
                        if (zzb4 == 16) {
                            i = zzjw.zzo();
                            obj = zzhk.zza(zzhi, this.zza, i);
                        } else if (zzb4 == 26) {
                            if (obj != null) {
                                zzhk.zza(zzjw, obj, zzhi, zzb2);
                            } else {
                                zzgm = zzjw.zzn();
                            }
                        } else if (!zzjw.zzc()) {
                            break;
                        }
                    }
                    if (zzjw.zzb() != 12) {
                        throw zzig.zze();
                    } else if (zzgm != null) {
                        if (obj != null) {
                            zzhk.zza(zzgm, obj, zzhi, zzb2);
                        } else {
                            zzkn.zza(zzc2, i, zzgm);
                        }
                    }
                } else if ((zzb3 & 7) == 2) {
                    Object zza2 = zzhk.zza(zzhi, this.zza, zzb3 >>> 3);
                    if (zza2 != null) {
                        zzhk.zza(zzjw, zza2, zzhi, zzb2);
                    } else {
                        z = zzkn.zza(zzc2, zzjw);
                        continue;
                    }
                } else {
                    z = zzjw.zzc();
                    continue;
                }
                z = true;
                continue;
            } finally {
                zzkn.zzb((Object) t, zzc2);
            }
        } while (z);
    }

    public final void zza(T t, zzlk zzlk) {
        int i;
        Object obj;
        Iterator<Map.Entry<?, Object>> zzd2 = this.zzd.zza((Object) t).zzd();
        while (zzd2.hasNext()) {
            Map.Entry next = zzd2.next();
            zzhq zzhq = (zzhq) next.getKey();
            if (zzhq.zzc() != zzlh.MESSAGE || zzhq.zzd() || zzhq.zze()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (next instanceof zzij) {
                i = zzhq.zza();
                obj = ((zzij) next).zza().zzc();
            } else {
                i = zzhq.zza();
                obj = next.getValue();
            }
            zzlk.zza(i, obj);
        }
        zzkn<?, ?> zzkn = this.zzb;
        zzkn.zzb(zzkn.zzb(t), zzlk);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: com.google.android.gms.internal.measurement.zzhv$zzf} */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r9, byte[] r10, int r11, int r12, com.google.android.gms.internal.measurement.zzgl r13) {
        /*
            r8 = this;
            r0 = r9
            com.google.android.gms.internal.measurement.zzhv r0 = (com.google.android.gms.internal.measurement.zzhv) r0
            com.google.android.gms.internal.measurement.zzkq r1 = r0.zzb
            com.google.android.gms.internal.measurement.zzkq r2 = com.google.android.gms.internal.measurement.zzkq.zza()
            if (r1 != r2) goto L_0x0011
            com.google.android.gms.internal.measurement.zzkq r1 = com.google.android.gms.internal.measurement.zzkq.zzb()
            r0.zzb = r1
        L_0x0011:
            com.google.android.gms.internal.measurement.zzhv$zzd r9 = (com.google.android.gms.internal.measurement.zzhv.zzd) r9
            r9.zza()
            r9 = 0
            r0 = r9
        L_0x0018:
            if (r11 >= r12) goto L_0x00a2
            int r4 = com.google.android.gms.internal.measurement.zzgi.zza(r10, r11, r13)
            int r2 = r13.zza
            r11 = 11
            r3 = 2
            if (r2 == r11) goto L_0x0051
            r11 = r2 & 7
            if (r11 != r3) goto L_0x004c
            com.google.android.gms.internal.measurement.zzhk<?> r11 = r8.zzd
            com.google.android.gms.internal.measurement.zzhi r0 = r13.zzd
            com.google.android.gms.internal.measurement.zzjg r3 = r8.zza
            int r5 = r2 >>> 3
            java.lang.Object r11 = r11.zza(r0, r3, r5)
            r0 = r11
            com.google.android.gms.internal.measurement.zzhv$zzf r0 = (com.google.android.gms.internal.measurement.zzhv.zzf) r0
            if (r0 != 0) goto L_0x0043
            r3 = r10
            r5 = r12
            r6 = r1
            r7 = r13
            int r11 = com.google.android.gms.internal.measurement.zzgi.zza((int) r2, (byte[]) r3, (int) r4, (int) r5, (com.google.android.gms.internal.measurement.zzkq) r6, (com.google.android.gms.internal.measurement.zzgl) r7)
            goto L_0x0018
        L_0x0043:
            com.google.android.gms.internal.measurement.zzjr.zza()
            java.lang.NoSuchMethodError r9 = new java.lang.NoSuchMethodError
            r9.<init>()
            throw r9
        L_0x004c:
            int r11 = com.google.android.gms.internal.measurement.zzgi.zza((int) r2, (byte[]) r10, (int) r4, (int) r12, (com.google.android.gms.internal.measurement.zzgl) r13)
            goto L_0x0018
        L_0x0051:
            r11 = 0
            r2 = r9
        L_0x0053:
            if (r4 >= r12) goto L_0x0097
            int r4 = com.google.android.gms.internal.measurement.zzgi.zza(r10, r4, r13)
            int r5 = r13.zza
            int r6 = r5 >>> 3
            r7 = r5 & 7
            switch(r6) {
                case 2: goto L_0x0079;
                case 3: goto L_0x0063;
                default: goto L_0x0062;
            }
        L_0x0062:
            goto L_0x008e
        L_0x0063:
            if (r0 != 0) goto L_0x0070
            if (r7 != r3) goto L_0x008e
            int r4 = com.google.android.gms.internal.measurement.zzgi.zze(r10, r4, r13)
            java.lang.Object r2 = r13.zzc
            com.google.android.gms.internal.measurement.zzgm r2 = (com.google.android.gms.internal.measurement.zzgm) r2
            goto L_0x0053
        L_0x0070:
            com.google.android.gms.internal.measurement.zzjr.zza()
            java.lang.NoSuchMethodError r9 = new java.lang.NoSuchMethodError
            r9.<init>()
            throw r9
        L_0x0079:
            if (r7 != 0) goto L_0x008e
            int r4 = com.google.android.gms.internal.measurement.zzgi.zza(r10, r4, r13)
            int r11 = r13.zza
            com.google.android.gms.internal.measurement.zzhk<?> r0 = r8.zzd
            com.google.android.gms.internal.measurement.zzhi r5 = r13.zzd
            com.google.android.gms.internal.measurement.zzjg r6 = r8.zza
            java.lang.Object r0 = r0.zza(r5, r6, r11)
            com.google.android.gms.internal.measurement.zzhv$zzf r0 = (com.google.android.gms.internal.measurement.zzhv.zzf) r0
            goto L_0x0053
        L_0x008e:
            r6 = 12
            if (r5 == r6) goto L_0x0097
            int r4 = com.google.android.gms.internal.measurement.zzgi.zza((int) r5, (byte[]) r10, (int) r4, (int) r12, (com.google.android.gms.internal.measurement.zzgl) r13)
            goto L_0x0053
        L_0x0097:
            if (r2 == 0) goto L_0x009f
            int r11 = r11 << 3
            r11 = r11 | r3
            r1.zza((int) r11, (java.lang.Object) r2)
        L_0x009f:
            r11 = r4
            goto L_0x0018
        L_0x00a2:
            if (r11 != r12) goto L_0x00a5
            return
        L_0x00a5:
            com.google.android.gms.internal.measurement.zzig r9 = com.google.android.gms.internal.measurement.zzig.zzg()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjm.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.measurement.zzgl):void");
    }

    public final boolean zza(T t, T t2) {
        if (!this.zzb.zzb(t).equals(this.zzb.zzb(t2))) {
            return false;
        }
        if (this.zzc) {
            return this.zzd.zza((Object) t).equals(this.zzd.zza((Object) t2));
        }
        return true;
    }

    public final int zzb(T t) {
        zzkn<?, ?> zzkn = this.zzb;
        int zze = zzkn.zze(zzkn.zzb(t)) + 0;
        return this.zzc ? zze + this.zzd.zza((Object) t).zzg() : zze;
    }

    public final void zzb(T t, T t2) {
        zzjx.zza(this.zzb, t, t2);
        if (this.zzc) {
            zzjx.zza(this.zzd, t, t2);
        }
    }

    public final void zzc(T t) {
        this.zzb.zzd(t);
        this.zzd.zzc(t);
    }

    public final boolean zzd(T t) {
        return this.zzd.zza((Object) t).zzf();
    }
}
