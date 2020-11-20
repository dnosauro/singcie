package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;

final class zzrp implements ValueCallback<String> {
    private final /* synthetic */ zzrm zzbtp;

    zzrp(zzrm zzrm) {
        this.zzbtp = zzrm;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        this.zzbtp.zzbtl.zza(this.zzbtp.zzbti, this.zzbtp.zzbtj, (String) obj, this.zzbtp.zzbtk);
    }
}
