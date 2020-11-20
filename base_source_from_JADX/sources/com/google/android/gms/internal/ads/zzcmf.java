package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;

final /* synthetic */ class zzcmf implements zzdyb {
    static final zzdyb zzbon = new zzcmf();

    private zzcmf() {
    }

    public final zzdyz zzf(Object obj) {
        return zzdyr.immediateFailedFuture(((ExecutionException) obj).getCause());
    }
}
