package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzbqw implements zzdyo<Boolean> {
    private final /* synthetic */ zzbqu zzfwu;

    zzbqw(zzbqu zzbqu) {
        this.zzfwu = zzbqu;
    }

    public final /* synthetic */ void onSuccess(@NullableDecl Object obj) {
        Boolean bool = (Boolean) obj;
        this.zzfwu.zzfwm.onAdImpression();
    }

    public final void zzb(Throwable th) {
    }
}
