package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

final class zzja implements zzif {
    private int zzahk = -1;
    private ByteBuffer zzald = zzaiw;
    private int zzamg = -1;
    private int[] zzamh;
    private boolean zzami;
    private int[] zzamj;
    private ByteBuffer zzamk = zzaiw;
    private boolean zzaml;

    public final void flush() {
        this.zzald = zzaiw;
        this.zzaml = false;
    }

    public final boolean isActive() {
        return this.zzami;
    }

    public final void reset() {
        flush();
        this.zzamk = zzaiw;
        this.zzahk = -1;
        this.zzamg = -1;
        this.zzamj = null;
        this.zzami = false;
    }

    public final void zzb(int[] iArr) {
        this.zzamh = iArr;
    }

    public final boolean zzb(int i, int i2, int i3) {
        boolean z = !Arrays.equals(this.zzamh, this.zzamj);
        this.zzamj = this.zzamh;
        if (this.zzamj == null) {
            this.zzami = false;
            return z;
        } else if (i3 != 2) {
            throw new zzii(i, i2, i3);
        } else if (!z && this.zzamg == i && this.zzahk == i2) {
            return false;
        } else {
            this.zzamg = i;
            this.zzahk = i2;
            this.zzami = i2 != this.zzamj.length;
            int i4 = 0;
            while (true) {
                int[] iArr = this.zzamj;
                if (i4 >= iArr.length) {
                    return true;
                }
                int i5 = iArr[i4];
                if (i5 < i2) {
                    this.zzami = (i5 != i4) | this.zzami;
                    i4++;
                } else {
                    throw new zzii(i, i2, i3);
                }
            }
        }
    }

    public final boolean zzfe() {
        return this.zzaml && this.zzald == zzaiw;
    }

    public final int zzfj() {
        int[] iArr = this.zzamj;
        return iArr == null ? this.zzahk : iArr.length;
    }

    public final int zzfk() {
        return 2;
    }

    public final void zzfl() {
        this.zzaml = true;
    }

    public final ByteBuffer zzfm() {
        ByteBuffer byteBuffer = this.zzald;
        this.zzald = zzaiw;
        return byteBuffer;
    }

    public final void zzn(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int length = (((limit - position) / (this.zzahk * 2)) * this.zzamj.length) << 1;
        if (this.zzamk.capacity() < length) {
            this.zzamk = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
        } else {
            this.zzamk.clear();
        }
        while (position < limit) {
            for (int i : this.zzamj) {
                this.zzamk.putShort(byteBuffer.getShort((i * 2) + position));
            }
            position += this.zzahk << 1;
        }
        byteBuffer.position(limit);
        this.zzamk.flip();
        this.zzald = this.zzamk;
    }
}
