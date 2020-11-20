package com.google.android.gms.internal.ads;

final /* synthetic */ class zzcic implements zzbfj {
    private final zzazq zzbvq;

    zzcic(zzazq zzazq) {
        this.zzbvq = zzazq;
    }

    public final void zzai(boolean z) {
        zzazq zzazq = this.zzbvq;
        if (z) {
            zzazq.set(null);
        } else {
            zzazq.setException(new Exception("Ad Web View failed to load."));
        }
    }
}
