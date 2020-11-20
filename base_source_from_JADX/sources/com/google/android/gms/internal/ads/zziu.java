package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.AudioTimestamp;
import android.media.AudioTrack;

@TargetApi(19)
final class zziu extends zzir {
    private final AudioTimestamp zzalx = new AudioTimestamp();
    private long zzaly;
    private long zzalz;
    private long zzama;

    public zziu() {
        super((zzis) null);
    }

    public final void zza(AudioTrack audioTrack, boolean z) {
        super.zza(audioTrack, z);
        this.zzaly = 0;
        this.zzalz = 0;
        this.zzama = 0;
    }

    public final boolean zzga() {
        boolean timestamp = this.zzajw.getTimestamp(this.zzalx);
        if (timestamp) {
            long j = this.zzalx.framePosition;
            if (this.zzalz > j) {
                this.zzaly++;
            }
            this.zzalz = j;
            this.zzama = j + (this.zzaly << 32);
        }
        return timestamp;
    }

    public final long zzgb() {
        return this.zzalx.nanoTime;
    }

    public final long zzgc() {
        return this.zzama;
    }
}
