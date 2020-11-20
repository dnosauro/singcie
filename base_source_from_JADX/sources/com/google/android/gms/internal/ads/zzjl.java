package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

public final class zzjl extends zzji {
    public final zzjh zzany = new zzjh();
    public long zzanz;
    private final int zzaoa = 0;
    public ByteBuffer zzda;

    public zzjl(int i) {
    }

    private final ByteBuffer zzad(int i) {
        ByteBuffer byteBuffer = this.zzda;
        int capacity = byteBuffer == null ? 0 : byteBuffer.capacity();
        StringBuilder sb = new StringBuilder(44);
        sb.append("Buffer too small (");
        sb.append(capacity);
        sb.append(" < ");
        sb.append(i);
        sb.append(")");
        throw new IllegalStateException(sb.toString());
    }

    public final void clear() {
        super.clear();
        ByteBuffer byteBuffer = this.zzda;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
    }

    public final boolean isEncrypted() {
        return zzab(1073741824);
    }

    public final void zzac(int i) {
        ByteBuffer byteBuffer = this.zzda;
        if (byteBuffer == null) {
            this.zzda = zzad(i);
            return;
        }
        int capacity = byteBuffer.capacity();
        int position = this.zzda.position();
        int i2 = i + position;
        if (capacity < i2) {
            ByteBuffer zzad = zzad(i2);
            if (position > 0) {
                this.zzda.position(0);
                this.zzda.limit(position);
                zzad.put(this.zzda);
            }
            this.zzda = zzad;
        }
    }
}
