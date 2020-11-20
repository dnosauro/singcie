package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

final class zzcq extends ContentObserver {
    private final /* synthetic */ zzco zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzcq(zzco zzco, Handler handler) {
        super((Handler) null);
        this.zza = zzco;
    }

    public final void onChange(boolean z) {
        this.zza.zzb();
    }
}
