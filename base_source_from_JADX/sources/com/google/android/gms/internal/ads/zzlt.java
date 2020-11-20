package com.google.android.gms.internal.ads;

final class zzlt {
    public final int[] zzaol;
    public final long[] zzaom;
    public final int zzaxa;
    public final int zzaxg;
    public final int[] zzaxi;
    public final long[] zzbbf;

    public zzlt(long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2) {
        boolean z = true;
        zzpc.checkArgument(iArr.length == jArr2.length);
        zzpc.checkArgument(jArr.length == jArr2.length);
        zzpc.checkArgument(iArr2.length != jArr2.length ? false : z);
        this.zzaom = jArr;
        this.zzaol = iArr;
        this.zzaxg = i;
        this.zzbbf = jArr2;
        this.zzaxi = iArr2;
        this.zzaxa = jArr.length;
    }

    public final int zzec(long j) {
        for (int zza = zzpt.zza(this.zzbbf, j, true, false); zza >= 0; zza--) {
            if ((this.zzaxi[zza] & 1) != 0) {
                return zza;
            }
        }
        return -1;
    }

    public final int zzed(long j) {
        for (int zzb = zzpt.zzb(this.zzbbf, j, true, false); zzb < this.zzbbf.length; zzb++) {
            if ((this.zzaxi[zzb] & 1) != 0) {
                return zzb;
            }
        }
        return -1;
    }
}
