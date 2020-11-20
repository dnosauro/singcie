package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.os.Handler;

@TargetApi(23)
final class zzqf implements MediaCodec.OnFrameRenderedListener {
    private final /* synthetic */ zzqa zzbmq;

    private zzqf(zzqa zzqa, MediaCodec mediaCodec) {
        this.zzbmq = zzqa;
        mediaCodec.setOnFrameRenderedListener(this, new Handler());
    }

    public final void onFrameRendered(MediaCodec mediaCodec, long j, long j2) {
        if (this == this.zzbmq.zzbmb) {
            this.zzbmq.zzjk();
        }
    }
}
