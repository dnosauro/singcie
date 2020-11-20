package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;

public final class zzdft implements zzdfj<Bundle> {
    private final String zzdwg;
    private final int zzdwr;
    private final int zzdws;
    private final int zzdwt;
    private final boolean zzdwy;
    private final int zzdwz;

    public zzdft(String str, int i, int i2, int i3, boolean z, int i4) {
        this.zzdwg = str;
        this.zzdwr = i;
        this.zzdws = i2;
        this.zzdwt = i3;
        this.zzdwy = z;
        this.zzdwz = i4;
    }

    public final /* synthetic */ void zzs(Object obj) {
        Bundle bundle = (Bundle) obj;
        String str = this.zzdwg;
        boolean z = true;
        zzdnx.zza(bundle, "carrier", str, !TextUtils.isEmpty(str));
        Integer valueOf = Integer.valueOf(this.zzdwr);
        if (this.zzdwr == -2) {
            z = false;
        }
        zzdnx.zza(bundle, "cnt", valueOf, z);
        bundle.putInt("gnt", this.zzdws);
        bundle.putInt("pt", this.zzdwt);
        Bundle zza = zzdnx.zza(bundle, "device");
        bundle.putBundle("device", zza);
        Bundle zza2 = zzdnx.zza(zza, "network");
        zza.putBundle("network", zza2);
        zza2.putInt("active_network_state", this.zzdwz);
        zza2.putBoolean("active_network_metered", this.zzdwy);
    }
}
