package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public interface zzif {
    public static final ByteBuffer zzaiw = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    void flush();

    boolean isActive();

    void reset();

    boolean zzb(int i, int i2, int i3);

    boolean zzfe();

    int zzfj();

    int zzfk();

    void zzfl();

    ByteBuffer zzfm();

    void zzn(ByteBuffer byteBuffer);
}
