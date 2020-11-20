package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import java.util.Arrays;

@TargetApi(21)
public final class zzig {
    private static final zzig zzaix = new zzig(new int[]{2}, 2);
    private final int[] zzaiy;
    private final int zzaiz = 2;

    private zzig(int[] iArr, int i) {
        this.zzaiy = Arrays.copyOf(iArr, iArr.length);
        Arrays.sort(this.zzaiy);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzig)) {
            return false;
        }
        zzig zzig = (zzig) obj;
        return Arrays.equals(this.zzaiy, zzig.zzaiy) && this.zzaiz == zzig.zzaiz;
    }

    public final int hashCode() {
        return this.zzaiz + (Arrays.hashCode(this.zzaiy) * 31);
    }

    public final String toString() {
        int i = this.zzaiz;
        String arrays = Arrays.toString(this.zzaiy);
        StringBuilder sb = new StringBuilder(String.valueOf(arrays).length() + 67);
        sb.append("AudioCapabilities[maxChannelCount=");
        sb.append(i);
        sb.append(", supportedEncodings=");
        sb.append(arrays);
        sb.append("]");
        return sb.toString();
    }
}
