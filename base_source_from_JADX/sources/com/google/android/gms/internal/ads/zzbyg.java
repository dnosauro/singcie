package com.google.android.gms.internal.ads;

import java.util.List;

public final class zzbyg implements zzbyd {
    private final List<String> zzdup;
    private final zzdrz zzfqa;
    private boolean zzfzn;

    public zzbyg(zzdmu zzdmu, zzdrz zzdrz) {
        this.zzdup = zzdmu.zzdup;
        this.zzfqa = zzdrz;
    }

    public final void zzalx() {
        if (!this.zzfzn) {
            this.zzfqa.zzj(this.zzdup);
            this.zzfzn = true;
        }
    }
}
