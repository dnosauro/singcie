package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Stack;

public final class zzlk implements zzjw, zzkf {
    private static final zzkb zzaph = new zzln();
    private static final int zzays = zzpt.zzbh("qt  ");
    private long zzaif;
    private final zzpn zzapo = new zzpn(zzpi.zzbjq);
    private final zzpn zzapp = new zzpn(4);
    private int zzard;
    private int zzare;
    private zzjy zzarh;
    private final zzpn zzaxr = new zzpn(16);
    private final Stack<zzkv> zzaxt = new Stack<>();
    private int zzaxv;
    private int zzaxw;
    private long zzaxx;
    private int zzaxy;
    private zzpn zzaxz;
    private zzlm[] zzayt;
    private boolean zzayu;

    private final void zzeb(long j) {
        zzmd zzmd;
        zzka zzka;
        zzlo zza;
        while (!this.zzaxt.isEmpty() && this.zzaxt.peek().zzawh == j) {
            zzkv pop = this.zzaxt.pop();
            if (pop.type == zzks.zzatr) {
                ArrayList arrayList = new ArrayList();
                zzmd zzmd2 = null;
                zzka zzka2 = new zzka();
                zzku zzas = pop.zzas(zzks.zzavq);
                if (!(zzas == null || (zzmd2 = zzkx.zza(zzas, this.zzayu)) == null)) {
                    zzka2.zzb(zzmd2);
                }
                long j2 = Long.MAX_VALUE;
                long j3 = -9223372036854775807L;
                int i = 0;
                while (i < pop.zzawj.size()) {
                    zzkv zzkv = pop.zzawj.get(i);
                    if (zzkv.type == zzks.zzatt && (zza = zzkx.zza(zzkv, pop.zzas(zzks.zzats), -9223372036854775807L, (zzjo) null, this.zzayu)) != null) {
                        zzlt zza2 = zzkx.zza(zza, zzkv.zzat(zzks.zzatu).zzat(zzks.zzatv).zzat(zzks.zzatw), zzka2);
                        if (zza2.zzaxa != 0) {
                            zzlm zzlm = new zzlm(zza, zza2, this.zzarh.zzc(i, zza.type));
                            zzhp zzv = zza.zzahv.zzv(zza2.zzaxg + 30);
                            if (zza.type == 1) {
                                if (zzka2.zzgs()) {
                                    zzv = zzv.zzb(zzka2.zzahn, zzka2.zzaho);
                                }
                                if (zzmd2 != null) {
                                    zzv = zzv.zza(zzmd2);
                                }
                            }
                            zzlm.zzbaa.zze(zzv);
                            zzmd = zzmd2;
                            zzka = zzka2;
                            j3 = Math.max(j3, zza.zzaif);
                            arrayList.add(zzlm);
                            long j4 = zza2.zzaom[0];
                            if (j4 < j2) {
                                j2 = j4;
                            }
                            i++;
                            zzka2 = zzka;
                            zzmd2 = zzmd;
                        }
                    }
                    zzmd = zzmd2;
                    zzka = zzka2;
                    i++;
                    zzka2 = zzka;
                    zzmd2 = zzmd;
                }
                this.zzaif = j3;
                this.zzayt = (zzlm[]) arrayList.toArray(new zzlm[arrayList.size()]);
                this.zzarh.zzgr();
                this.zzarh.zza(this);
                this.zzaxt.clear();
                this.zzaxv = 2;
            } else if (!this.zzaxt.isEmpty()) {
                this.zzaxt.peek().zza(pop);
            }
        }
        if (this.zzaxv != 2) {
            zzhb();
        }
    }

    private final void zzhb() {
        this.zzaxv = 0;
        this.zzaxy = 0;
    }

    public final long getDurationUs() {
        return this.zzaif;
    }

    public final boolean isSeekable() {
        return true;
    }

