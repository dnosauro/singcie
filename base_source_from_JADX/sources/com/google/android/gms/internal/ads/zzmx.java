package com.google.android.gms.internal.ads;

final class zzmx implements zznn {
    /* access modifiers changed from: private */
    public final int track;
    private final /* synthetic */ zzmo zzbei;

    public zzmx(zzmo zzmo, int i) {
        this.zzbei = zzmo;
        this.track = i;
    }

    public final boolean isReady() {
        return this.zzbei.zzaz(this.track);
    }

    public final int zzb(zzhr zzhr, zzjl zzjl, boolean z) {
        return this.zzbei.zza(this.track, zzhr, zzjl, z);
    }

    public final void zzeh(long j) {
        this.zzbei.zze(this.track, j);
    }

    public final void zzhs() {
        this.zzbei.zzhs();
    }
}
