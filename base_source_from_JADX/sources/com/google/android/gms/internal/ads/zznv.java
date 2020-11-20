package com.google.android.gms.internal.ads;

import java.util.Arrays;

public class zznv implements zzoc {
    private final int length;
    private int zzaht;
    private final zzhp[] zzbfm;
    private final zznr zzbgu;
    private final int[] zzbgv;
    private final long[] zzbgw;

    public zznv(zznr zznr, int... iArr) {
        int i = 0;
        zzpc.checkState(iArr.length > 0);
        this.zzbgu = (zznr) zzpc.checkNotNull(zznr);
        this.length = iArr.length;
        this.zzbfm = new zzhp[this.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            this.zzbfm[i2] = zznr.zzbc(iArr[i2]);
        }
        Arrays.sort(this.zzbfm, new zznx());
        this.zzbgv = new int[this.length];
        while (true) {
            int i3 = this.length;
            if (i < i3) {
                this.zzbgv[i] = zznr.zzh(this.zzbfm[i]);
                i++;
            } else {
                this.zzbgw = new long[i3];
                return;
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zznv zznv = (zznv) obj;
            return this.zzbgu == zznv.zzbgu && Arrays.equals(this.zzbgv, zznv.zzbgv);
        }
    }

    public int hashCode() {
        if (this.zzaht == 0) {
            this.zzaht = (System.identityHashCode(this.zzbgu) * 31) + Arrays.hashCode(this.zzbgv);
        }
        return this.zzaht;
    }

    public final int length() {
        return this.zzbgv.length;
    }

    public final zzhp zzbc(int i) {
        return this.zzbfm[i];
    }

    public final int zzbd(int i) {
        return this.zzbgv[0];
    }

    public final zznr zzil() {
        return this.zzbgu;
    }
}
