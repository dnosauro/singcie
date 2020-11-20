package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;

final /* synthetic */ class zzcoj implements zzdyb {
    static final zzdyb zzbon = new zzcoj();

    private zzcoj() {
    }

    public final zzdyz zzf(Object obj) {
        return zzdyr.immediateFailedFuture(((ExecutionException) obj).getCause());
    }
}
