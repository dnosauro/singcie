package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zznq {
    public static final zznq zzbgs = new zznq(new zznr[0]);
    public final int length;
    private int zzaht;
    private final zznr[] zzbgt;

    public zznq(zznr... zznrArr) {
        this.zzbgt = zznrArr;
        this.length = zznrArr.length;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zznq zznq = (zznq) obj;
            return this.length == zznq.length && Arrays.equals(this.zzbgt, zznq.zzbgt);
        }
    }

    public final int hashCode() {
        if (this.zzaht == 0) {
            this.zzaht = Arrays.hashCode(this.zzbgt);
        }
        return this.zzaht;
    }

    public final int zza(zznr zznr) {
        for (int i = 0; i < this.length; i++) {
            if (this.zzbgt[i] == zznr) {
                return i;
            }
        }
        return -1;
    }

    public final zznr zzbb(int i) {
        return this.zzbgt[i];
    }
}
