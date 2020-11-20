package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import com.google.android.gms.ads.internal.util.zzm;
import java.util.concurrent.TimeUnit;

@TargetApi(14)
public final class zzbaz {
    private final long zzejh = TimeUnit.MILLISECONDS.toNanos(((Long) zzwq.zzqe().zzd(zzabf.zzcmo)).longValue());
    private long zzeji;
    private boolean zzejj = true;

    zzbaz() {
    }

    public final void zza(SurfaceTexture surfaceTexture, zzbam zzbam) {
        if (zzbam != null) {
            long timestamp = surfaceTexture.getTimestamp();
            if (this.zzejj || Math.abs(timestamp - this.zzeji) >= this.zzejh) {
                this.zzejj = false;
                this.zzeji = timestamp;
                zzm.zzedd.post(new zzbay(this, zzbam));
            }
        }
    }

    public final void zzzs() {
        this.zzejj = true;
    }
}
