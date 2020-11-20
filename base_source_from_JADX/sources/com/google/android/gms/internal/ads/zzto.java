package com.google.android.gms.internal.ads;

import java.io.InputStream;
import java.io.PushbackInputStream;

final class zzto extends PushbackInputStream {
    private final /* synthetic */ zztn zzbvp;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzto(zztn zztn, InputStream inputStream, int i) {
        super(inputStream, 1);
        this.zzbvp = zztn;
    }

    public final synchronized void close() {
        this.zzbvp.zzbvh.disconnect();
        super.close();
    }
}
