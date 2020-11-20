package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Arrays;

public final class zzoo {
    public final int flags;
    public final long position;
    public final Uri uri;
    public final byte[] zzbia;
    public final long zzbib;
    public final String zzck;
    public final long zzcm;

    public zzoo(Uri uri2) {
        this(uri2, 0);
    }

    private zzoo(Uri uri2, int i) {
        this(uri2, 0, -1, (String) null, 0);
    }

    private zzoo(Uri uri2, long j, long j2, long j3, String str, int i) {
        this(uri2, (byte[]) null, j, j2, j3, str, 0);
    }

    public zzoo(Uri uri2, long j, long j2, String str) {
        this(uri2, j, j, j2, str, 0);
    }

    private zzoo(Uri uri2, long j, long j2, String str, int i) {
        this(uri2, 0, 0, -1, (String) null, 0);
    }

    public zzoo(Uri uri2, byte[] bArr, long j, long j2, long j3, String str, int i) {
        boolean z = true;
        zzpc.checkArgument(j >= 0);
        zzpc.checkArgument(j2 >= 0);
        if (j3 <= 0 && j3 != -1) {
            z = false;
        }
        zzpc.checkArgument(z);
        this.uri = uri2;
        this.zzbia = bArr;
        this.zzbib = j;
        this.position = j2;
        this.zzcm = j3;
        this.zzck = str;
        this.flags = i;
    }

    public final boolean isFlagSet(int i) {
        return (this.flags & 1) == 1;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.uri);
        String arrays = Arrays.toString(this.zzbia);
        long j = this.zzbib;
        long j2 = this.position;
        long j3 = this.zzcm;
        String str = this.zzck;
        int i = this.flags;
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 93 + String.valueOf(arrays).length() + String.valueOf(str).length());
        sb.append("DataSpec[");
        sb.append(valueOf);
        sb.append(", ");
        sb.append(arrays);
        sb.append(", ");
        sb.append(j);
        sb.append(", ");
        sb.append(j2);
        sb.append(", ");
        sb.append(j3);
        sb.append(", ");
        sb.append(str);
        sb.append(", ");
        sb.append(i);
        sb.append("]");
        return sb.toString();
    }
}
