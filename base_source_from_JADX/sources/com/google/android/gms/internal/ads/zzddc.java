package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzddc implements zzdfj<Bundle> {
    private final Bundle zzdtq;

    public zzddc(Bundle bundle) {
        this.zzdtq = bundle;
    }

    public final /* synthetic */ void zzs(Object obj) {
        Bundle bundle = (Bundle) obj;
        Bundle zza = zzdnx.zza(bundle, "device");
        zza.putBundle("android_mem_info", this.zzdtq);
        bundle.putBundle("device", zza);
    }
}
