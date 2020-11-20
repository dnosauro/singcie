package com.google.android.gms.internal.ads;

public final class zzry {
    final long value;
    final int zzbts;
    final String zzbtz;

    zzry(long j, String str, int i) {
        this.value = j;
        this.zzbtz = str;
        this.zzbts = i;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zzry)) {
            zzry zzry = (zzry) obj;
            return zzry.value == this.value && zzry.zzbts == this.zzbts;
        }
    }

    public final int hashCode() {
        return (int) this.value;
    }
}
