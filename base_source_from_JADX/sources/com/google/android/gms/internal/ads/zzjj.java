package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;

@TargetApi(24)
final class zzjj {
    private final MediaCodec.CryptoInfo zzanv;
    private final MediaCodec.CryptoInfo.Pattern zzanx;

    private zzjj(MediaCodec.CryptoInfo cryptoInfo) {
        this.zzanv = cryptoInfo;
        this.zzanx = new MediaCodec.CryptoInfo.Pattern(0, 0);
    }

    /* access modifiers changed from: private */
    public final void set(int i, int i2) {
        this.zzanx.set(0, 0);
        this.zzanv.setPattern(this.zzanx);
    }
}
