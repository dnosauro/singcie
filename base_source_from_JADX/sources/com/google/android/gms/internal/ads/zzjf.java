package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

public final class zzjf implements zzif {
    private int zzahk = -1;
    private float zzahy = 1.0f;
    private float zzahz = 1.0f;
    private ByteBuffer zzald = zzaiw;
    private int zzamg = -1;
    private ByteBuffer zzamk = zzaiw;
    private boolean zzaml;
    private zzjg zzamu;
    private ShortBuffer zzamv = this.zzamk.asShortBuffer();
    private long zzamw;
    private long zzamx;

    public final void flush() {
        this.zzamu = new zzjg(this.zzamg, this.zzahk);
        this.zzamu.setSpeed(this.zzahy);
        this.zzamu.zzc(this.zzahz);
        this.zzald = zzaiw;
        this.zzamw = 0;
        this.zzamx = 0;
        this.zzaml = false;
    }

    public final boolean isActive() {
        return Math.abs(this.zzahy - 1.0f) >= 0.01f || Math.abs(this.zzahz - 1.0f) >= 0.01f;
    }

    public final void reset() {
        this.zzamu = null;
        this.zzamk = zzaiw;
        this.zzamv = this.zzamk.asShortBuffer();
        this.zzald = zzaiw;
        this.zzahk = -1;
        this.zzamg = -1;
        this.zzamw = 0;
        this.zzamx = 0;
        this.zzaml = false;
    }

    public final float zza(float f) {
        this.zzahy = zzpt.zza(f, 0.1f, 8.0f);
        return this.zzahy;
    }

    public final float zzb(float f) {
        this.zzahz = zzpt.zza(f, 0.1f, 8.0f);
        return f;
    }

    public final boolean zzb(int i, int i2, int i3) {
        if (i3 != 2) {
            throw new zzii(i, i2, i3);
        } else if (this.zzamg == i && this.zzahk == i2) {
            return false;
        } else {
            this.zzamg = i;
            this.zzahk = i2;
            return true;
        }
    }

    public final boolean zzfe() {
        if (!this.zzaml) {
            return false;
        }
        zzjg zzjg = this.zzamu;
        return zzjg == null || zzjg.zzgh() == 0;
    }

    public final int zzfj() {
        return this.zzahk;
    }

    public final int zzfk() {
        return 2;
    }

    public final void zzfl() {
        this.zzamu.zzfl();
        this.zzaml = true;
    }

    public final ByteBuffer zzfm() {
        ByteBuffer byteBuffer = this.zzald;
        this.zzald = zzaiw;
        return byteBuffer;
    }

    public final long zzgf() {
        return this.zzamw;
    }

    public final long zzgg() {
        return this.zzamx;
    }

    public final void zzn(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.zzamw += (long) remaining;
            this.zzamu.zza(asShortBuffer);
            byteBuffer.position(byteBuffer.position() + remaining);
        }
        int zzgh = (this.zzamu.zzgh() * this.zzahk) << 1;
        if (zzgh > 0) {
            if (this.zzamk.capacity() < zzgh) {
                this.zzamk = ByteBuffer.allocateDirect(zzgh).order(ByteOrder.nativeOrder());
                this.zzamv = this.zzamk.asShortBuffer();
            } else {
                this.zzamk.clear();
                this.zzamv.clear();
            }
            this.zzamu.zzb(this.zzamv);
            this.zzamx += (long) zzgh;
            this.zzamk.limit(zzgh);
            this.zzald = this.zzamk;
        }
    }
}
