package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzdjz implements zzdyo<Void> {
    zzdjz(zzdju zzdju) {
    }

    public final /* synthetic */ void onSuccess(@NullableDecl Object obj) {
        Void voidR = (Void) obj;
        zzd.zzee("Notification of cache hit successful.");
    }

    public final void zzb(Throwable th) {
        zzd.zzee("Notification of cache hit failed.");
    }
}
