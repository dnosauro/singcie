package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zznr {
    public final int length;
    private int zzaht;
    private final zzhp[] zzbfm;

    public zznr(zzhp... zzhpArr) {
        zzpc.checkState(zzhpArr.length > 0);
        this.zzbfm = zzhpArr;
        this.length = zzhpArr.length;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zznr zznr = (zznr) obj;
            return this.length == zznr.length && Arrays.equals(this.zzbfm, zznr.zzbfm);
        }
    }

    public final int hashCode() {
        if (this.zzaht == 0) {
            this.zzaht = Arrays.hashCode(this.zzbfm) + 527;
        }
        return this.zzaht;
    }

    public final zzhp zzbc(int i) {
        return this.zzbfm[i];
    }

    public final int zzh(zzhp zzhp) {
        int i = 0;
        while (true) {
            zzhp[] zzhpArr = this.zzbfm;
            if (i >= zzhpArr.length) {
                return -1;
            }
            if (zzhp == zzhpArr[i]) {
                return i;
            }
            i++;
        }
    }
}
