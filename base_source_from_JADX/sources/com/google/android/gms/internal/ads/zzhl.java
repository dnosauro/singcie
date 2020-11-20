package com.google.android.gms.internal.ads;

import android.util.Log;

final class zzhl {
    public final int index;
    private final zzhy[] zzaeo;
    private final zzoh zzaep;
    public final zzmy zzafl;
    public final Object zzafm;
    public final zznn[] zzafn;
    private final boolean[] zzafo;
    public final long zzafp;
    public int zzafq;
    public long zzafr;
    public boolean zzafs;
    public boolean zzaft;
    public boolean zzafu;
    public zzhl zzafv;
    public zzoj zzafw;
    private final zzhx[] zzafx;
    private final zzht zzafy;
    private final zzna zzafz;
    private zzoj zzaga;

    public zzhl(zzhy[] zzhyArr, zzhx[] zzhxArr, long j, zzoh zzoh, zzht zzht, zzna zzna, Object obj, int i, int i2, boolean z, long j2) {
        this.zzaeo = zzhyArr;
        this.zzafx = zzhxArr;
        this.zzafp = j;
        this.zzaep = zzoh;
        this.zzafy = zzht;
        this.zzafz = zzna;
        this.zzafm = zzpc.checkNotNull(obj);
        this.index = i;
        this.zzafq = i2;
        this.zzafs = z;
        this.zzafr = j2;
        this.zzafn = new zznn[zzhyArr.length];
        this.zzafo = new boolean[zzhyArr.length];
        this.zzafl = zzna.zza(i2, zzht.zzfd());
    }

    public final void release() {
        try {
            this.zzafz.zzb(this.zzafl);
        } catch (RuntimeException e) {
            Log.e("ExoPlayerImplInternal", "Period release failed.", e);
        }
    }

    public final long zza(long j, boolean z, boolean[] zArr) {
        zzoe zzoe = this.zzafw.zzbhv;
        int i = 0;
        while (true) {
            boolean z2 = true;
            if (i >= zzoe.length) {
                break;
            }
            boolean[] zArr2 = this.zzafo;
            if (z || !this.zzafw.zza(this.zzaga, i)) {
                z2 = false;
            }
            zArr2[i] = z2;
            i++;
        }
        long zza = this.zzafl.zza(zzoe.zzim(), this.zzafo, this.zzafn, zArr, j);
        this.zzaga = this.zzafw;
        this.zzafu = false;
        int i2 = 0;
        while (true) {
            zznn[] zznnArr = this.zzafn;
            if (i2 < zznnArr.length) {
                if (zznnArr[i2] != null) {
                    zzpc.checkState(zzoe.zzbe(i2) != null);
                    this.zzafu = true;
                } else {
                    zzpc.checkState(zzoe.zzbe(i2) == null);
                }
                i2++;
            } else {
                this.zzafy.zza(this.zzaeo, this.zzafw.zzbhu, zzoe);
                return zza;
            }
        }
    }

    public final long zzb(long j, boolean z) {
        return zza(j, false, new boolean[this.zzaeo.length]);
    }

    public final void zzc(int i, boolean z) {
        this.zzafq = i;
        this.zzafs = z;
    }

    public final long zzep() {
        return this.zzafp - this.zzafr;
    }

    public final boolean zzeq() {
        if (this.zzaft) {
            return !this.zzafu || this.zzafl.zzhr() == Long.MIN_VALUE;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzer() {
        /*
            r6 = this;
            com.google.android.gms.internal.ads.zzoh r0 = r6.zzaep
            com.google.android.gms.internal.ads.zzhx[] r1 = r6.zzafx
            com.google.android.gms.internal.ads.zzmy r2 = r6.zzafl
            com.google.android.gms.internal.ads.zznq r2 = r2.zzho()
            com.google.android.gms.internal.ads.zzoj r0 = r0.zza(r1, r2)
            com.google.android.gms.internal.ads.zzoj r1 = r6.zzaga
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x0016
        L_0x0014:
            r1 = 0
            goto L_0x0028
        L_0x0016:
            r4 = 0
        L_0x0017:
            com.google.android.gms.internal.ads.zzoe r5 = r0.zzbhv
            int r5 = r5.length
            if (r4 >= r5) goto L_0x0027
            boolean r5 = r0.zza(r1, r4)
            if (r5 != 0) goto L_0x0024
            goto L_0x0014
        L_0x0024:
            int r4 = r4 + 1
            goto L_0x0017
        L_0x0027:
            r1 = 1
        L_0x0028:
            if (r1 == 0) goto L_0x002b
            return r3
        L_0x002b:
            r6.zzafw = r0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhl.zzer():boolean");
    }
}
