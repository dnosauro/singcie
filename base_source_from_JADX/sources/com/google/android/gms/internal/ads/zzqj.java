package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.view.Surface;

public final class zzqj {
    private final Handler handler;
    /* access modifiers changed from: private */
    public final zzqg zzbmx;

    public zzqj(Handler handler2, zzqg zzqg) {
        this.handler = zzqg != null ? (Handler) zzpc.checkNotNull(handler2) : null;
        this.zzbmx = zzqg;
    }

    public final void zzb(int i, int i2, int i3, float f) {
        if (this.zzbmx != null) {
            this.handler.post(new zzqm(this, i, i2, i3, f));
        }
    }

    public final void zzb(Surface surface) {
        if (this.zzbmx != null) {
            this.handler.post(new zzqp(this, surface));
        }
    }

    public final void zzb(String str, long j, long j2) {
        if (this.zzbmx != null) {
            this.handler.post(new zzql(this, str, j, j2));
        }
    }

    public final void zzc(zzhp zzhp) {
        if (this.zzbmx != null) {
            this.handler.post(new zzqk(this, zzhp));
        }
    }

    public final void zzc(zzjm zzjm) {
        if (this.zzbmx != null) {
            this.handler.post(new zzqi(this, zzjm));
        }
    }

    public final void zzd(zzjm zzjm) {
        if (this.zzbmx != null) {
            this.handler.post(new zzqo(this, zzjm));
        }
    }

    public final void zzg(int i, long j) {
        if (this.zzbmx != null) {
            this.handler.post(new zzqn(this, i, j));
        }
    }
}
