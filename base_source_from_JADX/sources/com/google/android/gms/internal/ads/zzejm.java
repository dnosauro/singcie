package com.google.android.gms.internal.ads;

import java.util.List;

final class zzejm implements zzemh {
    private int tag;
    private final zzejj zzijy;
    private int zzijz;
    private int zzika = 0;

    private zzejm(zzejj zzejj) {
        this.zzijy = (zzejj) zzekk.zza(zzejj, "input");
        this.zzijy.zzijo = this;
    }

    public static zzejm zza(zzejj zzejj) {
        return zzejj.zzijo != null ? zzejj.zzijo : new zzejm(zzejj);
    }

    private final Object zza(zzenw zzenw, Class<?> cls, zzeju zzeju) {
        switch (zzejp.zzikd[zzenw.ordinal()]) {
            case 1:
                return Boolean.valueOf(zzbgg());
            case 2:
                return zzbgi();
            case 3:
                return Double.valueOf(readDouble());
            case 4:
                return Integer.valueOf(zzbgk());
            case 5:
                return Integer.valueOf(zzbgf());
            case 6:
                return Long.valueOf(zzbge());
            case 7:
                return Float.valueOf(readFloat());
            case 8:
                return Integer.valueOf(zzbgd());
            case 9:
                return Long.valueOf(zzbgc());
            case 10:
                zzgm(2);
                return zzc(zzemg.zzbjn().zzh(cls), zzeju);
            case 11:
                return Integer.valueOf(zzbgl());
            case 12:
                return Long.valueOf(zzbgm());
            case 13:
                return Integer.valueOf(zzbgn());
            case 14:
                return Long.valueOf(zzbgo());
            case 15:
                return zzbgh();
            case 16:
                return Integer.valueOf(zzbgj());
            case 17:
                return Long.valueOf(zzbgb());
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private final void zza(List<String> list, boolean z) {
        int zzbga;
        int zzbga2;
        if ((this.tag & 7) != 2) {
            throw zzeks.zzbin();
        } else if (!(list instanceof zzekz) || z) {
            do {
                list.add(z ? zzbgh() : readString());
                if (!this.zzijy.zzbgq()) {
                    zzbga = this.zzijy.zzbga();
                } else {
                    return;
                }
            } while (zzbga == this.tag);
            this.zzika = zzbga;
        } else {
            zzekz zzekz = (zzekz) list;
            do {
                zzekz.zzak(zzbgi());
                if (!this.zzijy.zzbgq()) {
                    zzbga2 = this.zzijy.zzbga();
                } else {
                    return;
                }
            } while (zzbga2 == this.tag);
            this.zzika = zzbga2;
        }
    }

    private final <T> T zzc(zzemn<T> zzemn, zzeju zzeju) {
        int zzbgj = this.zzijy.zzbgj();
        if (this.zzijy.zzijl < this.zzijy.zzijm) {
            int zzge = this.zzijy.zzge(zzbgj);
            T newInstance = zzemn.newInstance();
            this.zzijy.zzijl++;
            zzemn.zza(newInstance, this, zzeju);
            zzemn.zzak(newInstance);
            this.zzijy.zzgc(0);
            zzejj zzejj = this.zzijy;
            zzejj.zzijl--;
            this.zzijy.zzgf(zzge);
            return newInstance;
        }
        throw new zzeks("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    private final <T> T zzd(zzemn<T> zzemn, zzeju zzeju) {
        int i = this.zzijz;
        this.zzijz = ((this.tag >>> 3) << 3) | 4;
        try {
            T newInstance = zzemn.newInstance();
            zzemn.zza(newInstance, this, zzeju);
            zzemn.zzak(newInstance);
            if (this.tag == this.zzijz) {
                return newInstance;
            }
            throw zzeks.zzbip();
        } finally {
            this.zzijz = i;
        }
    }

    private final void zzgm(int i) {
        if ((this.tag & 7) != i) {
            throw zzeks.zzbin();
        }
    }

    private static void zzgn(int i) {
        if ((i & 7) != 0) {
            throw zzeks.zzbip();
        }
    }

    private static void zzgo(int i) {
        if ((i & 3) != 0) {
            throw zzeks.zzbip();
        }
    }

    private final void zzgp(int i) {
        if (this.zzijy.zzbgr() != i) {
            throw zzeks.zzbii();
        }
    }

    public final int getTag() {
        return this.tag;
    }

    public final double readDouble() {
        zzgm(1);
        return this.zzijy.readDouble();
    }

    public final float readFloat() {
        zzgm(5);
        return this.zzijy.readFloat();
    }

    public final String readString() {
        zzgm(2);
        return this.zzijy.readString();
    }

    public final void readStringList(List<String> list) {
        zza(list, false);
    }

    public final <T> T zza(zzemn<T> zzemn, zzeju zzeju) {
        zzgm(2);
        return zzc(zzemn, zzeju);
    }

    public final <T> void zza(List<T> list, zzemn<T> zzemn, zzeju zzeju) {
        int zzbga;
        int i = this.tag;
        if ((i & 7) == 2) {
            do {
                list.add(zzc(zzemn, zzeju));
                if (!this.zzijy.zzbgq() && this.zzika == 0) {
                    zzbga = this.zzijy.zzbga();
                } else {
                    return;
                }
            } while (zzbga == i);
            this.zzika = zzbga;
            return;
        }
        throw zzeks.zzbin();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0051, code lost:
        if (zzbgz() != false) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005b, code lost:
        throw new com.google.android.gms.internal.ads.zzeks("Unable to parse map entry.");
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x004d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <K, V> void zza(java.util.Map<K, V> r6, com.google.android.gms.internal.ads.zzelj<K, V> r7, com.google.android.gms.internal.ads.zzeju r8) {
        /*
            r5 = this;
            r0 = 2
            r5.zzgm(r0)
            com.google.android.gms.internal.ads.zzejj r0 = r5.zzijy
            int r0 = r0.zzbgj()
            com.google.android.gms.internal.ads.zzejj r1 = r5.zzijy
            int r0 = r1.zzge(r0)
            K r1 = r7.zzipk
            V r2 = r7.zzcld
        L_0x0014:
            int r3 = r5.zzbgy()     // Catch:{ all -> 0x0065 }
            r4 = 2147483647(0x7fffffff, float:NaN)
            if (r3 == r4) goto L_0x005c
            com.google.android.gms.internal.ads.zzejj r4 = r5.zzijy     // Catch:{ all -> 0x0065 }
            boolean r4 = r4.zzbgq()     // Catch:{ all -> 0x0065 }
            if (r4 != 0) goto L_0x005c
            switch(r3) {
                case 1: goto L_0x003a;
                case 2: goto L_0x002d;
                default: goto L_0x0028;
            }
        L_0x0028:
            boolean r3 = r5.zzbgz()     // Catch:{ zzekr -> 0x004d }
            goto L_0x0042
        L_0x002d:
            com.google.android.gms.internal.ads.zzenw r3 = r7.zzipl     // Catch:{ zzekr -> 0x004d }
            V r4 = r7.zzcld     // Catch:{ zzekr -> 0x004d }
            java.lang.Class r4 = r4.getClass()     // Catch:{ zzekr -> 0x004d }
            java.lang.Object r2 = r5.zza((com.google.android.gms.internal.ads.zzenw) r3, (java.lang.Class<?>) r4, (com.google.android.gms.internal.ads.zzeju) r8)     // Catch:{ zzekr -> 0x004d }
            goto L_0x0014
        L_0x003a:
            com.google.android.gms.internal.ads.zzenw r3 = r7.zzipj     // Catch:{ zzekr -> 0x004d }
            r4 = 0
            java.lang.Object r1 = r5.zza((com.google.android.gms.internal.ads.zzenw) r3, (java.lang.Class<?>) r4, (com.google.android.gms.internal.ads.zzeju) r4)     // Catch:{ zzekr -> 0x004d }
            goto L_0x0014
        L_0x0042:
            if (r3 == 0) goto L_0x0045
            goto L_0x0014
        L_0x0045:
            com.google.android.gms.internal.ads.zzeks r3 = new com.google.android.gms.internal.ads.zzeks     // Catch:{ zzekr -> 0x004d }
            java.lang.String r4 = "Unable to parse map entry."
            r3.<init>(r4)     // Catch:{ zzekr -> 0x004d }
            throw r3     // Catch:{ zzekr -> 0x004d }
        L_0x004d:
            boolean r3 = r5.zzbgz()     // Catch:{ all -> 0x0065 }
            if (r3 == 0) goto L_0x0054
            goto L_0x0014
        L_0x0054:
            com.google.android.gms.internal.ads.zzeks r6 = new com.google.android.gms.internal.ads.zzeks     // Catch:{ all -> 0x0065 }
            java.lang.String r7 = "Unable to parse map entry."
            r6.<init>(r7)     // Catch:{ all -> 0x0065 }
            throw r6     // Catch:{ all -> 0x0065 }
        L_0x005c:
            r6.put(r1, r2)     // Catch:{ all -> 0x0065 }
            com.google.android.gms.internal.ads.zzejj r6 = r5.zzijy
            r6.zzgf(r0)
            return
        L_0x0065:
            r6 = move-exception
            com.google.android.gms.internal.ads.zzejj r7 = r5.zzijy
            r7.zzgf(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzejm.zza(java.util.Map, com.google.android.gms.internal.ads.zzelj, com.google.android.gms.internal.ads.zzeju):void");
    }

    public final void zzaa(List<Long> list) {
        int zzbga;
        int zzbga2;
        if (list instanceof zzelg) {
            zzelg zzelg = (zzelg) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzelg.zzfr(this.zzijy.zzbgo());
                    if (!this.zzijy.zzbgq()) {
                        zzbga2 = this.zzijy.zzbga();
                    } else {
                        return;
                    }
                } while (zzbga2 == this.tag);
                this.zzika = zzbga2;
            } else if (i == 2) {
                int zzbgr = this.zzijy.zzbgr() + this.zzijy.zzbgj();
                do {
                    zzelg.zzfr(this.zzijy.zzbgo());
                } while (this.zzijy.zzbgr() < zzbgr);
                zzgp(zzbgr);
            } else {
                throw zzeks.zzbin();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zzijy.zzbgo()));
                    if (!this.zzijy.zzbgq()) {
                        zzbga = this.zzijy.zzbga();
                    } else {
                        return;
                    }
                } while (zzbga == this.tag);
                this.zzika = zzbga;
            } else if (i2 == 2) {
                int zzbgr2 = this.zzijy.zzbgr() + this.zzijy.zzbgj();
                do {
                    list.add(Long.valueOf(this.zzijy.zzbgo()));
                } while (this.zzijy.zzbgr() < zzbgr2);
                zzgp(zzbgr2);
            } else {
                throw zzeks.zzbin();
            }
        }
    }

    public final <T> T zzb(zzemn<T> zzemn, zzeju zzeju) {
        zzgm(3);
        return zzd(zzemn, zzeju);
    }

    public final <T> void zzb(List<T> list, zzemn<T> zzemn, zzeju zzeju) {
        int zzbga;
        int i = this.tag;
        if ((i & 7) == 3) {
            do {
                list.add(zzd(zzemn, zzeju));
                if (!this.zzijy.zzbgq() && this.zzika == 0) {
                    zzbga = this.zzijy.zzbga();
                } else {
                    return;
                }
            } while (zzbga == i);
            this.zzika = zzbga;
            return;
        }
        throw zzeks.zzbin();
    }

    public final long zzbgb() {
        zzgm(0);
        return this.zzijy.zzbgb();
    }

    public final long zzbgc() {
        zzgm(0);
        return this.zzijy.zzbgc();
    }

    public final int zzbgd() {
        zzgm(0);
        return this.zzijy.zzbgd();
    }

    public final long zzbge() {
        zzgm(1);
        return this.zzijy.zzbge();
    }

    public final int zzbgf() {
        zzgm(5);
        return this.zzijy.zzbgf();
    }

    public final boolean zzbgg() {
        zzgm(0);
        return this.zzijy.zzbgg();
    }

    public final String zzbgh() {
        zzgm(2);
        return this.zzijy.zzbgh();
    }

    public final zzeiu zzbgi() {
        zzgm(2);
        return this.zzijy.zzbgi();
    }

    public final int zzbgj() {
        zzgm(0);
        return this.zzijy.zzbgj();
    }

    public final int zzbgk() {
        zzgm(0);
        return this.zzijy.zzbgk();
    }

    public final int zzbgl() {
        zzgm(5);
        return this.zzijy.zzbgl();
    }

    public final long zzbgm() {
        zzgm(1);
        return this.zzijy.zzbgm();
    }

    public final int zzbgn() {
        zzgm(0);
        return this.zzijy.zzbgn();
    }

    public final long zzbgo() {
        zzgm(0);
        return this.zzijy.zzbgo();
    }

    public final int zzbgy() {
        int i = this.zzika;
        if (i != 0) {
            this.tag = i;
            this.zzika = 0;
        } else {
            this.tag = this.zzijy.zzbga();
        }
        int i2 = this.tag;
        if (i2 == 0 || i2 == this.zzijz) {
            return Integer.MAX_VALUE;
        }
        return i2 >>> 3;
    }

    public final boolean zzbgz() {
        int i;
        if (this.zzijy.zzbgq() || (i = this.tag) == this.zzijz) {
            return false;
        }
        return this.zzijy.zzgd(i);
    }

    public final void zzl(List<Double> list) {
        int zzbga;
        int zzbga2;
        if (list instanceof zzejt) {
            zzejt zzejt = (zzejt) list;
            switch (this.tag & 7) {
                case 1:
                    break;
                case 2:
                    int zzbgj = this.zzijy.zzbgj();
                    zzgn(zzbgj);
                    int zzbgr = this.zzijy.zzbgr() + zzbgj;
                    do {
                        zzejt.zze(this.zzijy.readDouble());
                    } while (this.zzijy.zzbgr() < zzbgr);
                    return;
                default:
                    throw zzeks.zzbin();
            }
            do {
                zzejt.zze(this.zzijy.readDouble());
                if (!this.zzijy.zzbgq()) {
                    zzbga2 = this.zzijy.zzbga();
                } else {
                    return;
                }
            } while (zzbga2 == this.tag);
            this.zzika = zzbga2;
            return;
        }
        switch (this.tag & 7) {
            case 1:
                break;
            case 2:
                int zzbgj2 = this.zzijy.zzbgj();
                zzgn(zzbgj2);
                int zzbgr2 = this.zzijy.zzbgr() + zzbgj2;
                do {
                    list.add(Double.valueOf(this.zzijy.readDouble()));
                } while (this.zzijy.zzbgr() < zzbgr2);
                return;
            default:
                throw zzeks.zzbin();
        }
        do {
            list.add(Double.valueOf(this.zzijy.readDouble()));
            if (!this.zzijy.zzbgq()) {
                zzbga = this.zzijy.zzbga();
            } else {
                return;
            }
        } while (zzbga == this.tag);
        this.zzika = zzbga;
    }

    public final void zzm(List<Float> list) {
        int zzbga;
        int zzbga2;
        if (list instanceof zzekd) {
            zzekd zzekd = (zzekd) list;
            int i = this.tag & 7;
            if (i == 2) {
                int zzbgj = this.zzijy.zzbgj();
                zzgo(zzbgj);
                int zzbgr = this.zzijy.zzbgr() + zzbgj;
                do {
                    zzekd.zzh(this.zzijy.readFloat());
                } while (this.zzijy.zzbgr() < zzbgr);
            } else if (i == 5) {
                do {
                    zzekd.zzh(this.zzijy.readFloat());
                    if (!this.zzijy.zzbgq()) {
                        zzbga2 = this.zzijy.zzbga();
                    } else {
                        return;
                    }
                } while (zzbga2 == this.tag);
                this.zzika = zzbga2;
            } else {
                throw zzeks.zzbin();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int zzbgj2 = this.zzijy.zzbgj();
                zzgo(zzbgj2);
                int zzbgr2 = this.zzijy.zzbgr() + zzbgj2;
                do {
                    list.add(Float.valueOf(this.zzijy.readFloat()));
                } while (this.zzijy.zzbgr() < zzbgr2);
            } else if (i2 == 5) {
                do {
                    list.add(Float.valueOf(this.zzijy.readFloat()));
                    if (!this.zzijy.zzbgq()) {
                        zzbga = this.zzijy.zzbga();
                    } else {
                        return;
                    }
                } while (zzbga == this.tag);
                this.zzika = zzbga;
            } else {
                throw zzeks.zzbin();
            }
        }
    }

    public final void zzn(List<Long> list) {
        int zzbga;
        int zzbga2;
        if (list instanceof zzelg) {
            zzelg zzelg = (zzelg) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzelg.zzfr(this.zzijy.zzbgb());
                    if (!this.zzijy.zzbgq()) {
                        zzbga2 = this.zzijy.zzbga();
                    } else {
                        return;
                    }
                } while (zzbga2 == this.tag);
                this.zzika = zzbga2;
            } else if (i == 2) {
                int zzbgr = this.zzijy.zzbgr() + this.zzijy.zzbgj();
                do {
                    zzelg.zzfr(this.zzijy.zzbgb());
                } while (this.zzijy.zzbgr() < zzbgr);
                zzgp(zzbgr);
            } else {
                throw zzeks.zzbin();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zzijy.zzbgb()));
                    if (!this.zzijy.zzbgq()) {
                        zzbga = this.zzijy.zzbga();
                    } else {
                        return;
                    }
                } while (zzbga == this.tag);
                this.zzika = zzbga;
            } else if (i2 == 2) {
                int zzbgr2 = this.zzijy.zzbgr() + this.zzijy.zzbgj();
                do {
                    list.add(Long.valueOf(this.zzijy.zzbgb()));
                } while (this.zzijy.zzbgr() < zzbgr2);
                zzgp(zzbgr2);
            } else {
                throw zzeks.zzbin();
            }
        }
    }

    public final void zzo(List<Long> list) {
        int zzbga;
        int zzbga2;
        if (list instanceof zzelg) {
            zzelg zzelg = (zzelg) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzelg.zzfr(this.zzijy.zzbgc());
                    if (!this.zzijy.zzbgq()) {
                        zzbga2 = this.zzijy.zzbga();
                    } else {
                        return;
                    }
                } while (zzbga2 == this.tag);
                this.zzika = zzbga2;
            } else if (i == 2) {
                int zzbgr = this.zzijy.zzbgr() + this.zzijy.zzbgj();
                do {
                    zzelg.zzfr(this.zzijy.zzbgc());
                } while (this.zzijy.zzbgr() < zzbgr);
                zzgp(zzbgr);
            } else {
                throw zzeks.zzbin();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zzijy.zzbgc()));
                    if (!this.zzijy.zzbgq()) {
                        zzbga = this.zzijy.zzbga();
                    } else {
                        return;
                    }
                } while (zzbga == this.tag);
                this.zzika = zzbga;
            } else if (i2 == 2) {
                int zzbgr2 = this.zzijy.zzbgr() + this.zzijy.zzbgj();
                do {
                    list.add(Long.valueOf(this.zzijy.zzbgc()));
                } while (this.zzijy.zzbgr() < zzbgr2);
                zzgp(zzbgr2);
            } else {
                throw zzeks.zzbin();
            }
        }
    }

    public final void zzp(List<Integer> list) {
        int zzbga;
        int zzbga2;
        if (list instanceof zzeki) {
            zzeki zzeki = (zzeki) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzeki.zzhg(this.zzijy.zzbgd());
                    if (!this.zzijy.zzbgq()) {
                        zzbga2 = this.zzijy.zzbga();
                    } else {
                        return;
                    }
                } while (zzbga2 == this.tag);
                this.zzika = zzbga2;
            } else if (i == 2) {
                int zzbgr = this.zzijy.zzbgr() + this.zzijy.zzbgj();
                do {
                    zzeki.zzhg(this.zzijy.zzbgd());
                } while (this.zzijy.zzbgr() < zzbgr);
                zzgp(zzbgr);
            } else {
                throw zzeks.zzbin();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzijy.zzbgd()));
                    if (!this.zzijy.zzbgq()) {
                        zzbga = this.zzijy.zzbga();
                    } else {
                        return;
                    }
                } while (zzbga == this.tag);
                this.zzika = zzbga;
            } else if (i2 == 2) {
                int zzbgr2 = this.zzijy.zzbgr() + this.zzijy.zzbgj();
                do {
                    list.add(Integer.valueOf(this.zzijy.zzbgd()));
                } while (this.zzijy.zzbgr() < zzbgr2);
                zzgp(zzbgr2);
            } else {
                throw zzeks.zzbin();
            }
        }
    }

    public final void zzq(List<Long> list) {
        int zzbga;
        int zzbga2;
        if (list instanceof zzelg) {
            zzelg zzelg = (zzelg) list;
            switch (this.tag & 7) {
                case 1:
                    break;
                case 2:
                    int zzbgj = this.zzijy.zzbgj();
                    zzgn(zzbgj);
                    int zzbgr = this.zzijy.zzbgr() + zzbgj;
                    do {
                        zzelg.zzfr(this.zzijy.zzbge());
                    } while (this.zzijy.zzbgr() < zzbgr);
                    return;
                default:
                    throw zzeks.zzbin();
            }
            do {
                zzelg.zzfr(this.zzijy.zzbge());
                if (!this.zzijy.zzbgq()) {
                    zzbga2 = this.zzijy.zzbga();
                } else {
                    return;
                }
            } while (zzbga2 == this.tag);
            this.zzika = zzbga2;
            return;
        }
        switch (this.tag & 7) {
            case 1:
                break;
            case 2:
                int zzbgj2 = this.zzijy.zzbgj();
                zzgn(zzbgj2);
                int zzbgr2 = this.zzijy.zzbgr() + zzbgj2;
                do {
                    list.add(Long.valueOf(this.zzijy.zzbge()));
                } while (this.zzijy.zzbgr() < zzbgr2);
                return;
            default:
                throw zzeks.zzbin();
        }
        do {
            list.add(Long.valueOf(this.zzijy.zzbge()));
            if (!this.zzijy.zzbgq()) {
                zzbga = this.zzijy.zzbga();
            } else {
                return;
            }
        } while (zzbga == this.tag);
        this.zzika = zzbga;
    }

    public final void zzr(List<Integer> list) {
        int zzbga;
        int zzbga2;
        if (list instanceof zzeki) {
            zzeki zzeki = (zzeki) list;
            int i = this.tag & 7;
            if (i == 2) {
                int zzbgj = this.zzijy.zzbgj();
                zzgo(zzbgj);
                int zzbgr = this.zzijy.zzbgr() + zzbgj;
                do {
                    zzeki.zzhg(this.zzijy.zzbgf());
                } while (this.zzijy.zzbgr() < zzbgr);
            } else if (i == 5) {
                do {
                    zzeki.zzhg(this.zzijy.zzbgf());
                    if (!this.zzijy.zzbgq()) {
                        zzbga2 = this.zzijy.zzbga();
                    } else {
                        return;
                    }
                } while (zzbga2 == this.tag);
                this.zzika = zzbga2;
            } else {
                throw zzeks.zzbin();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int zzbgj2 = this.zzijy.zzbgj();
                zzgo(zzbgj2);
                int zzbgr2 = this.zzijy.zzbgr() + zzbgj2;
                do {
                    list.add(Integer.valueOf(this.zzijy.zzbgf()));
                } while (this.zzijy.zzbgr() < zzbgr2);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.zzijy.zzbgf()));
                    if (!this.zzijy.zzbgq()) {
                        zzbga = this.zzijy.zzbga();
                    } else {
                        return;
                    }
                } while (zzbga == this.tag);
                this.zzika = zzbga;
            } else {
                throw zzeks.zzbin();
            }
        }
    }

    public final void zzs(List<Boolean> list) {
        int zzbga;
        int zzbga2;
        if (list instanceof zzeis) {
            zzeis zzeis = (zzeis) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzeis.addBoolean(this.zzijy.zzbgg());
                    if (!this.zzijy.zzbgq()) {
                        zzbga2 = this.zzijy.zzbga();
                    } else {
                        return;
                    }
                } while (zzbga2 == this.tag);
                this.zzika = zzbga2;
            } else if (i == 2) {
                int zzbgr = this.zzijy.zzbgr() + this.zzijy.zzbgj();
                do {
                    zzeis.addBoolean(this.zzijy.zzbgg());
                } while (this.zzijy.zzbgr() < zzbgr);
                zzgp(zzbgr);
            } else {
                throw zzeks.zzbin();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Boolean.valueOf(this.zzijy.zzbgg()));
                    if (!this.zzijy.zzbgq()) {
                        zzbga = this.zzijy.zzbga();
                    } else {
                        return;
                    }
                } while (zzbga == this.tag);
                this.zzika = zzbga;
            } else if (i2 == 2) {
                int zzbgr2 = this.zzijy.zzbgr() + this.zzijy.zzbgj();
                do {
                    list.add(Boolean.valueOf(this.zzijy.zzbgg()));
                } while (this.zzijy.zzbgr() < zzbgr2);
                zzgp(zzbgr2);
            } else {
                throw zzeks.zzbin();
            }
        }
    }

    public final void zzt(List<String> list) {
        zza(list, true);
    }

    public final void zzu(List<zzeiu> list) {
        int zzbga;
        if ((this.tag & 7) == 2) {
            do {
                list.add(zzbgi());
                if (!this.zzijy.zzbgq()) {
                    zzbga = this.zzijy.zzbga();
                } else {
                    return;
                }
            } while (zzbga == this.tag);
            this.zzika = zzbga;
            return;
        }
        throw zzeks.zzbin();
    }

    public final void zzv(List<Integer> list) {
        int zzbga;
        int zzbga2;
        if (list instanceof zzeki) {
            zzeki zzeki = (zzeki) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzeki.zzhg(this.zzijy.zzbgj());
                    if (!this.zzijy.zzbgq()) {
                        zzbga2 = this.zzijy.zzbga();
                    } else {
                        return;
                    }
                } while (zzbga2 == this.tag);
                this.zzika = zzbga2;
            } else if (i == 2) {
                int zzbgr = this.zzijy.zzbgr() + this.zzijy.zzbgj();
                do {
                    zzeki.zzhg(this.zzijy.zzbgj());
                } while (this.zzijy.zzbgr() < zzbgr);
                zzgp(zzbgr);
            } else {
                throw zzeks.zzbin();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzijy.zzbgj()));
                    if (!this.zzijy.zzbgq()) {
                        zzbga = this.zzijy.zzbga();
                    } else {
                        return;
                    }
                } while (zzbga == this.tag);
                this.zzika = zzbga;
            } else if (i2 == 2) {
                int zzbgr2 = this.zzijy.zzbgr() + this.zzijy.zzbgj();
                do {
                    list.add(Integer.valueOf(this.zzijy.zzbgj()));
                } while (this.zzijy.zzbgr() < zzbgr2);
                zzgp(zzbgr2);
            } else {
                throw zzeks.zzbin();
            }
        }
    }

    public final void zzw(List<Integer> list) {
        int zzbga;
        int zzbga2;
        if (list instanceof zzeki) {
            zzeki zzeki = (zzeki) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzeki.zzhg(this.zzijy.zzbgk());
                    if (!this.zzijy.zzbgq()) {
                        zzbga2 = this.zzijy.zzbga();
                    } else {
                        return;
                    }
                } while (zzbga2 == this.tag);
                this.zzika = zzbga2;
            } else if (i == 2) {
                int zzbgr = this.zzijy.zzbgr() + this.zzijy.zzbgj();
                do {
                    zzeki.zzhg(this.zzijy.zzbgk());
                } while (this.zzijy.zzbgr() < zzbgr);
                zzgp(zzbgr);
            } else {
                throw zzeks.zzbin();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzijy.zzbgk()));
                    if (!this.zzijy.zzbgq()) {
                        zzbga = this.zzijy.zzbga();
                    } else {
                        return;
                    }
                } while (zzbga == this.tag);
                this.zzika = zzbga;
            } else if (i2 == 2) {
                int zzbgr2 = this.zzijy.zzbgr() + this.zzijy.zzbgj();
                do {
                    list.add(Integer.valueOf(this.zzijy.zzbgk()));
                } while (this.zzijy.zzbgr() < zzbgr2);
                zzgp(zzbgr2);
            } else {
                throw zzeks.zzbin();
            }
        }
    }

    public final void zzx(List<Integer> list) {
        int zzbga;
        int zzbga2;
        if (list instanceof zzeki) {
            zzeki zzeki = (zzeki) list;
            int i = this.tag & 7;
            if (i == 2) {
                int zzbgj = this.zzijy.zzbgj();
                zzgo(zzbgj);
                int zzbgr = this.zzijy.zzbgr() + zzbgj;
                do {
                    zzeki.zzhg(this.zzijy.zzbgl());
                } while (this.zzijy.zzbgr() < zzbgr);
            } else if (i == 5) {
                do {
                    zzeki.zzhg(this.zzijy.zzbgl());
                    if (!this.zzijy.zzbgq()) {
                        zzbga2 = this.zzijy.zzbga();
                    } else {
                        return;
                    }
                } while (zzbga2 == this.tag);
                this.zzika = zzbga2;
            } else {
                throw zzeks.zzbin();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int zzbgj2 = this.zzijy.zzbgj();
                zzgo(zzbgj2);
                int zzbgr2 = this.zzijy.zzbgr() + zzbgj2;
                do {
                    list.add(Integer.valueOf(this.zzijy.zzbgl()));
                } while (this.zzijy.zzbgr() < zzbgr2);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.zzijy.zzbgl()));
                    if (!this.zzijy.zzbgq()) {
                        zzbga = this.zzijy.zzbga();
                    } else {
                        return;
                    }
                } while (zzbga == this.tag);
                this.zzika = zzbga;
            } else {
                throw zzeks.zzbin();
            }
        }
    }

    public final void zzy(List<Long> list) {
        int zzbga;
        int zzbga2;
        if (list instanceof zzelg) {
            zzelg zzelg = (zzelg) list;
            switch (this.tag & 7) {
                case 1:
                    break;
                case 2:
                    int zzbgj = this.zzijy.zzbgj();
                    zzgn(zzbgj);
                    int zzbgr = this.zzijy.zzbgr() + zzbgj;
                    do {
                        zzelg.zzfr(this.zzijy.zzbgm());
                    } while (this.zzijy.zzbgr() < zzbgr);
                    return;
                default:
                    throw zzeks.zzbin();
            }
            do {
                zzelg.zzfr(this.zzijy.zzbgm());
                if (!this.zzijy.zzbgq()) {
                    zzbga2 = this.zzijy.zzbga();
                } else {
                    return;
                }
            } while (zzbga2 == this.tag);
            this.zzika = zzbga2;
            return;
        }
        switch (this.tag & 7) {
            case 1:
                break;
            case 2:
                int zzbgj2 = this.zzijy.zzbgj();
                zzgn(zzbgj2);
                int zzbgr2 = this.zzijy.zzbgr() + zzbgj2;
                do {
                    list.add(Long.valueOf(this.zzijy.zzbgm()));
                } while (this.zzijy.zzbgr() < zzbgr2);
                return;
            default:
                throw zzeks.zzbin();
        }
        do {
            list.add(Long.valueOf(this.zzijy.zzbgm()));
            if (!this.zzijy.zzbgq()) {
                zzbga = this.zzijy.zzbga();
            } else {
                return;
            }
        } while (zzbga == this.tag);
        this.zzika = zzbga;
    }

    public final void zzz(List<Integer> list) {
        int zzbga;
        int zzbga2;
        if (list instanceof zzeki) {
            zzeki zzeki = (zzeki) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzeki.zzhg(this.zzijy.zzbgn());
                    if (!this.zzijy.zzbgq()) {
                        zzbga2 = this.zzijy.zzbga();
                    } else {
                        return;
                    }
                } while (zzbga2 == this.tag);
                this.zzika = zzbga2;
            } else if (i == 2) {
                int zzbgr = this.zzijy.zzbgr() + this.zzijy.zzbgj();
                do {
                    zzeki.zzhg(this.zzijy.zzbgn());
                } while (this.zzijy.zzbgr() < zzbgr);
                zzgp(zzbgr);
            } else {
                throw zzeks.zzbin();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzijy.zzbgn()));
                    if (!this.zzijy.zzbgq()) {
                        zzbga = this.zzijy.zzbga();
                    } else {
                        return;
                    }
                } while (zzbga == this.tag);
                this.zzika = zzbga;
            } else if (i2 == 2) {
                int zzbgr2 = this.zzijy.zzbgr() + this.zzijy.zzbgj();
                do {
                    list.add(Integer.valueOf(this.zzijy.zzbgn()));
                } while (this.zzijy.zzbgr() < zzbgr2);
                zzgp(zzbgr2);
            } else {
                throw zzeks.zzbin();
            }
        }
    }
}
