package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

final class zzbl extends ThreadLocal<ByteBuffer> {
    zzbl(zzbm zzbm) {
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object initialValue() {
        return ByteBuffer.allocate(32);
    }
}
