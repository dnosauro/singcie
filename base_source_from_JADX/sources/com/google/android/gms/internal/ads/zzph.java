package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzph {
    private int size;
    private long[] zzbjt;

    public zzph() {
        this(32);
    }

    private zzph(int i) {
        this.zzbjt = new long[32];
    }

    public final void add(long j) {
        int i = this.size;
        long[] jArr = this.zzbjt;
        if (i == jArr.length) {
            this.zzbjt = Arrays.copyOf(jArr, i << 1);
        }
        long[] jArr2 = this.zzbjt;
        int i2 = this.size;
        this.size = i2 + 1;
        jArr2[i2] = j;
    }

    public final long get(int i) {
        if (i >= 0 && i < this.size) {
            return this.zzbjt[i];
        }
        int i2 = this.size;
        StringBuilder sb = new StringBuilder(46);
        sb.append("Invalid index ");
        sb.append(i);
        sb.append(", size is ");
        sb.append(i2);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public final int size() {
        return this.size;
    }
}
