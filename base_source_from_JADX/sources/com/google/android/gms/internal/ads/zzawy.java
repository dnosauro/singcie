package com.google.android.gms.internal.ads;

import android.os.Bundle;

final /* synthetic */ class zzawy implements zzaxn {
    private final String zzdih;
    private final Bundle zzdzz;

    zzawy(String str, Bundle bundle) {
        this.zzdih = str;
        this.zzdzz = bundle;
    }

    public final void zza(zzbgf zzbgf) {
        zzbgf.logEvent("am", this.zzdih, this.zzdzz);
    }
}
