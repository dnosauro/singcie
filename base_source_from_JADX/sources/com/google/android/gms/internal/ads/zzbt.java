package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

public final class zzbt extends zzeoo {
    private ByteBuffer zzda;

    public zzbt(String str) {
        super(str);
    }

    public final void zzl(ByteBuffer byteBuffer) {
        this.zzda = byteBuffer;
        byteBuffer.position(byteBuffer.position() + byteBuffer.remaining());
    }
}
