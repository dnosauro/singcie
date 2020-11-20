package com.google.android.gms.internal.ads;

import android.os.Handler;

public final class zzik {
    private final Handler handler;
    /* access modifiers changed from: private */
    public final zzih zzajc;

    public zzik(Handler handler2, zzih zzih) {
        this.handler = zzih != null ? (Handler) zzpc.checkNotNull(handler2) : null;
        this.zzajc = zzih;
    }

    public final void zzb(int i, long j, long j2) {
        if (this.zzajc != null) {
            this.handler.post(new zzio(this, i, j, j2));
        }
    }

    public final void zzb(String str, long j, long j2) {
        if (this.zzajc != null) {
            this.handler.post(new zzim(this, str, j, j2));
        }
    }

    public final void zzc(zzhp zzhp) {
        if (this.zzajc != null) {
            this.handler.post(new zzil(this, zzhp));
        }
    }

    public final void zzc(zzjm zzjm) {
        if (this.zzajc != null) {
            this.handler.post(new zzij(this, zzjm));
        }
    }

    public final void zzd(zzjm zzjm) {
        if (this.zzajc != null) {
            this.handler.post(new zzin(this, zzjm));
        }
    }

    public final void zzx(int i) {
        if (this.zzajc != null) {
            this.handler.post(new zziq(this, i));
        }
    }
}
