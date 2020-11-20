package com.google.android.gms.internal.ads;

import android.net.Uri;

final class zzbcn implements zzon {
    private Uri uri;
    private final zzon zzens;
    private final long zzent;
    private final zzon zzenu;
    private long zzenv;

    zzbcn(zzon zzon, int i, zzon zzon2) {
        this.zzens = zzon;
        this.zzent = (long) i;
        this.zzenu = zzon2;
    }

    public final void close() {
        this.zzens.close();
        this.zzenu.close();
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final int read(byte[] bArr, int i, int i2) {
        int i3;
        long j = this.zzenv;
        long j2 = this.zzent;
        if (j < j2) {
            i3 = this.zzens.read(bArr, i, (int) Math.min((long) i2, j2 - j));
            this.zzenv += (long) i3;
        } else {
            i3 = 0;
        }
        if (this.zzenv < this.zzent) {
            return i3;
        }
        int read = this.zzenu.read(bArr, i + i3, i2 - i3);
        int i4 = i3 + read;
        this.zzenv += (long) read;
        return i4;
    }

    public final long zza(zzoo zzoo) {
        zzoo zzoo2;
        zzoo zzoo3;
        zzoo zzoo4 = zzoo;
        this.uri = zzoo4.uri;
        if (zzoo4.position >= this.zzent) {
            zzoo2 = null;
        } else {
            long j = zzoo4.position;
            zzoo2 = new zzoo(zzoo4.uri, j, zzoo4.zzcm != -1 ? Math.min(zzoo4.zzcm, this.zzent - j) : this.zzent - j, (String) null);
        }
        if (zzoo4.zzcm == -1 || zzoo4.position + zzoo4.zzcm > this.zzent) {
            zzoo3 = new zzoo(zzoo4.uri, Math.max(this.zzent, zzoo4.position), zzoo4.zzcm != -1 ? Math.min(zzoo4.zzcm, (zzoo4.position + zzoo4.zzcm) - this.zzent) : -1, (String) null);
        } else {
            zzoo3 = null;
        }
        long j2 = 0;
        long zza = zzoo2 != null ? this.zzens.zza(zzoo2) : 0;
        if (zzoo3 != null) {
            j2 = this.zzenu.zza(zzoo3);
        }
        this.zzenv = zzoo4.position;
        if (zza == -1 || j2 == -1) {
            return -1;
        }
        return zza + j2;
    }
}
