package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;

final class zzazp implements zzdyo<Object> {
    private final /* synthetic */ String zzegy;

    zzazp(String str) {
        this.zzegy = str;
    }

    public final void onSuccess(Object obj) {
    }

    public final void zzb(Throwable th) {
        zzp.zzku().zza(th, this.zzegy);
    }
}
