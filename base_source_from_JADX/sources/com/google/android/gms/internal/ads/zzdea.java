package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzdea implements zzdfi<zzdeb> {
    private final Bundle zzfxi;
    private final zzdzc zzggb;

    public zzdea(zzdzc zzdzc, Bundle bundle) {
        this.zzggb = zzdzc;
        this.zzfxi = bundle;
    }

    public final zzdyz<zzdeb> zzasm() {
        return this.zzggb.zze(new zzded(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdeb zzasy() {
        return new zzdeb(this.zzfxi);
    }
}
