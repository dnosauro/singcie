package com.google.android.gms.internal.ads;

import java.util.concurrent.TimeoutException;

final /* synthetic */ class zzcng implements zzdyb {
    static final zzdyb zzbon = new zzcng();

    private zzcng() {
    }

    public final zzdyz zzf(Object obj) {
        TimeoutException timeoutException = (TimeoutException) obj;
        return zzdyr.immediateFailedFuture(new zzcme(zzdok.NETWORK_ERROR, "Timed out waiting for ad response."));
    }
}
