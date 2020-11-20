package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzbpe implements zzdyo<zzatl> {
    private final /* synthetic */ zzboz zzfvy;

    zzbpe(zzboz zzboz) {
        this.zzfvy = zzboz;
    }

    public final /* synthetic */ void onSuccess(@NullableDecl Object obj) {
        zzatl zzatl = (zzatl) obj;
        this.zzfvy.zzfvp.zzbf(true);
    }

    public final void zzb(Throwable th) {
        this.zzfvy.zzfvp.zzbf(false);
    }
}
