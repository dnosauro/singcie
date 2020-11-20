package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

final class zzely<T> implements zzemn<T> {
    private final zzels zzipu;
    private final boolean zzipv;
    private final zzenf<?, ?> zziqe;
    private final zzejw<?> zziqf;

    private zzely(zzenf<?, ?> zzenf, zzejw<?> zzejw, zzels zzels) {
        this.zziqe = zzenf;
        this.zzipv = zzejw.zzj(zzels);
        this.zziqf = zzejw;
        this.zzipu = zzels;
    }

    static <T> zzely<T> zza(zzenf<?, ?> zzenf, zzejw<?> zzejw, zzels zzels) {
        return new zzely<>(zzenf, zzejw, zzels);
    }

    public final boolean equals(T t, T t2) {
        if (!this.zziqe.zzay(t).equals(this.zziqe.zzay(t2))) {
            return false;
        }
        if (this.zzipv) {
            return this.zziqf.zzai(t).equals(this.zziqf.zzai(t2));
        }
        return true;
    }

    public final int hashCode(T t) {
        int hashCode = this.zziqe.zzay(t).hashCode();
        return this.zzipv ? (hashCode * 53) + this.zziqf.zzai(t).hashCode() : hashCode;
    }

    public final T newInstance() {
        return this.zzipu.zzbie().zzbhu();
    }

    public final void zza(T t, zzemh zzemh, zzeju zzeju) {
        boolean z;
        zzenf<?, ?> zzenf = this.zziqe;
        zzejw<?> zzejw = this.zziqf;
        Object zzaz = zzenf.zzaz(t);
        zzejx<?> zzaj = zzejw.zzaj(t);
        do {
            try {
                if (zzemh.zzbgy() == Integer.MAX_VALUE) {
                    zzenf.zzj(t, zzaz);
                    return;
                }
                int tag = zzemh.getTag();
                if (tag == 11) {
                    int i = 0;
                    Object obj = null;
                    zzeiu zzeiu = null;
                    while (zzemh.zzbgy() != Integer.MAX_VALUE) {
                        int tag2 = zzemh.getTag();
                        if (tag2 == 16) {
                            i = zzemh.zzbgj();
                            obj = zzejw.zza(zzeju, this.zzipu, i);
                        } else if (tag2 == 26) {
                            if (obj != null) {
                                zzejw.zza(zzemh, obj, zzeju, zzaj);
                            } else {
                                zzeiu = zzemh.zzbgi();
                            }
                        } else if (!zzemh.zzbgz()) {
                            break;
                        }
                    }
                    if (zzemh.getTag() != 12) {
                        throw zzeks.zzbim();
                    } else if (zzeiu != null) {
                        if (obj != null) {
                            zzejw.zza(zzeiu, obj, zzeju, zzaj);
                        } else {
                            zzenf.zza(zzaz, i, zzeiu);
                        }
                    }
                } else if ((tag & 7) == 2) {
                    Object zza = zzejw.zza(zzeju, this.zzipu, tag >>> 3);
                    if (zza != null) {
                        zzejw.zza(zzemh, zza, zzeju, zzaj);
                    } else {
                        z = zzenf.zza(zzaz, zzemh);
                        continue;
                    }
                } else {
                    z = zzemh.zzbgz();
                    continue;
                }
                z = true;
                continue;
            } finally {
                zzenf.zzj(t, zzaz);
            }
        } while (z);
    }

