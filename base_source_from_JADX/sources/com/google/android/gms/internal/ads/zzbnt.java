package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;

public final class zzbnt implements zzbtj, zzqu {
    private final zzdmu zzfps;
    private final zzbsl zzfug;
    private final zzbtn zzfuh;
    private final AtomicBoolean zzfui = new AtomicBoolean();
    private final AtomicBoolean zzfuj = new AtomicBoolean();

    public zzbnt(zzdmu zzdmu, zzbsl zzbsl, zzbtn zzbtn) {
        this.zzfps = zzdmu;
        this.zzfug = zzbsl;
        this.zzfuh = zzbtn;
    }

    private final void zzajw() {
        if (this.zzfui.compareAndSet(false, true)) {
            this.zzfug.onAdImpression();
        }
    }

    public final synchronized void onAdLoaded() {
        if (this.zzfps.zzhgq != 1) {
            zzajw();
        }
    }

    public final void zza(zzqv zzqv) {
        if (this.zzfps.zzhgq == 1 && zzqv.zzbqz) {
            zzajw();
        }
        if (zzqv.zzbqz && this.zzfuj.compareAndSet(false, true)) {
            this.zzfuh.zzakz();
        }
    }
}
