package com.google.android.gms.internal.ads;

public final class zzju implements zzkf {
    private final int length;
    private final long zzaif;
    private final int[] zzaol;
    private final long[] zzaom;
    private final long[] zzaon;
    private final long[] zzaoo;

    public zzju(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.zzaol = iArr;
        this.zzaom = jArr;
        this.zzaon = jArr2;
        this.zzaoo = jArr3;
        this.length = iArr.length;
        int i = this.length;
        if (i > 0) {
            this.zzaif = jArr2[i - 1] + jArr3[i - 1];
        } else {
            this.zzaif = 0;
        }
    }

    public final long getDurationUs() {
        return this.zzaif;
    }

    public final boolean isSeekable() {
        return true;
    }

    public final long zzdz(long j) {
        return this.zzaom[zzpt.zza(this.zzaoo, j, true, true)];
    }
}