    public final void release() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:149:0x0194 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x02a7 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x0006 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x0006 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0190  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(com.google.android.gms.internal.ads.zzjz r25, com.google.android.gms.internal.ads.zzkc r26) {
        /*
            r24 = this;
            r0 = r24
            r1 = r25
            r2 = r26
        L_0x0006:
            int r3 = r0.zzaxv
            r5 = 262144(0x40000, double:1.295163E-318)
            r8 = -1
            r9 = 8
            r10 = 1
            switch(r3) {
                case 0: goto L_0x0196;
                case 1: goto L_0x0111;
                case 2: goto L_0x0018;
                default: goto L_0x0012;
            }
        L_0x0012:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>()
            throw r1
        L_0x0018:
            r12 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r3 = 0
            r9 = -1
        L_0x001f:
            com.google.android.gms.internal.ads.zzlm[] r14 = r0.zzayt
            int r15 = r14.length
            if (r3 >= r15) goto L_0x003d
            r14 = r14[r3]
            int r15 = r14.zzaxc
            com.google.android.gms.internal.ads.zzlt r7 = r14.zzazz
            int r7 = r7.zzaxa
            if (r15 == r7) goto L_0x003a
            com.google.android.gms.internal.ads.zzlt r7 = r14.zzazz
            long[] r7 = r7.zzaom
            r14 = r7[r15]
            int r7 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
            if (r7 >= 0) goto L_0x003a
            r9 = r3
            r12 = r14
        L_0x003a:
            int r3 = r3 + 1
            goto L_0x001f
        L_0x003d:
            if (r9 != r8) goto L_0x0040
            return r8
        L_0x0040:
            r3 = r14[r9]
            com.google.android.gms.internal.ads.zzkh r7 = r3.zzbaa
            int r8 = r3.zzaxc
            com.google.android.gms.internal.ads.zzlt r9 = r3.zzazz
            long[] r9 = r9.zzaom
            r12 = r9[r8]
            com.google.android.gms.internal.ads.zzlt r9 = r3.zzazz
            int[] r9 = r9.zzaol
            r9 = r9[r8]
            com.google.android.gms.internal.ads.zzlo r14 = r3.zzayk
            int r14 = r14.zzbac
            if (r14 != r10) goto L_0x005d
            r14 = 8
            long r12 = r12 + r14
            int r9 = r9 + -8
        L_0x005d:
            long r14 = r25.getPosition()
            long r14 = r12 - r14
            int r4 = r0.zzare
            long r10 = (long) r4
            long r14 = r14 + r10
            r10 = 0
            int r4 = (r14 > r10 ? 1 : (r14 == r10 ? 0 : -1))
            if (r4 < 0) goto L_0x010d
            int r4 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            if (r4 < 0) goto L_0x0073
            goto L_0x010d
        L_0x0073:
            int r2 = (int) r14
            r1.zzag(r2)
            com.google.android.gms.internal.ads.zzlo r2 = r3.zzayk
            int r2 = r2.zzasp
            if (r2 == 0) goto L_0x00d4
            com.google.android.gms.internal.ads.zzpn r2 = r0.zzapp
            byte[] r2 = r2.data
            r4 = 0
            r2[r4] = r4
            r5 = 1
            r2[r5] = r4
            r5 = 2
            r2[r5] = r4
            com.google.android.gms.internal.ads.zzlo r2 = r3.zzayk
            int r2 = r2.zzasp
            com.google.android.gms.internal.ads.zzlo r4 = r3.zzayk
            int r4 = r4.zzasp
            r5 = 4
            int r4 = 4 - r4
        L_0x0095:
            int r5 = r0.zzare
            if (r5 >= r9) goto L_0x00ea
            int r5 = r0.zzard
            if (r5 != 0) goto L_0x00c4
            com.google.android.gms.internal.ads.zzpn r5 = r0.zzapp
            byte[] r5 = r5.data
            r1.readFully(r5, r4, r2)
            com.google.android.gms.internal.ads.zzpn r5 = r0.zzapp
            r6 = 0
            r5.zzbl(r6)
            com.google.android.gms.internal.ads.zzpn r5 = r0.zzapp
            int r5 = r5.zzjf()
            r0.zzard = r5
            com.google.android.gms.internal.ads.zzpn r5 = r0.zzapo
            r5.zzbl(r6)
            com.google.android.gms.internal.ads.zzpn r5 = r0.zzapo
            r10 = 4
            r7.zza(r5, r10)
            int r5 = r0.zzare
            int r5 = r5 + r10
            r0.zzare = r5
            int r9 = r9 + r4
            goto L_0x0095
        L_0x00c4:
            r6 = 0
            int r5 = r7.zza(r1, r5, r6)
            int r6 = r0.zzare
            int r6 = r6 + r5
            r0.zzare = r6
            int r6 = r0.zzard
            int r6 = r6 - r5
            r0.zzard = r6
            goto L_0x0095
        L_0x00d4:
            int r2 = r0.zzare
            if (r2 >= r9) goto L_0x00ea
            int r2 = r9 - r2
            r4 = 0
            int r2 = r7.zza(r1, r2, r4)
            int r4 = r0.zzare
            int r4 = r4 + r2
            r0.zzare = r4
            int r4 = r0.zzard
            int r4 = r4 - r2
            r0.zzard = r4
            goto L_0x00d4
        L_0x00ea:
            r20 = r9
            com.google.android.gms.internal.ads.zzlt r1 = r3.zzazz
            long[] r1 = r1.zzbbf
            r17 = r1[r8]
            com.google.android.gms.internal.ads.zzlt r1 = r3.zzazz
            int[] r1 = r1.zzaxi
            r19 = r1[r8]
            r21 = 0
            r22 = 0
            r16 = r7
            r16.zza(r17, r19, r20, r21, r22)
            int r1 = r3.zzaxc
            r4 = 1
            int r1 = r1 + r4
            r3.zzaxc = r1
            r1 = 0
            r0.zzare = r1
            r0.zzard = r1
            return r1
        L_0x010d:
            r4 = 1
            r2.position = r12
            return r4
        L_0x0111:
            long r3 = r0.zzaxx
            int r7 = r0.zzaxy
            long r7 = (long) r7
            long r3 = r3 - r7
            long r7 = r25.getPosition()
            long r7 = r7 + r3
            com.google.android.gms.internal.ads.zzpn r10 = r0.zzaxz
            if (r10 == 0) goto L_0x0171
            byte[] r5 = r10.data
            int r6 = r0.zzaxy
            int r4 = (int) r3
            r1.readFully(r5, r6, r4)
            int r3 = r0.zzaxw
            int r4 = com.google.android.gms.internal.ads.zzks.zzasq
            if (r3 != r4) goto L_0x0154
            com.google.android.gms.internal.ads.zzpn r3 = r0.zzaxz
            r3.zzbl(r9)
            int r4 = r3.readInt()
            int r5 = zzays
            if (r4 != r5) goto L_0x013d
        L_0x013b:
            r3 = 1
            goto L_0x0151
        L_0x013d:
            r4 = 4
            r3.zzbm(r4)
        L_0x0141:
            int r4 = r3.zzja()
            if (r4 <= 0) goto L_0x0150
            int r4 = r3.readInt()
            int r5 = zzays
            if (r4 != r5) goto L_0x0141
            goto L_0x013b
        L_0x0150:
            r3 = 0
        L_0x0151:
            r0.zzayu = r3
            goto L_0x0179
        L_0x0154:
            java.util.Stack<com.google.android.gms.internal.ads.zzkv> r3 = r0.zzaxt
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x0179
            java.util.Stack<com.google.android.gms.internal.ads.zzkv> r3 = r0.zzaxt
            java.lang.Object r3 = r3.peek()
            com.google.android.gms.internal.ads.zzkv r3 = (com.google.android.gms.internal.ads.zzkv) r3
            com.google.android.gms.internal.ads.zzku r4 = new com.google.android.gms.internal.ads.zzku
            int r5 = r0.zzaxw
            com.google.android.gms.internal.ads.zzpn r6 = r0.zzaxz
            r4.<init>(r5, r6)
            r3.zza((com.google.android.gms.internal.ads.zzku) r4)
            goto L_0x0179
        L_0x0171:
            int r9 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r9 >= 0) goto L_0x017b
            int r4 = (int) r3
            r1.zzag(r4)
        L_0x0179:
            r3 = 0
            goto L_0x0183
        L_0x017b:
            long r5 = r25.getPosition()
            long r5 = r5 + r3
            r2.position = r5
            r3 = 1
        L_0x0183:
            r0.zzeb(r7)
            if (r3 == 0) goto L_0x0190
            int r3 = r0.zzaxv
            r4 = 2
            if (r3 == r4) goto L_0x0190
            r23 = 1
            goto L_0x0192
        L_0x0190:
            r23 = 0
        L_0x0192:
            if (r23 == 0) goto L_0x0006
            r3 = 1
            return r3
        L_0x0196:
            r3 = 1
            int r4 = r0.zzaxy
            if (r4 != 0) goto L_0x01c0
            com.google.android.gms.internal.ads.zzpn r4 = r0.zzaxr
            byte[] r4 = r4.data
            r5 = 0
            boolean r4 = r1.zza(r4, r5, r9, r3)
            if (r4 != 0) goto L_0x01a9
            r3 = 0
            goto L_0x02a5
        L_0x01a9:
            r0.zzaxy = r9
            com.google.android.gms.internal.ads.zzpn r3 = r0.zzaxr
            r3.zzbl(r5)
            com.google.android.gms.internal.ads.zzpn r3 = r0.zzaxr
            long r3 = r3.zzjc()
            r0.zzaxx = r3
            com.google.android.gms.internal.ads.zzpn r3 = r0.zzaxr
            int r3 = r3.readInt()
            r0.zzaxw = r3
        L_0x01c0:
            long r3 = r0.zzaxx
            r5 = 1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x01dc
            com.google.android.gms.internal.ads.zzpn r3 = r0.zzaxr
            byte[] r3 = r3.data
            r1.readFully(r3, r9, r9)
            int r3 = r0.zzaxy
            int r3 = r3 + r9
            r0.zzaxy = r3
            com.google.android.gms.internal.ads.zzpn r3 = r0.zzaxr
            long r3 = r3.zzjg()
            r0.zzaxx = r3
        L_0x01dc:
            int r3 = r0.zzaxw
            int r4 = com.google.android.gms.internal.ads.zzks.zzatr
            if (r3 == r4) goto L_0x01f9
            int r4 = com.google.android.gms.internal.ads.zzks.zzatt
            if (r3 == r4) goto L_0x01f9
            int r4 = com.google.android.gms.internal.ads.zzks.zzatu
            if (r3 == r4) goto L_0x01f9
            int r4 = com.google.android.gms.internal.ads.zzks.zzatv
            if (r3 == r4) goto L_0x01f9
            int r4 = com.google.android.gms.internal.ads.zzks.zzatw
            if (r3 == r4) goto L_0x01f9
            int r4 = com.google.android.gms.internal.ads.zzks.zzauf
            if (r3 != r4) goto L_0x01f7
            goto L_0x01f9
        L_0x01f7:
            r3 = 0
            goto L_0x01fa
        L_0x01f9:
            r3 = 1
        L_0x01fa:
            if (r3 == 0) goto L_0x0226
            long r3 = r25.getPosition()
            long r5 = r0.zzaxx
            long r3 = r3 + r5
            int r5 = r0.zzaxy
            long r5 = (long) r5
            long r3 = r3 - r5
            java.util.Stack<com.google.android.gms.internal.ads.zzkv> r5 = r0.zzaxt
            com.google.android.gms.internal.ads.zzkv r6 = new com.google.android.gms.internal.ads.zzkv
            int r7 = r0.zzaxw
            r6.<init>(r7, r3)
            r5.add(r6)
            long r5 = r0.zzaxx
            int r7 = r0.zzaxy
            long r9 = (long) r7
            int r7 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r7 != 0) goto L_0x0220
            r0.zzeb(r3)
            goto L_0x0223
        L_0x0220:
            r24.zzhb()
        L_0x0223:
            r3 = 1
            goto L_0x02a5
        L_0x0226:
            int r3 = r0.zzaxw
            int r4 = com.google.android.gms.internal.ads.zzks.zzauh
            if (r3 == r4) goto L_0x026b
            int r4 = com.google.android.gms.internal.ads.zzks.zzats
            if (r3 == r4) goto L_0x026b
            int r4 = com.google.android.gms.internal.ads.zzks.zzaui
            if (r3 == r4) goto L_0x026b
            int r4 = com.google.android.gms.internal.ads.zzks.zzauj
            if (r3 == r4) goto L_0x026b
            int r4 = com.google.android.gms.internal.ads.zzks.zzavc
            if (r3 == r4) goto L_0x026b
            int r4 = com.google.android.gms.internal.ads.zzks.zzavd
            if (r3 == r4) goto L_0x026b
            int r4 = com.google.android.gms.internal.ads.zzks.zzave
            if (r3 == r4) goto L_0x026b
            int r4 = com.google.android.gms.internal.ads.zzks.zzaug
            if (r3 == r4) goto L_0x026b
            int r4 = com.google.android.gms.internal.ads.zzks.zzavf
            if (r3 == r4) goto L_0x026b
            int r4 = com.google.android.gms.internal.ads.zzks.zzavg
            if (r3 == r4) goto L_0x026b
            int r4 = com.google.android.gms.internal.ads.zzks.zzavh
            if (r3 == r4) goto L_0x026b
            int r4 = com.google.android.gms.internal.ads.zzks.zzavi
            if (r3 == r4) goto L_0x026b
            int r4 = com.google.android.gms.internal.ads.zzks.zzavj
            if (r3 == r4) goto L_0x026b
            int r4 = com.google.android.gms.internal.ads.zzks.zzaue
            if (r3 == r4) goto L_0x026b
            int r4 = com.google.android.gms.internal.ads.zzks.zzasq
            if (r3 == r4) goto L_0x026b
            int r4 = com.google.android.gms.internal.ads.zzks.zzavq
            if (r3 != r4) goto L_0x0269
            goto L_0x026b
        L_0x0269:
            r3 = 0
            goto L_0x026c
        L_0x026b:
            r3 = 1
        L_0x026c:
            if (r3 == 0) goto L_0x029f
            int r3 = r0.zzaxy
            if (r3 != r9) goto L_0x0274
            r3 = 1
            goto L_0x0275
        L_0x0274:
            r3 = 0
        L_0x0275:
            com.google.android.gms.internal.ads.zzpc.checkState(r3)
            long r3 = r0.zzaxx
            r5 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 > 0) goto L_0x0283
            r3 = 1
            goto L_0x0284
        L_0x0283:
            r3 = 0
        L_0x0284:
            com.google.android.gms.internal.ads.zzpc.checkState(r3)
            com.google.android.gms.internal.ads.zzpn r3 = new com.google.android.gms.internal.ads.zzpn
            long r4 = r0.zzaxx
            int r5 = (int) r4
            r3.<init>((int) r5)
            r0.zzaxz = r3
            com.google.android.gms.internal.ads.zzpn r3 = r0.zzaxr
            byte[] r3 = r3.data
            com.google.android.gms.internal.ads.zzpn r4 = r0.zzaxz
            byte[] r4 = r4.data
            r5 = 0
            java.lang.System.arraycopy(r3, r5, r4, r5, r9)
            r3 = 1
            goto L_0x02a3
        L_0x029f:
            r3 = 1
            r4 = 0
            r0.zzaxz = r4
        L_0x02a3:
            r0.zzaxv = r3
        L_0x02a5:
            if (r3 != 0) goto L_0x0006
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlk.zza(com.google.android.gms.internal.ads.zzjz, com.google.android.gms.internal.ads.zzkc):int");
    }

    public final void zza(zzjy zzjy) {
        this.zzarh = zzjy;
    }

    public final boolean zza(zzjz zzjz) {
        return zzlp.zze(zzjz);
    }

    public final void zzc(long j, long j2) {
        this.zzaxt.clear();
        this.zzaxy = 0;
        this.zzare = 0;
        this.zzard = 0;
        if (j == 0) {
            zzhb();
            return;
        }
        zzlm[] zzlmArr = this.zzayt;
        if (zzlmArr != null) {
            for (zzlm zzlm : zzlmArr) {
                zzlt zzlt = zzlm.zzazz;
                int zzec = zzlt.zzec(j2);
                if (zzec == -1) {
                    zzec = zzlt.zzed(j2);
                }
                zzlm.zzaxc = zzec;
            }
        }
    }

    public final long zzdz(long j) {
        long j2 = Long.MAX_VALUE;
        for (zzlm zzlm : this.zzayt) {
            zzlt zzlt = zzlm.zzazz;
            int zzec = zzlt.zzec(j);
            if (zzec == -1) {
                zzec = zzlt.zzed(j);
            }
            long j3 = zzlt.zzaom[zzec];
            if (j3 < j2) {
                j2 = j3;
            }
        }
        return j2;
    }
}