    public final void zza(T t, zzeoc zzeoc) {
        int i;
        Object obj;
        Iterator<Map.Entry<?, Object>> it = this.zziqf.zzai(t).iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            zzejz zzejz = (zzejz) next.getKey();
            if (zzejz.zzbhm() != zzenz.MESSAGE || zzejz.zzbhn() || zzejz.zzbho()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (next instanceof zzekv) {
                i = zzejz.zzv();
                obj = ((zzekv) next).zzbit().zzbfg();
            } else {
                i = zzejz.zzv();
                obj = next.getValue();
            }
            zzeoc.zzc(i, obj);
        }
        zzenf<?, ?> zzenf = this.zziqe;
        zzenf.zzc(zzenf.zzay(t), zzeoc);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: com.google.android.gms.internal.ads.zzekh$zzd} */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r9, byte[] r10, int r11, int r12, com.google.android.gms.internal.ads.zzeit r13) {
        /*
            r8 = this;
            r0 = r9
            com.google.android.gms.internal.ads.zzekh r0 = (com.google.android.gms.internal.ads.zzekh) r0
            com.google.android.gms.internal.ads.zzeni r1 = r0.zzino
            com.google.android.gms.internal.ads.zzeni r2 = com.google.android.gms.internal.ads.zzeni.zzbkg()
            if (r1 != r2) goto L_0x0011
            com.google.android.gms.internal.ads.zzeni r1 = com.google.android.gms.internal.ads.zzeni.zzbkh()
            r0.zzino = r1
        L_0x0011:
            com.google.android.gms.internal.ads.zzekh$zzb r9 = (com.google.android.gms.internal.ads.zzekh.zzb) r9
            r9.zzbif()
            r9 = 0
            r0 = r9
        L_0x0018:
            if (r11 >= r12) goto L_0x00a2
            int r4 = com.google.android.gms.internal.ads.zzeiq.zza(r10, r11, r13)
            int r2 = r13.zziiu
            r11 = 11
            r3 = 2
            if (r2 == r11) goto L_0x0051
            r11 = r2 & 7
            if (r11 != r3) goto L_0x004c
            com.google.android.gms.internal.ads.zzejw<?> r11 = r8.zziqf
            com.google.android.gms.internal.ads.zzeju r0 = r13.zziix
            com.google.android.gms.internal.ads.zzels r3 = r8.zzipu
            int r5 = r2 >>> 3
            java.lang.Object r11 = r11.zza(r0, r3, r5)
            r0 = r11
            com.google.android.gms.internal.ads.zzekh$zzd r0 = (com.google.android.gms.internal.ads.zzekh.zzd) r0
            if (r0 != 0) goto L_0x0043
            r3 = r10
            r5 = r12
            r6 = r1
            r7 = r13
            int r11 = com.google.android.gms.internal.ads.zzeiq.zza((int) r2, (byte[]) r3, (int) r4, (int) r5, (com.google.android.gms.internal.ads.zzeni) r6, (com.google.android.gms.internal.ads.zzeit) r7)
            goto L_0x0018
        L_0x0043:
            com.google.android.gms.internal.ads.zzemg.zzbjn()
            java.lang.NoSuchMethodError r9 = new java.lang.NoSuchMethodError
            r9.<init>()
            throw r9
        L_0x004c:
            int r11 = com.google.android.gms.internal.ads.zzeiq.zza((int) r2, (byte[]) r10, (int) r4, (int) r12, (com.google.android.gms.internal.ads.zzeit) r13)
            goto L_0x0018
        L_0x0051:
            r11 = 0
            r2 = r9
        L_0x0053:
            if (r4 >= r12) goto L_0x0097
            int r4 = com.google.android.gms.internal.ads.zzeiq.zza(r10, r4, r13)
            int r5 = r13.zziiu
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
            int r4 = com.google.android.gms.internal.ads.zzeiq.zze(r10, r4, r13)
            java.lang.Object r2 = r13.zziiw
            com.google.android.gms.internal.ads.zzeiu r2 = (com.google.android.gms.internal.ads.zzeiu) r2
            goto L_0x0053
        L_0x0070:
            com.google.android.gms.internal.ads.zzemg.zzbjn()
            java.lang.NoSuchMethodError r9 = new java.lang.NoSuchMethodError
            r9.<init>()
            throw r9
        L_0x0079:
            if (r7 != 0) goto L_0x008e
            int r4 = com.google.android.gms.internal.ads.zzeiq.zza(r10, r4, r13)
            int r11 = r13.zziiu
            com.google.android.gms.internal.ads.zzejw<?> r0 = r8.zziqf
            com.google.android.gms.internal.ads.zzeju r5 = r13.zziix
            com.google.android.gms.internal.ads.zzels r6 = r8.zzipu
            java.lang.Object r0 = r0.zza(r5, r6, r11)
            com.google.android.gms.internal.ads.zzekh$zzd r0 = (com.google.android.gms.internal.ads.zzekh.zzd) r0
            goto L_0x0053
        L_0x008e:
            r6 = 12
            if (r5 == r6) goto L_0x0097
            int r4 = com.google.android.gms.internal.ads.zzeiq.zza((int) r5, (byte[]) r10, (int) r4, (int) r12, (com.google.android.gms.internal.ads.zzeit) r13)
            goto L_0x0053
        L_0x0097:
            if (r2 == 0) goto L_0x009f
            int r11 = r11 << 3
            r11 = r11 | r3
            r1.zzd(r11, r2)
        L_0x009f:
            r11 = r4
            goto L_0x0018
        L_0x00a2:
            if (r11 != r12) goto L_0x00a5
            return
        L_0x00a5:
            com.google.android.gms.internal.ads.zzeks r9 = com.google.android.gms.internal.ads.zzeks.zzbip()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzely.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.ads.zzeit):void");
    }

    public final void zzak(T t) {
        this.zziqe.zzak(t);
        this.zziqf.zzak(t);
    }

    public final int zzau(T t) {
        zzenf<?, ?> zzenf = this.zziqe;
        int zzba = zzenf.zzba(zzenf.zzay(t)) + 0;
        return this.zzipv ? zzba + this.zziqf.zzai(t).zzbhh() : zzba;
    }

    public final boolean zzaw(T t) {
        return this.zziqf.zzai(t).isInitialized();
    }

    public final void zzg(T t, T t2) {
        zzemp.zza(this.zziqe, t, t2);
        if (this.zzipv) {
            zzemp.zza(this.zziqf, t, t2);
        }
    }
}
