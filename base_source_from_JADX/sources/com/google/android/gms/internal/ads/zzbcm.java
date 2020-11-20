package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

final class zzbcm implements zzeor {
    private final ByteBuffer zzamk;

    zzbcm(ByteBuffer byteBuffer) {
        this.zzamk = byteBuffer.duplicate();
    }

    public final void close() {
    }

    public final long position() {
        return (long) this.zzamk.position();
    }

    public final int read(ByteBuffer byteBuffer) {
        if (this.zzamk.remaining() == 0 && byteBuffer.remaining() > 0) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), this.zzamk.remaining());
        byte[] bArr = new byte[min];
        this.zzamk.get(bArr);
        byteBuffer.put(bArr);
        return min;
    }

    public final long size() {
        return (long) this.zzamk.limit();
    }

    public final void zzfc(long j) {
        this.zzamk.position((int) j);
    }

    public final ByteBuffer zzh(long j, long j2) {
        int position = this.zzamk.position();
        this.zzamk.position((int) j);
        ByteBuffer slice = this.zzamk.slice();
        slice.limit((int) j2);
        this.zzamk.position(position);
        return slice;
    }
}
