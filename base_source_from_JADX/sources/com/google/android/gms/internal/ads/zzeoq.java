package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

public abstract class zzeoq extends zzeoo implements zzbp {
    private int flags;
    private int version;

    protected zzeoq(String str) {
        super(str);
    }

    public final int getVersion() {
        if (!this.zzixx) {
            zzblq();
        }
        return this.version;
    }

    /* access modifiers changed from: protected */
    public final long zzr(ByteBuffer byteBuffer) {
        this.version = zzbq.zza(byteBuffer.get());
        this.flags = (zzbq.zzg(byteBuffer) << 8) + 0 + zzbq.zza(byteBuffer.get());
        return 4;
    }
}
