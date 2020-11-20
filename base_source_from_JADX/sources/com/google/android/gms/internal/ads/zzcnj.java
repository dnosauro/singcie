package com.google.android.gms.internal.ads;

import java.util.concurrent.TimeoutException;

final /* synthetic */ class zzcnj implements zzdyb {
    static final zzdyb zzbon = new zzcnj();

    private zzcnj() {
    }

    public final zzdyz zzf(Object obj) {
        TimeoutException timeoutException = (TimeoutException) obj;
        return zzdyr.immediateFailedFuture(new zzcme(zzdok.NETWORK_ERROR));
    }
}
