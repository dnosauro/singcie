package com.google.android.gms.internal.ads;

final class zztk extends zzazq<zztt> {
    private final /* synthetic */ zztl zzbvh;

    zztk(zztl zztl) {
        this.zzbvh = zztl;
    }

    public final boolean cancel(boolean z) {
        this.zzbvh.disconnect();
        return super.cancel(z);
    }
}
