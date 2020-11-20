package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;

public final class zzok implements zzon {
    private final byte[] data;
    private Uri uri;
    private int zzbhy;
    private int zzbhz;

    public zzok(byte[] bArr) {
        zzpc.checkNotNull(bArr);
        zzpc.checkArgument(bArr.length > 0);
        this.data = bArr;
    }

    public final void close() {
        this.uri = null;
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final int read(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        int i3 = this.zzbhz;
        if (i3 == 0) {
            return -1;
        }
        int min = Math.min(i2, i3);
        System.arraycopy(this.data, this.zzbhy, bArr, i, min);
        this.zzbhy += min;
        this.zzbhz -= min;
        return min;
    }

    public final long zza(zzoo zzoo) {
        this.uri = zzoo.uri;
        this.zzbhy = (int) zzoo.position;
        this.zzbhz = (int) (zzoo.zzcm == -1 ? ((long) this.data.length) - zzoo.position : zzoo.zzcm);
        int i = this.zzbhz;
        if (i > 0 && this.zzbhy + i <= this.data.length) {
            return (long) i;
        }
        int i2 = this.zzbhy;
        long j = zzoo.zzcm;
        int length = this.data.length;
        StringBuilder sb = new StringBuilder(77);
        sb.append("Unsatisfiable range: [");
        sb.append(i2);
        sb.append(", ");
        sb.append(j);
        sb.append("], length: ");
        sb.append(length);
        throw new IOException(sb.toString());
    }
}
