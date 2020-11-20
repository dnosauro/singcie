package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzdbr implements zzdfj<Bundle> {
    private final double zzdww;
    private final boolean zzdwx;

    public zzdbr(double d, boolean z) {
        this.zzdww = d;
        this.zzdwx = z;
    }

    public final /* synthetic */ void zzs(Object obj) {
        Bundle bundle = (Bundle) obj;
        Bundle zza = zzdnx.zza(bundle, "device");
        bundle.putBundle("device", zza);
        Bundle zza2 = zzdnx.zza(zza, "battery");
        zza.putBundle("battery", zza2);
        zza2.putBoolean("is_charging", this.zzdwx);
        zza2.putDouble("battery_level", this.zzdww);
    }
}
