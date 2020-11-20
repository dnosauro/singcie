package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;

public final class zzfr extends zzgl {
    private long startTime;

    public zzfr(zzfa zzfa, String str, String str2, zzcf.zza.C3704zza zza, long j, int i, int i2) {
        super(zzfa, str, str2, zza, i, 25);
        this.startTime = j;
    }

    /* access modifiers changed from: protected */
    public final void zzcw() {
        long longValue = ((Long) this.zzabi.invoke((Object) null, new Object[0])).longValue();
        synchronized (this.zzaay) {
            this.zzaay.zzak(longValue);
            if (this.startTime != 0) {
                this.zzaay.zzm(longValue - this.startTime);
                this.zzaay.zzp(this.startTime);
            }
        }
    }
}
