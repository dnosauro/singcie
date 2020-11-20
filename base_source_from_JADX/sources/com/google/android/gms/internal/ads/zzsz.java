package com.google.android.gms.internal.ads;

final class zzsz implements zzrl {
    private final /* synthetic */ zzsx zzbup;

    zzsz(zzsx zzsx) {
        this.zzbup = zzsx;
    }

    public final void zzp(boolean z) {
        if (z) {
            this.zzbup.connect();
        } else {
            this.zzbup.disconnect();
        }
    }
}
