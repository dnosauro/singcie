package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzbpd implements zzdyo<Void> {
    private final /* synthetic */ zzboz zzfvy;

    zzbpd(zzboz zzboz) {
        this.zzfvy = zzboz;
    }

    public final /* synthetic */ void onSuccess(@NullableDecl Object obj) {
        Void voidR = (Void) obj;
        this.zzfvy.zzfvp.zzbg(true);
    }

    public final void zzb(Throwable th) {
        this.zzfvy.zzfvp.zzbg(false);
    }
}
